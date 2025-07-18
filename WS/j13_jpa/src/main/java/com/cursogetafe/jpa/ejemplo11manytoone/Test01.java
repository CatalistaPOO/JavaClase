package com.cursogetafe.jpa.ejemplo11manytoone;

import org.hibernate.internal.build.AllowSysOut;

//import java.sql.PreparedStatement;
import com.cursogetafe.jpa.config.Config;
import com.cursogetafe.jpa.ejemplo01mapeosimple.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {
	public static void main(String[] args) {
		//unidad de persistencia para conexión (pool o DataSource)
		EntityManagerFactory emf = Config.getEmf();
		//Interactua con la persistencia
		EntityManager em = emf.createEntityManager();
		

		Partido p = em.find(Partido.class, 4);
		System.out.println(p);
		
		
		
		
		}
}