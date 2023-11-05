package com.alexiessaenz.proj_u.app.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
@RequiredArgsConstructor
public class Alumno extends Persona{
    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    ) @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public Alumno(Long id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }
}
