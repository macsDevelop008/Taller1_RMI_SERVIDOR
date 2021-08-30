/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba.database;

import com.mycompany.prueba.database.businessobject.especieBO.EspecieBO;
import com.mycompany.prueba.database.businessobject.jugadorBO.JugadorBO;
import com.mycompany.prueba.database.businessobject.personajeBO.PersonajeBO;
import com.mycompany.prueba.database.db.AbstractFactoryDataBase.Oracle.ConnectionOracleFactory;
import com.mycompany.prueba.valueobject.EspecieVO;
import com.mycompany.prueba.valueobject.JugadorVO;
import com.mycompany.prueba.valueobject.PersonajeVO;
import com.mycompany.prueba.valueobject.Tabla;
import java.util.ArrayList;

public class MainDataBase
{
   
    //Consultas -> INSERTAS-ACTUALIZAR-ELIMINAR
    public static boolean simpleAccordingToTheDatabase(DataBaseObjective dataBase, DatabaseInformation databaseInformation,
                                                        Tabla objectVO, TypeOfQuery typeQuery)
    {
        boolean resultado = false;
        
        //Base de datos
        switch(dataBase)
        {
            case ORACLE:
                
                ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
                
                //Tabla
                switch(objectVO.nameTable())
                {
                    case "jugador":
                        
                        JugadorBO jugadorBO = new JugadorBO(dbOracle, 
                            databaseInformation.getUsuarioDB(), 
                            databaseInformation.getContraseñaDB(), 
                            databaseInformation.getNombreDB());
                        
                        resultado = tableJugadorSimple(jugadorBO, objectVO, typeQuery);
                        
                        break;
                        
                    case "personaje":
                        
                        PersonajeBO personajeBO = new PersonajeBO(dbOracle, 
                            databaseInformation.getUsuarioDB(), 
                            databaseInformation.getContraseñaDB(), 
                            databaseInformation.getNombreDB());
                        
                        resultado = tablePersonajeSimple(personajeBO, objectVO, typeQuery);
                        
                        break;
                    
                    case "especie":
                        
                            EspecieBO especiejeBO = new EspecieBO(dbOracle, 
                            databaseInformation.getUsuarioDB(), 
                            databaseInformation.getContraseñaDB(), 
                            databaseInformation.getNombreDB());
                        
                        resultado = tableEspeciejeSimple(especiejeBO, objectVO, typeQuery);
                        break;
                }               
                break;
        }
        
        return resultado;
    }
    
    
    //---------------------------------------------------------------------------------------------
    static boolean tableJugadorSimple(JugadorBO jugadorBO, Tabla objectVO, TypeOfQuery typeQuery)
    {
        boolean resultado = false;
        
        switch(typeQuery)
        {
            case INSERTAR:
                resultado = jugadorBO.insert((JugadorVO)objectVO);
                break;
            case ACTUALIZAR:
                resultado = jugadorBO.update((JugadorVO)objectVO);
                break;
            case ELIMINAR:
                resultado = jugadorBO.delete((JugadorVO)objectVO);
                break;
        }
        
        return resultado;
    }
    static boolean tablePersonajeSimple(PersonajeBO personajeBO, Tabla objectVO, TypeOfQuery typeQuery)
    {
        boolean resultado = false;
        
        switch(typeQuery)
        {
            case INSERTAR:
                resultado = personajeBO.insert((PersonajeVO)objectVO);
                break;
            case ACTUALIZAR:
                resultado = personajeBO.update((PersonajeVO)objectVO);
                break;
            case ELIMINAR:
                resultado = personajeBO.delete((PersonajeVO)objectVO);
                break;
        }
        
        return resultado;
    }
    static boolean tableEspeciejeSimple(EspecieBO especieBO, Tabla objectVO, TypeOfQuery typeQuery)
    {
        boolean resultado = false;
        
        switch(typeQuery)
        {
            case INSERTAR:
                resultado = especieBO.insert((EspecieVO)objectVO);
                break;
            case ACTUALIZAR:
                resultado = especieBO.update((EspecieVO)objectVO);
                break;
            case ELIMINAR:
                resultado = especieBO.delete((EspecieVO)objectVO);
                break;
        }
        
        return resultado;
    }
    
