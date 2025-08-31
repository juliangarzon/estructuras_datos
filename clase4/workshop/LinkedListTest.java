/**
 * Clase de pruebas para la implementación MyLinkedList.
 * Incluye tests básicos, casos extremos y demostraciones didácticas.
 * 
 * @author Clase de Estructuras de Datos - Semana 4
 */
public class LinkedListTest {
    
    public static void main(String[] args) {
        System.out.println("🔗 TESTING MYLINKEDLIST - IMPLEMENTACIÓN PROPIA");
        System.out.println("=" .repeat(60));
        
        // Ejecutar todas las pruebas
        testBasicOperations();
        testIterator();
        testEdgeCases();
        testAdvancedMethods();
        testManualNodeCreation();
        
        System.out.println("\n✅ ¡TODAS LAS PRUEBAS COMPLETADAS!");
    }
    
    /**
     * Pruebas de operaciones básicas de la LinkedList
     */
    public static void testBasicOperations() {
        System.out.println("\n📝 TEST 1: OPERACIONES BÁSICAS");
        System.out.println("-".repeat(40));
        
        MyLinkedList<String> lista = new MyLinkedList<>();
        
        // Test lista vacía
        System.out.println("Lista vacía:");
        System.out.println("isEmpty(): " + lista.isEmpty());
        System.out.println("size(): " + lista.size());
        lista.display();
        
        // Test add() al final
        System.out.println("\nAgregando elementos al final:");
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.display();
        System.out.println("size(): " + lista.size());
        
        // Test addFirst() - O(1)
        System.out.println("\nAgregando al inicio (O(1)):");
        lista.addFirst("PRIMERO");
        lista.display();
        
        // Test add(index, element)
        System.out.println("\nInsertando en posición específica:");
        lista.add(2, "MEDIO");
        lista.display();
        
        // Test get()
        System.out.println("\nAccediendo por índice:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("get(" + i + ") = " + lista.get(i));
        }
        
        // Test contains e indexOf
        System.out.println("\nBúsquedas:");
        System.out.println("contains('B'): " + lista.contains("B"));
        System.out.println("indexOf('C'): " + lista.indexOf("C"));
        System.out.println("contains('Z'): " + lista.contains("Z"));
        
        // Test remove
        System.out.println("\nEliminaciones:");
        System.out.println("Elemento eliminado: " + lista.remove(0));
        lista.display();
        
        System.out.println("remove('B'): " + lista.remove("B"));
        lista.display();
        
        System.out.println("toString(): " + lista.toString());
    }
    
