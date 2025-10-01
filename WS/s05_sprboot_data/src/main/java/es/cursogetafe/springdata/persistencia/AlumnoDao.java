package es.cursogetafe.springdata.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursogetafe.springdata.modelo.Alumno;


public interface AlumnoDao extends JpaRepository<Alumno, Integer> {
	
}
