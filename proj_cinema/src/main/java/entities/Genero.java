package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGenero")
    private long idGenero;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "genero")
    private List<Pelicula> peliculas = new ArrayList<>();

    public Genero() {
    }
}
