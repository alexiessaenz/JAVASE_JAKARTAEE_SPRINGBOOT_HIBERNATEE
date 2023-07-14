package com.alexiessaenz.proj_u.app.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Direccion implements Serializable {
    private String calle;
    private String numero;
    private String codigoPostal;
    private String depto;
    private String piso;
    private String localidad;
}
