package es.cursogetafe.springdata.persistencia;

import java.util.Set;

import es.cursogetafe.springdata.modelo.Asignatura;

public interface AsignaturaDaoCustom {
	Set<Asignatura> findByProfesor(String apellido);
}
