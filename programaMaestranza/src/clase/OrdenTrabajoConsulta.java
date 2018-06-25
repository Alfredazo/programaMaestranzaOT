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
public class OrdenTrabajoConsulta {
    int nroOT;
    String descripcion;

    public OrdenTrabajoConsulta() {
    }

    public OrdenTrabajoConsulta(int nroOT, String descripcion) {
        this.nroOT = nroOT;
        this.descripcion = descripcion;
    }

    public int getNroOT() {
        return nroOT;
    }

    public void setNroOT(int nroOT) {
        this.nroOT = nroOT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "OrdenTrabajoConsulta{" + "nroOT=" + nroOT + ", descripcion=" + descripcion + '}';
    }
    
    
}
