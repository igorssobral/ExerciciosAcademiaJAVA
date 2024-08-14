package com.accenture.pessoa.repository;

import com.accenture.pessoa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByLogin(String login);
     boolean existsByLogin(String login);

}
