package sets;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import modelo.Cliente;

public class Class04ComparatorCliente {
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(15,"Adriana", "Jimenez", "Perez");
		Cliente c2 = new Cliente(123,"Juan", "Perez", "López");
		Cliente c3 = new Cliente(168,"Pedro", "Vacis", "Miranda");
		Cliente c4 = new Cliente(516,"Susana", "García", "Pinto");
		Cliente c5 = new Cliente(125,"Adriana", "Jimenez", "Perez");//podría haber dos iguales (c1 y c5)
		
		
		System.out.println("Orden natural de set: ");
		Set<Cliente> clientes = new TreeSet<Cliente>();
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		clientes.add(c5);
		
		 
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		System.out.println("-----");
		
		
		System.out.println("Orden por metodo getComparatorApellidos() de set2(clon set): ");
		//creamos el TreeSet de tipo Cliente y usamos el método estático de la clase
		//cliente para ordenar por apellido y finalmente por idCliente para indicar que usafremos ese orden en el objeto
		//cuando lo "rellenamos" con addAll.
		Set<Cliente> clientes2 = new TreeSet<Cliente>(Cliente.getComparatorApellidos());
		clientes2.addAll(clientes);
		
		for (Cliente cli : clientes2) {
			System.out.println(cli);
		}
		System.out.println();
		
//		//Entry recoge pares de valor, un set de Entry sera todo el mapa en una Set
//		Set<Entry<Integer,Cliente>> entries = clientes.entrySet();//clientes.entrySet();
//		
//		System.out.println(entries.getClass().getName());
//		
//		for (Entry<Integer , Cliente> entrada : entries) {
//			System.out.println(entrada.getKey() + ":" + entrada.getValue());
//		}
//		
//		//Map ha incorporado el método ForEach
//		clientes.forEach((id,cli) -> System.out.println(id + ": " + cli))
//		
	}
}
