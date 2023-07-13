package com.alexiessaenz.springbootdatajpa.app.controllers;

import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import com.alexiessaenz.springbootdatajpa.app.models.service.IClienteService;
import com.alexiessaenz.springbootdatajpa.app.util.paginator.PageRender;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@Controller
@SessionAttributes("cliente")
public class ClienteControler {
    @Autowired
    private IClienteService clienteService;
    private final static String UPLOADS_FOLDER = "uploads";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/uploads/{filename:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String filename)  {
        Path pathFoto = Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
        log.info("pathFoto: "+ pathFoto);
        Resource recurso = null;
        try{
            recurso = new UrlResource(pathFoto.toUri());
            if (!recurso.exists() && !recurso.isReadable()){
                throw new RuntimeException("Error: no se puede cargar la imagen: "+ pathFoto.toString());
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                + recurso.getFilename()).body(recurso);
    }
    @GetMapping(value = "/ver/{id}")
    public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model,
                      RedirectAttributes flash){
        Cliente cliente = clienteService.findOne(id);
        if(cliente==null){
            flash.addFlashAttribute("error", "El cliente no existe");
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Detalle Cliente; "+ cliente.getNombre());
        return "ver";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Cliente> clientes = clienteService.findAll(pageRequest);
        PageRender<Cliente> pageRender = new PageRender<Cliente>("/listar", clientes);
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clientes);
        model.addAttribute("page", pageRender);
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {

        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object>
            model, RedirectAttributes flash) {
        Cliente cliente = null;
        if (id > 0) {
            cliente = clienteService.findOne(id);
            if (cliente == null) {
                flash.addFlashAttribute("error",
                        "El ID del cliente no existe en la BBDD!");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error",
                    "El ID del cliente no puede ser cero!");
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Editar Cliente");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model,
                          @RequestParam("file") MultipartFile foto,
                          RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            return "form";
        }


        if(!foto.isEmpty()){


            if(cliente.getId() != null && cliente.getId()>0 && cliente.getFoto()!= null
            && cliente.getFoto().length()>0){
                Path rootPath = Paths.get(UPLOADS_FOLDER).resolve(cliente.getFoto()).toAbsolutePath();
                File archivo = rootPath.toFile();
                if(archivo.exists() && archivo.canRead()){
                        archivo.delete();
                }
            }

            //Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
            //String rootPath = directorioRecursos.toFile().getAbsolutePath();
            //String rootPath = "C://Temp//uploads";
            String uniqueFilename = UUID.randomUUID().toString() + "-" +foto.getOriginalFilename();
            Path rootPath = Paths.get(UPLOADS_FOLDER).resolve(uniqueFilename);
            Path rootAbsolutPAth = rootPath.toAbsolutePath();
            log.info("rootPath: " + rootPath);
            log.info("rootAbsolutPAth: " + rootAbsolutPAth);

            try {
//                byte[] bytes = foto.getBytes();
//                Path rutaCompleta = Paths.get(rootPath +"//" + foto.getOriginalFilename());
//                Files.write(rutaCompleta,bytes);

                Files.copy(foto.getInputStream(), rootAbsolutPAth);
                flash.addAttribute("info", "se ha subido correctamente"
                        +uniqueFilename+"'");
                cliente.setFoto(uniqueFilename);
            } catch (IOException e) {
                //TODO Autogenerated catch block
                e.printStackTrace();
                //throw new RuntimeException(e);
            }
        }
        String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con éxito!"
                : "Cliente creado con éxito!";

        clienteService.save(cliente);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:listar";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            Cliente cliente = clienteService.findOne(id);
            clienteService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
            Path rootPath = Paths.get("uploads").resolve(cliente.getFoto()).toAbsolutePath();
            File archivo = rootPath.toFile();
            if(archivo.exists() && archivo.canRead()){
                if (archivo.delete()){
                    flash.addFlashAttribute("info", "Foto" + cliente.getFoto()
                    +"Se elimino la foto!!");
                }
            }
        }
        return "redirect:/listar";
    }
}
