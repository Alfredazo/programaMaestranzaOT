/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.ListadoTrabajosRealizados;
import clase.TrabajoRealizadoExportacion;
import clase.TrabajosRealizados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class TrabajosRealizadosDao {

    Conexion conexion;

    public TrabajosRealizadosDao() {
        conexion = new Conexion();
    }

    public boolean insertarTrabajosRealizadoCabecera(int numeroOT) {
        boolean agregado = false;
        String sql = "Insert into trabajosRealizados(numero_OT)  ";
        sql += "Values(?); ";

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

    public boolean modificarTrabajosRealizadoCabecera(int numeroOT, int idTrabajosRealizados) {
        boolean modificado = false;
        String sql = "Update trabajosRealizados set  ";
        sql += "numero_OT = ?  ";
        sql += "where id_trabajosRealizados = ? ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, numeroOT);
            cs.setInt(1, idTrabajosRealizados);

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

    public boolean eliminarTrabajosRealizadoCabecera(int idTrabajoRealizado) {
        boolean agregado = false;
        String sql = "Delete from trabajosRealizados where id_trabajosRealizados = ? ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idTrabajoRealizado);

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

    public boolean validarQueNoExistaOTTrabajoRealizadoCabecera(int numeroOT) {
        boolean existe = false;
        String sql = "Select *  ";
        sql += "from trabajosRealizados  ";
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
            System.out.println("Error" + e.getMessage());
        }

        return existe;
    }

    public boolean validarQueNoExistaOTTrabajoRealizadoCabeceraPorID(int idTrabajoRealizado) {
        boolean existe = false;
        String sql = "Select *  ";
        sql += "from trabajosRealizados  ";
        sql += "where id_trabajosRealizados = ?  ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTrabajoRealizado);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return existe;
    }

    public int obtenerUltimoIDTrabajosRealizados() {
        int id = 0;
        String sql = "Select id_trabajosRealizados  ";
        sql += "from trabajosRealizados  ";
        sql += "Order by id_trabajosRealizados desc limit 1 ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return id;
    }

    public long devolverTotalITEMListadoTrabajos(int idTrabajosRealizados) {
        long valor = 0;
        String sql = "Select Sum(subTotal)  ";
        sql += "from listadotrabajosrealizados  ";
        sql += "where id_trabajoRealizado = ? ;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTrabajosRealizados);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valor = rs.getLong(1);
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return valor;
    }

    public boolean eliminarITEMListadoTrabajoRealizados(int idItemListadoTrabajo) {
        boolean agregado = false;
        String sql = "Delete from listadoTrabajosRealizados where id_listadosTR = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idItemListadoTrabajo);

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

    public boolean actualizarTotalTrabajosRealizados(long subTotal, int idTrabajoRealizado) {
        boolean agregado = false;
        String sql = "Update trabajosRealizados  set  ";
        sql += "subTotal_listadoTR =  ?  ";
        sql += "where id_trabajosRealizados = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setLong(1, subTotal);
            cs.setInt(2, idTrabajoRealizado);

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

    public ArrayList<TrabajosRealizados> listadoTrabajosRealizados() {
        ArrayList listado = new ArrayList();
        String sql = "Select tr.id_trabajosRealizados, tr.numero_OT, ot.nombre_OT, e.nombre, tr.subTotal_listadoTR  ";
        sql += "From trabajosrealizados tr  ";
        sql += "Join ordentrabajo ot ";
        sql += "ON(tr.numero_OT = ot.numero_OT)  ";
        sql += "JOIN empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa)  ";
        sql += "order by tr.numero_OT ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTrabajosRealizados = rs.getInt(1);
                int nroOT = rs.getInt(2);
                String nombreOT = rs.getString(3);
                String nombreCliente = rs.getString(4);
                long total = rs.getLong(5);

                TrabajosRealizados tr = new TrabajosRealizados(idTrabajosRealizados, nroOT, nombreOT, nombreCliente, total);
                listado.add(tr);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return listado;
    }
    
    
    public ArrayList<TrabajosRealizados> listadoTrabajosRealizados(int nroOTBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select tr.id_trabajosRealizados, tr.numero_OT, ot.nombre_OT, e.nombre, tr.subTotal_listadoTR  ";
        sql += "From trabajosrealizados tr  ";
        sql += "Join ordentrabajo ot ";
        sql += "ON(tr.numero_OT = ot.numero_OT)  ";
        sql += "JOIN empresa e  ";
        sql += "ON(ot.id_empresa = e.id_empresa)  ";
        sql += "where tr.numero_OT = ? ";
        sql += "order by tr.numero_OT ; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTrabajosRealizados = rs.getInt(1);
                int nroOT = rs.getInt(2);
                String nombreOT = rs.getString(3);
                String nombreCliente = rs.getString(4);
                long total = rs.getLong(5);

                TrabajosRealizados tr = new TrabajosRealizados(idTrabajosRealizados, nroOT, nombreOT, nombreCliente, total);
                listado.add(tr);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return listado;
    }
    

    public TrabajoRealizadoExportacion exportarObjetoTrabajoRealizado(int nroOTBuscar) {
        TrabajoRealizadoExportacion  trexport = null;
        String sql = "Select e.nombre,ot.nombre_ot, ot.nombre_responsable_ot, ot.numero_ot, ot.fecha_inicio, ot.fecha_termino, tr.subTotal_listadoTR  ";
        sql+= "from ordentrabajo ot  ";
        sql+= "Join empresa e  ";
        sql+= "ON(e.id_empresa = ot.id_empresa)  ";
        sql+= "Join trabajosrealizados tr ";
        sql+= "ON(tr.numero_OT = ot.numero_OT)  ";
        sql+= "where ot.numero_ot = ? ;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroOTBuscar);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String nombreCliente = rs.getString(1);
                String nombreOT = rs.getString(2);
                String nombreResponsable = rs.getString(3);
                int nroOT = rs.getInt(4);
                String fechaInicio = rs.getString(5);
                String fechaTermino = rs.getString(6);
                long subTotal = rs.getLong(7);
                 
                trexport = new TrabajoRealizadoExportacion(nombreCliente, nombreOT, nombreResponsable, nroOT, fechaInicio, fechaTermino, subTotal);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return trexport;
    }
    
   
    
    
    
    //Agregar item a la lista
    public boolean insertarITEMListadoTrabajadores(String nombreTrabajo, String descripcion, int idTipoTrabajo, double horasTrabajadas, long subTotal, int idTrabajosRealizados) {
        boolean agregado = false;
        String sql = "Insert into listadoTrabajosRealizados(nombre_trabajo,descripccion,id_tipoTrabajo,horas_ocupadas,subTotal,id_trabajoRealizado)  ";
        sql += "Values(?,?,?,?,?,?) ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, nombreTrabajo);
            cs.setString(2, descripcion);
            cs.setInt(3, idTipoTrabajo);
            cs.setDouble(4, horasTrabajadas);
            cs.setLong(5, subTotal);
            cs.setInt(6, idTrabajosRealizados);

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

    
    public boolean modificarITEMListadoTrabajadores(String nombreTrabajo, String descripcion, int idTipoTrabajo, double horasTrabajadas, long subTotal, int idItemListado) {
        boolean agregado = false;
        String sql = "UPDATE listadoTrabajosRealizados set  ";
        sql+= "nombre_trabajo = ? , ";
        sql+= "descripccion = ? , ";
        sql+= "id_tipoTrabajo = ? , ";
        sql+= "horas_ocupadas = ? , ";
        sql+= "subTotal = ? ";
        sql+= "where id_listadosTR = ? ; ";
        
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, nombreTrabajo);
            cs.setString(2, descripcion);
            cs.setInt(3, idTipoTrabajo);
            cs.setDouble(4, horasTrabajadas);
            cs.setLong(5, subTotal);
            cs.setInt(6, idItemListado);

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
    
    public ArrayList<ListadoTrabajosRealizados> listadoITEMSTrabajosRealizados(int idTrabajosRealizado) {
        ArrayList listado = new ArrayList();
        String sql = "Select lt.id_listadosTR, lt.nombre_trabajo,tp.tipo, d.nombre, lt.horas_ocupadas, tp.valor_horaTrabajo,lt.subTotal,lt.id_trabajoRealizado  ";
        sql += "from listadotrabajosrealizados lt  ";
        sql += "JOIn tipotrabajo tp  ";
        sql += "ON(lt.id_tipoTrabajo = tp.id_tipoTrabajo)  ";
        sql += "JOIN departamento d  ";
        sql += "ON(tp.id_departamento = d.id_departamento)  ";
        sql += "JOIN trabajosrealizados trabajosR  ";
        sql += "ON(trabajosR.id_trabajosRealizados = lt.id_trabajoRealizado)  ";
        sql += "where lt.id_trabajoRealizado = ? ;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTrabajosRealizado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idListadoTrabajosRealizado = rs.getInt(1);
                String nombreTrabajo = rs.getString(2);
                String tipo = rs.getString(3);
                String nombreDpto = rs.getString(4);
                double horasTrabajadas = rs.getDouble(5);
                long valorHora = rs.getLong(6);
                long subTotal = rs.getLong(7);

                ListadoTrabajosRealizados ltr = new ListadoTrabajosRealizados(idListadoTrabajosRealizado, nombreTrabajo, tipo, nombreDpto, horasTrabajadas, valorHora, subTotal);
                listado.add(ltr);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return listado;
    }

    
    public ArrayList<ListadoTrabajosRealizados> listadoITEMSTrabajosRealizadosExportar(int idTrabajosRealizado) {
        ArrayList listado = new ArrayList();
        String sql = "Select lt.id_listadosTR, lt.nombre_trabajo,tp.tipo, d.nombre, lt.horas_ocupadas, tp.valor_horaTrabajo,lt.subTotal,lt.descripccion  ";
        sql += "from listadotrabajosrealizados lt  ";
        sql += "JOIn tipotrabajo tp  ";
        sql += "ON(lt.id_tipoTrabajo = tp.id_tipoTrabajo)  ";
        sql += "JOIN departamento d  ";
        sql += "ON(tp.id_departamento = d.id_departamento)  ";
        sql += "JOIN trabajosrealizados trabajosR  ";
        sql += "ON(trabajosR.id_trabajosRealizados = lt.id_trabajoRealizado)  ";
        sql += "where lt.id_trabajoRealizado = ? ;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTrabajosRealizado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idListadoTrabajosRealizado = rs.getInt(1);
                String nombreTrabajo = rs.getString(2);
                String tipo = rs.getString(3);
                String nombreDpto = rs.getString(4);
                double horasTrabajadas = rs.getDouble(5);
                long valorHora = rs.getLong(6);
                long subTotal = rs.getLong(7);
                String descripcion = rs.getString(8);
                
                ListadoTrabajosRealizados ltr = new ListadoTrabajosRealizados(idListadoTrabajosRealizado, nombreTrabajo, tipo, nombreDpto, horasTrabajadas, valorHora, subTotal,descripcion);
                listado.add(ltr);
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return listado;
    }
    
    
    
    public int obtenerIDTipoTrabajoItemListado(String nombreDpto) {
        int idTipo = 0;
        nombreDpto = nombreDpto.toUpperCase();
        String sql = "Select tp.id_tipoTrabajo , d.nombre  ";
        sql+= "From tipotrabajo tp  ";
        sql+= "Join departamento d  ";
        sql+= "ON(tp.id_departamento = d.id_departamento)  ";
        sql+= "where upper(d.nombre) = ? ;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreDpto);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                 idTipo = rs.getInt(1);
                
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return idTipo;
    }

    public String obtenerDescripcion(int idListados) {
        String descripcion = "";        
        String sql = "Select descripccion ";
        sql+= "from listadotrabajosrealizados where id_listadosTR= ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idListados);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                descripcion = rs.getString(1);                
            }

        } catch (Exception e) {
            System.out.println("Error ObtenerUltimoNroPedido" + e.getMessage());
        }
        return descripcion;
    }
    
    
}
