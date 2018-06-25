/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.ListadoPedido;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class ListadoPedidoDao {

    Conexion conexion;

    public ListadoPedidoDao() {
        conexion = new Conexion();
    }

    public boolean insertarItemPedido(long precioUnitario, int cantidad, long subTotal, int idProducto, int idPedido) {
        boolean agregado = false;
        String sql = "Insert into listadoPedidos(precio_unitario,cantidad,subTotal_listaPedidos,id_producto,id_pedido) ";
        sql += "values(?,?,?,?,?);";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setLong(1, precioUnitario);
            cs.setInt(2, cantidad);
            cs.setLong(3, subTotal);
            cs.setInt(4, idProducto);
            cs.setInt(5, idPedido);

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

    public boolean modificarItemPedido(long precioUnitario, int cantidad, long subTotal, int idProducto, int idListado) {
        boolean agregado = false;
        String sql = "Update listadopedidos set  ";
        sql += " precio_unitario = ? , ";
        sql += " cantidad = ? , ";
        sql += " subTotal_listaPedidos = ?, ";
        sql += " id_producto = ? ";
        sql += " where id_listadoPedidos = ? ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setLong(1, precioUnitario);
            cs.setInt(2, cantidad);
            cs.setLong(3, subTotal);
            cs.setInt(4, idProducto);
            cs.setInt(5, idListado);

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

    public boolean eliminarITEM(int numeroListado) {
        boolean agregado = false;
        String sql = "Delete from listadoPedidos where id_listadoPedidos = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, numeroListado);
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

    public ArrayList<ListadoPedido> listadoITEMPedidosListaCompleta(int idPedido) {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select l.id_listadoPedidos, p.nombre, l.precio_unitario,l.cantidad,l.subTotal_listaPedidos ";
        sql += "from listadoPedidos l ";
        sql += "Join producto p ";
        sql += "ON(l.id_producto = p.id_producto) ";
        sql += "where l.id_pedido = ? ";
        sql += "order by l.id_listadoPedidos;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idListaPedido = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                long precioUnitario = rs.getLong(3);
                int cantidad = rs.getInt(4);
                long subTotal = rs.getLong(5);

                ListadoPedido pedido = new ListadoPedido(idListaPedido, cantidad, idPedido, precioUnitario, subTotal, nombreProducto);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }

    public long devolverTotalListaPedidos(int numeroPedido) {
        long valorFinal = 0;
        String sql = "select sum(subTotal_listaPedidos) ";
        sql += "from listadoPedidos ";
        sql += "where id_pedido = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valorFinal = rs.getLong(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valorFinal;
    }

    public String devolverNombreEmpresaSolicita(int numeroOT) {
        String nombre = "";
        String sql = "Select e.nombre ";
        sql += "from ordentrabajo ot ";
        sql += "join empresa e ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where ot.numero_OT = ? ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nombre;
    }

    public String devolverNombreTrabajoOT(int numeroOT) {
        String nombre = "";

        String sql = "Select ot.descripcion_OT  ";
        sql += "from ordentrabajo ot ";
        sql += "join empresa e ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where ot.numero_OT = ? ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("ERROR DEVOLVER NOMBRE OBRA:" + e.getMessage());
        }
        return nombre;
    }
}
