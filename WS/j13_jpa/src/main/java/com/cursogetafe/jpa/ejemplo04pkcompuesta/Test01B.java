package com.cursogetafe.jpa.ejemplo04pkcompuesta;

import com.cursogetafe.jpa.config.Config;
import jakarta.persistence.EntityManager;


//En esta clase utilizamos una clase que tiene primary key compuesta, recordar añadir a persistence.xml las clases usadas.
public class Test01B {
	public static void main(String[] args) {
		//conexion
		EntityManager em = Config.getEmf().createEntityManager();
		
		//Clase usa metodo find de conexion para consulta
		Persona04B p = em.find(Persona04B.class, new DniB(12121212,'A'));
		System.out.println((p));
		
		
		//permite crear para un DNI concreto el nombre, si utilizamos el mismo DNI dará error de integridad (lo que asegura que sea unico)
		Persona04B nuevo = new Persona04B(new DniB(9876, 'Z'), "Otro más");
		//generamos nueva fila en modo transaccional
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		//Cerrar conexion
		em.close();
	}
}