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
public class Usuario {
    
    int idUsuario, nroTrabajador;
    String clave;

    public Usuario() {
    }

    public Usuario(int idUsuario, int nroTrabajador, String clave) {
        this.idUsuario = idUsuario;
        this.nroTrabajador = nroTrabajador;
        this.clave = clave;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNroTrabajador() {
        return nroTrabajador;
    }

    public void setNroTrabajador(int nroTrabajador) {
        this.nroTrabajador = nroTrabajador;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nroTrabajador=" + nroTrabajador + ", clave=" + clave + '}';
    }
    
    
    
}
