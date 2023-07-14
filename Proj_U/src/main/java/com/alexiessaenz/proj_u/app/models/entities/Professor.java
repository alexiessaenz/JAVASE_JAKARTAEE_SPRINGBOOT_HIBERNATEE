package com.alexiessaenz.proj_u.app.models.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@Data
@RequiredArgsConstructor
public class Professor extends Persona{
    private BigDecimal sueldo;
}
