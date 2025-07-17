package com.cursogetafe.jpa.ejemplo05tipoacceso;

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
public class Persona05 implements Serializable{
	
	//cuando usamos @Id entiende que el atributo que tiene debajo es un id y el resto se identifican como atributos de la tabla.
	@Id //indica el atributo que usamos como id(idPersona) y le indicamos como se maneja con GeneratedValue(siguientelínea)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//indicamos que el valor del id es autoincremental, es decir cuando crea un nuevo onjeto le asigna un id incrementado
	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	
	//constructor por defecto
	public Persona05(){}

	public Persona05(int idPersona, String apellidos, String nombre) {
		
		this.idPersona = idPersona;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}

	//access properties: las anotaciones de metodo anulan las anotaciones de propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		System.out.println("setidPersona");
		this.idPersona = idPersona;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		System.out.println("setApellidos");
		this.apellidos = apellidos;
	}


	public String getApodo() {
		return apodo;
	}


	public void setApodo(String apodo) {
		System.out.println("setApodo");
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
		Persona05 other = (Persona05) obj;
		return idPersona == other.idPersona;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellidos=" + apellidos + ", apodo=" + apodo + ", nombre="
				+ nombre + ", dni=" + dni + "]";
	}
	
}