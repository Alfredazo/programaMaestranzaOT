/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Factura;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alfredo
 */
public class FacturaDao {

    Conexion conexion;

    public FacturaDao() {
        conexion = new Conexion();
    }

    public boolean insertarFactura(int factura1, int factura2, int factura3, int factura4, int factura5) {
        boolean agregado = false;
        String sql = "Insert into factura(nro_factura_1, nro_factura_2, nro_factura_3, nro_factura_4, nro_factura_5)  ";
        sql += "values(?,?,?,?,?) ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, factura1);
            cs.setInt(2, factura2);
            cs.setInt(3, factura3);
            cs.setInt(4, factura4);
            cs.setInt(5, factura5);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                agregado = true;
            } else {
                agregado = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return agregado;
    }

    public boolean modificarFactura(int factura1, int factura2, int factura3, int factura4, int factura5, int idFactura) {
        boolean agregado = false;
        String sql = "Update Factura set ";
        sql += "nro_factura_1 = ? , ";
        sql += "nro_factura_2 = ? , ";
        sql += "nro_factura_3 = ? , ";
        sql += "nro_factura_4 = ? , ";
        sql += "nro_factura_5 = ?   ";
        sql += "where id_factura = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, factura1);
            cs.setInt(2, factura2);
            cs.setInt(3, factura3);
            cs.setInt(4, factura4);
            cs.setInt(5, factura5);
            cs.setInt(6, idFactura);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                agregado = true;
            } else {
                agregado = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return agregado;
    }

    public int obtenerUltimoIDFactura() {
        int idFactura = 0;
        String sql = "Select id_factura from factura order by id_factura desc limit 1 ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            //ps.setInt(1, numeroPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idFactura = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idFactura;
    }

    public Factura obtenerFacturaPorID(int idPedido) {
        Factura facturita = null;
        String sql = "Select id_factura,nro_factura_1,nro_factura_2,nro_factura_3,nro_factura_4,nro_factura_5  ";
        sql += "from factura  ";
        sql += "where id_factura = ?  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idFactura = rs.getInt(1);
                int factura1 = rs.getInt(2);
                int factura2 = rs.getInt(3);
                int factura3 = rs.getInt(4);
                int factura4 = rs.getInt(5);
                int factura5 = rs.getInt(6);

                facturita = new Factura(idFactura, factura1, factura2, factura3, factura4, factura5);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return facturita;
    }

    public boolean validarExistaFactura(int idFactura) {
        boolean validado = false;
        String sql = "Select id_factura from factura where id_factura = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idFactura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                validado = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validado;
    }

}
