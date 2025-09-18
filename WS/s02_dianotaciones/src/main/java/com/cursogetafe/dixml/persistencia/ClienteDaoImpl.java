package com.cursogetafe.dixml.persistencia;

import org.springframework.stereotype.Component;

//@Component("clienteDaoImpl") nombre por defecto
//@Component //utiliza el nombre por defecto
@Component("clienteDao")
public class ClienteDaoImpl implements ClienteDao {

	public ClienteDaoImpl() {
		System.out.println("Constructor ClienteDaoImpl()");
	}
	
	@Override
	public String findById(int id) {
		return "Este es el cliente con id " + id;
	}

}
