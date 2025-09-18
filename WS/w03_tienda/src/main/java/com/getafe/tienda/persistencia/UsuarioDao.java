package com.getafe.tienda.persistencia;

import com.getafe.tienda.modelo.Usuario;

public interface UsuarioDao {

	Usuario findById(int id);
	
	boolean save(Usuario usuario);
	
	Usuario valida(String usuario, String password);
}
