package tests;

import miscolecciones.genericos.Lista;
import miscolecciones.genericos.ListaEnlazada;

public class Test02Genericos {
	public static void main(String[] args) {
		
		Lista<Integer> listaNum = new ListaEnlazada<>();
		
		listaNum.agregar(7);
		listaNum.agregar(45);
		listaNum.agregar(79);
		listaNum.agregar(-34);
		listaNum.agregar(2);
		
		for (int i= 0; i < listaNum.largo(); i++) {
			System.out.println(listaNum.buscar(i));
		}		
	}
}