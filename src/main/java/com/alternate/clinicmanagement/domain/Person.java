package com.alternate.clinicmanagement.domain;

import java.io.Serializable;

/**
 * Created by Randil Fernando on 11/5/2016.
 */
public abstract class Person implements Serializable {
    private String name;
    private int age;

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //</editor-fold>
}
