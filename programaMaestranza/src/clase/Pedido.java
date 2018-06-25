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
public class Pedido {
    int idPedido;
    int numeroOT;
    String fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto;
    long subTotales;
    String nombreOT;
    String nombreCliente;
    
    public Pedido() {
    }

    public Pedido(int idPedido,int numeroOT,String fechaGeneracion, String tipoUrgencia, String estadoPedido, String nombreCompleto, long subTotales) {
        this.idPedido = idPedido;
        this.fechaGeneracion = fechaGeneracion;
        this.tipoUrgencia = tipoUrgencia;
        this.estadoPedido = estadoPedido;
        this.nombreCompleto = nombreCompleto;
        this.subTotales = subTotales;
        this.numeroOT = numeroOT;
    }

    public Pedido(int idPedido, int numeroOT, String fechaGeneracion, String tipoUrgencia, String estadoPedido, String nombreCompleto, long subTotales, String nombreOT, String nombreCliente) {
        this.idPedido = idPedido;
        this.numeroOT = numeroOT;
        this.fechaGeneracion = fechaGeneracion;
        this.tipoUrgencia = tipoUrgencia;
        this.estadoPedido = estadoPedido;
        this.nombreCompleto = nombreCompleto;
        this.subTotales = subTotales;
        this.nombreOT = nombreOT;
        this.nombreCliente = nombreCliente;
    }

    public String getNombreOT() {
        return nombreOT;
    }

    public void setNombreOT(String nombreOT) {
        this.nombreOT = nombreOT;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    

    public int getNumeroOT() {
        return numeroOT;
    }

    public void setNumeroOT(int numeroOT) {
        this.numeroOT = numeroOT;
    }

    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getTipoUrgencia() {
        return tipoUrgencia;
    }

    public void setTipoUrgencia(String tipoUrgencia) {
        this.tipoUrgencia = tipoUrgencia;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getSubTotales() {
        return subTotales;
    }

    public void setSubTotales(long subTotales) {
        this.subTotales = subTotales;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fechaGeneracion=" + fechaGeneracion + ", tipoUrgencia=" + tipoUrgencia + ", estadoPedido=" + estadoPedido + ", nombreCompleto=" + nombreCompleto + ", subTotales=" + subTotales + '}';
    }
    
    
    
}
