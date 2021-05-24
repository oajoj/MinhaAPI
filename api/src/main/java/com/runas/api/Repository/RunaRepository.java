package com.runas.api.Repository;

import java.util.Optional;

import com.runas.api.Entity.RunaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RunaRepository extends JpaRepository<RunaModel, Long>{

    Optional<RunaModel> findByNomeContaining(String nomeRuna);
    
}
