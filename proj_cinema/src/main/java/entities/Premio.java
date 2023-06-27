package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPremio")
    Long codPremio;
    String premio;

    public Premio() {
    }

    public Long getCodPremio() {
        return codPremio;
    }

    public void setCodPremio(Long codPremio) {
        this.codPremio = codPremio;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Premio{" +
                "codPremio=" + codPremio +
                ", premio='" + premio + '\'' +
                '}';
    }
}
