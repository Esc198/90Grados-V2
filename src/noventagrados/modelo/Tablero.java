package noventagrados.modelo;

import java.util.Arrays;

import noventagrados.util.Coordenada;

/**
 * Representa un tablero de ajedrez como una matriz de celdas, con métodos para
 * clonar el tablero, colocar piezas y consultar su estado.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 * 
 */
public class Tablero {
	// Atributos
	private Celda[][] celdas;

	/**
	 * Constructor de Tablero
	 */
	public Tablero() {
		this.celdas = new Celda[7][7]; // Asumiendo un tablero de 7x7
		inicializarCeldas();
	}

	/**
	 * Devuelve el estado del tablero en formato de texto
	 * 
	 * @return String texto con el estado del tablero
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
			texto += "  " + i;		}
		return texto;
	}

	/**
	 * Devuelve un clon profundo del tablero
	 * 
	 * @return Tablero tablero clonado
	 */
	public Tablero clonar() {
		Tablero clon = new Tablero();
		clon.inicializarCeldas();
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[i].length; j++) {
				clon.celdas[i][j] = celdas[i][j].clonar();
			}
		}
		return clon;
	}

	/**
	 * Coloca una pieza en una celda del tablero
	 * 
	 * @param pieza      pieza a colocar
	 * @param coordenada coordenada de la celda
	 */
	public void colocar(Pieza pieza, Coordenada coordenada) {
		if (coordenada == null) {
			return;
		}
		if (!estaEnTablero(coordenada) || pieza == null) {
			return;
		}
		Celda celda = obtenerCelda(coordenada);

		celda.colocar(pieza);
	}

	/**
	 * Consulta la celda en una coordenada del tablero. Devuelve una copia de la celda
	 * 
	 * @param coordenada coordenada de la celda
	 * @return Celda celda en la coordenada. En caso de no existir o la coordenada
	 *         ser invalida devuelve null
	 */
	public Celda consultarCelda(Coordenada coordenada) {
		if (coordenada == null || !estaEnTablero(coordenada)) {
			return null;
		}
		return celdas[coordenada.fila()][coordenada.columna()].clonar();

	}

	/**
	 * 
	 * Consulta todas las celdas del tablero
	 * 
	 * @return Celda[] Array unidiemnsional con todas las celdas del tablero
	 */
	public Celda[] consultarCeldas() {
		int indice = 0;
		Celda[] celdas = new Celda[consultarNumeroFilas() * consultarNumeroColumnas()];
		for (int i = 0; i < consultarNumeroFilas(); i++) {
			for (int j = 0; j < consultarNumeroColumnas(); j++) {
				celdas[indice] = obtenerCelda(new Coordenada(i, j)).clonar();
				indice++;
			}

		}

		return celdas;
	}

	/**
	 * Consulta el número de columnas del tablero
	 * 
	 * @return int número de columnas
	 */
	public int consultarNumeroColumnas() {

		return celdas[0].length;
	}

	
	/**
	 * Consulta el número de filas del tablero
	 * 
	 * @return int número de filas
	 */
	public int consultarNumeroFilas() {
		return celdas.length;
	}

	/**
	 * Elimina una pieza de una celda del tablero
	 * 
	 * @param coordenada coordenada de la celda
	 */
	public void eliminarPieza(Coordenada coordenada) {
		if (coordenada == null) {
			return;
		}
		if (!estaEnTablero(coordenada)) {
			return;
		}
		celdas[coordenada.fila()][coordenada.columna()].eliminarPieza();
	}

	/**
	 * Consulta si una coordenada está dentro del tablero
	 * 
	 * @param coordenada coordenada a comprobar
	 * @return boolean true si la coordenada está en el tablero, false en caso
	 *         contrario
	 */
	public boolean estaEnTablero(Coordenada coordenada) {
		return coordenada != null && coordenada.fila() >= 0 && coordenada.fila() < consultarNumeroFilas()
				&& coordenada.columna() >= 0 && coordenada.columna() < consultarNumeroColumnas();
	}

	
	/**
	 * Consulta una celda del tablero a partir de una coordenada
	 * @param coordenada coordenada de la celda
	 * @return Celda celda en la coordenada. En caso de no existir o la coordenada ser invalida devuelve
	 */
	Celda obtenerCelda(Coordenada coordenada) {
		if (coordenada == null || !estaEnTablero(coordenada)) {
			return null;
		}
		return celdas[coordenada.fila()][coordenada.columna()];
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
		return Arrays.deepEquals(celdas, other.celdas);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(celdas);
		return result;
	}

	@Override
	public String toString() {
		return "Tablero [celdas=" + Arrays.toString(celdas) + "]";
	}

	// Inicializar las celdas del tablero
	private void inicializarCeldas() {

		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[i].length; j++) {
				celdas[i][j] = new Celda(new Coordenada(i, j));

			}
		}
	}

}
