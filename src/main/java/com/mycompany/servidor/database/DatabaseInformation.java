/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database;

/**
 *
 * @author migue
 */
public class DatabaseInformation 
{
    private String usuarioDB;
    private String contraseñaDB;
    private String nombreDB;

    public DatabaseInformation(String usuarioDB, String contraseñaDB, String nombreDB) 
    {
        this.usuarioDB = usuarioDB;
        this.contraseñaDB = contraseñaDB;
        this.nombreDB = nombreDB;
    }

    public String getUsuarioDB() {
        return usuarioDB;
    }

    public void setUsuarioDB(String usuarioDB) {
        this.usuarioDB = usuarioDB;
    }

    public String getContraseñaDB() {
        return contraseñaDB;
    }

    public void setContraseñaDB(String contraseñaDB) {
        this.contraseñaDB = contraseñaDB;
    }

    public String getNombreDB() {
        return nombreDB;
    }

    public void setNombreDB(String nombreDB) {
        this.nombreDB = nombreDB;
    }

    @Override
    public String toString() {
        return "DatabaseInformation{" + "usuarioDB=" + usuarioDB + ", contrase\u00f1aDB=" + contraseñaDB + ", nombreDB=" + nombreDB + '}';
    }    
    
    
}
