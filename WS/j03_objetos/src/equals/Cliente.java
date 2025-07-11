package equals;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellidos;
	
	
	
	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	
	public Cliente (int idCliente, String nombre,String apellidos){
		
	}
	
	
	
	@Override
	public boolean equals(Object otro) {
		//comprobación si hay objeto,si son el mismo objeto, si son la misma clase:
		if (otro == null)return false;
		if (this == otro)return true;
		if (this .getClass()!=otro.getClass()) return false;
		//una vez comprobado, downcasting(especificamos al objeto como el tipo Cliente)
		Cliente o = (Cliente)otro;
		return this.idCliente == o.idCliente;
	}
	
	
	
}
