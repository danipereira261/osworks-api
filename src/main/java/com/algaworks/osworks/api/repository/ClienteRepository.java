package com.algaworks.osworks.api.repository;

import com.algaworks.osworks.api.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
