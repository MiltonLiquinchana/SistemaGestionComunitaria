package Dao;

import Modelo.Comunero;
import Modelo.Login;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DAOLoginImpl {/*con esto podemos usar la conexion sin crear objetos*/
    private Conexion con;
    private Connection conec;

    public DAOLoginImpl() {

    }

    /*con este contructor podemos recivir los parametros necesarios para la conexion desde el xml del servlet*/
    public DAOLoginImpl(String url, String username, String pasword) throws SQLException {
        con = new Conexion(url, username, pasword);
        //imprimir todo lo de la conexion
        con.disconnect();
        con.getConexion();
        System.out.println(con.getConectionn());
    }

    public void registrar(Login login, Comunero comunero) throws Exception {
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call guardar_usuario(?,?,?,?)}");
            ps.setString(1, login.getUsuario());
            ps.setString(2, login.getContrasenia());
            ps.setInt(3, login.getFk_tipousuario());
            ps.setString(4, comunero.getCedula());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se guardo exitosamente los datos de login");
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void modificar(Login login) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Login login) throws Exception {
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call eliminar_login(?)}");
            ps.setInt(1, login.getFk_comunero());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se elimino login exitosamente");
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Login listar(String username, String password) throws Exception {
        Login login = new Login();
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            PreparedStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareStatement("Select * From login where usuario=? and contraseña=?");
            ps.setString(1, username);
            ps.setString(2, password);
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            while (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                login.setPk_login(res.getInt("pk_login"));
                login.setUsuario(res.getString("usuario"));
                login.setContrasenia(res.getString("contraseña"));
                login.setFk_tipousuario(res.getInt("fk_tipousuario"));
                login.setFk_comunero(res.getInt("fk_comunero"));
            }

        } catch (Exception e) {
            //solo un mensaje en consola
            throw e;
        }
        return login;
    }

    public Login listarID(Login login) throws Exception {
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call listar_usuarioID(?)}");
            ps.setInt(1, login.getFk_comunero());
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            while (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
                login.setPk_login(res.getInt("pk_login"));
                login.setUsuario(res.getString("usuario"));
                login.setContrasenia(res.getString("contraseña"));
                login.setFk_tipousuario(res.getInt("fk_tipousuario"));
                login.setFk_comunero(res.getInt("fk_comunero"));
            }
            res.close();
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
        return login;
    }
    
    /*metodo para consultar la fecha limite a colocar en el campo fecha limite del formulario registro de consumos*/
    public String FechaLimite(String fk_comunero) throws Exception {
        String fechalimite = "";
        try {
            conec = con.getConectionn();
            //ya echa la conecion hacemos una consulta
            //declaramos variables que necesitamos para hacer transacciones entre mysql
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            //aqui mandamos la consulta sql
            ps = conec.prepareCall("{call consultaFechaLimitePago(?)}");
            ps.setString(1, fk_comunero);
            res = ps.executeQuery();
            //con esto ejecutamos la consulta
            //con un if evaluamos si la consulta tiene resultados
            //con if solo estamos dando por echo que la consulta va a devolver una sola linea
            if (res.next()) { // si esto sale verdadero significa que esta consulta tiene resultados
                //con sun joptionpanel imprimimos los resultados
                //aqui definimos el tipo de dato que vamos a traer de la bd y dentro la etiqueta de la columna
               fechalimite=res.getString("fechaLimite");

            }
            res.close();
        } catch (Exception e) {
            //solo un mensaje en consola
            JOptionPane.showMessageDialog(null, e);
        }
        return fechalimite;
    }
    
    
    
    
}
