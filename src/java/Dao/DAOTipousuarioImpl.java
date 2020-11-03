
package Dao;

import Modelo.Tipousuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOTipousuarioImpl {
    private Conexion con;
    private Connection conec;
    
    public List listar() throws Exception {
        List<Tipousuario> lista=new ArrayList();
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call listar_tipousuario}");
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            while (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                Tipousuario tipousuario=new Tipousuario();
                tipousuario.setPk_tipousuario(res.getInt("pk_tipousuario"));
                tipousuario.setTipo_usuario(res.getString("tipo_usuario"));
                lista.add(tipousuario);
            }
            res.close();
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
}
