package es.cursogetafe.springdata.persistencia;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import es.cursogetafe.springdata.modelo.Asignatura;
import es.cursogetafe.springdata.modelo.Profesor;


public interface AsignaturaDao extends JpaRepository<Asignatura, Integer>, AsignaturaDaoCustom {
	
	@Query("select a from Asignatura a where a.profesor is null")
	Set<Asignatura> buscarSinProfesor();
	
//	@NativeQuery("select * from asigaturas left join alumnos on...")//opcion para consulta con sql(nativequery)
	@Query("select a from Asignatura a where a.asignatura like %?1%")
	Set<Asignatura> buscarPorDescripcion(String desc);
	
	Set<Asignatura> findByProfesor(Profesor profe);//utiliza el nombre de la clase
	
	Set<Asignatura> findByFacultadLike(String facultad);//utiliza el nombrede la clase yla consulta(simple)
	
//	@Query("select a from Asignatura a left join fetch a.alumnos where id.asignatura = ?1")
//	Asignatura findByIdEager(Integer id);
//	
//	public default Optional<Asignatura> findById(Integer id){
//		Asignatura buscada = findByIdEager(id);
//		if(buscada != null)
//			return Optional.of(buscada);
//		else
//			return Optional.empty();
//	}
	
	@Query("select a from Asignatura a left join fetch a.alumnos where a.asignatura = ?1")
	Optional<Asignatura>findByIdEager(Integer id);
	
	public default Optional<Asignatura> findById(Integer id){
			return findByIdEager(id);
	}
	
//	default Map<Integer, Asignatura> buscarTodas(){
//		Map<Integer,Asignatura> resu= new HashMap<Integer,Asignatura>();
//		for (Asignatura asig : findAll()) {
//			resu.put(asig.getIdAsignatura(), asig);
//		}
//		return resu;
//	}
	
	default Map<Integer, Asignatura> buscarTodas(){
		return findAll().stream().collect(Collectors.toMap(Asignatura::getIdAsignatura, Function.identity()));
//		Collectors trabajaría con hilos
	}
	
	//Esta clase es una interface y no podemos inyectar el entity manager por lo que perdemos funcionalidades.
	//
	
	
	
}
