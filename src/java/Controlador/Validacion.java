/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Dao.DAOLoginImpl;
import Modelo.Login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Validacion extends HttpServlet {

    /*creamos un objeto de daologinimpl para enviar los parametros para la conexion mediante la clase*/
    DAOLoginImpl daologinimpl;
    Login log;

    //para obtener los datos del xml y pasar al servidor
    @Override
    public void init() throws ServletException {
        //Variable para recivir los datos del xml camino, username, password
        String URL = getServletContext().getInitParameter("URL");
        String USERNAME = getServletContext().getInitParameter("USERNAME");
        String PASSWORD = getServletContext().getInitParameter("PASSWORD");
        System.out.println(URL);
        System.out.println("se conecto por este camino al db del proyecto");
        try {
            daologinimpl = new DAOLoginImpl(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  HttpSession session = request.getSession();
        String sesion = String.valueOf(session.getAttribute("user"));
        if (!sesion.equals("null")) {
            request.getRequestDispatcher("menu.jsp").forward(request, response);
            JOptionPane.showMessageDialog(null, sesion.length()+sesion);
        } else if (sesion.equals("null")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("login");
        if (accion.equalsIgnoreCase("valor")) {
            String user = request.getParameter("user_name");
            String pass = request.getParameter("password");
            try {
                log = new Login();
                log = daologinimpl.listar(user, pass);
                if (!log.getUsuario().equals("null")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", log.getUsuario());
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                } else if(log.getUsuario().equals("null")){
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
