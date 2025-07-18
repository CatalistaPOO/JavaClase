package com.cursogetafe.jpa.ejemplo12manytomany;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "jugadores_03")
public class Equipo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipo;
	private String equipo;
	
	//esta etiqueta especifica a la relacion de la tabla intermedia que se genera en relaciones n a n, 
//	al ser muchos a muchos da igual si es esta tabla o es la otra
//	mientras que la otra tenga un mappedby
	@ManyToMany
	@JoinTable(name = "equipos_jugadores_03",
					joinColumns = @JoinColumn(name = "idequipo"),//fk que apunta a esta clase
					inverseJoinColumns = @JoinColumn(name = "idjugador")) //fk que apunta a la otra clase
	private Set<Jugador> jugadores;
	
	
	
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public Set<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEquipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return idEquipo == other.idEquipo;
	}
	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", equipo=" + equipo + ", jugadores=" + jugadores + "]";
	}
	
	
	
}
