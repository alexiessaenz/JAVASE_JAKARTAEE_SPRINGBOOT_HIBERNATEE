package com.alexiessaenz.proj_u.app.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "cant_materias")
    private Integer cantMaterias;
    @Column(name = "cant_anios")
    private Integer cantAnios;
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    private Set<Alumno> alumnos;

    @ManyToMany(
            mappedBy = "carreras",
            fetch = FetchType.LAZY
    )
    private Set<Profesor> profesores;

    @PrePersist
    void prePersist() {
        this.fechaAlta = LocalDate.now();
    }
    @PreUpdate
    void preUpdate() {
        this.fechaModificacion = LocalDate.now();
    }
}
