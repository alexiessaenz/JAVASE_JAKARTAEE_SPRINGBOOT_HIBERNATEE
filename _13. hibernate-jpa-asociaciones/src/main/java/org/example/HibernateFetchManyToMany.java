package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Alumno;
import org.example.entities.Cliente;
import org.example.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Alumno> alumnos= em.createQuery("select distinct a from Alumno a left outer join fetch a.cursos", Alumno.class)
                .setParameter("id",1L).getResultList();
        alumnos.forEach(alumno -> System.out.println(
                alumno.getNombre() + ", cursos" + alumno.getCursos()
        ));
        em.close();
    }
}
