package ejercicios.ejercicios06;

public class Ej04 {
	public static void main(String[] args) {
//		Suma de los dígitos de un número natural.
		int n = 1234;
		
		System.out.println(sumaDigitos(n));
	}
	
	public static int sumaDigitos(int num) {
		String cantidadDigitos = String.valueOf(num);
		int[] digitos = new int[cantidadDigitos.length()];
		//int index = 0;
		if (num / 10 < 1) {
			return digitos[0];
		}
//		return num / (int)Math.pow(10, cantidadDigitos.length() - index--);//1234
		return num / 10 + sumaDigitos(num / cantidadDigitos.length()-1);//1234
	}
}
//1234 /quedarse con 1 si divides entre la longitud (length)que no abarca la ultima cifra