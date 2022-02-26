package gt.edu.usac.ingenieria.controller;

import gt.edu.usac.ingenieria.model.Usuario;
import gt.edu.usac.ingenieria.view.InfoUsuarioView;
import gt.edu.usac.ingenieria.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoUsuarioController {
    private final Usuario[] usuarios;
    private final InfoUsuarioView view;

    public InfoUsuarioController(InfoUsuarioView view, Usuario[] usuarios, Usuario usuarioActual) {
        this.usuarios = usuarios;
        this.view = view;
        this.view.setBienvenidaLabel(usuarioActual.getNombre());
        this.view.setNombreLabel(usuarioActual.getNombre() + " " + usuarioActual.getApellido());
        this.view.setCarnetLabel(String.valueOf(usuarioActual.getCarnet()));
        this.view.addSalirListener(new SalirListener());
    }

    class SalirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            LoginView loginView = new LoginView("Login");
            LoginController loginController = new LoginController(loginView, usuarios);
            loginView.setVisible(true);
            view.dispose();
        }
    }

}
