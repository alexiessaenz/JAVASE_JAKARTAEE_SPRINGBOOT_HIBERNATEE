package com.alexiessaenz.proj_u.app.models.entities;

import com.alexiessaenz.proj_u.app.models.entities.enums.TipoEmpleado;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona{
    private BigDecimal sueldo;
    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmpleado;

    @OneToOne(optional = false,
            cascade = CascadeType.ALL)
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABELLON_ID")
    )
    private Pavellon pavellon;
}
