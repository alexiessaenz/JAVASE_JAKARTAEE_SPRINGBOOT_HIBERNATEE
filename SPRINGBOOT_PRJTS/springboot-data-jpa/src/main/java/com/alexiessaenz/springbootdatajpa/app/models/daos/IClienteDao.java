package com.alexiessaenz.springbootdatajpa.app.models.daos;
import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {


}
