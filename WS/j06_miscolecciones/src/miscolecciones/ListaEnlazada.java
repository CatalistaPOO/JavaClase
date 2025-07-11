package miscolecciones;

public class ListaEnlazada implements Lista {
	//atributos
	private Nodo primero;
	private Nodo ultimo;
	private int cant;

	
	//GettersSetters
	@Override
	public void agregar(String dato) {
		// Se crea un nodo que tiene el dato y siguiente 
		Nodo nuevo = new Nodo(dato);
		if(primero == null)
			primero = nuevo;
		else
			ultimo.siguiente = nuevo;
		
		ultimo = nuevo;
		cant ++;
		
	}

	@Override
	public String eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscar(int pos) {
		// TODO Auto-generated method stub
		if (pos < 0 || pos >= cant)
			return null;
		
		if (pos == 0)
			return primero.dato;
		
		if(pos == cant-1)
			return ultimo.dato;
		
		return anterior(pos).siguiente.dato;
	}
	
	private Nodo anterior(int pos) {
		Nodo aux = primero;
		for (int i =0 ; i < pos - 1; i++) {
			aux = aux.siguiente;
		}
		return aux;
	}

	@Override
	public boolean vacia() {
		// TODO Auto-generated method stub
	
		return cant == 0;
	}

	@Override
	public int largo() {
		// TODO Auto-generated method stub
		return cant;
	}
	
	//CLASE INTERNA, al ser interna puede 
	//tener modificadores de acceso como un metodo(friendly, public,private, protected)
	 private class Nodo{
		String dato;
		Nodo siguiente;//hace referencia al espacio del siguiente elemento (en su direccion de memoria)
		
		//constrctor de la  clase interna Nodo
		Nodo(String dato){
			this.dato = dato;
		}
	}

	
	
}
