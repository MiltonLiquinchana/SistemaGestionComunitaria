/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MiltonLQ
 */
public class Medidor {

    //Estructura de la tabla
    private int pk_medidor;
    private String fecha_conexion;
    private String numero_medidor;
    private int fk_comunero;
    
    /*constructores*/
    //vacio
    public Medidor() {
    }
    
    //con parametros
    public Medidor(int pk_medidor, String fecha_conexion, String numero_medidor, int fk_comunero) {
        this.pk_medidor = pk_medidor;
        this.fecha_conexion = fecha_conexion;
        this.numero_medidor = numero_medidor;
        this.fk_comunero = fk_comunero;
    }
    
    /*getter y setters*/

    public int getPk_medidor() {
        return pk_medidor;
    }

    public void setPk_medidor(int pk_medidor) {
        this.pk_medidor = pk_medidor;
    }

    public String getFecha_conexion() {
        return fecha_conexion;
    }

    public void setFecha_conexion(String fecha_conexion) {
        this.fecha_conexion = fecha_conexion;
    }

    public String getNumero_medidor() {
        return numero_medidor;
    }

    public void setNumero_medidor(String numero_medidor) {
        this.numero_medidor = numero_medidor;
    }

    public int getFk_comunero() {
        return fk_comunero;
    }

    public void setFk_comunero(int fk_comunero) {
        this.fk_comunero = fk_comunero;
    }
    

    
}
