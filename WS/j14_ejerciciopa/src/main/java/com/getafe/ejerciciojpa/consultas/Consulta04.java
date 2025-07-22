package com.getafe.ejerciciojpa.consultas;



import com.getafe.ejerciciojpa.config.Config;
import com.getafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class Consulta04 {

	public static void main(String[] args) {
		//Clientes VIP que han comprado discos
		String categoria = "VIP";
		String producto = "disco";
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select c from Cliente c join c.productos p where c.categoria = :cat and p.producto like :prod";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cat", categoria);
		q.setParameter("prod", "%" +  producto + "%");//al ser like, debemos usar como en sql %
		
		q.getResultList().forEach(
				c -> {System.out.println(c);
				System.out.println(c.getProductos());
				});
	}
	
}
