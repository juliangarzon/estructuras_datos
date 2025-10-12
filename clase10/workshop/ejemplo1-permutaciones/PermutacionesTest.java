import java.util.*;

/**
 * TESTS PARA PERMUTACIONES
 *
 * Este archivo contiene tests automatizados para verificar
 * que tu implementación de Permutaciones funciona correctamente.
 *
 * CÓMO EJECUTAR:
 * 1. Compila: javac Permutaciones.java PermutacionesTest.java
 * 2. Ejecuta: java PermutacionesTest
 *
 * Si todos los tests pasan ✅, ¡tu implementación es correcta!
 */
public class PermutacionesTest {

    private static int testsPasados = 0;
    private static int testsTotales = 0;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   TESTS: PERMUTACIONES - BACKTRACKING  ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        Permutaciones p = new Permutaciones();

        // Ejecutar todos los tests
        test1_arregloVacio(p);
        test2_unElemento(p);
        test3_dosElementos(p);
        test4_tresElementos(p);
        test5_cuatroElementos(p);
        test6_verificarNoRepetidos(p);

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
    // TEST 1: Arreglo vacío
    // ========================================================================
    private static void test1_arregloVacio(Permutaciones p) {
        System.out.println("Test 1: Arreglo vacío []");
        System.out.println("-".repeat(40));

        int[] numeros = {};
        List<List<Integer>> resultado = p.permute(numeros);

        // Esperado: [[]] (una permutación vacía)
        boolean correcto = resultado.size() == 1 && resultado.get(0).isEmpty();

        imprimirResultado(resultado, correcto);
        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 2: Un elemento
    // ========================================================================
    private static void test2_unElemento(Permutaciones p) {
        System.out.println("\nTest 2: Un elemento [1]");
        System.out.println("-".repeat(40));

        int[] numeros = {1};
        List<List<Integer>> resultado = p.permute(numeros);

        // Esperado: [[1]]
        boolean correcto = resultado.size() == 1 &&
                          resultado.get(0).size() == 1 &&
                          resultado.get(0).get(0) == 1;

        imprimirResultado(resultado, correcto);
        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 3: Dos elementos
    // ========================================================================
    private static void test3_dosElementos(Permutaciones p) {
        System.out.println("\nTest 3: Dos elementos [1, 2]");
        System.out.println("-".repeat(40));

        int[] numeros = {1, 2};
        List<List<Integer>> resultado = p.permute(numeros);

        // Esperado: 2! = 2 permutaciones
        // [[1, 2], [2, 1]]
        boolean tamañoCorrecto = resultado.size() == 2;

        boolean contienePermutacion1 = contienePermutacion(resultado, Arrays.asList(1, 2));
        boolean contienePermutacion2 = contienePermutacion(resultado, Arrays.asList(2, 1));

        boolean correcto = tamañoCorrecto && contienePermutacion1 && contienePermutacion2;

        imprimirResultado(resultado, correcto);
        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 4: Tres elementos (caso principal)
    // ========================================================================
    private static void test4_tresElementos(Permutaciones p) {
        System.out.println("\nTest 4: Tres elementos [1, 2, 3]");
        System.out.println("-".repeat(40));

        int[] numeros = {1, 2, 3};
        List<List<Integer>> resultado = p.permute(numeros);

        // Esperado: 3! = 6 permutaciones
        boolean tamañoCorrecto = resultado.size() == 6;

        // Verificar que contiene todas las permutaciones esperadas
        List<List<Integer>> esperadas = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(1, 3, 2),
            Arrays.asList(2, 1, 3),
            Arrays.asList(2, 3, 1),
            Arrays.asList(3, 1, 2),
            Arrays.asList(3, 2, 1)
        );

        boolean todasPresentes = true;
        for (List<Integer> esperada : esperadas) {
            if (!contienePermutacion(resultado, esperada)) {
                todasPresentes = false;
                System.out.println("  ❌ Falta la permutación: " + esperada);
            }
        }

        boolean correcto = tamañoCorrecto && todasPresentes;

        imprimirResultado(resultado, correcto);
        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 5: Cuatro elementos (más complejo)
    // ========================================================================
    private static void test5_cuatroElementos(Permutaciones p) {
        System.out.println("\nTest 5: Cuatro elementos [1, 2, 3, 4]");
        System.out.println("-".repeat(40));

        int[] numeros = {1, 2, 3, 4};
        List<List<Integer>> resultado = p.permute(numeros);

        // Esperado: 4! = 24 permutaciones
        boolean tamañoCorrecto = resultado.size() == 24;

        // Verificar que todas son permutaciones válidas
        boolean todasValidas = true;
        for (List<Integer> perm : resultado) {
            if (!esPermutacionValida(perm, numeros)) {
                todasValidas = false;
                System.out.println("  ❌ Permutación inválida: " + perm);
            }
        }

        boolean correcto = tamañoCorrecto && todasValidas;

        if (correcto) {
            System.out.println("  ✅ 24 permutaciones generadas correctamente");
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // TEST 6: Verificar que no hay permutaciones repetidas
    // ========================================================================
    private static void test6_verificarNoRepetidos(Permutaciones p) {
        System.out.println("\nTest 6: Verificar que no hay repetidos");
        System.out.println("-".repeat(40));

        int[] numeros = {1, 2, 3};
        List<List<Integer>> resultado = p.permute(numeros);

        // Convertir a Set para detectar duplicados
        Set<List<Integer>> sinDuplicados = new HashSet<>(resultado);

        boolean correcto = resultado.size() == sinDuplicados.size();

        if (correcto) {
            System.out.println("  ✅ No hay permutaciones duplicadas");
        } else {
            System.out.println("  ❌ Se encontraron permutaciones duplicadas");
            System.out.println("     Total: " + resultado.size());
            System.out.println("     Únicos: " + sinDuplicados.size());
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }


    // ========================================================================
    // MÉTODOS AUXILIARES
    // ========================================================================

    /**
     * Verifica si la lista de resultados contiene una permutación específica.
     */
    private static boolean contienePermutacion(List<List<Integer>> resultados, List<Integer> permutacion) {
        for (List<Integer> resultado : resultados) {
            if (sonIguales(resultado, permutacion)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compara dos listas elemento por elemento.
     */
    private static boolean sonIguales(List<Integer> lista1, List<Integer> lista2) {
        if (lista1.size() != lista2.size()) return false;

        for (int i = 0; i < lista1.size(); i++) {
            if (!lista1.get(i).equals(lista2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica que una permutación sea válida (contiene todos los elementos exactamente una vez).
     */
    private static boolean esPermutacionValida(List<Integer> permutacion, int[] original) {
        if (permutacion.size() != original.length) return false;

        // Contar frecuencias
        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (int num : original) {
            frecuencias.put(num, frecuencias.getOrDefault(num, 0) + 1);
        }

        for (int num : permutacion) {
            if (!frecuencias.containsKey(num)) return false;
            int count = frecuencias.get(num);
            if (count == 0) return false;
            frecuencias.put(num, count - 1);
        }

        return true;
    }

    /**
     * Imprime el resultado de un test de forma bonita.
     */
    private static void imprimirResultado(List<List<Integer>> resultado, boolean correcto) {
        System.out.println("  Resultado: " + resultado);
        System.out.println("  Total de permutaciones: " + resultado.size());

        if (correcto) {
            System.out.println("  ✅ CORRECTO");
        } else {
            System.out.println("  ❌ INCORRECTO");
        }
    }
}
