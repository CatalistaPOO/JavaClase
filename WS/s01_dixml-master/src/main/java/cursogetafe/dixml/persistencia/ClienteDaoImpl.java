package cursogetafe.dixml.persistencia;

public class ClienteDaoImpl implements ClienteDao {

	
	public ClienteDaoImpl() {
		System.out.println("Constructor ClienteDaoImpl()");
	}
	
	@Override
	public String findById(int id) {
		
		return "Este es el cliente con id: " + id;
		
	}

}
