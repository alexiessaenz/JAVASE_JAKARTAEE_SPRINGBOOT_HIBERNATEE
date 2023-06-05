package org.alexiessaenz;

import org.alexiessaenz.model.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        Consumer<Date> cinsumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM.dd");
            System.out.println(f.format(fecha));
        };
        cinsumidor.accept(new Date());
        BiConsumer<String, Integer> consumerBi = (nobre, edad) -> {
            System.out.println(nobre + " tiene "+edad);
        };

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola Mundo");

        consumerBi.accept("Pedro", 22);
        List<String> nombres = Arrays.asList("jose","maria", "jose","frank");
        nombres.forEach(consumidor2);

        Usuario usuario = new Usuario();
//        BiConsumer<Usuario,String> asignarNombre = (persona, nombre) -> {
//            persona.setNombre(nombre);
//        };

        BiConsumer<Usuario,String> asignarNombre = Usuario::setNombre;

        asignarNombre.accept(usuario,"Mauricio");
        System.out.println("Nombre de usuario = " + usuario.getNombre());

        Supplier<String> proveedor = () -> {
            return "Otro Hola Mundo!";
        };
        System.out.println(proveedor.get());
    }
}
