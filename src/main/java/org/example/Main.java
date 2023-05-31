package org.example;

import org.example.modelo.Cliente;
import org.example.repositorio.ClienteListRepositorio;
import org.example.repositorio.Direccion;
import org.example.repositorio.OrdenablePaginableCrudRepositorio;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();

        repo.crear(new Cliente("Moises","Saenz"));
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        List<Cliente> paginable = repo.listar(3, 4);
        paginable.forEach(System.out::println);


        List<Cliente> clientesordasc = repo.listar("apellido", Direccion.ASC);
        clientesordasc.forEach(System.out::println);

        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);

        repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("Total registros: " + repo.total());
    }
}