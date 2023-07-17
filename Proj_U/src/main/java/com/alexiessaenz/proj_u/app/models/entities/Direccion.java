package com.alexiessaenz.proj_u.app.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Data
@RequiredArgsConstructor
@Embeddable
public class Direccion implements Serializable {
    private String calle;
    private String numero;
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Column(name = "departamento")
    private String depto;
    private String piso;
    private String localidad;
}
