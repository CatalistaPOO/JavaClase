package sets;

import java.util.Comparator;

public class PruebaComparator {
	public static void main(String[] args) {
		Comparator<String> comp = new StringComparatorCantLetras();
		
		System.out.println(comp.compare("un String largo", "Un String largo pero muy largo"));//usando comparator
		System.out.println("un String largo".compareTo("Este uno muy largo muy largo"));//usando orden natural
	}
}
