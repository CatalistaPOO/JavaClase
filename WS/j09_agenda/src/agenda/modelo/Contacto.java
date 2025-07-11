package agenda.modelo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Contacto implements Comparable<Contacto>, Cloneable {
	
	//Atributos
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	private Domicilio dom;
	private Set<String> telefonos;
	private Set<String> correos;
	
	//Constructor
	public Contacto() {
		telefonos = new LinkedHashSet<String>();//por orden de carga, por eso LinkedHashSet
		correos = new LinkedHashSet<String>();//por orden de carga, por eso LinkedHashSet
	}
	
	
	
	public Contacto(int idContacto, String nombre, String apellidos, String apodo, Domicilio dom) {
		super();
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
//		this.telefonos = telefonos; 
//		this.correos = correos;
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
	public void addCorreos(String... coreeos) {
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
