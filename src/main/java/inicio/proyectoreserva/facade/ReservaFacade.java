package inicio.proyectoreserva.facade;


import inicio.proyectoreserva.controller.PagoController;
import inicio.proyectoreserva.controller.ReservaController;
import inicio.proyectoreserva.controller.UsuarioController;
import inicio.proyectoreserva.model.Habitacion;
import inicio.proyectoreserva.model.Pago;
import inicio.proyectoreserva.model.Reserva;
import inicio.proyectoreserva.model.Usuario;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ReservaFacade {
    private final PagoController pagoController;
    private final ReservaController reservaController;
    private final UsuarioController usuarioController;

    public ReservaFacade() {
        pagoController = new PagoController();
        reservaController = new ReservaController();
        usuarioController = new UsuarioController();
    }

    public boolean auntenricarUsuario(
            String username, String password) throws SQLException {
        Usuario usuario = usuarioController.autentificarUsuario(username,password);
        return usuario != null;
    }

    public boolean registrarUsuario(
            String nombre, String username, String password) throws SQLException, SQLException {
        Usuario usuario = new Usuario(nombre, username, password, "Cliente");
        return usuarioController.registrarNuevoUsuario(usuario);
    }

    public boolean crearReserva(
            int usuarioId, int habitacionId, Date fechaInicio, Date fechaFin) throws SQLException {
        Reserva reserva = new Reserva(usuarioId, habitacionId, fechaInicio, fechaFin, "pendiente");
        return reservaController.crearReserva(reserva);
    }

    public List<Habitacion> obtenerHabitacionesDisponibles() throws SQLException {
        return reservaController.obtenerHabitacionesDisponible();
    }

    public boolean registrarPago(
            int reservaId, double monto, Date fecha, String metodo) throws SQLException {
        return pagoController.registrarPago(reservaId, monto, fecha, metodo);
    }

    public List<Pago> obtenerPagosPorReserva(int reservaId) throws SQLException {
        return pagoController.obtenerPagosPorReserva(reservaId);
    }
}
