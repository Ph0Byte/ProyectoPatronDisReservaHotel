package inicio.proyectoreserva.service.impl;

import inicio.proyectoreserva.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioService {
    boolean registrarNuevoUsuario(Usuario usuario) throws SQLException;
    List<Usuario> obtenerTodosUsuarios() throws SQLException;
    Usuario obtenerUsuarioPorId(int id) throws SQLException;
    boolean actualizarUsuario(Usuario usuario) throws SQLException;
    boolean eliminarUsuarioPorId(int id) throws SQLException;
    boolean actualizarRolUsuario(int id, String nuevoRol) throws SQLException;
}
