package org.example.list;

import org.example.modelo.Alumno;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.comparing;

public class EjemploListComparableComparator {
    public static void main(String[] args) {
        List<Alumno> sa = new LinkedList<>();

        sa.add(new Alumno("Pato",5));
        sa.add(new Alumno("Pato",5));
        sa.add(new Alumno("Pato",5));
        sa.add(new Alumno("Pato",5));

//        Collections.sort(sa,(a,b)-> b.getNota().compareTo(a.getNota()));
        sa.sort(comparing(Alumno::getNombre).reversed());
        System.out.println(sa);

        System.out.println("Utilizando sTream forEach");
        sa.forEach(System.out::println);
    }
}
