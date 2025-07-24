package com.getafe.ejerciciojpa.consultas;


import java.util.List;
import com.getafe.ejerciciojpa.config.Config;
import com.getafe.ejerciciojpa.modelo.ClienteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta07 {
	public static void main(String[] args) {
		
		clienteDTO().forEach(System.out::println);
		
		}
		
	public static List<ClienteDTO> clienteDTO() {
		EntityManager em = Config.getEmf().createEntityManager();
		//Devolver todos los clientes usando clienteDTO
		String jpql = "select com.getafe.ejerciciojpa.modelo(c.idRol, c.idCliente, c.persona.apellidos, c.nroCliente, c.categoria)" 
				+ " from Cliente c";//consulta JPQL llamando al constructor (del record (el path de la clase ClienteCategoria))
		TypedQuery<ClienteDTO> q = em.createQuery(jpql, ClienteDTO.class);
		
		return q.getResultList();
	}
		
}