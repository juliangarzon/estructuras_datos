package clase11.ejercicio_2;

public class Tarea {
    private String nombre;
    private String prioridad;

    public Tarea(String nombre, String prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    
    public String toString() {
        return "Tarea: " + nombre + " - Prioridad: " + prioridad;
    }
}