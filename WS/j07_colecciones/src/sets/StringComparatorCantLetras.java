package sets;

import java.util.Comparator;

//Este mecanismo no se utiliza
public class StringComparatorCantLetras implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// Comparamos objetos, devuelve: positivo, negativo o 0 (mirar interface Comparator)
		return o1.length() - o2.length();
		//<0 va antes que o2
		// = 0 o1 = o2
		//> 0 o1 va después de o2
	}

	
	
}
