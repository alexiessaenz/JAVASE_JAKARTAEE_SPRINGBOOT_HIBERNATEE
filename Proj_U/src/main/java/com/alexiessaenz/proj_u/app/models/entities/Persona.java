package com.alexiessaenz.proj_u.app.models.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public abstract class Persona implements Serializable {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;
    private LocalDate fechaModificacion;
    private Direccion direccion;
}
