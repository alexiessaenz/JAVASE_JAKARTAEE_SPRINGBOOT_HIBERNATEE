package org.example.list;

import org.example.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {
        LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada + ",size = "+ enlazada.size());
        System.out.println("esta vacia = "+ enlazada.isEmpty());

        enlazada.add(new Alumno("Pato", 5));
        enlazada.add(new Alumno("Pato", 5));
        enlazada.add(new Alumno("Pato", 5));
        enlazada.add(new Alumno("Pato", 5));

        System.out.println(enlazada + ",size = "+ enlazada.size());
        enlazada.addFirst(new Alumno("Zeus", 7));
        enlazada.addLast(new Alumno("Atenea", 9));

        System.out.println(enlazada + ",size = "+ enlazada.size());

        System.out.println("Primero = "+enlazada.getFirst());
        System.out.println("Ultimo = "+enlazada.getLast());
        System.out.println("Indice 2 = "+enlazada.get(2));

        //Alumno zeus = enlazada.pop();
        //enlazada.pollLast();
        enlazada.removeFirst();
        enlazada.removeLast();

        System.out.println(enlazada + ",size = "+ enlazada.size());

        enlazada.remove(new Alumno("Jano", 7));
        System.out.println(enlazada + ",size = "+ enlazada.size());

        Alumno a = new Alumno("Luca", 7);
        enlazada.addLast(a);
        System.out.println("Indice de Lucas: " +enlazada.indexOf(a));

        enlazada.remove(2);
        System.out.println(enlazada + ",size = "+ enlazada.size());
        System.out.println("Indice de Lucas: " +enlazada.indexOf(a));

        enlazada.set(3, new Alumno("Lalo",7));
        System.out.println(enlazada + ",size = "+ enlazada.size());

        ListIterator<Alumno> li = enlazada.listIterator();

        while (li.hasNext()) {
            Alumno alumno = li.next();
            System.out.println(alumno);
        }
        System.out.println("============ Previus");
        while (li.hasPrevious()){
            Alumno alumno = li.previous();
            System.out.println(alumno);
        }


    }
}
