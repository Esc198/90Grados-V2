package noventagrados.control;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;
import java.util.Arrays;
import java.util.Objects;

/**
 * 
 * Clase Caja que contiene un color y una lista de piezas. Sirve para saber que
 * piezas han sido expulsadas del tablero.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 * 
 */
public class Caja {

	private Color color;
	private Pieza[] piezas;
	private int ultimaPieza;

	/**
	 * Constructor de la clase Caja.
	 * 
	 * @param color Color de la caja.
	 */
	public Caja(Color color) {
		this.color = color;
		this.piezas = new Pieza[7];
		this.ultimaPieza = 0;
	}

	/**
	 * Método para añadir una pieza a la caja
	 * 
	 * @param pieza Tiene que ser una pieza valida y del mismo color que la caja
	 */
	public void añadir(Pieza pieza) {
		if (pieza == null) {
			return;
		}
		// Validar que la pieza es del color correcto
		if (pieza.consultarColor() == this.color && ultimaPieza < 7) {
			piezas[ultimaPieza] = pieza;
			ultimaPieza++;
		}
	}

	/**
	 * Método para clonar la caja.
	 * 
	 * @return Caja clonada.
	 */
	public Caja clonar() {
		Caja cajaClon = new Caja(this.color);
		for (int i = 0; i < ultimaPieza; i++) {
			cajaClon.añadir(piezas[i].clonar());
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
	 * @return Array de piezas de la caja.
	 */
	public Pieza[] consultarPiezas() {
		Pieza[] piezasClon = new Pieza[ultimaPieza];
		for (int i = 0; i < ultimaPieza; i++) {
			piezasClon[i] = piezas[i].clonar(); // Clona cada pieza para asegurar la copia profunda
		}
		return piezasClon;
	}

	/**
	 * Método para contar las piezas de la caja.
	 * 
	 * @return Número de piezas de la caja.
	 */
	public int contarPiezas() {
		return ultimaPieza;
	}

	/**
	 * Método para contar las piezas de un tipo concreto.
	 * 
	 * @param tipo Tipo de pieza
	 * @return Número de piezas del tipo indicado.
	 */
	public int contarPiezas(TipoPieza tipo) {
		int contador = 0;
		for (int i = 0; i < ultimaPieza; i++) {
			if (piezas[i].consultarTipoPieza() == tipo) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(piezas);
		result = prime * result + Objects.hash(color, ultimaPieza);
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
		return color == other.color && Arrays.equals(piezas, other.piezas) && ultimaPieza == other.ultimaPieza;
	}

	// Sobrescribe toString para imprimir la caja.
	@Override
	public String toString() {
		return "Caja [color=" + color + ", piezas=" + piezas + "]";
	}

}
