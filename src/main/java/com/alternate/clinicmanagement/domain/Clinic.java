package com.alternate.clinicmanagement.domain;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Randil Fernando on 11/5/2016.
 */
public class Clinic implements Serializable {
    private String name;
    private ArrayList<Medicine> medicines;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Clinic(String name) {
        this.name = name;
        medicines = new ArrayList<>();
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    //<editor-fold defaultstate="collapsed" desc="add data">
    public boolean addMedicine(Medicine m) {
        return medicines.add(m);
    }

    public boolean addPatient(Patient p) {
        return patients.add(p);
    }

    public boolean addDoctor(Doctor d) {
        return doctors.add(d);
    }
    //</editor-fold>

    public Medicine getMedicine(String name) {
        for (Medicine m : medicines) {
            if (m.getDrug().equals(name)) return m;
        }
        return null;
    }

    public Patient getPatient(String name) {
        for (Patient p : patients) {
            if (p.getName().equals(name)) return p;
        }
        return null;
    }

    public Doctor getDoctor(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equals(name)) return d;
        }
        return null;
    }

    public void doSerialize() throws IOException{
        FileOutputStream f_out = new FileOutputStream("D:\\myobject.data");
        ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
        obj_out.writeObject (medicines);
    }
}
