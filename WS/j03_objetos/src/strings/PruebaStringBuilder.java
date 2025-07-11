package strings;

public class PruebaStringBuilder {
	public static void main(String[]args) {
		
		StringBuilder sb = new StringBuilder("Hola");
		sb.append (" que tal?");
		System.out.println(sb);
		
		String cadena = "Hola";
		cadena = cadena + " que tal?";
		System.out.println(cadena);
		
		
		
	}
}
