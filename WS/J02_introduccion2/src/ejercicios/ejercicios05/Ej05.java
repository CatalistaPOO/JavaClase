package ejercicios.ejercicios05;

public class Ej05 {
	public static void main(String[] args) {
//		Dos números son "amigables" si la suma de los divisores propios de uno es igual al otro. Por
//		ejemplo, los divisores propios de 8 son: 1, 2 y 4 y la suma de éstos 1 + 2 + 4 = 7; luego 8 es un
//		número amigo de 7. Escribe un método que determine si dos números dados son amigables.
		
		int seraAmigable= 8;
		int nAmigable = 7;
		System.out.println(esAmigable(seraAmigable, nAmigable));
		
	}
	
	public static boolean esAmigable(int num, int num2) {
		int sumDivisores = 0;
		for (int i = 1; i < num2 ;i++) {
			if(num % i == 0) {
				System.out.println(i);
				sumDivisores += i;
			}
		}
		return sumDivisores == num2;
	}

}