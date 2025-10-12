package clase8.workshop;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Patient {
    private String name;
    private Date arrivalTime;
    private int priority;
    private String symptoms;

    public Patient(String name, Date arrivalTime, int priority, String symptoms){
        this.arrivalTime = arrivalTime;
        this.name = name;
        this.priority = priority;
        this.symptoms = symptoms;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public String getSymptoms() {
        return symptoms;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPriorityLabel() {
        switch (priority) {
            case 1: return "CRITICAL";
            case 2: return "URGENT";
            case 3: return "STANDARD";
            default: return "UNKNOWN";
        }
    }

    @Override
    public String toString(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return name + " | " + timeFormat.format(arrivalTime) + " | " +
               getPriorityLabel() + " | " + symptoms;
    }
}
