import java.util.*;

/**
 * EJEMPLO 1: PERMUTACIONES
 *
 * Generar todas las permutaciones de un arreglo de números.
 *
 * Input:  [1, 2, 3]
 * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 * PATRÓN DE BACKTRACKING:
 * 1️⃣ VALIDAR: ¿Ya usé este número?
 * 2️⃣ HACER: Agregar número a la permutación actual
 * 3️⃣ EXPLORAR: Continuar recursivamente
 * 4️⃣ DESHACER: Quitar número (backtrack)
 */
public class Permutaciones {

    /**
     * Método principal que genera todas las permutaciones.
     *
     * @param numeros Arreglo de números a permutar
     * @return Lista con todas las permutaciones posibles
     */
    public List<List<Integer>> permute(int[] numeros) {
        List<List<Integer>> resultado = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();

        // Iniciamos el backtracking
        backtrack(numeros, actual, resultado);

        return resultado;
    }

    /**
     * Función recursiva de backtracking.
     *
     * @param numeros   Arreglo original (no cambia)
     * @param actual    Permutación parcial que estamos construyendo
     * @param resultado Lista donde guardamos todas las permutaciones completas
     */
    private void backtrack(int[] numeros, List<Integer> actual, List<List<Integer>> resultado) {

        // ============================================================
        // TODO 1: CASO BASE
        // ============================================================
        // ¿Cuándo tenemos una permutación completa?
        // Pista: Cuando 'actual' tiene el mismo tamaño que 'numeros'
        //
        // Cuando eso pase:
        // 1. Agregar una COPIA de 'actual' a 'resultado'
        //    ⚠️ IMPORTANTE: Usar 'new ArrayList<>(actual)' para crear copia
        // 2. Hacer return para terminar esta rama de recursión
        //
        // Escribe tu código aquí:

        if (actual.size() == numeros.length) {
            // ¿Qué agregamos a 'resultado'?
            // TODO: Completa esta línea

            return;
        }


        // ============================================================
        // GENERAR: Probar con cada número del arreglo
        // ============================================================
        for (int num : numeros) {

            // ============================================================
            // TODO 2: VALIDAR
            // ============================================================
            // ¿Ya usamos este número en la permutación actual?
            // Pista: Usa 'actual.contains(num)'
            //
            // Si ya lo usamos, hacemos 'continue' para saltar al siguiente número
            //
            // Escribe tu código aquí:

            if (false) { // TODO: Cambia 'false' por la condición correcta
                continue; // Saltar este número
            }


            // ============================================================
            // TODO 3: HACER
            // ============================================================
            // Agregar 'num' a la permutación actual
            // Pista: Usa 'actual.add(num)'
            //
            // Escribe tu código aquí:

            // TODO: Completa esta línea


            // ============================================================
            // TODO 4: EXPLORAR
            // ============================================================
            // Llamar recursivamente a backtrack para continuar construyendo
            // la permutación con los números restantes
            //
            // Escribe tu código aquí:

            // TODO: Completa esta línea


            // ============================================================
            // TODO 5: DESHACER (BACKTRACK)
            // ============================================================
            // Quitar el último número agregado para probar otra opción
            // Pista: Usa 'actual.remove(actual.size() - 1)'
            //
            // ⚠️ ESTE ES EL PASO CLAVE DEL BACKTRACKING
            //
            // Escribe tu código aquí:

            // TODO: Completa esta línea
        }
    }


    // ============================================================
    // MÉTODO AUXILIAR (OPCIONAL - PARA DEBUGGING)
    // ============================================================
    /**
     * Imprime todas las permutaciones de forma legible.
     */
    public void imprimirPermutaciones(List<List<Integer>> permutaciones) {
        System.out.println("Total de permutaciones: " + permutaciones.size());
        for (int i = 0; i < permutaciones.size(); i++) {
            System.out.println((i + 1) + ". " + permutaciones.get(i));
        }
    }


    // ============================================================
    // MAIN (PARA PROBAR MANUALMENTE)
    // ============================================================
    public static void main(String[] args) {
        Permutaciones p = new Permutaciones();

        // Prueba 1: [1, 2, 3]
        System.out.println("========== PRUEBA 1 ==========");
        int[] numeros1 = {1, 2, 3};
        List<List<Integer>> resultado1 = p.permute(numeros1);
        p.imprimirPermutaciones(resultado1);

        System.out.println();

        // Prueba 2: [1, 2]
        System.out.println("========== PRUEBA 2 ==========");
        int[] numeros2 = {1, 2};
        List<List<Integer>> resultado2 = p.permute(numeros2);
        p.imprimirPermutaciones(resultado2);
    }
}
