package com.alexiessaenz.proj_u.app.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, length = 60)
    private String nombre;
    @Column(nullable = true, length = 60)
    private String apellido;

    @Column(nullable = true, length = 60,unique = true)
    private String dni;

    @Column(name = "fecha_alta", length = 60)
    private LocalDate fechaAlta;
    @Column(name = "fecha_modificacion",nullable = true, length = 60)
    private LocalDate fechaModificacion;

    @Embedded
    @AttributeOverrides({
                    @AttributeOverride(name="codigo_postal", column = @Column(name = "codigo_postal")),
                    @AttributeOverride(name="depto", column = @Column(name = "departamento")),
            })
    private Direccion direccion;
}
