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
public class Proveedor {

    String nombreEmpresa, giro, rut, paginaWeb, nombreContacto, telefono, correo,nombreBanco,nroCuentaCorriente;

    public Proveedor() {
    }

    public Proveedor(String nombreEmpresa, String giro, String rut) {
        this.nombreEmpresa = nombreEmpresa;
        this.giro = giro;
        this.rut = rut;
    }

    public Proveedor(String nombreEmpresa, String giro, String rut, String paginaWeb, String nombreContacto, String telefono, String correo,String nombreBanco,String nroCuentaCorriente) {
        this.nombreEmpresa = nombreEmpresa;
        this.giro = giro;
        this.rut = rut;
        this.paginaWeb = paginaWeb;
        this.nombreContacto = nombreContacto;
        this.telefono = telefono;
        this.correo = correo;
        this.nombreBanco = nombreBanco;
        this.nroCuentaCorriente = nroCuentaCorriente;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNroCuentaCorriente() {
        return nroCuentaCorriente;
    }

    public void setNroCuentaCorriente(String nroCuentaCorriente) {
        this.nroCuentaCorriente = nroCuentaCorriente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nombreEmpresa=" + nombreEmpresa + ", giro=" + giro + ", rut=" + rut + ", paginaWeb=" + paginaWeb + ", nombreContacto=" + nombreContacto + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

}
