package com.getafe.ejerciciojpa.pruebas;

import com.getafe.ejerciciojpa.config.Config;
import com.getafe.ejerciciojpa.modelo.Cliente;
import com.getafe.ejerciciojpa.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class Test01 {
	public static void main(String[] args) {
		
		//busca el cliente 12 con sus productos
		Cliente cli = buscaClienteId(12);
		
		if (cli != null){
			System.out.println(cli);
		
			for (Producto p : cli.getProductos()) {
				System.out.println(p);
			}
		}
		
		
		buscaClienteIdjpql(99);
		
		if (cli != null){
			System.out.println(cli);
			
			for (Producto p : cli.getProductos()) {
				System.out.println(p);
			}
		}
		
		buscaClienteIdjpqlSinTrycatch(99);
	
	}
	
	//retorna el cliente con sus productos cargados en caso que exista
	public static Cliente buscaClienteId(int id) {
		EntityManager em = Config.getEmf().createEntityManager();
		
		Cliente buscado = em.find(Cliente.class, id);
		if (buscado != null)
				buscado.getProductos().size();//puede dar error si se pide un cliente fuera de rango
		
		em.close();
		
		return buscado;
	}
	
	
	public static Cliente buscaClienteIdjpql(int id) {
		EntityManager em = Config.getEmf().createEntityManager();
		String jpql = "select c from Cliente c left join fetch c.productos where c.idRol = :id";//fetch para cargar productos
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", id);
		
		Cliente buscado;
		try {
			buscado = q.getSingleResult();
			
		} catch (NoResultException e) {
			buscado = null;
		}
		em.close();
		
		return buscado;
	}
	
	public static Cliente buscaClienteIdjpqlSinTrycatch(int id) {
		EntityManager em = Config.getEmf().createEntityManager();
		String jpql = "select c from Cliente c left join fetch c.productos where c.idRol = :id";//fetch para cargar productos
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", id);
		
		Cliente buscado = q.getSingleResultOrNull();
		
		em.close();
		
		return buscado;
	}
	
}
