package clase8.workshop;


import java.util.Queue;
import java.util.ArrayDeque;
public class TestQueue {
    public static void main(String[] args) {
        // Crear queue
        Queue<String> cola = new ArrayDeque<>();

        // Operaciones básicas
        cola.offer("Usuario1"); // Agregar
        cola.offer("Usuario2");
        cola.offer("Usuario3");

        String siguiente = cola.poll(); // "Usuario1" (y lo remueve)
        String primero = cola.peek(); // "Usuario2" (sin remover)
        int tamaño = cola.size(); // 2
        boolean vacía = cola.isEmpty(); // false
    }
}
