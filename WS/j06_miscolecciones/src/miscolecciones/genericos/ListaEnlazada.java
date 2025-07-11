
//Este package hace que tanto ListaEnlazada como ListaArray funcionen 
//con cualquier tipo de dato (object, int,String...) a diferencia de la coleccion miscolecciones
//que funciona unicamente con Strings
package miscolecciones.genericos;

public class ListaEnlazada<T> implements Lista<T> {
	//atributos
	private Nodo primero;
	private Nodo ultimo;
	private int cant;

	
	//GettersSetters
	@Override
	public void agregar(T dato) {
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
	public T eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T buscar(int pos) {
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
		// // Devuelve cantidad de elementos
		return cant;
	}
	
	//CLASE INTERNA, al ser interna puede 
	//tener modificadores de acceso como un metodo(friendly, public,private, protected)
	 private class Nodo{
		T dato;
		Nodo siguiente;//hace referencia al espacio del siguiente elemento (en su direccion de memoria)
		
		//constrctor de la  clase interna Nodo
		Nodo(T dato){
			this.dato = dato;
		}
	}

	
	
}
