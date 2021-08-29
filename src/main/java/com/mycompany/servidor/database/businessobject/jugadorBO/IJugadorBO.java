/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database.businessobject.jugadorBO;

import com.mycompany.servidor.database.valueobject.JugadorVO;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public interface IJugadorBO 
{
    public boolean insert(JugadorVO jugadorVO); //Objeto Completo
    public boolean update(JugadorVO jugadorVO); //Objeto Completo
    public boolean delete(JugadorVO jugadorVO); //Objeto solo Id
    public ArrayList<JugadorVO> list();
    public JugadorVO findById(JugadorVO jugadorVO); //Objeto solo Id
}
