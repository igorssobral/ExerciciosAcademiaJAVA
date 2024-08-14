package com.accenture.pessoa.controller;

import com.accenture.pessoa.dto.AuthenticationDTO;
import com.accenture.pessoa.dto.UserRegistrationDTO;
import com.accenture.pessoa.repository.UserRepository;
import com.accenture.pessoa.service.LoginService;
import com.accenture.pessoa.service.TokenService;
import com.accenture.pessoa.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dto){
        try {
            return ResponseEntity.ok(loginService.login(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/userRegistration")
    public ResponseEntity userRegistration(@RequestBody UserRegistrationDTO dto) {
        try {
            userRegistrationService.registerUser(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

}