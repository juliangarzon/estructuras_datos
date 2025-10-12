import java.util.*;

/**
 * EJEMPLO 3: N-REINAS
 *
 * Colocar N reinas en un tablero NxN sin que se ataquen entre sí.
 *
 * Restricciones:
 * - Una reina NO puede estar en la misma fila que otra
 * - Una reina NO puede estar en la misma columna que otra
 * - Una reina NO puede estar en la misma diagonal que otra
 *
 * Input:  N = 4
 * Output: [1, 3, 0, 2]
 *
 * Interpretación: tablero[fila] = columna
 * - Fila 0: reina en columna 1 → . Q . .
 * - Fila 1: reina en columna 3 → . . . Q
 * - Fila 2: reina en columna 0 → Q . . .
 * - Fila 3: reina en columna 2 → . . Q .
 *
 * PATRÓN DE BACKTRACKING:
 * 1️⃣ VALIDAR: ¿Es seguro colocar reina en (fila, col)?
 * 2️⃣ HACER: Colocar reina → tablero[fila] = col
 * 3️⃣ EXPLORAR: Continuar con la siguiente fila
 * 4️⃣ DESHACER: Quitar reina → tablero[fila] = -1 (backtrack)
 */
public class NReinas {

    private int N;

    /**
     * Resuelve el problema de N-Reinas.
     *
     * @param N Tamaño del tablero (NxN)
     * @return Arreglo con la solución, o null si no existe
     */
    public int[] resolverNReinas(int N) {
        this.N = N;

        // El tablero se representa como un arreglo de N elementos
        // tablero[fila] = columna donde está la reina en esa fila
        int[] tablero = new int[N];

        // Inicializar tablero: -1 significa "sin reina"
        for (int i = 0; i < N; i++) {
            tablero[i] = -1;
        }

        // Intentar colocar reinas comenzando desde la fila 0
        if (colocarReinas(tablero, 0)) {
            return tablero; // Solución encontrada ✅
        }

        return null; // No hay solución ❌
    }


    /**
     * Función recursiva de backtracking para colocar reinas.
     *
     * @param tablero Arreglo donde tablero[fila] = columna de la reina
     * @param fila    Fila actual donde intentamos colocar una reina
     * @return true si encontramos una solución completa, false si no
     */
    private boolean colocarReinas(int[] tablero, int fila) {

        // ============================================================
        // TODO 1: CASO BASE
        // ============================================================
        // ¿Ya colocamos todas las reinas?
        // Pista: Si fila == N, significa que ya pasamos por todas las filas
        //
        // Si es así, retornar true (¡encontramos solución!)
        //
        // Escribe tu código aquí:

        if (false) { // TODO: Cambia 'false' por la condición correcta
            return true; // ¡Éxito!
        }


        // ============================================================
        // GENERAR: Probar cada columna en esta fila
        // ============================================================
        for (int col = 0; col < N; col++) {

            // ============================================================
            // TODO 2: VALIDAR
            // ============================================================
            // ¿Es seguro colocar una reina en (fila, col)?
            // Usa el método esSeguro(tablero, fila, col) que implementarás abajo
            //
            // Solo continúa si es seguro
            //
            // Escribe tu código aquí:

            if (false) { // TODO: Cambia 'false' por esSeguro(tablero, fila, col)

                // ============================================================
                // TODO 3: HACER
                // ============================================================
                // Colocar la reina en esta posición
                // Pista: tablero[fila] = col
                //
                // Escribe tu código aquí:

                // TODO: Completa esta línea


                // ============================================================
                // TODO 4: EXPLORAR
                // ============================================================
                // Intentar colocar reinas en las siguientes filas
                // Pista: Llamar recursivamente a colocarReinas(tablero, fila + 1)
                //
                // Si retorna true, ¡encontramos solución! Retornar true inmediatamente
                //
                // Escribe tu código aquí:

                if (false) { // TODO: Completa la condición
                    return true; // ¡Encontramos solución completa!
                }


                // ============================================================
                // TODO 5: DESHACER (BACKTRACK)
                // ============================================================
                // La llamada recursiva retornó false, no hay solución por aquí
                // Debemos quitar la reina de esta posición para probar otra columna
                //
                // Pista: tablero[fila] = -1 (marca como "sin reina")
                //
                // ⚠️ ESTE ES EL BACKTRACK
                //
                // Escribe tu código aquí:

                // TODO: Completa esta línea
            }
        }

        // ============================================================
        // Si llegamos aquí, probamos todas las columnas y ninguna funcionó
        // ============================================================
        return false; // No hay solución con esta configuración
    }


