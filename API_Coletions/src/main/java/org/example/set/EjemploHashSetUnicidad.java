package org.example.set;

import org.example.modelo.Alumno;
import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> sa = new HashSet<>();

        sa.add(new Alumno("Pato",5));
        sa.add(new Alumno("Pato",5));
        sa.add(new Alumno("Cata",6));
        sa.add(new Alumno("Cata",6));

        System.out.println(sa);

        System.out.println("Iterando utilizando u foreach");

        for (Alumno a : sa ) {
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando utilizando while y iterator");
        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()){
            Alumno a = it.next();
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando utilizando Stream foreach");
        sa.forEach(System.out::println);
    }
}
