package com.alexiessaenz.proj_u.app.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona{
    private BigDecimal sueldo;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "professor_carrera",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")

    )
    private Set<Carrera> carreras;
}
