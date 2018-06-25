/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

/**
id_producto
nombre
descripccion
unidad_medida
marca
modelo
id_tipoProducto
rut_proveedor
 */
public class Producto {
   int id,idTipoProducto;
   String nombre,descripcion,unidadMedida,marca,modelo,rutProveedor;
   String nombreProveedor,nombreCategoria;
   

    public Producto() {
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    //Objeto para listado
    public Producto(int id, int idTipoProducto, String nombre, String descripcion, String unidadMedida, String marca, String modelo, String rutProveedor) {
        this.id = id;
        this.idTipoProducto = idTipoProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.marca = marca;
        this.modelo = modelo;
        this.rutProveedor = rutProveedor;
    }

    public Producto(int id, String nombre, String descripcion, String unidadMedida, String marca, String modelo, String nombreProveedor, String nombreCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.marca = marca;
        this.modelo = modelo;
        this.nombreProveedor = nombreProveedor;
        this.nombreCategoria = nombreCategoria;
    }

    
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
}
