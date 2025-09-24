package es.cursosanblas.examen.modelo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno extends Persona {

	private String matricula;
	@Column(name = "anyo_inscripcion")
	private int anyoInscripcion;

	@ManyToMany
	@JoinTable(name = "matriculados", 
			joinColumns = @JoinColumn(name="fk_alumno"), 
			inverseJoinColumns = @JoinColumn(name="fk_asignatura"))
	private Set<Asignatura> asignaturas;
	
	public Alumno() {
	}
	
	public Alumno(String dni, String nombre, String apellido1, String apellido2, String telefono, String direccion,
			String ciudad, String matricula, int anyoInscripcion) {
		super(dni, nombre, apellido1, apellido2, telefono, direccion, ciudad);
		this.matricula = matricula;
		this.anyoInscripcion = anyoInscripcion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAnyoInscripcion() {
		return anyoInscripcion;
	}

	public void setAnyoInscripcion(int anyoInscripcion) {
		this.anyoInscripcion = anyoInscripcion;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", anyoInscripcion=" + anyoInscripcion + ", getIdPersona()="
				+ getIdPersona() + ", getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellido1()="
				+ getApellido1() + ", getApellido2()=" + getApellido2() + ", getTelefono()=" + getTelefono()
				+ ", getDireccion()=" + getDireccion() + ", getCiudad()=" + getCiudad() + "]";
	}
	
	
}
