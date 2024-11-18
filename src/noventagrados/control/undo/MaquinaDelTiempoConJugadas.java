package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {
	private List<Jugada> historicoJugadas;

	public MaquinaDelTiempoConJugadas() {
		super();
		this.historicoJugadas = new ArrayList<>();
	}

	@Override
	public Arbitro consultarArbitroActual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int consultarNumeroJugadasEnHistorico() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deshacerJugada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hacerJugada(Jugada jugada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date obtenerFechaInicio() {
		// TODO Auto-generated method stub
		return null;
	}
}