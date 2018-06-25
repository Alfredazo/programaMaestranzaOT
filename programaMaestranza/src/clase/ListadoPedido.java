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
public class ListadoPedido {
    int idListado,cantidad,idPedido;
    Long precioUnitario,subTotal;
    String nombre;

    public ListadoPedido() {
    }

    public ListadoPedido(int idListado, int cantidad, int idPedido, Long precioUnitario, Long subTotal, String nombre) {
        this.idListado = idListado;
        this.cantidad = cantidad;
        this.idPedido = idPedido;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.nombre = nombre;
    }

    public ListadoPedido(int cantidad, Long subTotal, String nombre) {
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.nombre = nombre;
    }

    
    
    
    public int getIdListado() {
        return idListado;
    }

    public void setIdListado(int idListado) {
        this.idListado = idListado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
