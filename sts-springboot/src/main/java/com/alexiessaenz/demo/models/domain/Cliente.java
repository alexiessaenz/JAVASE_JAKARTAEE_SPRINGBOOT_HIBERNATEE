package com.alexiessaenz.demo.models.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
@Data
@Component
@RequestScope
public class Cliente {
    @Value("Andr&eacute;s")
    private String nombre;
    @Value("Guzm&aacute;n")
    private String apellido;
}
