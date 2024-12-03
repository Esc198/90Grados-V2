
package noventagrados.util;

/**
 * Enumera los tipos de piezas de ajedrez (PEON y REINA), asociando cada tipo
 * con un carácter ('P' para peón y 'R' para reina).
 *
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 2.0
 *
 */
public enum TipoPieza {
	/**
	 * Valor que representa el peón.
	 */
    PEON('P'),
    
	/**
	 * Valor que representa la reina.
	 */
    REINA('R');

	/**
	 * Carácter que representa el tipo de pieza.
	 */
    private char caracter;

    /**
     * Constructor que asocia un carácter a cada tipo de pieza.
     *
     * @param letra el carácter que representa el tipo de pieza
     */
    TipoPieza(char letra) {
        caracter = letra;
    }

    /**
     * Devuelve el carácter perteneciente al tipo de pieza.
     *
     * @return el carácter que representa el tipo de pieza
     */
    public char toChar() {
        return caracter;
    }
}

