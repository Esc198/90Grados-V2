package noventagrados.util;

/**
 * Enumera los colores de las piezas de ajedrez, asignando 'B' para blanco y 'N'
 * para negro, con un método para consultar el color contrario.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 * 
 */
public enum Color {
	
	/**
	 * Valor que representa el color Blanco.
	 */
	BLANCO('B'), 
	
	/**
	 * Valor que representa el color Negro.
	 */
	
	NEGRO('N');

	private char letra;

	Color(char letra) {
		this.letra = letra;
	}

	/**
	 * Retorna el color contrario
	 * 
	 * @return Color color contrario
	 */
	public Color consultarContrario() {
		if (letra == 'B') {
			return Color.NEGRO;
		} else {
			return Color.BLANCO;
		}
	}

	/**
	 * Devuelve la letra correspondiente al color (B o N)
	 * 
	 * @return char caracter
	 */
	public char toChar() {
		return letra;
	}

}
