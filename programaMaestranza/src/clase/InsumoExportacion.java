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
public class InsumoExportacion {
    String nombreEmpresa;
    String nombreOT;
    String nombreResponsable;
    int idInsumo;
    long subTotalInsumo;
    int nroOT;

    public InsumoExportacion() {
    }

    public InsumoExportacion(String nombreEmpresa, String nombreOT, String nombreResponsable, int idInsumo, long subTotalInsumo, int nroOT) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreOT = nombreOT;
        this.nombreResponsable = nombreResponsable;
        this.idInsumo = idInsumo;
        this.subTotalInsumo = subTotalInsumo;
        this.nroOT = nroOT;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreOT() {
        return nombreOT;
    }

    public void setNombreOT(String nombreOT) {
        this.nombreOT = nombreOT;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public long getSubTotalInsumo() {
        return subTotalInsumo;
    }

    public void setSubTotalInsumo(long subTotalInsumo) {
        this.subTotalInsumo = subTotalInsumo;
    }

    public int getNroOT() {
        return nroOT;
    }

    public void setNroOT(int nroOT) {
        this.nroOT = nroOT;
    }
    
}
