
package noventagrados.control;

import noventagrados.modelo.Tablero;

import java.util.List;
import java.util.Objects;

import noventagrados.modelo.Jugada;
import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.Sentido;
import noventagrados.util.TipoPieza;

/**
 * Controla la lógica del juego, gestionando turnos, movimientos y condiciones
 * de finalización de la partida.
 *
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 */
public class Arbitro {

	// Atributos
	private Tablero tablero;
	private Color turno;
	private int numeroJugada;
	private Caja cajaBlancas;
	private Caja cajaNegras;

	/**
	 * Constructor de la clase Arbitro.
	 *
	 * @param tablero El tablero de juego.
	 */
	public Arbitro(Tablero tablero) {
		this.tablero = tablero;
		this.turno = null;
		this.numeroJugada = 0;
		this.cajaBlancas = new Caja(Color.BLANCO);
		this.cajaNegras = new Caja(Color.NEGRO);
	}

	/**
	 * Cambia el turno del juego.
	 */
	public void cambiarTurno() {
		turno = (turno == Color.BLANCO) ? Color.NEGRO : Color.BLANCO;
	}

	/**
	 * Coloca las piezas en el tablero en las coordenadas especificadas.
	 *
	 * @param piezas      Lista de piezas a colocar.
	 * @param coordenadas Lista de coordenadas donde colocar las piezas.
	 * @param turnoActual El turno actual del juego.
	 */
	public void colocarPiezas(List<Pieza> piezas, List<Coordenada> coordenadas, Color turnoActual) {
		for (int i = 0; i < piezas.size(); i++) {
			tablero.colocar(piezas.get(i), coordenadas.get(i));
		}
		this.turno = turnoActual;
	}

