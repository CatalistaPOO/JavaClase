package com.getafe.tienda.negocio;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.getafe.tienda.modelo.Fabricante;
import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.modelo.Usuario;
import com.getafe.tienda.persistencia.FabricanteDao;
import com.getafe.tienda.persistencia.FabricanteDaoImpl;
import com.getafe.tienda.persistencia.ProductoDao;
import com.getafe.tienda.persistencia.ProductoDaoImpl;
import com.getafe.tienda.persistencia.UsuarioDao;
import com.getafe.tienda.persistencia.UsuarioDaoImpl;

public class TiendaImpl implements Tienda {

	private ProductoDao pDao;
	private FabricanteDao fDao;
	private UsuarioDao uDao;
	
	public TiendaImpl() {
		pDao = new ProductoDaoImpl();
		fDao = new FabricanteDaoImpl();
		uDao = new UsuarioDaoImpl();
	}
	
	@Override
	public Set<Producto> getProductos() {
		Set<Producto> resu = new TreeSet<Producto>(getComparatorProductoDesc());
		resu.addAll(pDao.findAll());
		return resu;
	}

	@Override
	public Set<Producto> getProductos(String descripcion) {
		Set<Producto> resu = new TreeSet<Producto>(getComparatorProductoDescLambda());
		resu.addAll(pDao.findByDescripcion(descripcion));
		return resu;
	}
	
	@Override
	public Set<Fabricante> getFabricantes() {
		Set<Fabricante> resu = new TreeSet<Fabricante>(getComparatorFabricanteNombre());
		resu.addAll(fDao.findAll());
		return resu;
	}
	
	@Override
	public Fabricante getFabricante(int idFabricante) {
		return fDao.findById(idFabricante);
	}
	
	@Override
	public Set<Fabricante> getFabricantesActivos() {
		Set<Fabricante> resu = new TreeSet<Fabricante>(getComparatorFabricanteNombre());
		resu.addAll(fDao.findOnlyActive());
		return resu;
	}
	
	@Override
	public void crearProducto(Producto p) {
		pDao.save(p);
	}

	private Comparator<Producto> getComparatorProductoDesc(){
		return new Comparator<Producto>() {
			@Override
			public int compare(Producto o1, Producto o2) {
				Collator col = Collator.getInstance(new Locale("es"));
				return col.compare(o1.getProducto(), o2.getProducto());
			}
		};
	}
	
	private Comparator<Producto> getComparatorProductoDescLambda(){
//		Collator col = Collator.getInstance(new Locale("es"));
//		return (p1,p2) -> col.compare(p1.getProducto(), p2.getProducto());
		
		return (p1,p2) -> {
			Collator col = Collator.getInstance(new Locale("es"));
			return col.compare(p1.getProducto(), p2.getProducto());
		};
	}
	
	private Comparator<Producto> getComparatorProductoIdLambda(){
		return (p1,p2) -> p1.getIdProducto() - p2.getIdProducto();
	}

	private Comparator<Fabricante> getComparatorFabricanteNombre(){
		Collator col = Collator.getInstance(new Locale("es"));
		return (f1,f2) -> col.compare(f1.getFabricante(), f2.getFabricante());		
	}

	@Override
	public boolean crearUsuario(Usuario u) {
		return uDao.save(u);
	}

	@Override
	public Usuario validaUsuario(String usr, String pwd) {
		return uDao.valida(usr, pwd);
	}
}
