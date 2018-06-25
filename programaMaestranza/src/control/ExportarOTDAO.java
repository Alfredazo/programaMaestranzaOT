/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Cliente;
import clase.Conexion;
import clase.ExportarOT;
import clase.ListadoInsumos;
import clase.ListadoPedido;
import clase.ListadoTrabajosRealizados;
import clase.ListadoTrabajosRealizadosExportOT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class ExportarOTDAO {

    Conexion conexion;

    public ExportarOTDAO() {
        conexion = new Conexion();
    }

    public ExportarOT rescatarCabeceraExport(int nroOTBuscar) {
        ExportarOT export = null;
        String sql = "Select ot.numero_OT, ot.nombre_responsable_ot, ot.fecha_inicio, ot.fecha_termino, ot.descripcion_ot, ot.numero_ordenCompra, ot.nombre_ot, ";
        sql += " f.nro_factura_1, f.nro_factura_2, f.nro_factura_3, f.nro_factura_4, f.nro_factura_5,e.nombre, e.rut, e.giro_empresa, e.direccion, e.nombre_contacto, ";
        sql += " e.nro_contacto, e.nro_empresa ";
        sql += " from ordentrabajo ot  ";
        sql += " Join factura f  ";
        sql += "ON(ot.id_factura = f.id_factura) ";
        sql += "Join empresa e  ";
        sql += "ON (ot.id_empresa = e.id_empresa) ";
        sql += "Where ot.numero_OT = ? ;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int nroOT = rs.getInt(1);
                String nombreResponsable = rs.getString(2);
                String fechaInicio = rs.getString(3);
                String fechaTermino = rs.getString(4);
                String descripcion = rs.getString(5);
                int nroOrdenCompra = rs.getInt(6);
                String nombreOT = rs.getString(7);
                int nroFactura1 = rs.getInt(8);
                int nroFactura2 = rs.getInt(9);
                int nroFactura3 = rs.getInt(10);
                int nroFactura4 = rs.getInt(11);
                int nroFactura5 = rs.getInt(12);
                String nombreEmpresa = rs.getString(13);
                String rutEmpresa = rs.getString(14);
                String giroEmpresa = rs.getString(15);
                String direccion = rs.getString(16);
                String nombreContacto = rs.getString(17);
                String nroContacto = rs.getString(18);
                String nroEmpresa = rs.getString(19);

                export = new ExportarOT(nroOT, nombreResponsable, fechaInicio, fechaTermino, descripcion, nroOrdenCompra, nombreOT, nroFactura1, nroFactura2, nroFactura3, nroFactura4, nroFactura5, nombreEmpresa, rutEmpresa, giroEmpresa, direccion, nombreContacto, nroContacto, nroEmpresa);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return export;
    }

    public ArrayList<ListadoPedido> rescatarDatosPedido(int nroOTBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select p.nombre,sum(l.cantidad),sum(l.subTotal_listaPedidos)  ";
        sql += "from listadoPedidos l   ";
        sql += "Join producto p   ";
        sql += "ON(l.id_producto = p.id_producto)   ";
        sql += "Join pedidos pe  ";
        sql += "on(l.id_pedido = pe.id_pedido)  ";
        sql += "where pe.numero_OT = ? and pe.estado_pedido = 'COMPRADO'  ";
        sql += "Group by p.nombre  ";
        sql += "order by l.id_listadoPedidos;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreProducto = rs.getString(1);
                int cantidadSumada = rs.getInt(2);
                long subTotal = rs.getLong(3);

                ListadoPedido lp = new ListadoPedido(cantidadSumada, subTotal, nombreProducto);
                listado.add(lp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public long rescatarTotalDatosPedidoPorNroOT(int nroOTBuscar) {
        long totalPorOT = 0;
        String sql = "Select sum(subTotal_pedidos)  ";
        sql += "from pedidos  ";
        sql += "where numero_OT = ? and estado_pedido = 'COMPRADO'; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalPorOT = rs.getLong(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return totalPorOT;
    }

    public ArrayList<ListadoPedido> rescatarDatosInsumos(int nroOTBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select l.id_listadoInsumos, p.nombre,sum(l.cantidad),sum(l.subTotal_listadoInsumos)  ";
        sql += "From listadoInsumos l   ";
        sql += "JOIN producto p  ";
        sql += "ON(l.id_producto = p.id_producto) ";
        sql += "Join insumos ins ";
        sql += "ON(l.id_insumos = ins.id_insumos) ";
        sql += "where ins.numero_OT = ?  ";
        sql += "Group by p.nombre;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreProducto = rs.getString(2);
                int cantidadSumada = rs.getInt(3);
                long subTotal = rs.getLong(4);

                ListadoPedido listadoPedido = new ListadoPedido(cantidadSumada, subTotal, nombreProducto);
                listado.add(listadoPedido);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public long rescatarTotalDatosInsumoPorNroOT(int nroOTBuscar) {
        long totalPorOT = 0;
        String sql = "Select subTotal_listaInsumos  ";
        sql += "from insumos  ";
        sql += "where numero_OT = ?; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalPorOT = rs.getLong(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return totalPorOT;
    }

    public ArrayList<ListadoTrabajosRealizadosExportOT> rescatarDatosTrabajosRealizado(int nroOTBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select d.nombre,lt.nombre_trabajo,sum(lt.horas_ocupadas),tt.valor_horaTrabajo,sum(lt.subTotal) ";
        sql += "from listadotrabajosrealizados lt ";
        sql += "Join tipotrabajo tt ";
        sql += "ON(tt.id_tipoTrabajo = lt.id_tipoTrabajo)  ";
        sql += "Join departamento d ";
        sql += "ON(tt.id_departamento = d.id_departamento) ";
        sql += "Join trabajosrealizados tr  ";
        sql += "ON(lt.id_trabajoRealizado = tr.id_trabajosRealizados)  ";
        sql += "Where tr.numero_OT = ?  ";
        sql += "Group by d.nombre; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreDepto = rs.getString(1);
                String nombreTrabajo = rs.getString(2);
                double horasTrabajadas = rs.getDouble(3);
                long valorHora = rs.getLong(4);
                long subTotal = rs.getLong(5);

                ListadoTrabajosRealizadosExportOT ltr = new ListadoTrabajosRealizadosExportOT(nombreDepto, nombreTrabajo, horasTrabajadas, valorHora, subTotal);
                listado.add(ltr);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public long rescatarTotalDatosTrabajosPorNroOT(int nroOTBuscar) {
        long totalPorOT = 0;
        String sql = "Select subTotal_listadoTR ";
        sql += "from ";
        sql += "trabajosrealizados ";
        sql += "where numero_OT = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalPorOT = rs.getLong(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return totalPorOT;
    }

}
