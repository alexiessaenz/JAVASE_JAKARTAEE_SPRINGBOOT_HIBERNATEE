package org.example.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        System.out.println(hs.add("Uno"));
        System.out.println(hs.add("Uno"));
        System.out.println(hs.add("Uno"));
        System.out.println(hs.add("Uno"));
        System.out.println(hs.add("Uno"));
        System.out.println(hs);

        boolean b = hs.add("tres");
        System.out.println("permite agrewgar elemento duplicados = ");
    }
}
