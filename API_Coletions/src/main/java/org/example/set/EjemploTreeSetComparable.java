package org.example.set;

import org.example.modelo.Alumno;

import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        //Set<Alumno> sa = new TreeSet<>((a,b)->b.getNota().compareTo(a.getNota()));
        Set<Alumno> sa = new TreeSet<>(comparing(Alumno::getNota).reversed());
        sa.add(new Alumno("Pato",6));
        sa.add(new Alumno("Elver",6));
        sa.add(new Alumno("Gasso",2));
        sa.add(new Alumno("Gasso",8));
        System.out.println(sa);
    }


}
