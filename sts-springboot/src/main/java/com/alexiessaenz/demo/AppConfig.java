package com.alexiessaenz.demo;

import com.alexiessaenz.demo.services.IServicio;
import com.alexiessaenz.demo.services.MiServicio;
import com.alexiessaenz.demo.services.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean("MiServicioSimple")
    @Primary
    public IServicio registrarMiServicio(){
        return new MiServicio();
    }
    @Bean("MiServicioComplejo")
    @Primary
    public IServicio registrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("ItemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camaara Sony", 100);
        Producto producto2 = new Producto("Bicicleta Bianchi rim 26", 200);

        ItemFactura linea1 = new ItemFactura(producto1,2);
        ItemFactura linea2 = new ItemFactura(producto2,4);
        return Arrays.asList(linea1,linea2);
    }

    @Bean("ItemsFacturaOficina")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Monitor LG LCD 24", 250);
        Producto producto2 = new Producto("Notebook ASUS", 500);
        Producto producto3 = new Producto("Impresora HP Multifuncional", 250);
        Producto producto4 = new Producto("Escritorio Oficina", 250);

        ItemFactura linea1 = new ItemFactura(producto1,2);
        ItemFactura linea2 = new ItemFactura(producto1,1);
        ItemFactura linea3 = new ItemFactura(producto1,1);
        ItemFactura linea4 = new ItemFactura(producto1,1);
        return Arrays.asList(linea1, linea2, linea3, linea4);
    }

    }
