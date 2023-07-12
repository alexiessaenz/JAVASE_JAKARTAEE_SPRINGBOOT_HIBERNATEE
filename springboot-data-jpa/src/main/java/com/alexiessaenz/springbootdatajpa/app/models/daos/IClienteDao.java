package com.alexiessaenz.springbootdatajpa.app.models.daos;

import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
