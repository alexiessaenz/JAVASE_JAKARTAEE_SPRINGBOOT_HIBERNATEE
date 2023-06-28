package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodDirector")
    private Integer codDirector;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "FNacimiento")
    LocalDateTime fNacimiento;
    @Column(name = "LNacimiento")
    String lNacimiento;
    @Column(name = "Nacionalidad")
    String nacionalidad;
    @Column(name = "FMuerte")
    LocalDateTime fMuerte;


//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pelicula")
//    private List<Pelicula> pelicula;


    public Director() {

    }

    public Integer getCodDirector() {
        return codDirector;
    }

    public void setCodDirector(Integer codDirector) {
        this.codDirector = codDirector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public LocalDateTime getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDateTime fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getlNacimiento() {
        return lNacimiento;
    }

    public void setlNacimiento(String lNacimiento) {
        this.lNacimiento = lNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDateTime getfMuerte() {
        return fMuerte;
    }

    public void setfMuerte(LocalDateTime fMuerte) {
        this.fMuerte = fMuerte;
    }

    @Override
    public String toString() {
        return "{" +
                "codDirector=" + codDirector +
                ", Nombre='" + nombre + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", lNacimiento='" + lNacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fMuerte=" + fMuerte +
                '}';
    }
}
