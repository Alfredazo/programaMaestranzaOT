/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Insumo;
import clase.InsumoExportacion;
import clase.ListadoInsumos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class InsumoDao {

    Conexion conexion;

    public InsumoDao() {
        conexion = new Conexion();
    }

    /*TABLA INSUMOS*/
    public boolean insertarInsumo(int numeroOT) {
        boolean agregado = false;
        String sql = "Insert into insumos(numero_OT) ";
        sql += "values(?) ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, numeroOT);

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

    public boolean modificarInsumo(int numeroOT, int idInsumo) {
        boolean modificado = false;
        String sql = "Update Insumos set ";
        sql += "numero_OT  = ? ";
        sql += "where id_insumos = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, numeroOT);
            cs.setInt(2, idInsumo);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                modificado = true;
            } else {
                modificado = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public boolean validarQueNoExistaOTInsumo(int numeroOT) {
        boolean existe = false;
        String sql = "Select id_insumos  ";
        sql += "from insumos  ";
        sql += "where numero_OT = ?  ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOT);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return existe;

    }

    public boolean validarQueExistaInsumo(int idInsumo) {
        boolean existe = false;
        String sql = "Select id_insumos  ";
        sql += "from insumos  ";
        sql += "where id_insumos = ?  ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idInsumo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return existe;

    }

    public int obtenerUltimoNroInsumo() {
        int numeroPedido = 0;

        String sql = "SELECT id_insumos FROM insumos order by id_insumos desc limit 1;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numeroPedido = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return numeroPedido;

    }

    public ArrayList<Insumo> listadoInsumo() {
        ArrayList listado = new ArrayList();
        String sql = "Select i.id_insumos, i.numero_OT, upper(ot.nombre_OT), upper(e.nombre),i.subTotal_listaInsumos  ";
        sql += "from insumos i  ";
        sql += "Join ordentrabajo ot  ";
        sql += "ON(i.numero_OT = ot.numero_OT)  ";
        sql += "Join empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa);  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idInsumo = rs.getInt(1);
                int nroOT = rs.getInt(2);
                String nombreOT = rs.getString(3);
                String nombreCliente = rs.getString(4);
                long total = rs.getLong(5);

                Insumo insumito = new Insumo(idInsumo, nroOT, nombreOT, nombreCliente, total);
                listado.add(insumito);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return listado;

    }

    public ArrayList<Insumo> listadoInsumo(int nroOTBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select i.id_insumos, i.numero_OT, upper(ot.nombre_OT), upper(e.nombre),i.subTotal_listaInsumos  ";
        sql += "from insumos i  ";
        sql += "Join ordentrabajo ot  ";
        sql += "ON(i.numero_OT = ot.numero_OT)  ";
        sql += "Join empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa)  ";
        sql += "where i.numero_OT = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idInsumo = rs.getInt(1);
                int nroOT = rs.getInt(2);
                String nombreOT = rs.getString(3);
                String nombreCliente = rs.getString(4);
                long total = rs.getLong(5);

                Insumo insumito = new Insumo(idInsumo, nroOT, nombreOT, nombreCliente, total);
                listado.add(insumito);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return listado;

    }

    /*TABLA LISTADOINSUMOS - INSUMOS*/
    public ArrayList<ListadoInsumos> listadoItemsInsumo(int idInsumoBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select l.id_listadoInsumos, p.nombre,l.fecha_creacion,l.cantidad,l.precio_unitario,l.subTotal_listadoInsumos  ";
        sql += "From listadoInsumos l  ";
        sql += "JOIN producto p  ";
        sql += "ON(l.id_producto = p.id_producto)  ";
        sql += "where l.id_insumos = ? ;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idInsumoBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idInsumo = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String fechaCreacion = rs.getString(3);
                int cantidad = rs.getInt(4);
                long precioUnitario = rs.getLong(5);
                long subTotal = rs.getLong(6);

                ListadoInsumos insumox = new ListadoInsumos(idInsumo, nombreProducto, fechaCreacion, cantidad, precioUnitario, subTotal);

                listado.add(insumox);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return listado;

    }

    public ListadoInsumos objetoItemsInsumo(int idListado) {
        ListadoInsumos insumox = null;
        String sql = "Select l.id_listadoInsumos, p.nombre,l.fecha_creacion,l.cantidad,l.precio_unitario,l.subTotal_listadoInsumos  ";
        sql += "From listadoInsumos l  ";
        sql += "JOIN producto p  ";
        sql += "ON(l.id_producto = p.id_producto)  ";
        sql += "where l.id_listadoInsumos = ? ;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idListado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idInsumo = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String fechaCreacion = rs.getString(3);
                int cantidad = rs.getInt(4);
                long precioUnitario = rs.getLong(5);
                long subTotal = rs.getLong(6);

                insumox = new ListadoInsumos(idInsumo, nombreProducto, fechaCreacion, cantidad, precioUnitario, subTotal);

            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return insumox;

    }

    public boolean insertarItemListadoInsumo(int cantidad, long precioUnitario, long subTotal, int idProducto, int idInsumo, String fechaCreacion) {
        boolean agregado = false;
        String sql = "Insert into listadoInsumos(precio_unitario,cantidad,subTotal_listadoInsumos,id_producto,id_insumos,fecha_creacion)  ";
        sql += "values(?,?,?,?,?,?)  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setLong(1, precioUnitario);
            cs.setInt(2, cantidad);
            cs.setLong(3, subTotal);
            cs.setInt(4, idProducto);
            cs.setInt(5, idInsumo);
            cs.setString(6, fechaCreacion);

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

    public boolean modificarItemListadoInsumo(int cantidad, long precioUnitario, long subTotal, int idProducto, int idListado) {
        boolean agregado = false;
        String sql = "Update listadoInsumos set ";
        sql += "cantidad = ? ,";
        sql += "precio_unitario = ? ,";
        sql += "subTotal_listadoInsumos = ?, ";
        sql += "id_producto = ? ";
        sql += "where id_listadoInsumos = ? ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, cantidad);
            cs.setLong(2, precioUnitario);
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

    public boolean eliminarITEMListado(int idListado) {
        boolean agregado = false;
        String sql = "Delete from listadoInsumos where id_listadoInsumos = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idListado);

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

    public boolean eliminarInsumo(int idInsumo) {
        boolean agregado = false;
        String sql = "Delete from insumos where id_insumos = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idInsumo);

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

    public long devolverValorTotalListadoInsumo(int idInsumo) {
        long total = 0;
        String sql = "Select SUM(subTotal_listadoInsumos)  ";
        sql += "from listadoInsumos   ";
        sql += "where id_insumos = ? ;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idInsumo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getLong(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    public boolean modificarSubTotalInsumo(long subTotal, int idInsumo) {
        boolean agregado = false;
        String sql = "Update insumos set  ";
        sql += "subTotal_listaInsumos = ?  ";
        sql += "where id_insumos = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setLong(1, subTotal);
            cs.setInt(2, idInsumo);

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

    /*METODO PARA EXPORTAR*/
    public InsumoExportacion objetoExportarInsumo(int idInsumoB) {
        InsumoExportacion insumox = null;
        String sql = "Select e.nombre, ot.nombre_OT, ot.nombre_responsable_OT, i.id_insumos, i.subTotal_listaInsumos, i.numero_OT   ";
        sql += "from empresa e  ";
        sql += "Join ordentrabajo ot  ";
        sql += "ON(ot.id_empresa = e.id_empresa)  ";
        sql += "Join insumos i  ";
        sql += "ON(ot.numero_OT = i.numero_OT) ";
        sql += "where i.id_insumos = ? ;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idInsumoB);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nombreEmpresa = rs.getString(1);
                String nombreOT = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                int idInsumo = rs.getInt(4);
                long subTotal = rs.getLong(5);
                int nroOT = rs.getInt(6);

                insumox = new InsumoExportacion(nombreEmpresa, nombreOT, nombreResponsable, idInsumo, subTotal, nroOT);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }

        return insumox;

    }

}
