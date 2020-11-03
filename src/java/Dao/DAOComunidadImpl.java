
package Dao;

import Modelo.Comuna;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOComunidadImpl {
    private Conexion con;
    private Connection conec;
    
    public void registrar(Comuna comuni) throws SQLException {
        
    }
    
    public void modificar(Comuna comuni) throws SQLException {
//         try {
//            conec = con.getConectionn();
//            //ya echa la conecion hacemos una consulta
//            //declaramos variables que necesitamos para hacer transacciones entre mysql
//            CallableStatement ps; //para usar esra se agrego la libreria
//               //tambien agregamos libreria
//            //aqui mandamos la consulta sql
//            ps = conec.prepareCall("{call actualizar_comunero(?,?,?,?,?,?,?,?,?,?,?,?)}");
//            ps.setInt(1,login.getPk_comunero());
//            ps.setString(2, login.getCedula());
//            ps.setString(3, login.getPrimer_nombre());
//            ps.setString(4, login.getSegundo_nombre());
//            ps.setString(5, login.getPrimer_apellido());
//            ps.setString(5, login.getSegundo_apellido());
//            ps.setString(7, login.getTelefono());
//            ps.setDate(8, (Date) login.getFecha_nacimiento());
//            ps.setInt(9,login.getEdad());
//            ps.setInt(10,login.getFk_comuna());
//            ps.setString(11, login.getDireccion_vivienda());
//            ps.setString(12, login.getReferencia_geografica());
//            ps.execute();
//            JOptionPane.showMessageDialog(null, "Acutalizacion excitosa");
//        } catch (Exception e) {
//            //solo un mensaje en consola
//            JOptionPane.showMessageDialog(null, e);
//        }
    }
    
    public void eliminar(Comuna comuni) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List listar() throws Exception {
        List<Comuna> lista=new ArrayList();
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call listar_comuna}");
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            while (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                Comuna comunidad=new Comuna();
                comunidad.setPk_comuna(res.getInt("pk_comuna"));
                comunidad.setNombre_comuna(res.getString("nombre_comuna"));
                comunidad.setDireccion_comuna(res.getString("direccion_comuna"));
                comunidad.setFk_parroquia(res.getString("fk_parroquia"));
                lista.add(comunidad);
            }
            res.close();
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
}
