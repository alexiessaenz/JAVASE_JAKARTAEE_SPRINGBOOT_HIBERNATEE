package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
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


}
