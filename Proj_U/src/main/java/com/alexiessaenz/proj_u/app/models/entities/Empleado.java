package com.alexiessaenz.proj_u.app.models.entities;

import com.alexiessaenz.proj_u.app.models.entities.enums.TipoEmpleado;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class Empleado extends Persona{
    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;
}
