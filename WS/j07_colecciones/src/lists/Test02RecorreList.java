package lists;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test02RecorreList {
	public static void main(String[] args) {
		
		 final int cant = 200_000;
		 long t0, tf;
		 
		
		List<String> al = new ArrayList<String>(cant);
		List<String> ll = new LinkedList<String>();
		
		cargaLista(al, cant);
		cargaLista(ll,cant);
		
		System.out.println("listas cargadas");
		System.out.println(al.size());
		System.out.println(ll.size());
		
		//tiempo para recorrer al ArrayList correctamente
		t0= System.currentTimeMillis();
		recorre(al);
		tf= System.currentTimeMillis();
		System.out.println("ArrayLlist: " + (tf-t0));
//		
//		//tiempo para recorrer ll (linkedList)de manera incorrecta
//		t0= System.currentTimeMillis();
//		recorre(ll);
//		tf= System.currentTimeMillis();
//		System.out.println("LinkedLlist: " + (tf-t0));
		
		//recorre con metodo usando iterator
		t0= System.currentTimeMillis();
		recorreIterator(ll);
		tf= System.currentTimeMillis();
		System.out.println("LinkedLlist con recorreIterator(): " + (tf-t0));
		
		t0= System.currentTimeMillis();
		recorreForEach(ll);
		tf= System.currentTimeMillis();
		System.out.println("LinkedLlist con recorreForEach(): " + (tf-t0));
		
		
		
		
}
	
	public static void cargaLista(List<String> lista, int cant) {
		for (int i = 0;i< cant;i++) {
			lista.add("objeto" + i);
		}
	}
	
	public static void recorre(List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			String elemento = lista.get(i);
			//trabajo con elemento
			
		}
	}
	
	//La manera correcta de recorrer un ArrayList
	public static void recorreIterator(List<String> lista) {
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			String elemento = it.next();
			//trabajo con elemento
		}
	}
	
	//Este metodo es para mostrar el foreach que en realidad solo funciona
	//con clases que hayan implementado la clase iterable
	public static void recorreForEach(List<String> lista) {
		for (String elemento : lista) {
			
		}
	}
	
}
