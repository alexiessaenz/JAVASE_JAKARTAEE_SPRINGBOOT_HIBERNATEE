package repositories;


import java.util.List;

public interface CrudRepository<T> {
    List<T> listar();
    T porId(Long id);
    void editar(T t) throws Exception;
    void crear(T t) throws Exception;
    void eliminar(long id) throws Exception;
}