    //---------------------------------------------------------------------------------------------
    //           SIGUIENTES METODOS USAR ASÍ POR EL MOMENTO - TENGO MUCHO SUEÑO YA :V
    //---------------------------------------------------------------------------------------------
    
    
    public static ArrayList<JugadorVO> listJugador(DatabaseInformation databaseInformation)
    {
        ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        JugadorBO jugadorBO = new JugadorBO(dbOracle, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        ArrayList<JugadorVO> list = new ArrayList<>();
        
        list = jugadorBO.list();
         
         return list;
    }
    
    public static JugadorVO findJugadorById(DatabaseInformation databaseInformation, Tabla objectVO)
    {
        ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        JugadorBO jugadorBO = new JugadorBO(dbOracle, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        JugadorVO jugadorVo = null;
        
        jugadorVo = jugadorBO.findById((JugadorVO)objectVO);
         
        return jugadorVo;
    }
    
    //---------------------------------------------------------------------------------------------
    
    public static ArrayList<PersonajeVO> listPersonaje(DatabaseInformation databaseInformation)
    {
        ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        PersonajeBO personajeBO = new PersonajeBO(dbOracle, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        ArrayList<PersonajeVO> list = new ArrayList<>();
        
        list = personajeBO.list();
         
        return list;
    }
    
    public static PersonajeVO findPersonajeById(DatabaseInformation databaseInformation, Tabla objectVO)
    {
        ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        PersonajeBO personajeBO = new PersonajeBO(dbOracle, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        PersonajeVO personajeVO = null;
        
        personajeVO = personajeBO.findById((PersonajeVO)objectVO);
         
        return personajeVO;
    }
    
    //---------------------------------------------------------------------------------------------
    
    public static ArrayList<EspecieVO> listEspecie(DatabaseInformation databaseInformation)
    {
        ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        EspecieBO especieBO = new EspecieBO(dbOracle, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        ArrayList<EspecieVO> list = new ArrayList<>();
        
        list = especieBO.list();
         
         return list;
    }
    
    public static EspecieVO findEspecieById(DatabaseInformation databaseInformation, Tabla objectVO)
    {
        
        ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        EspecieBO especieBO = new EspecieBO(dbOracle, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        EspecieVO especieVO = null;
        
        especieVO = especieBO.findById((EspecieVO)objectVO);
         
        return especieVO;
    }
    
    
    
    //----------------------------------------------------------------------------------------------
    
//    static ArrayList<JugadorVO> listJugador(JugadorBO jugadorBO, TypeOfQuery typeQuery)
//    {
//        ArrayList<JugadorVO> list = new ArrayList<>();
//        
//         switch(typeQuery)
//         {
//            case LISTAR:
//                
//                list = jugadorBO.list();
//                
//                break;              
//         }
//         
//         return list;
//    }
//    
//    static JugadorVO findJugadorById(JugadorBO jugadorBO, Tabla objectVO, TypeOfQuery typeQuery)
//    {
//        JugadorVO jugadorVo = null;
//        
//         switch(typeQuery)
//         {
//            case BUSCAR_POR_ID:
//                
//                jugadorVo = jugadorBO.findById((JugadorVO)objectVO);
//                
//                break;              
//         }
//         
//         return jugadorVo;
//    }
//    
//    //---------------------------------------------------------------------------------------------
//    
//    static ArrayList<PersonajeVO> listPersonaje(PersonajeBO personajeBO, TypeOfQuery typeQuery)
//    {
//        ArrayList<PersonajeVO> list = new ArrayList<>();
//        
//         switch(typeQuery)
//         {
//            case LISTAR:
//                
//                list = personajeBO.list();
//                
//                break;              
//         }
//         
//         return list;
//    }
//    
//    static PersonajeVO findPersonajeById(PersonajeBO personajeBO, Tabla objectVO, TypeOfQuery typeQuery)
//    {
//        PersonajeVO personajeVO = null;
//        
//         switch(typeQuery)
//         {
//            case BUSCAR_POR_ID:
//                
//                personajeVO = personajeBO.findById((PersonajeVO)objectVO);
//                
//                break;              
//         }
//         
//         return personajeVO;
//    }
//    
//    //---------------------------------------------------------------------------------------------
//    
//    static ArrayList<EspecieVO> listEspecie(EspecieBO especieBO, TypeOfQuery typeQuery)
//    {
//        ArrayList<EspecieVO> list = new ArrayList<>();
//        
//         switch(typeQuery)
//         {
//            case LISTAR:
//                
//                list = especieBO.list();
//                
//                break;              
//         }
//         
//         return list;
//    }
//    
//    static EspecieVO findEspecieById(EspecieBO especieBO, Tabla objectVO, TypeOfQuery typeQuery)
//    {
//        EspecieVO especieVO = null;
//        
//         switch(typeQuery)
//         {
//            case BUSCAR_POR_ID:
//                
//                especieVO = especieBO.findById((EspecieVO)objectVO);
//                
//                break;              
//         }
//         
//         return especieVO;
//    }
}
