package inicio.proyectoreserva.facade;

import com.mysql.cj.util.StringInspector;
import inicio.proyectoreserva.controller.LoginUsuarioController;
import inicio.proyectoreserva.model.Usuario;

import java.sql.SQLException;

public class LoginFacade {

    private static LoginUsuarioController loginUsuarioController;

    public LoginFacade() {
        loginUsuarioController = new LoginUsuarioController();
    }

    public boolean auntenricarUsuario(
            String username, String password) throws SQLException {
        Usuario usuario = loginUsuarioController.autentificarUsuario(username,password);
        return usuario != null;
    }

    public boolean registrarUsuario(
            String nombre, String username, String password) throws SQLException, SQLException {
        Usuario usuario = new Usuario(nombre, username, password, "Cliente");
        return loginUsuarioController.registrarNuevoUsuario(usuario);
    }
}
