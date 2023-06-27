package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @Column(name = "CodDirector")
    long codDirector;
}
