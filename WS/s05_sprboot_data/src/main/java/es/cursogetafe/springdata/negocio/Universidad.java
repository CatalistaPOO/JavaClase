package es.cursogetafe.springdata.negocio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cursogetafe.springdata.modelo.Asignatura;
import es.cursogetafe.springdata.modelo.Profesor;
import es.cursogetafe.springdata.persistencia.AlumnoDao;
import es.cursogetafe.springdata.persistencia.AsignaturaDao;
import es.cursogetafe.springdata.persistencia.ProfesorDao;
import jakarta.annotation.PostConstruct;
@Service
public class Universidad {
	private AsignaturaDao asigDao;
	private AlumnoDao aluDao;
	private ProfesorDao profeDao;
	
	public Universidad() {
	}
	
	@Autowired
	public Universidad(AsignaturaDao asigDao, AlumnoDao aluDao, ProfesorDao profeDao) {
		super();
		this.asigDao = asigDao;
		this.aluDao = aluDao;
		this.profeDao = profeDao;
	}

	@PostConstruct
	public void init() {
		
//		asigDao.findAll().forEach(System.out::println);
//		System.out.println("-------------------------");
//		aluDao.findAll().forEach(System.out::println);
//		System.out.println("-------------------------");
//		profeDao.findAll().forEach(System.out::println);
//		System.out.println("-------------------------");
//		
//		Optional<Asignatura> buscadaOpt= asigDao.findById(9);
//		if (buscadaOpt.isPresent()) {
//			Asignatura buscada = buscadaOpt.get();
//			System.out.println(buscada);
//			System.out.println(buscada.getAlumnos());
//		}else {
//			
//			System.out.println("no existe");
//		}
		
//		
//		System.out.println(buscada.getAlumnos());
		
//		asigDao.buscarSinProfesor().forEach(System.out::println);
		
//		asigDao.buscarPorDescripcion("datos").forEach(System.out::println);
		
//		Profesor profe = profeDao.findById(10).get();
//		asigDao.findByProfesor(profe).forEach(System.out::println);
		
//		asigDao.findByFacultadLike("%Mate%").forEach(System.out::println);
		
//		asigDao.buscarTodas().forEach((id,asig)->System.out.println(id + ": " + asig));
		
//		profeDao.findByApellidos("silva").forEach(System.out::println);
		
		asigDao.findByProfesor("va").forEach(System.out::println);
	}

	
}
