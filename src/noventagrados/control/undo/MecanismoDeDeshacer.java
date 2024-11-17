package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import java.util.Date;

public interface MecanismoDeDeshacer {

    /**
     * Devuelve un clon en profundidad del árbitro en el estado actual.
     * 
     * @return Clon en profundidad del árbitro actual.
     */
    Arbitro consultarArbitroActual();

    /**
     * Devuelve el número de jugadas que pueden deshacerse hasta el momento.
     * 
     * @return Número de jugadas en el histórico.
     */
    int consultarNumeroJugadasEnHistorico();

    /**
     * Deshace la última jugada realizada.
     */
    void deshacerJugada();

    /**
     * Guarda los efectos de la última jugada realizada.
     * 
     * @param jugada La última jugada realizada.
     */
    void hacerJugada(Jugada jugada);

    /**
     * Devuelve la fecha en la que se inicializa el mecanismo de deshacer.
     * 
     * @return Fecha de inicio del mecanismo de deshacer.
     */
    Date obtenerFechaInicio();
}
