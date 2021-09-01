/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba.database.businessobject.personajeBO;

import com.mycompany.prueba.database.db.AbstractFactoryDataBase.IDataBaseFactory;
import com.mycompany.prueba.valueobject.PersonajeVO;
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
public class PersonajeBO implements IPersonajeBO
{
    public final static String NOMBRE_TABLA_SQL = "personaje";
    
    //Inyectar la DataBaseFactory objetivo de la base de datos.
    private IDataBaseFactory dataBase;
    
    private String user;
    private String password;
    private String nombreBD;

    public PersonajeBO(IDataBaseFactory dataBase, String user, String password, String nombreBD) 
    {
        this.dataBase = dataBase;
        this.user = user;
        this.password = password;
        this.nombreBD = nombreBD;
    }
    
    

    @Override
    public boolean insert(PersonajeVO personajeVO) 
    {
        boolean result = false;
        
        String id = personajeVO.getId();
        String nombre = personajeVO.getNombre();
        Double fuerza = personajeVO.getFuerza();
        Double mana = personajeVO.getMana();
        Double energia = personajeVO.getEnergia();
        String idEspecie = personajeVO.getId_especie();
        String idJugador = personajeVO.getId_jugador();
        double estadoRegistro = personajeVO.getEstadoRegistro();
        Date fechaModificacion = personajeVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "INSERT INTO "+ NOMBRE_TABLA_SQL + 
                " VALUES("+id+","+"'"+nombre+"'"+","+
                fuerza+","+mana+","+energia+","+
                idEspecie+","+idJugador+","+estadoRegistro+","
                +"TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY'))";
        
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
    }

    @Override
    public boolean update(PersonajeVO personajeVO) 
    {
        boolean result = false;
        
        String id = personajeVO.getId();
        String nombre = personajeVO.getNombre();
        Double fuerza = personajeVO.getFuerza();
        Double mana = personajeVO.getMana();
        Double energia = personajeVO.getEnergia();
        String idEspecie = personajeVO.getId_especie();
        String idJugador = personajeVO.getId_jugador();
        double estadoRegistro = personajeVO.getEstadoRegistro();
        Date fechaModificacion = personajeVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "UPDATE " + NOMBRE_TABLA_SQL + " SET nombre='"+
                nombre+"'"+","+"fuerza="+fuerza+","+
                "mana="+mana+","+"energia="+energia+","+
                "id_especie='"+idEspecie+"'"+","+
                "id_jugador='"+idJugador+"'"+","+"estado_registro="+estadoRegistro+","+
                "fecha_modificacion="+"TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY')"+
                "WHERE id="+id;
        
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
    }

    @Override
    public boolean delete(PersonajeVO personajeVO) 
    {
        boolean result = false;
        
        String id = personajeVO.getId();
        
        String sql = "DELETE FROM "+ NOMBRE_TABLA_SQL +" WHERE id ="+ id;
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
    }

    @Override
    public ArrayList<PersonajeVO> list() 
    {
        ArrayList<PersonajeVO> result = new ArrayList<>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL;
        
        System.out.println(sql);
        result = descomposeResultSet(dataBase.ConectarBaseDatos(user, password, nombreBD).executeQueryStatement(sql));
        
        return result;
    }

    @Override
    public PersonajeVO findById(PersonajeVO personajeVO) 
    {
        ArrayList<PersonajeVO> result = new ArrayList<>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL + " WHERE id ="+ personajeVO.getId();
        
        System.out.println(sql);
        result = descomposeResultSet(dataBase.ConectarBaseDatos(user, password, nombreBD).executeQueryStatement(sql));
        
        return result.get(0);
    }
    
    
    private ArrayList<PersonajeVO> descomposeResultSet(ResultSet resultSet)
    {
        ArrayList<PersonajeVO> result = new ArrayList<>();
        
        String id;
        String nombre;
        Double fuerza;
        Double mana;
        Double energia;
        String idEspecie;
        String idJugador;        
        String estadoRegistro;
        Date fechaModificacion;
        
        try 
        {
            while(resultSet.next())
            {
                id = resultSet.getString(1);
                nombre = resultSet.getString(2);
                fuerza = resultSet.getDouble(3);
                mana = resultSet.getDouble(4);
                energia = resultSet.getDouble(5);
                idEspecie = resultSet.getString(6);
                idJugador = resultSet.getString(7);                
                estadoRegistro = resultSet.getString(8);
                fechaModificacion = resultSet.getDate(9);               
                
                result.add(new PersonajeVO(
                        id, 
                        nombre,
                        fuerza,
                        mana,
                        energia,
                        idEspecie,
                        idJugador,
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
    public ArrayList<PersonajeVO> charactersAccordingToPlayer(PersonajeVO personajeVO)
    {
        ArrayList<PersonajeVO> result = new ArrayList<>();

        String sql = "SELECT * FROM personaje WHERE id_jugador =" + personajeVO.getId_jugador();
        System.out.println(sql);

        result = descomposeResultSet(dataBase.ConectarBaseDatos(user, password, nombreBD).executeQueryStatement(sql));

        return result;
    }
}
