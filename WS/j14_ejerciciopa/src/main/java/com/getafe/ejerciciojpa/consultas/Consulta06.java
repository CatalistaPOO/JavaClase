package com.getafe.ejerciciojpa.consultas;

import java.util.LinkedList;
import java.util.List;

import com.getafe.ejerciciojpa.config.Config;
import com.getafe.ejerciciojpa.modelo.Cliente;
import com.getafe.ejerciciojpa.modelo.ClienteCategoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta06 {
	public static void main(String[] args) {
		
		cantClientesPorCategoria().forEach(System.out::println);
		
		}
		
	
	public static List<ClienteCategoria> cantClientesPorCategoria() {
		EntityManager em = Config.getEmf().createEntityManager();
		//Buscar la cantidad de clientes por categoria
		//String jpql = "select categoria, count(idrol) from clientes group by categoria ";//consulta SQL
		String jpql = "select new com.getafe.ejerciciojpa.modelo.ClienteCategoria(c.categoria, count(c.idRol)) " 
				+ "from Cliente c group by c.categoria";//consulta JPQL llamando al constructor (del record (el path de la claseClienteCategoria))
		TypedQuery<ClienteCategoria> q = em.createQuery(jpql, ClienteCategoria.class);
		
		return q.getResultList();
	}
	
	public static List<ClienteCategoria> cantClientesPorCategoriaManual() {
		EntityManager em = Config.getEmf().createEntityManager();
		//Buscar la cantidad de clientes por categoria
		//String jpql = "select categoria, count(idrol) from clientes group by categoria ";//consulta SQL
		String jpql = "select c.categoria, count(c.idRol) from Cliente c group by c.categoria";//consulta JPQL 
		TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
		
		List<Object[]> objetos = q.getResultList();
		List<ClienteCategoria> resu = new LinkedList<ClienteCategoria>();
		
		for (Object[] array : objetos) {
			
			resu.add(new ClienteCategoria((String) array[0],(Long)array[1]));
		}
		return resu;
	}
}
