package org.example.entities

import jakarta.persistence.*
import lombok.*

//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Builder
@Entity
@Table(name="facturas")
data class Factura (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0,
    var descripcion:String ="",
    var total:Long = 0,
    @ManyToOne
    @JoinColumn(name="id_cliente")
    var cliente:Cliente= Cliente()
)