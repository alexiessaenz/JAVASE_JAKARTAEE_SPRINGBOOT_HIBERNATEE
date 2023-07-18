package com.alexiessaenz.proj_u.app.services.contracts;

public interface IAlumnoDAO extends IPersonaDAO<P> {

    Iterable<Aula> findAulasByPizarron(Pizarron pizarron);
    Iterable<Aula> findAulasByPavellonNombre(String nombre);
    Optional<Aula> findAulaByNroAula(Integer nroAula);

}
