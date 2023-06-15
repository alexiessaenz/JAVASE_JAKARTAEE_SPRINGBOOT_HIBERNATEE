package org.tbsJunit.jpaHib;

import jakarta.persistence.EntityManager;
import org.tbsJunit.jpaHib.entity.Cliente;
import org.tbsJunit.jpaHib.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
            Cliente c = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:", c.getApellido());
            String pago  = JOptionPane.showInputDialog("Ingrese la forma de pago:", c.getFormapago());
            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormapago(pago);
            em.merge(c);
            em.getTransaction().commit();
            System.out.println(c);
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}