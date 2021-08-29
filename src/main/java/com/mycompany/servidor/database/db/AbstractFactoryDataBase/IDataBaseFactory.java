/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database.db.AbstractFactoryDataBase;

/**
 *
 * @author migue
 */
public interface IDataBaseFactory 
{
    public IDataBase ConectarBaseDatos(String usuario, String contraseña, String nombreDB);   //Rrtorna el objeto de la base de datos objetivo
}
