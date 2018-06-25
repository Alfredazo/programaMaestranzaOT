/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.ProductoExport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class ProductoExportDao {

    Conexion conexion;

    public ProductoExportDao() {
        conexion = new Conexion();
    }

    public ArrayList<ProductoExport> listadoProductos() {
        ArrayList listado = new ArrayList();
        
        String sql = "Select p.id_producto, p.nombre, pro.nombre,min(lp.precio_unitario),max(lp.precio_unitario)  ";
        sql+= "from producto p  ";
        sql+= "JOIN proveedor pro  ";
        sql+= "ON(p.rut_proveedor = pro.rut_empresa)  ";
        sql+= "JOIN listadopedidos lp  ";
        sql+= "ON(lp.id_producto = p.id_producto)  ";
        sql+= "JOIN pedidos pe  ";
        sql+= "ON(lp.id_pedido = lp.id_pedido)  ";
        sql+= "group by p.nombre  ";
        sql+= "Order by p.nombre;  ";
        
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String nombreProveedor =  rs.getString(3);
                long precioMinimo =  rs.getLong(4);
                long precioMaximo = rs.getLong(5);               
             
                ProductoExport prod = new ProductoExport(idProducto, nombreProducto, nombreProveedor, precioMinimo, precioMaximo);
                listado.add(prod);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    
    public ArrayList<ProductoExport> listadoProductos(String nombreProductoBuscar) {
        ArrayList listado = new ArrayList();
        
        String sql = "Select p.id_producto, p.nombre, pro.nombre,min(lp.precio_unitario),max(lp.precio_unitario)  ";
        sql+= "from producto p  ";
        sql+= "JOIN proveedor pro  ";
        sql+= "ON(p.rut_proveedor = pro.rut_empresa)  ";
        sql+= "JOIN listadopedidos lp  ";
        sql+= "ON(lp.id_producto = p.id_producto)  ";
        sql+= "JOIN pedidos pe  ";
        sql+= "ON(lp.id_pedido = lp.id_pedido)  ";
        sql+= "Where upper(p.nombre) like '%' ? '%' ";
        sql+= "group by p.nombre  ";
        sql+= "Order by p.nombre;  ";
        
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreProductoBuscar);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idProducto = rs.getInt(1);
                String nombreProducto = rs.getString(2);
                String nombreProveedor =  rs.getString(3);
                long precioMinimo =  rs.getLong(4);
                long precioMaximo = rs.getLong(5);               
             
                ProductoExport prod = new ProductoExport(idProducto, nombreProducto, nombreProveedor, precioMinimo, precioMaximo);
                listado.add(prod);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    
}
