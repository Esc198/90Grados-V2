package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;

/**
 * Representa una celda en el tablero de ajedrez, con métodos para clonar,
 * colocar piezas, consultar colores, y comprobar si está vacía.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 2.0
 * 
 * @see java.util.Objects
 * @see noventagrados.util.Color
 * @see noventagrados.util.Coordenada
 * 
 */
public class Celda {
	
	/**
	 * Coordenada de la celda
	 * 
	 * @see noventagrados.util.Coordenada
	 */
	private Coordenada coordenada;
	
	/**
	 * Pieza de la celda
	 * 
	 * @see noventagrados.modelo.Pieza
	 */
	private Pieza pieza;

	/**
	 * Constructor de Celda
	 * 
	 * @param coordenada coordenada de la celda
	 */
	// Constructor
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
		this.pieza = null;
	}

	/***
	 * Devuelve un clon profundo de la celda
	 * 
	 * @return Celda celda clonada
	 */
	public Celda clonar() {

		Coordenada clonCoordenada = new Coordenada(coordenada.fila(), coordenada.columna());
		Celda clon = new Celda(clonCoordenada);
		if (!estaVacia()) {
			clon.pieza = pieza.clonar();
		}

		return clon;
	}

	/***
	 * Coloca una pieza en la celda
	 * 
	 * @param pieza pieza a colocar
	 */
	public void colocar(Pieza pieza) {

		this.pieza = pieza;
	}

	/***
	 * Consulta el color de la pieza de la celda
	 * 
	 * @return Color color de la pieza de la celda. En caso de no haber pieza
	 *         devuelve null
	 */
	public Color consultarColorDePieza() {

		if (pieza != null) {
			return pieza.consultarColor();
		}
		return null;
	}

	/**
	 * Consulta la coordenada de la celda
	 * 
	 * @return Coordenada coordenada de la celda
	 */
	public Coordenada consultarCoordenada() {
		return coordenada;
	}

	/**
	 * Consulta la pieza de la celda
	 * 
	 * @return Pieza pieza de la celda
	 */
	public Pieza consultarPieza() {
		return pieza;
	}

	/**
	 * Elimina la pieza de la celda
	 */
	public void eliminarPieza() {

		this.pieza = null;
	}

	/**
	 * Comprueba si la celda está vacía
	 * 
	 * @return boolean true si la celda está vacía, false en caso contrario
	 */
	public boolean estaVacia() {

		return pieza == null;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(coordenada, pieza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celda other = (Celda) obj;
		return Objects.equals(coordenada, other.coordenada) && Objects.equals(pieza, other.pieza);
	}

	/**
	 * Devuelve un string con la representacion de la celda
	 * 
	 * @return String representacion de la celda
	 */
	// No se si se tiene que llamar toString o aTexto porque no es
	// la implementacion automatica de eclipse para la funcion toString
	public String toString() {
		if (estaVacia()) {
			return "--";
		}
		return pieza.aTexto();
	}
}
