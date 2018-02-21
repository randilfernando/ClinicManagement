package com.alternate.clinicmanagement.domain;

import java.io.Serializable;

/**
 * Created by Randil Fernando on 11/5/2016.
 */
public class Tablet extends Medicine implements Serializable {
    public Tablet(String brand, String drug, String weight) {
        super(brand, drug, weight);
    }
}
