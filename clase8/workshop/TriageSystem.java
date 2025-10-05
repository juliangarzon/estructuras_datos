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
        switch (patient.priority) {
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
}
