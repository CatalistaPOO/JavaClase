package com.getafe.tienda.vista;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WEB-INF/informacion")
public class Info extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//creamos una variable para escribir una respuesta al usuario
		PrintWriter out = resp.getWriter();
		//imprimimos en consola el envío de informacion desde Controller.java 
		System.out.println(req.getAttribute("origen"));
		
		//todo esto saldrá en el navegador cuando pulsemos info del menu principal
		out.println("METODOS DE LA PETICION");
		out.println("req.getCharacterEncoding()" + req.getCharacterEncoding());
		out.println("req.getContentType()" + req.getContentType());
		out.println("req.getContextPath()" + req.getContextPath());
		out.println("req.getLocalAddr()" + req.getLocalAddr());
		out.println("req.getLocalPort()" + req.getLocalPort());
		out.println("req.getMethod()" + req.getMethod());
		out.println("req.getProtocol()" + req.getProtocol());
		out.println("req.getRemoteAddr()" + req.getRemoteAddr());
		out.println("req.getRequestURI()" + req.getRequestURI());
		out.println("req.req.getPathInfo()" + req.getPathInfo());
		
	}
}
