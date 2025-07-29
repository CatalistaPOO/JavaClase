package threads;

public class Th03Estados1  {
	public static void main(String[] args) throws InterruptedException {
		
		Thread th1 = new Thread();
		System.out.println(th1.getState());//new
		
		th1.start();
		System.out.println(th1.getState());//runnable
		
		//ponemos a dormir con la clase ThreadUtil (para evitar manejar la excepcion si usaramos  la clase Thread)
		//el hilo de main 200milisegundos para que el hilo th1 tenga tiempo de ejecutarse y aparezca terminated
		ThreadUtil.sleep(200);
		
		System.out.println(th1.getState());//terminated
		}
}