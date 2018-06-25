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
public class Cotizacion {

    int idCotizacion;
    String fechaCreacion;
    int numeroOT;
    String estadoCotizacion, nombreEmpresa;
    Long total;

    public Cotizacion() {
    }

    public Cotizacion(int idCotizacion, String fechaCreacion, int numeroOT, String estadoCotizacion, Long total) {
        this.idCotizacion = idCotizacion;
        this.fechaCreacion = fechaCreacion;
        this.numeroOT = numeroOT;
        this.estadoCotizacion = estadoCotizacion;
        this.total = total;
    }

    public Cotizacion(int idCotizacion, String fechaCreacion, int numeroOT, String estadoCotizacion, String nombreEmpresa, Long total) {
        this.idCotizacion = idCotizacion;
        this.fechaCreacion = fechaCreacion;
        this.numeroOT = numeroOT;
        this.estadoCotizacion = estadoCotizacion;
        this.nombreEmpresa = nombreEmpresa;
        this.total = total;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getNumeroOT() {
        return numeroOT;
    }

    public void setNumeroOT(int numeroOT) {
        this.numeroOT = numeroOT;
    }

    public String getEstadoCotizacion() {
        return estadoCotizacion;
    }

    public void setEstadoCotizacion(String estadoCotizacion) {
        this.estadoCotizacion = estadoCotizacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cotizacion{" + "idCotizacion=" + idCotizacion + ", fechaCreacion=" + fechaCreacion + ", numeroOT=" + numeroOT + ", estadoCotizacion=" + estadoCotizacion + ", nombreEmpresa=" + nombreEmpresa + ", total=" + total + '}';
    }

}
