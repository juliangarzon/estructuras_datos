package clase8.workshop;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Iterator;
import java.util.Queue;

public class TriageSystem {
    private Queue<Patient> priority1;
    private Queue<Patient> priority2;
    private Queue<Patient> priority3;
    private final int avgTime = 20;

    public TriageSystem(){
        priority1 = new ArrayDeque<Patient>();
        priority2 = new ArrayDeque<Patient>();
        priority3 = new ArrayDeque<Patient>();
    }

    public String registerPatient(String name, int priority, String symptoms){
        Patient patient = new Patient(name, new Date(), priority, symptoms);
        int currentPosition = 0;
        switch (priority) {
            case 1:
                priority1.offer(patient);
                currentPosition = priority1.size();
                break;
            case 2:
                priority2.offer(patient);
                currentPosition = priority2.size();
                break;
            case 3:
                priority3.offer(patient);
                currentPosition = priority3.size();
                break;
            default:
                break;
        }
        String returnString = "The queue position is " + currentPosition + 
        "on the priority queue "+ priority;

        return returnString;
        
    }

    public Patient callNextPatient(){
        if (priority1.peek() != null){
            return priority1.poll();
        }
        if (priority2.peek() != null){
            return priority2.poll();
        }
        if (priority3.peek() != null){
            return priority3.poll();
        }
        return null;
    }

    public int getWaitingTime(Patient patient){
        int currentPosition = 0;
        switch (patient.getPriority()) {
            case 1:
                currentPosition = locatePatientOnQueue(patient, priority1);
                break;
            case 2:
                currentPosition = locatePatientOnQueue(patient, priority2);
                currentPosition =  currentPosition + priority1.size();
                break;
            default:
                currentPosition = locatePatientOnQueue(patient, priority3);
                currentPosition =  currentPosition + priority1.size();
                currentPosition =  currentPosition + priority2.size();
                break;

        }

        return avgTime*currentPosition;
    }

    public int locatePatientOnQueue(Patient patient, Queue<Patient> queue){
        Iterator<Patient> iter = queue.iterator();
        int i = 0;
        while(iter.hasNext()){
            i++;
            if(iter.next().equals(patient)){
                break;
            }
        }
        return i;
    }

    public void displayStatus(){
        System.out.println("\n========== EMERGENCY ROOM STATUS ==========");
        System.out.println("CRITICAL:  " + priority1.size() + " patients waiting");
        System.out.println("URGENT:    " + priority2.size() + " patients waiting");
        System.out.println("STANDARD:  " + priority3.size() + " patients waiting");
        System.out.println("-------------------------------------------");
        System.out.println("TOTAL:     " + (priority1.size() + priority2.size() + priority3.size()) + " patients");

        // Mostrar el siguiente paciente
        Patient next = getNextPatientWithoutRemoving();
        if (next != null) {
            System.out.println("\nNext to be called: " + next.getName() + " (" + next.getPriorityLabel() + ")");
        } else {
            System.out.println("\nNo patients waiting");
        }
        System.out.println("===========================================\n");
    }

    public void displayAllWaitingPatients(){
        System.out.println("\n============ ALL WAITING PATIENTS ============");

        if (priority1.isEmpty() && priority2.isEmpty() && priority3.isEmpty()) {
            System.out.println("No patients waiting");
        } else {
            if (!priority1.isEmpty()) {
                System.out.println("\n🔴 CRITICAL PATIENTS:");
                displayQueue(priority1);
            }

            if (!priority2.isEmpty()) {
                System.out.println("\n🟡 URGENT PATIENTS:");
                displayQueue(priority2);
            }

            if (!priority3.isEmpty()) {
                System.out.println("\n🟢 STANDARD PATIENTS:");
                displayQueue(priority3);
            }
        }
        System.out.println("==============================================\n");
    }

    private void displayQueue(Queue<Patient> queue) {
        int position = 1;
        for (Patient p : queue) {
            System.out.println("  " + position + ". " + p.toString());
            position++;
        }
    }

    public boolean removePatient(String patientName){
        // Buscar en todas las colas
        if (removeFromQueue(priority1, patientName)) {
            return true;
        }
        if (removeFromQueue(priority2, patientName)) {
            return true;
        }
        if (removeFromQueue(priority3, patientName)) {
            return true;
        }
        return false;
    }

    private boolean removeFromQueue(Queue<Patient> queue, String patientName) {
        Iterator<Patient> iter = queue.iterator();
        while (iter.hasNext()) {
            Patient p = iter.next();
            if (p.getName().equalsIgnoreCase(patientName)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    private Patient getNextPatientWithoutRemoving() {
        if (priority1.peek() != null) {
            return priority1.peek();
        }
        if (priority2.peek() != null) {
            return priority2.peek();
        }
        if (priority3.peek() != null) {
            return priority3.peek();
        }
        return null;
    }

    public int getTotalPatients() {
        return priority1.size() + priority2.size() + priority3.size();
    }

    public int getPriorityQueueSize(int priority) {
        switch (priority) {
            case 1: return priority1.size();
            case 2: return priority2.size();
            case 3: return priority3.size();
            default: return 0;
        }
    }
}
