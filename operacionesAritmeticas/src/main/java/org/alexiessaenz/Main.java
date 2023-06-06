package org.alexiessaenz;

import org.alexiessaenz.data.Aritmetica;
import org.alexiessaenz.data.Calculadora;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Aritmetica suma = Double::sum;
        Aritmetica resta = (a,b) -> a-b;

        Calculadora cal = new Calculadora();
        System.out.println(cal.computar(10,5,suma));
        System.out.println(cal.computar(10,5,resta));
        System.out.println(cal.computar(10,5,(a,b) -> a*b));
        System.out.println(cal.computarconBiFunction(10,5,(a,b) -> a-b));
    }
}