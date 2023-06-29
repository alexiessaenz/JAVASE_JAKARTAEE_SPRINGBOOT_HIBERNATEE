package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPelicula")
    Long codPelicula;
    @Column(name = "Titulo")
    String titulo;
    @Column(name = "Anyo")
    String anyo;
    @Column(name = "Nacionalidad")
    String nacionalidad;
    @Column(name = "Duracion")
    Float duracion;
    @Column(name = "FechaEstreno")
    LocalDateTime fechaEstreno;
    @Column(name = "Genero")
    int genero;
    @Column(name = "Taquilla")
    double taquilla;

    @Column(name = "Productora")
    String productora;
    @Column(name = "Distribuidora")
    String distribuidora;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="participa"
            ,joinColumns = @JoinColumn(name = "CodPelicula")
            ,inverseJoinColumns = @JoinColumn(name = "CodActor")
            ,uniqueConstraints = @UniqueConstraint(
            columnNames = {"CodActor"}
    ))
    private List<Actor> actores = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(
//            name="ganaPremio",
//            joinColumns = {@JoinColumn(name = "CodPelicula")},
//            inverseJoinColumns = @JoinColumn(name = "CodPremio"),
//            uniqueConstraints = @UniqueConstraint(
//            columnNames = {"CodPremio"}
//    ))
//    private List<Premio> premios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="CodDirector")
    Director director = new Director();


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "premio")
    private List<Premio> premios = new ArrayList<>();


}