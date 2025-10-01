package es.cursogetafe.springdata.persistencia;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import es.cursogetafe.springdata.modelo.Asignatura;
import es.cursogetafe.springdata.modelo.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

//El nombre de esta clase es igual de la que hereda y siempre lleva al final el Impl
public class AsignaturaDaoCustomImpl implements AsignaturaDaoCustom{
	
	
	private EntityManager em;
	private ProfesorDao pDao;
	
	
	@Override
	public Set<Asignatura> findByProfesor(String apellido) {
		Set<Profesor> profesores = pDao.findByApellidos(apellido);
		String jpql = "select a from Asignatura a where a.profesor in :profes";
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class).setParameter("profes", profesores);
		return new HashSet<Asignatura>(q.getResultList());
	}



	public EntityManager getEm() {
		return em;
	}


	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}



	public ProfesorDao getpDao() {
		return pDao;
	}


	@Autowired
	public void setpDao(ProfesorDao pDao) {
		this.pDao = pDao;
	}
	
	

}
