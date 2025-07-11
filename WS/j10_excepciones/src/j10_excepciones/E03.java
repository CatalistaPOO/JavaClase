package j10_excepciones;

import java.sql.SQLException;

public class E03 {
	
	public static void main(String[] args) {
		//al contemplar con excepción no saltará error
		try {
			metodo(-5);
		} catch (SQLException e) {
			System.out.println("Esto arregla el problema");
			e.printStackTrace();
		}
		System.err.println("Continua el programa");//redirecciona el error a otra salida que no sea pantalla(se muestra en rojo en consola)
		
		otroMetodo(66);
		
	}
	
	
	public static void otroMetodo(int num) {
		try {
			problematico(44);
		} catch (SQLException e) {
			// el cuerpo de catch contendría la solucion al problema
			e.printStackTrace();
		}
	}
	
	
	public static void metodo(int num)throws SQLException {
		problematico(78);//este caso no resuelve el posible problema cuando pasamos un int inválido
		System.out.println("todo fenomenal");
	}
	
	
	public static void problematico(int valor) throws SQLException {
		if (valor == 0)
			throw new IllegalArgumentException();// no obliga a avisar en el metodopor que es runtime (o uncatched)
		if (valor < 0)
			throw new SQLException("Esto ha explotado!!");//obliga a avisar en el metodo con throws (catched)
	}
	
	
}
