package com.getafe.tienda.negocio;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.persistencia.ProductoDao;
import com.getafe.tienda.persistencia.ProductoDaoImpl;

public class TiendaImpl implements Tienda {
	
	private ProductoDao pDao;
	
	public TiendaImpl() {
		pDao = new ProductoDaoImpl();
	}

	@Override
	public Set<Producto> getProductos() {
		Set<Producto> resu = new TreeSet<Producto>(getComparatorProductoDesc());//al treeset le pasamos del metodo getComparatorProductoDesc
		resu.addAll(pDao.findAll());
		return resu;
	}

	@Override
	public Set<Producto> getProductos(String descripcion) {
		Set<Producto> resu = new TreeSet<Producto>(getComparatorProductoDescLambda());
		resu.addAll(pDao.findByDescripcion(descripcion));
		return resu;
	}
	
	private Comparator<Producto> getComparatorProductoDesc(){
		// Usamos una clase anónima para retornar un objeto que implementa la interfaz Comparator.
		// Como Comparator es una interfaz funcional (solo tiene el método 'compare'), podríamos
		//reemplazar esta clase anónima con una expresión lambda.
		return new Comparator<Producto>() {
			@Override
			public int compare(Producto o1, Producto o2) {
				Collator col = Collator.getInstance(new Locale("es"));
				return col.compare(o1.getProducto(), o2.getProducto());
			}
		};
	}
	
	
	//Aquí Los metodos hacen lo mismo que getComparatorProductoDesc,hay varios para ver diferentes maneras de usar Lambda
	private Comparator<Producto> getComparatorProductoDescLambda(){
//		Collator col = Collator.getInstance(new Locale("es"));
//		return (p1,p2) -> col.compare(p1, p2);
		
		return (p1,p2) -> {
			Collator col = Collator.getInstance(new Locale("es"));
			return col.compare(p1.getProducto(), p2.getProducto());
		};
	}
	
	private Comparator<Producto> getComparatorProductoIdLambda(){
		return (p1,p2) -> p1.getIdProducto() - p2.getIdProducto();
	}

}
