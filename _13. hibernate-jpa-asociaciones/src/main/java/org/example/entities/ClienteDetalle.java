package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "clientes_detalles")
public class ClienteDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean prime;
    @Column(name="puntos_acumulados")
    private long puntosAcumulados;
    @OneToOne
    @JoinColumn(name="cliente_detalle_id")
    private Cliente cliente;
}
