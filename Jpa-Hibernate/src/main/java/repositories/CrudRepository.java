package repositories;

import org.tbsJunit.jpaHib.entity.Cliente;

import java.util.List;

public interface CrudRepository <T> {
    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(long id);

}
