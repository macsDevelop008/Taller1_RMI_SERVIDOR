/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor.database.businessobject.especieBO;

import com.mycompany.servidor.database.db.AbstractFactoryDataBase.IDataBase;
import com.mycompany.servidor.database.valueobject.EspecieVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public interface IEspecieBO
{    
    public boolean insert(EspecieVO especieVO); //Objeto Completo
    public boolean update(EspecieVO especieVO); //Objeto Completo
    public boolean delete(EspecieVO especieVO); //Objeto solo Id
    public ArrayList<EspecieVO> list();
    public EspecieVO findById(EspecieVO especieVO); //Objeto solo Id
}
