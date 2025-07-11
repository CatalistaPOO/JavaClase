package modelo.otro;

import modelo.Dibujable;

public class Cliente implements Dibujable{
	private int id;
	private String nombre;
	@Override
	public void dibujar() {
		System.out.println("Cliente dibujado");
	}
	
	
	
	
}
