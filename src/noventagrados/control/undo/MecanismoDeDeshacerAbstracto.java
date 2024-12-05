package noventagrados.control.undo;

import java.util.Date;

/**
 * Clase abstracta que define el mecanismo de deshacer. Proporciona una fecha de
 * inicio para el mecanismo.
 * 
 * @author <a href="esc1007@alu.ubu.es">Enrique Saiz</a>
 * @author <a href="mal1030@alu.ubu.es">Mario Alonso</a>
 * @version 1.0
 * 
 * @see java.util.Date
 */
public abstract class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {

	/**
	 * Fecha de creación del mecanismo de deshacer.
	 */
	private Date fechaInicio;

	/**
	 * Constructor que inicializa la fecha de inicio del mecanismo de deshacer.
	 * 
	 * @param date La fecha de inicio del mecanismo de deshacer.
	 */
	public MecanismoDeDeshacerAbstracto(Date date) {
		this.fechaInicio = date;
	}

	/**
	 * Obtiene la fecha de inicio de la máquina del tiempo.
	 *
	 * @return La fecha de inicio.
	 */
	@Override
	public Date obtenerFechaInicio() {
		return fechaInicio;
	}

}