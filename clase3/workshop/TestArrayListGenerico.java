public class TestArrayListGenerico {
    public static void main(String[] args) {
        System.out.println("=== TESTS MIarraylist GENÉRICO ===\n");
        
        testBasicos();
        testTaller();
        testLibros();
        testCrecimiento();
        testExcepciones();
        
        System.out.println("🎉 Todos los tests completados exitosamente!");
    }
    
    public static void testBasicos() {
        System.out.println("=== Test Básicos ===");
        
        // Ahora con type safety!
        MiArrayListGenerico<String> listaNombres = new MiArrayListGenerico<>();
        listaNombres.add("Ana");
        listaNombres.add("Juan");
        // listaNombres.add(123); // No compila!
        
        String nombre = listaNombres.get(0); // Sin casting!
        System.out.println("Nombre: " + nombre);
        
        // Lista de números
        MiArrayListGenerico<Integer> listaNumeros = new MiArrayListGenerico<>();
        listaNumeros.add(10);
        listaNumeros.add(20);
        
        Integer suma = listaNumeros.get(0) + listaNumeros.get(1);
        System.out.println("Suma: " + suma);
        System.out.println("Size números: " + listaNumeros.size());
        System.out.println("Lista números: " + listaNumeros);
        System.out.println();
    }
    
    public static void testTaller() {
        System.out.println("=== Test Métodos del Taller ===");
        MiArrayListGenerico<String> lista = new MiArrayListGenerico<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        
        // Test 1: contains
        System.out.println("Contains 'B': " + lista.contains("B"));  // true
        System.out.println("Contains 'Z': " + lista.contains("Z"));  // false
        
        // Test 2: indexOf
        System.out.println("Index of 'B': " + lista.indexOf("B"));  // 1
        System.out.println("Index of 'Z': " + lista.indexOf("Z"));  // -1
        
        // Test 3: set
        lista.set(1, "X");
        System.out.println("After set(1, 'X'): " + lista.get(1));  // X
        
        // Test 4: add con índice
        lista.add(1, "Y");
        System.out.println("After add(1, 'Y'): ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }
        // Debería imprimir: A, Y, X, C
        
        // Test 5: clear
        int sizeBefore = lista.size();
        lista.clear();
        System.out.println("Size before clear: " + sizeBefore);
        System.out.println("After clear, size: " + lista.size());  // 0
        System.out.println("Is empty: " + lista.isEmpty());  // true
        System.out.println();
    }
    
    public static void testLibros() {
        System.out.println("=== Test con Objetos Custom (Libro) ===");
        
        // Lista de objetos custom
        MiArrayListGenerico<Libro> biblioteca = new MiArrayListGenerico<>();
        biblioteca.add(new Libro("1984", "Orwell"));
        biblioteca.add(new Libro("Quijote", "Cervantes"));
        biblioteca.add(new Libro("Cien años de soledad", "García Márquez"));
        
        Libro libro = biblioteca.get(0); // Type safe!
        System.out.println("Primer libro: " + libro.getTitulo());
        System.out.println("Biblioteca completa: " + biblioteca);
        
        // Test contains con objetos
        Libro buscar = new Libro("1984", "Orwell");
        System.out.println("Contiene 1984: " + biblioteca.contains(buscar));
        
        // Test remove
        Libro removido = biblioteca.remove(1);
        System.out.println("Libro removido: " + removido);
        System.out.println("Biblioteca después: " + biblioteca);
        System.out.println();
    }
    
    public static void testCrecimiento() {
        System.out.println("=== Test Crecimiento Automático ===");
        MiArrayListGenerico<Integer> numeros = new MiArrayListGenerico<>();
        
        // Agregar más de la capacidad inicial (10)
        for (int i = 0; i < 25; i++) {
            numeros.add(i);
        }
        System.out.println("25 elementos agregados, size: " + numeros.size());
        System.out.println("Primeros 5: " + numeros.get(0) + ", " + numeros.get(1) + 
                          ", " + numeros.get(2) + ", " + numeros.get(3) + ", " + numeros.get(4));
        System.out.println("Últimos 5: " + numeros.get(20) + ", " + numeros.get(21) + 
                          ", " + numeros.get(22) + ", " + numeros.get(23) + ", " + numeros.get(24));
        System.out.println();
    }
    
    public static void testExcepciones() {
        System.out.println("=== Test Excepciones ===");
        MiArrayListGenerico<String> lista = new MiArrayListGenerico<>();
        lista.add("A");
        lista.add("B");
        
        // Test índice inválido en get
        try {
            lista.get(5);
            System.out.println("ERROR: Debería haber lanzado excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("✅ get(5) lanzó excepción correctamente: " + e.getMessage());
        }
        
        // Test índice inválido en remove
        try {
            lista.remove(-1);
            System.out.println("ERROR: Debería haber lanzado excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("✅ remove(-1) lanzó excepción correctamente: " + e.getMessage());
        }
        
        // Test índice inválido en set
        try {
            lista.set(10, "Z");
            System.out.println("ERROR: Debería haber lanzado excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("✅ set(10, 'Z') lanzó excepción correctamente: " + e.getMessage());
        }
        
        // Test add con índice válido en el límite
        lista.add(lista.size(), "C"); // Esto debería funcionar
        System.out.println("✅ add(" + (lista.size()-1) + ", 'C') funcionó correctamente");
        System.out.println("Lista final: " + lista);
        System.out.println();
    }
}