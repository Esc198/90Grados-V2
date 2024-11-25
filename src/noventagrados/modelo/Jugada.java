package noventagrados.modelo;

/**
 * Tipo registro que almacena las celdas de origen y destino de un movimiento,
 * con un método que devuelve las coordenadas en formato de texto.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 2.0
 * 
 * @param origen  Celda de origen
 * @param destino Celda de destino
 */
public record Jugada(Celda origen, Celda destino) {
	/**
	 * Metodo que devuelve las coordenadas de origen y destino en formato de texto
	 * 
	 * @return String texto con las coordenadas de origen y destino
	 */
	public String aTexto() {
		// Devolver el texto asociado al par de coordenadas de las celdas (e.g.,
		// "00-11", "23-45")
		return origen.consultarCoordenada().aTexto() + "-" + destino.consultarCoordenada().aTexto();
	}

}
