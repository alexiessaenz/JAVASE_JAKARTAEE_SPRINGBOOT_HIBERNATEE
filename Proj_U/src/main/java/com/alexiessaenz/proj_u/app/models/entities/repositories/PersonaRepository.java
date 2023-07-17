package com.alexiessaenz.proj_u.app.models.entities.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Long> {
}
