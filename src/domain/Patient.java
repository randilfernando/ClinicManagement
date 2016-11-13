package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Randil Fernando on 11/5/2016.
 */
public class Patient extends Person implements Serializable {
    private ArrayList<Prescription> prescriptions;

    public Patient(String name, int age) {
        super(name, age);
        prescriptions = new ArrayList<>();
    }

    public boolean addPrescription(Prescription p) {
        return prescriptions.add(p);
    }

    public ArrayList<Prescription> getPrescriptions(){
        return prescriptions;
    }
}
