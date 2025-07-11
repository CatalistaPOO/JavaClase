package recursividad;

public class R03Palindromo {
	public static void main(String[] args) {
		
		System.out.println(esPalindromo("nopalindromo"));
		System.out.println(esPalindromo("ala"));
		System.out.println(esPalindromo("Dabale arroz a la zorra el Abad"));
		
	}
	
	private static boolean esPalindromoRecursion(String cad) {
		
		if (cad.length() <= 1) {
			return true;
		}
		int ultimo = cad.length() -1;
		return cad.charAt(0) == cad.charAt(ultimo) && esPalindromo(cad.substring(1,ultimo));
	}
	
	//este metodo es para que no forme parte de la recursion, prepara el texto y solo lo hace una vez.
	//Cuando está preparado se hace la llamada a un metodo(privado, ya que es funcionamiento interno de la clase.
	public static boolean esPalindromo(String cad) {
		cad = cad.replace(" ", "");
		cad = cad.toLowerCase();
		return esPalindromoRecursion(cad);
	}
}