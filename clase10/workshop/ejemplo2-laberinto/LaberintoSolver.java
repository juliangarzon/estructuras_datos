import java.util.*;

/**
 * EJEMPLO 2: LABERINTO
 *
 * Encontrar un camino desde el inicio (S) hasta la meta (E) en un grid
 * con obstáculos (X) y espacios libres (.).
 *
 * Input:
 *   S . .
 *   . X .
 *   . . E
 *
 * Output: ["(0,0)", "(1,0)", "(2,0)", "(2,1)", "(2,2)"]
 *
 * PATRÓN DE BACKTRACKING:
 * 1️⃣ VALIDAR: ¿La posición es válida? (dentro del grid, no pared, no visitada)
 * 2️⃣ HACER: Marcar como visitado y agregar al camino
 * 3️⃣ EXPLORAR: Intentar 4 direcciones (arriba, abajo, izquierda, derecha)
 * 4️⃣ DESHACER: Desmarcar visitado y quitar del camino (backtrack)
 */
public class LaberintoSolver {

    private char[][] grid;
    private boolean[][] visitado;
    private int filas;
    private int columnas;

    /**
     * Encuentra un camino desde S hasta E en el grid.
     *
     * @param grid Matriz con 'S' (inicio), 'E' (meta), 'X' (pared), '.' (libre)
     * @return Lista de coordenadas del camino, o null si no existe camino
     */
    public List<String> encontrarCamino(char[][] grid) {
        this.grid = grid;
        this.filas = grid.length;
        this.columnas = grid[0].length;
        this.visitado = new boolean[filas][columnas];

        // Encontrar posición de inicio (S)
        int inicioX = -1, inicioY = -1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (grid[i][j] == 'S') {
                    inicioX = i;
                    inicioY = j;
                }
            }
        }

        List<String> camino = new ArrayList<>();

        // Iniciar backtracking desde la posición de inicio
        if (backtrack(inicioX, inicioY, camino)) {
            return camino; // Camino encontrado ✅
        }

        return null; // No hay camino ❌
    }


    /**
     * Función recursiva de backtracking para encontrar camino.
     *
     * @param x      Coordenada X (fila) actual
     * @param y      Coordenada Y (columna) actual
     * @param camino Lista donde guardamos el camino
     * @return true si encontramos camino a la meta, false si no
     */
    private boolean backtrack(int x, int y, List<String> camino) {

        // ============================================================
        // TODO 1: VALIDACIÓN
        // ============================================================
        // ¿Es esta posición válida para visitar?
        // Usa el método esValido(x, y) que implementarás abajo
        //
        // Si NO es válida, retorna false
        //
        // Escribe tu código aquí:

        if (false) { // TODO: Cambia 'false' por !esValido(x, y)
            return false;
        }


        // ============================================================
        // TODO 2: CASO BASE
        // ============================================================
        // ¿Llegamos a la meta?
        // Pista: Verifica si grid[x][y] == 'E'
        //
        // Si llegamos:
        // 1. Agregar la coordenada al camino: camino.add("(" + x + "," + y + ")")
        // 2. Retornar true (¡encontramos la meta!)
        //
        // Escribe tu código aquí:

        if (false) { // TODO: Cambia 'false' por la condición correcta
            // TODO: Agregar coordenada al camino

            return true;
        }


        // ============================================================
        // TODO 3: HACER
        // ============================================================
        // Marcar esta posición como visitada y agregarla al camino
        //
        // 1. visitado[x][y] = true
        // 2. camino.add("(" + x + "," + y + ")")
        //
        // Escribe tu código aquí:

        // TODO: Marcar como visitado

        // TODO: Agregar al camino


        // ============================================================
        // TODO 4: EXPLORAR - Probar 4 direcciones
        // ============================================================
        // Intentar moverse en las 4 direcciones:
        // - ABAJO:     (x + 1, y)
        // - DERECHA:   (x, y + 1)
        // - ARRIBA:    (x - 1, y)
        // - IZQUIERDA: (x, y - 1)
        //
        // Si alguna dirección retorna true, retornar true inmediatamente
        //
        // Ejemplo:
        // if (backtrack(x + 1, y, camino)) return true; // Abajo
        //
        // Escribe tu código aquí:

        // TODO: Probar ir ABAJO (x + 1, y)


        // TODO: Probar ir DERECHA (x, y + 1)


        // TODO: Probar ir ARRIBA (x - 1, y)


        // TODO: Probar ir IZQUIERDA (x, y - 1)



        // ============================================================
        // TODO 5: DESHACER (BACKTRACK)
        // ============================================================
        // Ninguna dirección llevó a la meta, debemos retroceder
        //
        // 1. visitado[x][y] = false (desmarcar)
        // 2. camino.remove(camino.size() - 1) (quitar del camino)
        //
        // ⚠️ ESTE ES EL BACKTRACK
        //
        // Escribe tu código aquí:

        // TODO: Desmarcar visitado

        // TODO: Quitar del camino


        return false; // No encontramos camino desde aquí
    }


    /**
     * Verifica si una posición (x, y) es válida para visitar.
     *
     * @param x Coordenada X (fila)
     * @param y Coordenada Y (columna)
     * @return true si es válida, false si no
     */
    private boolean esValido(int x, int y) {

        // ============================================================
        // TODO 6: VALIDAR LÍMITES
        // ============================================================
        // Verificar que (x, y) esté dentro del grid
        //
        // Condiciones que hacen una posición INVÁLIDA:
        // - x < 0
        // - x >= filas
        // - y < 0
        // - y >= columnas
        //
        // Si alguna se cumple, retornar false
        //
        // Escribe tu código aquí:

        if (false) { // TODO: Completa la condición
            return false;
        }


        // ============================================================
        // TODO 7: VALIDAR PARED
        // ============================================================
        // Verificar que no sea una pared
        // Pista: grid[x][y] == 'X'
        //
        // Escribe tu código aquí:

        if (false) { // TODO: Completa la condición
            return false;
        }


        // ============================================================
        // TODO 8: VALIDAR VISITADO
        // ============================================================
        // Verificar que no hayamos visitado esta celda antes
        // Pista: visitado[x][y]
        //
        // Escribe tu código aquí:

        if (false) { // TODO: Completa la condición
            return false;
        }


        return true; // ¡Posición válida!
    }


    // ============================================================
    // MÉTODO AUXILIAR (OPCIONAL - PARA DEBUGGING)
    // ============================================================
    /**
     * Imprime el camino de forma legible.
     */
    public void imprimirCamino(List<String> camino) {
        if (camino == null) {
            System.out.println("❌ No existe camino");
            return;
        }

        System.out.println("✅ Camino encontrado:");
        System.out.println("   " + String.join(" → ", camino));
        System.out.println("   Total de pasos: " + camino.size());
    }


    /**
     * Imprime el grid de forma visual.
     */
    public void imprimirGrid(char[][] grid) {
        System.out.println("Grid:");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("   ");
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    // ============================================================
    // MAIN (PARA PROBAR MANUALMENTE)
    // ============================================================
    public static void main(String[] args) {
        LaberintoSolver solver = new LaberintoSolver();

        // Prueba 1: Grid simple con obstáculo
        System.out.println("========== PRUEBA 1 ==========");
        char[][] grid1 = {
            {'S', '.', '.'},
            {'.', 'X', '.'},
            {'.', '.', 'E'}
        };

        solver.imprimirGrid(grid1);
        List<String> camino1 = solver.encontrarCamino(grid1);
        solver.imprimirCamino(camino1);

        System.out.println();

        // Prueba 2: Sin obstáculos
        System.out.println("========== PRUEBA 2 ==========");
        char[][] grid2 = {
            {'S', '.', '.', 'E'}
        };

        solver.imprimirGrid(grid2);
        List<String> camino2 = solver.encontrarCamino(grid2);
        solver.imprimirCamino(camino2);
    }
}
