
package noventagrados.textui.excepcion;

/**
 * Excepción que indica que una opción no está disponible.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 */
public class OpcionNoDisponibleException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto de la excepción.
	 */
	public OpcionNoDisponibleException() {
		super();
	}

	/**
	 * Constructor de la excepción.
	 *
	 * @param mensaje Mensaje de error.
	 */
	public OpcionNoDisponibleException(String mensaje) {
		super(mensaje);
	}

	/**
	 * Constructor de la excepción.
	 *
	 * @param mensaje Mensaje de error.
	 * @param causa   Causa de la excepción.
	 */
	public OpcionNoDisponibleException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

	/**
	 * Constructor de la excepción.
	 *
	 * @param causa Causa de la excepción.
	 */
	public OpcionNoDisponibleException(Throwable causa) {
		super(causa);
	}
}
