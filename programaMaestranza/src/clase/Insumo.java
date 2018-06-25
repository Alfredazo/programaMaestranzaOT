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
public class Insumo {
    int idInsumo;
    int numeroOT;
    String nombreOT, nombreEmpresa;
    long total;

    public Insumo() {
    }

    public Insumo(int idInsumo, int numeroOT, String nombreOT, String nombreEmpresa, long total) {
        this.idInsumo = idInsumo;
        this.numeroOT = numeroOT;
        this.nombreOT = nombreOT;
        this.nombreEmpresa = nombreEmpresa;
        this.total = total;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getNumeroOT() {
        return numeroOT;
    }

    public void setNumeroOT(int numeroOT) {
        this.numeroOT = numeroOT;
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

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    
    
}
