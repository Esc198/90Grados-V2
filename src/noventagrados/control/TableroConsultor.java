
package noventagrados.control;

import noventagrados.modelo.Tablero;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.Sentido;
import noventagrados.util.TipoPieza;
import noventagrados.modelo.Pieza;

/**
 * Proporciona métodos para realizar consultas sobre el estado del tablero sin
 * modificarlo, incluyendo cálculos de distancias y conteo de piezas.
 *
 * @param <T> El tipo de tablero sobre el que se realizarán las consultas.
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 2.0
 */
public class TableroConsultor<T extends Tablero> {

	private T tablero;

	/**
	 * Constructor de la clase TableroConsultor
	 *
	 * @param tablero Tablero sobre el que se realizarán las consultas
	 */
	public TableroConsultor(T tablero) {
		this.tablero = tablero;
	}

	/**
	 * Calcula el sentido de un movimiento entre dos coordenadas
	 *
	 * @param origen  Coordenada de origen
	 * @param destino Coordenada de destino
	 * @return Sentido del movimiento o null si no es válido
	 */
	public Sentido calcularSentido(Coordenada origen, Coordenada destino) {
		Sentido sentido = null;
		int SentidoFilas = destino.fila() - origen.fila();
		int SentidoColumnas = destino.columna() - origen.columna();

		if (SentidoFilas == 0 && SentidoColumnas != 0) {
			if (SentidoColumnas > 0) {
				sentido = Sentido.HORIZONTAL_E;
			} else {
				sentido = Sentido.HORIZONTAL_O;
			}
		} else if (SentidoColumnas == 0 && SentidoFilas != 0) {
			if (SentidoFilas > 0) {
				sentido = Sentido.VERTICAL_S;
			} else {
				sentido = Sentido.VERTICAL_N;
			}
		}

		return sentido;
	}

	/**
	 * Calcula la distancia en horizontal entre dos coordenadas
	 *
	 * @param origen  Coordenada de origen
	 * @param destino Coordenada de destino
	 * @return Distancia en horizontal o -1 si no están en la misma horizontal
	 */
	public int consultarDistanciaEnHorizontal(Coordenada origen, Coordenada destino) {
		if (origen.fila() != destino.fila()) {
			return -1;
		}
		int distancia = destino.columna() - origen.columna();
		return (distancia >= 0) ? distancia : -distancia;
	}

	/**
	 * Calcula la distancia en vertical entre dos coordenadas
	 *
	 * @param origen  Coordenada de origen
	 * @param destino Coordenada de destino
	 * @return Distancia en vertical o -1 si no están en la misma vertical
	 */
	public int consultarDistanciaEnVertical(Coordenada origen, Coordenada destino) {
		if (origen.columna() != destino.columna()) {
			return -1;
		}
		int distancia = destino.fila() - origen.fila();
		return (distancia >= 0) ? distancia : -distancia;
	}

	/**
	 * Consulta el número de piezas de un tipo y color concretos en el tablero
	 *
	 * @param tipoPieza El tipo de pieza a contar
	 * @param color     El color de la pieza a contar
	 * @return Número de piezas de ese tipo y color en el tablero
	 */
	public int consultarNumeroPiezas(TipoPieza tipoPieza, Color color) {
		int contador = 0;
		for (int i = 0; i < tablero.consultarNumeroFilas(); i++) {
			for (int j = 0; j < tablero.consultarNumeroColumnas(); j++) {
				Pieza piezaTemporal = tablero.consultarCelda(new Coordenada(i, j)).consultarPieza();
				if (piezaTemporal != null && piezaTemporal.consultarTipoPieza() == tipoPieza
						&& piezaTemporal.consultarColor() == color) {
					contador++;
				}
			}
		}
		return contador;
	}

	/**
	 * Consulta el número de piezas en la misma fila que la coordenada
	 *
	 * @param coordenada Coordenada de la fila a consultar
	 * @return Número de piezas en la fila
	 */
	public int consultarNumeroPiezasEnHorizontal(Coordenada coordenada) {
		int contador = 0;
		for (int i = 0; i < tablero.consultarNumeroColumnas(); i++) {
			if (!tablero.consultarCelda(new Coordenada(coordenada.fila(), i)).estaVacia()) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Consulta el número de piezas en la misma columna que la coordenada
	 *
	 * @param coordenada Coordenada de la columna a consultar
	 * @return Número de piezas en la columna
	 */
	public int consultarNumeroPiezasEnVertical(Coordenada coordenada) {
		int contador = 0;
		for (int i = 0; i < tablero.consultarNumeroFilas(); i++) {
			if (!tablero.consultarCelda(new Coordenada(i, coordenada.columna())).estaVacia()) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Comprueba si hay una reina del color especifico en el centro del tablero
	 *
	 * @param color Color de la reina a comprobar
	 * @return True si hay una reina del color especifico en el centro del tablero,
	 *         false en caso contrario
	 */
	public boolean estaReinaEnElCentro(Color color) {
		Pieza piezaEnCentro = tablero.consultarCelda(new Coordenada(3, 3)).consultarPieza();
		return piezaEnCentro != null && piezaEnCentro.consultarTipoPieza() == TipoPieza.REINA
				&& piezaEnCentro.consultarColor() == color;
	}

	/**
	 * Comprueba si hay una reina del color especifico en el tablero
	 *
	 * @param color Color de la reina a comprobar
	 * @return True si hay una reina del color especifico en el tablero, false en
	 *         caso contrario
	 */
	public boolean hayReina(Color color) {
		return consultarNumeroPiezas(TipoPieza.REINA, color) > 0;
	}

	@Override
	public String toString() {
		return "TableroConsultor [tablero=" + tablero + "]";
	}

}
