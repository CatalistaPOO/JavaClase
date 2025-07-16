package com.cursogetafe.jpa.config;

import jakarta.persistence.EntityManagerFactory;//pertenece a hibernate
import jakarta.persistence.Persistence;

public class Config {

	private static EntityManagerFactory emf;
	
	private Config(){}
	
	//Singleton: Construcción de un unico pool o DataSource
	 public static EntityManagerFactory getEmf() {
		 if (emf == null) {
			 emf = Persistence.createEntityManagerFactory("cursoJPA");
		 }
		 return emf;
	 }
	
}