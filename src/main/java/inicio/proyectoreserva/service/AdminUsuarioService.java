package inicio.proyectoreserva.service;

import inicio.proyectoreserva.database.DatabaseManager;
import inicio.proyectoreserva.model.Usuario;
import inicio.proyectoreserva.service.impl.IUsuarioService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// solo para usuarios administradores
// agregar solo desde la pestaña de los admin
public class AdminUsuarioService implements IUsuarioService {
    private DatabaseManager databaseManager;

    public AdminUsuarioService(){
        databaseManager = new DatabaseManager();
    }

    @Override
    public boolean registrarNuevoUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, username, password, rol) VALUES (?, ?, ?, ?)";
        int col = databaseManager.actualizarConsulta(query,
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRol());
        return col > 0;
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() throws SQLException {
        String query = "SELECT * FROM usuarios";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query);
        List<Usuario> usuarios = new ArrayList<>();
        while (resultSet.next()){
            usuarios.add(new Usuario(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("rol")
            ));
        }
        return usuarios;
    }
    @Override
    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query, id);

        if (resultSet.next()){
            return new Usuario(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("rol")
            );
        }
        return null;
    }
    @Override
    public boolean actualizarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuarios SET nombre = ?, username = ?, password = ?, " +
                "rol = ? WHERE id = ?";
        int col = databaseManager.actualizarConsulta(query,
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRol(),
                usuario.getId());
        return col > 0;
    }
    @Override
    public boolean eliminarUsuarioPorId(int id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id = ?";
        int col = databaseManager.actualizarConsulta(query, id);
        return col > 0;
    }

    // rol -> 'admin', 'usuario'
    @Override
    public boolean actualizarRolUsuario(int id, String nuevoRol) throws SQLException {
        String query = "UPDATE usuarios SET rol=? WHERE id =id";
        int col = databaseManager.actualizarConsulta(query,nuevoRol, id);
        return col >0;
    }
}
