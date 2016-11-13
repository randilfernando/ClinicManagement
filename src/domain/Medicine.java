package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Randil Fernando on 11/5/2016.
 */
public abstract class Medicine implements Serializable {
    private String brand;
    private String drug;
    private String weight;
    private Date expDate;
    private ArrayList<String> reactList;

    public Medicine(String brand, String drug, String weight) {
        this.brand = brand;
        this.drug = drug;
        this.weight = weight;
        this.expDate = new Date();
        reactList = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public ArrayList<String> getReactList() {
        return reactList;
    }
    //</editor-fold>

    public boolean addReactMed(Medicine m) {
        this.getReactList().add(m.getDrug());
        m.getReactList().add(this.getDrug());
        return true;
    }
}
