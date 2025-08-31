import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Clase para realizar benchmarks de rendimiento entre diferentes implementaciones de listas.
 * Compara MyLinkedList (implementación propia), ArrayList y LinkedList de Java.
 * 
 * @author Clase de Estructuras de Datos - Semana 4
 */
public class BenchmarkTest {
    
    private static final int SMALL_SIZE = 1_000;
    private static final int MEDIUM_SIZE = 10_000;
    private static final int LARGE_SIZE = 100_000;
    private static final Random random = new Random(42); // Seed fijo para resultados reproducibles
    
    public static void main(String[] args) {
        System.out.println("⚡ BENCHMARK: COMPARACIÓN DE RENDIMIENTO");
        System.out.println("=" .repeat(80));
        
        // Warming up JVM
        System.out.println("🔥 Calentando la JVM...");
        warmUp();
        
        System.out.println("\n📊 RESULTADOS DE BENCHMARKS");
        System.out.println("=" .repeat(80));
        
        // Ejecutar benchmarks
        benchmarkInsertAtBeginning();
        benchmarkInsertAtEnd();
        benchmarkRandomAccess();
        benchmarkIteration();
        benchmarkSearchOperations();
        
        // Conclusiones
        printConclusions();
    }
    
    /**
     * Calentar la JVM para obtener mediciones más precisas
     */
    private static void warmUp() {
        MyLinkedList<Integer> warmUpList = new MyLinkedList<>();
        ArrayList<Integer> warmUpArray = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            warmUpList.add(i);
            warmUpArray.add(i);
            warmUpList.contains(i);
            warmUpArray.contains(i);
        }
    }
    
    /**
     * Benchmark: Inserción al inicio
     * Operación donde LinkedList debería ser superior
     */
    private static void benchmarkInsertAtBeginning() {
        System.out.println("\n🚀 BENCHMARK 1: INSERCIÓN AL INICIO");
        System.out.println("-".repeat(50));
        
        int[] sizes = {SMALL_SIZE, MEDIUM_SIZE};
        
        for (int size : sizes) {
            System.out.printf("\n📏 Insertando %,d elementos al INICIO:%n", size);
            
            // MyLinkedList (nuestra implementación)
            long myLinkedTime = measureInsertAtBeginning(size, "MyLinkedList");
            
            // ArrayList (para comparación)
            long arrayListTime = measureArrayListInsertAtBeginning(size);
            
            // LinkedList de Java (para referencia)
            long javaLinkedTime = measureJavaLinkedListInsertAtBeginning(size);
            
            // Mostrar resultados
            System.out.printf("%-20s: %,8d ms%n", "MyLinkedList", myLinkedTime);
            System.out.printf("%-20s: %,8d ms (%.1fx más lento)%n", 
                             "ArrayList", arrayListTime, (double)arrayListTime / myLinkedTime);
            System.out.printf("%-20s: %,8d ms (%.1fx comparado a nuestra)%n", 
                             "Java LinkedList", javaLinkedTime, (double)javaLinkedTime / myLinkedTime);
            
            System.out.println("📈 Análisis:");
            if (myLinkedTime < arrayListTime) {
                System.out.println("   ✅ MyLinkedList es más eficiente que ArrayList para inserción al inicio");
            }
            System.out.printf("   🎯 MyLinkedList es O(1), ArrayList es O(n) para inserción al inicio%n");
        }
    }
    
    /**
     * Benchmark: Inserción al final
     * Operación donde ArrayList debería ser superior
     */
    private static void benchmarkInsertAtEnd() {
        System.out.println("\n🎯 BENCHMARK 2: INSERCIÓN AL FINAL");
        System.out.println("-".repeat(50));
        
        int[] sizes = {SMALL_SIZE, MEDIUM_SIZE};
        
        for (int size : sizes) {
            System.out.printf("\n📏 Insertando %,d elementos al FINAL:%n", size);
            
            // MyLinkedList
            long myLinkedTime = measureInsertAtEnd(size, "MyLinkedList");
            
            // ArrayList
            long arrayListTime = measureArrayListInsertAtEnd(size);
            
            // LinkedList de Java
            long javaLinkedTime = measureJavaLinkedListInsertAtEnd(size);
            
            System.out.printf("%-20s: %,8d ms%n", "MyLinkedList", myLinkedTime);
            System.out.printf("%-20s: %,8d ms (%.1fx más rápido)%n", 
                             "ArrayList", arrayListTime, (double)myLinkedTime / arrayListTime);
            System.out.printf("%-20s: %,8d ms%n", "Java LinkedList", javaLinkedTime);
            
            System.out.println("📈 Análisis:");
            if (arrayListTime < myLinkedTime) {
                System.out.println("   ✅ ArrayList es más eficiente para inserción al final");
                System.out.println("   🎯 ArrayList es O(1) amortizado, LinkedList es O(n)");
            }
        }
    }
    
    /**
     * Benchmark: Acceso aleatorio por índice
     * Operación donde ArrayList debería dominar completamente
     */
    private static void benchmarkRandomAccess() {
        System.out.println("\n🔍 BENCHMARK 3: ACCESO ALEATORIO POR ÍNDICE");
        System.out.println("-".repeat(50));
        
        int size = SMALL_SIZE; // Usamos tamaño pequeño porque LinkedList será muy lento
        int accessCount = 1000;
        
        System.out.printf("📏 Lista de %,d elementos, %,d accesos aleatorios:%n", size, accessCount);
        
        // Preparar listas con datos
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            myList.add(i);
            arrayList.add(i);
        }
        
        // MyLinkedList - acceso aleatorio
        long start = System.currentTimeMillis();
        for (int i = 0; i < accessCount; i++) {
            int randomIndex = random.nextInt(size);
            myList.get(randomIndex);
        }
        long myLinkedTime = System.currentTimeMillis() - start;
        
        // ArrayList - acceso aleatorio
        start = System.currentTimeMillis();
        for (int i = 0; i < accessCount; i++) {
            int randomIndex = random.nextInt(size);
            arrayList.get(randomIndex);
        }
        long arrayListTime = System.currentTimeMillis() - start;
        
        System.out.printf("%-20s: %,8d ms%n", "MyLinkedList", myLinkedTime);
        System.out.printf("%-20s: %,8d ms (%.0fx más rápido)%n", 
                         "ArrayList", arrayListTime, (double)myLinkedTime / arrayListTime);
        
        System.out.println("📈 Análisis:");
        System.out.println("   ✅ ArrayList domina completamente en acceso aleatorio");
        System.out.println("   🎯 ArrayList: O(1) por acceso, LinkedList: O(n) por acceso");
        System.out.println("   ⚠️  NUNCA uses get(i) en un for-loop con LinkedList");
    }
    
    /**
     * Benchmark: Iteración completa
     * Operación donde ambas deberían ser similares
     */
    private static void benchmarkIteration() {
        System.out.println("\n🔄 BENCHMARK 4: ITERACIÓN COMPLETA");
        System.out.println("-".repeat(50));
        
        int size = MEDIUM_SIZE;
        
        System.out.printf("📏 Iterando sobre %,d elementos:%n", size);
        
        // Preparar listas
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> javaList = new LinkedList<>();
        
        for (int i = 0; i < size; i++) {
            myList.add(i);
            arrayList.add(i);
            javaList.add(i);
        }
        
        // MyLinkedList con enhanced for-loop
        long start = System.currentTimeMillis();
        long sum = 0;
        for (Integer value : myList) {
            sum += value;
        }
        long myLinkedTime = System.currentTimeMillis() - start;
        
        // ArrayList con enhanced for-loop
        start = System.currentTimeMillis();
        sum = 0;
        for (Integer value : arrayList) {
            sum += value;
        }
        long arrayListTime = System.currentTimeMillis() - start;
        
        // Java LinkedList con enhanced for-loop
        start = System.currentTimeMillis();
        sum = 0;
        for (Integer value : javaList) {
            sum += value;
        }
        long javaLinkedTime = System.currentTimeMillis() - start;
        
        System.out.printf("%-20s: %,8d ms%n", "MyLinkedList", myLinkedTime);
        System.out.printf("%-20s: %,8d ms%n", "ArrayList", arrayListTime);
        System.out.printf("%-20s: %,8d ms%n", "Java LinkedList", javaLinkedTime);
        
        System.out.println("📈 Análisis:");
        System.out.println("   ✅ Todas son O(n) para iteración completa");
        System.out.println("   🎯 Enhanced for-loop es eficiente para ambas estructuras");
    }
    
    /**
     * Benchmark: Operaciones de búsqueda
     */
    private static void benchmarkSearchOperations() {
        System.out.println("\n🔍 BENCHMARK 5: OPERACIONES DE BÚSQUEDA");
        System.out.println("-".repeat(50));
        
        int size = MEDIUM_SIZE;
        int searchCount = 100;
        
        System.out.printf("📏 Lista de %,d elementos, %,d búsquedas:%n", size, searchCount);
        
        // Preparar listas
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            myList.add(i);
            arrayList.add(i);
        }
        
        // MyLinkedList - contains
        long start = System.currentTimeMillis();
        for (int i = 0; i < searchCount; i++) {
            int searchValue = random.nextInt(size);
            myList.contains(searchValue);
        }
        long myLinkedTime = System.currentTimeMillis() - start;
        
        // ArrayList - contains
        start = System.currentTimeMillis();
        for (int i = 0; i < searchCount; i++) {
            int searchValue = random.nextInt(size);
            arrayList.contains(searchValue);
        }
        long arrayListTime = System.currentTimeMillis() - start;
        
        System.out.printf("%-20s: %,8d ms%n", "MyLinkedList", myLinkedTime);
        System.out.printf("%-20s: %,8d ms%n", "ArrayList", arrayListTime);
        
        System.out.println("📈 Análisis:");
        System.out.println("   ✅ Ambas son O(n) para búsqueda lineal");
        System.out.println("   🎯 Rendimiento similar para contains()");
    }
    
    /**
     * Mediciones específicas para cada tipo de operación
     */
    private static long measureInsertAtBeginning(int size, String type) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.addFirst(i);
        }
        return System.currentTimeMillis() - start;
    }
    
    private static long measureArrayListInsertAtBeginning(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        return System.currentTimeMillis() - start;
    }
    
    private static long measureJavaLinkedListInsertAtBeginning(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.addFirst(i);
        }
        return System.currentTimeMillis() - start;
    }
    
    private static long measureInsertAtEnd(int size, String type) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }
    
    private static long measureArrayListInsertAtEnd(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }
    
    private static long measureJavaLinkedListInsertAtEnd(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }
    
    /**
     * Imprime conclusiones del benchmark
     */
    private static void printConclusions() {
        System.out.println("\n🎯 CONCLUSIONES DEL BENCHMARK");
        System.out.println("=" .repeat(60));
        
        System.out.println("\n✅ CUÁNDO USAR LINKEDLIST:");
        System.out.println("   • Muchas inserciones/eliminaciones al INICIO");
        System.out.println("   • Historial de navegación, Stack, Queue");
        System.out.println("   • Tamaño muy variable e impredecible");
        System.out.println("   • Poco o nulo acceso aleatorio por índice");
        
        System.out.println("\n✅ CUÁNDO USAR ARRAYLIST:");
        System.out.println("   • Acceso frecuente por índice (get/set)");
        System.out.println("   • Inserciones principalmente al final");
        System.out.println("   • Búsquedas aleatorias frecuentes");
        System.out.println("   • Memoria limitada (menos overhead)");
        
        System.out.println("\n⚠️  ANTIPATRONES A EVITAR:");
        System.out.println("   • NUNCA: for(int i=0; i<linkedList.size(); i++) linkedList.get(i)");
        System.out.println("   • NUNCA: ArrayList.add(0, element) en loops grandes");
        System.out.println("   • SIEMPRE: usa enhanced for-loop para recorridos");
        
        System.out.println("\n🏆 RESULTADOS CLAVE:");
        System.out.println("   • LinkedList.addFirst(): O(1) vs ArrayList.add(0): O(n)");
        System.out.println("   • ArrayList.get(i): O(1) vs LinkedList.get(i): O(n)");
        System.out.println("   • Iteración: ambas O(n) con enhanced for-loop");
        System.out.println("   • Memoria: ArrayList ~25% menos overhead que LinkedList");
        
        System.out.println("\n🎓 LECCIÓN PRINCIPAL:");
        System.out.println("   La elección de estructura de datos IMPORTA.");
        System.out.println("   Una mala elección puede hacer tu programa 100x más lento.");
        System.out.println("   ¡Siempre considera el patrón de uso antes de decidir!");
    }
}