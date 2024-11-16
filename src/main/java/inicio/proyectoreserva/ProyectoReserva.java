package inicio.proyectoreserva;

import inicio.proyectoreserva.facade.ReservaFacade;
import inicio.proyectoreserva.model.Habitacion;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */


public class ProyectoReserva {
    
    public static void main(String[] args) throws SQLException {

        // EJEMPLO DE COMO UTILIZAR
        // 1 UTILIZE SOLO DEL PACKAGE facede para accder a todo el sistema

//        ReservaFacade reservaFacade = new ReservaFacade();
//
//        try {
//            // Autenticar un usuario
//            if (reservaFacade.auntenricarUsuario("usuario1", "password1")) {
//                System.out.println("Usuario autenticado.");
//
//                // Crear una reserva
//                boolean reservaCreada = reservaFacade.crearReserva(
//                        1, 101, new Date(), new Date());
//                if (reservaCreada) {
//                    System.out.println("Reserva creada con éxito.");
//                }
//
//                // Registrar un pago para una reserva
//                boolean pagoRegistrado = reservaFacade.registrarPago(
//                        1, 100.0, new Date(), "Tarjeta");
//                if (pagoRegistrado) {
//                    System.out.println("Pago registrado con éxito.");
//                }
//
//                // Obtener habitaciones disponibles
//                List<Habitacion> habitacionesDisponibles = reservaFacade.obtenerHabitacionesDisponibles();
//                habitacionesDisponibles.forEach(h -> System.out.println(
//                        "Habitación disponible: " + h.getId()));
//            } else {
//                System.out.println("Autenticación fallida.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
