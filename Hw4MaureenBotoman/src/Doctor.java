
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maureen
 */
public class Doctor {
    private final int dID;
    private Specialty dSpec = null;
    private ArrayList<Appointment> schedule = new ArrayList<>();
    private boolean available = true;
    private static final int MAXAPPT = 3;
    private static int startTime = 9;
    
    public Doctor(int id, Specialty spec) {    
        dID = id;
        dSpec = spec;
    }
    
    public int getID() { 
        return dID;
    }
    public Specialty getSpecialty() { 
        return dSpec;
    }
    public ArrayList<Appointment> getSchedule() { 
        return schedule;
    }  
    public boolean isAvailable() {
        if(schedule.size() < MAXAPPT) {
            return true;
        } else {
            return false;
        }
    }
    public void addToSchedule(Patient patID) {
        if(schedule.size() == 0) {
            startTime = 9;
        }
        Appointment newAppointment = new Appointment(startTime, this, patID);
        schedule.add(newAppointment);
        
        patID.setAppt(newAppointment);
        startTime++;
    }   


}
