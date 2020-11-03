/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DAOComuneroImpl;
import Dao.DAOComunidadImpl;
import Dao.DAOConsumoImpl;
import Dao.DAOLoginImpl;
import Dao.DAOMedidorImpl;
import Dao.DAOTipoConsumoImpl;
import Dao.DAOTipousuarioImpl;
import Modelo.Comunero;
import Modelo.Consumo;
import Modelo.Login;
import Modelo.Medidor;
import Modelo.TipoConsumo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Controles extends HttpServlet {

    DAOComuneroImpl daocomuneroimpl;
    DAOComunidadImpl daocomunidadimpl;
    DAOTipousuarioImpl daotipousuarioimpl;
    DAOLoginImpl daologinimpl;
    DAOMedidorImpl dAOMedidorImpl;
    DAOConsumoImpl daoConsumoImpl;
    DAOTipoConsumoImpl daoTipoConsumoImpl;
    /*instanciamos las clases para setear los datos y desde los dao con el objeto obtener los datos requeridos*/
    Comunero comune;
    Login logi;
    Consumo consum;
    TipoConsumo tipoConsumo;
    Medidor medidor;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*zona de captura de datos y acciones de formularios*/
        String menu = request.getParameter("menu");

        /*Acciones del menu*/
        if (menu.equals("Socios")) {
            String accion = request.getParameter("accion");
            String id = request.getParameter("id");
            switch (accion) {
                case "listar":
                       try {
                    List lista = null;
                    daocomuneroimpl = new DAOComuneroImpl();
                    lista = daocomuneroimpl.listar();
                    request.setAttribute("comunero", lista);
                } catch (Exception ex) {
                    Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("busquedaSocios.jsp").forward(request, response);
                break;
                case "editar":
                    /**
                     * ***********************************************************
                     */
                    comune = new Comunero();
                    logi = new Login();
                    comune.setPk_comunero(Integer.parseInt(id));
                    logi.setFk_comunero(Integer.parseInt(id));
                    try {
                        List lista = null;
                        List listar = null;
                        daocomunidadimpl = new DAOComunidadImpl();
                        daotipousuarioimpl = new DAOTipousuarioImpl();
                        lista = daocomunidadimpl.listar();
                        listar = daotipousuarioimpl.listar();
                        request.setAttribute("lista", lista);
                        request.setAttribute("listar", listar);
                        daocomuneroimpl = new DAOComuneroImpl();
                        daologinimpl = new DAOLoginImpl();
                        Comunero comuner = daocomuneroimpl.listarID(comune);
                        Login logn = daologinimpl.listarID(logi);
                        request.setAttribute("logins", logn);
                        request.setAttribute("comunero", comuner);
                    } catch (Exception ex) {
                        Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
                    /**
                     * ***********************************************************
                     */
                    break;
                case "eliminar":
                    comune = new Comunero();
                    comune.setPk_comunero(Integer.parseInt(id));
                    logi = new Login();
                    logi.setFk_comunero(Integer.parseInt(id));
                    try {
                        daocomuneroimpl = new DAOComuneroImpl();
                        daologinimpl = new DAOLoginImpl();
                        daologinimpl.eliminar(logi);
                        daocomuneroimpl.eliminar(comune);
                        List lista = null;
                        daocomuneroimpl = new DAOComuneroImpl();
                        lista = daocomuneroimpl.listar();
                        request.setAttribute("comunero", lista);
                    } catch (Exception ex) {
                        Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.getRequestDispatcher("busquedaSocios.jsp").forward(request, response);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "default");
                    break;
            }

        }
        if (menu.equals("RAnual")) {
            request.getRequestDispatcher("reporteAnualConsumos.jsp").forward(request, response);
        }
        if (menu.equals("RMensual")) {
            request.getRequestDispatcher("reporteAguaMensual.jsp").forward(request, response);
        }
        if (menu.equals("RSocios")) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "mostrar":
                    try {
                    List lista = null;
                    List listar = null;
                    daocomunidadimpl = new DAOComunidadImpl();
                    daotipousuarioimpl = new DAOTipousuarioImpl();
                    lista = daocomunidadimpl.listar();
                    listar = daotipousuarioimpl.listar();
                    request.setAttribute("lista", lista);
                    request.setAttribute("listar", listar);
                } catch (Exception ex) {
                    Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
                break;
                case "guardar":
                    /*zona de captura de datos del formulario*/
                    String cedula = request.getParameter("cedula");
                    String primer_nombre = request.getParameter("pnombre");
                    String segundo_nombre = request.getParameter("snombre");
                    String primer_apellido = request.getParameter("papellido");
                    String segundo_apellido = request.getParameter("sapellido");
                    String telefono = request.getParameter("telefono");
                    String direccion_vivienda = request.getParameter("direccion");
                    int fk_comuna = Integer.parseInt(request.getParameter("listacomunaRsocios"));
                    String referencia_geografica = request.getParameter("referenciaG");
                    /*convertimos el string a date*/
                    String fecha_nacimientosc = request.getParameter("fechan");
                    int edad = Integer.parseInt(request.getParameter("edad"));
                    String nombreusuario = request.getParameter("nombreus");
                    int fk_tipousuario = Integer.parseInt(request.getParameter("listatipoRsocios"));
                    String contrasenia = request.getParameter("contraseniaus");
                    String repcontraseña = request.getParameter("rcontraseniaus");

                    comune = new Comunero(1, cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, fecha_nacimientosc, edad, fk_comuna, direccion_vivienda, referencia_geografica);
                    logi = new Login(1, nombreusuario, contrasenia, fk_tipousuario, 1);
                    try {
                        daocomuneroimpl = new DAOComuneroImpl();
                        daologinimpl = new DAOLoginImpl();
                        daocomuneroimpl.registrar(comune);
                        daologinimpl.registrar(logi, comune);
                    } catch (Exception ex) {
                        Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
                    break;
            }
        }
        if (menu.equals("RConsumos")) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "mostrar":
                    request.getRequestDispatcher("registroConsumo.jsp").forward(request, response);
                    break;
                case "buscar":
                    //ceamos un objeto de tipo lista vacio     
                    String dato = request.getParameter("dato");
                    try {
                        List lista = null;
                        //creamos una nueva instancia de la clase daoMedidorImpl
                        dAOMedidorImpl = new DAOMedidorImpl();
                        //enviamos el dato por el cual se va a realizar la consulta y almacenamos los devuelto en la lista
                        lista = dAOMedidorImpl.listar(dato);

                        //creamos un objeto 
                        request.setAttribute("lista", lista);
                        comune = new Comunero();
                        daocomuneroimpl = new DAOComuneroImpl();
                        comune = daocomuneroimpl.listarCCedula(dato);
                        request.setAttribute("comunero", comune);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    request.getRequestDispatcher("registroConsumo.jsp").forward(request, response);
                    break;
                case "select_medidor":
                    try {
                    List lista = null;
                    lista = dAOMedidorImpl.listar(comune.getCedula());
                    request.setAttribute("lista", lista);
                    request.setAttribute("comunero", comune);
                    consum = new Consumo();
                    daoConsumoImpl = new DAOConsumoImpl();
                    String num_medidor = request.getParameter("num_medidor");
                    consum = daoConsumoImpl.listarConsumoMedidor(num_medidor);

                    if (consum.getLectura_anterior() == null) {
                        consum.setLectura_anterior("0");
                        request.setAttribute("consumo", consum);
                    } else {
                        request.setAttribute("consumo", consum);
                    }

                    request.setAttribute("valuemedi", num_medidor);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                request.getRequestDispatcher("registroConsumo.jsp").forward(request, response);
                break;

                case "buscarTipoConsumo":
                    try {
                    List lista = null;
                    lista = dAOMedidorImpl.listar(comune.getCedula());
                    request.setAttribute("lista", lista);
                    request.setAttribute("comunero", comune);
                    request.setAttribute("consumo", consum);
                    String num_medidor = request.getParameter("num_medidor");
                    request.setAttribute("valuemedi", num_medidor);

                    String valorLecturaActual = request.getParameter("lecturaActual");
                    request.setAttribute("valuelectura", valorLecturaActual);

                    String valorconsumido = request.getParameter("valorConsumido");
                    request.setAttribute("valorconsumido", valorconsumido);
                    daoTipoConsumoImpl = new DAOTipoConsumoImpl();
                    tipoConsumo = new TipoConsumo();
                    tipoConsumo = daoTipoConsumoImpl.listarTipoConsumo(comune.getCedula(), Integer.parseInt(valorconsumido));
                    daologinimpl = new DAOLoginImpl();
                    String fechalimitecancelacion = daologinimpl.FechaLimite(String.valueOf(comune.getPk_comunero()));
                    request.setAttribute("fechalimitepago", fechalimitecancelacion);

                    double totalpagar = 0.0;
                    if (Integer.parseInt(valorconsumido) <= tipoConsumo.getLimitem_cubico() && tipoConsumo.getTarifa_basica() > 0) {
                        totalpagar = tipoConsumo.getTarifa_basica();

                    }
                    if (Integer.parseInt(valorconsumido) > tipoConsumo.getLimitem_cubico() && tipoConsumo.getTarifa_basica() > 1) {
                        totalpagar = Double.parseDouble(valorconsumido) * tipoConsumo.getValor();
                    }
                    if (Integer.parseInt(valorconsumido) <= tipoConsumo.getLimitem_cubico() && tipoConsumo.getTarifa_basica() < 1) {
                        totalpagar = Double.parseDouble(valorconsumido) * tipoConsumo.getValor();
                    }
                    if (Integer.parseInt(valorconsumido) > tipoConsumo.getLimitem_cubico() && tipoConsumo.getTarifa_basica() < 1) {
                        totalpagar = Double.parseDouble(valorconsumido) * tipoConsumo.getValor();
                    }
                    request.setAttribute("total", totalpagar);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                request.getRequestDispatcher("registroConsumo.jsp").forward(request, response);
                break;
                case "guardar":
                    try {
                    String nummedidor, lectura_anterior, lectura_actual, fecha_lectura, fecha_limite_pago;/*Hasta que fecha tiene que pagar sin cargo extra*/
                    int consumo_mcubico, fk_medidor;
                    double total_pagar;
                    nummedidor = request.getParameter("nummedidor");
                    lectura_anterior = request.getParameter("lecturaAnterior");
                    lectura_actual = request.getParameter("lecturaActual");
                    fecha_lectura = request.getParameter("fechalectura");
                    fecha_limite_pago = request.getParameter("fechalimite");
                    consumo_mcubico = Integer.parseInt(request.getParameter("totalconsumo"));
                    total_pagar = Double.parseDouble(request.getParameter("totalpagar"));
                    daoConsumoImpl = new DAOConsumoImpl();
                    consum = new Consumo(1, lectura_anterior, lectura_actual, fecha_lectura, fecha_limite_pago, consumo_mcubico, total_pagar, 1);
                    daoConsumoImpl.registrar(consum, nummedidor);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                request.getRequestDispatcher("registroConsumo.jsp").forward(request, response);
                break;

            }

        }
        if (menu.equals("RActividades")) {
            request.getRequestDispatcher("registroParticipacion.jsp").forward(request, response);
        }
        if (menu.equals("PAgua")) {
            request.getRequestDispatcher("cobroAgua.jsp").forward(request, response);
        }
        if (menu.equals("PCuotas")) {
            request.getRequestDispatcher("cobroCuotas.jsp").forward(request, response);
        }
        if (menu.equals("PMultas")) {
            request.getRequestDispatcher("cobroParticipacion.jsp").forward(request, response);
        }
        if (menu.equals("RComunidad")) {
            request.getRequestDispatcher("registro_comunidad.jsp").forward(request, response);
        }
        if (menu.equals("CDescuentos")) {
            request.getRequestDispatcher("tipo_descuento.jsp").forward(request, response);
        }
        if (menu.equals("Something")) {
            request.getRequestDispatcher("Socios.jsp").forward(request, response);
        }
        if (menu.equals("Contactos")) {
            request.getRequestDispatcher("Socios.jsp").forward(request, response);
        }
        if (menu.equals("LogOut")) {
            request.getRequestDispatcher("Socios.jsp").forward(request, response);
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

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
