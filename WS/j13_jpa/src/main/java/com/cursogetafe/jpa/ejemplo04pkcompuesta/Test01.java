package com.cursogetafe.jpa.ejemplo04pkcompuesta;

import com.cursogetafe.jpa.config.Config;
import jakarta.persistence.EntityManager;

//En esta clase utilizamos una clase que tiene primary key compuesta, recordar añadir a persistence.xml las clases usadas.
public class Test01 {
	public static void main(String[] args) {
		//conexion
		EntityManager em = Config.getEmf().createEntityManager();
		
		//Clase usa metodo find de conexion para consulta
		Persona04 p = em.find(Persona04.class, new Dni(12121212,'A'));
		System.out.println((p));
		
		Persona04 nuevo = new Persona04(1234, 'X', "Pepito");
		//generamos nueva fila en modo transaccional
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		//Cerrar conexion
		em.close();
	}
}