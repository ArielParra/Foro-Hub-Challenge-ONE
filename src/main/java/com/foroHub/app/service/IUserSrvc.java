package com.foroHub.app.service;

import com.foroHub.app.record.User;
import com.foroHub.app.record.UserRes;

public interface IUserSrvc {
	public User obtenerPorCorreo(String correo);
	public UserRes registrar(User user);
}
