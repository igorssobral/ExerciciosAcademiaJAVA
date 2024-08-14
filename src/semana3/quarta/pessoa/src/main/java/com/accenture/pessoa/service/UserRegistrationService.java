package com.accenture.pessoa.service;

import com.accenture.pessoa.dto.UserRegistrationDTO;
import com.accenture.pessoa.model.User;
import com.accenture.pessoa.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;

    @Autowired
    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerUser(UserRegistrationDTO dto) throws Exception {
        if (userRepository.existsByLogin(dto.login())) {
            throw new EntityExistsException("Já existe um usuário com esse login");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());

        User newUser = new User(dto.name(), dto.login(), encryptedPassword);

        return userRepository.save(newUser);
    }
}
