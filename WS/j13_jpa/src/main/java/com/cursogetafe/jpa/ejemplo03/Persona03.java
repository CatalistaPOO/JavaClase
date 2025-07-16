package com.cursogetafe.jpa.ejemplo03;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //Indicamos a Hibernate que maneje esta clase
@Table(name="persona04")// indicamos tabla de la BBDD
public class Persona03 implements Serializable{
	
	@Id //indica el atributo que usamos como id(idPersona) y le indicamos como se maneja con GeneratedValue(siguientelínea)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//indicamos que el valor del id es autoincremental
	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	@Embedded //añade los atributos de la clase Domicilio a esta clase (como si fuese un join de SQL)
	private Domicilio dom;
	
	
	
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Domicilio getDom() {
		return dom;
	}
	public void setDom(Domicilio dom) {
		this.dom = dom;
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
		Persona03 other = (Persona03) obj;
		return idPersona == other.idPersona;
	}
	@Override
	public String toString() {
		return "Persona03 [idPersona=" + idPersona + ", apellidos=" + apellidos + ", apodo=" + apodo + ", nombre="
				+ nombre + ", dni=" + dni + ", dom=" + dom + "]";
	}
	
	
}
