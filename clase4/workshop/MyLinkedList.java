import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación propia de una Lista Enlazada Simple (Singly Linked List).
 * Esta implementación demuestra los conceptos fundamentales de las estructuras
 * de datos dinámicas usando referencias.
 * 
 * @param <T> Tipo genérico de los elementos almacenados
 * @author Clase de Estructuras de Datos - Semana 4
 */
public class MyLinkedList<T> implements Iterable<T> {
    
    /**
     * Referencia al primer nodo de la lista (cabeza)
     */
    private Node<T> head;
    
    /**
     * Contador del número de elementos en la lista
     * Permite que size() sea O(1) en lugar de O(n)
     */
    private int size;
    
    /**
     * Constructor por defecto. Crea una lista enlazada vacía.
     */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Verifica si la lista está vacía.
     * Complejidad: O(1)
     * 
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Obtiene el número de elementos en la lista.
     * Complejidad: O(1) gracias al contador interno
     * 
     * @return Número de elementos en la lista
     */
    public int size() {
        return size;
    }
    
    /**
     * Agrega un elemento al final de la lista.
     * Complejidad: O(n) - debe recorrer hasta el final
     * 
     * @param element Elemento a agregar
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    /**
     * Agrega un elemento al inicio de la lista.
     * Complejidad: O(1) - ventaja principal de LinkedList
     * 
     * @param element Elemento a agregar al inicio
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * Agrega un elemento en la posición especificada.
     * Complejidad: O(n) en el peor caso
     * 
     * @param index Posición donde insertar (0-based)
     * @param element Elemento a insertar
     * @throws IndexOutOfBoundsException si el índice es inválido
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
        }
        
        if (index == 0) {
            addFirst(element);
            return;
        }
        
        Node<T> newNode = new Node<>(element);
        Node<T> current = head;
        
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    /**
     * Obtiene el elemento en la posición especificada.
     * Complejidad: O(n) - desventaja principal de LinkedList
     * 
     * @param index Posición del elemento (0-based)
     * @return Elemento en la posición especificada
     * @throws IndexOutOfBoundsException si el índice es inválido
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    /**
     * Obtiene el primer elemento de la lista.
     * Complejidad: O(1)
     * 
     * @return Primer elemento
     * @throws NoSuchElementException si la lista está vacía
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía");
        }
        return head.data;
    }
    
    /**
     * Obtiene el último elemento de la lista.
     * Complejidad: O(n)
     * 
     * @return Último elemento
     * @throws NoSuchElementException si la lista está vacía
     */
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía");
        }
        
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        return current.data;
    }
    
    /**
     * Verifica si la lista contiene el elemento especificado.
     * Complejidad: O(n)
     * 
     * @param element Elemento a buscar
     * @return true si el elemento está presente, false en caso contrario
     */
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }
    
    /**
     * Encuentra el índice de la primera ocurrencia del elemento especificado.
     * Complejidad: O(n)
     * 
     * @param element Elemento a buscar
     * @return Índice del elemento o -1 si no se encuentra
     */
    public int indexOf(T element) {
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            if ((element == null && current.data == null) || 
                (element != null && element.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1;
    }
    
    /**
     * Elimina el elemento en la posición especificada.
     * Complejidad: O(n)
     * 
     * @param index Posición del elemento a eliminar
     * @return Elemento eliminado
     * @throws IndexOutOfBoundsException si el índice es inválido
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        
        return data;
    }
    
    /**
     * Elimina la primera ocurrencia del elemento especificado.
     * Complejidad: O(n)
     * 
     * @param element Elemento a eliminar
     * @return true si se eliminó el elemento, false si no se encontró
     */
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }
        
        if ((element == null && head.data == null) || 
            (element != null && element.equals(head.data))) {
            removeFirst();
            return true;
        }
        
        Node<T> current = head;
        while (current.next != null) {
            if ((element == null && current.next.data == null) || 
                (element != null && element.equals(current.next.data))) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * Elimina el primer elemento de la lista.
     * Complejidad: O(1)
     * 
     * @return Elemento eliminado
     * @throws NoSuchElementException si la lista está vacía
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía");
        }
        
        T data = head.data;
        head = head.next;
        size--;
        
        return data;
    }
    
    /**
     * Elimina todos los elementos de la lista.
     * Complejidad: O(1)
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * Muestra todos los elementos de la lista en consola.
     * Útil para debugging y demostraciones.
     * Complejidad: O(n)
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Lista vacía: []");
            return;
        }
        
        System.out.print("Lista: [");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
    
    /**
     * Muestra información detallada de debugging con direcciones de memoria.
     * Complejidad: O(n)
     */
    public void displayDebug() {
        System.out.println("=== DEBUG INFO ===");
        System.out.println("Size: " + size);
        System.out.println("Head: " + (head == null ? "null" : head.toDetailedString()));
        
        if (!isEmpty()) {
            Node<T> current = head;
            int index = 0;
            while (current != null) {
                System.out.printf("[%d] %s%n", index, current.toDetailedString());
                current = current.next;
                index++;
            }
        }
        System.out.println("================");
    }
    
    /**
     * Convierte la lista en una representación de cadena.
     * Complejidad: O(n)
     * 
     * @return Representación en cadena de la lista
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Convierte la lista a un array.
     * Complejidad: O(n)
     * 
     * @return Array con los elementos de la lista
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        
        return array;
    }
    
    /**
     * Obtiene un iterador para recorrer la lista.
     * Permite el uso de enhanced for-loop y otros patrones de iteración.
     * 
     * @return Iterator para esta lista
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    
    /**
     * Clase interna que implementa Iterator para MyLinkedList.
     * Permite recorrer la lista de forma segura y eficiente.
     */
    private class LinkedListIterator implements Iterator<T> {
        
        /**
         * Referencia al nodo actual en la iteración
         */
        private Node<T> current;
        
        /**
         * Constructor del iterador. Comienza desde head.
         */
        public LinkedListIterator() {
            this.current = head;
        }
        
        /**
         * Verifica si hay más elementos para iterar.
         * Complejidad: O(1)
         * 
         * @return true si hay más elementos, false en caso contrario
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        /**
         * Obtiene el siguiente elemento en la iteración.
         * Complejidad: O(1)
         * 
         * @return Siguiente elemento
         * @throws NoSuchElementException si no hay más elementos
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos");
            }
            
            T data = current.data;
            current = current.next;
            return data;
        }
        
        /**
         * Operación remove no soportada en esta implementación básica.
         * En una implementación completa, requeriría mantener referencia al nodo anterior.
         * 
         * @throws UnsupportedOperationException siempre
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove no soportado en este iterador");
        }
    }
    
    /**
     * Invierte el orden de los elementos en la lista.
     * Complejidad: O(n)
     * Método adicional para práctica avanzada.
     */
    public void reverse() {
        if (isEmpty() || head.next == null) {
            return;
        }
        
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
    }
    
    /**
     * Encuentra el nodo en el medio de la lista usando el algoritmo "tortuga y liebre".
     * Complejidad: O(n)
     * Método adicional para práctica avanzada.
     * 
     * @return Dato del nodo medio (si hay número par, devuelve el segundo del medio)
     * @throws NoSuchElementException si la lista está vacía
     */
    public T findMiddle() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía");
        }
        
        Node<T> slow = head;
        Node<T> fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
}