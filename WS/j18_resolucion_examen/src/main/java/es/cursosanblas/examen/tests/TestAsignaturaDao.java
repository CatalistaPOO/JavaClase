package es.cursosanblas.examen.tests;

import java.util.HashMap;

import es.cursosanblas.examen.config.Config;
import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import es.cursosanblas.examen.persistencia.AsignaturaDao;
import es.cursosanblas.examen.persistencia.AsignaturaDaoImpl;
import jakarta.persistence.EntityManager;

public class TestAsignaturaDao {
	public static void main(String[] args) {
		AsignaturaDao dao = new AsignaturaDaoImpl();
		
		Asignatura asig = dao.buscar(2);
		System.out.println(asig);
		
		asig.setCreditos(12);
		dao.actualizar(asig);
		
		asig = dao.buscar(2);
		System.out.println(asig);
		//
		asig = dao.buscar(987);
		System.out.println(asig);
		
		EntityManager em = Config.getEmf().createEntityManager();
		Profesor profe = em.find(Profesor.class, 7);
		System.out.println(profe);
		
		dao.buscarPorProfesor(profe).forEach(System.out::println);
		//
		System.out.println("---------------");
		dao.buscarSinProfesor().forEach(System.out::println);
		
		//
		dao.buscarTodas().forEach((k, v) -> System.out.println(k + ": " + v));
		
	}
}
