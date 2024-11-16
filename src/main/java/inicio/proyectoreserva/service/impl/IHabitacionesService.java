package inicio.proyectoreserva.service.impl;

import inicio.proyectoreserva.model.Habitacion;

import java.sql.SQLException;
import java.util.List;

public interface IHabitacionesService {
    boolean registrarNuevaHabitacion(Habitacion habitacion) throws SQLException;
    List<Habitacion> obtenerTodasHabitaciones() throws SQLException;
    Habitacion obtenerHabitacionPorId(int id)throws  SQLException;
    boolean actualizarHabitacion(Habitacion habitacion) throws SQLException;
    boolean eliminarHabitacionPorId(int id) throws SQLException;
}
