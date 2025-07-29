package threads;

public class Th01Thread extends Thread{
	private String mensaje;
	
	public Th01Thread(String mensaje) {
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
		Th01Thread h1 = new Th01Thread("Soy el primero");
		h1.start();//Este metodo ejecuta un nuevo hilo que llama a run
		
		Th01Thread h2 = new Th01Thread("Soy el segundo");
		h1.start();//Este metodo ejecuta un nuevo hilo que llama a run
		
		Th01Thread h3 = new Th01Thread("Soy el tercero");
		h1.start();//Este metodo ejecuta un nuevo hilo que llama a run
	}
}