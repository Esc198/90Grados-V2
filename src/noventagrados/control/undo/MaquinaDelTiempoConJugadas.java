package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {
	private List<Jugada> historicoJugadas;

	public MaquinaDelTiempoConJugadas() {
		super();
		this.historicoJugadas = new ArrayList<>();
	}
}