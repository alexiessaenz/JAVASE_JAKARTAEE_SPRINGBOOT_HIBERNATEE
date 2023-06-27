package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//@Table(name = "auditorias")
@Embeddable
public class Auditoria {
    @Column(name="creado_en")
    private LocalDateTime creadoEn;
    @Column(name="editado_en")
    private LocalDateTime editadoEn;

    @PrePersist
    public void prePersist(){
        System.out.println("inicializa antes del persist");
        this.creadoEn = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println("inicializa  antes del update");
        this.creadoEn = LocalDateTime.now();
    }

    public Auditoria() {
    }

    public Auditoria(LocalDateTime creadoEn, LocalDateTime editadoEn) {
        this.creadoEn = creadoEn;
        this.editadoEn = editadoEn;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEditadoEn() {
        return editadoEn;
    }

    public void setEditadoEn(LocalDateTime editadoEn) {
        this.editadoEn = editadoEn;
    }

    @Override
    public String toString() {
        return "Auditoria{" +
                "creadoEn=" + creadoEn +
                ", editadoEn=" + editadoEn +
                '}';
    }
}