    /**
     * Verifica si es seguro colocar una reina en la posición (fila, col).
     *
     * Verificamos:
     * - ❌ Misma columna (que otra reina ya colocada)
     * - ❌ Misma diagonal (que otra reina ya colocada)
     *
     * NO verificamos misma fila porque nuestro algoritmo coloca
     * exactamente una reina por fila.
     *
     * @param tablero Arreglo con las posiciones de las reinas
     * @param fila    Fila donde queremos colocar la reina
     * @param col     Columna donde queremos colocar la reina
     * @return true si es seguro, false si hay conflicto
     */
    private boolean esSeguro(int[] tablero, int fila, int col) {

        // ============================================================
        // TODO 6: VALIDAR contra reinas ya colocadas
        // ============================================================
        // Necesitamos verificar que no haya conflictos con reinas
        // ya colocadas en filas anteriores (0 a fila-1)
        //
        // Para cada fila i < fila:
        //   - Obtener la columna de esa reina: reinaCol = tablero[i]
        //   - Verificar conflictos:
        //     1. Misma columna: reinaCol == col
        //     2. Misma diagonal: |i - fila| == |reinaCol - col|
        //
        // Si hay conflicto, retornar false
        //
        // Escribe tu código aquí:

        for (int i = 0; i < fila; i++) {
            int reinaCol = tablero[i];

            // TODO 6a: Verificar MISMA COLUMNA
            // ¿La reina en la fila i está en la misma columna?
            if (false) { // TODO: Completa la condición
                return false; // Conflicto de columna
            }

            // TODO 6b: Verificar MISMA DIAGONAL
            // Dos posiciones están en la misma diagonal si:
            // |fila1 - fila2| == |col1 - col2|
            //
            // En nuestro caso:
            // |i - fila| == |reinaCol - col|
            //
            // Pista: Usa Math.abs() para valor absoluto
            if (false) { // TODO: Completa la condición
                return false; // Conflicto de diagonal
            }
        }

        return true; // ✅ No hay conflictos, es seguro
    }


    // ============================================================
    // MÉTODOS AUXILIARES (PARA VISUALIZACIÓN)
    // ============================================================

    /**
     * Imprime el tablero de forma visual.
     */
    public void imprimirTablero(int[] tablero) {
        if (tablero == null) {
            System.out.println("❌ No hay solución");
            return;
        }

        System.out.println("Tablero " + N + "x" + N + ":");
        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < N; col++) {
                if (tablero[fila] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.print("Representación: [");
        for (int i = 0; i < N; i++) {
            System.out.print(tablero[i]);
            if (i < N - 1) System.out.print(", ");
        }
        System.out.println("]");
    }


    /**
     * Verifica que una solución sea válida.
     * (Útil para debugging)
     */
    public boolean verificarSolucion(int[] tablero) {
        if (tablero == null || tablero.length != N) return false;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // Misma columna
                if (tablero[i] == tablero[j]) {
                    return false;
                }

                // Misma diagonal
                if (Math.abs(i - j) == Math.abs(tablero[i] - tablero[j])) {
                    return false;
                }
            }
        }

        return true;
    }


    // ============================================================
    // MAIN (PARA PROBAR MANUALMENTE)
    // ============================================================
    public static void main(String[] args) {
        NReinas solver = new NReinas();

        // Prueba 1: N = 4 (tiene solución)
        System.out.println("========== N = 4 ==========");
        int[] solucion4 = solver.resolverNReinas(4);
        solver.imprimirTablero(solucion4);

        System.out.println();

        // Prueba 2: N = 8 (clásico problema de 8 reinas)
        System.out.println("========== N = 8 ==========");
        int[] solucion8 = solver.resolverNReinas(8);
        solver.imprimirTablero(solucion8);

        System.out.println();

        // Prueba 3: N = 1 (trivial)
        System.out.println("========== N = 1 ==========");
        int[] solucion1 = solver.resolverNReinas(1);
        solver.imprimirTablero(solucion1);

        System.out.println();

        // Prueba 4: N = 3 (no tiene solución)
        System.out.println("========== N = 3 ==========");
        int[] solucion3 = solver.resolverNReinas(3);
        solver.imprimirTablero(solucion3);
    }
}
