package com.getafe.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fabricante")
	private int idFabricante;
	private String fabricante;
	
	@OneToMany(mappedBy = "fabricante")
	private Set<Producto> productos;
	public int getIdFabricante() {
		return idFabricante;
	}
	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idFabricante);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		return idFabricante == other.idFabricante;
	}
	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", fabricante=" + fabricante + "]";
	}
	
	
}
