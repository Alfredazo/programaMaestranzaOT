/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

/**
 *
 * @author Alfredo
 */
public class ListadoTrabajosRealizadosExportOT {
    String nombreDepto;
    String nombreTrabajo;
    double horasTrabajadas;
    long valorHora;
    long subTotal;

    public ListadoTrabajosRealizadosExportOT() {
    }

    public ListadoTrabajosRealizadosExportOT(String nombreDepto, String nombreTrabajo, double horasTrabajadas, long valorHora, long subTotal) {
        this.nombreDepto = nombreDepto;
        this.nombreTrabajo = nombreTrabajo;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.subTotal = subTotal;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public long getValorHora() {
        return valorHora;
    }

    public void setValorHora(long valorHora) {
        this.valorHora = valorHora;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
