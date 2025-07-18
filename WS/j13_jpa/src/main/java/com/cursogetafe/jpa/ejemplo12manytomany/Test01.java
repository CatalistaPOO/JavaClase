package com.cursogetafe.jpa.ejemplo12manytomany;


import com.cursogetafe.jpa.config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {
	public static void main(String[] args) {
		//unidad de persistencia para conexión (pool o DataSource)
		EntityManagerFactory emf = Config.getEmf();
		//Interactua con la persistencia
		EntityManager em = emf.createEntityManager();
		

		Jugador j = em.find(Jugador.class, 5);
		System.out.println(j);
		
		
		System.out.println(j.getEquipos());
		
		
		em.close();
		
		}
}