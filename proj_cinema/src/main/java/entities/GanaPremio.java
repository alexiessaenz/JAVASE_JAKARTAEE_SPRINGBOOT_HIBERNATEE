package entities;

import jakarta.persistence.*;
@Entity
@Table(name = "ganaPremio")
public class GanaPremio {

    @EmbeddedId
    GanaPremioKey id;

    @ManyToOne
    @MapsId("codPelicula")
    @JoinColumn(name = "CodPelicula")
    Pelicula pelicula;

    @ManyToOne
    @MapsId("codPremio")
    @JoinColumn(name = "CodPremio")
    Premio premio;

    @Column(name = "Anyo")
    String anyo;

    public GanaPremio() {
    }

    public GanaPremioKey getId() {
        return id;
    }

    public void setId(GanaPremioKey id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "GanaPremio{" +
                "id=" + id +
                ", pelicula=" + pelicula +
                ", premio=" + premio +
                ", anyo='" + anyo + '\'' +
                '}';
    }
}
