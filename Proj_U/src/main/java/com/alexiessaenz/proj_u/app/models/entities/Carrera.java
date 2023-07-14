package com.alexiessaenz.proj_u.app.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(name = "cant_materias")
    private Integer cantMaterias;
    @Column(name = "cant_anios")
    private Integer cantAnios;
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @PrePersist
    void prePersist() {
        this.fechaAlta = LocalDate.now();
    }
    @PreUpdate
    void preUpdate() {
        this.fechaModificacion = LocalDate.now();
    }
}
