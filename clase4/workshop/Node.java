/**
 * Clase Node que representa un nodo individual en una lista enlazada.
 * Cada nodo contiene un dato y una referencia al siguiente nodo.
 * 
 * @param <T> Tipo genérico del dato que almacena el nodo
 * @author Clase de Estructuras de Datos - Semana 4
 */
public class Node<T> {
    /**
     * El dato almacenado en este nodo
     */
    T data;
    
    /**
     * Referencia al siguiente nodo en la lista
     */
    Node<T> next;
    
    /**
     * Constructor que crea un nuevo nodo con el dato especificado.
     * La referencia 'next' se inicializa como null.
     * 
     * @param data El dato a almacenar en este nodo
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    /**
     * Constructor que crea un nuevo nodo con dato y referencia al siguiente.
     * 
     * @param data El dato a almacenar en este nodo
     * @param next Referencia al siguiente nodo
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
    
    /**
     * Representación en cadena del nodo.
     * Muestra el dato y si tiene una referencia al siguiente nodo.
     * 
     * @return String representación del nodo
     */
    @Override
    public String toString() {
        return data + " → " + (next == null ? "null" : "[...]");
    }
    
    /**
     * Representación detallada del nodo con información de la referencia.
     * Útil para debugging.
     * 
     * @return String representación detallada
     */
    public String toDetailedString() {
        return String.format("Node{data=%s, next=%s}", 
                           data, 
                           next == null ? "null" : "Node@" + Integer.toHexString(next.hashCode()));
    }
    
    /**
     * Verifica si este es el último nodo (no tiene siguiente).
     * 
     * @return true si es el último nodo, false en caso contrario
     */
    public boolean isLast() {
        return next == null;
    }
    
    /**
     * Obtiene el dato almacenado en este nodo.
     * 
     * @return El dato del nodo
     */
    public T getData() {
        return data;
    }
    
    /**
     * Establece el dato de este nodo.
     * 
     * @param data El nuevo dato
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo.
     * 
     * @return El siguiente nodo o null si es el último
     */
    public Node<T> getNext() {
        return next;
    }
    
    /**
     * Establece la referencia al siguiente nodo.
     * 
     * @param next El siguiente nodo
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}