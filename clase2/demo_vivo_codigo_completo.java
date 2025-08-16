// =================================================================
// DEMO EN VIVO - CLASE 2: ARRAYS
// Código para escribir paso a paso con los estudiantes
// =================================================================

// PASO 1: Demo básico con arrays (15 minutos)
public class BibliotecaDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO EN VIVO: ARRAYS ===");
        
        // PASO 1.1: Crear array (pregunta a estudiantes el tamaño)
        System.out.println("¿Cuántos libros debería tener nuestra biblioteca inicial?");
        // Respuesta típica: 5-10, elegir 5 para demo
        String[] biblioteca = new String[5];
        
        System.out.println("Array creado con capacidad: " + biblioteca.length);
        
        // PASO 1.2: Mostrar array vacío
        System.out.println("\n=== BIBLIOTECA INICIAL ===");
        for (int i = 0; i < biblioteca.length; i++) {
            System.out.println("Posición " + i + ": " + biblioteca[i]);
        }
        
        // PASO 1.3: Agregar libros (pide sugerencias a estudiantes)
        System.out.println("\n=== AGREGANDO LIBROS ===");
        System.out.println("¿Qué libros sugieren?");
        
        // Los estudiantes sugieren, escribir en vivo:
        biblioteca[0] = "El Quijote";
        System.out.println("Agregado: " + biblioteca[0]);
        
        biblioteca[1] = "1984";
        System.out.println("Agregado: " + biblioteca[1]);
        
        biblioteca[2] = "Cien años de soledad";
        System.out.println("Agregado: " + biblioteca[2]);
        
        // PASO 1.4: Mostrar biblioteca con contenido
        System.out.println("\n=== BIBLIOTECA ACTUAL ===");
        for (int i = 0; i < biblioteca.length; i++) {
            System.out.println("Posición " + i + ": " + biblioteca[i]);
        }
        
        // PASO 1.5: Buscar un libro (elegir uno que exista)
        System.out.println("\n=== BÚSQUEDA DE LIBRO ===");
        String buscar = "1984";
        System.out.println("Buscando: " + buscar);
        
        boolean encontrado = false;
        int posicionEncontrada = -1;
        
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i] != null && biblioteca[i].equals(buscar)) {
                encontrado = true;
                posicionEncontrada = i;
                break;
            }
        }
        
        if (encontrado) {
            System.out.println("✅ ¡Encontrado en posición: " + posicionEncontrada + "!");
        } else {
            System.out.println("❌ Libro no encontrado");
        }
        
        // PASO 1.6: Buscar libro que NO existe
        System.out.println("\n=== BÚSQUEDA DE LIBRO INEXISTENTE ===");
        String buscarInexistente = "Harry Potter";
        System.out.println("Buscando: " + buscarInexistente);
        
        encontrado = false;
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i] != null && biblioteca[i].equals(buscarInexistente)) {
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            System.out.println("✅ ¡Encontrado!");
        } else {
            System.out.println("❌ Libro no encontrado");
        }
        
        // PASO 1.7: Llenar el array completamente
        System.out.println("\n=== LLENANDO EL ARRAY ===");
        biblioteca[3] = "Hamlet";
        biblioteca[4] = "La Odisea";
        
        System.out.println("Array completo:");
        for (int i = 0; i < biblioteca.length; i++) {
            System.out.println("Posición " + i + ": " + biblioteca[i]);
        }
        
        // PASO 1.8: Intentar agregar MÁS libros (¡ERROR INTENCIONAL!)
        System.out.println("\n=== ¿QUÉ PASA SI AGREGAMOS MÁS? ===");
        System.out.println("Intentando agregar 'Don Quijote' en posición 5...");
        
        // COMENTAR ESTA LÍNEA PRIMERO, explicar qué pasaría:
        // biblioteca[5] = "Don Quijote"; // ¡ArrayIndexOutOfBoundsException!
        
        System.out.println("❌ ERROR: No podemos agregar más libros!");
        System.out.println("El array solo tiene " + biblioteca.length + " posiciones (0 a " + (biblioteca.length-1) + ")");
        
        // PAUSA: Preguntar a estudiantes qué problemas ven
        System.out.println("\n🤔 REFLEXIÓN:");
        System.out.println("¿Qué problemas ven con este enfoque?");
        System.out.println("¿Cómo podríamos solucionarlos?");
    }
}

// =================================================================
// PASO 2: Solución con clase organizada (20 minutos)
// =================================================================

public class BibliotecaSolucion {
    private String[] libros;
    private int contador; // ¡IMPORTANTE! Preguntar por qué necesitamos esto
    
