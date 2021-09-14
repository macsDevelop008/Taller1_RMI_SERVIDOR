/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba.businessobject.jugadorBO;

import com.mycompany.prueba.db.AbstractFactoryDataBase.IDataBaseFactory;
import com.mycompany.prueba.valueobject.JugadorVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author migue
 */
public class JugadorBO implements IJugadorBO
{
    
    public final static String NOMBRE_TABLA_SQL = "jugador";
    
    //Inyectar la DataBaseFactory objetivo de la base de datos.
    private IDataBaseFactory dataBase;
    
    private String user;
    private String password;
    private String nombreBD;

    public JugadorBO(IDataBaseFactory dataBase, String user, String password, String nombreBD) 
    {
        this.dataBase = dataBase;
        this.user = user;
        this.password = password;
        this.nombreBD = nombreBD;
    }
    
    
    
    @Override
    public boolean insert(JugadorVO jugadorVO) 
    {
        boolean result = false;
        
        String id = jugadorVO.getId();
        String cuenta = jugadorVO.getCuenta();
        String contraseña = jugadorVO.getContraseña();
        String apodo = jugadorVO.getApodo();
        String email = jugadorVO.getEmail();
        double estadoRegistro = jugadorVO.getEstadoRegistro();
        Date fechaModificacion = jugadorVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "INSERT INTO "+ NOMBRE_TABLA_SQL+ " VALUES("+ 
                id+","+"'"+cuenta+"'"+","+"'"+contraseña+"'"+
                ","+"'"+apodo+"'"+","+ "'"+email+"'"+","+ estadoRegistro+
                ","+ "TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY'))";
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
    }

    @Override
    public boolean update(JugadorVO jugadorVO) 
    {
        boolean result = false;
        
        String id = jugadorVO.getId();
        String cuenta = jugadorVO.getCuenta();
        String contraseña = jugadorVO.getContraseña();
        String apodo = jugadorVO.getApodo();
        String email = jugadorVO.getEmail();
        double estadoRegistro = jugadorVO.getEstadoRegistro();
        Date fechaModificacion = jugadorVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql ="UPDATE " + NOMBRE_TABLA_SQL + " SET cuenta = '"+ cuenta + "'" +
                ", contraseña =" + "'"+ contraseña +"'"+","+
                "apodo = '"+apodo+"'"+","+ "email = '"+email+"'"+","+ 
                "estado_registro ="+ estadoRegistro+","+
                "fecha_modificacion ="+ "TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY')" +
                "WHERE id ="+ "'"+id+"'";
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
        
    }

    @Override
    public boolean delete(JugadorVO jugadorVO) 
    {
        boolean result = false;
        
        String id = jugadorVO.getId();
        
        String sql = "DELETE FROM "+ NOMBRE_TABLA_SQL +" WHERE id ="+ "'"+id+"'";
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
    }

    @Override
    public ArrayList<JugadorVO> list() 
    {
        ArrayList<JugadorVO> result = new ArrayList<>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL;
        
        System.out.println(sql);
        result = descomposeResultSet(dataBase.ConectarBaseDatos(user, password, nombreBD).executeQueryStatement(sql));
        
        return result;
    }
    
    @Override
    public JugadorVO findById(JugadorVO jugadorVO) 
    {
        ArrayList<JugadorVO> result = new ArrayList<>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL + " WHERE id ="+ "'"+jugadorVO.getId()+"'";
        
        System.out.println(sql);
        result = descomposeResultSet(dataBase.ConectarBaseDatos(user, password, nombreBD).executeQueryStatement(sql));
        
        return result.get(0);
    }
    
    
    private ArrayList<JugadorVO> descomposeResultSet(ResultSet resultSet)
    {
        ArrayList<JugadorVO> result = new ArrayList<>();
        
        String id;
        String cuenta;
        String contraseña;
        String apodo;
        String email;
        String estadoRegistro;
        Date fechaModificacion;
        
        try 
        {
            while(resultSet.next())
            {
                //id = Integer.parseInt(resultSet.getString(1));
                id = resultSet.getString(1);
                cuenta = resultSet.getString(2);
                contraseña = resultSet.getString(3);
                apodo = resultSet.getString(4);
                email = resultSet.getString(5);
                estadoRegistro = resultSet.getString(6);
                fechaModificacion = resultSet.getDate(7);               
                
                result.add(new JugadorVO(
                        id, 
                        cuenta,
                        contraseña,
                        apodo,
                        email,
                        Double.parseDouble(estadoRegistro), 
                        fechaModificacion));
            }
        } 
        catch (SQLException ex)
        {
            System.out.println("Error en descomposeResultSet: " + ex);
        }  
        return result;
    }
    
}
