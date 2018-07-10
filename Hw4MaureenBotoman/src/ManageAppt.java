
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maureen
 */
public class ManageAppt {

    /**
     * @param args the command line arguments
     */
    final static int DOCSIZE = 5;
    final static int PATSIZE = 15;

    public static void main(String[] args) {
        
        ArrayList<Doctor> docArr = new ArrayList<Doctor>();
        ArrayList<Patient> patArr = new ArrayList<Patient>();
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        
        System.out.println("Thank you for visiting Medical Center portal. \nPlease enter one of the following choices and we will do our best to assist you.");

        do {
            try {
                System.out.println(
                "1.     Simulate\n" +
                "2.     View doctors\n" +
                "3.     View patients\n" +
                "4.     View appointments for a particular doctor\n" + 
                "5.     View appointment for a particular patient\n" +
                "6.     Exit from system");
                int choice = Integer.parseInt(sc.nextLine());
                if(choice == 1) {
                    simulate(docArr, patArr);
                } else if(choice == 2) {
                    if(docArr.size() == 0){
                        System.out.println("There are no doctors in the system. Please simulate first.");

                    } else {
                        printDocInfo(docArr); 
                    }
                } else if(choice == 3) {
                    if(patArr.size() == 0) {
                        System.out.println("There are no patients in the system. Please simulate first.");
                    } else {
                        printPatInfo(patArr);
                    }
                } else if(choice == 4) {
                    if(docArr.size() == 0) {
                        System.out.println("There are no doctors in the system. Please simulate first.");
                    } else {
                        System.out.println("Please enter a doctor ID");
                        int dID = Integer.parseInt(sc.nextLine());
                        viewDocAppt(dID, docArr);
                    }

                } else if(choice == 5) {
                    if(patArr.size() == 0) {
                        System.out.println("There are no patients in the system. Please simulate first.");
                    } else {
                        System.out.println("Please enter a Patient ID");
                        int pID = Integer.parseInt(sc.nextLine());
                        viewPatAppt(pID, patArr);
                    }
                } else if(choice == 6) {
                    System.out.println("Goodbye");
                    menu = false;
                }  
                else {
                    throw(new InputMismatchException("Choice not in range. Please"));
                }
            } catch (InputMismatchException ime) {
                    System.err.println("Invalid selection. Try again");
            } catch (NumberFormatException nfe) {
                System.err.println("Bad input, please choose a menu option number 1-6");
            } catch (Exception exception) {
                System.out.println("An error has occured: " + exception + "\nPlease try again.");
            }
        } while (menu == true);
    }
    public static void simulate(ArrayList<Doctor> docList, ArrayList<Patient> patList) {
        Random random = new Random();
        int docID = 101;
        int patID = 5001;
        int docCreated = 0;
        int patCreated = 0;
        
        if(docList.size() != 0) {
            docList.clear();
        }
        if(patList.size() != 0) {
            patList.clear();
        }
        
        for(int i = 0; i < DOCSIZE; i++) {
            Specialty specialty = Specialty.values()[random.nextInt(Specialty.values().length)];
            docList.add(new Doctor(docID, specialty));
            docID++;
            docCreated++;
            
        }
        
        for(int i = 0; i < PATSIZE; i++) {
            Specialty treatment = Specialty.values()[random.nextInt(Specialty.values().length)];
            patList.add(new Patient(patID, treatment));
            patID++;
            patCreated++;
        }
        System.out.println(docCreated + " doctors have been created.\n" + patCreated + " patients have been created.");
        assignAppt(docList, patList);
    }
    public static void assignAppt(ArrayList<Doctor> dList, ArrayList<Patient> pList) {
        boolean docFound = false;
        boolean appointed = false;
        int patNoDoc = 0;
        int patNoAppt = 0;
        int patAppointed = 0;
        
        for(Patient aPatient : pList) {
            docFound = false;
            appointed = false;
            for(Doctor aDoctor : dList) {
                if(aPatient.getTreatment() == aDoctor.getSpecialty()) {
                    docFound = true;
                    if(aDoctor.isAvailable()) {
                        aDoctor.addToSchedule(aPatient);
                        appointed = true;
                        patAppointed++;
                        break;
                    }
                }
            }
            if(!docFound) {
                patNoDoc++;
            }
            if(docFound && !appointed) {
                patNoAppt++;
            }
        }
        System.out.println(patAppointed + " patients have been scheduled for an appointment.\n"
            + patNoDoc + " patients were rejected because no doctor with the desired specialty is present.\n"
            + patNoAppt + " patients were rejected because all available doctors of the specialty have no appointments available.");
       
    }
    public static void printDocInfo(ArrayList<Doctor> dList) {
        System.out.println("printing list of simulated doctors");
        for(int i = 0; i < dList.size(); i++) {
            System.out.println(dList.get(i).getID() + " " + dList.get(i).getSpecialty() + " Appointments: " + dList.get(i).getSchedule().size());
        }
    }
    public static void printPatInfo(ArrayList<Patient> pList) { 
        System.out.println("printing list of simulated patients");
        for(int i = 0; i < pList.size(); i++) {
            System.out.println(pList.get(i).getID() + " " + pList.get(i).getTreatment());
        }
    }
    public static void viewDocAppt(int docIDToSearch, ArrayList<Doctor> docList) { 
        boolean found = false;
        
        for(int i = 0; i < docList.size(); i++) {
            Doctor aDoc = docList.get(i);
            
            if(aDoc.getID() == docIDToSearch) {
                found = true;
                System.out.println("Doctor " + aDoc.getID() + ", Specialty is " + aDoc.getSpecialty());
                ArrayList<Appointment> docSchedule = aDoc.getSchedule();
                for(int j = 0; j < docSchedule.size();j++) {
                    docSchedule.get(j).getApptInfo();
                }
            }
            
        }
        if(!found) {
            System.out.println("That doctor wasn't found in the system.");
        }
        
    } 
    public static void viewPatAppt(int patIDToSearch, ArrayList<Patient> patList) { 
     boolean found = false;
        
        for(int i = 0; i < patList.size(); i++) {
            Patient aPat = patList.get(i);
            
            if(aPat.getID() == patIDToSearch) {
                
                Appointment patAppt = aPat.getAppt();
                if(patAppt == null) {
                    found = true;
                    System.out.println("Patient " + patIDToSearch + " doesn't have an appointment");
                } else {
                    found = true;
                    patAppt.getApptInfo();
                }
                
            }
        }
        if(!found) {
            System.out.println("That patient wasn't found in the system.");
        }
    } 
}
