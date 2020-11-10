/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Consumo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author MiltonLQ
 */
public class DAOConsumoImpl {

    private Conexion con;
    private Connection conec;

    /*metodo para listar los datos del comunero por el numero de cedula*/
    public Consumo listarConsumoMedidor(String num_medidor) throws Exception {
        Consumo consumo = null;
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call datos_lectura_medidor(?)}");
            ps.setString(1, num_medidor);
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            if (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                consumo = new Consumo();
                consumo.setLectura_anterior(res.getString("lectura_actual"));
            }

            res.close();
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
        return consumo;
    }

    public void registrar(Consumo consumo, String num_medidor,String tipoconsumo) throws Exception {

        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call guardarconsumo(?,?,?,?,?,?,?,?)}");
            ps.setString(1, consumo.getLectura_anterior());
            ps.setString(2, consumo.getLectura_actual());
            ps.setString(3, consumo.getFecha_lectura());
            ps.setString(4, consumo.getFecha_limite_pago());
            ps.setInt(5, consumo.getConsumo_mcubico());
            ps.setDouble(6, consumo.getTotal_pagar());
            ps.setString(7, num_medidor);
            ps.setString(8, tipoconsumo);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
