package interfaces;

public class Implementacion implements EjemploInterfaz {

	//De la clase EjemploInterfaz tenemos metodos abstractos que OBLIGA a implementar
	@Override
	public void procesa(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int otroProceso() {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	De la clase EjemploInterfaz tenemos metodos default(hecerAlgo()) que
	// PODRIAMOS sobeescribir(sin que sea obligatorio)
	@Override
	public void haceAlgo() {
		// TODO Auto-generated method stub
		EjemploInterfaz.super.haceAlgo();
	}
	
}