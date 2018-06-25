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
public class ListadoExportarCotizacion {
    int idCotizacion;
    int numeroOT;
    String nombreEmpresa;
    String fechaGeneracion;
    long total;
    String nombreOT;

    public ListadoExportarCotizacion() {
    }

    public ListadoExportarCotizacion(int idCotizacion, int numeroOT, String nombreEmpresa, String fechaGeneracion, long total, String nombreOT) {
        this.idCotizacion = idCotizacion;
        this.numeroOT = numeroOT;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaGeneracion = fechaGeneracion;
        this.total = total;
        this.nombreOT = nombreOT;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public int getNumeroOT() {
        return numeroOT;
    }

    public void setNumeroOT(int numeroOT) {
        this.numeroOT = numeroOT;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getNombreOT() {
        return nombreOT;
    }

    public void setNombreOT(String nombreOT) {
        this.nombreOT = nombreOT;
    }
    
    
    
}
