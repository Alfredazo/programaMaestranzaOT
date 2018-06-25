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
public class Cliente {

    String nombre, rut, giro, direccion, nombreContacto, telefono, numeroContacto;

    public Cliente() {
    }

    public Cliente(String nombre, String rut, String giro, String direccion, String nombreContacto, String numeroContacto, String telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.giro = giro;
        this.direccion = direccion;
        this.nombreContacto = nombreContacto;
        this.numeroContacto = numeroContacto;
        this.telefono = telefono;
    }
    
    public Cliente(String nombre,String rut, String giro){
        this.nombre = nombre;
        this.rut = rut;
        this.giro = giro;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", rut=" + rut + ", giro=" + giro + ", direccion=" + direccion + ", nombreContacto=" + nombreContacto + ", telefono=" + telefono + '}';
    }

}
