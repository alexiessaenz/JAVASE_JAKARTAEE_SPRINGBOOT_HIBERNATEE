package services;

import entities.Actor;
import repositories.ActorRepository;
//import repositories.CrudRepositoryImpl;

import java.util.List;

//public class ServiceImpl<T> implements IService<T> {
//ActorRepository Repository = new ActorRepository();
//    private T t;
//
//    public ServiceImpl() {
//    }
//
//    public ServiceImpl(T t) {
//        this.t = t;
//    }
//
//    @Override
//    public List<T> listar() throws Exception{
//        try {
//            return (List<T>) Repository.listar();
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    public T porId(Long id) throws Exception{
//        try {
//            return (T) Repository.porId(id);
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    public void crear(T t) throws Exception{
//        Repository.crear((Actor) t);
//    }
//
//    @Override
//    public void eliminar(long id) throws Exception{
//            t = (T) Repository.porId(id);
//            if (t == null) throw new Exception("No existe el empleado con el id " + id);
//            Repository.eliminar(id);
//    }
//
//    @Override
//    public void editar(T t) throws Exception{
//        Repository.crear((Actor) t);
//            Repository.editar((Actor) ServiceImplt);
//    }
//}
