public class TestArrayListObject {
    public static void main(String[] args) {
        MiArrayList lista = new MiArrayList();
        
        // Test 1: Add y get con diferentes tipos
        System.out.println("=== Test Add/Get con Object ===");
        lista.add("Texto");
        lista.add(123);           // Integer
        lista.add(3.14);          // Double
        lista.add(true);          // Boolean
        
        System.out.println("Size: " + lista.size());
        
        // Problema: necesitamos casting
        String texto = (String) lista.get(0);
        Integer numero = (Integer) lista.get(1);
        System.out.println("Texto: " + texto);
        System.out.println("Número: " + numero);
        
        // Test 2: ¡PELIGRO! Mezcla de tipos
        System.out.println("\n=== Problema de tipos ===");
        try {
            String mal = (String) lista.get(1); // ClassCastException!
        } catch (ClassCastException e) {
            System.out.println("❌ Error de tipos: " + e.getMessage());
        }
        
        // Test 3: Crecimiento
        System.out.println("\n=== Test Crecimiento ===");
        MiArrayList numeros = new MiArrayList();
        for (int i = 0; i < 25; i++) {
            numeros.add(i);
        }
        System.out.println("25 elementos agregados, size: " + numeros.size());
        
        // Test 4: Remove
        System.out.println("\n=== Test Remove ===");
        System.out.println("Lista antes: " + lista);
        Object removido = lista.remove(1);
        System.out.println("Elemento removido: " + removido);
        System.out.println("Lista después: " + lista);
        System.out.println("Nuevo size: " + lista.size());
        
        // Test 5: Empty list
        System.out.println("\n=== Test Lista Vacía ===");
        MiArrayList vacia = new MiArrayList();
        System.out.println("Lista vacía isEmpty: " + vacia.isEmpty());
        System.out.println("Lista con elementos isEmpty: " + lista.isEmpty());
    }
}