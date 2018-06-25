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
public class OrdenTrabajo {
    
    int numeroOT;
    String nombreCliente,nombreResponsable,fechaInicio,fechaTermino,nombreOT;
    String descripcion;
    int idFactura, nroOrden;
    public OrdenTrabajo() {
    }

    public OrdenTrabajo(int numeroOT, String nombreCliente, String nombreResponsable, String fechaInicio, String fechaTermino, String nombreOT, String descripcion, int idFactura, int nroOrden) {
        this.numeroOT = numeroOT;
        this.nombreCliente = nombreCliente;
        this.nombreResponsable = nombreResponsable;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.nombreOT = nombreOT;
        this.descripcion = descripcion;
        this.idFactura = idFactura;
        this.nroOrden = nroOrden;
    }

    
    public OrdenTrabajo(int numeroOT, String nombreCliente, String nombreResponsable, String fechaInicio, String fechaTermino, String nombreOT) {
        this.numeroOT = numeroOT;
        this.nombreCliente = nombreCliente;
        this.nombreResponsable = nombreResponsable;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.nombreOT = nombreOT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }

    
    public int getNumeroOT() {
        return numeroOT;
    }

    public void setNumeroOT(int numeroOT) {
        this.numeroOT = numeroOT;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
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

    public String getNombreOT() {
        return nombreOT;
    }

    public void setNombreOT(String nombreOT) {
        this.nombreOT = nombreOT;
    }
    
    
    
    
    
}
