package modelo;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;


//Comparable (pinchar command(Mac) sobre comparable para acceder documentacion de la interface)
//	Compares this object with the specified object for order.  Returns a
//	negative integer, zero, or a positive integer as this object is less
//	than, equal to, or greater than the specified object.

public class Cliente implements Comparable<Cliente> {//Implementa Comparable para comparar objetos tipo Cliente
	
	private  int idCliente;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	
	public Cliente(int idCliente, String nombre, String apellido1, String apellido2) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	@Override
	public int hashCode() {
		return idCliente;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + "]";
	}

	//Implementando Comparable en esta clase,obliga a definir el metodo compareTo (que comparará contra otro objeto de tipo Cliente)
	//ya que Cliente no tienen definido un orden por defecto (no conoce atributos)
	@Override
	public int compareTo(Cliente o) {
		// Compara Cliente, si devuelve positivo va despues,el negativo estará antes y si es igual es el mismo
			return this.idCliente - o.idCliente;
		}
	
	
	//crear un metodo que retorne un Comparator por apellidos y nombre
	//el método es static porque no interviene el objeto
	public static Comparator<Cliente> getComparatorApellidos(){
		//creamos 
		return new Comparator<Cliente>() {
		//Implementamos compare con dos objetos anonimos
			@Override
			public int compare(Cliente o1, Cliente o2) {
				String nom1 = o1.apellido1 + o1.apellido2 + o1.nombre + o1.idCliente;
				String nom2 = o2.apellido1 + o2.apellido2 + o2.nombre + o2.idCliente;
				//definimos collator que plantea español(Locale("es") como referencia (Java 17, en 21 cambia)
				//para poder procesar los caracteres españoles cuando usemos compare
				Collator col = Collator.getInstance(new Locale("es"));
				return col.compare(nom1, nom2);
		}
		
	};
	
	}
	
	
}