    // Constructor
    public BibliotecaSolucion(int capacidad) {
        this.libros = new String[capacidad];
        this.contador = 0;
        System.out.println("Biblioteca creada con capacidad para " + capacidad + " libros");
    }
    
    // Método 1: Pregunta "¿Cómo buscarían ustedes un libro?"
    public int buscarLibro(String titulo) {
        System.out.println("Buscando: " + titulo);
        
        for (int i = 0; i < contador; i++) { // ¡IMPORTANTE! Solo hasta contador, no length
            if (libros[i].equals(titulo)) {
                System.out.println("✅ Encontrado en posición " + i);
                return i;
            }
        }
        
        System.out.println("❌ Libro no encontrado");
        return -1; // Convención: -1 significa "no encontrado"
    }
    
    // Método 2: Pregunta "¿Dónde ponemos el nuevo libro?"
    public boolean agregarLibro(String titulo) {
        // Validar si hay espacio
        if (contador >= libros.length) {
            System.out.println("❌ Error: Biblioteca llena (capacidad: " + libros.length + ")");
            return false;
        }
        
        // Validar que no sea null o vacío
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("❌ Error: El título no puede estar vacío");
            return false;
        }
        
        // Validar que no exista ya
        if (buscarLibro(titulo) != -1) {
            System.out.println("❌ Error: El libro ya existe en la biblioteca");
            return false;
        }
        
        // Agregar en la próxima posición disponible
        libros[contador] = titulo;
        contador++;
        System.out.println("✅ Libro agregado: " + titulo + " (Total: " + contador + ")");
        return true;
    }
    
    // Método 3: Pregunta "¿Cómo eliminamos sin dejar huecos?"
    public boolean eliminarLibro(String titulo) {
        int posicion = buscarLibro(titulo);
        if (posicion == -1) {
            return false; // No encontrado
        }
        
        System.out.println("Eliminando libro en posición " + posicion);
        
        // CLAVE: Desplazar elementos hacia la izquierda
        for (int i = posicion; i < contador - 1; i++) {
            libros[i] = libros[i + 1];
            System.out.println("Moviendo: " + libros[i + 1] + " de posición " + (i + 1) + " a " + i);
        }
        
        // Limpiar la última posición y decrementar contador
        contador--;
        libros[contador] = null;
        
        System.out.println("✅ Libro eliminado. Total actual: " + contador);
        return true;
    }
    
    // Método 4: Pregunta "¿Cómo mostramos solo los libros reales?"
    public void mostrarBiblioteca() {
        System.out.println("\n=== BIBLIOTECA (" + contador + "/" + libros.length + " libros) ===");
        
        if (contador == 0) {
            System.out.println("La biblioteca está vacía");
            return;
        }
        
        for (int i = 0; i < contador; i++) { // ¡Solo hasta contador!
            System.out.println(i + ": " + libros[i]);
        }
        System.out.println("=== FIN BIBLIOTECA ===\n");
    }
    
    // Métodos adicionales útiles
    public boolean estaLlena() {
        return contador >= libros.length;
    }
    
    public boolean estaVacia() {
        return contador == 0;
    }
    
    public int getContador() {
        return contador;
    }
    
    public int getCapacidad() {
        return libros.length;
    }
    
    public double getPorcentajeUso() {
        return (double) contador / libros.length * 100;
    }
}

// =================================================================
// PASO 3: Clase de prueba (10 minutos)
// =================================================================

public class PruebaBiblioteca {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE NUESTRA BIBLIOTECA ===\n");
        
        // Crear biblioteca
        BibliotecaSolucion biblioteca = new BibliotecaSolucion(5);
        
        // Probar agregar libros
        System.out.println("--- AGREGANDO LIBROS ---");
        biblioteca.agregarLibro("El Quijote");
        biblioteca.agregarLibro("1984");
        biblioteca.agregarLibro("Hamlet");
        biblioteca.mostrarBiblioteca();
        
        // Probar búsqueda exitosa
        System.out.println("--- BÚSQUEDA EXITOSA ---");
        biblioteca.buscarLibro("1984");
        
        // Probar búsqueda fallida
        System.out.println("\n--- BÚSQUEDA FALLIDA ---");
        biblioteca.buscarLibro("Harry Potter");
        
        // Probar eliminación
        System.out.println("\n--- ELIMINANDO LIBRO ---");
        biblioteca.eliminarLibro("1984");
        biblioteca.mostrarBiblioteca();
        
