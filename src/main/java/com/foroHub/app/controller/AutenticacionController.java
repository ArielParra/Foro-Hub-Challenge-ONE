package com.foroHub.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foroHub.app.domain.UserEntity;
import com.foroHub.app.record.UserAuth;
import com.foroHub.app.record.JWTToken;
import com.foroHub.app.service.impl.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UserAuth userAuth) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuth.login(),
                userAuth.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((UserEntity) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTToken(JWTtoken));
    }

}

