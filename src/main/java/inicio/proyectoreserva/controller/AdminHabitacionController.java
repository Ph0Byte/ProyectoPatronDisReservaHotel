package inicio.proyectoreserva.controller;

import inicio.proyectoreserva.controller.proxy.HabitacionProxy;
import inicio.proyectoreserva.model.Habitacion;
import inicio.proyectoreserva.model.Usuario;
import inicio.proyectoreserva.service.CRUDHabitacionesService;
import inicio.proyectoreserva.service.impl.IHabitacionesService;

import java.sql.SQLException;
import java.util.List;

public class AdminHabitacionController implements IHabitacionesService {

    private IHabitacionesService habitacionesService;

    public AdminHabitacionController(Usuario usuarioActual) {
        habitacionesService = new HabitacionProxy(new CRUDHabitacionesService(), usuarioActual);
    }

    @Override
    public boolean registrarNuevaHabitacion(Habitacion habitacion) throws SQLException {
        Habitacion nuevaHabitacion = new Habitacion(
                habitacion.getNumero_habitacion(),
                habitacion.getTipo(),
                habitacion.getPrecioPorNoche(),
                habitacion.getDisponible()
        );
        return habitacionesService.registrarNuevaHabitacion(nuevaHabitacion);
    }

    @Override
    public List<Habitacion> obtenerTodasHabitaciones() throws SQLException {
        List<Habitacion> habitaciones = habitacionesService.obtenerTodasHabitaciones();
        return habitaciones;
    }

    @Override
    public Habitacion obtenerHabitacionPorId(int id) throws SQLException {
        Habitacion habitacion = habitacionesService.obtenerHabitacionPorId(id);
        return habitacion;
    }

    @Override
    public boolean actualizarHabitacion(Habitacion habitacion) throws SQLException {
        return habitacionesService.actualizarHabitacion(habitacion);
    }

    @Override
    public boolean eliminarHabitacionPorId(int id) throws SQLException {
        return habitacionesService.eliminarHabitacionPorId(id);
    }
}
