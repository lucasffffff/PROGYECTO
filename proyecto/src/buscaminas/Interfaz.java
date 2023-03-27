package buscaminas;

/**
 *
 * @author lucas
 */
import buscaminas.Tablero;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Interfaz extends JFrame {

    private Tablero tablero;
    private JLabel tiempoLabel;
    private Timer cronometro;

    // Constructor
    public Interfaz(Tablero tablero) {
        this.tablero = tablero;
        tiempoLabel = new JLabel("Tiempo: 0");
        add(tiempoLabel, BorderLayout.NORTH);
        add(tablero, BorderLayout.CENTER);
    // Timer para actualizar el tiempo transcurrido
        cronometro = new Timer(1000, new ActionListener() {
            int segundos = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                tiempoLabel.setText("Tiempo: " + segundos);
            }
        });

        cronometro.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Buscaminas");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // Muestra el resultado del juego
    public void mostrarResultado(boolean ganado) {
        cronometro.stop();
        int tiempo = Integer.parseInt(tiempoLabel.getText().split(": ")[1]);
        String mensaje = ganado ? "¡Ganaste! Tardaste " + tiempo + " segundos." : "Perdiste";
        JOptionPane.showMessageDialog(this, mensaje);
        System.exit(0);
    }

}
