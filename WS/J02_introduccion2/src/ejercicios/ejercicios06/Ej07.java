package ejercicios.ejercicios06;

public class Ej07 {
	public static void main(String[] args) {
//		Imprimir un valor decimal en binario
		System.out.println(binario(25));
	}
	
	public static String binario(int numero) {
		if (numero == 0) {
		return "0";
		}
		if (numero == 1) {
			return "1";
		}
		return binario(numero / 2) + (numero % 2);
	}
}