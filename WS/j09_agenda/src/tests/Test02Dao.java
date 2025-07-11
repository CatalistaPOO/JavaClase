package tests;

import agenda.modelo.Contacto;
import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoMem;

public class Test02Dao {
	public static void main(String[] args) {
		ContactoDao dao = new ContactoDaoMem();
		
		dao.buscarTodos().forEach(System.out::println);
		System.out.println("-------------------------");
		
		dao.buscar("al").forEach(System.out::println);
		System.out.println("-------------------------");
		
		System.out.println(dao.buscar(44));
		System.out.println("-------------------------");
		
		Contacto buscado = dao.buscar(88);
		buscado.setApellidos("Nuevo Apellido");
		dao.actualizar(buscado);
		
		buscado = dao.buscar(88);
		System.out.println(buscado);
		
		dao.eliminar(88);
		System.out.println(dao.buscar(88));
	}
}
