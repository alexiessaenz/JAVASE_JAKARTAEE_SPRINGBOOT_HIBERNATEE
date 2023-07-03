package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPremio")
    Long codPremio;
    String premio;

//    @ManyToOne
//    @JoinColumn(name="Anyo")
//    Pelicula pelicula = new Pelicula();
//
//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "pelicula")
//    private List<Pelicula> peliculas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "premio")
    private List<GanaPremio> ganaPremios = new ArrayList<>();

}
