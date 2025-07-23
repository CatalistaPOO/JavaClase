package com.cursogetafe.agenda.persistencia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.util.Contactos;

public class ContactoDaoMem implements ContactoDao{
	
	private Map<Integer,Contacto> almacen;
	private int proximoId;
	
	//Constructor
	public ContactoDaoMem() {
		almacen = new HashMap<Integer, Contacto>();//tipo hashMap
		proximoId = 1;
	}
	
	private void cargaInicial() {
		for (Contacto c : Contactos.generaContactos()) {
			insertar(c);
		}
	}
	
	@Override
	public void insertar(Contacto c) {
		// Recibe objeto sin id., incrementa el id y lo guarda
		c.setIdContacto(proximoId++);
		almacen.put(c.getIdContacto(), c);
	}

	@Override
	public void actualizar(Contacto c) {
		// Actualizar un contactos
		almacen.replace(c.getIdContacto() , c);
		
	}

	@Override
	public boolean eliminar(int idContacto) {
		// Recibe idContacto, elimina y recoloca el resto de idContacto
//		if(almacen.containsKey(idContacto)) {
//			almacen.remove(idContacto);
//			return true;
//		}
//		return false;
		return almacen.remove(idContacto) != null;
	}

	@Override
	public boolean eliminar(Contacto c) {
//		// identificamos objeto que eliminamos, si existe
//		if(almacen.containsKey(c)) {
//			almacen.remove(c);
//			return true;
//		}
//		return false;
		return eliminar(c.getIdContacto());
	}

	@Override
	public Contacto buscar(int idContacto) {
		// recorres el map por id(key del map) y si es devuelvelo como objeto Contacto
		
		return almacen.get(idContacto);
	}

	@Override
	public Set<Contacto> buscar(String cadena) {
		cadena = cadena.toLowerCase();
		// 
		Set<Contacto> resu = new HashSet<Contacto>();
		for (Contacto contacto : almacen.values()) {
			if(contacto.getApellidos().contains(cadena)
					|| contacto.getNombre().toLowerCase().contains(cadena)
					|| contacto.getApodo().toLowerCase().contains(cadena)) {
				resu.add(contacto);
			}
		}
		return resu;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		// 
		return new HashSet<Contacto>(almacen.values());
	}

}
