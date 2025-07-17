package com.cursogetafe.jpa.ejemplo01;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// Esta clase funcionará como JavaBean.(Serializable, contructor sin cuerpo)

@Entity //indicamos que es una clase persistente (la gestiona Hibernate)
@Table(name = "persona") //indicamos la tabla a la que apunta
//esta clase es JavaBean e implementa Serializable
public class Persona implements Serializable{
	
	//cuando usamos @Id entiende que el atributo que tiene debajo es un id y el resto se identifican como atributos de la tabla.
	@Id //indica el atributo que usamos como id(idPersona) y le indicamos como se maneja con GeneratedValue(siguientelínea)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//indicamos que el valor del id es autoincremental, es decir cuando crea un nuevo onjeto le asigna un id incrementado
	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	
	//constructor por defecto
	public Persona(){}

	public Persona(int idPersona, String apellidos, String nombre) {
		super();
		this.idPersona = idPersona;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}


	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return idPersona == other.idPersona;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellidos=" + apellidos + ", apodo=" + apodo + ", nombre="
				+ nombre + ", dni=" + dni + "]";
	}
	
}