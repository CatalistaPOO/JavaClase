package es.cursogetafe.springdata.persistencia;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.cursogetafe.springdata.modelo.Profesor;

public interface ProfesorDao extends JpaRepository<Profesor, Integer> {
	
	@Query("select p from Profesor p where p.apellido1 like %?1% or p.apellido2 like %?1%")
	Set<Profesor> findByApellidos(String apellido);
	
}