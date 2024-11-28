package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La clase MaquinaDelTiempoConArbitros permite deshacer y rehacer jugadas en un
 * juego de tablero, manteniendo un historial de árbitros.
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
public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
	
	/**
	 * Historial de árbitros.
	 * 
	 * @see noventagrados.control.Arbitro
	 * @see java.util.ArrayList
	 */
	private List<Arbitro> historicoArbitros;

	/**
	 * Constructor que inicializa la máquina del tiempo con la fecha de inicio y
	 * configura el tablero y el árbitro inicial.
	 *
	 * @param date La fecha de inicio.
	 */
	public MaquinaDelTiempoConArbitros(Date date) {
		super(date);
		this.historicoArbitros = new ArrayList<>();

		Tablero tablero = new Tablero();
		Arbitro arbitro = new Arbitro(tablero);
		arbitro.colocarPiezasConfiguracionInicial();
		historicoArbitros.add(arbitro);
	}

	/**
	 * Consulta el árbitro actual del historial.
	 *
	 * @return El árbitro actual.
	 */
	@Override
	public Arbitro consultarArbitroActual() {
		return historicoArbitros.get(historicoArbitros.size() - 1);
	}

	/**
	 * Consulta el número de jugadas en el historial.
	 *
	 * @return El número de jugadas en el historial.
	 */
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		return historicoArbitros.size() - 1;
	}

	/**
	 * Deshace la última jugada realizada.
	 */
	@Override
	public void deshacerJugada() {
		if (historicoArbitros.size() > 1) {
			historicoArbitros.remove(historicoArbitros.size() - 1);
		}
	}

	/**
	 * Realiza una nueva jugada y la añade al historial.
	 *
	 * @param jugada La jugada a realizar.
	 */
	@Override
	public void hacerJugada(Jugada jugada) {
		if (jugada != null) {
			Arbitro arbitro = historicoArbitros.get(historicoArbitros.size() - 1).clonar();
			arbitro.empujar(jugada);
			arbitro.cambiarTurno();
			historicoArbitros.add(arbitro);
		}
	}

	/**
	 * Obtiene la fecha de inicio de la máquina del tiempo.
	 *
	 * @return La fecha de inicio.
	 */
	@Override
	public Date obtenerFechaInicio() {
		return super.fechaInicio;
	}
}
