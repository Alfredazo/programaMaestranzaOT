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
public class ListadoInsumos {
    int idListadoInsumos;
    String nombreProducto;
    String fechaCreacion;
    int cantidad;
    long precioUnitario;
    long subTotal;

    public ListadoInsumos() {
    }

    public ListadoInsumos(int idListadoInsumos, String nombreProducto, String fechaCreacion, int cantidad, long precioUnitario, long subTotal) {
        this.idListadoInsumos = idListadoInsumos;
        this.nombreProducto = nombreProducto;
        this.fechaCreacion = fechaCreacion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public int getIdListadoInsumos() {
        return idListadoInsumos;
    }

    public void setIdListadoInsumos(int idListadoInsumos) {
        this.idListadoInsumos = idListadoInsumos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
