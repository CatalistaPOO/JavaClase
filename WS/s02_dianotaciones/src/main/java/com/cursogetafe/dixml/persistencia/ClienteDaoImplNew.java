package com.cursogetafe.dixml.persistencia;

public class ClienteDaoImplNew implements ClienteDao {

	@Override
	public String findById(int id) {
		return "Nuevo Dao de cliente " + id;
	}

}
