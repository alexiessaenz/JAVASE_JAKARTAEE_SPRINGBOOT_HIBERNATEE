package services;

import entities.Actor;
import repositories.ActorRepository;

import java.util.List;

public class ActorServiceImpl implements IService<Actor> {
ActorRepository Repository = new ActorRepository();
    Actor actor = new Actor();
    public ActorServiceImpl() {
    }
    @Override
    public List<Actor> listar() throws Exception{
        try {
            return (List<Actor>) Repository.listar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Actor porId(Long id) throws Exception{
        try {
            return Repository.porId(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public void crear(Actor actor) throws Exception{
        Repository.crear(actor);
    }
    @Override
    public void eliminar(long id) throws Exception{
            actor =  Repository.porId(id);
            if (actor == null) throw new Exception("No existe el actor con el id " + id);
            Repository.eliminar(id);
    }
    @Override
    public void editar(Actor actor) throws Exception{
        actor =  Repository.porId(actor.getCodActor());
        if (actor == null)
            Repository.crear(actor);
        Repository.editar(actor);
    }
}
