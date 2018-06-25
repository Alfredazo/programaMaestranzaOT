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
public class Factura {
    int idFactura, factura1,factura2,factura3,factura4,factura5;
    int numeroOC;

    public Factura() {
    }

    public Factura(int idFactura, int factura1, int factura2, int factura3, int factura4, int factura5) {
        this.idFactura = idFactura;
        this.factura1 = factura1;
        this.factura2 = factura2;
        this.factura3 = factura3;
        this.factura4 = factura4;
        this.factura5 = factura5;
    }

    public Factura(int idFactura, int factura1, int factura2, int factura3, int factura4, int factura5, int numeroOC) {
        this.idFactura = idFactura;
        this.factura1 = factura1;
        this.factura2 = factura2;
        this.factura3 = factura3;
        this.factura4 = factura4;
        this.factura5 = factura5;
        this.numeroOC = numeroOC;
    }

    
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getFactura1() {
        return factura1;
    }

    public void setFactura1(int factura1) {
        this.factura1 = factura1;
    }

    public int getFactura2() {
        return factura2;
    }

    public void setFactura2(int factura2) {
        this.factura2 = factura2;
    }

    public int getFactura3() {
        return factura3;
    }

    public void setFactura3(int factura3) {
        this.factura3 = factura3;
    }

    public int getFactura4() {
        return factura4;
    }

    public void setFactura4(int factura4) {
        this.factura4 = factura4;
    }

    public int getNumeroOC() {
        return numeroOC;
    }

    public void setNumeroOC(int numeroOC) {
        this.numeroOC = numeroOC;
    }

    public int getFactura5() {
        return factura5;
    }

    public void setFactura5(int factura5) {
        this.factura5 = factura5;
    }
    
    
}
