package inicio.proyectoreserva.service;

import inicio.proyectoreserva.database.DatabaseManager;
import inicio.proyectoreserva.model.Habitacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Habitacionservice {
    private DatabaseManager databaseManager;

    public Habitacionservice(){
        databaseManager = new DatabaseManager();
    }

    // ACTUALIZAR ESTADO DIPONIBLE DE LAS HABITACIONNES

    public boolean actualizarDisponibilidadHabitacion(
            int habitacionId, boolean disponible) throws SQLException {
        String query = "UPDATE habitaciones SET disponible = ? WHERE id = ?";
        int col = databaseManager.actualizarConsulta(query, disponible, habitacionId);
        return col > 0;
    }

    // BUSCAR HABITACIONES DISPONIBLES
    public List<Habitacion> obtenerHabitacionesDisponibles() throws SQLException {
        String query = "SELECT * FROM habitaciones WHERE disponible = true";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query);

        List<Habitacion>  habitaciones = new ArrayList<>();
        while (resultSet.next()){
            habitaciones.add(mapearHabitacion(resultSet));
        }
        return habitaciones;
    }


    // METODOS PARA EL BUSCADOR

    public List<Habitacion> buscarHabitacionPorTipo(String tipo) throws SQLException {
        String query = "SELECT * FROM habitaciones WHERE tipo = ?";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query, tipo);

        List<Habitacion> habitaciones = new ArrayList<>();
        while (resultSet.next()){
            habitaciones.add(mapearHabitacion(resultSet));
        }
        return habitaciones;
    }

    public List<Habitacion> buscarHabitacionPorPrecio(
            double precioMinimo, double precioMaximo) throws SQLException {
        String query = "SELECT * FROM habitaciones WHERE precio BETWEEN ? AND ?";
        ResultSet resultSet = databaseManager.ejecutarConsulta(query, precioMinimo, precioMaximo);

        List<Habitacion> habitaciones = new ArrayList<>();

        while (resultSet.next()){
            habitaciones.add(mapearHabitacion(resultSet));
        }
        return habitaciones;
    }

    // cuando busca por precio obtenemos una lista menores a
    public List<Habitacion> buscadorDeHabitacion(String tipo, Double precio, boolean disponible) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM habitaciones WHERE 1=1");
        List<Object> resultado = new ArrayList<>();
        if (tipo!=null && !tipo.isEmpty()){
            query.append(" AND tipo=?");
            resultado.add(tipo);
        }
        if (precio!= null){
            query.append(" AND precio<=?");
            resultado.add(precio);
        }
        if (disponible){
            query.append(" AND disponible=?");
            resultado.add(disponible);
        }
        ResultSet resultSet = databaseManager.ejecutarConsulta(query.toString(), resultado.toArray());
        List<Habitacion> habitaciones = new ArrayList<>();

        while (resultSet.next()){
            habitaciones.add(mapearHabitacion(resultSet));
        }
        return habitaciones;
    }


    private Habitacion mapearHabitacion(ResultSet resultSet) throws SQLException {
        Habitacion habitacion = new Habitacion();
        habitacion.setId(resultSet.getInt("id"));
        habitacion.setTipo(resultSet.getString("tipo"));
        habitacion.setPrecioPorNoche(resultSet.getDouble("precio"));
        habitacion.setDisponible(resultSet.getBoolean("disponible"));
        return habitacion;
    }


}
