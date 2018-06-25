/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Categoria;
import clase.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class CategoriaDao {

    Conexion conexion;

    public CategoriaDao() {
        conexion = new Conexion();
    }

    public boolean insertarCategoria(String nombreCategoria, String descripcion) {
        boolean agregado = false;
        String sql = "Insert into tipoProducto(nombre_categoria,descripcion)  ";
        sql += "values(?,?);";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, nombreCategoria);
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

    public boolean modificarCategoria(int idCategoria, String nombreCategoria, String descripcion) {
        boolean agregado = false;
        String sql = "Update tipoProducto set  ";
        sql += "nombre_categoria = ? ,";
        sql += "descripcion = ? ";
        sql += "where id_tipoProducto = ?";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, nombreCategoria);
            cs.setString(2, descripcion);
            cs.setInt(3, idCategoria);

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

    public boolean eliminarCategoria(int idCategoria) {
        boolean agregado = false;
        String sql = "Delete from tipoProducto ";
        sql += "where id_tipoProducto = ?";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setInt(1, idCategoria);

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

    public int obtenerIDCategoria() {
        int idCategoria = 0;
        String sql = "Select id_tipoProducto from tipoProducto order by id_tipoProducto desc limit 1; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idCategoria;
    }

    public ArrayList<Categoria> obtenerListadoCategoria() {
        ArrayList listadoCategoria = new ArrayList();
        String sql = "Select * from tipoproducto;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCategoria = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripccion = rs.getString(3);
                Categoria categoria = new Categoria(idCategoria, nombre, descripccion);
                listadoCategoria.add(categoria);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listadoCategoria;
    }
    
     public ArrayList<Categoria> obtenerListadoCategoriaPorNombre(String nombreCategoria) {
        nombreCategoria = nombreCategoria.toUpperCase();
        ArrayList listadoCategoria = new ArrayList();
        String sql = "Select * from tipoproducto  ";
               sql+= "where upper(nombre_categoria) like '%' ? '%';";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreCategoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCategoria = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripccion = rs.getString(3);
                Categoria categoria = new Categoria(idCategoria, nombre, descripccion);
                listadoCategoria.add(categoria);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listadoCategoria;
    }

    public Categoria obtenerDatosCategoria(int idTipoProducto) {
        Categoria categoria = new Categoria();
        String sql = "Select * from tipoproducto where id_tipoProducto = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idTipoProducto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCategoria = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripccion = rs.getString(3);

                categoria = new Categoria(idCategoria, nombre, descripccion);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return categoria;
    }

    public boolean validarSiExiste(int idCategoria) {
        boolean validar = false;
        String sql = "Select * from tipoproducto  where id_tipoProducto = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return validar;
    }

    public int obtenerIDProductoSeleccionado(String nombreProducto) {
        int valor = 0;

        String sql = "select id_producto from producto ";
        sql += "where nombre = ? ";
        sql += "limit 1; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                valor = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return valor;
    }

}
