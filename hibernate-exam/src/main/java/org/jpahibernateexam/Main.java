package org.jpahibernateexam;

import jakarta.persistence.EntityManager;
import org.jpahibernateexam.entities.Empleado;
import org.jpahibernateexam.services.EmpleadoServiceImpl;
import org.jpahibernateexam.services.IEmpleadoService;
import org.jpahibernateexam.utils.JpaUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Empleado> empleados;
        Empleado empleado;
        Scanner s = new Scanner(System.in);
        Long id;
        String str;

        EmpleadoServiceImpl emp = new EmpleadoServiceImpl(em);

        System.out.println("\n\n========= listanr =========");
        empleados = emp.listar();
        empleados.forEach(System.out::println);

        System.out.println("\n\n========= por id =========");
        EntityManager em2 = JpaUtil.getEntityManager();
        EmpleadoServiceImpl emp2 = new EmpleadoServiceImpl(em2);
        System.out.println("ingrese el id del empleado a buscar: ");
        id = s.nextLong();
        System.out.println("elllllllll id: "+ id);
        empleado = emp2.porId(id);
        System.out.println("Empleado encontrado: ");
        System.out.println(empleado);
        if (empleado!=null){
            System.out.println("Empleado encontrado: ");
            System.out.println(empleado);
        } else {
            System.out.println("Error: Empleado no encontrado");
        }

        System.out.println("\n\n========= editar =========");
        System.out.println("ingrese el id del empleado a buscar: ");
        id = s.nextLong();
        empleado = em.find(Empleado.class, id);

        System.out.println("ingrese el nombre del empleado: ");
        empleado.setApellido(s.nextLine());
        System.out.println("ingrese el oficio del empleado: ");
        empleado.setOficio(s.nextLine());
        System.out.println("ingrese el salario del empleado: ");
        empleado.setSalario(s.nextFloat());
        System.out.println("ingrese la comision del empleado: ");
        empleado.setComision(s.nextFloat());
        emp.editar(empleado);


        System.out.println("\n\n========= eliminar =========");

        System.out.println("ingrese el id del empleado a eliminar: ");
        id = s.nextLong();
        emp.eliminar(id);

        System.out.println("\n\n========= crear =========");


        System.out.println("ingrese el numero del empleado: ");
        empleado.setEmpNo(s.nextLong());

        System.out.println("ingrese el apellido del empleado: ");
        empleado.setApellido(s.nextLine());

        System.out.println("ingrese el oficio del empleado: ");
        empleado.setOficio(s.nextLine());

        System.out.println("ingrese el dir del empleado: ");
        empleado.setDir(s.nextInt());

        System.out.println("ingrese la fecha del empleado ");
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