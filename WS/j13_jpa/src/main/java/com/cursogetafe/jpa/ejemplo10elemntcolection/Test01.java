package com.cursogetafe.jpa.ejemplo10elemntcolection;

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
		

		ContactoConTelefonos c = em.find(ContactoConTelefonos.class, 10);
		
		
		
//		System.out.println(c.getApellidos() + ", " +  c.getNombre());
		
		System.out.println(c.getIdcontacto());
		System.out.println(c.getApellidos());
		
		em.close();
		// al cerrar la conexion no podrá leer los telefonos porque pierde la referencia del objeto que teníamos
		System.out.println("----------------");
		System.out.println("y ahora accedo a los telefonos");
		System.out.println(c.getTelefonos());
	
		
		
		}
}