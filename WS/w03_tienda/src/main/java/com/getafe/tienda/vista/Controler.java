package com.getafe.tienda.vista;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home/*")//atiende a home y a todas sus subcarpetas
public class Controler extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getPathInfo();
		
		//lo primero es hacer un switch para acceder a diferentes peticiones.
		switch(path) {
		case "/informacion":
			//creamos un mapa para pasar información a Info.java (2 vlores (clave "origen",valor "el que te envió esto fui yo..."))
			req.setAttribute("origen", "el que te envió esto fui yo, el Controlador!!");
			//forward se encarga de reenviar la petición al otro servlet de información (en archivo Info.java), para cada acceso a la parte privada(/WEB-INF)
			req.getRequestDispatcher("/WEB-INF/informacion").forward(req, resp);
			break;
		case"/menu_principal":
			req.getRequestDispatcher("/WEB-INF/vista/menu_principal.jsp").forward(req, resp);
			break;
		case "/listado_productos":
			req.getRequestDispatcher("/WEB-INF/vista/listado_productos.jsp").forward(req, resp);
			break;
			}
	}
	
	
	@Override
	public void init() throws ServletException {
		//definimos la variable home y css utilizando
		ServletContext app = getServletContext();
		
		//home 
		app.setAttribute("home", app.getContextPath() + "/home");
		//css
		app.setAttribute("css", app.getContextPath() + "/css");
		}
}
