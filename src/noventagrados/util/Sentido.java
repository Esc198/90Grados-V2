package noventagrados.util;

/**
 * Enumera los cuatro sentidos posibles de movimiento (vertical y horizontal),
 * incluyendo métodos para consultar los desplazamientos en filas y columnas.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 2.0
 * 
 */
public enum Sentido {

	/**
	 * Valor de la direccion arriba y izquierda(norte).
	 */
	VERTICAL_N(-1, 0),

	/**
	 * Valor de la direccion abajo y derecha(sur).
	 */
	VERTICAL_S(1, 0),

	/**
	 * Valor de la direccion derecha(este).
	 */
	HORIZONTAL_E(0, 1),

	/**
	 * Valor de la direccion izquierda(oeste).
	 */
	HORIZONTAL_O(0, -1);

	/**
	 * Desplazamiento en filas.
	 */
	private int desplazamientoEnFilas;

	/**
	 * Desplazamiento en columnas.
	 */
	private int desplazamientoEnColumnas;

	/**
	 * Constructor de Sentido.
	 * 
	 * @param desplazamientoEnFilas    Desplazamiento en las filas
	 * @param desplazamientoEnColumnas Desplazamiento en las columnas
	 */
	private Sentido(int desplazamientoEnFilas, int desplazamientoEnColumnas) {
		this.desplazamientoEnFilas = desplazamientoEnFilas;
		this.desplazamientoEnColumnas = desplazamientoEnColumnas;
	}

	/**
	 * Devuelve el desplazamiento en las filas.
	 * 
	 * @return int desplazamiento en las filas
	 */
	public int consultarDesplazamientoEnFilas() {
		return desplazamientoEnFilas;
	}

	/**
	 * Devuelve el desplazamiento en las columnas.
	 * 
	 * @return int desplazamiento en las columnas
	 */
	public int consultarDesplazamientoEnColumnas() {
		return desplazamientoEnColumnas;
	}

}
