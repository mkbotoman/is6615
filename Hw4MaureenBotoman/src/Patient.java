/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maureen
 */
public class Patient {

    private final int pID;
    private Specialty treat = null;
    private Appointment appt = null;

   
    public Patient(int id, Specialty spec) {
        pID = id;
        treat = spec;
    }
    
    public int getID() { 
        return pID;
    }
    public Specialty getTreatment() {
        return treat;
    }
    public void setAppt (Appointment info) { 
        appt = info;
    }
    public Appointment getAppt () { 
        return appt;
    }

}
