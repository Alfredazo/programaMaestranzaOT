/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Factura;
import clase.OrdenTrabajo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class OrdenTrabajoDao {

    Conexion conexion;

    public OrdenTrabajoDao() {
        conexion = new Conexion();
    }

    public boolean insertarOrdenTrabajo(int nroOrden, int idFactura, int idEmpresa, String nombreResponsable, String fechaInicio, String fechaTermino, String descripcion, int numeroOrdenCompra, String nombreOT) {
        boolean agregado = false;
        String sql = "Insert into ordentrabajo(numero_OT,id_factura,id_empresa,nombre_responsable_OT,fecha_inicio,fecha_termino,descripcion_OT,numero_ordenCompra,nombre_OT)  ";
        sql += "Values(?,?,?,?,?,?,?,?,?) ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, nroOrden);
            cs.setInt(2, idFactura);
            cs.setInt(3, idEmpresa);
            cs.setString(4, nombreResponsable);
            cs.setString(5, fechaInicio);
            cs.setString(6, fechaTermino);
            cs.setString(7, descripcion);
            cs.setInt(8, numeroOrdenCompra);
            cs.setString(9, nombreOT);

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

    public boolean modificarOrdenTrabajo(int nroOrden, int idEmpresa, String nombreResponsable, String fechaTermino, String descripcion, int numeroOrdenCompra, String nombreOT) {
        boolean agregado = false;
        String sql = "Update ordenTrabajo set ";
        sql += "id_empresa = ? , ";
        sql += "nombre_responsable_ot = ? ,";
        sql += "fecha_termino = ? ,  ";
        sql += "descripcion_OT = ?  ,";
        sql += "numero_ordenCompra = ?, ";
        sql += "nombre_OT  = ? ";
        sql += "where numero_OT = ? ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idEmpresa);
            cs.setString(2, nombreResponsable);
            cs.setString(3, fechaTermino);
            cs.setString(4, descripcion);
            cs.setInt(5, numeroOrdenCompra);
            cs.setString(6, nombreOT);
            cs.setInt(7, nroOrden);
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

    public boolean eliminarOrdenTrabajo(int nroOrdenTrabajo) {
        boolean agregado = false;
        String sql = "Delete from OrdenTrabajo where numero_OT = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, nroOrdenTrabajo);
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

    public int obtenerUltimoNroOrdenTrabajo() {
        int nroOT = 0;
        String sql = "Select numero_OT From ordentrabajo order by numero_OT desc limit 1;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nroOT = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nroOT;
    }

    public int obtenerIdEmpresa(String nombreEmpresa) {
        int idEmpresa = 0;
        String sql = "Select id_empresa  ";
        sql += "from empresa  ";
        sql += "where upper(nombre) = ? ";
        sql += "LIMIT 1;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreEmpresa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idEmpresa = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return idEmpresa;
    }

    public ArrayList<OrdenTrabajo> listarTodasLasOrdenesDeTrabajo() {
        ArrayList listado = new ArrayList();
        String sql = "Select ot.numero_OT, e.nombre, upper(ot.nombre_responsable_ot), ot.fecha_inicio, ot.fecha_termino, upper(ot.nombre_OT)  ";
        sql += "from ordenTrabajo ot  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa = e.id_empresa);   ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            //ps.setString(1, nombreEmpresa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int nroOrdenTrabajo = rs.getInt(1);
                String nombreEmpresa = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                String fechaInicio = rs.getString(4);
                String fechaTermino = rs.getString(5);
                String nombreOT = rs.getString(6);

                OrdenTrabajo ot = new OrdenTrabajo(nroOrdenTrabajo, nombreEmpresa, nombreResponsable, fechaInicio, fechaTermino, nombreOT);
                listado.add(ot);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<OrdenTrabajo> listarTodasLasOrdenesDeTrabajo(int numeroOT) {
        ArrayList listado = new ArrayList();
        String sql = "Select ot.numero_OT, e.nombre, upper(ot.nombre_responsable_ot), ot.fecha_inicio, ot.fecha_termino, upper(ot.nombre_OT)  ";
        sql += "from ordenTrabajo ot  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where ot.numero_OT = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int nroOrdenTrabajo = rs.getInt(1);
                String nombreEmpresa = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                String fechaInicio = rs.getString(4);
                String fechaTermino = rs.getString(5);
                String nombreOT = rs.getString(6);

                OrdenTrabajo ot = new OrdenTrabajo(nroOrdenTrabajo, nombreEmpresa, nombreResponsable, fechaInicio, fechaTermino, nombreOT);
                listado.add(ot);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<OrdenTrabajo> listarPorRangoNumeroOT(int numeroOTDesde, int numeroOTHasta) {
        ArrayList listado = new ArrayList();
        String sql = "Select ot.numero_OT, e.nombre, upper(ot.nombre_responsable_ot), ot.fecha_inicio, ot.fecha_termino, upper(ot.nombre_OT)  ";
        sql += "from ordenTrabajo ot  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where ot.numero_ot between ? and ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOTDesde);
            ps.setInt(2, numeroOTHasta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int nroOrdenTrabajo = rs.getInt(1);
                String nombreEmpresa = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                String fechaInicio = rs.getString(4);
                String fechaTermino = rs.getString(5);
                String nombreOT = rs.getString(6);

                OrdenTrabajo ot = new OrdenTrabajo(nroOrdenTrabajo, nombreEmpresa, nombreResponsable, fechaInicio, fechaTermino, nombreOT);
                listado.add(ot);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<OrdenTrabajo> listarPorNombreBuscar(String nombreResponsableBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select ot.numero_OT, e.nombre, upper(ot.nombre_responsable_ot), ot.fecha_inicio, ot.fecha_termino, upper(ot.nombre_OT)  ";
        sql += "from ordenTrabajo ot  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where upper(ot.nombre_responsable_ot) like '%' ? '%' ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreResponsableBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int nroOrdenTrabajo = rs.getInt(1);
                String nombreEmpresa = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                String fechaInicio = rs.getString(4);
                String fechaTermino = rs.getString(5);
                String nombreOT = rs.getString(6);

                OrdenTrabajo ot = new OrdenTrabajo(nroOrdenTrabajo, nombreEmpresa, nombreResponsable, fechaInicio, fechaTermino, nombreOT);
                listado.add(ot);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

     public ArrayList<OrdenTrabajo> listarPorNombreOTBuscar(String nombreOTBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select ot.numero_OT, e.nombre, upper(ot.nombre_responsable_ot), ot.fecha_inicio, ot.fecha_termino, upper(ot.nombre_OT)  ";
        sql += "from ordenTrabajo ot  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where upper(ot.nombre_OT) like '%' ? '%' ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int nroOrdenTrabajo = rs.getInt(1);
                String nombreEmpresa = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                String fechaInicio = rs.getString(4);
                String fechaTermino = rs.getString(5);
                String nombreOT = rs.getString(6);

                OrdenTrabajo ot = new OrdenTrabajo(nroOrdenTrabajo, nombreEmpresa, nombreResponsable, fechaInicio, fechaTermino, nombreOT);
                listado.add(ot);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }
    
    public ArrayList<OrdenTrabajo> listarPorFechaCreacion(String fechaCreacion) {
        ArrayList listado = new ArrayList();
        String sql = "Select ot.numero_OT, e.nombre, upper(ot.nombre_responsable_ot), ot.fecha_inicio, ot.fecha_termino, upper(ot.nombre_OT)  ";
        sql += "from ordenTrabajo ot  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where ot.fecha_inicio = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, fechaCreacion);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int nroOrdenTrabajo = rs.getInt(1);
                String nombreEmpresa = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                String fechaInicio = rs.getString(4);
                String fechaTermino = rs.getString(5);
                String nombreOT = rs.getString(6);

                OrdenTrabajo ot = new OrdenTrabajo(nroOrdenTrabajo, nombreEmpresa, nombreResponsable, fechaInicio, fechaTermino, nombreOT);
                listado.add(ot);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<OrdenTrabajo> listarPorFechaCreacionPorRango(String desde, String hasta) {
        ArrayList listado = new ArrayList();
        String sql = "Select ot.numero_OT, e.nombre, upper(ot.nombre_responsable_ot), ot.fecha_inicio, ot.fecha_termino, upper(ot.nombre_OT)  ";
        sql += "from ordenTrabajo ot  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa = e.id_empresa) ";
        sql += "where str_to_date(ot.fecha_inicio, '%d-%m-%Y') between str_to_date( ? , '%d-%m-%Y') and str_to_date( ? , '%d-%m-%Y');";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, desde);
            ps.setString(2, hasta);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int nroOrdenTrabajo = rs.getInt(1);
                String nombreEmpresa = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                String fechaInicio = rs.getString(4);
                String fechaTermino = rs.getString(5);
                String nombreOT = rs.getString(6);

                OrdenTrabajo ot = new OrdenTrabajo(nroOrdenTrabajo, nombreEmpresa, nombreResponsable, fechaInicio, fechaTermino, nombreOT);
                listado.add(ot);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public Factura obtenerFacturaOCPorNumeroOT(int numeroOT) {
        Factura factura = null;
        String sql = "Select f.nro_factura_1,f.nro_factura_2,f.nro_factura_3,f.nro_factura_4,f.nro_factura_5,ot.numero_ordenCompra   ";
        sql += "from factura f   ";
        sql += "join ordentrabajo ot  ";
        sql += "ON(ot.id_factura = f.id_factura)  ";
        sql += "where ot.numero_OT = ?;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int factura1 = rs.getInt(1);
                int factura2 = rs.getInt(2);
                int factura3 = rs.getInt(3);
                int factura4 = rs.getInt(4);
                int factura5 = rs.getInt(5);
                int numeroOC = rs.getInt(6);

                factura = new Factura(0, factura1, factura2, factura3, factura4, factura5, numeroOC);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return factura;
    }

    public OrdenTrabajo obtenerOrdenTrabajo(int numeroOTBuscar) {
        OrdenTrabajo ot = null;
        String sql = "Select ot.numero_ot ,ot.id_factura, e.nombre, ot.nombre_responsable_ot, ot.fecha_inicio, ot.fecha_termino, ot.descripcion_ot,ot.numero_ordenCompra,ot.nombre_ot  ";
        sql += "from ordentrabajo ot  ";
        sql += "join empresa e  ";
        sql += "ON(ot.id_empresa=e.id_empresa)  ";
        sql += "where ot.numero_ot = ? ;   ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOTBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int numeroOT = rs.getInt(1);
                int idFactura = rs.getInt(2);
                String nombreCliente = rs.getString(3);
                String nombreResponsable = rs.getString(4);
                String fechaInicio = rs.getString(5);
                String fechaTermino = rs.getString(6);
                String descripcion = rs.getString(7);
                int numeroOC = rs.getInt(8);
                String nombreOT = rs.getString(9);
                //Agregar a objeto
                ot = new OrdenTrabajo(numeroOT, nombreCliente, nombreResponsable, fechaInicio, fechaTermino, nombreOT, descripcion, idFactura, numeroOC);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ot;
    }

    public boolean validarSiExiste(int numeroOT) {
        boolean valida = false;
        String sql = "Select * from ordenTrabajo ";
        sql += "where numero_OT = ?;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valida = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return valida;
    }

}
