package com.mycompany.servidor.Structural;

import java.util.Date;

public class Sort {
    private String id;
    private String name;
    private double state_registration;
    private Date modification_date;

    public Sort(){

    }
    public Sort(String id, String name, double state_registry, Date date_modification) {
        this.id = id;
        this.name = name;
        this.state_registration = state_registry;
        this.modification_date = date_modification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double isState_registration() {
        return state_registration;
    }

    public void setState_registration(double state_registration) {
        this.state_registration = state_registration;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }
}
