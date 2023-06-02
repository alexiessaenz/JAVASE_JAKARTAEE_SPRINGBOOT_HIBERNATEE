package org.example.set;

import org.example.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Set<String> ts = new TreeSet<>((a,b) -> b.compareTo(a));
        ts.add("zUno");
        ts.add("Uno");
        ts.add("Dos");
        ts.add("Tres");
        ts.add("Tres");
        ts.add("Cuatro");
        ts.add("Cinco");

        System.out.println("ts = " + ts);

        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());
        numeros.add(1);
        numeros.add(3);
        numeros.add(5);
        numeros.add(2);
        numeros.add(6);

        System.out.println("numeros = " + numeros);

    }
}
