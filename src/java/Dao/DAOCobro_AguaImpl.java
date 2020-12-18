package Dao;

import Modelo.Cobro_Agua;
import Modelo.Consumo;
import Modelo.Multas;
import Modelo.TipoConsumo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DAOCobro_AguaImpl {

    private Conexion con;
    private Connection conec;

    /*metodo para listar los datos del consumo sin pagar por el numero de medidor*/
    public Cobro_Agua listarConsumoMedidorImpaga(String cedula, int fkconsumo) throws Exception {
        Cobro_Agua cobro_Agua = null;
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call buscar_datos_consumo_impaga(?,?)}");
            ps.setString(1, cedula);
            ps.setInt(2, fkconsumo);
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            while (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                cobro_Agua = new Cobro_Agua();
                Consumo consumo = new Consumo();
                Multas multa = new Multas();
                TipoConsumo tipoConsumo = new TipoConsumo();
                
                //Asignamos los valores obtenidos de la base de datos a sus respectivas entidades(clases) y atributos
                consumo.setConsumo_mcubico(res.getInt("consumo_mcubico"));
                tipoConsumo.setTipo_consumo(res.getString("tipo_consumo"));
                consumo.setFecha_lectura(res.getString("fecha_lectura"));
                consumo.setFecha_limite_pago(res.getString("fecha_limite_pago"));
                consumo.setTotal_pagar(res.getDouble("subtotal"));
                multa.setTipo_multa(res.getString("tipo_multa"));
                cobro_Agua.setDias_retraso(res.getString("diasretraso"));
                multa.setValor(res.getDouble("valor_multa"));
                tipoConsumo.setTarifa_ambiente(res.getDouble("tarifa_ambiente"));
                tipoConsumo.setAlcantarillado(res.getDouble("alcantarillado"));
                
                //asignamos los objetos con sus atributos ya definidos a la clase principal que maneja todo
                consumo.setTipoconsumo(tipoConsumo);
                cobro_Agua.setConsumo(consumo);
                cobro_Agua.setMultas(multa);               
            }

            res.close();
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
        return cobro_Agua;
    }
    
    public void registrar(int diasretraso, String fecha_limite,String cedula,Double valor_mul, Double total_pag, int fk_consumo) throws Exception {

        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call guardar_pago(?,?,?,?,?,?)}");
            ps.setInt(1, diasretraso);
            ps.setString(2, fecha_limite);
            ps.setString(3, cedula);
            ps.setDouble(4, valor_mul);
            ps.setDouble(5, total_pag);
            ps.setInt(6, fk_consumo);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }

    }
    

}
