package inicio.proyectoreserva.facade;

import inicio.proyectoreserva.controller.AdminHabitacionController;
import inicio.proyectoreserva.controller.HabitacionController;
import inicio.proyectoreserva.model.Habitacion;
import inicio.proyectoreserva.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class GestionAdminHabitacionFacade {

    private final HabitacionController habitacionController;
    private final AdminHabitacionController adminHabitacionController;


    public GestionAdminHabitacionFacade(Usuario nuevoActual) {
        habitacionController = new HabitacionController();
        adminHabitacionController = new AdminHabitacionController(nuevoActual);
    }

    // Metodos de busqueda y filtrado de habitaciones
    public List<Habitacion> obtenerHabitacionesDisponible() throws SQLException {
        return habitacionController.obtenerHabitacionesDisponibles();
    }

    public List<Habitacion> buscarHabitacionPorTipo(String tipo) throws SQLException {
        return habitacionController.buscarHabitacionPorTipo(tipo);
    }

    public List<Habitacion> buscarHabitacionPorPrecio(double precioMinimo, double precioMaximo) throws SQLException {
        return habitacionController.buscarHabitacionPorPrecio(precioMinimo, precioMaximo);
    }

    public List<Habitacion> buscarHabitacionGeneral
            (String tipo, double precioMaximo, boolean disponible ) throws SQLException {
        return habitacionController.buscadorDeHabitacion(tipo, precioMaximo, disponible);
    }

    // Metodos de gestion CRUD solo para Administradores

    public boolean regstrarNuevaHabitacion(Habitacion habitacion) throws SQLException {
        return adminHabitacionController.registrarNuevaHabitacion(habitacion);
    }

    public List<Habitacion> obtenerTodasLasHabitaciones() throws SQLException {
        return adminHabitacionController.obtenerTodasHabitaciones();
    }

    public Habitacion obtenerHabitacionPorId(int id) throws SQLException {
        return adminHabitacionController.obtenerHabitacionPorId(id);
    }


    public boolean actualizarHabitacion(Habitacion habitacion) throws SQLException {
        return adminHabitacionController.actualizarHabitacion(habitacion);
    }


    public boolean eliminarHabitacionPorId(int id) throws SQLException {
        return adminHabitacionController.eliminarHabitacionPorId(id);
    }


}
