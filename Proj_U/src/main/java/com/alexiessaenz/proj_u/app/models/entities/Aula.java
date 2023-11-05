package com.alexiessaenz.proj_u.app.models.entities;

import com.alexiessaenz.proj_u.app.models.entities.enums.Pizarron;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "aulas")
public class Aula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_aula")
    private Integer nroAula;
    @Column(name = "medidas_m2")
    private String medidas;
    @Column(name = "cantidad_pupitres")
    private Integer cantidadPupitres;
    @Enumerated(EnumType.STRING)
    private Pizarron pizarron;
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @ManyToOne(optional = true,
    cascade={
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "pavellon_id", foreignKey = @ForeignKey(name = "FK_PAVELLON_ID"))
    private Pavellon pavellon;

    public Aula(Integer id, Integer nroAula, String medidas, int cantidadPupitres, Pizarron pizarron) {
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
