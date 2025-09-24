package es.cursosanblas.examen.persistencia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import es.cursosanblas.examen.config.Config;
import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class AsignaturaDaoImpl implements AsignaturaDao {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AsignaturaDaoImpl() {
		emf = Config.getEmf();
	}
	
	@Override
	public boolean insertar(Asignatura asignatura) {
		EntityManager em = emf.createEntityManager();
		try (em){
			em.getTransaction().begin();
			em.persist(asignatura);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(Asignatura asignatura) {
		EntityManager em = emf.createEntityManager();
		try (em){
			em.getTransaction().begin();
			em.merge(asignatura);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Asignatura asignatura) {
		EntityManager em = emf.createEntityManager();
		asignatura = em.find(Asignatura.class, asignatura.getIdAsignatura());
		boolean resu = false;
		if(asignatura != null) {
			try(em){
				em.getTransaction().begin();
				em.remove(asignatura);
				em.getTransaction().commit();
				resu = true;
			} catch(Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}
		}
		return resu;
	}

	@Override
	public Asignatura buscar(int idAsignatura) {
		em = emf.createEntityManager();
		String jpql = "select a from Asignatura a left join fetch a.alumnos where a.idAsignatura = :id";
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class);
		q.setParameter("id", idAsignatura);
		Asignatura resu = q.getSingleResultOrNull();
		em.close();
		return resu;
	}

	@Override
	public Set<Asignatura> buscarPorProfesor(Profesor profesor) {
		em = emf.createEntityManager();
		String jpql = "select a from Asignatura a where a.profesor = :profe";
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class);
		q.setParameter("profe",	profesor);
		Set<Asignatura> resu = new HashSet<Asignatura>(q.getResultList());
		em.close();
		return resu;
	}

	@Override
	public Map<Integer, Asignatura> buscarTodas() {
		em = emf.createEntityManager();
		String jpql = "select a from Asignatura a";
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class);
		Map<Integer, Asignatura> resu = new HashMap<Integer, Asignatura>();
		for (Asignatura asig : q.getResultList()) {
			resu.put(asig.getIdAsignatura(), asig);
		}
		em.close();
		return resu;
	}

	@Override
	public Set<Asignatura> buscarSinProfesor() {
		em = emf.createEntityManager();
		String jpql = "select a from Asignatura a where a.profesor is null";
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class);
		Set<Asignatura> resu = new HashSet<Asignatura>(q.getResultList());
		em.close();
		return resu;
	}
}
