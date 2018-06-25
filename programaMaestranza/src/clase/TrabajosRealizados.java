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
public class TrabajosRealizados {
    int idTrabajosRealizados;
    int nroOT;
    String nombreOT;
    String nombreEmpresa;
    long subTotal;

    public TrabajosRealizados() {
    }

    public TrabajosRealizados(int idTrabajosRealizados, int nroOT, String nombreOT, String nombreEmpresa, long subTotal) {
        this.idTrabajosRealizados = idTrabajosRealizados;
        this.nroOT = nroOT;
        this.nombreOT = nombreOT;
        this.nombreEmpresa = nombreEmpresa;
        this.subTotal = subTotal;
    }

    public int getIdTrabajosRealizados() {
        return idTrabajosRealizados;
    }

    public void setIdTrabajosRealizados(int idTrabajosRealizados) {
        this.idTrabajosRealizados = idTrabajosRealizados;
    }

    public int getNroOT() {
        return nroOT;
    }

    public void setNroOT(int nroOT) {
        this.nroOT = nroOT;
    }

    public String getNombreOT() {
        return nombreOT;
    }

    public void setNombreOT(String nombreOT) {
        this.nombreOT = nombreOT;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}
