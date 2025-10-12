import java.util.*;

/**
 * TESTS PARA LABERINTO SOLVER
 *
 * Este archivo contiene tests automatizados para verificar
 * que tu implementación de LaberintoSolver funciona correctamente.
 *
 * CÓMO EJECUTAR:
 * 1. Compila: javac LaberintoSolver.java LaberintoSolverTest.java
 * 2. Ejecuta: java LaberintoSolverTest
 *
 * Si todos los tests pasan ✅, ¡tu implementación es correcta!
 */
public class LaberintoSolverTest {

    private static int testsPasados = 0;
    private static int testsTotales = 0;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   TESTS: LABERINTO - BACKTRACKING      ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        LaberintoSolver solver = new LaberintoSolver();

        // Ejecutar todos los tests
        test1_caminoDirecto(solver);
        test2_conObstaculo(solver);
        test3_sinSolucion(solver);
        test4_laberintoComplejo(solver);
        test5_gridGrande(solver);

        // Reporte final
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMEN: " + testsPasados + "/" + testsTotales + " tests pasados");

        if (testsPasados == testsTotales) {
            System.out.println("✅ ¡TODOS LOS TESTS PASARON! 🎉");
            System.out.println("Tu implementación de backtracking es correcta.");
        } else {
            System.out.println("❌ Algunos tests fallaron. Revisa tu código.");
        }
        System.out.println("=".repeat(50));
    }


    // ========================================================================
    // TEST 1: Camino directo (sin obstáculos)
    // ========================================================================
    private static void test1_caminoDirecto(LaberintoSolver solver) {
        System.out.println("Test 1: Camino directo sin obstáculos");
        System.out.println("-".repeat(40));

        char[][] grid = {
            {'S', '.', '.', 'E'}
        };

        imprimirGrid(grid);
        List<String> camino = solver.encontrarCamino(grid);

        // Debe existir un camino
        boolean existeCamino = camino != null;

        // El camino debe tener 4 pasos
        boolean longitudCorrecta = existeCamino && camino.size() == 4;

        // Debe empezar en (0,0) y terminar en (0,3)
        boolean inicioYFinCorrectos = existeCamino &&
                                      camino.get(0).equals("(0,0)") &&
                                      camino.get(camino.size() - 1).equals("(0,3)");

        boolean correcto = existeCamino && longitudCorrecta && inicioYFinCorrectos;

        imprimirResultadoCamino(camino, correcto);
        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 2: Con obstáculo (del ejemplo de las diapositivas)
    // ========================================================================
    private static void test2_conObstaculo(LaberintoSolver solver) {
        System.out.println("\nTest 2: Con obstáculo (ejemplo de clase)");
        System.out.println("-".repeat(40));

        char[][] grid = {
            {'S', '.', '.'},
            {'.', 'X', '.'},
            {'.', '.', 'E'}
        };

        imprimirGrid(grid);
        List<String> camino = solver.encontrarCamino(grid);

        // Debe existir un camino
        boolean existeCamino = camino != null;

        // El camino debe tener 5 pasos
        boolean longitudCorrecta = existeCamino && camino.size() == 5;

        // Debe empezar en (0,0) y terminar en (2,2)
        boolean inicioYFinCorrectos = existeCamino &&
                                      camino.get(0).equals("(0,0)") &&
                                      camino.get(camino.size() - 1).equals("(2,2)");

        // No debe pasar por (1,1) que es la pared
        boolean noPasaPorPared = !contieneCoord(camino, "(1,1)");

        boolean correcto = existeCamino && longitudCorrecta && inicioYFinCorrectos && noPasaPorPared;

        imprimirResultadoCamino(camino, correcto);

        if (!noPasaPorPared) {
            System.out.println("  ⚠️  El camino pasa por la pared (1,1)");
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 3: Sin solución
    // ========================================================================
    private static void test3_sinSolucion(LaberintoSolver solver) {
        System.out.println("\nTest 3: Sin solución (bloqueado)");
        System.out.println("-".repeat(40));

        char[][] grid = {
            {'S', 'X', 'E'}
        };

        imprimirGrid(grid);
        List<String> camino = solver.encontrarCamino(grid);

        // NO debe existir camino
        boolean correcto = camino == null;

        if (correcto) {
            System.out.println("  ✅ Correctamente detectó que no hay camino");
        } else {
            System.out.println("  ❌ Encontró un camino cuando no debería existir");
            System.out.println("     Camino retornado: " + camino);
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 4: Laberinto complejo
    // ========================================================================
    private static void test4_laberintoComplejo(LaberintoSolver solver) {
        System.out.println("\nTest 4: Laberinto complejo");
        System.out.println("-".repeat(40));

        char[][] grid = {
            {'S', '.', 'X', '.'},
            {'X', '.', '.', '.'},
            {'.', 'X', '.', 'E'}
        };

        imprimirGrid(grid);
        List<String> camino = solver.encontrarCamino(grid);

        // Debe existir un camino
        boolean existeCamino = camino != null;

        // Debe empezar en (0,0) y terminar en (2,3)
        boolean inicioYFinCorrectos = existeCamino &&
                                      camino.get(0).equals("(0,0)") &&
                                      camino.get(camino.size() - 1).equals("(2,3)");

        // Verificar que es un camino válido (movimientos solo a celdas adyacentes)
        boolean esValido = existeCamino && esCaminoValido(camino);

        boolean correcto = existeCamino && inicioYFinCorrectos && esValido;

        imprimirResultadoCamino(camino, correcto);

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 5: Grid más grande
    // ========================================================================
    private static void test5_gridGrande(LaberintoSolver solver) {
        System.out.println("\nTest 5: Grid 5x5 con múltiples obstáculos");
        System.out.println("-".repeat(40));

        char[][] grid = {
            {'S', '.', 'X', '.', '.'},
            {'.', '.', 'X', '.', 'X'},
            {'.', 'X', '.', '.', '.'},
            {'.', '.', '.', 'X', '.'},
            {'X', '.', '.', '.', 'E'}
        };

        imprimirGrid(grid);
        List<String> camino = solver.encontrarCamino(grid);

        // Debe existir un camino
        boolean existeCamino = camino != null;

        // Debe empezar en (0,0) y terminar en (4,4)
        boolean inicioYFinCorrectos = existeCamino &&
                                      camino.get(0).equals("(0,0)") &&
                                      camino.get(camino.size() - 1).equals("(4,4)");

        // Verificar que es un camino válido
        boolean esValido = existeCamino && esCaminoValido(camino);

        boolean correcto = existeCamino && inicioYFinCorrectos && esValido;

        imprimirResultadoCamino(camino, correcto);

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // MÉTODOS AUXILIARES
    // ========================================================================

    /**
     * Imprime un grid de forma visual.
     */
    private static void imprimirGrid(char[][] grid) {
        System.out.println("  Grid:");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("    ");
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Imprime el resultado de un camino.
     */
    private static void imprimirResultadoCamino(List<String> camino, boolean correcto) {
        if (camino == null) {
            System.out.println("  Resultado: null (no hay camino)");
        } else {
            System.out.println("  Resultado: " + String.join(" → ", camino));
            System.out.println("  Longitud: " + camino.size() + " pasos");
        }

        if (correcto) {
            System.out.println("  ✅ CORRECTO");
        } else {
            System.out.println("  ❌ INCORRECTO");
        }
    }

    /**
     * Verifica si el camino contiene una coordenada.
     */
    private static boolean contieneCoord(List<String> camino, String coord) {
        if (camino == null) return false;
        return camino.contains(coord);
    }

    /**
     * Verifica que un camino sea válido (movimientos solo a celdas adyacentes).
     */
    private static boolean esCaminoValido(List<String> camino) {
        if (camino == null || camino.size() < 2) return true;

        for (int i = 0; i < camino.size() - 1; i++) {
            int[] pos1 = parseCoordenada(camino.get(i));
            int[] pos2 = parseCoordenada(camino.get(i + 1));

            int diffX = Math.abs(pos1[0] - pos2[0]);
            int diffY = Math.abs(pos1[1] - pos2[1]);

            // Movimiento válido: exactamente una celda en una dirección
            if (!((diffX == 1 && diffY == 0) || (diffX == 0 && diffY == 1))) {
                System.out.println("  ⚠️  Movimiento inválido: " + camino.get(i) + " → " + camino.get(i + 1));
                return false;
            }
        }

        return true;
    }

    /**
     * Parsea una coordenada "(x,y)" a [x, y].
     */
    private static int[] parseCoordenada(String coord) {
        // Quitar paréntesis
        coord = coord.replace("(", "").replace(")", "");
        String[] partes = coord.split(",");
        return new int[]{Integer.parseInt(partes[0]), Integer.parseInt(partes[1])};
    }
}
