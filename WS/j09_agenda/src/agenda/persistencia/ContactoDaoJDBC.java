package agenda.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import agenda.config.Config;
import agenda.modelo.Contacto;
import agenda.modelo.Domicilio;

public class ContactoDaoJDBC implements ContactoDao {
	
	private DataSource ds;
	
	 public ContactoDaoJDBC() {
		ds = Config.getDataSource();
	};
	

	@Override
	public void insertar(Contacto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Contacto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eliminar(int idContacto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Contacto c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscar(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		// Leemos la tabla y traer en result set en un objeto (tipo Contacto) y luego añadir telefonos y correo, filtrando por Id del contacto.
		Set<Contacto> resu = new HashSet<Contacto>();
		try (Connection con = ds.getConnection()){
			String sql = "SELECT idcontactos, nombre, apellidos, apodo, tipo_via, via, numero,piso ,puerta, codigo_postal, ciudad,provincia FROM 11_agenda.contactos;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Contacto c = new Contacto();
				c.setIdContacto(0);
				c.setNombre(rs.getString("nombre"));
				c.setApellidos(rs.getString("apellidos"));
				c.setApodo(rs.getString("apodo"));
				
				Domicilio dom = new Domicilio();
				dom.setTipoVia(rs.getString("tipo_via"));
				dom.setVia(rs.getString("via"));
				dom.setNumero(rs.getInt("numero"));
				dom.setPiso(rs.getInt("piso"));
				dom.setPuerta(rs.getString("puerta"));
				dom.setPuerta(rs.getString("puerta"));
				dom.setCodigoPostal(rs.getString("codigo_postal"));
				dom.setCiudad(rs.getString("ciudad"));
				dom.setProvincia(rs.getString("provincia"));
				
				
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resu;
	}
	
	
	
	
	
}
