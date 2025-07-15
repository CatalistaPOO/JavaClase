package agenda.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class Config {
	//queremos obtener el dataSource usando Singleton: si esta vacío lo crea, si no lunicamente lo devuelve.
	
	private static DataSource ds;
	private static Properties prop;
	
	private Config(){};//Este constructor, impide hacer nuevos objetos iguales al ser privado, y si se da el caso de herencia, serán el mismo objeto.
	
	public static DataSource getDataSource() {
		if (ds == null) {
			BasicDataSource bds = new BasicDataSource();
			Properties prop = getProp();
			bds.setUrl(prop.getProperty("bbdd.url"));
			bds.setDriverClassName(prop.getProperty("bbdd.driver"));
			bds.setUsername(prop.getProperty("bbdd.user"));
			bds.setPassword(prop.getProperty("bbdd.password"));
			ds = bds;
		}
		return ds;
	}
	
	private static Properties getProp() {
		//coge el fichero properties lo lee y lo mete en las propiedades para usar con la base de datos(si está vacío busca fichero de pares
		if(prop == null) {
			prop = new Properties();
			try (FileReader fr = new FileReader("app.properties")){
				prop.load(fr);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("No se puede leer el fichero app.properties");
			}
		}
		return prop;
	}
	
}
