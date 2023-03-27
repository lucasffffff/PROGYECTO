package proyecto;

import snake.*;
import buscaminas.Tablero;
import buscaminas.Interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;


public class MenuPrincipal {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;

    private static final String FRAME_TITLE = "Menú Principal";
    private static final String BUSCAMINAS_BUTTON_TEXT = "Iniciar Buscaminas";
    private static final String SNAKE_BUTTON_TEXT = "Iniciar Snake";
    private static final String MENU_LABEL_TEXT = "Elige un juego";

    private JFrame frame;
    private JPanel panel;
    private JButton buscaminasButton;
    private JButton snakeButton;

    public MenuPrincipal() {
        createFrame(); // Para crear el JFrame y establecer sus propiedades básicas
        createPanel(); // 
        createButtons(); // botones para iniciar los juegos
        addComponents();
    }

    private void createFrame() {
        frame = new JFrame(FRAME_TITLE); // JFrame con el título especificado
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); // seleccionar tamaño de ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.getContentPane().setBackground(new Color(18, 32, 53)); // color de fondo
    }

    private void createPanel() {
        panel = new JPanel(); // JPanel que contendrá los botones y el texto
        panel.setLayout(null); // 
        panel.setBackground(new Color(18, 32, 53)); // color de fondo del panel
        frame.add(panel); // Añadir el JPanel al JFrame
    }

    private void createButtons() {
        // Crear el botón para iniciar el juego Buscaminas
        buscaminasButton = new JButton(BUSCAMINAS_BUTTON_TEXT);
        buscaminasButton.setBounds(120, 110, 150, 30); // posición y tamaño del botón
        buscaminasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Al hacer clic en el botón, se crea un objeto Tablero y un objeto Interfaz para iniciar el Buscaminas
                Tablero tablero = new Tablero(8, 8, 10);
                Interfaz interfaz = new Interfaz(tablero);
                interfaz.setVisible(true);
            }
        });
        buscaminasButton.setBackground(new Color(74, 137, 220)); // color de fondo del botón
        buscaminasButton.setForeground(Color.WHITE); // color del texto del botón
        buscaminasButton.setFont(new Font("Arial", Font.BOLD, (int) (0.04 * FRAME_WIDTH))); // tamaño de la letra

        // Crear el botón para iniciar el juego Snake
        snakeButton = new JButton(SNAKE_BUTTON_TEXT);
        snakeButton.setBounds(120, 160, 150, 30); // posición y tamaño del botón
        snakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// Al clickar en el botón, se crea un objeto Juego para iniciar el juego Snake
                Juego juegoSnake = new Juego();
            }
        });
        snakeButton.setBackground(new Color(74, 137, 220)); // Establecer el color de fondo del botón
        snakeButton.setForeground(Color.WHITE); // Establecer el color del texto del botón
        snakeButton.setFont(new Font("Arial", Font.BOLD, (int) (0.04 * FRAME_WIDTH))); // Establecer el tamaño de la letra según el tamaño de la ventana
    }

private void addComponents() {
    // Crear un JLabel que servirá de etiqueta para el menú
    JLabel menuLabel = new JLabel(MENU_LABEL_TEXT);
    menuLabel.setBounds(0, 50, FRAME_WIDTH, 50); 
    menuLabel.setBackground(new Color(18, 32, 53));
    menuLabel.setForeground(Color.WHITE); 
    menuLabel.setFont(new Font("Arial", Font.BOLD, (int) (0.06 * FRAME_WIDTH)));
    panel.add(menuLabel); 
    
    // Crear los botones para iniciar los juegos
    buscaminasButton = new JButton(BUSCAMINAS_BUTTON_TEXT);
    buscaminasButton.setBounds(120, 110, 200, 50);
    buscaminasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Tablero tablero = new Tablero(8, 8, 10);
            Interfaz interfaz = new Interfaz(tablero);
            interfaz.setVisible(true);
        }
    });
    buscaminasButton.setBackground(new Color(74, 137, 220));
    buscaminasButton.setForeground(Color.WHITE);
    buscaminasButton.setFont(new Font("Arial", Font.BOLD, (int) (0.04 * FRAME_WIDTH)));

    snakeButton = new JButton(SNAKE_BUTTON_TEXT);
    snakeButton.setBounds(120, 170, 200, 50);
    snakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Juego juegoSnake = new Juego();
        }
    });
    menuLabel.setHorizontalAlignment(JLabel.CENTER);

    snakeButton.setBackground(new Color(74, 137, 220));
    snakeButton.setForeground(Color.WHITE);
    snakeButton.setFont(new Font("Arial", Font.BOLD, (int) (0.04 * FRAME_WIDTH)));

    panel.add(buscaminasButton);
    panel.add(snakeButton);
}


    public void show() {
        // Hacer visible el JFrame en el hilo de eventos de la interfaz gráfica de usuario
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        // Crear un objeto de la clase MenuPrincipal y mostrar el menú
        MenuPrincipal menu = new MenuPrincipal();
        menu.show();
    }
}