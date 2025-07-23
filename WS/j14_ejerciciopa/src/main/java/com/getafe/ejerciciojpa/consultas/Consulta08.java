package com.getafe.ejerciciojpa.consultas;


import java.util.List;
import com.getafe.ejerciciojpa.config.Config;

import com.getafe.ejerciciojpa.modelo.ClienteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta08 {
	public static void main(String[] args) {
		
		prodClientes("cable").forEach(System.out::println);
		
		}
		
	
	public static List<ClienteDTO> prodClientes(String producto) {
		EntityManager em = Config.getEmf().createEntityManager();
		//Devolver todos los clientes usando clienteDTO
		String jpql = "select c.idRol, c.persona.apellidos, c.nroCliente, c.categoria" 
				+ "from Cliente c join c.productos p where p.producto like :prod";//consulta JPQL llamando al constructor (del record (el path de la claseClienteCategoria))
		
		TypedQuery<ClienteDTO> q = em.createQuery(jpql, ClienteDTO.class);
		q.setParameter("prod" , "%" + producto + "%");
		
		return q.getResultList();
	}
		
}
