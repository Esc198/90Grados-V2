package noventagrados.textui.excepcion;

public class OpcionNoDisponibleException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

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
