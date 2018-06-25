/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Pedido;
import clase.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alfredo
 */
public class PedidoDao {

    Conexion conexion;

    public PedidoDao() {
        conexion = new Conexion();
    }

    public int obtenerUltimoNroPedido() {
        int numeroPedido = 0;

        String sql = "SELECT id_pedido FROM pedidos order by id_pedido desc limit 1;";
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

    public boolean consultarSiExisteCabeceraPedido(int numeroPedido) {
        boolean existe = false;
        String sql = "SELECT * FROM pedidos where id_pedido = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroPedido);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return existe;

    }

    public boolean validarSiExistePedido(int idPedido) {
        boolean existe = false;
        String sql = "SELECT * FROM pedidos where id_pedido = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idPedido);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return existe;

    }

    public String devolverRutTrabajador(String nombreBuscar) {
        String nombre = "";
        String sql = "Select rut ";
        sql += "from persona  ";
        sql += "where upper(concat(nombre,' ',apellido)) = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreBuscar);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nombre = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return nombre;

    }

    public boolean ingresarCabeceraPedido(int numero_OT, String estadoPedido, String tipoUrgencia, String rut) {
        boolean agregado = false;
        String fechaHoy = this.obtenerFechaHoy();
        String sql = "Insert into pedidos(fecha_generacion,numero_OT,tipo_urgencia,estado_pedido,rut_trabajador)";
        sql += "values(?,?,?,?,?);";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, fechaHoy);
            cs.setInt(2, numero_OT);
            cs.setString(3, tipoUrgencia);
            cs.setString(4, estadoPedido);
            cs.setString(5, rut);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                agregado = true;
            } else {
                agregado = false;
            }

        } catch (Exception e) {
            System.out.println("Error Ingreasr pedido: " + e.getMessage());
        }
        return agregado;
    }

    public boolean eliminarPedido(int idPedido) {
        boolean agregado = false;
        String sql = "Delete from pedidos where id_pedido = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idPedido);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                agregado = true;
            } else {
                agregado = false;
            }

        } catch (Exception e) {
            System.out.println("Error Ingreasr pedido: " + e.getMessage());
        }
        return agregado;
    }

    public String obtenerFechaHoy() {
        Calendar today = Calendar.getInstance();
        Date fechaHoy = today.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fechaStringBase = format.format(fechaHoy);

        return fechaStringBase;
    }

    public ArrayList<Pedido> listadoPedidos() {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select p.id_pedido,p.numero_OT,p.fecha_generacion, p.tipo_urgencia, p.estado_pedido, p.subTotal_pedidos,concat(trabajador.nombre,' ',trabajador.apellido)  ";
        sql += "from pedidos p  ";
        sql += "Join persona trabajador ";
        sql += "ON(p.rut_trabajador = trabajador.rut); ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                long subTotal = rs.getLong(6);
                String nombreCompleto = rs.getString(7);

                Pedido pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto, subTotal);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }
    
    
     public ArrayList<Pedido> listadoPedidosPorNombreSolicita(String nombreBuscar) {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select p.id_pedido,p.numero_OT,p.fecha_generacion, p.tipo_urgencia, p.estado_pedido, p.subTotal_pedidos,concat(trabajador.nombre,' ',trabajador.apellido)  ";
        sql += "from pedidos p  ";
        sql += "Join persona trabajador ";
        sql += "ON(p.rut_trabajador = trabajador.rut)  ";
        sql += "where upper(concat(trabajador.nombre,' ',trabajador.apellido)) like '%' ? '%' ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                long subTotal = rs.getLong(6);
                String nombreCompleto = rs.getString(7);

                Pedido pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto, subTotal);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }
    
    
    
    

    public ArrayList<Pedido> listadoPedidosFiltroOT(int numeroOTBuscar) {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select p.id_pedido,p.numero_OT,p.fecha_generacion, p.tipo_urgencia, p.estado_pedido, p.subTotal_pedidos,concat(trabajador.nombre,' ',trabajador.apellido)  ";
        sql += "from pedidos p  ";
        sql += "Join persona trabajador ";
        sql += "ON(p.rut_trabajador = trabajador.rut) ";
        sql += "where p.numero_OT = ? ";
        sql += "Order by p.fecha_generacion;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                long subTotal = rs.getLong(6);
                String nombreCompleto = rs.getString(7);

                Pedido pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto, subTotal);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }

    //Filtro urgencia con OT 
    public ArrayList<Pedido> listadoPedidosFiltroUrgenciaConOT(int numeroOTBuscar, String urgencia) {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select p.id_pedido,p.numero_OT,p.fecha_generacion, p.tipo_urgencia, p.estado_pedido, p.subTotal_pedidos,concat(trabajador.nombre,' ',trabajador.apellido)  ";
        sql += "from pedidos p  ";
        sql += "Join persona trabajador ";
        sql += "ON(p.rut_trabajador = trabajador.rut) ";
        sql += "where p.numero_OT = ? and p.tipo_urgencia = ? ";
        sql += "Order by p.fecha_generacion;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOTBuscar);
            ps.setString(2, urgencia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                long subTotal = rs.getLong(6);
                String nombreCompleto = rs.getString(7);

                Pedido pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto, subTotal);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }

    //Filtro urgencia sin OT
    public ArrayList<Pedido> listadoPedidosFiltroUrgenciaSinOT(String urgencia) {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select p.id_pedido,p.numero_OT,p.fecha_generacion, p.tipo_urgencia, p.estado_pedido, p.subTotal_pedidos,concat(trabajador.nombre,' ',trabajador.apellido)  ";
        sql += "from pedidos p  ";
        sql += "Join persona trabajador ";
        sql += "ON(p.rut_trabajador = trabajador.rut) ";
        sql += "where p.tipo_urgencia = ? ";
        sql += "Order by p.fecha_generacion;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, urgencia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                long subTotal = rs.getLong(6);
                String nombreCompleto = rs.getString(7);

                Pedido pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto, subTotal);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }

    //Filtro Estado con OT
    public ArrayList<Pedido> listadoPedidosFiltroEstadoConOT(int numeroOTBuscar, String estado) {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select p.id_pedido,p.numero_OT,p.fecha_generacion, p.tipo_urgencia, p.estado_pedido, p.subTotal_pedidos,concat(trabajador.nombre,' ',trabajador.apellido)  ";
        sql += "from pedidos p  ";
        sql += "Join persona trabajador ";
        sql += "ON(p.rut_trabajador = trabajador.rut) ";
        sql += "where p.numero_OT = ? and p.estado_pedido = ? ";
        sql += "Order by p.fecha_generacion;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroOTBuscar);
            ps.setString(2, estado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                long subTotal = rs.getLong(6);
                String nombreCompleto = rs.getString(7);

                Pedido pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto, subTotal);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }

    //Filtro Estado sin OT
    public ArrayList<Pedido> listadoPedidosFiltroEstadoSinOT(String estado) {
        ArrayList listadoPedidos = new ArrayList();
        String sql = "select p.id_pedido,p.numero_OT,p.fecha_generacion, p.tipo_urgencia, p.estado_pedido, p.subTotal_pedidos,concat(trabajador.nombre,' ',trabajador.apellido)  ";
        sql += "from pedidos p  ";
        sql += "Join persona trabajador ";
        sql += "ON(p.rut_trabajador = trabajador.rut) ";
        sql += "where p.estado_pedido = ? ";
        sql += "Order by p.fecha_generacion;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                long subTotal = rs.getLong(6);
                String nombreCompleto = rs.getString(7);

                Pedido pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, nombreCompleto, subTotal);
                listadoPedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        System.out.println("LISTADO PAOS: " + listadoPedidos.toString());
        return listadoPedidos;
    }

    public Pedido obtenerObjetoPedido(int idPedidoBuscar, int numeroOTBuscar) {
        Pedido pedido = null;
        String sql = "Select p.id_pedido, p.numero_OT, p.fecha_generacion , p.tipo_urgencia, p.estado_pedido, upper(concat(pe.nombre,' ',pe.apellido)), upper(ot.nombre_OT), p.subtotal_pedidos, e.nombre   ";
        sql += "from pedidos p   ";
        sql += "join persona pe  ";
        sql += "on(p.rut_trabajador = pe.rut)  ";
        sql += "Join ordentrabajo ot   ";
        sql += "on(p.numero_ot = ot.numero_ot)  ";
        sql += "Join empresa e  ";
        sql += "on(ot.id_empresa  = e.id_empresa)  ";
        sql += "where p.id_pedido = ? and p.numero_OT = ?;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idPedidoBuscar);
            ps.setInt(2, numeroOTBuscar);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int idPedido = rs.getInt(1);
                int numeroOT = rs.getInt(2);
                String fechaGeneracion = rs.getString(3);
                String tipoUrgencia = rs.getString(4);
                String estadoPedido = rs.getString(5);
                String solicita = rs.getString(6);
                String nombreOT = rs.getString(7);                
                long subTotal = rs.getLong(8);                
                String nombreEmpresa = rs.getString(9);

                pedido = new Pedido(idPedido, numeroOT, fechaGeneracion, tipoUrgencia, estadoPedido, solicita, subTotal,nombreOT, nombreEmpresa);
                
            }

        } catch (Exception e) {
            System.out.println("Metodo " + e.getMessage());
        }
        return pedido;
    }

    public boolean modificarCabeceraPedido(String estado, String urgencia, int numeroOT, int idPedido, String rutTrabajador) {
        boolean agregado = false;
        String sql = "Update pedidos set estado_pedido = ?, tipo_urgencia = ?, numero_OT = ?, rut_trabajador = ? ";
        sql += " where id_pedido = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, estado);
            cs.setString(2, urgencia);
            cs.setInt(3, numeroOT);
            cs.setString(4, rutTrabajador);
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

    public boolean modificarSubTotal(long subTotal, int idPedido) {
        boolean agregado = false;
        String sql = "update pedidos ";
        sql += "set ";
        sql += "subTotal_pedidos = ? ";
        sql += "where id_pedido = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setLong(1, subTotal);
            cs.setInt(2, idPedido);

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

}
