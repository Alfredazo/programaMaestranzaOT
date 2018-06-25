/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Departamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class DepartamentoDao {

    Conexion conexion;

    public DepartamentoDao() {
        conexion = new Conexion();
    }

    public boolean insertarDepartamento(String nombreDepartamento, String descripcion) {
        boolean agregado = false;
        String sql = "Insert into departamento(nombre,descripccion)  ";
        sql += "values(?,?);";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, nombreDepartamento);
            cs.setString(2, descripcion);

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

    public boolean modificarDepartamento(int idDepartamento, String nombreDepartamento, String descripcion) {
        boolean agregado = false;
        String sql = "Update departamento set ";
        sql += "nombre = ?,  ";
        sql += "descripccion = ?  ";
        sql += "where id_departamento = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, nombreDepartamento);
            cs.setString(2, descripcion);
            cs.setInt(3, idDepartamento);

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

    public boolean eliminarDepartamento(int idDepartamento) {
        boolean eliminado = false;
        String sql = "Delete from departamento ";
        sql += "where id_departamento = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idDepartamento);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                eliminado = true;
            } else {
                eliminado = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }

    public ArrayList<Departamento> rescatarTodosLosDepartamentos() {
        ArrayList listado = new ArrayList();
        String sql = "Select id_departamento, nombre,descripccion ";
        sql += "from departamento ";
        sql += "Order by id_departamento; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDepto = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);

                Departamento departamentox = new Departamento(idDepto, nombre, descripcion);
                listado.add(departamentox);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public ArrayList<Departamento> rescatarTodosLosDepartamentos(String nombreBuscar) {
        ArrayList listado = new ArrayList();
        nombreBuscar = nombreBuscar.trim().toUpperCase();
        String sql = "Select id_departamento, nombre,descripccion ";
        sql += "from departamento ";
        sql += "where upper(nombre) like '%' ? '%' ";
        sql += "Order by id_departamento; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDepto = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);

                Departamento departamentox = new Departamento(idDepto, nombre, descripcion);
                listado.add(departamentox);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public Departamento rescatarDepartamentos(int idDepartamento) {
        Departamento departamento = null;
        String sql = "Select id_departamento, nombre,descripccion ";
        sql += "from departamento ";
        sql += "where id_departamento = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idDepartamento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idDepto = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                departamento = new Departamento(idDepto, nombre, descripcion);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return departamento;
    }

    public int obtenerIDDepartamento() {
        int idDepartamento = 0;
        String sql = "Select id_departamento from departamento order by id_departamento desc limit 1; ";
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

    public boolean validarSiExiste(int idDepto) {
        boolean validar = false;
        String sql = "Select id_departamento from departamento  ";
        sql += "where id_departamento = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idDepto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validar;
    }

    public ArrayList<String> rescatarNombresDeptoComboBox() {
        ArrayList listado = new ArrayList();
        String sql = "Select nombre from departamento ";
        sql += "group by nombre ";
        sql += "order by nombre; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreDepto = rs.getString(1);
                listado.add(nombreDepto);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    /**/

}
