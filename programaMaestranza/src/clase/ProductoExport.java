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
public class ProductoExport {

    int idProducto;
    String nombreProducto;
    String nombreEmpresa;
    long precioMinimo;
    long precioMaximo;
    
    

    public ProductoExport(int idProducto, String nombreProducto, String nombreEmpresa, long precioMinimo, long precioMaximo) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.nombreEmpresa = nombreEmpresa;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
    }

    public ProductoExport() {
    }

    public ProductoExport(int idProducto, String nombreProducto, long precioMinimo, long precioMaximo) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public long getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(long precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public long getPrecioMaximo() {
        return precioMaximo;
    }

    public void setPrecioMaximo(long precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

}
