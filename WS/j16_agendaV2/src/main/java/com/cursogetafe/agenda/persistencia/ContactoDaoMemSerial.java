package com.cursogetafe.agenda.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.util.Contactos;

public class ContactoDaoMemSerial implements ContactoDao{
	
	private Map<Integer,Contacto> almacen;
	private int proximoId;
	
	private final String FICH_ALM = "almacen.dat";
	private final String FICH_ID = "id.dat";
	
	
	//Constructor
	public ContactoDaoMemSerial() {
//		almacen = new HashMap<Integer, Contacto>();//tipo hashMap
//		proximoId = 1;
//		cargaInicial();
		leerFicheros();
	}
	
	private void cargaInicial() {
		for (Contacto c : Contactos.generaContactos()) {
			insertar(c);
		}
		grabar();
	}
	
	//Este metodo obtiene los ficheros de memoria
	private void leerFicheros() {
		try (FileInputStream fisAlm = new FileInputStream(FICH_ALM);
				FileInputStream fisId = new FileInputStream(FICH_ID)){
				ObjectInputStream oisAlm = new ObjectInputStream(fisAlm);
				ObjectInputStream oisId = new ObjectInputStream(fisId);
				
				almacen = (Map<Integer, Contacto>) oisAlm.readObject();//casting 
				proximoId = (Integer) oisId.readObject();
				
		}catch (FileNotFoundException e) {
			almacen = new HashMap<Integer, Contacto>();//tipo hashMap
			proximoId = 1;
			cargaInicial();
		}
		catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();	
		}
	}
	
	@Override
	public void insertar(Contacto c) {
		// Recibe objeto sin id., incrementa el id y lo guarda
		c.setIdContacto(proximoId++);
		almacen.put(c.getIdContacto(), c);
		grabar();
	}

	@Override
	public void actualizar(Contacto c) {
		// Actualizar un contactos
		almacen.replace(c.getIdContacto() , c);
		grabar();
		
	}

	@Override
	public boolean eliminar(int idContacto) {
		// Recibe idContacto, elimina y recoloca el resto de idContacto
//		if(almacen.containsKey(idContacto)) {
//			almacen.remove(idContacto);
//			return true;
		grabar();
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
	
	//metodo propio, grabamos dos datos (map e id) 
	private void grabar() {
		try(FileOutputStream fosAlm = new FileOutputStream(FICH_ALM); 
			FileOutputStream fosId = new FileOutputStream(FICH_ID)	
			){
			
			ObjectOutputStream oosAlm = new ObjectOutputStream(fosAlm);
			ObjectOutputStream oosId = new ObjectOutputStream(fosId);
			
			oosAlm.writeObject(almacen);
			oosId.writeObject(proximoId);
			
		}catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
