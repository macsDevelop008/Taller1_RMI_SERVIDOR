/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba;

import com.mycompany.prueba.valueobject.EspecieVO;
import com.mycompany.prueba.valueobject.PersonajeVO;

import java.util.Date;

/**
 *
 * @author migue
 */
public class Test 
{
    public static DatabaseInformation pos = new DatabaseInformation("usqflxaqeyzjlg", "23350f39fffcc74b5f869b2c2049a5b9424dff80e35fbddc40946985664ed014", "d7n31ha057s6gf");
    public static void main(String[] args) 
    {
        new Test();
    }
    
    public Test()
    {
        
        //Lita de todos los personajes segun el jugador
        //ORACLE
     System.out.println(MainDataBase.listPersonajesSegunJugador(DataBaseObjective.ORACLE ,new DatabaseInformation("alex","prueba","xe"),
                                                           new PersonajeVO("3",new Date())).size());
        //POSTGRESQL
        System.out.println(MainDataBase.listPersonajesSegunJugador(DataBaseObjective.POSTGRESQL ,pos,
                                                            new PersonajeVO("3",new Date())).size());
        
       //INSERTAR-ACTUALIZAR-ELIMINAR
        
       //ORACLE "miguel","123","xe"    
 /*     System.out.println(MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                                                                          new DatabaseInformation("alex","prueba","xe"),
                                                                            new EspecieVO("10","sfC-UENTA",1,new Date()),
                                                                           TypeOfQuery.ELIMINAR));*/

    System.out.println(MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                                                                            pos,
                                                                            new EspecieVO("10","sfC-UENTA",1,new Date()),
                                                                           TypeOfQuery.ELIMINAR));
        
                //LISTAR
        System.out.println(MainDataBase.listPersonaje(DataBaseObjective.ORACLE, new DatabaseInformation("alex","prueba","xe")).size());
//        
        System.out.println(MainDataBase.listPersonaje(DataBaseObjective.POSTGRESQL, pos));
        
        
                //BUSCAR POR ID
  //      System.out.println(MainDataBase.findJugadorById(DataBaseObjective.ORACLE, new DatabaseInformation("alex","prueba","xe"),
      //                                                      new JugadorVO("4")));
   //     System.out.println(MainDataBase.findJugadorById(DataBaseObjective.POSTGRESQL, new DatabaseInformation("usqflxaqeyzjlg", "23350f39fffcc74b5f869b2c2049a5b9424dff80e35fbddc40946985664ed014", "d7n31ha057s6gf"),
       //                                                     new JugadorVO("4")));
        
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
