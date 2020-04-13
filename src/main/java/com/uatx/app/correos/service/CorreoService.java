package com.uatx.app.correos.service;

import java.util.List;

import com.uatx.app.correos.model.User;

public interface CorreoService {
	
	void enviarConGMail(String destinatario, String asunto, String cuerpo);
	List<User> fyndTarget();
	void mandarCorreos();
	int obtenerDia();

}
