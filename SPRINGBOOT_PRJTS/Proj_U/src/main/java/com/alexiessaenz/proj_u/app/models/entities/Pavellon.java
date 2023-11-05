package com.alexiessaenz.proj_u.app.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "pavellones")
public class Pavellon {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @Column(name = "metors_cuadrados")
    private Double mts2;
    @Column(name = "nombre_pavellon", unique = true, nullable = false)
    private String nombre;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "dpto", column = @Column(name = "departamento"))
    })
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @OneToMany(mappedBy = "pavellon",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Aula> aulas;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="codigo_postal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name="depto", column = @Column(name = "departamento")),
    })
    private Direccion direccion;

    public Pavellon(Integer id, double mts2, String nombrePavellon, Direccion direccion) {
        this.id = id;
        this.mts2 = mts2;
        this.nombre = nombrePavellon;
        this.direccion = direccion;
    }

    @PrePersist
    void prePersist() {
        this.fechaAlta = LocalDate.now();
    }
    @PreUpdate
    void preUpdate() {
        this.fechaModificacion = LocalDate.now();
    }
}
