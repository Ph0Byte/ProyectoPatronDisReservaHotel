package inicio.proyectoreserva.controller;

import inicio.proyectoreserva.model.Usuario;
import inicio.proyectoreserva.service.LoginUsuarioService;

import java.sql.SQLException;

public class LoginUsuarioController {

    private LoginUsuarioService loginUsuarioService;

    public LoginUsuarioController(){
        loginUsuarioService = new LoginUsuarioService();
    }

    public Usuario autentificarUsuario(String username, String password) throws SQLException {
        return loginUsuarioService.autenticarUsuario(username,password);
    }

    public boolean registrarNuevoUsuario(Usuario usuario) throws SQLException {
        Usuario nuevoUsuario = new Usuario(
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                "Cliente"
        );
        return loginUsuarioService.registrarUsuario(nuevoUsuario);
    }
}
