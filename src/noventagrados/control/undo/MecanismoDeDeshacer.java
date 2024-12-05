package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import java.util.Date;

/**
 * Interfaz que define el mecanismo de deshacer.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 * 
 * @see noventagrados.control.Arbitro
 * @see noventagrados.modelo.Jugada
 * @see java.util.Date
 */
public interface MecanismoDeDeshacer {

	/**
	 * Devuelve un clon en profundidad del árbitro en el estado actual.
	 * 
	 * @return Clon en profundidad del árbitro actual.
	 */
	public Arbitro consultarArbitroActual();

	/**
	 * Devuelve el número de jugadas que pueden deshacerse hasta el momento.
	 * 
	 * @return Número de jugadas en el histórico.
	 */
	public int consultarNumeroJugadasEnHistorico();

	/**
	 * Deshace la última jugada realizada.
	 */
	public void deshacerJugada();

	/**
	 * Guarda los efectos de la última jugada realizada.
	 * 
	 * @param jugada La última jugada realizada.
	 */
	public void hacerJugada(Jugada jugada);

	/**
	 * Devuelve la fecha en la que se inicializa el mecanismo de deshacer.
	 * 
	 * @return Fecha de inicio del mecanismo de deshacer.
	 */
	public Date obtenerFechaInicio();
}
