package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
//    @Column(name = "Genero")
//    int genero;
    @Column(name = "Taquilla")
    double taquilla;

    @Column(name = "Productora")
    String productora;
    @Column(name = "Distribuidora")
    String distribuidora;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
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

    @ManyToOne/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name="CodDirector")
    Director director = new Director();

    @ManyToOne/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name="idGenero")
    Genero genero = new Genero();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( cascade = CascadeType.MERGE,orphanRemoval = true,mappedBy = "pelicula")
    private List<GanaPremio> ganaPremios = new ArrayList<>();

    public void setGanaPremios(List<GanaPremio> ganaPremios) {
        this.ganaPremios = ganaPremios;
    }
}