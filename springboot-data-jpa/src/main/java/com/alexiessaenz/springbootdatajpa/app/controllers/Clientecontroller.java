package com.alexiessaenz.springbootdatajpa.app.controllers;

import com.alexiessaenz.springbootdatajpa.app.entities.Cliente;
import com.alexiessaenz.springbootdatajpa.app.models.daos.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
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
    public String guardar(Cliente cliente){
        clienteDao.save(cliente);
        return "redirect:listar";
    }
}
