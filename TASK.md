
# Descripcion del sistema  
### Descripción: 
El sistema permite a los usuarios hacer reservas de habitaciones, gestionar la disponibilidad y registrar pagos. 
Los administradores pueden ver las reservas activas y gestionar el inventario de habitaciones.

### Patrones Recomendados:
o Creacionales: 
 - Singleton (gestión de conexión a la base de datos),  X
 - Factory (creación de objetos de reserva y usuario).
   
o Estructurales:
- Facade (simplificar la interfaz de reservas),  X
- Proxy (controlar el acceso de diferentes usuarios a ciertas funcionalidades). X

o Comportamiento:
- Observer (notificación a usuarios de cambios en su reserva),   +-
- State (gestión de estados de reserva: confirmada, pendiente, cancelada).


## TAREAS PENDIENTES

- CRUD de usuarios X
-  Agregar un buscador  (habitaciones  , reservas  -> por nombre de usuairo ) admin  X
- filtrar habitaciones (tipo , disponible , precio) X
- CRUD habitaciones que solo admi puede hacer X
- 

---------






 
