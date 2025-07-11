package interfaces;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test02OtroOrder {
	public static void main(String[] args) {
		//SE DESCRIBE EL PASO DE CREAR UN TREESET POR 3 METODOS:
		
		
		//1-creamos TreeSet estableciendo su orden por Comparator(definido por longitud de mayor a menor)
//		Set<String> set= new TreeSet<String>(new Comparator<String>() {
//			//Definimos compare que es el metodo abstracto
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.length() - o1.length();
//			}
//		});
		
//		//2-Lambda para crear TreeSet ordenado por método del cuerpo
//		Set<String> set = new TreeSet<String>((String o1, String o2)->{
//			return o1.length() - o2.length();
//		});
		
		
		//3-Lambda para crear TreeSet reducido al ser una unica innstruccion que recibe solo Strings
		//el cuerpo es solo una línea fuera llaves y si devuelve algo asume que es un return(fuera return y ; del final de instrucción
		Set<String> set = new TreeSet<String>((o1, o2)-> o1.length() - o2.length());
		
		
		//Llenamos TreeSet, que respetará el orden indicado al crearlo, NO el natural.		
		set.add("uno");
		set.add("dos");
		set.add("tres");
		set.add("cuatro");
		set.add("cinco");
		set.add("AS");
		set.add("ZAPATO");
		set.add("Ávila");
		set.add("ágil");
		
//		for  (String s : set) {
//			System.out.println(s);
//		}
		
		//Diferentes representaciones de lambda, resumiendo cada vez más la expresión lambda
		set.forEach((s)-> System.out.println(s));
		
		set.forEach(s -> System.out.println(s));

		set.forEach(System.out::println);
	}
}