package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Randil Fernando on 11/6/2016.
 */
public class Prescription implements Serializable {
    private Doctor doctor;
    private Date date;
    private ArrayList<PrescriptionEntry> entries;

    public Prescription(Doctor doctor) {
        this.doctor = doctor;
        this.date =new Date();
        entries = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<PrescriptionEntry> getEntries() {
        return entries;
    }
    //</editor-fold>

    //<editor-fold defaultstate="expanded" desc="prescription entries">
    public boolean addEntry(PrescriptionEntry p) {
        for (String name : p.getMedicine().getReactList()) {
            for (PrescriptionEntry pE : entries) {
                if (pE.getMedicine().getDrug() == name) return false;
            }
        }
        entries.add(p);
        return true;
    }

    public boolean deleteEntry(PrescriptionEntry p) {
        entries.remove(p);
        return true;
    }
    //</editor-fold>
}
