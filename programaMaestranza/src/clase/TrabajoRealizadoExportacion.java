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
public class TrabajoRealizadoExportacion {
    String nombreCliente;
    String nombreOT;
    String responsable;
    int nroOT;
    String fechaInicio;
    String fechaTermino;
    long subTotal;

    public TrabajoRealizadoExportacion() {
    }

    public TrabajoRealizadoExportacion(String nombreCliente, String nombreOT, String responsable, int nroOT, String fechaInicio, String fechaTermino, long subTotal) {
        this.nombreCliente = nombreCliente;
        this.nombreOT = nombreOT;
        this.responsable = responsable;
        this.nroOT = nroOT;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.subTotal = subTotal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreOT() {
        return nombreOT;
    }

    public void setNombreOT(String nombreOT) {
        this.nombreOT = nombreOT;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getNroOT() {
        return nroOT;
    }

    public void setNroOT(int nroOT) {
        this.nroOT = nroOT;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}
