package inicio.proyectoreserva.controller.proxy;

import inicio.proyectoreserva.model.Usuario;
import inicio.proyectoreserva.service.AdminUsuarioService;
import inicio.proyectoreserva.service.impl.IUsuarioService;

import java.sql.SQLException;
import java.util.List;

public class AdminUsuarioProxy implements IUsuarioService {

    private AdminUsuarioService adminUsuarioService;
    private Usuario usuarioActual;

    public AdminUsuarioProxy(
            AdminUsuarioService adminUsuarioService, Usuario usuarioActual) {
        this.adminUsuarioService = adminUsuarioService;
        this.usuarioActual = usuarioActual;
    }

    public boolean esAdmin(){
        boolean comp = usuarioActual != null && "admin".equalsIgnoreCase(usuarioActual.getRol());
        return comp;
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() throws SQLException {
        return adminUsuarioService.obtenerTodosUsuarios();
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        return adminUsuarioService.obtenerUsuarioPorId(id);
    }

    @Override
    public boolean registrarNuevoUsuario(Usuario usuario) throws SQLException {
        if (esAdmin()){
            return adminUsuarioService.registrarNuevoUsuario(usuario);
        }
        throw new SecurityException("Acceso denegado, no se pudo registrar");
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) throws SQLException {
        if (esAdmin()){
            return adminUsuarioService.actualizarUsuario(usuario);
        }
        throw new SecurityException("Acceso denegado, no se pudo actualizar");
    }

    @Override
    public boolean eliminarUsuarioPorId(int id) throws SQLException {
        if (esAdmin()){
            return adminUsuarioService.eliminarUsuarioPorId(id);
        }
        throw new SecurityException("Acceso denegado, no se pudo eliminar");
    }

    @Override
    public boolean actualizarRolUsuario(int id, String nuevoRol) throws SQLException {
        if (esAdmin()){
            return adminUsuarioService.actualizarRolUsuario(id, nuevoRol);
        }
        throw new SecurityException("Acceso denegado, no es el admin ");
    }
}
