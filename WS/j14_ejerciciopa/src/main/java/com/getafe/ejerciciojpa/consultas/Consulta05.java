package com.getafe.ejerciciojpa.consultas;



import com.getafe.ejerciciojpa.config.Config;
import com.getafe.ejerciciojpa.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta05 {
	public static void main(String[] args) {
		
		//
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		
		//Busca todos los clientes con todos sus datos  que por defecto estan en modo eager.
		//no carga los productos (lazy)
		//para cargar todos los datos de la Persona, realiza una consulta por cada idRol
		// una consultasola consulta sin cargar las demas clases aunque sus atributos apunten hacia esas clases.
		String jpql1 = "select c from Cliente c";
		
		//Realiza una consulta con join a Personas con todos los datos
		//no carga los datos (lazy)(una consulta de Personas unidas todas las clases)
		String jpql2 = "select c from Cliente c join fetch c.persona";
		
		//Realiza una sola consulta de Clientes join Roles join Personas join CLientes_productos
		//devuelve los productos en modo eager (una sola consulta con todas las clases unidas)
		String jpql3 = "select c from Cliente c join fetch c.persona left join fetch c.productos";
		
		TypedQuery<Cliente> q = em.createQuery(jpql2 , Cliente.class);
		
		for (Cliente cli : q.getResultList()) {
			System.out.println(cli);
			System.out.println("\t" + cli.getProductos());
		}
	}
}
