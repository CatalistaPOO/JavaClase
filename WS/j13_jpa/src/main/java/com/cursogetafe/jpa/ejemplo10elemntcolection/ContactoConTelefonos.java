package com.cursogetafe.jpa.ejemplo10elemntcolection;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacto")
public class ContactoConTelefonos implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcontacto;
	
	private String nombre;
	private String apellidos;
	private String apodo;
	
	@ElementCollection
	@CollectionTable(name = "telefonos", joinColumns = {@JoinColumn(name="idcontacto")})
	@Column(name = "telefono")
	private Set<String> telefonos;
	
	
	public int getIdcontacto() {
		return idcontacto;
	}
	public void setIdcontacto(int idcontacto) {
		this.idcontacto = idcontacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	
	public Set<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<String> telefonos) {
		this.telefonos = telefonos;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idcontacto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactoConTelefonos other = (ContactoConTelefonos) obj;
		return idcontacto == other.idcontacto;
	}
	
	
	@Override
	public String toString() {
		return "Contacto [idcontacto=" + idcontacto + ", nombre=" + nombre + ", apellidos=" + apellidos + ", apodo="
				+ apodo + ", " +  telefonos + "]";
	}
	
	
	
}
