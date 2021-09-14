/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba.db.AbstractFactoryDataBase.PostgreSQL;
import com.mycompany.prueba.db.AbstractFactoryDataBase.IDataBase;
import java.sql.*;
/**
 *
 * @author migue
 */
public class ConnectionPostgresSQL implements IDataBase
{
    
    //Singleton
    private static ConnectionPostgresSQL connectionPostgresSQL = null;
    
    private Connection con;  
    private String user;
    private String password;
    private String url;
    private String nombreBD;
    
    //Metodo a invocar para poder conectar con la DB
    public static ConnectionPostgresSQL getInstance(String pUs, String pPass, String pNombreDB)
    {
        if (connectionPostgresSQL == null)
        {
            connectionPostgresSQL = new ConnectionPostgresSQL(pUs, pPass, pNombreDB);
        }
        return connectionPostgresSQL;
    }

    private ConnectionPostgresSQL(String user, String password, String nombreBD) 
    {
        this.user = user;
        this.password = password;
        this.nombreBD = nombreBD;
        
        try
        {
            //Puente - conexión a la DB   
            url = "jdbc:postgresql://ec2-18-209-153-180.compute-1.amazonaws.com:5432/"+nombreBD;
            con = DriverManager.getConnection(url, user, password);

            //Test
            System.out.println("Conexión DB Exitosa: POSTGRES");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error, Conexión DB NO Exitosa: POSTGRES");
        }
    }   

    //Ejecuta el executeQuery -> Select y FinByID
    //@ Retorna -> resulSet que contiene la información
    @Override
    public ResultSet executeQueryStatement(String sql)
    {
        ResultSet resultSet = null;
        try
        {
            //Permite la ejecucion de instrucciones sql en la DB
            Statement statement = con.createStatement();
            resultSet = statement.executeQuery(sql);

            System.out.println("Consulta realizada: POSTGRES "+sql);
        }
        catch (SQLException e)
        {
            System.out.println("Consulta error: POSTGRES "+e.getMessage());
        }
        return resultSet;
    }

    //Ejecuta el executeUpdate -> Delete, update, insert
    //@ Return true o false, si lo hizo bien o no
    @Override
    public boolean executeUpdateStatement(String sql)
    {
        int rows=0;
        try
        {
            //Permite la ejecucion de instrucciones sql en la DB
            Statement statement = con.createStatement();
            rows = statement.executeUpdate(sql);
            System.out.println("Consulta realizada: POSTGRES "+sql);
            //System.out.println();
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Consulta error: POSTGRES "+e.getMessage());
            return false;
        }
    }
}
