package com.acc.corridaJPA.repository;

import com.acc.corridaJPA.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalRepository extends JpaRepository<Local, Long>
{
}

