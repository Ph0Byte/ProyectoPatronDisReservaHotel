package inicio.proyectoreserva.facade;

import inicio.proyectoreserva.controller.HabitacionController;

public class GestionAdminHabitacionFacade {

    private static HabitacionController habitacionController;

    public GestionAdminHabitacionFacade() {
        habitacionController = new HabitacionController();
    }
}
