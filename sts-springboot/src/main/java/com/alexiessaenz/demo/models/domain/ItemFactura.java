package com.alexiessaenz.demo.models.domain;

import lombok.Data;

@Data
public class ItemFactura {
    private Producto producto;
    private Integer cantidad;


public Integer calcularImporte(){
    return cantidad*producto.getPrecio();
}
}
