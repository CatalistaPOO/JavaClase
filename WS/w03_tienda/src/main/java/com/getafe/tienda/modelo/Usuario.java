package com.getafe.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "users")
public class Usuario implements Serializable {
	@Id
	@Column(name = "id_user")
	private int idUsuario;
	@Column(name = "username")
	private String usuario;

	
	@Column(name = "name")
	private String nombre;

	private String email;
	private String password;
	private boolean enabled;
	
	public Usuario() {
	};
	
	public Usuario(String nombre,String usuario,  String email, String password) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		
	}
	public int getIdusuario() {
		return idUsuario;
	}
	public void setIdusuario(int idusuario) {
		this.idUsuario = idusuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}
	
}
