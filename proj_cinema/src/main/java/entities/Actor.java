package entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodActor")
    Long codActor;
    @Column(name = "Nombre")
    String nombre;
    @Column(name = "FNacimiento")
    LocalDateTime fNAcimiento;
    @Column(name = "LNacimiento")
    String lNacimiento;
    @Column(name = "Nacionalidad")
    String nacionalidad;
    @Column(name = "FMuerte")
    LocalDateTime fMuerte;
    @Column(name = "LMuerte")
    String lMuerte;

//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "a")
//    private List<GanaPremio> ganaPremios = new ArrayList<>();
    public Actor() {
    }
}
