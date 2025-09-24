package es.cursosanblas.examen.tests;

import es.cursosanblas.examen.modelo.Alumno;
import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestEmf {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examen");
		
		EntityManager em = emf.createEntityManager();
		
		Alumno alu = em.find(Alumno.class, 67);
		
		System.out.println(alu);
		System.out.println(alu.getAsignaturas());
		
		Profesor profe = em.find(Profesor.class, 20);
		
		System.out.println(profe);
		
		Asignatura asig = em.find(Asignatura.class, 2);
		System.out.println(asig);
		System.out.println(asig.getAlumnos());
	}
}
