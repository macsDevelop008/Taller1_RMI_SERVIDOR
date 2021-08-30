/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba.database;

import com.mycompany.prueba.database.businessobject.personajeBO.PersonajeBO;
import com.mycompany.prueba.database.db.AbstractFactoryDataBase.Oracle.ConnectionOracleFactory;
import com.mycompany.prueba.valueobject.EspecieVO;
import com.mycompany.prueba.valueobject.JugadorVO;
import com.mycompany.prueba.valueobject.PersonajeVO;

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
     System.out.println(MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                                                                           new DatabaseInformation("alex","prueba","xe"),
                                                                            new JugadorVO("12"),
                                                                            TypeOfQuery.ELIMINAR));

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
        /*System.out.println(MainDataBase.findEspecieById(new DatabaseInformation("alex","prueba","xe"),
                                                            new EspecieVO("4")));*/
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
