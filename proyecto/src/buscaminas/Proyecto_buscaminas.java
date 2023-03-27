package buscaminas;

import buscaminas.Interfaz;
import buscaminas.Tablero;

/**
 *
 * @author lucas
 */
public class Proyecto_buscaminas {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(8, 8, 10);
        Interfaz interfaz = new Interfaz(tablero);
        interfaz.setVisible(true);
    }
}


