package repositories;


import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {
    List<T> listar();
    T porId(Long id);
    void editar(T t) throws Exception;
    void crear(T t) throws Exception;
    void eliminar(long id) throws Exception;
    void eliminar(T t) throws Exception;
}
