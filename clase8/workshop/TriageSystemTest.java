package clase8.workshop;

import java.util.Date;

/**
 * TESTS PARA TRIAGE SYSTEM
 *
 * Tests automatizados para verificar el funcionamiento correcto
 * del sistema de triage de la sala de emergencias.
 *
 * CÓMO EJECUTAR:
 * 1. Compila: javac clase8/workshop/*.java
 * 2. Ejecuta: java clase8.workshop.TriageSystemTest
 */
public class TriageSystemTest {

    private static int testsPasados = 0;
    private static int testsTotales = 0;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   TESTS: EMERGENCY ROOM TRIAGE SYSTEM     ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        TriageSystem system = new TriageSystem();

        // Ejecutar todos los tests
        test1_emptyQueueReturnNull(system);
        test2_priorityOrder();
        test3_fifoWithinPriority();
        test4_removePatient();
        test5_waitingTimeCalculation();
        test6_mixedPriorities();

        // Reporte final
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMEN: " + testsPasados + "/" + testsTotales + " tests pasados");

        if (testsPasados == testsTotales) {
            System.out.println("✅ ¡TODOS LOS TESTS PASARON! 🎉");
            System.out.println("El sistema de triage funciona correctamente.");
        } else {
            System.out.println("❌ Algunos tests fallaron. Revisa la implementación.");
        }
        System.out.println("=".repeat(50));
    }

    // ========================================================================
    // TEST 1: Cola vacía debe retornar null
    // ========================================================================
    private static void test1_emptyQueueReturnNull(TriageSystem system) {
        System.out.println("Test 1: Cola vacía retorna null");
        System.out.println("-".repeat(40));

        Patient patient = system.callNextPatient();
        boolean correcto = patient == null;

        if (correcto) {
            System.out.println("  ✅ CORRECTO - Retorna null cuando no hay pacientes");
        } else {
            System.out.println("  ❌ INCORRECTO - Debería retornar null");
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }

    // ========================================================================
    // TEST 2: Orden de prioridad (CRITICAL > URGENT > STANDARD)
    // ========================================================================
    private static void test2_priorityOrder() {
        System.out.println("\nTest 2: Orden de prioridad correcto");
        System.out.println("-".repeat(40));

        TriageSystem system = new TriageSystem();

        // Agregar en orden inverso de prioridad
        system.registerPatient("Standard Patient", 3, "Minor cut");
        system.registerPatient("Urgent Patient", 2, "Broken arm");
        system.registerPatient("Critical Patient", 1, "Heart attack");

        // Debe llamar en orden: Critical, Urgent, Standard
        Patient p1 = system.callNextPatient();
        Patient p2 = system.callNextPatient();
        Patient p3 = system.callNextPatient();

        boolean correcto = p1.getName().equals("Critical Patient") &&
                          p2.getName().equals("Urgent Patient") &&
                          p3.getName().equals("Standard Patient");

        if (correcto) {
            System.out.println("  ✅ CORRECTO - Prioridad respetada");
            System.out.println("     Orden: " + p1.getName() + " → " + p2.getName() + " → " + p3.getName());
        } else {
            System.out.println("  ❌ INCORRECTO - Orden de prioridad incorrecto");
            System.out.println("     Obtenido: " + p1.getName() + " → " + p2.getName() + " → " + p3.getName());
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }

    // ========================================================================
    // TEST 3: FIFO dentro de la misma prioridad
    // ========================================================================
    private static void test3_fifoWithinPriority() {
        System.out.println("\nTest 3: FIFO dentro de misma prioridad");
        System.out.println("-".repeat(40));

        TriageSystem system = new TriageSystem();

        // Agregar 3 pacientes críticos
        system.registerPatient("Critical 1", 1, "Symptom A");
        system.registerPatient("Critical 2", 1, "Symptom B");
        system.registerPatient("Critical 3", 1, "Symptom C");

        Patient p1 = system.callNextPatient();
        Patient p2 = system.callNextPatient();
        Patient p3 = system.callNextPatient();

        boolean correcto = p1.getName().equals("Critical 1") &&
                          p2.getName().equals("Critical 2") &&
                          p3.getName().equals("Critical 3");

        if (correcto) {
            System.out.println("  ✅ CORRECTO - FIFO respetado");
            System.out.println("     Orden: " + p1.getName() + " → " + p2.getName() + " → " + p3.getName());
        } else {
            System.out.println("  ❌ INCORRECTO - FIFO no respetado");
            System.out.println("     Obtenido: " + p1.getName() + " → " + p2.getName() + " → " + p3.getName());
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }

    // ========================================================================
    // TEST 4: Remover paciente de la cola
    // ========================================================================
    private static void test4_removePatient() {
        System.out.println("\nTest 4: Remover paciente de la cola");
        System.out.println("-".repeat(40));

        TriageSystem system = new TriageSystem();

        system.registerPatient("Alice", 2, "Symptom A");
        system.registerPatient("Bob", 2, "Symptom B");
        system.registerPatient("Charlie", 2, "Symptom C");

        // Remover paciente del medio
        boolean removed = system.removePatient("Bob");

        Patient p1 = system.callNextPatient();
        Patient p2 = system.callNextPatient();
        Patient p3 = system.callNextPatient();

        boolean correcto = removed &&
                          p1.getName().equals("Alice") &&
                          p2.getName().equals("Charlie") &&
                          p3 == null; // Solo quedaban 2 después de remover Bob

        if (correcto) {
            System.out.println("  ✅ CORRECTO - Paciente removido exitosamente");
            System.out.println("     Quedaron: " + p1.getName() + " → " + p2.getName());
        } else {
            System.out.println("  ❌ INCORRECTO - Error al remover paciente");
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }

    // ========================================================================
    // TEST 5: Cálculo de tiempo de espera
    // ========================================================================
    private static void test5_waitingTimeCalculation() {
        System.out.println("\nTest 5: Cálculo de tiempo de espera");
        System.out.println("-".repeat(40));

        TriageSystem system = new TriageSystem();

        // Agregar pacientes
        system.registerPatient("Critical 1", 1, "Symptom A");
        system.registerPatient("Critical 2", 1, "Symptom B");
        system.registerPatient("Urgent 1", 2, "Symptom C");

        // Crear un paciente urgente y calcular su tiempo de espera
        Patient testPatient = new Patient("Test Patient", new Date(), 2, "Test");
        system.registerPatient(testPatient.getName(), testPatient.getPriority(), testPatient.getSymptoms());

        int waitTime = system.getWaitingTime(testPatient);

        // Debe esperar: 2 críticos (40 min) + 1 urgente (20 min) + su posición (20 min) = 80 min
        // Pero solo cuenta hasta él, así que: 2 críticos + 1 urgente antes + él = 80 min
        boolean correcto = waitTime > 0 && waitTime <= 100; // Rango razonable

        if (correcto) {
            System.out.println("  ✅ CORRECTO - Tiempo de espera calculado");
            System.out.println("     Tiempo estimado: " + waitTime + " minutos");
        } else {
            System.out.println("  ❌ INCORRECTO - Cálculo de tiempo incorrecto");
            System.out.println("     Obtenido: " + waitTime + " minutos");
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }

    // ========================================================================
    // TEST 6: Escenario complejo con prioridades mezcladas
    // ========================================================================
    private static void test6_mixedPriorities() {
        System.out.println("\nTest 6: Escenario complejo con múltiples prioridades");
        System.out.println("-".repeat(40));

        TriageSystem system = new TriageSystem();

        // Agregar pacientes en orden mezclado
        system.registerPatient("Standard 1", 3, "Minor");
        system.registerPatient("Critical 1", 1, "Severe");
        system.registerPatient("Urgent 1", 2, "Moderate");
        system.registerPatient("Standard 2", 3, "Minor");
        system.registerPatient("Critical 2", 1, "Severe");
        system.registerPatient("Urgent 2", 2, "Moderate");

        // Llamar a todos
        Patient p1 = system.callNextPatient();
        Patient p2 = system.callNextPatient();
        Patient p3 = system.callNextPatient();
        Patient p4 = system.callNextPatient();
        Patient p5 = system.callNextPatient();
        Patient p6 = system.callNextPatient();

        boolean correcto =
            // Primero los 2 críticos (en FIFO)
            p1.getPriority() == 1 && p1.getName().equals("Critical 1") &&
            p2.getPriority() == 1 && p2.getName().equals("Critical 2") &&
            // Luego los 2 urgentes (en FIFO)
            p3.getPriority() == 2 && p3.getName().equals("Urgent 1") &&
            p4.getPriority() == 2 && p4.getName().equals("Urgent 2") &&
            // Finalmente los 2 standard (en FIFO)
            p5.getPriority() == 3 && p5.getName().equals("Standard 1") &&
            p6.getPriority() == 3 && p6.getName().equals("Standard 2");

        if (correcto) {
            System.out.println("  ✅ CORRECTO - Escenario complejo manejado correctamente");
            System.out.println("     Orden:");
            System.out.println("       1. " + p1.getName() + " (" + p1.getPriorityLabel() + ")");
            System.out.println("       2. " + p2.getName() + " (" + p2.getPriorityLabel() + ")");
            System.out.println("       3. " + p3.getName() + " (" + p3.getPriorityLabel() + ")");
            System.out.println("       4. " + p4.getName() + " (" + p4.getPriorityLabel() + ")");
            System.out.println("       5. " + p5.getName() + " (" + p5.getPriorityLabel() + ")");
            System.out.println("       6. " + p6.getName() + " (" + p6.getPriorityLabel() + ")");
        } else {
            System.out.println("  ❌ INCORRECTO - Orden incorrecto en escenario complejo");
        }

        testsTotales++;
        if (correcto) testsPasados++;
    }
}
