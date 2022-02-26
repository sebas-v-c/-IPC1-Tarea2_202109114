package gt.edu.usac.ingenieria.controller;

import gt.edu.usac.ingenieria.model.Usuario;
import gt.edu.usac.ingenieria.view.InfoUsuarioView;
import gt.edu.usac.ingenieria.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    Usuario[] usuarios;
    LoginView view;

    public LoginController(LoginView view, Usuario[] usuarios) {
        this.usuarios = usuarios;
        this.view = view;
        view.addLoginListener(new LoginListener());
        view.addCerrarListener(new cerrarListener());
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String nombre;
            int carnet;
            Usuario usuarioActual;
            boolean usuarioCorrecto = false;

            // Lo rodeamos de un try para evitar cualquier error
            try {
                nombre = view.getUsuarioTextField();
                carnet = Integer.parseInt(view.getPasswordField());

                for (int i = 0; i < usuarios.length; i++) {
                    if (usuarios[i] != null) {
                        if ((usuarios[i].getNombre().equals(nombre)) && (usuarios[i].getCarnet() == carnet)) {
                            usuarioActual = usuarios[i];
                            usuarioCorrecto = true;
                            // llamo a otra ventana con los datos aquí encontrados
                            InfoUsuarioView infoView = new InfoUsuarioView("Información del usuario");
                            InfoUsuarioController controller = new InfoUsuarioController(infoView, usuarios, usuarioActual);
                            infoView.setVisible(true);
                            view.dispose();
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("No se ingresaron los datos correctos");
            }
            if (!usuarioCorrecto) {
                view.limpiarCampos();
                view.mostrarMensajeError("Usuario y/o contraseña incorrectos");
            }
        }
    }

    private class cerrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            view.dispose();
        }
    }
}
