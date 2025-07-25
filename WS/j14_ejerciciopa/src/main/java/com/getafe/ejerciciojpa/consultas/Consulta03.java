package com.getafe.ejerciciojpa.consultas;



import com.getafe.ejerciciojpa.config.Config;
import com.getafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta03 {
	public static void main(String[] args) {
		
		//buscar clientes de una categoria determinada con un apellido determinado
		String categoria = "ESPORADICO";
		String apellidos = "Ramirez";
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select c from Cliente c where c.categoria = :cat and c.persona.apellidos = :ape"; //los : indican que recibe parametro
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cat", categoria);
		q.setParameter("ape", apellidos);
		
		q.getResultList().forEach(System.out::println);
		
		System.out.println("-------------");
		
		 jpql = "select c from Cliente c where c.categoria = ?1 and c.persona.apellidos = ?2";
		 q = em.createQuery(jpql, Cliente.class);
		 q.setParameter(1, categoria);
		 q.setParameter(2, apellidos);
		 
		 q.getResultList().forEach(System.out::println);
	}
}