package miscolecciones.genericos;

public class ListaArray<T> implements Lista<T>{
	//propiedades
	private Object[]almacen;
	private int cant;
	
	//constructores
	public ListaArray() {
		//por defecto damos 10 elementos al crear el array
		this(10);
	}
	
	public ListaArray(int tamnyo) {
		super();
		almacen = new Object[tamnyo];
	}
	
	//metodos de interface
	@Override
	public void agregar(T dato) {
		// debemos indicar un lugar y cuando se llena crear otro nuevo
		if(almacen.length == cant) {
			redimensionar();
		}
		almacen[cant++] = dato; //obtiene cantidad y le añade dato despues
		
	}

	@Override
	public T eliminar(int pos) {
		// a partir de pos, si es valido, copia los elementos un puesto atras
		
		return null;
	}

//	@SuppressWarnings("unchecked")//desactiva warning en este metodo
	@Override
	public T buscar(int pos) {
		//Si mandan posicion incorrecta retorna null (podría haber retornado un exception)
		if(pos < 0 || pos >= cant)
			return null;
		return (T)almacen[pos];//casting
	}

	@Override
	public boolean vacia() {
		// Comprobar si está vacío mediante expresion booleana
		return cant == 0;
	}

	@Override
	public int largo() {
		// Devuelve cantidad de elementos
		return cant;
	}
	
	//metodos propios
	private void redimensionar() {
		//crea un nuevo array del tamaño duplicado del que había y
		//ese nuevo copia elementos y despues sobreescribe manteniendo nombre propiedad (almacen)
		Object[] nuevo = new Object[almacen.length * 2];
		for (int i = 0; i < almacen.length; i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}
	
}
