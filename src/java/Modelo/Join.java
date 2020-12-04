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
public class Join {
    private double TotalMulta;
    private double TotalPagar;

    public Join() {
    }

    public Join(double TotalMulta, double TotalPagar) {
        this.TotalMulta = TotalMulta;
        this.TotalPagar = TotalPagar;
    }
    

    public double getTotalMulta() {
        return TotalMulta;
    }

    public void setTotalMulta(double TotalMulta) {
        this.TotalMulta = TotalMulta;
    }

    public double getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(double TotalPagar) {
        this.TotalPagar = TotalPagar;
    }
    
}
