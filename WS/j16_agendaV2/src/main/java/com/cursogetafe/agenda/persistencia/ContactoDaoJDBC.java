package com.cursogetafe.agenda.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import com.cursogetafe.agenda.config.Config;
import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.modelo.Domicilio;

public class ContactoDaoJDBC implements ContactoDao {
	
	private DataSource ds;
	
	 public ContactoDaoJDBC() {
		ds = Config.getDataSource();
	}
	

	@Override
	public void insertar(Contacto c) {
		String sql = "insert into contactos" +  
						"( nombre, apellidos, apodo, tipo_via, via, numero, piso, puerta, " +
						"codigo_postal, ciudad, provincia)values(?,?,?,?,?,?,?,?,?,?,?)";//las ? indican un marcador de posición
		//JDBC trabaja en modo autocommit pero para añadir un contacto no tiene sentido (no queremos grabar un contacto a medias)
		//necesitamos activar el nmodo transaccional, si sale bien hacer commit y si sale mal rollback
		try (Connection con= ds.getConnection()){
			con.setAutoCommit(false);//autocommit desactivado
			PreparedStatement ps = con.prepareStatement(sql);//obtenemos la consulta insert
			
			//Setea cada elemento(numero del elemento,valor) con PreparedStatement(la consulta de insert)
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getApellidos());
			ps.setString(3, c.getApodo());
			ps.setString(4, c.getDom().getTipoVia());
			ps.setString(5, c.getDom().getVia());
			ps.setInt(6,c.getDom().getNumero());
			ps.setInt(7,c.getDom().getNumero());
			ps.setString(8, c.getDom().getPuerta());
			ps.setString(9, c.getDom().getCodigoPostal());
			ps.setString(10, c.getDom().getCiudad());
			ps.setString(11, c.getDom().getProvincia());
			
			// si hay filas, seteamos cada fila,si no hay filas hay que hacer rollback.
			int filas = ps.executeUpdate();
			if(filas == 1) {
				//consultar el id generado
				PreparedStatement psId = con.prepareStatement("select LAST_INSERT_ID()"); //Solo en MySQL
				ResultSet rsId = psId.executeQuery();
				rsId.next();
				int id = rsId.getInt(1);
				
				//consultar numero de telefonos
				sql = "insert into telefonos (fk_contacto, telefono) values (?,?)";
				PreparedStatement psTel = con.prepareStatement(sql);
				int cantTel = 0;
				for (String tel : c.getTelefonos()) {
					psTel.setInt(1, id);
					psTel.setString(2,tel);
					cantTel += psTel.executeUpdate();
				}
				
				//consultar numero de correos
				sql = "insert into correos (fk_contacto, correo) values (?,?)";
				PreparedStatement psCorreo = con.prepareStatement(sql);
				int cantCorreos = 0;
				for (String correo : c.getCorreos()) {
					psCorreo.setInt(1, id);
					psCorreo.setString(2,correo);
					cantCorreos += psCorreo.executeUpdate();
				}
				
				if (cantTel == c.getTelefonos().size() && cantCorreos == c.getCorreos().size()) {
						con.commit();
				}
				else {
					con.rollback();
					throw new RuntimeException();
					}
				}
			else {
				con.rollback();
				//tendria que lanzar excepcion propia (algo fallo guardando el contacto, correo o telefono)
				throw new RuntimeException();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
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
				c.setIdContacto(rs.getInt("idcontactos"));
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
				c.setDom(dom);
				
				sql = "select telefono from telefonos where fk_contacto = ?";
				PreparedStatement psTelefonos = con.prepareStatement(sql);
				psTelefonos.setInt(1, c.getIdContacto());
				ResultSet rsTelefonos = psTelefonos.executeQuery();
				while (rsTelefonos.next()) {
					c.addTelefonos(rsTelefonos.getString("Telefono"));
				}
				
				sql = "select correo from correos where fk_contacto = ?";
				PreparedStatement psCorreos = con.prepareStatement(sql);
				psCorreos.setInt(1, c.getIdContacto());
				ResultSet rsCorreos = psCorreos.executeQuery();
				while (rsCorreos.next()) {
					c.addCorreos(rsCorreos.getString("correo"));
				}
				
				resu.add(c);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resu;
	}
	
	
	
	
	
}
