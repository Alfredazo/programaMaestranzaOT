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
public class TipoTrabajo {
    int idTipoTrabajo, idDepartamento;
    String tipoDepto;
    String nombreDepto;
    long valorHora;

    public TipoTrabajo() {
    }

    public TipoTrabajo(int idTipoTrabajo, int idDepartamento, String tipoDepto, long valorHora,String nombreDepto) {
        this.idTipoTrabajo = idTipoTrabajo;
        this.idDepartamento = idDepartamento;
        this.tipoDepto = tipoDepto;
        this.valorHora = valorHora;
        this.nombreDepto = nombreDepto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public int getIdTipoTrabajo() {
        return idTipoTrabajo;
    }

    public void setIdTipoTrabajo(int idTipoTrabajo) {
        this.idTipoTrabajo = idTipoTrabajo;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getTipoDepto() {
        return tipoDepto;
    }

    public void setTipoDepto(String tipoDepto) {
        this.tipoDepto = tipoDepto;
    }

    public long getValorHora() {
        return valorHora;
    }

    public void setValorHora(long valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "TipoTrabajo{" + "idTipoTrabajo=" + idTipoTrabajo + ", idDepartamento=" + idDepartamento + ", tipoDepto=" + tipoDepto + ", valorHora=" + valorHora + '}';
    }
}
