package com.foroHub.app.repository;

import com.foroHub.app.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UserEntity, Long>{
    @Query("SELECT u FROM UserEntity u WHERE u.correoEletronico = :correo")
    UserEntity searchEmail(String email);
    UserDetails findByEmail(String username);
}