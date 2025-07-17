package com.cursogetafe.jpa.ejemplo05tipoacceso;

import java.sql.PreparedStatement;
import com.cursogetafe.jpa.config.Config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {
	public static void main(String[] args) {
		//unidad de persistencia para conexión (pool o DataSource)
		EntityManagerFactory emf = Config.getEmf();
		//Interactua con la persistencia
		EntityManager em = emf.createEntityManager();
		
		
		Persona05 p = em.find(Persona05.class, 12);
		if (p != null)
			System.out.println(p);
		else
			System.out.println("Esta Persona no existe!!");
		}
}