package buscaminas;

/**
 *
 * @author lucas
 */
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Tablero extends JPanel {

    private Casilla[][] casillas; // Matriz de casillas que representa el tablero
    private int filas; // Número de filas en el tablero
    private int columnas; // Número de columnas en el tablero
    private int minas; // Número de minas en el tablero

    // Constructor
    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;

        casillas = new Casilla[filas][columnas];
        setLayout(new GridLayout(filas, columnas));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(this);
                add(casillas[i][j]);
            }
        }
        colocarMinas();
        calcularValores();
    }

    // Coloca las minas en el tablero
    private void colocarMinas() {
        int contador = 0;
        while (contador < minas) {
            int fila = (int) (Math.random() * filas);
            int columna = (int) (Math.random() * columnas);
            if (!casillas[fila][columna].isMina()) {
                casillas[fila][columna].setMina(true);
                contador++;
            }
        }
    }

    // Calcula el valor de cada casilla
    private void calcularValores() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].isMina()) {
                    int contador = 0;
                    if (i > 0 && j > 0 && casillas[i - 1][j - 1].isMina()) {
                        contador++;
                    }
                    if (i > 0 && casillas[i - 1][j].isMina()) {
                        contador++;
                    }
                    if (i > 0 && j < columnas - 1 && casillas[i - 1][j + 1].isMina()) {
                        contador++;
                    }
                    if (j > 0 && casillas[i][j - 1].isMina()) {
                        contador++;
                    }
                    if (j < columnas - 1 && casillas[i][j + 1].isMina()) {
                        contador++;
                    }
                    if (i < filas - 1 && j > 0 && casillas[i + 1][j - 1].isMina()) {
                        contador++;
                    }
                    if (i < filas - 1 && casillas[i + 1][j].isMina()) {
                        contador++;
                    }
                    if (i < filas - 1 && j < columnas - 1 && casillas[i + 1][j + 1].isMina()) {
                        contador++;
                    }
                    casillas[i][j].setValor(contador);
                }
            }
        }
    }

    public boolean estadoJuego() {
        int casillasMarcadas = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].isMina() && casillas[i][j].isMarcada()) {
                    casillasMarcadas++;
                }
            }
        }
        if (casillasMarcadas == minas) {
            return true;
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].isAbierta() && !casillas[i][j].isMina()) {
                    return false;
                }
            }
        }
        return !algunaMinaExplotada();
    }

    public void mostrarMensajeDerrota() {
        JOptionPane.showMessageDialog(this, "Has perdido! ", "Mensaje de derrota", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public void todasLasCasillasAbiertas() {
        int casillasMarcadas = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].isMina() && casillas[i][j].isMarcada()) {
                    casillasMarcadas++;
                }
            }
        }
        if (casillasMarcadas == minas) {
            mostrarMensajeVictoria();
        }
    }

    public void mostrarMensajeVictoria() {
        JOptionPane.showMessageDialog(this, "¡Has ganado!", "Mensaje de victoria", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

// Indica si alguna mina ha explotado
    public boolean algunaMinaExplotada() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].isMina() && casillas[i][j].isAbierta()) {
                    return true;
                }
            }
        }
        return false;
    }
}
