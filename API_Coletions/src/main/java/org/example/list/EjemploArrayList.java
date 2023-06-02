package org.example.list;

import org.example.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EjemploArrayList {
    public static void main(String[] args) {
        List<Alumno> al = new ArrayList<>();
        System.out.println(al + ", size = "+ al.size());
        System.out.println("esta vaacia = "+ al.isEmpty());
        al.add(new Alumno("Pato", 5));
        al.add(new Alumno("Pato", 5));
        al.add(new Alumno("Pato", 5));

        al.add(2,new Alumno("Pato", 5));
        al.set(2,new Alumno("Pato", 5));

        System.out.println(al +", size "+ al.size());
        al.remove(new Alumno("Jano", 7));
        //al.remove(0);

        System.out.println(al +", size "+ al.size());

        boolean b = al.contains(new Alumno("Pato", 5));
        System.out.println("La lista contiene a Pato "+b);

        Object a[] = al.toArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println("Desde el arreglo = " + a[i]);
        }
    }
}
