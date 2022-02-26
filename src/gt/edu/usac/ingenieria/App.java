package gt.edu.usac.ingenieria;

import gt.edu.usac.ingenieria.controller.LoginController;
import gt.edu.usac.ingenieria.model.Usuario;
import gt.edu.usac.ingenieria.view.LoginView;

public class App {
    public static void main(String[] args) {
        LoginView view = new LoginView("Login");
        Usuario[] usuarios = new Usuario[100];
        usuarios[0] = new Usuario("Sebastian", "Vásquez", 202109114);
        LoginController controller = new LoginController(view, usuarios);

        view.setVisible(true);
    }
}
