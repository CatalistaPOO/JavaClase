package com.cursogetafe.agenda.negocio;

import java.io.IOException;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.persistencia.ContactoDao;
import com.cursogetafe.agenda.persistencia.ContactoDaoJDBC;

public class AgendaImpl implements Agenda {
	
	private ContactoDao cDao;
	
	public AgendaImpl() {
//		cDao = new ContactoDaoMem();
//		cDao = new ContactoDaoMemSerial();
		cDao = new ContactoDaoJDBC();
	}

	@Override
	public void insertarContacto(Contacto c) {
		// Devuelve contacto
		cDao.insertar(c);
	}

	@Override
	public Contacto eliminar(int idContacto) {
		// Elimina contacto por id, para devolverlo necesita un clon
		Contacto clonCDao = cDao.buscar(idContacto); 
		cDao.eliminar(idContacto);
		return clonCDao;
	}

	@Override
	public boolean eliminar(Contacto c) {
		// busca contacto y elimina
		return cDao.eliminar(c.getIdContacto());
	}

	@Override
	public void modificar(Contacto c) {
		// modificar
	    cDao.actualizar(c);
	}
	
	//Metodo para obtener compare y usarlo en buscarTodos y buscarContactosPorNombre
	private Comparator<Contacto> getComparatorApodo(){
		return (c1,c2) -> {
			Collator col = Collator.getInstance(new Locale("es"));
			return col.compare(c1.getApodo(), c2.getApodo());
		};
	}
	
	@Override
	public Set<Contacto> buscarTodos() {
		// Buscar con comparator y añadir a un TreeSet los contactos
		Set<Contacto> contactos = new TreeSet<Contacto>(getComparatorApodo());
		contactos.addAll(cDao.buscarTodos());
		return contactos;
	}

	@Override
	public Set<Contacto> buscarContactoPorNombre(String buscado) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int importarCSV(String fichero) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contacto buscar(int idContacto) {
		// buscar por id de Contacto
		return cDao.buscar(idContacto);
	}

}
