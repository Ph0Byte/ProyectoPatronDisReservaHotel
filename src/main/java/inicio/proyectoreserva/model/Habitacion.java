package inicio.proyectoreserva.model;

public class Habitacion {
    private int id;
    private int numero_habitacion;
    private String tipo;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion() {
    }

    public Habitacion(String tipo, double precioPorNoche, boolean disponible) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = disponible;
    }

    public Habitacion(
            int id, int numero_habitacion, String tipo,
            double precioPorNoche, boolean disponible) {
        this.id = id;
        this.numero_habitacion = numero_habitacion;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = disponible;
    }

    public Habitacion(int id, String tipo, double precioPorNoche, boolean disponible) {
        this.id = id;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = disponible;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
}
