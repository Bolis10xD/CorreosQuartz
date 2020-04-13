package com.uatx.app.correos.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
    
    @Column(name = "nombre", length = 50)
	private String Nombre;
    
    @Column(name = "apellidos", length = 50)
	private String Apellidos;
    
    @Column(name = "email", length = 50)
	private String correo;
    
    @Column(name = "lastday", length = 50)
	private Integer lastDay;
	
    
    public Integer getLastDay() {
		return lastDay;
	}
	public void setLastDay(Integer lastDay) {
		this.lastDay = lastDay;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}

