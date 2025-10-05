package clase8.workshop;

import java.util.Date;

public class Patient {
    String name;
    Date arrivalTime;
    int priority;
    String symptoms;

    public Patient(String name,Date arrivalTime, int priority, String symptoms){
        this.arrivalTime=arrivalTime;
        this.name= name;
        this.priority = priority;
        this.symptoms = symptoms;
    }

    public String toString(){
        return this.name +" | " + this.arrivalTime + " | " + this.priority + " | " +this.symptoms;
    }

}
