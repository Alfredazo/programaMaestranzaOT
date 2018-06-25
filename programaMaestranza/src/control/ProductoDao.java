/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Producto;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class ProductoDao {

    Conexion conexion;

    public ProductoDao() {
        conexion = new Conexion();
    }

    public boolean insertarProducto(String nombre, String descripcion, String unidadMedida, String marca, String modelo, int idTipoProducto, String rutProveedor) {
        boolean agregado = false;
        String sql = "Insert into producto(nombre,descripccion,unidad_medida,marca,modelo,id_tipoProducto,rut_proveedor) ";
        sql += "values(?,?,?,?,?,?,?); ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, descripcion);
            cs.setString(3, unidadMedida);
            cs.setString(4, marca);
            cs.setString(5, modelo);
            cs.setInt(6, idTipoProducto);
            cs.setString(7, rutProveedor);
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

    public boolean modificarProducto(String nombre, String descripcion, String unidadMedida, String marca, String modelo, int idTipoProducto, String rutProveedor, int idProducto) {
        boolean agregado = false;
        String sql = "Update Producto set ";
        sql += "nombre = ?, ";
        sql += "descripccion = ?, ";
        sql += "unidad_medida = ?, ";
        sql += "marca = ?, ";
        sql += "modelo = ?, ";
        sql += "id_tipoProducto = ? ,";
        sql += "rut_proveedor = ? ";
        sql += "where id_producto = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, descripcion);
            cs.setString(3, unidadMedida);
            cs.setString(4, marca);
            cs.setString(5, modelo);
            cs.setInt(6, idTipoProducto);
            cs.setString(7, rutProveedor);
            cs.setInt(8, idProducto);
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

    public boolean eliminarProducto(int idProducto) {
        boolean agregado = false;
        String sql = "Delete from Producto ";
        sql += "where id_producto = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idProducto);
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

    public int obtenerUltimoIDProducto() {
        int valor = 0;
        String sql = "select id_producto from producto order by id_producto desc limit 1; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            //ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valor = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valor;
    }

    public int obtenerIDProductoPorNombre(String nombre) {
        int valor = 0;
        nombre = nombre.toUpperCase();
        String sql = "Select id_producto ";
        sql += "From producto  ";
        sql += "where upper(nombre) = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valor = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valor;
    }
    
    public int obtenerNumeroCategoriaSegunNombre(String nombre) {
        int valor = 0;
        nombre = nombre.toUpperCase();
        String sql = "Select id_tipoProducto ";
        sql += "From tipoProducto  ";
        sql += "where upper(nombre_categoria) = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valor = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valor;
    }

    public boolean validarProductoExiste(int id_producto) {
        boolean validar = false;
        String sql = "select id_producto from producto where id_producto = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, id_producto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                validar = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validar;
    }

    public ArrayList<Producto> obtenerListadoProductos() {
        ArrayList listado = new ArrayList();
        String sql = "Select p.id_producto,p.nombre, p.descripccion,p.unidad_medida,p.marca,p.modelo,t.nombre_categoria, pv.nombre  ";
        sql += "from producto p  ";
        sql += "join tipoProducto t  ";
        sql += "on(p.id_tipoProducto = t.id_tipoProducto)  ";
        sql += "join proveedor pv ";
        sql += "on(p.rut_proveedor = pv.rut_empresa) ";
        sql += "Order by p.id_producto  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String descripcion = rs.getString(3);
                String unidadMedida = rs.getString(4);
                String marca = rs.getString(5);
                String modelo = rs.getString(6);
                String categoria = rs.getString(7);
                String nombreProveedor = rs.getString(8);

                Producto productito = new Producto(idProducto, nombreProducto, descripcion, unidadMedida, marca, modelo, nombreProveedor, categoria);

                listado.add(productito);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public Producto obtenerProductoSegunID(int idProductoBuscar) {
        Producto productitox = null;
        String sql = "Select id_producto,nombre,descripccion,unidad_medida,marca,modelo,id_tipoProducto,rut_proveedor  ";
        sql += "from producto ";
        sql += "where id_producto =  ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idProductoBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String descripcion = rs.getString(3);
                String unidadMedida = rs.getString(4);
                String marca = rs.getString(5);
                String modelo = rs.getString(6);
                int idTipoProducto = rs.getInt(7);
                String rutProveedor = rs.getString(8);

                productitox = new Producto(idProducto, idTipoProducto, nombreProducto, descripcion, unidadMedida, marca, modelo, rutProveedor);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productitox;
    }

    public ArrayList<String> cargarComboBoxProveedores() {
        ArrayList listado = new ArrayList();
        String sql = "Select nombre ";
        sql += "From proveedor  ";
        sql += "group by rut_empresa;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            //ps.setInt(1, idProductoBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                listado.add(nombre);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    public ArrayList<String> cargarComboBoxCategoria() {
        ArrayList listado = new ArrayList();
        String sql = "Select nombre_categoria  ";
        sql+= "from tipoProducto  ";
        sql+= "Group by nombre_categoria  ";
        sql+= "Order by nombre_categoria;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            //ps.setInt(1, idProductoBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                listado.add(nombre);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    public ArrayList<String> cargarComboBoxMarcaProducto() {
        ArrayList listado = new ArrayList();
        String sql ="Select marca  ";
        sql+= "from producto  ";
        sql+= "group by marca  ";
        sql+= "order by marca;  ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            //ps.setInt(1, idProductoBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                listado.add(nombre);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    
    

    public ArrayList<Producto> obtenerListadoProductos(String nombreProveedorBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select p.id_producto,p.nombre, p.descripccion,p.unidad_medida,p.marca,p.modelo,t.nombre_categoria, pv.nombre  ";
        sql += "from producto p  ";
        sql += "join tipoProducto t  ";
        sql += "on(p.id_tipoProducto = t.id_tipoProducto)  ";
        sql += "join proveedor pv ";
        sql += "on(p.rut_proveedor = pv.rut_empresa) ";
        sql += "where pv.nombre = ? ";
        sql += "Order by p.id_producto  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreProveedorBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String descripcion = rs.getString(3);
                String unidadMedida = rs.getString(4);
                String marca = rs.getString(5);
                String modelo = rs.getString(6);
                String categoria = rs.getString(7);
                String nombreProveedor = rs.getString(8);

                Producto productito = new Producto(idProducto, nombreProducto, descripcion, unidadMedida, marca, modelo, nombreProveedor, categoria);

                listado.add(productito);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    
    public ArrayList<Producto> obtenerListadoProductosPorCategoria(String nombreCategoria) {
        ArrayList listado = new ArrayList();
        String sql = "Select p.id_producto,p.nombre, p.descripccion,p.unidad_medida,p.marca,p.modelo,t.nombre_categoria, pv.nombre  ";
        sql += "from producto p  ";
        sql += "join tipoProducto t  ";
        sql += "on(p.id_tipoProducto = t.id_tipoProducto)  ";
        sql += "join proveedor pv ";
        sql += "on(p.rut_proveedor = pv.rut_empresa) ";
        sql += "where t.nombre_categoria = ? ";
        sql += "Order by p.id_producto  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreCategoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String descripcion = rs.getString(3);
                String unidadMedida = rs.getString(4);
                String marca = rs.getString(5);
                String modelo = rs.getString(6);
                String categoria = rs.getString(7);
                String nombreProveedor = rs.getString(8);

                Producto productito = new Producto(idProducto, nombreProducto, descripcion, unidadMedida, marca, modelo, nombreProveedor, categoria);

                listado.add(productito);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

 
public ArrayList<Producto> obtenerListadoProductosPorMarca(String marcaBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select p.id_producto,p.nombre, p.descripccion,p.unidad_medida,p.marca,p.modelo,t.nombre_categoria, pv.nombre  ";
        sql += "from producto p  ";
        sql += "join tipoProducto t  ";
        sql += "on(p.id_tipoProducto = t.id_tipoProducto)  ";
        sql += "join proveedor pv ";
        sql += "on(p.rut_proveedor = pv.rut_empresa) ";
        sql += "where p.marca = ? ";
        sql += "Order by p.id_producto  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, marcaBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String descripcion = rs.getString(3);
                String unidadMedida = rs.getString(4);
                String marca = rs.getString(5);
                String modelo = rs.getString(6);
                String categoria = rs.getString(7);
                String nombreProveedor = rs.getString(8);

                Producto productito = new Producto(idProducto, nombreProducto, descripcion, unidadMedida, marca, modelo, nombreProveedor, categoria);

                listado.add(productito);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    public ArrayList<Producto> obtenerListadoProductosPorNombre(String nombreProductoBuscar) {
        ArrayList listado = new ArrayList();
        nombreProductoBuscar = nombreProductoBuscar.toUpperCase();
        String sql = "Select p.id_producto,p.nombre, p.descripccion,p.unidad_medida,p.marca,p.modelo,t.nombre_categoria, pv.nombre  ";
        sql += "from producto p  ";
        sql += "join tipoProducto t  ";
        sql += "on(p.id_tipoProducto = t.id_tipoProducto)  ";
        sql += "join proveedor pv ";
        sql += "on(p.rut_proveedor = pv.rut_empresa) ";
        sql += "where upper(p.nombre) like '%' ? '%'  ";
        sql += "Order by p.id_producto  ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreProductoBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String descripcion = rs.getString(3);
                String unidadMedida = rs.getString(4);
                String marca = rs.getString(5);
                String modelo = rs.getString(6);
                String categoria = rs.getString(7);
                String nombreProveedor = rs.getString(8);

                Producto productito = new Producto(idProducto, nombreProducto, descripcion, unidadMedida, marca, modelo, nombreProveedor, categoria);

                listado.add(productito);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }


}
