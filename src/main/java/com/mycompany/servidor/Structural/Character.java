package com.mycompany.servidor.Structural;

import java.util.Date;

public class Character {
    private String id;
    private String name;
    private double strength;
    private double mana;
    private double energy;
    private String idKind;
    private String  idPlayer;
    private double state_registration;
    private Date modification_date;

    public Character() {
    }

    public Character(String id, String name, double strength, double mana, double energy, String  idKind, String  idPlayer, double state_registration, Date modification_date) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.mana = mana;
        this.energy = energy;
        this.idKind = idKind;
        this.idPlayer = idPlayer;
        this.state_registration = state_registration;
        this.modification_date = modification_date;
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

    public double getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String  idPlayer) {
        this.idPlayer = idPlayer;
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
