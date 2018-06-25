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
public class ListadoTrabajosRealizados {
    int idListadoTrabajosRealizado;
    String nombreTrabajo;
    String tipoTrabajo;
    String nombreDepto;
    double horasTrabajadas;
    long valorHora;
    long subTotal;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    String descripcion;

    public ListadoTrabajosRealizados(int idListadoTrabajosRealizado, String nombreTrabajo, String tipoTrabajo, String nombreDepto, double horasTrabajadas, long valorHora, long subTotal, String descripcion) {
        this.idListadoTrabajosRealizado = idListadoTrabajosRealizado;
        this.nombreTrabajo = nombreTrabajo;
        this.tipoTrabajo = tipoTrabajo;
        this.nombreDepto = nombreDepto;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.subTotal = subTotal;
        this.descripcion = descripcion;
    }
    

    public ListadoTrabajosRealizados() {
    }

    public ListadoTrabajosRealizados(int idListadoTrabajosRealizado, String nombreTrabajo, String tipoTrabajo, String nombreDepto, double horasTrabajadas, long valorHora, long subTotal) {
        this.idListadoTrabajosRealizado = idListadoTrabajosRealizado;
        this.nombreTrabajo = nombreTrabajo;
        this.tipoTrabajo = tipoTrabajo;
        this.nombreDepto = nombreDepto;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.subTotal = subTotal;
    }

    public int getIdListadoTrabajosRealizado() {
        return idListadoTrabajosRealizado;
    }

    public void setIdListadoTrabajosRealizado(int idListadoTrabajosRealizado) {
        this.idListadoTrabajosRealizado = idListadoTrabajosRealizado;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
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
