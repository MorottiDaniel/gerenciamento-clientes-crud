package com.morotti.clientes.repository;

import com.morotti.clientes.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {
}
