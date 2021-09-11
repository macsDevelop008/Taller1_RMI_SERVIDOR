
package com.mycompany.servidor.database.businessobject.especieBO;

import com.mycompany.servidor.database.db.AbstractFactoryDataBase.IDataBase;
import com.mycompany.servidor.database.db.AbstractFactoryDataBase.IDataBaseFactory;
import com.mycompany.servidor.database.valueobject.EspecieVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class EspecieBO implements IEspecieBO
{
    public final static String NOMBRE_TABLA_SQL = "especie";
    
    //Inyectar la DataBaseFactory objetivo de la base de datos.
    private IDataBaseFactory dataBase;
    
    private String user;
    private String password;
    private String nombreBD;

    public EspecieBO(IDataBaseFactory dataBase, String user, String password, String nombreBD) 
    {
        this.dataBase = dataBase;
        this.user = user;
        this.password = password;
        this.nombreBD = nombreBD;
    }

   
    @Override
    public boolean insert(EspecieVO especieVO) 
    {
        boolean result = false;

        String id = especieVO.getId();
        String nombre = especieVO.getNombre();
        double estadoRegistro = especieVO.getEstadoRegistro();
        Date fechaModificacion = especieVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "INSERT INTO " + NOMBRE_TABLA_SQL + " VALUES("+"'"+id+"'"+","+
                "'"+nombre+"'"+","+
                estadoRegistro+","+
                "TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY'))";
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
    }

    @Override
    public boolean update(EspecieVO especieVO) 
    {
        boolean result = false;
        
        String id = especieVO.getId();
        String nombre = especieVO.getNombre();
        double estadoRegistro = especieVO.getEstadoRegistro();
        Date fechaModificacion = especieVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "UPDATE " + NOMBRE_TABLA_SQL + " SET " + 
                        "nombre ="+"'"+nombre+"'"+","+ 
                        "estado_registro ="+ estadoRegistro +","+ 
                        "fecha_modificacion = TO_DATE("+"'"+strDateFormat+"'"+","+"'DD/MM/YYYY')"+ 
                        "WHERE id =" + "'"+id+"'";
        
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        return result;
    }

    @Override
    public boolean delete(EspecieVO especieVO) 
    {
        boolean result = false;
        
        String id = especieVO.getId();      
        
        String sql = "DELETE FROM "+ NOMBRE_TABLA_SQL +" WHERE id ="+ "'"+id+"'";
        System.out.println(sql);
        result = dataBase.ConectarBaseDatos(user, password, nombreBD).executeUpdateStatement(sql);
        
        return result;
    }

    @Override
    public ArrayList<EspecieVO> list() 
    {
        ArrayList<EspecieVO> result = new ArrayList<>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL;
        
        System.out.println(sql);
        result = descomposeResultSet(dataBase.ConectarBaseDatos(user, password, nombreBD).executeQueryStatement(sql));
        
        return result;
    }

    @Override
    public EspecieVO findById(EspecieVO especieVO) 
    {
        ArrayList<EspecieVO> result = new ArrayList<>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL + " WHERE id ="+"'"+especieVO.getId()+"'";
        
        System.out.println(sql);
        result = descomposeResultSet(dataBase.ConectarBaseDatos(user, password, nombreBD).executeQueryStatement(sql));
        
        return result.get(0);
    }
    
    
    
    private ArrayList<EspecieVO> descomposeResultSet(ResultSet resultSet)
    {
        ArrayList<EspecieVO> result = new ArrayList<>();
        
        String id;
        String nombre;
        String estadoRegistro;
        Date fechaModificacion;
        
        try 
        {
            while(resultSet.next())
            {
                //id = Integer.parseInt(resultSet.getString(1));
                id = resultSet.getString(1);
                nombre = resultSet.getString(2);
                estadoRegistro = resultSet.getString(3);
                fechaModificacion = resultSet.getDate(4);
                
                //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
                //Date date = dateFormat.parse(fechaModificacion);
                
                result.add(new EspecieVO(
                        id, 
                        nombre, 
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
}
