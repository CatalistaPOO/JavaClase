package com.getafe.ejerciciojpa.consultas;

import java.util.List;

import com.getafe.ejerciciojpa.config.Config;
import com.getafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta01 {
	public static void main(String[] args) {
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		//definimos consulta jpql: buscar objetos de la clase cliente
		String jpql = "select c from Cliente c";
		
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		
		List<Cliente> clientes = q.getResultList();
		
		clientes.forEach(System.out::println);
		
		System.out.println("-------------");
		//buscar todos los numeros de clientes
		jpql = "select c.nroCliente from Cliente c";
		
		List<Integer> numeros = em.createQuery(jpql, Integer.class).getResultList();
		
		numeros.forEach(System.out::println);
		
		
		System.out.println("-------------");
		
		
		//buscar todos los numeros de clientes
		jpql = "select c.nroCliente, c.categoria from Cliente c";
		
		List<Object[]> lista = em.createQuery(jpql, Object[].class).getResultList();
		
		for(Object[] objects : lista) {
			System.out.println(objects[0] + ":" + objects[1]);
		}
		
	}
	
	
}