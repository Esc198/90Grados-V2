package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La clase MaquinaDelTiempoConJugadas permite gestionar un histórico de jugadas
 * y proporciona funcionalidades para deshacer y rehacer jugadas.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 * 
 * @see noventagrados.control.Arbitro
 * @see noventagrados.modelo.Jugada
 * @see noventagrados.modelo.Tablero
 * @see java.util.ArrayList
 * @see java.util.Date
 * @see java.util.List
 */
public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {

	/**
	 * Historial de jugadas.
	 * 
	 * @see noventagrados.modelo.Jugada
	 * @see java.util.ArrayList
	 */
	private List<Jugada> historicoJugadas;

	/**
	 * Constructor que inicializa la máquina del tiempo con una fecha específica.
	 *
	 * @param date La fecha de inicio.
	 */
	public MaquinaDelTiempoConJugadas(Date date) {
		super(date);
		this.historicoJugadas = new ArrayList<>();
	}

	/**
	 * Consulta el estado actual del árbitro basado en el histórico de jugadas.
	 *
	 * @return El árbitro con el estado actualizado.
	 */
	public Arbitro consultarArbitroActual() {
		Tablero tablero = new Tablero();
		Arbitro arbitro = new Arbitro(tablero);
		arbitro.colocarPiezasConfiguracionInicial();
		for (Jugada jugada : historicoJugadas) {
			arbitro.empujar(jugada);
			arbitro.cambiarTurno();
		}

		return arbitro;
	}

	/**
	 * Consulta el número de jugadas en el histórico.
	 *
	 * @return El número de jugadas en el histórico.
	 */
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		return historicoJugadas.size();
	}

	/**
	 * Deshace la última jugada realizada.
	 */
	@Override
	public void deshacerJugada() {
		if (!historicoJugadas.isEmpty()) {
			historicoJugadas.remove(historicoJugadas.size() - 1);
		}
	}

	/**
	 * Añade una nueva jugada al histórico.
	 *
	 * @param jugada La jugada a añadir.
	 */
	@Override
	public void hacerJugada(Jugada jugada) {
		historicoJugadas.add(jugada);
	}

}
