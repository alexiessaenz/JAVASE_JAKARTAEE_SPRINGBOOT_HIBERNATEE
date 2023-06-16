package org.jpahibernateexam.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(name="emp_no")
    private Long empNo;

    private String apellido;
    private String oficio;
    private int dir;
    @Column(name="fecha_alt")
    private LocalDate fechaAlt;
    private Float salario;
    private Float comision;
    private int dept_no;

    public Empleado() {
    }

    public Empleado(Long empNo, String apellido, String oficio, int dir, LocalDate fechaAlt, float salario, float comision, int dept_no) {
        this.empNo = empNo;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fechaAlt = fechaAlt;
        this.salario = salario;
        this.comision = comision;
        this.dept_no = dept_no;
    }

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(LocalDate fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "empNo=" + empNo +
                ", apellido='" + apellido + '\'' +
                ", oficio='" + oficio + '\'' +
                ", dir=" + dir +
                ", fechaAlt=" + fechaAlt +
                ", salario=" + salario +
                ", comision=" + comision +
                ", dept_no=" + dept_no +
                '}';
    }
}

