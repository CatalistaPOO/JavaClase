package threads.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DateFormatter;

//servidor tipo TCP(abre socket tcp para un cliente
public class ServidorChat {
	private int puerto;
	
	public ServidorChat (int puerto) {
		this.puerto = puerto;
	}

	
	public void start() {
		System.out.println("Servidor esperando conexiones...");
		
		try (ServerSocket server = new ServerSocket(puerto)){
			
			while(true) {
				Socket cliente = server.accept();
				new AtiendeCliente(cliente);
				}
			
		} catch (Exception e) {
			System.err.print("no se puede abrir el puerto" + puerto);
		}
	}
	
	
	//clase interna
	private class AtiendeCliente implements Runnable{
		
		private Socket socket;
		private String user;
		private PrintWriter out;
		//uno para todos, por eso static
		private static int cant;
		private static Map<String, AtiendeCliente> sala = new HashMap<>();
		
		public AtiendeCliente(Socket socket) {
			
			this.socket = socket;
			new Thread(this).start();
		}
		
		
		@Override
		public void run() {
			
			log("Nuevo cliente(o inconsciente) conectado");
			
			try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
				this.out = out;
				out.println("Bienvenido al NUEVO GUASÁ!!");
				
				
				out.println("Por favor identifícate");
				user = in.readLine();
				user = user.replaceAll(" ", "_");//sustituye espacios por _
				
				while(sala.containsKey(user) || user.length() == 0) {
					out.println("Usuario incorrecto o ya existe");
					out.println ("Ingresa tu usuario");
					user = in.readLine();
				}
				
				out.println(user + " ya estas en la sala");
				help();
				sala.put(user, this);
				
				cant ++;
				log(user + " se ha conectado");
				log("hay " + cant + " usuarios en la sala");
				difusion("SRV: " + user + " se ha conectado");
				
				String linea;
				while ((linea = in.readLine()) != null) {
					//controla que haya @ y algo (separa el nombre de usuario y el mensaje
					if (linea.length() > 0 && linea.charAt(0)== '@') {
						if (linea.contains(" ")) {
							String usrDestino = linea.substring(1,linea.indexOf(" "));
							String mensaje = linea.substring(linea.indexOf(" ") + 1);
							//si existe el usuario manda el mensaje
							if (sala.containsKey(usrDestino)) {
								sala.get(usrDestino).out.println("PRIVADO DE " + user + ": " + mensaje);
							}
							else {
								out.println(usrDestino + "no está conectado");
							}
						
						}
						else {
							out.println("formato incorrecto. No se ha enviado el mensaje");
						}
					}
					else { //no es un mensaje privado
						switch(linea.toLowerCase()) {
						case "-w" , "who":
							for (String usr : sala.keySet()) {
								out.println("SRV: " + user);
							}
						break;
						case "-h", "help":
							help();
						break;
						
							
						default:
							difusion(user + ": " + linea);
						}
					}
					
				}
				

			}catch(IOException e){
				e.printStackTrace();				
			}
		}
		
		private void log(String mje) {
			System.out.println(now() + " - " +mje);
		}
		
		private String now() {
			LocalDateTime ahora = LocalDateTime.now();//no tiene en cuenta la zona horaria (localDateTime), toma la hora del servidor
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yy hh:mm:ss");
			return dtf.format(ahora);
		}
		
		private void difusion(String mje) {
			for (AtiendeCliente cli  : sala.values()) {
				cli.out.println(mje);
			}
		}
		
		private void help() {
			out.println("-----------------------------------------------------");
			out.println("Ayuda del GUASÁ");
			out.println("-----------------------------------------------------");
			out.println("-q: terminar sesion");
			out.println("-h: mostrar ayuda");
			out.println("-w: consultar usuarios");
			out.println("@usuario mensaje: para mensajes privados");
			out.println("-----------------------------------------------------");
		}
	}
	
	
	
	public static void main(String[] args) {
		new ServidorChat(1234).start();
	}
	
	
}
