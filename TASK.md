
# Descripcion del sistema  
### Descripción: 
El sistema permite a los usuarios hacer reservas de habitaciones, gestionar la disponibilidad y registrar pagos. 
Los administradores pueden ver las reservas activas y gestionar el inventario de habitaciones.

### Patrones Recomendados:
o Creacionales: 
 - Singleton (gestión de conexión a la base de datos),
 - Factory (creación de objetos de reserva y usuario).
o Estructurales:
- Facade (simplificar la interfaz de reservas),
- Proxy (controlar el acceso de diferentes usuarios a ciertas funcionalidades).

o Comportamiento:
- Observer (notificación a usuarios de cambios en su reserva),
- State (gestión de estados de reserva: confirmada, pendiente, cancelada).


## TAREAS PENDIENTES

-  


---------



# METODOS DISPONIBLES 

### AdminUsuarioController 
- registrarNuevoUsuario
- obtenerTodosUsuarios
- obtenerUsuarioPorId
- actualizarUsuario
- eliminarUsuarioPorId
- actualizarRolUsuario

### LoginUsuarioController
- autentificarUsuario
- registrarNuevoUsuario

### PagoController
- registrarPago(int reservaId, double monto, Date fecha, String metodo)
- obtenerPagosPorReserva(int reservaId)
- obtenerTodosLosPagos

### ReservaController 
-  crearReserva(Reserva reserva)
-  cancelarReserva(int reservaId)
-  obtenerReservaPorUsuario(int usuarioId)
-  obtenerHabitacionesDisponible
-  actualizarDisponibilidadHabitacion(int habitacionId, boolean disponible)

 
