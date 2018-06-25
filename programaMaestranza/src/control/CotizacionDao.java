/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Cotizacion;
import clase.ListadoCotizacion;
import clase.ListadoExportarCotizacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class CotizacionDao {

    Conexion conexion;

    public CotizacionDao() {
        conexion = new Conexion();
    }

    public boolean insertarCotizacion(String fechaCreacion, int numeroOT, String estadoCotizacion) {
        boolean agregado = false;
        String sql = "Insert into cotizacion(fecha_generacion,numero_OT,estado_cotizacion)  ";
        sql += "values(?,?,?);";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, fechaCreacion);
            cs.setInt(2, numeroOT);
            cs.setString(3, estadoCotizacion);

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

    public boolean modificarCotizacion(int numeroOT, String estadoCotizacion, int idCotizacion) {
        boolean agregado = false;
        String sql = "Update cotizacion set  ";
        sql += "numero_OT = ? , ";
        sql += "estado_cotizacion = ?  ";
        sql += "where id_cotizacion = ?  ;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, numeroOT);
            cs.setString(2, estadoCotizacion);
            cs.setInt(3, idCotizacion);

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

    public int obtenerIDCotizacion() {
        int idCotizacion = 0;
        String sql = "Select id_cotizacion from cotizacion order by id_cotizacion desc limit 1; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idCotizacion = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idCotizacion;
    }

    public boolean validarSiExiste(int idCotizacion) {
        boolean valida = false;
        String sql = "Select id_cotizacion from cotizacion where id_cotizacion = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idCotizacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valida = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valida;
    }

    public ArrayList<ListadoCotizacion> listadoCotizacion(int idCotizacion) {
        ArrayList listado = new ArrayList();
        String sql = "Select id_listadoCotizacion, descripcion_item,cantidad,precioUnitario,subTotal_listadoCotizacion from listadoCotizacion  ";
        sql += "where id_cotizacion = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idCotizacion);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idListado = rs.getInt(1);
                String descripcion = rs.getString(2);
                int cantidad = rs.getInt(3);
                long precioUnitario = rs.getLong(4);
                long subTotal = rs.getLong(5);

                ListadoCotizacion listaCoti = new ListadoCotizacion(idListado, descripcion, cantidad, precioUnitario, subTotal);
                listado.add(listaCoti);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public boolean insertarListadoCotizacion(String descripcion, int cantidad, long precioUnitario, long subTotal, int idCotizacion) {
        boolean agregado = false;
        String sql = "Insert into listadoCotizacion(descripcion_item,cantidad,precioUnitario,subTotal_listadoCotizacion,id_cotizacion)  ";
        sql += "values(?,?,?,?,?);";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, descripcion);
            cs.setInt(2, cantidad);
            cs.setLong(3, precioUnitario);
            cs.setLong(4, subTotal);
            cs.setInt(5, idCotizacion);

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

    public boolean modificarListadoCotizacion(String descripcion, int cantidad, long precioUnitario, long subTotal, int idListadocotizacion) {
        boolean agregado = false;
        String sql = "Update ListadoCotizacion set  ";
        sql += "descripcion_item = ? , ";
        sql += "cantidad = ? , ";
        sql += "precioUnitario = ?, ";
        sql += "subTotal_listadoCotizacion = ? ";
        sql += "where id_listadoCotizacion = ? ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, descripcion);
            cs.setInt(2, cantidad);
            cs.setLong(3, precioUnitario);
            cs.setLong(4, subTotal);
            cs.setInt(5, idListadocotizacion);

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

    public boolean eliminarCotizacion(int idListadoCotizacion) {
        boolean agregado = false;
        String sql = "Delete from cotizacion ";
        sql += "where id_cotizacion = ?  ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idListadoCotizacion);

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

    public boolean eliminarListadoCotizacion(int idListadoCotizacion) {
        boolean agregado = false;
        String sql = "Delete from listadoCotizacion ";
        sql += "where id_listadoCotizacion = ?  ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idListadoCotizacion);

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

    public long devolverValorTotalListadoCotizacion(int idCotizacion) {
        long total = 0;
        String sql = "Select Sum(subTotal_listadoCotizacion)  ";
        sql += "from listadoCotizacion   ";
        sql += "where id_cotizacion = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idCotizacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getLong(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    public ArrayList<Cotizacion> listadoCotizaciones() {
        ArrayList listado = new ArrayList();
        String sql = "Select c.id_cotizacion,c.numero_OT, e.nombre, c.fecha_generacion, c.total_cotizacion, c.estado_cotizacion  ";
        sql += "from cotizacion c  ";
        sql += "join ordentrabajo ot ";
        sql += "ON(c.numero_OT = ot.numero_OT)  ";
        sql += "Join empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa)   ";
        sql += "Order by id_cotizacion;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCotizacion = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String nombreCliente = rs.getString(3);
                String fechaCreacion = rs.getString(4);
                long total = rs.getLong(5);
                String estadoCotizacion = rs.getString(6);

                Cotizacion coti = new Cotizacion(idCotizacion, fechaCreacion, numeroOT, estadoCotizacion, nombreCliente, total);
                listado.add(coti);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public ArrayList<Cotizacion> listadoCotizacionesPorNombreCliente(String nombreClienteBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select c.id_cotizacion,c.numero_OT, e.nombre, c.fecha_generacion, c.total_cotizacion, c.estado_cotizacion  ";
        sql += "from cotizacion c  ";
        sql += "join ordentrabajo ot ";
        sql += "ON(c.numero_OT = ot.numero_OT)  ";
        sql += "Join empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa)   ";
        sql += "where upper(e.nombre) like '%' ? '%' ";
        sql += "Order by id_cotizacion;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreClienteBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCotizacion = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String nombreCliente = rs.getString(3);
                String fechaCreacion = rs.getString(4);
                long total = rs.getLong(5);
                String estadoCotizacion = rs.getString(6);

                Cotizacion coti = new Cotizacion(idCotizacion, fechaCreacion, numeroOT, estadoCotizacion, nombreCliente, total);
                listado.add(coti);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public Cotizacion obtenerCotizaciones(int idCotizacionBuscar) {
        Cotizacion cotix = new Cotizacion();
        String sql = "Select c.id_cotizacion,c.numero_OT, e.nombre, c.fecha_generacion, c.total_cotizacion, c.estado_cotizacion  ";
        sql += "from cotizacion c  ";
        sql += "join ordentrabajo ot ";
        sql += "ON(c.numero_OT = ot.numero_OT)  ";
        sql += "Join empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa)   ";
        sql += "where c.id_cotizacion = ? ";
        sql += "Order by c.id_cotizacion ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idCotizacionBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCotizacion = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String nombreCliente = rs.getString(3);
                String fechaCreacion = rs.getString(4);
                long total = rs.getLong(5);
                String estadoCotizacion = rs.getString(6);

                cotix = new Cotizacion(idCotizacion, fechaCreacion, numeroOT, estadoCotizacion, nombreCliente, total);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cotix;
    }

    public boolean actualizarTotalCotizacion(int idCotizacion, long subTotal) {
        boolean validar = false;
        String sql = "Update Cotizacion set  ";
        sql += "total_cotizacion = ? ";
        sql += "where id_cotizacion = ? ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);           
            cs.setLong(1, subTotal);
            cs.setInt(2, idCotizacion);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                validar = true;
            } else {
                validar = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return validar;
    }

    public ListadoExportarCotizacion retornarDatosCotizacionExportar(int idCotizacionBuscar, int numeroOTBuscar) {
        ListadoExportarCotizacion cotix = null;
        String sql = "Select c.id_cotizacion,c.numero_OT, e.nombre, c.fecha_generacion, c.total_cotizacion, ot.nombre_OT  ";
        sql += "from cotizacion c  ";
        sql += "join ordentrabajo ot  ";
        sql += "ON(c.numero_OT = ot.numero_OT)  ";
        sql += "Join empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa)  ";
        sql += "where c.id_cotizacion = ? and c.numero_OT  = ? ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idCotizacionBuscar);
            ps.setInt(2, numeroOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCotizacion = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String nombreCliente = rs.getString(3);
                String fechaCreacion = rs.getString(4);
                long total = rs.getLong(5);
                String nombreOT = rs.getString(6);

                cotix = new ListadoExportarCotizacion(idCotizacion, numeroOT, nombreCliente, fechaCreacion, total, nombreOT);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cotix;
    }

}
