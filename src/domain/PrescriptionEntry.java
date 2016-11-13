package domain;

import java.io.Serializable;

/**
 * Created by Randil Fernando on 11/6/2016.
 */
public class PrescriptionEntry implements Serializable {
    private Medicine medicine;
    private int amount;
    private int timeInterval;
    private int timeTaken;

    public PrescriptionEntry(Medicine medicine, int amount, int timeInterval, int timeTaken) {
        this.medicine = medicine;
        this.amount = amount;
        this.timeInterval = timeInterval;
        this.timeTaken = timeTaken;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
    // </editor-fold>
}
