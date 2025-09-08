package com.getafe.tienda.negocio;

import java.util.Set;

import com.getafe.tienda.modelo.Producto;

public interface Tienda {
	
	/**
	 * Devuelve todos los productos ordenados por su descripcion
	 * @return un set de productos ordenados
	 */
	Set<Producto> getProductos();
	
	/**
	 * Devuelve todos los productos que contiene descripcion ordenados por su descripción
	 * @param descripcion Descripcion de los productos a buscar
	 * @return un set de productos ordenados
	 */
	Set<Producto> getProductos(String descripcion);
}
