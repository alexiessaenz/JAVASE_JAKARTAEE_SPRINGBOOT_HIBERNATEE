package com.alexiessaenz.springbootdatajpa.app.controllers;

import com.alexiessaenz.springbootdatajpa.app.models.daos.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
