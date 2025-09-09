package com.getafe.tienda.vista;

import java.io.IOException;
import java.util.Set;

import com.getafe.tienda.modelo.Fabricante;
import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.negocio.Tienda;
import com.getafe.tienda.negocio.TiendaImpl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tienda/*")
public class Controller extends HttpServlet {

	private Tienda neg;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		switch(path) {
		case "/informacion":
			req.setAttribute("origen", "el que te envio esto fui yo, el Controlador!!!");
			req.getRequestDispatcher("/WEB-INF/informacion").forward(req, resp);
			break;
		case "/menu_principal":
			req.getRequestDispatcher("/WEB-INF/vista/menu_principal.jsp").forward(req, resp);
			break;
		case "/listado_productos":
			req.getRequestDispatcher("/WEB-INF/vista/listado_productos.jsp").forward(req, resp);
			break;
		case "/alta_producto":
			Set<Fabricante> fabs = neg.getFabricantes();
			req.setAttribute("fabs", fabs);
			req.getRequestDispatcher("/WEB-INF/vista/alta_producto.jsp").forward(req, resp);
			
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		String descripcion;
		switch(path) {
		case "/listado_productos":
			descripcion = req.getParameter("descripcion");
			//se crea un set que recibe los fabricantes de la base
			//de datos a través de negocio(TiendaImpl.java) para cargarlos en el desplegable de listado de productos
			Set<Producto> prods;
			if(descripcion != null && descripcion.length() > 0) {
				prods = neg.getProductos(descripcion);
			} else {
				prods = neg.getProductos();
			}
			req.setAttribute("prods", prods);
			req.getRequestDispatcher("/WEB-INF/vista/listado_productos.jsp").forward(req, resp);
			break;
		case "/alta_producto":
			descripcion = req.getParameter("descripcion");
			String precioStr = req.getParameter("precio");
			String idFabStr = req.getParameter("idFabricante");
			double precio;
			Fabricante fab;
			//Chequeo de parametros recibidos
			if(!isEmpty(descripcion)
				&& !isEmpty(precioStr)
				&& !isEmpty(idFabStr)
				&& isDouble(precioStr)
				&& isInteger(idFabStr)
				&& (precio = Double.parseDouble(precioStr)) > 0
				&& (fab = neg.getFabricante(Integer.parseInt(idFabStr))) != null) {
				req.setAttribute("producto", descripcion);
				try {
					neg.crearProducto(new Producto(descripcion, precio,fab));
					req.getRequestDispatcher("/WEB-INF/vista/alta_producto_ok.jsp").forward(req,resp);
				}catch (Exception e) {
					req.getRequestDispatcher("/WEB-INF/vista/alta_producto_ok.jsp").forward(req,resp);
				}
				
			}else
				//deberíamos cerrar sesion (pero no tenemos sesion)
				System.out.println("si tuvieras sesion te mandaba a hacer puñetas");
			
			break;
		}
	}

	@Override
	public void init() throws ServletException {
		neg = new TiendaImpl();
		
		ServletContext app = getServletContext();
		
		app.setAttribute("home", app.getContextPath() + "/tienda");
		app.setAttribute("css", app.getContextPath() + "/css");
	}
	
	//Este metodo chequea si hay vacíos o nulos
	public boolean isEmpty(String param) {
		return param == null && param.trim().length() == 0;
	}
	
	//Este metodo para recibir si es vacío, si es nulo o si encuentra una cosa diferente a numero decimal
	public boolean isDouble(String num) {
		try {
			Double.parseDouble(num);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	//Este metodo para recibir si es vacío, si es nulo o si encuentra una cosa diferente a numero entero
	public boolean isInteger(String num) {
		try {
			Double.parseDouble(num);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
