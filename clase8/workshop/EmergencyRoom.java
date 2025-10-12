package clase8.workshop;

import java.util.Scanner;

/**
 * EMERGENCY ROOM - Sistema Interactivo de Triage
 *
 * Sistema de gestión de pacientes en sala de emergencias
 * con priorización basada en severidad.
 */
public class EmergencyRoom {

    private TriageSystem triageSystem;
    private Scanner scanner;
    private int totalPatientsServed;

    public EmergencyRoom() {
        this.triageSystem = new TriageSystem();
        this.scanner = new Scanner(System.in);
        this.totalPatientsServed = 0;
    }

    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();
        er.run();
    }

    public void run() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║  EMERGENCY ROOM TRIAGE SYSTEM             ║");
        System.out.println("║  Hospital Management System v1.0          ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getIntInput("Choose option: ");

            switch (choice) {
                case 1:
                    registerNewPatient();
                    break;
                case 2:
                    callNextPatient();
                    break;
                case 3:
                    viewWaitingPatients();
                    break;
                case 4:
                    patientLeft();
                    break;
                case 5:
                    viewStatistics();
                    break;
                case 6:
                    running = false;
                    System.out.println("\n👋 Thank you for using Emergency Room System!");
                    System.out.println("Stay safe! 🏥\n");
                    break;
                default:
                    System.out.println("\n❌ Invalid option. Please try again.\n");
            }
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("════════════════════════════════════════════");
        System.out.println("           MAIN MENU");
        System.out.println("════════════════════════════════════════════");
        System.out.println("1. Register New Patient");
        System.out.println("2. Call Next Patient");
        System.out.println("3. View All Waiting Patients");
        System.out.println("4. Patient Left Without Being Seen");
        System.out.println("5. View Statistics");
        System.out.println("6. Exit System");
        System.out.println("════════════════════════════════════════════");
    }

    private void registerNewPatient() {
        System.out.println("\n──────── REGISTER NEW PATIENT ────────");

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter symptoms: ");
        String symptoms = scanner.nextLine();

        System.out.println("\nSelect priority:");
        System.out.println("  1 - CRITICAL (Life-threatening)");
        System.out.println("  2 - URGENT (Serious but stable)");
        System.out.println("  3 - STANDARD (Minor injuries)");

        int priority = getIntInput("Choice (1-3): ");

        if (priority < 1 || priority > 3) {
            System.out.println("\n❌ Invalid priority. Registration cancelled.\n");
            return;
        }

        String result = triageSystem.registerPatient(name, priority, symptoms);

        System.out.println("\n✅ Patient registered successfully!");
        System.out.println("   Name: " + name);
        System.out.println("   Priority: " + getPriorityLabel(priority));
        System.out.println("   " + result);

        // Calcular tiempo de espera estimado
        int queueSize = triageSystem.getPriorityQueueSize(priority);
        int estimatedWaitMinutes = queueSize * 20; // 20 minutos por paciente

        System.out.println("   Estimated wait: ~" + estimatedWaitMinutes + " minutes");
        System.out.println();

        triageSystem.displayStatus();
    }

    private void callNextPatient() {
        System.out.println("\n──────── CALLING NEXT PATIENT ────────");

        Patient patient = triageSystem.callNextPatient();

        if (patient == null) {
            System.out.println("📭 No patients waiting in the emergency room.");
        } else {
            totalPatientsServed++;
            System.out.println("🔔 NOW CALLING:");
            System.out.println("   Patient: " + patient.getName());
            System.out.println("   Priority: " + patient.getPriorityLabel());
            System.out.println("   Symptoms: " + patient.getSymptoms());
            System.out.println("   Arrived at: " + patient.getArrivalTime());
            System.out.println("\n✅ Patient is being attended.");
        }

        System.out.println();
        triageSystem.displayStatus();
    }

    private void viewWaitingPatients() {
        triageSystem.displayAllWaitingPatients();
        triageSystem.displayStatus();
    }

    private void patientLeft() {
        System.out.println("\n──────── PATIENT LEFT ────────");

        if (triageSystem.getTotalPatients() == 0) {
            System.out.println("📭 No patients in the waiting room.\n");
            return;
        }

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        boolean removed = triageSystem.removePatient(name);

        if (removed) {
            System.out.println("\n✅ Patient '" + name + "' has been removed from the queue.");
        } else {
            System.out.println("\n❌ Patient '" + name + "' not found in the system.");
        }

        System.out.println();
        triageSystem.displayStatus();
    }

    private void viewStatistics() {
        System.out.println("\n════════ EMERGENCY ROOM STATISTICS ════════");
        System.out.println("Total patients served today: " + totalPatientsServed);
        System.out.println("Currently waiting:");
        System.out.println("  - CRITICAL: " + triageSystem.getPriorityQueueSize(1));
        System.out.println("  - URGENT:   " + triageSystem.getPriorityQueueSize(2));
        System.out.println("  - STANDARD: " + triageSystem.getPriorityQueueSize(3));
        System.out.println("  - TOTAL:    " + triageSystem.getTotalPatients());
        System.out.println("═══════════════════════════════════════════\n");
    }

    private String getPriorityLabel(int priority) {
        switch (priority) {
            case 1: return "CRITICAL";
            case 2: return "URGENT";
            case 3: return "STANDARD";
            default: return "UNKNOWN";
        }
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Limpiar input inválido
            System.out.print("Invalid input. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpiar el newline
        return value;
    }
}
