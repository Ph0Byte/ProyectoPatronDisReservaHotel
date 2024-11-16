package inicio.proyectoreserva.controller;

import inicio.proyectoreserva.model.Habitacion;
import inicio.proyectoreserva.model.Reserva;
import inicio.proyectoreserva.service.Habitacionservice;
import inicio.proyectoreserva.service.ReservaService;

import java.sql.SQLException;
import java.util.List;

public class ReservaController {
    private ReservaService reservaService;
    private Habitacionservice habitacionservice;

    public ReservaController() {
        reservaService = new ReservaService();
        habitacionservice = new Habitacionservice();
    }


    public boolean crearReserva(Reserva reserva) throws SQLException {
        Reserva nuevaReserva = new Reserva(
                reserva.getUsuarioId(),
                reserva.getHabitacionId(),
                reserva.getFechaInicio(),
                reserva.getFechaFin(),
                "pendiente"
        );
        return reservaService.crearReserva(nuevaReserva);
    }

    public boolean cancelarReserva(int reservaId) throws SQLException {
        return reservaService.cancelarReserva(reservaId);
    }

    public List<Reserva> obtenerReservaPorUsuario(int usuarioId) throws SQLException {
        return reservaService.obtenerReservaPorUsuario(usuarioId);
    }

    // listar Habitaciones libres
    public List<Habitacion> obtenerHabitacionesDisponible() throws SQLException {
        return habitacionservice.obtenerHabitacionesDisponibles();
    }

    public boolean actualizarDisponibilidadHabitacion(int habitacionId, boolean disponible) throws SQLException {
        return habitacionservice
                .actualizarDisponibilidadHabitacion(habitacionId,disponible);
    }
}
