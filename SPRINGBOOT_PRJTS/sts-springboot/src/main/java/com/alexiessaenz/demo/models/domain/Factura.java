package com.alexiessaenz.demo.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;
import java.util.List;

@Data
@Component
@RequestScope
public class Factura implements Serializable {
    private static final long serialVersionUID=946004357128146951L;

    String descripcion;
    Cliente cliente;
    List<ItemFactura> items;

    @PostConstruct
    void inicializar(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat(" ").concat(" "));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }

    @PreDestroy
    void destruir(){
        System.out.println("Factura destruida: ".concat(descripcion));
    }
}
