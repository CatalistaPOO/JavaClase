package ejercicios.ejercicios05;

public class Ej07 {
	
	public static void main(String[] args) {
//		Escribe un programa que verifique si un número es un número Armstrong, es decir, si la suma
//		de cada uno de sus dígitos elevado a la cantidad de dígitos es igual al número. Por ejemplo,
//		el número 371 es un numero de Armstrong, ya que 3^3 + 7^3 + 1^3 = 27 + 343 + 1 = 371.
//		Números de Armstrong para probar: 371, 8_208, 4_210_818
		
		int  seraNumArmstrong = 371;
		System.out.println(esNumeroArmstrong(seraNumArmstrong));
		
	}

	public static boolean esNumeroArmstrong(int nCheck){
		String nToString = String.valueOf(nCheck);
		double suma = 0;
		for (int i = 0; i <nToString.length(); i++) {
			double d1 = Character.getNumericValue(nToString.charAt(i));
			double d2 = nToString.length();
			System.out.println("Digito " + i + "del numero " + nCheck + ": " + d1);
			suma += Math.pow(d1,d2);
			System.out.println(nToString.length());
			System.out.println(suma);
		}
		return suma == Double.valueOf(nCheck);
	}
}