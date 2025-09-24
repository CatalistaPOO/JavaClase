package es.cursosanblas.examen.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Config {

	private static EntityManagerFactory emf;
	
	private Config() {}
	
	public static EntityManagerFactory getEmf() {
		if(emf == null)
			emf = Persistence.createEntityManagerFactory("examen");
		return emf;
	}
}
