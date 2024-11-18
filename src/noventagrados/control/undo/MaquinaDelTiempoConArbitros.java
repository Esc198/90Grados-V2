package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
	private List<Arbitro> historicoArbitros;

	public MaquinaDelTiempoConArbitros(Date date) {
		super(date);
		this.historicoArbitros = new ArrayList<>();
		
		Tablero tablero = new Tablero();
		Arbitro arbitro = new Arbitro(tablero);
		arbitro.colocarPiezasConfiguracionInicial();
		historicoArbitros.add(arbitro);
	}

	@Override
	public Arbitro consultarArbitroActual() {
		return historicoArbitros.get(historicoArbitros.size() - 1);
	}

	@Override
	public int consultarNumeroJugadasEnHistorico() {

		return historicoArbitros.size() -1;
	}

	@Override
	public void deshacerJugada() {
		if (historicoArbitros.size() > 1) {
			historicoArbitros.remove(historicoArbitros.size() - 1);
		}

	}

	@Override
	public void hacerJugada(Jugada jugada) {
		if (jugada != null) {
			
			Arbitro arbitro = historicoArbitros.get(historicoArbitros.size() - 1).clonar();
			arbitro.empujar(jugada);
			arbitro.cambiarTurno();
			historicoArbitros.add(arbitro);
		}


	}

	@Override
	public Date obtenerFechaInicio() {
		// TODO Auto-generated method stub
		return super.fechaInicio;
	}
}