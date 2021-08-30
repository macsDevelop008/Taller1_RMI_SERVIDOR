/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba.database.db.AbstractFactoryDataBase;

import java.sql.ResultSet;

/**
 *
 * @author migue
 */
public interface IDataBase 
{
    public ResultSet executeQueryStatement(String cad);     //Metodo que permite ejecutar una consulta y retorna un objeto ResulSet con los resultados.
    public boolean executeUpdateStatement(String cad);      //Metodo que permite ejecutar una transaccion de insercion o actualizacion o eliminacion
    public void executeProcedure(String cadProc);           //Metodo para invocar un procedimiento almacenado
    public void closeConecction();                          //Objeto que cierra la conexion con la base de datos.
}
