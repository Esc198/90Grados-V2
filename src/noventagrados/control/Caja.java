
package noventagrados.control;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * Clase Caja que contiene un color y una lista de piezas. Sirve para saber qué
 * piezas han sido expulsadas del tablero.
 *
 * @version 1.0
 *
 */
public class Caja {

	private Color color;
	private List<Pieza> piezas;

	/**
	 * Constructor de la clase Caja.
	 *
	 * @param color Color de la caja.
	 */
	public Caja(Color color) {
		this.color = color;
		this.piezas = new ArrayList<>();
	}

	/**
	 * Método para añadir una pieza a la caja.
	 *
	 * @param pieza Debe ser una pieza válida y del mismo color que la caja.
	 */
	public void añadir(Pieza pieza) {
		if (pieza == null) {
			return;
		}
		// Validar que la pieza es del color correcto
		if (pieza.consultarColor() == this.color && piezas.size() < 7) {
			piezas.add(pieza);
		}
	}

	/**
	 * Método para clonar la caja.
	 *
	 * @return Caja clonada.
	 */
	public Caja clonar() {
		Caja cajaClon = new Caja(this.color);
		for (Pieza pieza : piezas) {
			cajaClon.añadir(pieza.clonar());
		}
		return cajaClon;
	}

	/**
	 * Método para consultar el color de la caja.
	 *
	 * @return Color de la caja.
	 */
	public Color consultarColor() {
		return color;
	}

	/**
	 * Método para consultar las piezas de la caja.
	 *
	 * @return Lista de piezas de la caja.
	 */
	public List<Pieza> consultarPiezas() {
		List<Pieza> piezasClon = new ArrayList<>();
		for (Pieza pieza : piezas) {
			piezasClon.add(pieza.clonar()); // Clona cada pieza para asegurar la copia profunda
		}
		return piezasClon;
	}

	/**
	 * Método para contar las piezas de la caja.
	 *
	 * @return Número de piezas en la caja.
	 */
	public int contarPiezas() {
		return piezas.size();
	}

	/**
	 * Método para contar las piezas de un tipo concreto.
	 *
	 * @param tipo Tipo de pieza.
	 * @return Número de piezas del tipo indicado.
	 */
	public int contarPiezas(TipoPieza tipo) {
		int contador = 0;
		for (Pieza pieza : piezas) {
			if (pieza.consultarTipoPieza() == tipo) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(color, piezas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caja other = (Caja) obj;
		return color == other.color && Objects.equals(piezas, other.piezas);
	}

	/**
	 * Sobrescribe toString para imprimir la caja.
	 *
	 * @return Representación en cadena de la caja.
	 */
	@Override
	public String toString() {
		return "Caja [color=" + color + ", piezas=" + piezas + "]";
	}

}
