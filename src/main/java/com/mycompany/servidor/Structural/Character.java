package com.mycompany.servidor.Structural;

import java.util.Date;

public class Character {
    private int id;
    private String name;
    private int strength;
    private int mana;
    private int energy;
    private int idKind;
    private int  idPlayer;
    private boolean state_registration;
    private Date modification_date;

    public Character() {
    }

    public Character(int id, String name, int strength, int mana, int energy, int idKind, int idPlayer, boolean state_registration, Date modification_date) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getIdKind() {
        return idKind;
    }

    public void setIdKind(int idKind) {
        this.idKind = idKind;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public boolean isState_registration() {
        return state_registration;
    }

    public void setState_registration(boolean state_registration) {
        this.state_registration = state_registration;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }
}
