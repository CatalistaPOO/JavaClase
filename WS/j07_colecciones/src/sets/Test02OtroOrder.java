package sets;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test02OtroOrder {
	public static void main(String[] args) {
		
		Set<String> set= new TreeSet<>(new StringComparatorCantLetras());
				
		set.add("uno");
		set.add("dos");
		set.add("tres");
		set.add("cuatro");
		set.add("cinco");
		set.add("AS");
		set.add("ZAPATO");
		set.add("Ávila");
		set.add("ágil");
		
		for  (String s : set) {
			System.out.println(s);
		}
		
		
		//Usaremos clase anónima que implementa comparator con set02 para ordenarlo
		//Ordena por largo de la palabra de mayor a menor
		Set<String> set02 = new TreeSet<String>(new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		
		//cargar el set02 con los valores que tienen cargado set
		set02.addAll(set);
		for (String s : set02) {
			System.out.println(s);
		}
		
	}
}