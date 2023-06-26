package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Long total;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
}

/*
* <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.26</version>
        </dependency>*/