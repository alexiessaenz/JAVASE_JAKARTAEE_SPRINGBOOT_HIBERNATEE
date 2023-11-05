package com.alexiessaenz.demo.models.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Producto {
    private String nombre;
    private int precio;
}
