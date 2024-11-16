package inicio.proyectoreserva.controller;

import inicio.proyectoreserva.model.Usuario;
import inicio.proyectoreserva.service.AdminUsuarioService;

import java.sql.SQLException;
import java.util.List;

// solo para usuarios administradores
// agregar solo desde la pestaña de los admin
public class AdminUsuarioController {

    private AdminUsuarioService usuarioService;

    public AdminUsuarioController(){
        usuarioService = new AdminUsuarioService();
    }

    public boolean registrarNuevoUsuario(Usuario usuario) throws SQLException {
        Usuario nuevoUsuario = new Usuario(
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getPassword()
        );
        return usuarioService.registrarNuevoUsuario(nuevoUsuario);
    }

    public List<Usuario> obtenerTodosUsuarios() throws SQLException {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    public boolean actualizarUsuario(Usuario usuario) throws SQLException {
        return usuarioService.actualizarUsuario(usuario);
    }

    public boolean eliminarUsuarioPorId(int idUsuario) throws SQLException {
        return usuarioService.eliminarUsuarioPorId(idUsuario);
    }

    // rol admitido  -> 'admin', 'usuario' // importante
    public boolean actualizarRolUsuario(int id, String nuevoRol) throws SQLException {
        return usuarioService.actualizarRolUsuario(id, nuevoRol);
    }
}
