package com.accenture.pessoa.service;


import com.accenture.pessoa.dto.AuthenticationDTO;
import com.accenture.pessoa.dto.LoginResponseDTO;
import com.accenture.pessoa.model.User;
import com.accenture.pessoa.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @Transactional
    public LoginResponseDTO login(AuthenticationDTO dto) throws Exception {

        User user = (User) userRepository.findByLogin(dto.login());

        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return new LoginResponseDTO(token);
    }
}