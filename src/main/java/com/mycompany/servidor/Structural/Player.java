package com.mycompany.servidor.Structural;

import java.util.Date;

public class Player {
    private int id;
    private String account;
    private String password;
    private String nickname;
    private String email;
    private boolean state_registration;
    private Date modification_date;

    public Player(){

    }

    public Player(int id, String account, String password, String nickname, String email, boolean state_registry, Date modification_date) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.state_registration = state_registry;
        this.modification_date = modification_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
