
package Dao;

/*librerias usadas para realizar la conexion*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    /*Constantes necesarias para la conexion*/
    private String URL;
    private String USERNAME;
    private String PASSWORD;
    
    /*esta es una variable de tipo conexion*/
    protected static Connection con;/*Esta variable obtiene y guarda la conexion*/
    /*Constructor para resivir valores necesarios para la conexion desde el servlet*/
    public Conexion(String url, String username, String pasword){
        this.URL=url;
        this.USERNAME=username;
        this.PASSWORD=pasword;
    }
    /*metodo de tipo conexion public para hacer la conexion*/
    public Connection getConexion(){
        try {
            /*Aqui agregamos la ruta del driver*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conexion Exitosa perro jajja");
            /*Igualamos la variable a la conexion*/
            con=DriverManager.getConnection(URL, USERNAME, PASSWORD);/*con esto ya esta echa la conexion*/
        } catch (SQLException e) {/*en caso de que suceda un error en la conexion*/
            System.err.println(e);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    //Este metodo desconecta la conexion de la BD
    public Connection disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
        return con;
    }
    
    public static  Connection getConectionn() {
        return con;
    }
}
