package noventagrados.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import noventagrados.util.Coordenada;


/**
 * Representa un tablero de ajedrez como una matriz de celdas, con métodos para
 * clonar el tablero, colocar piezas y consultar su estado.
 *
 * @version 1.0
 */
public class Tablero {
    // Atributos
    private List<List<Celda>> celdas;

    /**
     * Constructor de Tablero
     */
    public Tablero() {
        this.celdas = new ArrayList<>(); // Asumiendo un tablero de 7x7
        inicializarCeldas();
    }

    /**
     * Devuelve el estado del tablero en formato de texto
     *
     * @return String texto con el estado del tablero
     */
    public String aTexto() {
        String texto = "";
        for (int i = 0; i < consultarNumeroFilas(); i++) {
            texto += i + " ";
            for (int j = 0; j < consultarNumeroColumnas(); j++) {
                texto += consultarCelda(new Coordenada(i, j)).toString() + " ";
            }
            texto += "\n";
        }

        for (int i = 0; i < consultarNumeroColumnas(); i++) {
            texto += "  " + i;
        }
        return texto;
    }

    /**
     * Devuelve un clon profundo del tablero
     *
     * @return Tablero tablero clonado
     */
    public Tablero clonar() {
        Tablero clon = new Tablero();
        clon.inicializarCeldas();
        for (int i = 0; i < celdas.size(); i++) {
            for (int j = 0; j < celdas.size(); j++) {
                clon.celdas.get(i).set(j, celdas.get(i).get(j).clonar());
            }
        }
        return clon;
    }

    /**
     * Coloca una pieza en una celda del tablero
     *
     * @param pieza      pieza a colocar
     * @param coordenada coordenada de la celda
     */
    public void colocar(Pieza pieza, Coordenada coordenada) {
        if (coordenada == null) {
            return;
        }
        if (!estaEnTablero(coordenada) || pieza == null) {
            return;
        }
        Celda celda = obtenerCelda(coordenada);
        celda.colocar(pieza);
    }

    /**
     * Consulta la celda en una coordenada del tablero. Devuelve una copia de la
     * celda
     *
     * @param coordenada coordenada de la celda
     * @return Celda celda en la coordenada. En caso de no existir o la coordenada
     *         ser inválida devuelve null
     */
    public Celda consultarCelda(Coordenada coordenada) {
        if (coordenada == null || !estaEnTablero(coordenada)) {
            return null;
        }
        return celdas.get(coordenada.fila()).get(coordenada.columna()).clonar();
    }

    /**
     * Consulta todas las celdas del tablero
     *
     * @return List<Celda> lista unidimensional con todas las celdas del tablero
     */
    public List<Celda> consultarCeldas() {
        List<Celda> todasCeldas = new ArrayList<>();
        for (int i = 0; i < celdas.size(); i++) {
            List<Celda> fila = celdas.get(i);
            for (int j = 0; j < fila.size(); j++) {
                todasCeldas.add(fila.get(j).clonar());
            }
        }
        return todasCeldas;
    }

    /**
     * Consulta el número de columnas del tablero
     *
     * @return int número de columnas
     */
    public int consultarNumeroColumnas() {
        return celdas.get(0).size();
    }

    /**
     * Consulta el número de filas del tablero
     *
     * @return int número de filas
     */
    public int consultarNumeroFilas() {
        return celdas.size();
    }

    /**
     * Elimina una pieza de una celda del tablero
     *
     * @param coordenada coordenada de la celda
     */
    public void eliminarPieza(Coordenada coordenada) {
        if (coordenada == null) {
            return;
        }
        if (!estaEnTablero(coordenada)) {
            return;
        }
        celdas.get(coordenada.fila()).get(coordenada.columna()).eliminarPieza();
    }

    /**
     * Consulta si una coordenada está dentro del tablero
     *
     * @param coordenada coordenada a comprobar
     * @return boolean true si la coordenada está en el tablero, false en caso
     *         contrario
     */
    public boolean estaEnTablero(Coordenada coordenada) {
        return coordenada != null && coordenada.fila() >= 0 && coordenada.fila() < consultarNumeroFilas()
                && coordenada.columna() >= 0 && coordenada.columna() < consultarNumeroColumnas();
    }

    /**
     * Consulta una celda del tablero a partir de una coordenada
     *
     * @param coordenada coordenada de la celda
     * @return Celda celda en la coordenada. En caso de no existir o la coordenada
     *         ser inválida devuelve null
     */
    Celda obtenerCelda(Coordenada coordenada) {
        if (coordenada == null || !estaEnTablero(coordenada)) {
            return null;
        }
        return celdas.get(coordenada.fila()).get(coordenada.columna());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tablero other = (Tablero) obj;
        return Objects.equals(celdas, other.celdas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(celdas);
    }

    @Override
    public String toString() {
        return "Tablero [celdas=" + celdas + "]";
    }

    /**
     * Inicializa las celdas del tablero
     */
    private void inicializarCeldas() {
        for (int i = 0; i < 7; i++) {
            List<Celda> fila = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                fila.add(new Celda(new Coordenada(i, j)));
            }
            celdas.add(fila);
        }
    }
}
