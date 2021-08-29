/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database.businessobject.personajeBO;

import com.mycompany.servidor.database.valueobject.PersonajeVO;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public interface IPersonajeBO 
{
    public boolean insert(PersonajeVO personajeVO); //Objeto Completo
    public boolean update(PersonajeVO personajeVO); //Objeto Completo
    public boolean delete(PersonajeVO personajeVO); //Objeto solo Id
    public ArrayList<PersonajeVO> list();
    public PersonajeVO findById(PersonajeVO personajeVO); //Objeto solo Id
}
