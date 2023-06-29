package org.aguzman.apiservlet.webapp.headers.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.aguzman.apiservlet.webapp.headers.configs.Repository;
import org.aguzman.apiservlet.webapp.headers.models.entities.Producto;

import java.util.List;

@RepositoryJpa
@Repository
public class ProductoRepositoryImpl implements CrudRepository<Producto>{

    @Inject
    private EntityManager em;
    @Override
    public List<Producto> listar() throws Exception {
        return em.createQuery("select p from Producto p left outer join fetch p.categoria",
                Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) throws Exception {
        return null;
    }

    @Override
    public void guardar(Producto producto) throws Exception {

    }

    @Override
    public void eliminar(Long id) throws Exception {

    }
}
