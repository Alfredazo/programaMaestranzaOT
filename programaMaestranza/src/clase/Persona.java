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
public class Persona {
    String rut,nombre,apellido,cargo;
    int nroTrabajador;
    String numeroEmergencia1 , numeroEmergencia2;

    public Persona(String rut, String nombre, String apellido, String cargo, int nroTrabajador, String numeroEmergencia1, String numeroEmergencia2) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.nroTrabajador = nroTrabajador;
        this.numeroEmergencia1 = numeroEmergencia1;
        this.numeroEmergencia2 = numeroEmergencia2;
    }

    public Persona() {
    }

    public Persona(String rut, String nombre, String apellido, String cargo, int nroTrabajador) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.nroTrabajador = nroTrabajador;
    }
    
    public Persona(String rut, String nombre, int nroTrabajador){
        this.rut=rut;
        this.nombre = nombre;
        this.nroTrabajador = nroTrabajador;
    }

    public String getNumeroEmergencia1() {
        return numeroEmergencia1;
    }

    public void setNumeroEmergencia1(String numeroEmergencia1) {
        this.numeroEmergencia1 = numeroEmergencia1;
    }

    public String getNumeroEmergencia2() {
        return numeroEmergencia2;
    }

    public void setNumeroEmergencia2(String numeroEmergencia2) {
        this.numeroEmergencia2 = numeroEmergencia2;
    }

    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getNroTrabajador() {
        return nroTrabajador;
    }

    public void setNroTrabajador(int nroTrabajador) {
        this.nroTrabajador = nroTrabajador;
    }

    @Override
    public String toString() {
        return "Persona{" + "rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo + ", nroTrabajador=" + nroTrabajador + '}';
    }
    
    
}
