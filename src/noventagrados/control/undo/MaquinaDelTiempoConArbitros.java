package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
	private List<Arbitro> historicoArbitros;

	public MaquinaDelTiempoConArbitros() {
		super();
		this.historicoArbitros = new ArrayList<>();
	}
}