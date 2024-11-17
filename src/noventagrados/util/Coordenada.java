package noventagrados.util;

/**
 * Tipo registro que almacena fila y columna en el tablero, con un método que
 * devuelve la posición en formato de texto.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 *
 * @param fila    fila de la coordenada
 * @param columna columna de la coordenada
 * @version 1.0
 * 
 */
public record Coordenada(int fila, int columna) {

	/**
	 * Devuelve la coordenada en formato texto
	 * 
	 * @return String Cadena con la coordenada
	 */
	public String aTexto() {
		return fila + "" + columna;
	}

}
