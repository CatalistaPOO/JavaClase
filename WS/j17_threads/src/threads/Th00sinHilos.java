package threads;

public class Th00sinHilos {
	private String mensaje;
	
	public Th00sinHilos(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void run () {
		while (true) {			
			System.out.println(mensaje);
		}
	}
	
	public static void main(String[] args) {
		Th00sinHilos h1 = new Th00sinHilos("Soy el primero");
		Th00sinHilos h2 = new Th00sinHilos("Soy el segundo");
		Th00sinHilos h3 = new Th00sinHilos("Soy el tercero");
	}
}