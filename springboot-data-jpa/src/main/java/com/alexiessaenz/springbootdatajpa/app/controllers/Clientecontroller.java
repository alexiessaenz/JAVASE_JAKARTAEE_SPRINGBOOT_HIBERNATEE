package com.alexiessaenz.springbootdatajpa.app.controllers;

import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import com.alexiessaenz.springbootdatajpa.app.models.daos.IClienteDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class Clientecontroller {
    @Autowired
    private IClienteDao clienteDao;
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes",clienteDao.findAll());
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

        clienteDao.save(cliente);
        status.setComplete();
        flash.addAttribute("success","Cliente Guardado con exito");
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") long id, Map<String, Object> model, RedirectAttributes f){
        /*if (result.hasErrors()) {
            model.addAttribute("titulo","Formulario de Cliente");
            return "form";
        }*/
        Cliente cliente=null;
        if(id>0) cliente = clienteDao.findOneById(id);
        else {
            f.addAttribute("error","El id del cliente no puede ser cero");
            return "redirect:/listar";
        }

        model.put("cliente",cliente);
        model.put("titulo","Editar cliente");

        return "form";
    }
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable(value = "id") Long id, RedirectAttributes f/*, Map<String, Object> model*/){
        if(id>0) clienteDao.remove(id);
        f.addAttribute("success","Cliente eliminado con exito")
        return "redirect:/listar";
    }
}
