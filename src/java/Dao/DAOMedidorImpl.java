/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Modelo.Medidor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MiltonLQ
 */
public class DAOMedidorImpl{
    //
    private Conexion con;
    private Connection conec;
    
    //realizamos las operaciones
     
    public void registrar(Medidor medi) throws SQLException {
        
    }
    
    public void modificar(Medidor comuni) throws SQLException {
    }
    
    public void eliminar(Medidor comuni) throws SQLException {
        
    }
    
    public List listar(String dato) throws Exception {
        List<Medidor> lista=new ArrayList();
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call listar_medidor_comunero(?)}");
            ps.setString(1, dato);
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            while (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                Medidor medidor=new Medidor();
                medidor.setPk_medidor(res.getInt("pk_medidor"));
                medidor.setNumero_medidor(res.getString("numero_medidor"));
                lista.add(medidor);
            }
            res.close();
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
}
