package com.getafe.tienda.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getafe.tienda.modelo.Producto;

public class TestJackson02 {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
	    // 1. Define el String JSON a deserializar.
	    // Este String representa un objeto 'Producto' con un objeto 'Fabricante' anidado.
	    // 'idProducto', 'producto', y 'precio' son atributos del 'Producto'.
	    // 'fabricante' es un objeto anidado con sus propios atributos: 'idFabricante' y 'fabricante'.
	    String json = "{\"idProducto\":7,\"producto\":\"Monitor 27 LED Full HD\",\"precio\":245.99,\"fabricante\":{\"idFabricante\":1,\"fabricante\":\"Asus\"}}";
	    
	    // 2. Imprime el String JSON original.
	    // Esta línea se usa para verificar visualmente que el JSON se ha definido correctamente.
	    System.out.println(json);
	    
	    // 3. Crea una instancia de 'ObjectMapper'.
	    // 'ObjectMapper' es la clase principal de la biblioteca Jackson para manejar la conversión
	    // (serialización y deserialización) entre objetos Java y JSON.
	    ObjectMapper mapper = new ObjectMapper();
	    
	    // 4. Deserializa el String JSON en un objeto Java.
	    // 'mapper.readValue(json, Producto.class)' es el método que realiza la magia.
	    // Toma el String 'json' y lo convierte a una instancia de la clase 'Producto'.
	    // La clase 'Producto' (y 'Fabricante' en este caso) debe tener sus atributos con los
	    // mismos nombres que las claves del JSON para que la conversión se realice con éxito.
	    Producto p = mapper.readValue(json, Producto.class);
	    
	    // 5. Imprime el objeto Java.
	    // Si la clase 'Producto' tiene un método 'toString()' sobrescrito, este imprimirá
	    // los valores de sus atributos, demostrando que la deserialización fue exitosa.
	    System.out.println(p);
	}
}
