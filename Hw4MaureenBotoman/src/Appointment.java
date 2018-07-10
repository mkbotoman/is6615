/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maureen
 */
public class Appointment {
    private int timeH;
    private Doctor doctor;
    private Patient patient;

   
    public Appointment(int time, Doctor doc, Patient pat) {
        timeH = time;
        doctor = doc;
        patient = pat;
    }

    public String getApptInfo() { 
        String apptInfo = timeH + "am: doctor = " + doctor.getID() + " : " + doctor.getSpecialty() + "; patient =  " + patient.getID() + " : " + patient.getTreatment();
        System.out.println(apptInfo);
        return apptInfo;
    }

}
