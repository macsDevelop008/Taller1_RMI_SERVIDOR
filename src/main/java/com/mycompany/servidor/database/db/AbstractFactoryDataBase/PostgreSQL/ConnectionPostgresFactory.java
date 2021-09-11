/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.DataBase.db.AbstractFactoryDataBase.PostgreSQL;

import com.mycompany.servidor.database.db.AbstractFactoryDataBase.IDataBase;
import com.mycompany.servidor.database.db.AbstractFactoryDataBase.IDataBaseFactory;

/**
 *
 * @author migue
 */
public class ConnectionPostgresFactory implements IDataBaseFactory
{

    public ConnectionPostgresFactory() 
    {
        
    }
    
    @Override
    public IDataBase ConectarBaseDatos(String usuario, String contraseña, String nombreDB)
    {
        return ConnectionPostgresSQL.getInstance(usuario, contraseña, nombreDB);
    }
    
}