    /**
     * Pruebas del patrón Iterator
     */
    public static void testIterator() {
        System.out.println("\n🔄 TEST 2: PATRÓN ITERATOR");
        System.out.println("-".repeat(40));
        
        MyLinkedList<Integer> numeros = new MyLinkedList<>();
        
        // Agregar números
        for (int i = 1; i <= 5; i++) {
            numeros.add(i * 10);
        }
        
        System.out.println("Lista original:");
        numeros.display();
        
        // Test iterator manual
        System.out.println("\nRecorrido con Iterator manual:");
        var iterator = numeros.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Test enhanced for-loop
        System.out.println("\nRecorrido con enhanced for-loop:");
        for (Integer num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Comparación de eficiencia de recorridos
        System.out.println("\n⚠️  COMPARACIÓN DE EFICIENCIA:");
        System.out.println("Enhanced for-loop (recomendado): O(n)");
        System.out.println("For tradicional con get(i): O(n²) - ¡EVITAR!");
        
        // Demostrar por qué get(i) es ineficiente
        System.out.println("\nDemostración - Recorrido ineficiente con get(i):");
        long start = System.nanoTime();
        for (int i = 0; i < numeros.size(); i++) {
            numeros.get(i); // O(n) por cada acceso
        }
        long inefficientTime = System.nanoTime() - start;
        
        System.out.println("\nRecorrido eficiente con iterator:");
        start = System.nanoTime();
        for (Integer num : numeros) {
            // Solo acceso, no operación
        }
        long efficientTime = System.nanoTime() - start;
        
        System.out.printf("Tiempo ineficiente: %d ns%n", inefficientTime);
        System.out.printf("Tiempo eficiente: %d ns%n", efficientTime);
    }
    
    /**
     * Pruebas de casos extremos y manejo de errores
     */
    public static void testEdgeCases() {
        System.out.println("\n⚠️  TEST 3: CASOS EXTREMOS");
        System.out.println("-".repeat(40));
        
        MyLinkedList<String> lista = new MyLinkedList<>();
        
        // Test operaciones en lista vacía
        System.out.println("Operaciones en lista vacía:");
        try {
            lista.getFirst();
        } catch (Exception e) {
            System.out.println("getFirst() en lista vacía: " + e.getMessage());
        }
        
        try {
            lista.get(0);
        } catch (Exception e) {
            System.out.println("get(0) en lista vacía: " + e.getMessage());
        }
        
        try {
            lista.removeFirst();
        } catch (Exception e) {
            System.out.println("removeFirst() en lista vacía: " + e.getMessage());
        }
        
        // Test índices fuera de rango
        lista.add("Único");
        System.out.println("\nÍndices fuera de rango:");
        try {
            lista.get(5);
        } catch (Exception e) {
            System.out.println("get(5) con size=1: " + e.getMessage());
        }
        
        try {
            lista.add(10, "Imposible");
        } catch (Exception e) {
            System.out.println("add(10, element) con size=1: " + e.getMessage());
        }
        
        // Test con elementos null
        System.out.println("\nManejo de elementos null:");
        lista.add(null);
        lista.add("Normal");
        lista.add(null);
        lista.display();
        System.out.println("contains(null): " + lista.contains(null));
        System.out.println("indexOf(null): " + lista.indexOf(null));
        
        // Test clear
        System.out.println("\nLimpieza de lista:");
        lista.clear();
        System.out.println("Después de clear() - size: " + lista.size());
        System.out.println("isEmpty(): " + lista.isEmpty());
    }
    
    /**
     * Pruebas de métodos avanzados
     */
    public static void testAdvancedMethods() {
        System.out.println("\n🚀 TEST 4: MÉTODOS AVANZADOS");
        System.out.println("-".repeat(40));
        
        MyLinkedList<Character> letras = new MyLinkedList<>();
        
        // Construir lista: A → B → C → D → E
        for (char c = 'A'; c <= 'E'; c++) {
            letras.add(c);
        }
        
        System.out.println("Lista original:");
        letras.display();
        
        // Test reverse
        System.out.println("\nDespués de reverse():");
        letras.reverse();
        letras.display();
        
        // Volver al orden original para otros tests
        letras.reverse();
        
        // Test findMiddle
        System.out.println("\nElemento del medio: " + letras.findMiddle());
        
        // Test toArray
        System.out.println("\nConversión a array:");
        Object[] array = letras.toArray();
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        // Test debug info
        System.out.println("\nInformación de debugging:");
        letras.displayDebug();
    }
    
    /**
     * Demostración de creación manual de nodos (como en las slides)
     */
    public static void testManualNodeCreation() {
        System.out.println("\n🧩 TEST 5: CREACIÓN MANUAL DE NODOS");
        System.out.println("-".repeat(40));
        
        // Crear nodos manualmente como se muestra en las slides
        Node<String> primero = new Node<>("A");
        Node<String> segundo = new Node<>("B");
        Node<String> tercero = new Node<>("C");
        
        // Conectar los nodos
        primero.next = segundo;
        segundo.next = tercero;
        tercero.next = null; // Último nodo
        
        System.out.println("Nodos creados manualmente:");
        System.out.println("Primero: " + primero);
        System.out.println("Segundo: " + segundo);
        System.out.println("Tercero: " + tercero);
        
        // Recorrido manual
        System.out.println("\nRecorrido manual desde el primer nodo:");
        Node<String> current = primero;
        int index = 0;
        while (current != null) {
            System.out.println("Posición " + index + ": " + current.data);
            current = current.next;
            index++;
        }
        
        // Demostrar información detallada de debugging
        System.out.println("\nInformación detallada de nodos:");
        System.out.println("Primero: " + primero.toDetailedString());
        System.out.println("Segundo: " + segundo.toDetailedString());
        System.out.println("Tercero: " + tercero.toDetailedString());
    }
    
    /**
     * Método auxiliar para crear una lista con elementos de ejemplo
     */
    public static MyLinkedList<String> createSampleList() {
        MyLinkedList<String> lista = new MyLinkedList<>();
        lista.add("Google");
        lista.add("Facebook");
        lista.add("YouTube");
        return lista;
    }
    
    /**
     * Simulación del caso de uso real: Historial de navegación
     */
    public static void demonstrateBrowserHistory() {
        System.out.println("\n🌐 DEMOSTRACIÓN: HISTORIAL DE NAVEGACIÓN");
        System.out.println("-".repeat(50));
        
        MyLinkedList<String> historial = new MyLinkedList<>();
        
        // Páginas iniciales
        historial.add("Google");
        historial.add("Facebook");
        historial.add("YouTube");
        
        System.out.println("Historial inicial:");
        historial.display();
        
        // Usuario visita nueva página - debe ir AL INICIO
        System.out.println("\nUsuario visita GitHub (al inicio - O(1)):");
        historial.addFirst("GitHub");
        historial.display();
        
        System.out.println("\nUsuario visita Stack Overflow:");
        historial.addFirst("Stack Overflow");
        historial.display();
        
        System.out.println("\nPágina más reciente: " + historial.getFirst());
        System.out.println("Total de páginas visitadas: " + historial.size());
        
        // Mostrar últimas 3 páginas
        System.out.println("\nÚltimas 3 páginas visitadas:");
        int count = 0;
        for (String pagina : historial) {
            if (count >= 3) break;
            System.out.println((count + 1) + ". " + pagina);
            count++;
        }
    }
}