        // Llenar completamente
        System.out.println("--- LLENANDO BIBLIOTECA ---");
        biblioteca.agregarLibro("La Odisea");
        biblioteca.agregarLibro("Cien años de soledad");
        biblioteca.agregarLibro("Don Quijote"); // Debería funcionar
        biblioteca.agregarLibro("Otro libro"); // Este debería fallar
        biblioteca.mostrarBiblioteca();
        
        // Mostrar estadísticas
        System.out.println("--- ESTADÍSTICAS ---");
        System.out.println("Libros actuales: " + biblioteca.getContador());
        System.out.println("Capacidad total: " + biblioteca.getCapacidad());
        System.out.printf("Porcentaje de uso: %.1f%%\n", biblioteca.getPorcentajeUso());
        System.out.println("¿Está llena? " + biblioteca.estaLlena());
        System.out.println("¿Está vacía? " + biblioteca.estaVacia());
    }
}

// =================================================================
// DEMO RÁPIDO DE MATRICES (10 minutos)
// =================================================================

public class MatrizNotasDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO MATRICES: NOTAS DE ESTUDIANTES ===\n");
        
        // Crear matriz 3x4 (3 estudiantes, 4 materias)
        // Preguntar a estudiantes qué notas poner
        double[][] notas = {
            {4.5, 3.8, 4.2, 3.9}, // Estudiante 1
            {3.5, 4.0, 3.7, 4.1}, // Estudiante 2  
            {4.8, 4.5, 4.9, 4.3}  // Estudiante 3
        };
        
        String[] materias = {"Matemáticas", "Física", "Química", "Programación"};
        
        // Mostrar matriz completa
        System.out.println("=== NOTAS POR ESTUDIANTE ===");
        System.out.print("Estudiante\t");
        for (String materia : materias) {
            System.out.print(materia + "\t");
        }
        System.out.println();
        
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Est-" + (i+1) + "\t\t");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print(notas[i][j] + "\t\t");
            }
            System.out.println();
        }
        
        // Calcular promedio por estudiante
        System.out.println("\n=== PROMEDIOS POR ESTUDIANTE ===");
        for (int i = 0; i < notas.length; i++) {
            double suma = 0;
            for (int j = 0; j < notas[i].length; j++) {
                suma += notas[i][j];
            }
            double promedio = suma / notas[i].length;
            System.out.printf("Estudiante %d: %.2f\n", (i+1), promedio);
        }
        
        // Calcular promedio por materia
        System.out.println("\n=== PROMEDIOS POR MATERIA ===");
        for (int j = 0; j < materias.length; j++) {
            double suma = 0;
            for (int i = 0; i < notas.length; i++) {
                suma += notas[i][j];
            }
            double promedio = suma / notas.length;
            System.out.printf("%s: %.2f\n", materias[j], promedio);
        }
        
        // Encontrar mejor estudiante
        System.out.println("\n=== MEJOR ESTUDIANTE ===");
        double mejorPromedio = 0;
        int mejorEstudiante = 0;
        
        for (int i = 0; i < notas.length; i++) {
            double suma = 0;
            for (int j = 0; j < notas[i].length; j++) {
                suma += notas[i][j];
            }
            double promedio = suma / notas[i].length;
            
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorEstudiante = i;
            }
        }
        
        System.out.printf("El mejor estudiante es el Estudiante %d con promedio %.2f\n", 
                         (mejorEstudiante + 1), mejorPromedio);
    }
}

/*
TIPS PARA EL DEMO EN VIVO:
========================

1. ERRORES INTENCIONALES:
   - Comentar la línea biblioteca[5] y explicar el error
   - Intentar buscar en array completo vs solo hasta contador
   - Mostrar qué pasa si no validamos entradas

2. PREGUNTAS PARA ESTUDIANTES:
   - "¿Qué tamaño le ponemos al array?"
   - "¿Qué libros sugieren?"
   - "¿Por qué necesitamos una variable contador?"
   - "¿Cómo eliminamos sin dejar huecos?"
   - "¿Qué notas le ponemos a cada estudiante?"

3. MOMENTOS DE PAUSA:
   - Después de mostrar el array vacío con nulls
   - Cuando el array se llena y no podemos agregar más
   - Al explicar por qué usamos contador vs length
   - Al mostrar cómo se desplazan elementos al eliminar

4. CELEBRAR ÉXITOS:
   - Cuando algo funciona bien: "¡Excelente!"
   - Cuando encuentran un error: "¡Perfecto error!"
   - Cuando entienden un concepto: "¡Ahí está!"

5. REFACTORING EN VIVO:
   - Empezar con código simple y mejorarlo
   - Mostrar cómo extraer métodos
   - Agregar validaciones paso a paso
*/