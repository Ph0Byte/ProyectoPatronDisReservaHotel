package inicio.proyectoreserva.controller;

import inicio.proyectoreserva.model.Habitacion;
import inicio.proyectoreserva.service.Habitacionservice;
import inicio.proyectoreserva.service.impl.IHabitacionesService;

import java.sql.SQLException;
import java.util.List;

public class HabitacionController {

    private Habitacionservice buscadorhabitacionservice;

    public HabitacionController() {
        buscadorhabitacionservice = new Habitacionservice();
    }

    // metodos del buscador de filtracion de laas habitaciones
    public List<Habitacion> obtenerHabitacionesDisponibles () throws SQLException {
        return buscadorhabitacionservice.obtenerHabitacionesDisponibles();
    }

    public List<Habitacion> buscarHabitacionPorTipo(String tipo) throws SQLException {
        return buscadorhabitacionservice.buscarHabitacionPorTipo(tipo);
    }

    public List<Habitacion> buscarHabitacionPorPrecio(
            double precioMinimo, double precioMaximo) throws SQLException {
        return buscadorhabitacionservice.buscarHabitacionPorPrecio(precioMinimo, precioMaximo);
    }

    public List<Habitacion> buscadorDeHabitacion(String tipo, Double precioMaximo, boolean disponible) throws SQLException {
        return buscadorhabitacionservice.buscadorDeHabitacion(tipo,precioMaximo,disponible);
    }

    // CRUD SOLO PARA ADMINISTRADORES


}
