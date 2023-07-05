package com.alexiessaenz.springbootdatajpa.app.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private static  final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createAt;
}
