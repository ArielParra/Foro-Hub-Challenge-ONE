package com.foroHub.app.service.impl;

import com.foroHub.app.domain.UserEntity;
import com.foroHub.app.record.User;
import com.foroHub.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import com.foroHub.app.record.UserRes;
import com.foroHub.app.service.IUserSrvc;

import jakarta.transaction.Transactional;

@Service
public class UserSrvc implements IUserSrvc {

	private UsuarioRepository repository;

	public UserSrvc(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public User obtenerPorCorreo(String correo) {
		UserEntity usuario = repository.searchEmail(correo);
		return new User(usuario.getNombre(), usuario.getCorreoEletronico(), usuario.getContrasena());
	}

	@Transactional
	@Override
	public UserRes registrar(User user) {
		UserEntity usuarioRegistrado = repository.save(new UserEntity(user));
		UserRes usuarioNuevo =  new UserRes(usuarioRegistrado.getNombre(), usuarioRegistrado.getCorreoEletronico(), "User Registrado");
		return usuarioNuevo;
	}

}
