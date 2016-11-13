package domain;

import java.io.Serializable;

/**
 * Created by Randil Fernando on 11/5/2016.
 */
public class Doctor extends Person implements Serializable {
    public Doctor(String name, int age) {
        super(name, age);
    }
}
