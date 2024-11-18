package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {
	private List<Jugada> historicoJugadas;

	public MaquinaDelTiempoConJugadas(Date date) {
		super(date);
		this.historicoJugadas = new ArrayList<>();
	}

	public Arbitro consultarArbitroActual() {
	    Tablero tablero = new Tablero();
		Arbitro arbitro = new Arbitro(tablero);
	    arbitro.colocarPiezasConfiguracionInicial();
		for (Jugada jugada : historicoJugadas) {
			arbitro.empujar(jugada);
			arbitro.cambiarTurno();
		}
		
		return arbitro;
	}

	@Override
	public int consultarNumeroJugadasEnHistorico() {
	    return historicoJugadas.size();
	}

	@Override
	public void deshacerJugada() {
	    if (!historicoJugadas.isEmpty()) {
	        historicoJugadas.remove(historicoJugadas.size() - 1);
	    }
	}

	@Override
	public void hacerJugada(Jugada jugada) {
	    historicoJugadas.add(jugada);
	}

	@Override
	public Date obtenerFechaInicio() {
	    return super.fechaInicio;
	}
}