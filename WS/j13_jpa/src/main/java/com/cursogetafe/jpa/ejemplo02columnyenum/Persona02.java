package com.cursogetafe.jpa.ejemplo02;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


 // Esta clase funcionará como JavaBean.(Serializable, contructor sin cuerpo)

@Entity //indicamos que es una clase persistente (la gestiona Hibernate)
@Table(name = "personas")
public class Persona02 implements Serializable{
	
	@Id //indica el atributo que usamos como id(idPersona) y le indicamos como se maneja con GeneratedValue(siguientelínea)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//indicamos que el valor del id es autoincremental
	@Column(name="id_persona")//esta nota indica a qué columna hace referencia en la tabla de la BBDD
	private int idPersona;
	
	@Column(name="p_apellidos")
	private String apellidos;
	
	@Column(name="p_apodo")
	private String apodo;
	
	@Column(name="p_nombre")
	private String nombre;
	
	@Column(name="p_dni")
	private String dni;
	
	@Enumerated(EnumType.STRING)//Utiliza el nombre de las constantes(string)
	@Column(name = "p_sexo")
	private Genero genero;//este atributo apunta a la clase Enum Genero
	
	@Transient //con esta anotación decimos que hibernate(jakarta) obvie este atributo
	private String nombreYApellidos;//este atributo no existe en la BBDD
	
	//constructor por defecto
	public Persona02(){}

	public Persona02(int idPersona, String apellidos, String nombre) {
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
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNombreYApellidos() {
		return nombreYApellidos;
	}

	public void setNombreYApellidos(String nombreYApellidos) {
		this.nombreYApellidos = nombreYApellidos;
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
		Persona02 other = (Persona02) obj;
		return idPersona == other.idPersona;
	}


	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellidos=" + apellidos + ", apodo=" + apodo + ", nombre="
				+ nombre + ", dni=" + dni + "]";
	}
	
	
	
}
