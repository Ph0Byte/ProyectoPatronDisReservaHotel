package inicio.proyectoreserva.service;

import inicio.proyectoreserva.database.DatabaseManager;
import inicio.proyectoreserva.model.Habitacion;
import inicio.proyectoreserva.service.impl.IHabitacionesService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDHabitacionesService implements IHabitacionesService {
    private DatabaseManager databaseManager;

    public CRUDHabitacionesService() {
        databaseManager = new DatabaseManager();
    }

    @Override
    public boolean registrarNuevaHabitacion(Habitacion habitacion) throws SQLException {
        String query = "INSERT INTO habitaciones " +
                "(numero_habitacion, tipo, precio, disponible) VALUES (?,?,?,?)";
        int col = databaseManager.actualizarConsulta(query,
                habitacion.getNumero_habitacion(),
                habitacion.getTipo(),
                habitacion.getPrecioPorNoche(),
                habitacion.getDisponible()
                );
        return col>0;
    }

    @Override
    public List<Habitacion> obtenerTodasHabitaciones() throws SQLException {
        String query = "SELECT * FROM habitaciones";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query);
        List<Habitacion> habitaciones = new ArrayList<>();

        while (resultSet.next()){
            habitaciones.add(mapearHabitacion(resultSet));
        }

        return habitaciones;
    }

    @Override
    public Habitacion obtenerHabitacionPorId(int id) throws SQLException {
        String query = "SELECT * FROM habitaciones WHERE id=?";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query);
        List<Habitacion> habitaciones = new ArrayList<>();
        if (resultSet.next()){
            return mapearHabitacion(resultSet);
        }
        return null;
    }

    @Override
    public boolean actualizarHabitacion(Habitacion habitacion) throws SQLException {
        String query = "UPDATE habitaciones " +
                "SET numero_habitacion=?, tipo=?, precio=?, disponible=? WHERE id =?";

        int col = databaseManager.actualizarConsulta(query,
                    habitacion.getNumero_habitacion(),
                    habitacion.getTipo(),
                    habitacion.getPrecioPorNoche(),
                    habitacion.getDisponible()
                );
        return col>0;
    }

    @Override
    public boolean eliminarHabitacionPorId(int id) throws SQLException {
        String query = "SELECT FROM habitaciones WHERE id=?";
        int col = databaseManager.actualizarConsulta(query, id);
        return col>0;
    }

    private Habitacion mapearHabitacion(ResultSet resultSet) throws SQLException {
        Habitacion habitacion = new Habitacion();

        habitacion.setId(resultSet.getInt("id"));
        habitacion.setNumero_habitacion(resultSet.getInt("numero_habitacion"));
        habitacion.setTipo(resultSet.getString("tipo"));
        habitacion.setPrecioPorNoche(resultSet.getDouble("precio"));
        habitacion.setDisponible(resultSet.getBoolean("disponible"));
        return habitacion;
    }
}
