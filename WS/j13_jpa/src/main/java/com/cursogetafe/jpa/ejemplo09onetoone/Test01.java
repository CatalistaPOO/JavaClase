package com.cursogetafe.jpa.ejemplo09onetoone;

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
		

		Contacto c = em.find(Contacto.class, 9);
		System.out.println(c);
		
		Domicilio d = em.find(Domicilio.class, 3);
		System.out.println(d);
		System.out.println(d.getContacto());
		
//		c.setApodo("TioMolesto");
//		//sigo trabajando...pero apodo se queda sin asignación
//		
//		Persona nueva = new Persona(0,"Apenuevo", "nombreNuevo");
//		//en esta transaccion va a pasar el apodo sin asignación(TioMolesto) en el objeto que está en persistencia
//		em.getTransaction().begin();
//		em.persist(nueva);
//		em.getTransaction().commit();
//		
//		em.close();
		
		}
}