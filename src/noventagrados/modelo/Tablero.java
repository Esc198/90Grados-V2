package noventagrados.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import noventagrados.util.Coordenada;

/**
 * Representa un tablero de juego como una matriz de celdas, proporcionando
 * métodos para clonar el tablero, colocar piezas y consultar su estado.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 2.0
 * 
 * @see noventagrados.util.Coordenada
 * @see java.util.ArrayList
 * @see java.util.Date
 * @see java.util.List
 */
public class Tablero {

	/**
	 * Lista de celdas que componen el tablero.
	 * 
	 * @see noventagrados.modelo.Celda
	 * @see java.util.List
	 * @see java.util.ArrayList
	 */
	private List<List<Celda>> celdas;

	/**
	 * Tamaño del lateral del tablero (filas o columnas). =======
	 * 
	 * /** Tamaño del tablero. >>>>>>> branch 'main' of
	 * https://github.com/Esc198/90Grados-V2.git
	 */
	private final int TAMAÑO_TABLERO = 7;

	/**
	 * Constructor que inicializa un tablero vacío con celdas en una matriz de 7x7.
	 */
	public Tablero() {
		this.celdas = new ArrayList<>();
		inicializarCeldas();
	}

	/**
	 * Devuelve una representación textual del estado actual del tablero.
	 * 
	 * @return una cadena de texto que representa el estado del tablero.
	 */
	public String aTexto() {
		String texto = "";
		for (int i = 0; i < consultarNumeroFilas(); i++) {
			texto += i + " ";
			for (int j = 0; j < consultarNumeroColumnas(); j++) {
				texto += consultarCelda(new Coordenada(i, j)).toString() + " ";
			}
			texto += "\n";
		}
		for (int i = 0; i < consultarNumeroColumnas(); i++) {
			texto += "  " + i;
		}
		return texto;
	}

	/**
	 * Crea un clon profundo del tablero, duplicando todas las celdas y sus piezas.
	 * 
	 * @return un nuevo objeto {@code Tablero} que es una copia del tablero actual.
	 */
	public Tablero clonar() {
		Tablero clon = new Tablero();
		for (int i = 0; i < consultarNumeroFilas(); i++) {
			for (int j = 0; j < consultarNumeroColumnas(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				Celda celda = obtenerCelda(coordenada);
				if (celda != null) {
					clon.colocar(celda.consultarPieza(), coordenada);
				}
			}
		}
		return clon;
	}

	/**
	 * Coloca una pieza en una celda específica del tablero.
	 * 
	 * @param pieza      la pieza que se desea colocar.
	 * @param coordenada la coordenada de la celda donde colocar la pieza.
	 */
	public void colocar(Pieza pieza, Coordenada coordenada) {
		if (coordenada == null || !estaEnTablero(coordenada) || pieza == null) {
			return;
		}
		Celda celda = obtenerCelda(coordenada);
		celda.colocar(pieza);
	}

	/**
	 * Devuelve una copia de la celda ubicada en la coordenada especificada.
	 * 
	 * @param coordenada la coordenada de la celda a consultar.
	 * @return una copia de la celda correspondiente, o {@code null} si la
	 *         coordenada es inválida.
	 */
	public Celda consultarCelda(Coordenada coordenada) {
		if (coordenada == null || !estaEnTablero(coordenada)) {
			return null;
		}
		return celdas.get(coordenada.fila()).get(coordenada.columna()).clonar();
	}

	/**
	 * Devuelve una lista unidimensional con copias de todas las celdas del tablero.
	 * 
	 * @return una lista con todas las celdas del tablero.
	 */
	public List<Celda> consultarCeldas() {
		List<Celda> todasCeldas = new ArrayList<>();
		for (int i = 0; i < celdas.size(); i++) {
			List<Celda> fila = celdas.get(i);
			for (int j = 0; j < fila.size(); j++) {
				todasCeldas.add(fila.get(j).clonar());
			}
		}
		return todasCeldas;
	}

	/**
	 * Devuelve el número de columnas en el tablero.
	 * 
	 * @return el número de columnas.
	 */
	public int consultarNumeroColumnas() {
		return celdas.get(0).size();
	}

	/**
	 * Devuelve el número de filas en el tablero.
	 * 
	 * @return el número de filas.
	 */
	public int consultarNumeroFilas() {
		return celdas.size();
	}

	/**
	 * Elimina la pieza de una celda en una coordenada específica del tablero.
	 * 
	 * @param coordenada la coordenada de la celda de la que se desea eliminar la
	 *                   pieza.
	 */
	public void eliminarPieza(Coordenada coordenada) {
		if (coordenada == null || !estaEnTablero(coordenada)) {
			return;
		}
		celdas.get(coordenada.fila()).get(coordenada.columna()).eliminarPieza();
	}

	/**
	 * Comprueba si una coordenada está dentro de los límites del tablero.
	 * 
	 * @param coordenada la coordenada a comprobar.
	 * @return {@code true} si la coordenada está dentro del tablero, {@code false}
	 *         en caso contrario.
	 */
	public boolean estaEnTablero(Coordenada coordenada) {
		return coordenada != null && coordenada.fila() >= 0 && coordenada.fila() < consultarNumeroFilas()
				&& coordenada.columna() >= 0 && coordenada.columna() < consultarNumeroColumnas();
	}

	/**
	 * Obtiene la celda ubicada en una coordenada específica sin crear una copia.
	 * 
	 * @param coordenada la coordenada de la celda a obtener.
	 * @return la celda correspondiente, o {@code null} si la coordenada es
	 *         inválida.
	 */
	Celda obtenerCelda(Coordenada coordenada) {
		if (coordenada == null || !estaEnTablero(coordenada)) {
			return null;
		}
		return celdas.get(coordenada.fila()).get(coordenada.columna());
	}

	/**
	 * Inicializa las celdas del tablero con sus respectivas coordenadas.
	 */
	private void inicializarCeldas() {
		for (int i = 0; i < TAMAÑO_TABLERO; i++) {
			List<Celda> fila = new ArrayList<>();
			for (int j = 0; j < TAMAÑO_TABLERO; j++) {
				fila.add(new Celda(new Coordenada(i, j)));
			}
			celdas.add(fila);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(TAMAÑO_TABLERO, celdas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		return TAMAÑO_TABLERO == other.TAMAÑO_TABLERO && Objects.equals(celdas, other.celdas);
	}

	@Override
	public String toString() {
		return "Tablero [celdas=" + celdas + ", TAMAÑO_TABLERO=" + TAMAÑO_TABLERO + "]";
	}

}
