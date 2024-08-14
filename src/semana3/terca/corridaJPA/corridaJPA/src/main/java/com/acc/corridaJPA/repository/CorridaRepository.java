package com.acc.corridaJPA.repository;

import java.util.List;

import com.acc.corridaJPA.model.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long>
{
    List<Corrida> findByLocalId(Long localId);

    @Transactional
    void deleteByLocalId(Long localId);
}
