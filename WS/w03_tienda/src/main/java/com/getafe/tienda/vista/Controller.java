package com.getafe.tienda.vista;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getafe.tienda.modelo.Fabricante;
import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.modelo.Usuario;
import com.getafe.tienda.negocio.Tienda;
import com.getafe.tienda.negocio.TiendaImpl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tienda/*")
public class Controller extends HttpServlet {

	private Tienda neg;
	private String home;
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		HttpSession session = req.getSession();
		Set<Fabricante> fabs;
		
		switch(path) {
		case "/login":
			req.getRequestDispatcher("/WEB-INF/vista/login.jsp").forward(req, resp);
			break;
		case "/registro_usuarios":
			req.getRequestDispatcher("/WEB-INF/vista/registro_usuarios.jsp").forward(req, resp);
			break;
		case "/registro_usuarios_respuesta":
			req.getRequestDispatcher("/WEB-INF/vista/registro_usuarios_respuesta.jsp").forward(req, resp);
			break;
		case "/informacion":
			req.setAttribute("origen", "el que te envio esto fui yo, el Controlador!!!");
			req.getRequestDispatcher("/WEB-INF/informacion").forward(req, resp);
			break;
		case "/menu_principal":
			eliminaDatosSession(session);
			req.getRequestDispatcher("/WEB-INF/vista/menu_principal.jsp").forward(req, resp);
			break;
		case "/listado_productos":
			req.getRequestDispatcher("/WEB-INF/vista/listado_productos.jsp").forward(req, resp);
			break;
		case "/alta_producto":
			fabs = neg.getFabricantes();
			req.setAttribute("fabs", fabs);
			req.getRequestDispatcher("/WEB-INF/vista/alta_producto.jsp").forward(req, resp);

			break;
		case "/alta_producto_ok":
			req.getRequestDispatcher("/WEB-INF/vista/alta_producto_ok.jsp").forward(req,resp);
			break;
			
		case "/alta_producto_error":
			req.getRequestDispatcher("/WEB-INF/vista/alta_producto_error.jsp").forward(req,resp);
			break;
		case "/productos_fabricante":
			fabs = neg.getFabricantesActivos();
			req.setAttribute("fabs", fabs);
			req.getRequestDispatcher("/WEB-INF/vista/productos_fabricante.jsp").forward(req,resp);
			break;
		case "/productos_fabricante_json":
			fabs = neg.getFabricantesActivos();
			req.setAttribute("fabs", fabs);
			req.getRequestDispatcher("/WEB-INF/vista/productos_fabricante_json.jsp").forward(req,resp);
			break;
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		HttpSession session = req.getSession();
		String descripcion;
		String idFabStr;
		Fabricante fab;
		String usr,pwd;
		
		switch(path) {
		case "/login":
			 usr = req.getParameter("usr");
			 pwd = req.getParameter("pwd");
			System.out.println(usr);
			System.out.println(pwd);
			break;
		case "/registro_usuarios":
			String nombre = req.getParameter("nombre");
			usr = req.getParameter("usr");
			pwd = req.getParameter("pwd");
			String email = req.getParameter("email");
			if(!isEmpty(nombre)
					 && !isEmpty(usr)
					 && !isEmpty (pwd)
					 && !isEmpty(email)
					 && checkPassword(pwd)){
				 	Usuario nuevo = new Usuario(nombre.trim(), email.trim(), usr.trim(), pwd.trim());
				 	session.setAttribute("nombreUsuario", nombre);
				 	try {
				 		if ( neg.crearUsuario(nuevo)) {
				 			session.setAttribute("resu", "ok");
				 		}else {
				 			session.setAttribute("resu", "error");
				 		}
					} catch (Exception e) {
						session.setAttribute("resu", "existe");
					}
				 	System.out.println("llegue");
				 	resp.sendRedirect(home + "/registro_usuarios_respuesta");
			 }else {
				 //todo mal!!
			 }
			break;
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
			idFabStr = req.getParameter("idFabricante");
			double precio;
			
			//Chequeo de parametros recibidos
			if(!isEmpty(descripcion)
				&& !isEmpty(precioStr)
				&& !isEmpty(idFabStr)
				&& isDouble(precioStr)
				&& isInteger(idFabStr)
				&& (precio = Double.parseDouble(precioStr)) > 0
				&& (fab = neg.getFabricante(Integer.parseInt(idFabStr))) != null) {
				session.setAttribute("producto", descripcion);
				try {
					neg.crearProducto(new Producto(descripcion, precio,fab));
					resp.sendRedirect(home + "/alta_producto_ok");
				}catch (Exception e) {
					resp.sendRedirect(home + "/alta_producto_error");
				}
				
			}else
				//deberíamos cerrar sesion (pero no tenemos sesion)
				System.out.println("si tuvieras sesion te hacía esperar un rato");
			break;
		case "/productos_fabricante":
			idFabStr = req.getParameter("idFabricante");
			if (!isEmpty(idFabStr)
					&& isInteger(idFabStr)
					&& (fab = neg.getFabricante(Integer.parseInt(idFabStr))) != null) {
					session.setAttribute("fab", fab);
					resp.sendRedirect(home + "/productos_fabricante");
			}else {
				//cerrar sesion(si la tuvieramos, que no es el caso) y mostramos fallo
				System.out.println("dio error");
			}	
			break;
		case"/productos_fabricante_json_respuesta":
			idFabStr = req.getParameter("idFabricante");
			System.out.println(idFabStr);
			if (!isEmpty(idFabStr)
					&& isInteger(idFabStr)
					&& (fab = neg.getFabricante(Integer.parseInt(idFabStr))) != null) {
					ObjectMapper  mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(fab.getProductos());
					System.out.println(json);
					resp.getWriter().println(json);
			}else {
				//cerrar sesion(si la tuvieramos, que no es el caso) y mostramos fallo
				System.out.println("dio error");
			}	
			break;
		case  "/registro_usuario_respuesta":
			req.getRequestDispatcher("/WEB-INF/vista/registro_usuario_respuesta.jsp").forward(req, resp);
			break;
		}
	}

	@Override
	public void init() throws ServletException {
		neg = new TiendaImpl();
		
		ServletContext app = getServletContext();
		
		home = app.getContextPath() + "/tienda";
		
		app.setAttribute("home", home);
		app.setAttribute("css", app.getContextPath() + "/css");
	}
	
	//Este metodo chequea si hay vacíos o nulos
	private boolean isEmpty(String param) {
		return param == null || param.trim().length() == 0;
	}
	
	//Este metodo para recibir si es vacío, si es nulo o si encuentra una cosa diferente a numero decimal
	private boolean isDouble(String num) {
		try {
			Double.parseDouble(num);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	//Este metodo para recibir si es vacío, si es nulo o si encuentra una cosa diferente a numero entero
	private boolean isInteger(String num) {
		try {
			Double.parseDouble(num);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	private void eliminaDatosSession(HttpSession sesion) {
		sesion.removeAttribute("fab");
		sesion.removeAttribute("fabs");
		sesion.removeAttribute("prods");
	}
	
	private boolean checkPassword(String pwd) {
		return pwd.trim().length() > 5;
	}
}
