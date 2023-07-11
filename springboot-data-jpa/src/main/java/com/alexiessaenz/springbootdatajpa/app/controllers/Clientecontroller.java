package com.alexiessaenz.springbootdatajpa.app.controllers;

import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import com.alexiessaenz.springbootdatajpa.app.models.daos.IClienteDao;
import com.alexiessaenz.springbootdatajpa.app.models.service.IClienteService;
import com.alexiessaenz.springbootdatajpa.app.util.paginator.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class Clientecontroller {
    @Autowired
    private IClienteService clienteService;
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String listar(@RequestParam(name="page", defaultValue = "0") int page, Model model){
        Pageable pageRequest= (Pageable) PageRequest.of(page,4);
        Page<Cliente> clientes = clienteService.findAll(pageRequest);
        PageRender<Cliente> pageRender = new PageRender<>("/listar",Cliente.class);
        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes",clienteService.findAll());
        return "listar";
    }
    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String crear(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente",cliente);
        return "form";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()) {
            model.addAttribute("titulo","Formulario de Cliente");
            return "form";
        }

        String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con exito" : "Cliente creado con exito";

        clienteService.save(cliente);
        status.setComplete();
        flash.addAttribute("success",mensajeFlash);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") long id, Map<String, Object> model, RedirectAttributes f){
        /*if (result.hasErrors()) {
            model.addAttribute("titulo","Formulario de Cliente");
            return "form";
        }*/
        Cliente cliente=null;
        if(id>0) cliente = clienteService.findOneById(id);
        else {
            f.addAttribute("error","El id del cliente no puede ser cero");
            return "redirect:/listar";
        }

        model.put("cliente",cliente);
        model.put("titulo","Editar cliente");

        return "form";
    }
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable(value = "id") Long id, RedirectAttributes flash /*, Map<String, Object> model*/){
        if(id>0) {
            clienteService.remove(id);
            flash.addAttribute("success","Cliente eliminado con exito");
        }
        return "redirect:/listar";
    }
}
