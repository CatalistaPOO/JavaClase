package es.cursosanblas.examen.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

	@Column(name = "nro_seg_social")
	private String nroSeguridadSocial;

	public Profesor() {
	}

	public Profesor(String dni, String nombre, String apellido1, String apellido2, String telefono, String direccion,
			String ciudad, String nroSeguridadSocial) {
		super(dni, nombre, apellido1, apellido2, telefono, direccion, ciudad);
		this.nroSeguridadSocial = nroSeguridadSocial;
	}

	public String getNroSeguridadSocial() {
		return nroSeguridadSocial;
	}

	public void setNroSeguridadSocial(String nroSeguridadSocial) {
		this.nroSeguridadSocial = nroSeguridadSocial;
	}

	@Override
	public String toString() {
		return "Profesor [nroSeguridadSocial=" + nroSeguridadSocial + ", getIdPersona()=" + getIdPersona()
				+ ", getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1()
				+ ", getApellido2()=" + getApellido2() + ", getTelefono()=" + getTelefono() + ", getDireccion()="
				+ getDireccion() + ", getCiudad()=" + getCiudad() + "]";
	}
	
	
}
