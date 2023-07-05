package com.alexiessaenz.demo.models.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemFactura {
    private Producto producto;
    private Integer cantidad;


public Integer calcularImporte(){
    return cantidad*producto.getPrecio();
}
}
