import java.util.Arrays;

public class MiArrayListGenerico<T> {
    private T[] elementos;
    private int size;
    private static final int CAPACIDAD_INICIAL = 10;
    
    @SuppressWarnings("unchecked")
    public MiArrayListGenerico() {
        elementos = (T[]) new Object[CAPACIDAD_INICIAL];
        size = 0;
    }
    
    public void add(T elemento) {
        if (size == elementos.length) {
            crecer();
        }
        elementos[size++] = elemento;
    }
    
    @SuppressWarnings("unchecked")
    private void crecer() {
        int nuevaCapacidad = elementos.length * 2;
        elementos = Arrays.copyOf(elementos, nuevaCapacidad);
    }
    
    public T get(int index) {
        verificarIndice(index);
        return elementos[index];
    }
    
    public T remove(int index) {
        verificarIndice(index);
        T elementoEliminado = elementos[index];
        
        int elementosAMover = size - index - 1;
        if (elementosAMover > 0) {
            System.arraycopy(elementos, index + 1, 
                           elementos, index, elementosAMover);
        }
        
        elementos[--size] = null;
        return elementoEliminado;
    }
    
    private void verificarIndice(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Índice: " + index + ", Tamaño: " + size
            );
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Métodos del taller para implementar
    public boolean contains(T elemento) {
        return indexOf(elemento) >= 0;
    }
    
    public int indexOf(T elemento) {
        for (int i = 0; i < size; i++) {
            if (elemento == null) {
                if (elementos[i] == null) return i;
            } else if (elemento.equals(elementos[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementos[i] = null;
        }
        size = 0;
    }
    
    public void set(int index, T elemento) {
        verificarIndice(index);
        elementos[index] = elemento;
    }
    
    public void add(int index, T elemento) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Índice: " + index + ", Tamaño: " + size
            );
        }
        
        if (size == elementos.length) {
            crecer();
        }
        
        System.arraycopy(elementos, index, 
                        elementos, index + 1, 
                        size - index);
        
        elementos[index] = elemento;
        size++;
    }
    
    @Override
    public String toString() {
        if (size == 0) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elementos[i]).append(", ");
        }
        sb.append(elementos[size - 1]).append("]");
        return sb.toString();
    }
}