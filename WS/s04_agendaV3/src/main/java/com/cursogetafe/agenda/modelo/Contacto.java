package com.cursogetafe.agenda.modelo;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "contactos")
public class Contacto implements Comparable<Contacto>, Cloneable,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idcontactos")
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	
	@Embedded
	@AttributeOverride(name = "tipoVia" , column = @Column(name="tipo_via"))
	@AttributeOverride(name = "codigoPostal", column = @Column(name="codigo_postal"))
	private Domicilio dom;
	
	@ElementCollection
	@CollectionTable(name = "telefonos", joinColumns = {@JoinColumn(name = "fk_contacto")})
	@Column(name = "telefono")
	private Set<String> telefonos;
	
	@ElementCollection
	@CollectionTable(name = "correos", joinColumns = {@JoinColumn(name = "fk_contacto")})
	@Column(name = "correo")
	private Set<String> correos;
	
	//Constructor
	public Contacto() {
		telefonos = new LinkedHashSet<String>();//por orden de carga, por eso LinkedHashSet
		correos = new LinkedHashSet<String>();//por orden de carga, por eso LinkedHashSet
		dom = new Domicilio();
	}
	
	
	
	public Contacto(int idContacto, String nombre, String apellidos, String apodo, Domicilio dom) {
		this();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.dom = dom;
	}



	public Contacto(int idContacto, String nombre, String apellidos, String apodo, Domicilio dom, Set<String> telefonos,
			Set<String> correos) {
		this();//hace una llamada al constructor por defecto
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.dom = dom;
		this.idContacto = idContacto;
//		Lee estos atributos del constructor principal
		this.telefonos = telefonos; 
		this.correos = correos;
	}

	//Getters y Setters
	
	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
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
	public Domicilio getDom() {
		return dom;
	}
	public void setDom(Domicilio dom) {
		this.dom = dom;
	}
	public Set<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<String> telefonos) {
		this.telefonos = telefonos;
	}
	//Este metodo sustituiría a set telefonos permitiendo la insercion de varios telefonos
	public void addTelefonos(String... telefonos) {
		for (String telefono : telefonos) {
			this.telefonos.add(telefono);
		}
	}
	
	public Set<String> getCorreos() {
		return correos;
	}
	public void setCorreos(Set<String> correos) {
		this.correos = correos;
	}
	//Este metodo sustituiría a set correos permitiendo la insercion de varios correos
	public void addCorreos(String... correos) {
		for (String correo : correos) {
			this.correos.add(correo);
		}
	}

	//Sobreescritura hashCode, equals y toString
	@Override
	public int hashCode() {
//		return Objects.hash(idContacto);
		return idContacto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return idContacto == other.idContacto;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", nombre=" + nombre + ", apellidos=" + apellidos + ", apodo="
				+ apodo + ", dom=" + dom + ", telefonos=" + telefonos + ", correos=" + correos + "]";
	}
	//para definir el orden natural de contactos
	@Override
	public int compareTo(Contacto o) {
		return this.idContacto - o.idContacto;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Clona un objeto exactamente igual
		return super.clone();
	}
	
	
	
}
