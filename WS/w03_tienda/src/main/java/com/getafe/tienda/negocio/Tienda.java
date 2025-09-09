package com.getafe.tienda.negocio;

import java.util.Set;

import com.getafe.tienda.modelo.Fabricante;
import com.getafe.tienda.modelo.Producto;

public interface Tienda {

	/**
	 * Devuelve todos los productos ordenados por su descripción
	 * @return Un Set de productos ordenados
	 */
	Set<Producto> getProductos();
	
	/**
	 * Devuelve los productos que contienen descripcion ordenados por su descripción
	 * @param descripcion Descripcion de los productos a buscar
	 * @return Un Set de productos ordenados
	 */
	Set<Producto> getProductos(String descripcion);
	
	/**
	 * Devuelve los fabricantes ordenados por su nombre
	 * @return Set de fabricantes ordenados
	 */
	Set<Fabricante> getFabricantes();
	
	/**
	 * Retorna fabricante buscado
	 * @param idFabricante id del fabricante
	 * @return el fabricante si existe, null si no existe
	 */
	Fabricante getFabricante(int idFabricante);
	
	/**
	 * Agrega un nuevo producto en la persistencia
	 * @param p producto a añadir
	 */
	void crearProducto(Producto p);
}
