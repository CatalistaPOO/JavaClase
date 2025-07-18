package com.cursogetafe.jpa.ejemplo11manytoone;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "campos")
public class Campo2 implements Serializable{
	
	private static final long serialVersionUID = 1L;//asigna nro de version
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCampo;
	private String campo;
	private String direccion;
	
	@OneToMany(mappedBy = "campo")//referencia al atributo de la clase que establece la relacion
	Set<Partido2> partidos;
	
	
	public int getIdCampo() {
		return idCampo;
	}
	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Set<Partido2> getPartidos() {
		return partidos;
	}
	public void setPartidos(Set<Partido2> partidos) {
		this.partidos = partidos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCampo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campo2 other = (Campo2) obj;
		return idCampo == other.idCampo;
	}
	@Override
	public String toString() {
		return "Campo [idCampo=" + idCampo + ", campo=" + campo + ", direccion=" + direccion + "]";
	}
	
	
	
}
