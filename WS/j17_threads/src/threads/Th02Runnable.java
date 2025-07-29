package threads;

public class Th02Runnable implements Runnable{
	private String mensaje;
	
	public Th02Runnable(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public void run () {
		// con start
		while (true) {
			System.out.println(mensaje);
		}
	}
	
	public static void main(String[] args) {
		
		Th02Runnable h1 = new Th02Runnable("Soy el primero");
		//al heredar de runnable implementa run y con start ejecuta un nuevo hilo que llama al metodo run al que hemos hecho Override 
		new Thread(h1).start();
	
		
		Th02Runnable h2 = new Th02Runnable("Soy el segundo");
		//al heredar de runnable implementa run y con start ejecuta un nuevo hilo que llama al metodo run al que hemos hecho Override
		new Thread(h2).start();
	
		
		Th02Runnable h3 = new Th02Runnable("Soy el tercero");
		//al heredar de runnable implementa run y con start ejecuta un nuevo hilo que llama al metodo run al que hemos hecho Override
		new Thread(h2).start();
		
	}
}