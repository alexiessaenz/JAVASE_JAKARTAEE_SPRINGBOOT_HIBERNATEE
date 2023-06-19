package org.jpahibernateexam;

import org.jpahibernateexam.entities.Empleado;
import org.jpahibernateexam.services.EmpleadoServiceImpl;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws Exception {
        Empleado empleado = new Empleado();
        List<Empleado> empleados;
        long id;
        Scanner s = new Scanner(System.in);
        String str;
        EmpleadoServiceImpl emp = new EmpleadoServiceImpl();


        //System.out.println("\n\n========= listar =========");
        empleados = emp.listar();
        System.out.println("\n\n========= listar =========");
        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados");
        } else {
            empleados.forEach(System.out::println);
        }


        System.out.println("\n\n========= por id =========");
        System.out.println("ingrese el id del empleado a buscar: ");
        id = s.nextLong();
        empleado = emp.porId(id);
        if (empleado!=null){
            System.out.println("Empleado encontrado: ");
            System.out.println(empleado);
        } else {
            System.out.println("Error: Empleado no encontrado");
        }


        System.out.println("\n\n========= editar =========");
        try {
            System.out.println("ingrese el id del empleado a buscar: ");
            id = s.nextLong();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        empleado = emp.porId(id);
        if(empleado != null) {
            s.nextLine();
            System.out.println("ingrese el apellido del empleado: ");
            empleado.setApellido(s.nextLine());
            System.out.println("ingrese el oficio del empleado: ");
            empleado.setOficio(s.nextLine());
            System.out.println("ingrese el salario del empleado: ");
            empleado.setSalario(s.nextFloat());
            System.out.println("ingrese la comision del empleado: ");
            empleado.setComision(s.nextFloat());
            emp.editar(empleado);
            empleado = emp.porId(id);
            System.out.println("Empleado editado: ");
            System.out.println(empleado);
        } else {
            System.out.println("Error: Empleado no encontrado");
        }


        System.out.println("\n\n========= eliminar =========");
        System.out.println("ingrese el id del empleado a eliminar: ");
        id = s.nextLong();
        empleado = emp.porId(id);
        if (empleado != null)
            emp.eliminar(id);
        else
            System.out.println("Error: Empleado no encontrado");


        System.out.println("\n\n========= crear =========");
        System.out.println("ingrese el numero del empleado: ");
        empleado.setEmpNo(s.nextLong());
        s.nextLine();
        System.out.println("ingrese el apellido del empleado: ");
        empleado.setApellido(s.nextLine());
        System.out.println("ingrese el oficio del empleado: ");
        empleado.setOficio(s.nextLine());
        System.out.println("ingrese el dir del empleado: ");
        empleado.setDir(s.nextInt());
        System.out.println("ingrese la fecha del empleado ");
        s.nextLine();
        System.out.println("en formato 2020-01-08: ");
        str = s.nextLine();
        empleado.setFechaAlt(LocalDate.parse(str));
        System.out.println("ingrese el salario del empleado: ");
        empleado.setSalario(s.nextFloat());
        System.out.println("ingrese la comision del empleado: ");
        empleado.setComision(s.nextFloat());
        System.out.println("ingrese el num departamento del empleado: ");
        empleado.setDept_no(s.nextInt());
        emp.editar(empleado);
    }

}