package inicio.proyectoreserva.service;

import inicio.proyectoreserva.database.DatabaseManager;
import inicio.proyectoreserva.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

// funcionalidades del login
public class LoginUsuarioService {
    private DatabaseManager databaseManager;

    public LoginUsuarioService(){
        databaseManager = new DatabaseManager();
    }

    public Usuario autenticarUsuario(String username, String password) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query,username, password);

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

    public boolean registrarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, username, password, rol) VALUES (?, ?, ?, ?)";
        int col = databaseManager.actualizarConsulta(query,
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRol());
        return col > 0;
    }



}
