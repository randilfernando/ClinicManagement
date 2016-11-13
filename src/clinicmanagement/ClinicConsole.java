package clinicmanagement;

import com.sun.org.apache.xpath.internal.SourceTree;
import domain.Medicine;
import domain.Prescription;
import domain.PrescriptionEntry;

import java.util.Scanner;

/**
 * Created by Randil Fernando on 11/6/2016.
 */
public class ClinicConsole {
    private static Scanner console;
    private static ClinicHandler clinicHandler;

    //<editor-fold defaultstate="collapsed" desc="Add Menus">
    private static void addDoctor(){
        String dname,dage;
        System.out.print("Enter name: ");
        dname = console.next();
        System.out.print("Enter age: ");
        dage = console.next();
        if(clinicHandler.addDoctor(dname, dage)){
            System.out.println("Successful");
        }
    }

    private static void addPatient(){
        String pname,page;
        System.out.print("Enter name: ");
        pname = console.next();
        System.out.print("Enter age: ");
        page = console.next();
        if(clinicHandler.addPatient(pname, page)){
            System.out.println("Successful");
        }
    }

    private static void addTablet(){
        String drug,brand,weight;
        System.out.print("Enter drug name: ");
        drug = console.next();
        System.out.print("Enter brand name: ");
        brand = console.next();
        System.out.print("Enter weight: ");
        weight = console.next();
        if(clinicHandler.addTablet(drug, brand, weight)){
            System.out.println("Successful");
        }
    }

    private static void addCapsule(){
        String drug,brand,weight;
        System.out.print("Enter drug name: ");
        drug = console.next();
        System.out.print("Enter brand name: ");
        brand = console.next();
        System.out.print("Enter weight: ");
        weight = console.next();
        if(clinicHandler.addCapsule(drug, brand, weight)){
            System.out.println("Successful");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Search Menus">
    private static boolean searchMedicine(){
        String mname;
        System.out.print("Enter medicine name: ");
        mname = console.next();
        while (!mname.equals("q")) {
            if (clinicHandler.getMedicine(mname)) {
                System.out.println("Selected medicine: " + clinicHandler.getSelectedMedicine().getDrug());
                return true;
            }
            System.out.println("No such entry found. Enter the name again or press 'q' to exit.....");
            mname = console.next();
        }
        return false;
    }

    private static boolean searchDoctor(){
        String dname;
        System.out.print("Enter doctor name: ");
        dname = console.next();
        while (!dname.equals("q")) {
            if (clinicHandler.getDoctor(dname)) {
                System.out.println("Selected doctor: " + clinicHandler.getSelectedDoctor().getName());
                return true;
            }
            System.out.println("No such entry found. Enter the name again or press 'q' to exit.....");
            dname = console.next();
        }
        return false;
    }

    private static boolean searchPatient(){
        String pname;
        System.out.print("Enter patient name: ");
        pname = console.next();
        while (!pname.equals("q")) {
            if (clinicHandler.getPatient(pname)) {
                System.out.println("Selected patient: " + clinicHandler.getSelectedPatient().getName());
                return true;
            }
            System.out.println("No such entry found. Enter the name again or press 'q' to exit.....");
            pname = console.next();
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Prescriptions">
    private static void addPrescription(){
        searchDoctor();
        clinicHandler.createPrescription();
        String amount,interval,taken;
        System.out.println("1.Add entry\n2.finalize");
        String addentry = "1";
        while(addentry.equals("1")){
            if (searchMedicine()){
                System.out.println("Enter amount");
                amount = console.next();
                System.out.println("Enter time interval");
                interval = console.next();
                System.out.println("Enter time taken");
                taken = console.next();
                if (clinicHandler.addPrescriptionEntry(amount,interval,taken)){
                    System.out.println("Successful");
                }else{
                    System.out.println("Reacting medicine already in the prescription!");
                }
            }
            System.out.println("1.Add entry\n2.finalize");
            addentry = console.next();
        }
        clinicHandler.finalisePrescription();
    }

    private static void printPrescription(){
        for (Prescription p : clinicHandler.getSelectedPatient().getPrescriptions()) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println(String.format("Prescription [%s]", p.getDate()));
            System.out.println("Dr. " + p.getDoctor().getName());
            for (PrescriptionEntry pE : p.getEntries()) {
                printPrescriptionEntry(pE);
            }
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    private static void printPrescriptionEntry(PrescriptionEntry pE){
        String s = String.format("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t",
                pE.getMedicine().getDrug(),pE.getMedicine().getBrand(),pE.getMedicine().getWeight(),
                pE.getAmount(),pE.getTimeInterval(),pE.getTimeTaken());
        System.out.println(s);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MainSelection">
    private static void MainSelection(){
        int selection;
        selection = Integer.parseInt(console.next());

        switch (selection) {
            case 1:
                System.out.println("Adding a doctor..............");
                addDoctor();
                break;
            case 2:
                System.out.println("Adding a patient..............");
                addPatient();
                break;
            case 3:
                System.out.println("Adding a tablet..............");
                addTablet();
                break;
            case 4:
                System.out.println("Adding a capsule..............");
                addCapsule();
                break;
            case 5:
                System.out.println("Searching medicine..............");
                searchMedicine();
                medicineSelection();
                break;
            case 6:
                System.out.println("Searching doctor..............");
                searchDoctor();
                break;
            case 7:
                System.out.println("Searching patient..............");
                searchPatient();
                patientSelection();
                break;
            case 8:
                System.exit(0);
            default:
                printMenu();
        }
        System.out.println("=========================================================================================");
    }
    //</editor-fold>()

    //<editor-fold defaultstate="collapsed" desc="SubSelection">
    private static void medicineSelection(){
        System.out.println("1.Add reacting medicine\n2.Back");
        String medName = "";
        if (console.next().equals("1")){
            Medicine temp = clinicHandler.getSelectedMedicine();
            System.out.println("Searching medicine..............");
            System.out.print("Enter medicine name: ");
            medName = "";
            while (!medName.equals("q")) {
                medName = console.next();
                if (clinicHandler.getMedicine(medName)) {
                    clinicHandler.addReactMed(temp);
                    break;
                }
                System.out.println("No such entry found. Enter the name again or press 'q' to exit.....");
            }
        }
    }

    private static void patientSelection(){
        System.out.println("1.Add prescription\n2.Print prescriptions\n3.Back");
        int choice = Integer.parseInt(console.next());
        switch(choice){
            case 1:
                addPrescription();
                break;
            case 2:
                printPrescription();
                break;
        }
    }
    //</editor-fold>

    private static void printMenu(){
        System.out.println("Clinic management system.\n" +
                "1.Add doctor\n2.Add patient\n3.Add tablet\n4.Add capsule\n\n5.Search Medicine" +
                "\n6.Search doctor\n7.Search patient\n8.Exit\n9.Print menu");
    }

    public static void clinicConsoleRun(){
        console = new Scanner(System.in);
        System.out.print("Enter new clinic name: ");
        clinicHandler = new ClinicHandler(console.next());
        printMenu();
        System.out.println("=========================================================================================");

        while (true) {
            MainSelection();
        }
    }
}