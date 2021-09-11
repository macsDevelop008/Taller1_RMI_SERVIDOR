/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database;

import com.mycompany.servidor.DataBase.db.AbstractFactoryDataBase.PostgreSQL.ConnectionPostgresSQL;
import com.mycompany.servidor.database.businessobject.especieBO.EspecieBO;
import com.mycompany.servidor.database.businessobject.jugadorBO.JugadorBO;
import com.mycompany.servidor.database.businessobject.personajeBO.PersonajeBO;
import com.mycompany.servidor.database.db.AbstractFactoryDataBase.Oracle.ConnectionOracle;
import com.mycompany.servidor.database.db.AbstractFactoryDataBase.Oracle.ConnectionOracleFactory;
import com.mycompany.servidor.database.valueobject.EspecieVO;
import com.mycompany.servidor.database.valueobject.JugadorVO;
import com.mycompany.servidor.database.valueobject.PersonajeVO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author migue
 */
public class Test 
{
    public static void main(String[] args) 
    {
        new Test();
    }
    
    public Test()
    {
        
        //Lita de todos los personajes segun el jugador
        //ORACLE
//        System.out.println(MainDataBase.listPersonajesSegunJugador(DataBaseObjective.ORACLE ,new DatabaseInformation("miguel","123","xe"),
//                                                            new PersonajeVO("3",new Date())).size());
        //POSTGRESQL
//        System.out.println(MainDataBase.listPersonajesSegunJugador(DataBaseObjective.POSTGRESQL ,new DatabaseInformation("postgres", "123", "Taller_1"),
//                                                            new PersonajeVO("3",new Date())).size());
        
       //INSERTAR-ACTUALIZAR-ELIMINAR
        
       //ORACLE "miguel","123","xe"    
//       System.out.println(MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
//                                                                            new DatabaseInformation("miguel","123","xe"),
//                                                                            new EspecieVO("10","sfC-UENTA",1,new Date()),
//                                                                           TypeOfQuery.ELIMINAR));
        //POSTFRESQL "postgres", "123", "Taller_1"
//       System.out.println(MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
//                                                                            new DatabaseInformation("postgres", "123", "Taller_1"),
//                                                                            new EspecieVO("10","sfC-UENTA",1,new Date()),
//                                                                           TypeOfQuery.ELIMINAR)); 
        
                //LISTAR
//        System.out.println(MainDataBase.listPersonaje(DataBaseObjective.ORACLE, new DatabaseInformation("miguel","123","xe")).size());
//        
//        System.out.println(MainDataBase.listPersonaje(DataBaseObjective.POSTGRESQL, new DatabaseInformation("postgres", "123", "Taller_1")).size());
        
        
                //BUSCAR POR ID
        System.out.println(MainDataBase.findJugadorById(DataBaseObjective.ORACLE, new DatabaseInformation("miguel","123","xe"),
                                                            new JugadorVO("4")));
        System.out.println(MainDataBase.findJugadorById(DataBaseObjective.POSTGRESQL, new DatabaseInformation("postgres", "123", "Taller_1"),
                                                            new JugadorVO("4")));
        
    }
    
//    void TestInsertar()
//    {
//        ConnectionOracleFactory c = new ConnectionOracleFactory();
//        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe"); 
//        
//        Date da = new Date();
//        PersonajeVO vo = new PersonajeVO("11","Nombrebla",12,34,134,"2","3",1,da);
//        System.out.println(bo.insert(vo));
//    }
//    
//    void TestActualizar()
//    {
//        ConnectionOracleFactory c = new ConnectionOracleFactory();
//        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");  
//        Date da = new Date();
//        PersonajeVO vo = new PersonajeVO("11","Nombre111",98,114,314,"1","3",1,da);  
//        System.out.println(bo.update(vo));
//    }
//        
//    void TestEliminar()
//    {
//        ConnectionOracleFactory c = new ConnectionOracleFactory();
//        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");
//        PersonajeVO vo = new PersonajeVO("11");
//        System.out.println(bo.delete(vo));
//    }
//    
//    void TestListar()
//    {
//        ConnectionOracleFactory c = new ConnectionOracleFactory();
//        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");
//        ArrayList<PersonajeVO> l =  new ArrayList<>();
//        l = bo.list();
//        
//        for (PersonajeVO e : l)
//        {
//            System.out.println(e.toString());
//        }
//        
//    }
//    
//    void TestBuscarPorId()
//    {
//        ConnectionOracleFactory c = new ConnectionOracleFactory();
//        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");
//        
//        System.out.println(bo.findById(new PersonajeVO("5")));
//    }
}
