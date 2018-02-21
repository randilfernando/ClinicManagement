package com.alternate.clinicmanagement.service;

import com.alternate.clinicmanagement.domain.*;

/**
 * Created by Randil Fernando on 11/7/2016.
 */
public class ClinicService
{
    private final Clinic clinic;
    private Doctor selectedDoctor;
    private Patient selectedPatient;
    private Medicine selectedMedicine;
    private Prescription selectedPrescription;

    public ClinicService(String clinicName){
        clinic = new Clinic(clinicName);
    }

    public Doctor getSelectedDoctor() {
        return selectedDoctor;
    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public Medicine getSelectedMedicine() {
        return selectedMedicine;
    }

    public boolean addDoctor(String name, String age){
        Doctor d = new Doctor(name,Integer.parseInt(age));
        clinic.addDoctor(d);
        return true;
    }

    public boolean addPatient(String name, String age){
        Patient p = new Patient(name,Integer.parseInt(age));
        clinic.addPatient(p);
        return true;
    }

    public boolean addTablet(String drug, String brand, String weight){
        Medicine m = new Tablet(brand,drug,weight);
        clinic.addMedicine(m);
        return true;
    }

    public boolean addCapsule(String drug, String brand, String weight){
        Medicine m = new Capsule(brand,drug,weight);
        return clinic.addMedicine(m);
    }

    public boolean addReactMed(Medicine m1){
        return m1.addReactMed(selectedMedicine);
    }

    public boolean getDoctor(String name){
        selectedDoctor = clinic.getDoctor(name);
        return selectedDoctor != null;
    }

    public boolean getPatient(String name){
        selectedPatient = clinic.getPatient(name);
        return selectedPatient != null;
    }

    public boolean getMedicine(String drug){
        selectedMedicine = clinic.getMedicine(drug);
        return selectedMedicine != null;
    }

    public boolean createPrescription(){
        selectedPrescription = new Prescription(selectedDoctor);
        return true;
    }

    public boolean addPrescriptionEntry(String amount, String timeInterval, String timeTaken){
        PrescriptionEntry pE = new PrescriptionEntry(selectedMedicine, Integer.parseInt(amount),
                Integer.parseInt(timeInterval), Integer.parseInt(timeTaken));
        return selectedPrescription.addEntry(pE);
    }

    public boolean finalisePrescription(){
        return selectedPatient.addPrescription(selectedPrescription);
    }
}
