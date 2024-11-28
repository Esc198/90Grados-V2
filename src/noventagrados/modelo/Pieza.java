package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;

import noventagrados.util.TipoPieza;

/**
 * Representa una pieza de ajedrez, inicializándose con un tipo y color, y
 * proporcionando métodos para clonarla y convertirla a texto.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 2.0
 * 
 * @see java.util.Objects
 * @see noventagrados.util.Color
 * @see noventagrados.util.TipoPieza
 */
public class Pieza {

	/**
	 * Tipo de la pieza
	 * 
	 * @see noventagrados.util.TipoPieza
	 */
	private TipoPieza tipo;
	
	/**
	 * Color de la pieza
	 * 
	 * @see noventagrados.util.Color
	 */
	private Color color;

	/**
	 * Constructor de Pieza
	 * 
	 * @param tipo  tipo de pieza
	 * @param color color de la pieza
	 */
	public Pieza(TipoPieza tipo, Color color) {
		this.tipo = tipo;
		this.color = color;
	}

	/**
	 * Devuelve en texto el tipo de pieza y su color
	 * 
	 * @return String texto con el tipo de pieza y su color
	 */
	public String aTexto() {
		// (e.g., "PB" o "RN")
		return tipo.toChar() + "" + color.toChar();
	}

	/***
	 * Devuelve un clon de la pieza
	 * 
	 * @return Pieza clon de la pieza
	 */
	public Pieza clonar() {
		return new Pieza(this.tipo, this.color);
	}

	
	/**
	 * Consulta el color de la pieza
	 * 
	 * @return Color color de la pieza
	 */
	public Color consultarColor() {
		return color;
	}

	/**
	 * Consulta el tipo de pieza
	 * 
	 * @return TipoPieza tipo de pieza
	 */
	public TipoPieza consultarTipoPieza() {
		return tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pieza other = (Pieza) obj;
		return color == other.color && tipo == other.tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, tipo);
	}

	@Override
	public String toString() {
		return "Pieza [tipo=" + tipo + ", color=" + color + "]";
	}

}
