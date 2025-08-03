package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modelo.Cliente;

public class TestHashMap {
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(15,"Adriana", "Jimenez", "Perez");
		Cliente c2 = new Cliente(123,"Juan", "Perez", "López");
		Cliente c3 = new Cliente(168,"Pedro", "Vacis", "Miranda");
		Cliente c4 = new Cliente(516,"Susana", "García", "Pinto");
		Cliente c5 = new Cliente(125,"Adriana", "Jimenez", "Perez");
		
		//crear mapa clientes y llenarlo con los Clientes(c1,c2,c3,c4,c5)
//		Map<Integer, Cliente> clientes= new HashMap<Integer, Cliente>();//mapa
		Map<Integer, Cliente> clientes= new LinkedHashMap<Integer, Cliente>();//mapa creado manteniendo el orden de carga
		clientes.put(c1.getIdCliente(),c1);
		clientes.put(c2.getIdCliente(),c2);
		clientes.put(c3.getIdCliente(),c3);
		clientes.put(c4.getIdCliente(),c4);
		clientes.put(c5.getIdCliente(),c5);
		
		System.out.println(clientes.get(168));
		System.out.println(clientes.get(999));
		
		System.out.println("-----------------");
		System.out.println("-----------------");
		
		// Los maps no son iterables
		// puedo obtener una coleccion de los valores o un set  de las claves:
		Collection<Cliente> valores = clientes.values();
		Set<Integer> claves = clientes.keySet();
		
		valores.forEach(System.out::println);//println es una referencia a metodo
		claves.forEach(System.out::println);
		
		System.out.println("-----------------");
		System.out.println("-----------------");
		
		for (Integer clave : clientes.keySet()) {
			System.out.println(clave);
		}
		for(Cliente cli : clientes.values()) {
			System.out.println(cli);
		}
		
	}
}
