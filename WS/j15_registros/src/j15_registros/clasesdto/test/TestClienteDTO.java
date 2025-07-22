package j15_registros.clasesdto.test;

import registrosdto.ClienteDTO;

public class TestClienteDTO {
	public static void main(String[] args) {
		ClienteDTO cli = new ClienteDTO(456, "De la Fuente", 123456, "VIP");
		ClienteDTO cli2 = new ClienteDTO(456, "De la Fuente", 123456, "VIP");
		ClienteDTO cli3 = new ClienteDTO(222, "Otro Distinto", 7654, "VIP");
		
//		System.out.println(cli.getApellidos());
		System.out.println(cli.apellidos());
		
		
		System.out.println(cli);
		
		System.out.println(cli.equals(cli2));
		System.out.println(cli.equals(cli3));
	
				
	}
}
