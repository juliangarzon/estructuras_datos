package clase8.workshop;

/**
 * DEMO: Demostración automática del sistema de Emergency Room
 *
 * Este archivo muestra cómo funciona el sistema sin interacción del usuario.
 * Útil para demostración en clase.
 */
public class DemoEmergencyRoom {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  EMERGENCY ROOM - DEMO AUTOMÁTICA         ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        TriageSystem system = new TriageSystem();

        // Escenario 1: Registrar pacientes
        System.out.println("📋 ESCENARIO 1: Registrando pacientes...\n");

        system.registerPatient("Bob Wilson", 3, "Minor cut on finger");
        System.out.println("✓ Registrado: Bob Wilson (STANDARD)\n");

        system.registerPatient("Alice Johnson", 2, "Broken arm");
        System.out.println("✓ Registrado: Alice Johnson (URGENT)\n");

        system.registerPatient("John Doe", 1, "Heart attack symptoms");
        System.out.println("✓ Registrado: John Doe (CRITICAL)\n");

        system.registerPatient("Mary Smith", 3, "Sprained ankle");
        System.out.println("✓ Registrado: Mary Smith (STANDARD)\n");

        system.registerPatient("Carlos Lopez", 1, "Severe chest pain");
        System.out.println("✓ Registrado: Carlos Lopez (CRITICAL)\n");

        // Mostrar estado
        system.displayStatus();

        // Mostrar todos los pacientes
        system.displayAllWaitingPatients();

        // Escenario 2: Llamar pacientes
        System.out.println("\n🔔 ESCENARIO 2: Llamando pacientes...\n");

        for (int i = 1; i <= 5; i++) {
            Patient patient = system.callNextPatient();
            if (patient != null) {
                System.out.println("Llamada #" + i + ": " + patient.getName() +
                                 " (" + patient.getPriorityLabel() + ")");
                System.out.println("  Síntomas: " + patient.getSymptoms());
                System.out.println();
                pausa(1000);
            }
        }

        system.displayStatus();

        // Escenario 3: Paciente se va
        System.out.println("\n🚪 ESCENARIO 3: Simulando paciente que se va...\n");

        system.registerPatient("David Brown", 2, "Migraine");
        system.registerPatient("Emma Davis", 2, "Allergic reaction");
        system.registerPatient("Frank Miller", 3, "Cold symptoms");

        system.displayStatus();
        system.displayAllWaitingPatients();

        System.out.println("❌ Emma Davis se va sin ser atendida...\n");
        boolean removed = system.removePatient("Emma Davis");

        if (removed) {
            System.out.println("✓ Emma Davis removida del sistema\n");
        }

        system.displayAllWaitingPatients();
        system.displayStatus();

        // Escenario 4: Atender pacientes restantes
        System.out.println("\n🏥 ESCENARIO 4: Atendiendo pacientes restantes...\n");

        Patient p;
        int count = 1;
        while ((p = system.callNextPatient()) != null) {
            System.out.println("Atendiendo #" + count + ": " + p.getName());
            count++;
            pausa(800);
        }

        System.out.println("\n✅ Todos los pacientes han sido atendidos!\n");
        system.displayStatus();

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         FIN DE LA DEMOSTRACIÓN            ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }

    private static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            // Ignorar
        }
    }
}
