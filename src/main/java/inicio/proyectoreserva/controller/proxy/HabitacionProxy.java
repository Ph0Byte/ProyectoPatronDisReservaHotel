package inicio.proyectoreserva.controller.proxy;

import inicio.proyectoreserva.model.Habitacion;
import inicio.proyectoreserva.model.Usuario;
import inicio.proyectoreserva.service.CRUDHabitacionesService;
import inicio.proyectoreserva.service.impl.IHabitacionesService;

import java.sql.SQLException;
import java.util.List;

public class HabitacionProxy implements IHabitacionesService {

    private CRUDHabitacionesService habitacionesService;
    private Usuario usuarioActual;

    public HabitacionProxy(CRUDHabitacionesService habitacionesService, Usuario usuarioActual) {
        this.habitacionesService = habitacionesService;
        this.usuarioActual = usuarioActual;
    }

    private boolean verificarAdmin(){
        return usuarioActual !=null && "admin".equalsIgnoreCase(usuarioActual.getRol());
    }

    @Override
    public boolean registrarNuevaHabitacion(Habitacion habitacion) throws SQLException {
        if (verificarAdmin()){
            return habitacionesService.registrarNuevaHabitacion(habitacion);
        }
        throw new SecurityException("Acceso denegado, no tiene permiso administrador ");
    }

    @Override
    public List<Habitacion> obtenerTodasHabitaciones() throws SQLException {
        return habitacionesService.obtenerTodasHabitaciones();
    }

    @Override
    public Habitacion obtenerHabitacionPorId(int id) throws SQLException {
        return habitacionesService.obtenerHabitacionPorId(id);
    }

    @Override
    public boolean actualizarHabitacion(Habitacion habitacion) throws SQLException {
        if (verificarAdmin()){
            return habitacionesService.actualizarHabitacion(habitacion);
        }
        throw new SecurityException("No tiene permiso de administrador ");
    }

    @Override
    public boolean eliminarHabitacionPorId(int id) throws SQLException {
        if (verificarAdmin()){
            return habitacionesService.eliminarHabitacionPorId(id);
        }
        throw new SecurityException("No tiene los permisos necesarios ");
    }
}
