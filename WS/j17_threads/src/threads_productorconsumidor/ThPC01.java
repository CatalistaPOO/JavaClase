package threads_productorconsumidor;

import java.util.LinkedList;
import java.util.Queue;

import threads.ThreadUtil;

public class ThPC01 {
	
	private static final Queue<Integer> buffer = new LinkedList<Integer>();
	private static final int CAPACIDAD = 5;
	private static int valor= 0;
	
	public static void main(String[] args) {
		
		Runnable productor = ()-> {
			while (true) {
				ThreadUtil.sleep();//llamada a nuestra clase
				if(buffer.size() < CAPACIDAD) {
					buffer.offer(valor);
					System.out.println(Thread.currentThread().getName() + "produjo " + valor);
					System.out.println("--------------");
					valor ++;
					
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
				ThreadUtil.sleep();
				if(buffer.size() > 0) {
					int v = buffer.poll();
					System.out.println(Thread.currentThread().getName()+ "consumio " + v);
					System.out.println("~~~~~~~~~~~");
					
					//control innecesario
					if (buffer.size()<0) {
						System.out.println("Error el tamaño del buffer es " + buffer.size());
						System.exit(1);
					}
				}
			}
		};
		//Al haber dos unicos hilo para productor y consumidor no hay problema
		//si hubiese muchos consumidores y productores podrían entrar dos al mismo tiempo lo que genera error
		new Thread (productor, "productor").start();
		new Thread (consumidor, "consumidor").start();
	}
}
