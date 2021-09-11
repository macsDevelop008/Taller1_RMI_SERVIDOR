/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database;

import com.mycompany.servidor.DataBase.db.AbstractFactoryDataBase.PostgreSQL.ConnectionPostgresFactory;
import com.mycompany.servidor.database.businessobject.especieBO.EspecieBO;
import com.mycompany.servidor.database.businessobject.jugadorBO.JugadorBO;
import com.mycompany.servidor.database.businessobject.personajeBO.PersonajeBO;
import com.mycompany.servidor.database.db.AbstractFactoryDataBase.IDataBaseFactory;
import com.mycompany.servidor.database.db.AbstractFactoryDataBase.Oracle.ConnectionOracleFactory;
import com.mycompany.servidor.database.valueobject.EspecieVO;
import com.mycompany.servidor.database.valueobject.JugadorVO;
import com.mycompany.servidor.database.valueobject.PersonajeVO;
import com.mycompany.servidor.database.valueobject.Tabla;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
enum DataBaseObjective
{
    ORACLE, POSTGRESQL
}
enum TypeOfQuery
{
    INSERTAR, ACTUALIZAR, ELIMINAR, LISTAR, BUSCAR_POR_ID
}
public class MainDataBase 
{
   
    //Consultas -> INSERTAS-ACTUALIZAR-ELIMINAR
    public static boolean simpleAccordingToTheDatabase(DataBaseObjective dataBase, DatabaseInformation databaseInformation,
                                                        Tabla objectVO, TypeOfQuery typeQuery)
    {
        boolean resultado = false;
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
                     
        //Tabla
        switch(objectVO.nameTable())
        {
            case "jugador":

                JugadorBO jugadorBO = new JugadorBO(dbObjective, 
                    databaseInformation.getUsuarioDB(), 
                    databaseInformation.getContraseñaDB(), 
                    databaseInformation.getNombreDB());

                resultado = tableJugadorSimple(jugadorBO, objectVO, typeQuery);

            break;

            case "personaje":

                PersonajeBO personajeBO = new PersonajeBO(dbObjective, 
                    databaseInformation.getUsuarioDB(), 
                    databaseInformation.getContraseñaDB(), 
                    databaseInformation.getNombreDB());

                resultado = tablePersonajeSimple(personajeBO, objectVO, typeQuery);

            break;

            case "especie":

                    EspecieBO especiejeBO = new EspecieBO(dbObjective, 
                    databaseInformation.getUsuarioDB(), 
                    databaseInformation.getContraseñaDB(), 
                    databaseInformation.getNombreDB());

                resultado = tableEspeciejeSimple(especiejeBO, objectVO, typeQuery);
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
    
    
    public static ArrayList<JugadorVO> listJugador(DataBaseObjective dataBase, DatabaseInformation databaseInformation)
    {
        
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
        
        JugadorBO jugadorBO = new JugadorBO(dbObjective, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        ArrayList<JugadorVO> list = new ArrayList<>();
        
        list = jugadorBO.list();
         
         return list;
    }
    
    public static JugadorVO findJugadorById(DataBaseObjective dataBase, DatabaseInformation databaseInformation, Tabla objectVO)
    {
        //ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
        
        JugadorBO jugadorBO = new JugadorBO(dbObjective, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        JugadorVO jugadorVo = null;
        
        jugadorVo = jugadorBO.findById((JugadorVO)objectVO);
         
        return jugadorVo;
    }
    
    //---------------------------------------------------------------------------------------------
    
    public static ArrayList<PersonajeVO> listPersonaje(DataBaseObjective dataBase, DatabaseInformation databaseInformation)
    {
        //ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
        
        PersonajeBO personajeBO = new PersonajeBO(dbObjective, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        ArrayList<PersonajeVO> list = new ArrayList<>();
        
        list = personajeBO.list();
         
        return list;
    }
    
    public static PersonajeVO findPersonajeById(DataBaseObjective dataBase, DatabaseInformation databaseInformation, Tabla objectVO)
    {
        //ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
        
        PersonajeBO personajeBO = new PersonajeBO(dbObjective, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        PersonajeVO personajeVO = null;
        
        personajeVO = personajeBO.findById((PersonajeVO)objectVO);
         
        return personajeVO;
    }
    
    public static ArrayList<PersonajeVO> listPersonajesSegunJugador(DataBaseObjective dataBase, DatabaseInformation databaseInformation, Tabla objectVO)
    {
        //ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
        
        PersonajeBO personajeBO = new PersonajeBO(dbObjective, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        ArrayList<PersonajeVO> list = new ArrayList<>();
        
        list = personajeBO.charactersAccordingToPlayer((PersonajeVO)objectVO);
        
        return list;
    }
    
    //---------------------------------------------------------------------------------------------
    
    public static ArrayList<EspecieVO> listEspecie(DataBaseObjective dataBase, DatabaseInformation databaseInformation)
    {
        //ConnectionOracleFactory dbOracle = new ConnectionOracleFactory();
        
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
        
        EspecieBO especieBO = new EspecieBO(dbObjective, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        ArrayList<EspecieVO> list = new ArrayList<>();
        
        list = especieBO.list();
         
         return list;
    }
    
    public static EspecieVO findEspecieById(DataBaseObjective dataBase, DatabaseInformation databaseInformation, Tabla objectVO)
    {
        
        IDataBaseFactory dbObjective = null;
        
        //Base de datos objetivo
        dbObjective = selectDBFactory(dataBase);
        
        EspecieBO especieBO = new EspecieBO(dbObjective, 
        databaseInformation.getUsuarioDB(), 
        databaseInformation.getContraseñaDB(), 
        databaseInformation.getNombreDB());
        
        EspecieVO especieVO = null;
        
        especieVO = especieBO.findById((EspecieVO)objectVO);
         
        return especieVO;
    }
    
    
    
    //----------------------------------------------------------------------------------------------
    
    //Selecciona de forma abstracta la base de datos objetivo
    static IDataBaseFactory selectDBFactory(DataBaseObjective dataBase)
    {
        IDataBaseFactory dbObjective = null;
        
        switch(dataBase)
        {            
            case ORACLE:
                
                    dbObjective = new ConnectionOracleFactory();         
                break;
                
                case POSTGRESQL:
                    
                    dbObjective = new ConnectionPostgresFactory();                    
                break;
        }
        
        return dbObjective;
    }
    
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
