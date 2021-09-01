/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database;

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
        //INSERTAR-ACTUALIZAR-ELIMINAR
//        System.out.println(Maindatabase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
//                                                                            new DatabaseInformation("miguel","123","xe"),
//                                                                            new JugadorVO("12","sfCUENTA","123SDF","@ASD@","@123",1,new Date()),
//                                                                            TypeOfQuery.ELIMINAR));
        
//        System.out.println(Maindatabase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
//                                                                            new DatabaseInformation("miguel","123","xe"),
//                                                                            new PersonajeVO("12","sfCUENTA",1,2,3,"2","1",1,new Date()),
//                                                                            TypeOfQuery.INSERTAR));
        
//        System.out.println(Maindatabase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
//                                                                            new DatabaseInformation("miguel","123","xe"),
//                                                                            new EspecieVO("10","sfCUENTA",1,new Date()),
//                                                                            TypeOfQuery.INSERTAR));
        
        //LISTAR
//        System.out.println(Maindatabase.listEspecie(new DatabaseInformation("miguel","123","xe")).size());
        
        //BUSCAR POR ID
//        System.out.println(MainDataBase.findEspecieById(new DatabaseInformation("miguel","123","xe"),
//                                                            new EspecieVO("4")));
        
        //Lita de todos los personajes segun el jugador
         System.out.println(MainDataBase.listPersonajesSegunJugador(new DatabaseInformation("miguel","123","xe"),
                                                            new PersonajeVO("3",new Date())).size());
        
    }
    
    void TestInsertar()
    {
        ConnectionOracleFactory c = new ConnectionOracleFactory();
        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe"); 
        
        Date da = new Date();
        PersonajeVO vo = new PersonajeVO("11","Nombrebla",12,34,134,"2","3",1,da);
        System.out.println(bo.insert(vo));
    }
    
    void TestActualizar()
    {
        ConnectionOracleFactory c = new ConnectionOracleFactory();
        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");  
        Date da = new Date();
        PersonajeVO vo = new PersonajeVO("11","Nombre111",98,114,314,"1","3",1,da);  
        System.out.println(bo.update(vo));
    }
        
    void TestEliminar()
    {
        ConnectionOracleFactory c = new ConnectionOracleFactory();
        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");
        PersonajeVO vo = new PersonajeVO("11");
        System.out.println(bo.delete(vo));
    }
    
    void TestListar()
    {
        ConnectionOracleFactory c = new ConnectionOracleFactory();
        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");
        ArrayList<PersonajeVO> l =  new ArrayList<>();
        l = bo.list();
        
        for (PersonajeVO e : l)
        {
            System.out.println(e.toString());
        }
        
    }
    
    void TestBuscarPorId()
    {
        ConnectionOracleFactory c = new ConnectionOracleFactory();
        PersonajeBO bo = new PersonajeBO(c, "miguel", "123", "xe");
        
        System.out.println(bo.findById(new PersonajeVO("5")));
    }
}