	/**
	 * Coloca las piezas en la configuración inicial del juego.
	 */
	public void colocarPiezasConfiguracionInicial() {
		// Colocación de piezas blancas
		tablero.colocar(new Pieza(TipoPieza.REINA, Color.BLANCO), new Coordenada(0, 0));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(0, 1));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(0, 2));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(0, 3));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(1, 0));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(2, 0));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(3, 0));

		// Colocación de piezas negras
		tablero.colocar(new Pieza(TipoPieza.REINA, Color.NEGRO), new Coordenada(6, 6));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(6, 5));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(6, 4));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(6, 3));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(5, 6));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(4, 6));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(3, 6));

		turno = Color.BLANCO;
	}

	/**
	 * Consulta la caja de piezas del color especificado.
	 *
	 * @param color El color de la caja a consultar.
	 * @return La caja de piezas del color especificado.
	 */
	public Caja consultarCaja(Color color) {
		return (color == Color.BLANCO) ? cajaBlancas : cajaNegras;
	}

	/**
	 * Consulta el número de jugada actual.
	 *
	 * @return El número de jugada actual.
	 */
	public int consultarNumeroJugada() {
		return numeroJugada;
	}

	/**
	 * Consulta el tablero de juego.
	 *
	 * @return Una copia del tablero de juego.
	 */
	public Tablero consultarTablero() {
		return tablero.clonar();
	}

	/**
	 * Consulta el turno actual del juego.
	 *
	 * @return El turno actual del juego.
	 */
	public Color consultarTurno() {
		return turno;
	}

	/**
	 * Consulta el turno del ganador del juego.
	 *
	 * @return El color del turno del ganador, o null si no hay ganador aún.
	 */
	public Color consultarTurnoGanador() {
		Color ganador = null;
		if (cajaBlancas.contarPiezas(TipoPieza.REINA) != 0 && cajaNegras.contarPiezas(TipoPieza.REINA) == 0) {
			ganador = Color.NEGRO;
		} else if (cajaBlancas.contarPiezas(TipoPieza.REINA) == 0 && cajaNegras.contarPiezas(TipoPieza.REINA) != 0) {
			ganador = Color.BLANCO;
		}
		TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero.clonar());
		if (consultor.estaReinaEnElCentro(Color.BLANCO)) {
			ganador = Color.BLANCO;
		} else if (consultor.estaReinaEnElCentro(Color.NEGRO)) {
			ganador = Color.NEGRO;
		}

		return ganador; // No hay ganador aún
	}

	/**
	 * Empuja las piezas en el tablero según la jugada especificada.
	 *
	 * @param jugada La jugada a realizar.
	 */
	public void empujar(Jugada jugada) {
		Pieza[] orden = new Pieza[7];
		TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero.clonar());
		Coordenada origen = jugada.origen().consultarCoordenada();
		Coordenada destino = jugada.destino().consultarCoordenada();
		Sentido sentido = consultor.calcularSentido(origen, destino);

		boolean esHorizontal = sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O;
		boolean esVertical = sentido == Sentido.HORIZONTAL_E || sentido == Sentido.VERTICAL_S;

		int inicio = esVertical ? 0 : 6;
		int fin = esVertical ? 7 : -1;
		int paso = esVertical ? 1 : -1;

		if (esHorizontal) {
			moverPiezas(origen.fila(), origen.columna(), destino.columna(), inicio, fin, paso, true, orden);
		} else {
			moverPiezas(origen.columna(), origen.fila(), destino.fila(), inicio, fin, paso, false, orden);
		}
		numeroJugada++;
	}

	/**
	 * Mueve las piezas en el tablero.
	 *
	 * @param fila         La fila de origen.
	 * @param origen       La columna de origen.
	 * @param destino      La columna de destino.
	 * @param inicio       El índice de inicio.
	 * @param fin          El índice de fin.
	 * @param paso         El paso de incremento.
	 * @param esHorizontal Indica si el movimiento es horizontal.
	 * @param orden        El arreglo de piezas a mover.
	 */
	private void moverPiezas(int fila, int origen, int destino, int inicio, int fin, int paso, boolean esHorizontal,
			Pieza[] orden) {
		for (int i = inicio; i != origen; i += paso) {
			orden[i] = consultarPieza(fila, i, esHorizontal);
		}
		for (int i = origen; i != fin; i += paso) {
			Pieza pieza = consultarPieza(fila, i, esHorizontal);
			if (pieza != null) {
				colocarPieza(pieza, destino, fin, paso, orden, esHorizontal, i);
			}
		}
		actualizarTablero(fila, orden, esHorizontal);
	}

	/**
	 * Consulta la pieza en la celda especificada.
	 *
	 * @param fila         La fila de la celda.
	 * @param i            El índice de la celda.
	 * @param esHorizontal Indica si la consulta es horizontal.
	 * @return La pieza en la celda especificada.
	 */
	private Pieza consultarPieza(int fila, int i, boolean esHorizontal) {
		return esHorizontal ? tablero.consultarCelda(new Coordenada(fila, i)).consultarPieza()
				: tablero.consultarCelda(new Coordenada(i, fila)).consultarPieza();
	}

	/**
	 * Coloca la pieza en la posición correcta o la añade a la caja si no puede ser
	 * colocada.
	 *
	 * @param pieza        La pieza a colocar.
	 * @param destino      La columna de destino.
	 * @param fin          El índice de fin.
	 * @param paso         El paso de incremento.
	 * @param orden        El arreglo de piezas a mover.
	 * @param esHorizontal Indica si el movimiento es horizontal.
	 * @param i            El índice de la celda.
	 */
	private void colocarPieza(Pieza pieza, int destino, int fin, int paso, Pieza[] orden, boolean esHorizontal, int i) {
		boolean noColocada = true;
		for (int j = destino; j != fin && noColocada; j += paso) {
			if (orden[j] == null && (paso > 0 ? i <= j : i >= j)) {
				orden[j] = pieza;
				noColocada = false;
			}
		}
		if (noColocada) {
			consultarCaja(pieza.consultarColor()).añadir(pieza);
		}
	}

	/**
	 * Actualiza el tablero con las nuevas posiciones de las piezas.
	 *
	 * @param fila         La fila de origen.
	 * @param orden        El arreglo de piezas a mover.
	 * @param esHorizontal Indica si el movimiento es horizontal.
	 */
	private void actualizarTablero(int fila, Pieza[] orden, boolean esHorizontal) {
		for (int i = 0; i < 7; i++) {
			if (esHorizontal) {
				tablero.eliminarPieza(new Coordenada(fila, i));
				tablero.colocar(orden[i], new Coordenada(fila, i));
			} else {
				tablero.eliminarPieza(new Coordenada(i, fila));
				tablero.colocar(orden[i], new Coordenada(i, fila));
			}
		}
	}

	/**
	 * Verifica si una jugada es legal.
	 *
	 * @param jugada La jugada a verificar.
	 * @return true si la jugada es legal, false en caso contrario.
	 */
	public boolean esMovimientoLegal(Jugada jugada) {
		boolean esLegal = true;

		if (estaFinalizadaPartida()) {
			esLegal = false;
		} else {
			Tablero clonTablero = consultarTablero();
			TableroConsultor<Tablero> consultaTablero = new TableroConsultor<>(clonTablero);
			Coordenada origen = jugada.origen().consultarCoordenada();
			Coordenada destino = jugada.destino().consultarCoordenada();

			if (!estaDentroDelTablero(origen) || !estaDentroDelTablero(destino)) {
				esLegal = false;
			} else {
				Pieza piezaOrigen = clonTablero.consultarCelda(origen).consultarPieza();
				if (piezaOrigen == null || piezaOrigen.consultarColor() != consultarTurno()) {
					esLegal = false;
				} else {
					Sentido sentido = consultaTablero.calcularSentido(origen, destino);
					if (sentido == null || origen.equals(destino)) {
						esLegal = false;
					} else {
						esLegal = esMovimientoEnSentidoValido(consultaTablero, origen, destino, sentido);
					}
				}
			}
		}

		return esLegal;
	}

	/**
	 * Verifica si el movimiento es válido en el sentido especificado.
	 *
	 * @param consultaTablero El consultor del tablero.
	 * @param origen          La coordenada de origen.
	 * @param destino         La coordenada de destino.
	 * @param sentido         El sentido del movimiento.
	 * @return true si el movimiento es válido, false en caso contrario.
	 */
	private boolean esMovimientoEnSentidoValido(TableroConsultor<Tablero> consultaTablero, Coordenada origen,
			Coordenada destino, Sentido sentido) {
		boolean esValido = false;
		int movimientoHorizontal = consultaTablero.consultarNumeroPiezasEnHorizontal(origen);
		int movimientoVertical = consultaTablero.consultarNumeroPiezasEnVertical(origen);

		if ((sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O)
				&& movimientoVertical == consultaTablero.consultarDistanciaEnHorizontal(origen, destino)) {
			esValido = true;
		} else if ((sentido == Sentido.VERTICAL_N || sentido == Sentido.VERTICAL_S)
				&& movimientoHorizontal == consultaTablero.consultarDistanciaEnVertical(origen, destino)) {
			esValido = true;
		}
		return esValido;
	}

	/**
	 * Verifica si una coordenada está dentro del tablero.
	 *
	 * @param coordenada La coordenada a verificar.
	 * @return true si la coordenada está dentro del tablero, false en caso
	 *         contrario.
	 */
	private boolean estaDentroDelTablero(Coordenada coordenada) {
		return coordenada.fila() >= 0 && coordenada.fila() < 7 && coordenada.columna() >= 0 && coordenada.columna() < 7;
	}

	/**
	 * Verifica si la partida ha finalizado.
	 *
	 * @return true si la partida ha finalizado, false en caso contrario.
	 */
	public boolean estaFinalizadaPartida() {
		Tablero clonTablero = consultarTablero();
		TableroConsultor<Tablero> consultaTablero = new TableroConsultor<>(clonTablero);
		boolean acabada = false;

		if (!consultaTablero.hayReina(Color.BLANCO) || !consultaTablero.hayReina(Color.NEGRO)) {
			acabada = true;
		}
		if (consultaTablero.estaReinaEnElCentro(Color.BLANCO) || consultaTablero.estaReinaEnElCentro(Color.NEGRO)) {
			acabada = true;
		}
		return acabada;
	}

	/**
	 * Clona el objeto Arbitro.
	 *
	 * @return Un clon del objeto Arbitro.
	 */
	public Arbitro clonar() {
		Tablero tableroClon = tablero.clonar();
		Arbitro clon = new Arbitro(tableroClon);
		clon.turno = turno;
		clon.numeroJugada = numeroJugada;
		clon.cajaBlancas = cajaBlancas.clonar();
		clon.cajaNegras = cajaNegras.clonar();

		return clon;
	}

	@Override
	public String toString() {
		return "Arbitro [tablero=" + tablero + ", turno=" + turno + ", numeroJugada=" + numeroJugada + ", cajaBlancas="
				+ cajaBlancas + ", cajaNegras=" + cajaNegras + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cajaBlancas, cajaNegras, numeroJugada, tablero, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		return Objects.equals(cajaBlancas, other.cajaBlancas) && Objects.equals(cajaNegras, other.cajaNegras)
				&& numeroJugada == other.numeroJugada && Objects.equals(tablero, other.tablero) && turno == other.turno;
	}

}