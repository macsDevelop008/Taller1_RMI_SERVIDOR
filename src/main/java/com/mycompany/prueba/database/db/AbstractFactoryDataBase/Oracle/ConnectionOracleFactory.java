/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba.database.db.AbstractFactoryDataBase.Oracle;

import com.mycompany.prueba.database.db.AbstractFactoryDataBase.IDataBase;
import com.mycompany.prueba.database.db.AbstractFactoryDataBase.IDataBaseFactory;

/**
 *
 * @author migue
 */
public class ConnectionOracleFactory implements IDataBaseFactory
{
    public ConnectionOracleFactory()
    {
        
    }
    
    @Override
    public IDataBase ConectarBaseDatos(String usuario, String contraseña, String nombreDB) 
    {
        return ConnectionOracle.getInstance(usuario, contraseña, nombreDB);
    }
    
}
