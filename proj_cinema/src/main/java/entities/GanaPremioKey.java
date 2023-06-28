package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GanaPremioKey {
    @Column(name = "CodPelicula")
    Long codPelicula;

    @Column(name = "CodPremio")
    Long codPremio;

    public GanaPremioKey() {
    }

    public Long getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(Long codPelicula) {
        this.codPelicula = codPelicula;
    }

    public Long getCodPremio() {
        return codPremio;
    }

    public void setCodPremio(Long codPremio) {
        this.codPremio = codPremio;
    }

    @Override
    public String toString() {
        return "GanaPremioKey{" +
                "codPelicula=" + codPelicula +
                ", codPremio=" + codPremio +
                '}';
    }
}
