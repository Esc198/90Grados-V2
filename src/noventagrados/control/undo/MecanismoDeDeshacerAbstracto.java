package noventagrados.control.undo;

import java.util.Date;

public abstract class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {
	protected Date fechaInicio;

	public MecanismoDeDeshacerAbstracto() {
		this.fechaInicio = new Date();
	}
}