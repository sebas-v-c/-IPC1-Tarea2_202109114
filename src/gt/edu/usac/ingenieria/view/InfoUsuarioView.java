package gt.edu.usac.ingenieria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InfoUsuarioView extends JFrame {
    private JLabel bienvenidaLabel;
    private JLabel nombreLabel;
    private JLabel carnetLabel;
    private JPanel mainPanel;
    private JButton salirButton;

    public InfoUsuarioView(String titulo) {
        super(titulo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(300, 400));
        this.pack();
    }

    // Agregamos un listener del boton salir
    public void addSalirListener(ActionListener listenForSalirButton) {
        salirButton.addActionListener(listenForSalirButton);
    }

    public void setBienvenidaLabel(String nombre) {
        bienvenidaLabel.setText("¡Bienvenid@ " + nombre + "!");
    }

    public void setNombreLabel(String nombreCompleto) {
        nombreLabel.setText(nombreCompleto);
    }

    public void setCarnetLabel(String carnet) {
        carnetLabel.setText(carnet);
    }

}
