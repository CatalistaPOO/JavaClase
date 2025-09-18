package com.getafe.tienda.negocio;

import java.util.Set;

import com.getafe.tienda.modelo.Fabricante;
import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.modelo.Usuario;

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
	 * Devuelve todos los fabricantes ordenados por su nombre
	 * @return Set de fabricantes ordenados
	 */
	Set<Fabricante> getFabricantes();
	
	/**
	 * Retorna el fabricante buscado
	 * @param idFabricante id del fabricante
	 * @return el fabricante si existe, null si no existe
	 */
	Fabricante getFabricante(int idFabricante);
	
	/**
	 * Devuelve todos los fabricantes que proporcionan productos. Ordenados por su nombre
	 * @return Set de fabricantes ordenados
	 */
	Set<Fabricante> getFabricantesActivos();
	
	/**
	 * Agrega un nuevo producto en la persistencia
	 * @param p producto a agregar
	 */
	void crearProducto(Producto p);
	
	/**
	 * Agrega un nuevo Usuario
	 * @param u usuario a agregar
	 * @return
	 */
	boolean crearUsuario(Usuario u);
	
	/**
	 * Valida las credenciales de un login
	 * @param usr nombre de usuario
	 * @param pwd password
	 * @return el Usuario si las credenciales son correctas o null si no lo son
	 */
	Usuario validaUsuario(String usr, String pwd);
}
