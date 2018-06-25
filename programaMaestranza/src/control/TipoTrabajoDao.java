/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.TipoTrabajo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class TipoTrabajoDao {

    Conexion conexion;

    public TipoTrabajoDao() {
        conexion = new Conexion();
    }

    public boolean insertarTipoTrabajo(String tipoTrabajo, int idDepartamento, long valorHora) {
        boolean agregado = false;
        String sql = "Insert into tipoTrabajo(tipo,id_departamento,valor_horaTrabajo) ";
        sql += "values(?,?,?) ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, tipoTrabajo);
            cs.setInt(2, idDepartamento);
            cs.setLong(3, valorHora);

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

    public boolean modificarTipoTrabajo(String tipoTrabajo, int idDepartamento, long valorHora, int idTipoTrabajo) {
        boolean agregado = false;
        String sql = "Update tipoTrabajo set  ";
        sql += "tipo = ? , ";
        sql += "id_departamento = ? , ";
        sql += "valor_horaTrabajo = ? ";
        sql += "where id_tipoTrabajo = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, tipoTrabajo);
            cs.setInt(2, idDepartamento);
            cs.setLong(3, valorHora);
            cs.setInt(4, idTipoTrabajo);

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

    public boolean eliminarTipoTrabajo(int idTipoTrabajo) {
        boolean agregado = false;
        String sql = "Delete from tipoTrabajo ";
        sql += "where id_tipoTrabajo = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idTipoTrabajo);

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

    public int obtenerIDDepartamento() {
        int idDepartamento = 0;
        String sql = "Select id_tipoTrabajo from tipoTrabajo order by id_tipoTrabajo desc limit 1; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idDepartamento = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idDepartamento;
    }

    public int obtenerIDDepartamento(String nombreDepto) {
        int idDepartamento = 0;
        nombreDepto = nombreDepto.trim().toUpperCase();

        String sql = "Select id_departamento ";
        sql += "from departamento  ";
        sql += "where upper(nombre) = ?  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreDepto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idDepartamento = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idDepartamento;
    }

    public boolean validarSiExisteTipoTrabajo(int idTipoTrabajo) {
        boolean validar = false;
        String sql = "Select * from tipoTrabajo ";
        sql += "where id_tipoTrabajo = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTipoTrabajo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validar;
    }

    public ArrayList<TipoTrabajo> obtenerListadoTipoTrabajo() {
        ArrayList listadoCategoria = new ArrayList();
        String sql = "Select t.id_tipoTrabajo, t.tipo,t.id_departamento,t.valor_horaTrabajo,d.nombre ";
        sql += "from tipoTrabajo t  ";
        sql += "join departamento d ";
        sql += "on(t.id_departamento = d.id_departamento); ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTipoTrabajo = rs.getInt(1);
                String tipoTrabajo = rs.getString(2);
                int idDepartamento = rs.getInt(3);
                long valorHora = rs.getLong(4);
                String nombreDepto = rs.getString(5);
                TipoTrabajo tipox = new TipoTrabajo(idTipoTrabajo, idDepartamento, tipoTrabajo, valorHora, nombreDepto);
                listadoCategoria.add(tipox);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listadoCategoria;
    }

    public ArrayList<TipoTrabajo> obtenerListadoTipoTrabajo(String nombreDeptoBuscar) {
        ArrayList listadoCategoria = new ArrayList();
        String sql = "Select t.id_tipoTrabajo, t.tipo,t.id_departamento,t.valor_horaTrabajo,d.nombre ";
        sql += "from tipoTrabajo t  ";
        sql += "join departamento d ";
        sql += "on(t.id_departamento = d.id_departamento) ";
        sql += "where d.nombre = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreDeptoBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTipoTrabajo = rs.getInt(1);
                String tipoTrabajo = rs.getString(2);
                int idDepartamento = rs.getInt(3);
                long valorHora = rs.getLong(4);
                String nombreDepto = rs.getString(5);
                TipoTrabajo tipox = new TipoTrabajo(idTipoTrabajo, idDepartamento, tipoTrabajo, valorHora, nombreDepto);
                listadoCategoria.add(tipox);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listadoCategoria;
    }

    public TipoTrabajo obtenerTipoTrabajo(int idTipo) {
        TipoTrabajo tipox = null;
        String sql = "Select t.id_tipoTrabajo, t.tipo,t.id_departamento,t.valor_horaTrabajo,d.nombre ";
        sql += "from tipoTrabajo t  ";
        sql += "join departamento d ";
        sql += "on(t.id_departamento = d.id_departamento) ";
        sql += "where t.id_tipoTrabajo = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idTipoTrabajo = rs.getInt(1);
                String tipoTrabajo = rs.getString(2);
                int idDepartamento = rs.getInt(3);
                long valorHora = rs.getLong(4);
                String nombreDepto = rs.getString(5);
                tipox = new TipoTrabajo(idTipoTrabajo, idDepartamento, tipoTrabajo, valorHora, nombreDepto);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return tipox;
    }
    
    public long obtenerValorHoraTipoTrabajo(int idTipo) {
        long valorHora = 0;
        String sql = "Select valor_horaTrabajo  ";
        sql += "from tipoTrabajo ";
        sql += "where id_tipoTrabajo = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valorHora = rs.getLong(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return valorHora;
    }
    
    

}
