import java.util.Arrays;

public class MiArrayList {
    private Object[] elementos;
    private int size;
    private static final int CAPACIDAD_INICIAL = 10;
    
    public MiArrayList() {
        elementos = new Object[CAPACIDAD_INICIAL];
        size = 0;
    }
    
    public void add(Object elemento) {
        if (size == elementos.length) {
            crecer();
        }
        elementos[size++] = elemento;
    }
    
    private void crecer() {
        int nuevaCapacidad = elementos.length * 2;
        elementos = Arrays.copyOf(elementos, nuevaCapacidad);
    }
    
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Índice: " + index + ", Tamaño: " + size
            );
        }
        return elementos[index];
    }
    
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Índice: " + index + ", Tamaño: " + size
            );
        }
        
        Object elementoEliminado = elementos[index];
        
        int elementosAMover = size - index - 1;
        if (elementosAMover > 0) {
            System.arraycopy(elementos, index + 1, 
                           elementos, index, 
                           elementosAMover);
        }
        
        elementos[--size] = null;
        
        return elementoEliminado;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
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