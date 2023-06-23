package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name="forma_pago")
    private String formapago;
//    @Column(name="creado_en")
//    private LocalDateTime creadoEn;
//    @Column(name="editado_en")
//    private LocalDateTime editadoEn;
    @Embedded
    private Auditoria audit = new Auditoria();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "id_cliente")
    @JoinTable(name="tbl_clientes_direcciones",joinColumns = @JoinColumn(name = "id_cliente")
    ,inverseJoinColumns = @JoinColumn(name = "id_cliente")
    ,uniqueConstraints = @UniqueConstraint(columnNames = {"id_direccion"}))
    private List<Direccion> direcciones = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "cliente")
    private List<Factura> facturas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "cliente")
    private ClienteDetalle clienteDetalle;


//    @PrePersist
//    public void prePersist(){
//        System.out.println("inicializa antes del persist");
//        this.creadoEn = LocalDateTime.now();
//    }
//    @PreUpdate
//    public void preUpdate(){
//        System.out.println("inicializa  antes del update");
//        this.creadoEn = LocalDateTime.now();
//    }


//    @Override
//    public String toString() {
//        return "Cliente{" +
//                "id=" + id +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", formapago='" + formapago + '\'' +
//                ", creadoEn='" + audit.getCreadoEn() + '\'' +
//                ", editadoEn='" + audit.getEditadoEn() + '\'' +
//                '}';
//    }
    public Cliente addFactura(Factura f){
        this.facturas.add(f);
        f.setCliente(this);
        return this;
    }

    public  void removeFactura(Factura f){
        this.facturas.remove(f);
        f.setCliente(null);
    }

    public void addDetalle(ClienteDetalle cd){
        this.clienteDetalle = cd;
        clienteDetalle.setCliente(this);
    }

    public void removeDetalle(){
        clienteDetalle.setCliente(null)
        this.clienteDetalle=null;
    }
}
