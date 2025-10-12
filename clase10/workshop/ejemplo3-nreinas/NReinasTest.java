import java.util.*;

/**
 * TESTS PARA N-REINAS
 *
 * Este archivo contiene tests automatizados para verificar
 * que tu implementación de N-Reinas funciona correctamente.
 *
 * CÓMO EJECUTAR:
 * 1. Compila: javac NReinas.java NReinasTest.java
 * 2. Ejecuta: java NReinasTest
 *
 * Si todos los tests pasan ✅, ¡tu implementación es correcta!
 */
public class NReinasTest {

    private static int testsPasados = 0;
    private static int testsTotales = 0;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     TESTS: N-REINAS - BACKTRACKING     ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        NReinas solver = new NReinas();

        // Ejecutar todos los tests
        test1_n1(solver);
        test2_n2_sinSolucion(solver);
        test3_n3_sinSolucion(solver);
        test4_n4(solver);
        test5_n5(solver);
        test6_n8(solver);

        // Reporte final
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMEN: " + testsPasados + "/" + testsTotales + " tests pasados");

        if (testsPasados == testsTotales) {
            System.out.println("✅ ¡TODOS LOS TESTS PASARON! 🎉");
            System.out.println("Tu implementación de backtracking es correcta.");
            System.out.println("\n🏆 ¡Has dominado el problema clásico de N-Reinas!");
        } else {
            System.out.println("❌ Algunos tests fallaron. Revisa tu código.");
        }
        System.out.println("=".repeat(50));
    }


    // ========================================================================
    // TEST 1: N = 1 (caso trivial)
    // ========================================================================
    private static void test1_n1(NReinas solver) {
        System.out.println("Test 1: N = 1 (caso trivial)");
        System.out.println("-".repeat(40));

        int[] resultado = solver.resolverNReinas(1);

        // Debe existir solución
        boolean existeSolucion = resultado != null;

        // La solución debe ser [0] (una reina en la única celda)
        boolean solucionCorrecta = existeSolucion &&
                                   resultado.length == 1 &&
                                   resultado[0] == 0;

        // Verificar que sea válida
        boolean esValida = solver.verificarSolucion(resultado);

        boolean correcto = existeSolucion && solucionCorrecta && esValida;

        imprimirResultado(1, resultado, correcto);
        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 2: N = 2 (no tiene solución)
    // ========================================================================
    private static void test2_n2_sinSolucion(NReinas solver) {
        System.out.println("\nTest 2: N = 2 (sin solución)");
        System.out.println("-".repeat(40));

        int[] resultado = solver.resolverNReinas(2);

        // NO debe existir solución
        boolean correcto = resultado == null;

        if (correcto) {
            System.out.println("  ✅ Correctamente detectó que N=2 no tiene solución");
        } else {
            System.out.println("  ❌ Encontró una solución cuando no debería existir");
            System.out.println("     Solución retornada: " + Arrays.toString(resultado));
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 3: N = 3 (no tiene solución)
    // ========================================================================
    private static void test3_n3_sinSolucion(NReinas solver) {
        System.out.println("\nTest 3: N = 3 (sin solución)");
        System.out.println("-".repeat(40));

        int[] resultado = solver.resolverNReinas(3);

        // NO debe existir solución
        boolean correcto = resultado == null;

        if (correcto) {
            System.out.println("  ✅ Correctamente detectó que N=3 no tiene solución");
        } else {
            System.out.println("  ❌ Encontró una solución cuando no debería existir");
            System.out.println("     Solución retornada: " + Arrays.toString(resultado));
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 4: N = 4 (caso de las diapositivas)
    // ========================================================================
    private static void test4_n4(NReinas solver) {
        System.out.println("\nTest 4: N = 4 (ejemplo de clase)");
        System.out.println("-".repeat(40));

        int[] resultado = solver.resolverNReinas(4);

        // Debe existir solución
        boolean existeSolucion = resultado != null;

        // Verificar que sea válida
        boolean esValida = existeSolucion && solver.verificarSolucion(resultado);

        // Verificar longitud
        boolean longitudCorrecta = existeSolucion && resultado.length == 4;

        boolean correcto = existeSolucion && esValida && longitudCorrecta;

        imprimirResultado(4, resultado, correcto);

        if (existeSolucion) {
            imprimirTableroVisual(resultado, 4);
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 5: N = 5
    // ========================================================================
    private static void test5_n5(NReinas solver) {
        System.out.println("\nTest 5: N = 5");
        System.out.println("-".repeat(40));

        int[] resultado = solver.resolverNReinas(5);

        // Debe existir solución
        boolean existeSolucion = resultado != null;

        // Verificar que sea válida
        boolean esValida = existeSolucion && solver.verificarSolucion(resultado);

        // Verificar longitud
        boolean longitudCorrecta = existeSolucion && resultado.length == 5;

        boolean correcto = existeSolucion && esValida && longitudCorrecta;

        imprimirResultado(5, resultado, correcto);
        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 6: N = 8 (problema clásico de 8 reinas)
    // ========================================================================
    private static void test6_n8(NReinas solver) {
        System.out.println("\nTest 6: N = 8 (problema clásico)");
        System.out.println("-".repeat(40));

        int[] resultado = solver.resolverNReinas(8);

        // Debe existir solución
        boolean existeSolucion = resultado != null;

        // Verificar que sea válida
        boolean esValida = existeSolucion && solver.verificarSolucion(resultado);

        // Verificar longitud
        boolean longitudCorrecta = existeSolucion && resultado.length == 8;

        boolean correcto = existeSolucion && esValida && longitudCorrecta;

        imprimirResultado(8, resultado, correcto);

        if (existeSolucion) {
            System.out.println("\n  Tablero 8x8:");
            imprimirTableroVisual(resultado, 8);
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // MÉTODOS AUXILIARES
    // ========================================================================

    /**
     * Imprime el resultado de un test.
     */
    private static void imprimirResultado(int n, int[] resultado, boolean correcto) {
        if (resultado == null) {
            System.out.println("  Resultado: null (no hay solución)");
        } else {
            System.out.println("  Resultado: " + Arrays.toString(resultado));
        }

        if (correcto) {
            System.out.println("  ✅ CORRECTO");
        } else {
            System.out.println("  ❌ INCORRECTO");

            if (resultado != null) {
                // Verificar qué tipo de error hubo
                if (resultado.length != n) {
                    System.out.println("     Error: Longitud incorrecta (esperado " + n + ", obtenido " + resultado.length + ")");
                } else if (!esValidoManual(resultado)) {
                    System.out.println("     Error: La solución no es válida (hay reinas que se atacan)");
                    mostrarConflictos(resultado);
                }
            }
        }
    }

    /**
     * Imprime el tablero de forma visual.
     */
    private static void imprimirTableroVisual(int[] tablero, int n) {
        for (int fila = 0; fila < n; fila++) {
            System.out.print("     ");
            for (int col = 0; col < n; col++) {
                if (tablero[fila] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Verifica manualmente que una solución sea válida.
     */
    private static boolean esValidoManual(int[] tablero) {
        int n = tablero.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
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

    /**
     * Muestra qué reinas están en conflicto.
     */
    private static void mostrarConflictos(int[] tablero) {
        int n = tablero.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Misma columna
                if (tablero[i] == tablero[j]) {
                    System.out.println("     Conflicto: Reinas en fila " + i + " y fila " + j +
                                     " están en la misma columna " + tablero[i]);
                }

                // Misma diagonal
                if (Math.abs(i - j) == Math.abs(tablero[i] - tablero[j])) {
                    System.out.println("     Conflicto: Reinas en (" + i + "," + tablero[i] + ") y (" +
                                     j + "," + tablero[j] + ") están en la misma diagonal");
                }
            }
        }
    }
}
