/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.TipoConsumo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MiltonLQ
 */
public class DAOTipoConsumoImpl {

    private Conexion con;
    private Connection conec;

    public TipoConsumo listarTipoConsumo(String cedula, int valoringreso) throws Exception {
        List<TipoConsumo> lista = new ArrayList();
        TipoConsumo tipo = null;
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call consulta_tipo_consumo_porcedula(?)}");
            ps.setString(1, cedula);
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            while (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                tipo = new TipoConsumo();
                tipo.setTipo_consumo(res.getString("tipo_consumo"));
                tipo.setLimitem_cubico(res.getInt("limitem_cubico"));
                tipo.setValor(res.getDouble("valor"));
                tipo.setTarifa_basica(res.getDouble("tarifa_basica"));
                tipo.setTarifa_ambiente(res.getDouble("tarifa_ambiente"));
                tipo.setAlcantarillado(res.getDouble("alcantarillado"));
                lista.add(tipo);
            }
            res.close();
            int count = 0;
            int tamalista = lista.size();
            while (count < tamalista) {
                tipo = new TipoConsumo();
                if (tamalista == 1) {
                    tipo.setTipo_consumo(lista.get(0).getTipo_consumo());
                    tipo.setLimitem_cubico(lista.get(0).getLimitem_cubico());
                    tipo.setValor(lista.get(0).getValor());
                    tipo.setTarifa_basica(lista.get(0).getTarifa_basica());
                    tipo.setTarifa_ambiente(lista.get(0).getTarifa_ambiente());
                    tipo.setAlcantarillado(lista.get(0).getAlcantarillado());
                    break;
                } else if (tamalista > 1) {
                    int limite = lista.get(count).getLimitem_cubico();
                    if (valoringreso <= limite) {
                        tipo.setTipo_consumo(lista.get(count).getTipo_consumo());
                        tipo.setLimitem_cubico(lista.get(count).getLimitem_cubico());
                        tipo.setValor(lista.get(count).getValor());
                        tipo.setTarifa_basica(lista.get(count).getTarifa_basica());
                        tipo.setTarifa_ambiente(lista.get(count).getTarifa_ambiente());
                        tipo.setAlcantarillado(lista.get(count).getAlcantarillado());
                        break;
                    }
                    if (valoringreso > limite) {
                        if (count <= tamalista) {
                            int countd;
                            countd = 1 + count;
                            if (countd < tamalista) {
                                tipo.setTipo_consumo(lista.get(countd).getTipo_consumo());
                                tipo.setLimitem_cubico(lista.get(countd).getLimitem_cubico());
                                tipo.setValor(lista.get(countd).getValor());
                                tipo.setTarifa_basica(lista.get(countd).getTarifa_basica());
                                tipo.setTarifa_ambiente(lista.get(countd).getTarifa_ambiente());
                                tipo.setAlcantarillado(lista.get(countd).getAlcantarillado());
                            } else if (countd >= tamalista) {
                                tipo.setTipo_consumo(lista.get(count).getTipo_consumo());
                                tipo.setLimitem_cubico(lista.get(count).getLimitem_cubico());
                                tipo.setValor(lista.get(count).getValor());
                                tipo.setTarifa_basica(lista.get(count).getTarifa_basica());
                                tipo.setTarifa_ambiente(lista.get(count).getTarifa_ambiente());
                                tipo.setAlcantarillado(lista.get(count).getAlcantarillado());
                                break;
                            }

                        } else if (count >= tamalista) {
                            tipo.setTipo_consumo(lista.get(count).getTipo_consumo());
                            tipo.setLimitem_cubico(lista.get(count).getLimitem_cubico());
                            tipo.setValor(lista.get(count).getValor());
                            tipo.setTarifa_basica(lista.get(count).getTarifa_basica());
                            tipo.setTarifa_ambiente(lista.get(count).getTarifa_ambiente());
                            tipo.setAlcantarillado(lista.get(count).getAlcantarillado());
                        }
                    }
                    count++;

                } else if (tamalista < 1) {
                    tipo.setTipo_consumo("Defecto");
                    break;
                }

            }

        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tipo;
    }

}
