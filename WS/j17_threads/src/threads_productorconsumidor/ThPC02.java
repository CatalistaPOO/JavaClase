package threads_productorconsumidor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import threads.ThreadUtil;

public class ThPC02 {
	
//	private static final Queue<Integer> buffer = new LinkedList<Integer>();En vez de usar linked list usaremos LinkedBlockingQueue
	private static final int CAPACIDAD = 5;
	private static final LinkedBlockingDeque<Integer> buffer = new LinkedBlockingDeque(CAPACIDAD);
	private static final int CANT_PROD = 2;
	private static final int CANT_CONS = 9;
	private static int valor= 0;
	private static final Object LOCK = new Object();
	
	public static void main(String[] args) {
		
		Runnable productor = ()-> {
			while (true) {
				ThreadUtil.sleep();//llamada a nuestra clase para tiempos aleatorios
				synchronized (LOCK) {
					
					while(buffer.size() == CAPACIDAD) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					buffer.offer(valor);
					System.out.println(Thread.currentThread().getName() + " produjo " + valor);
					System.out.println("--------------");
					valor ++;
					LOCK.notifyAll();//Avisa a todos los hilos de que se ha producido
						
					//control innecesario 
					if(buffer.size() > CAPACIDAD) {
						System.err.println("Error se produjeron  " + buffer.size());
						System.exit(1);//cualquier cosa diferente de 0 será un error (por convención)
						}
					}
				}
			
		};
		
		Runnable consumidor = () -> {
			while(true) {
				synchronized (LOCK) {
					while(buffer.size() == 0) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
							
						int v = buffer.poll();//no permite extraer si no hay nada, lanza excepcion
						System.out.println(Thread.currentThread().getName()+ " consumio " + v);
						System.out.println("~~~~~~~~~~~");
						LOCK.notifyAll();
						
						//control innecesario
						if (buffer.size()<0) {
							System.out.println("Error el tamaño del buffer es " + buffer.size());
							System.exit(1);
						}
				}
			}
		};
		
		//Generamos varios consumidores y productores
		for (int i = 0; i <= CANT_PROD; i++) {
			new Thread(productor, "productor" + i).start();
			
		}
		for (int i = 0; i <= CANT_CONS; i++) {
			new Thread(consumidor, "consumidor" + i).start();
			
		}
		
	}
}
