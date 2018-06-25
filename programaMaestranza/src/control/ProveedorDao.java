/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProveedorDao {

    Conexion conexion;

    public ProveedorDao() {
        conexion = new Conexion();
    }

    public boolean insertarProveedor(String nombre, String giro, String rut, String paginaWeb, String nombreContacto, String telefono, String correo,String nombreBanco,String nroCuentaCorriente) {
        boolean agregado = false;
        String sql = "Insert into Proveedor(rut_empresa,nombre,giro,telefono,nombre_personaContacto,pagina_web,correo_electronico,nombre_banco,nro_cuentaCorriente) ";
        sql += "values(?,?,?,?,?,?,?,?,?);";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, rut);
            cs.setString(2, nombre);
            cs.setString(3, giro);
            cs.setString(4, telefono);
            cs.setString(5, nombreContacto);
            cs.setString(6, paginaWeb);
            cs.setString(7, correo);
            cs.setString(8, nombreBanco);
            cs.setString(9, nroCuentaCorriente);

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

    //rut_empresa,nombre,giro,telefono,nombre_personaContacto,pagina_web,correo_electronico
    public boolean modificarProveedor(String nombre, String giro, String rut, String paginaWeb, String nombreContacto, String telefono, String correo,String nombreBanco,String nroCuentaCorriente) {
        boolean modificado = false;
        rut = rut.trim().replace(".", "");
        rut = rut.toUpperCase();

        String sql = "Update proveedor ";
        sql += "set ";
        sql += "nombre = ? ,";
        sql += "giro = ?  ,";
        sql += "telefono = ?, ";
        sql += "nombre_personaContacto = ? ,";
        sql += "pagina_web = ? , ";
        sql += "correo_electronico= ?,";
        sql += "nombre_banco= ?,";
        sql += "nro_cuentaCorriente= ? ";
        sql += "where rut_empresa = ?; ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, giro);
            cs.setString(3, telefono);
            cs.setString(4, nombreContacto);
            cs.setString(5, paginaWeb);
            cs.setString(6, correo);
            cs.setString(7, nombreBanco);
            cs.setString(8, nroCuentaCorriente);
            cs.setString(9, rut);

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

    public boolean eliminarProveedor(String rut) {
        boolean eliminado = false;
        String sql = "Delete From proveedor ";
        sql += "where rut_empresa = ?; ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, rut);

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

    public boolean validarSiExisteProveedor(String rut) {
        boolean valida = false;
        rut = rut.trim().replace(".", "");
        rut = rut.toUpperCase();
        String sql = "Select rut_empresa From Proveedor ";
        sql += "where rut_empresa = ? ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valida = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return valida;
    }

    public Proveedor rescatarProveedorSegunRut(String rut) {
        Proveedor provedor = null;
        rut = rut.trim().replace(".", "");
        rut = rut.toUpperCase();

        String sql = "Select * From Proveedor ";
        sql += "where rut_empresa = ? ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String telefono = rs.getString(4);
                String nombreContacto = rs.getString(5);
                String paginaWeb = rs.getString(6);
                String correoElectronico = rs.getString(7);
                String nombreBanco = rs.getString(8);
                String nroCuentaCorriente = rs.getString(9);

                provedor = new Proveedor(nombre, giro, rutEmpresa, paginaWeb, nombreContacto, telefono, correoElectronico,nombreBanco,nroCuentaCorriente);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return provedor;
    }

    public ArrayList<Proveedor> rescatarConsultaProveedores(String giroProveedor) {
        ArrayList listado = new ArrayList();
        String sql = "Select rut_empresa,nombre,giro From Proveedor where giro= ?; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, giroProveedor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);

                Proveedor proveedor = new Proveedor(nombre, giro, rutEmpresa);
                listado.add(proveedor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Proveedor> cargarListadoProveedores() {
        ArrayList listado = new ArrayList();
        String sql = "Select rut_empresa,nombre,giro From Proveedor ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);

                Proveedor proveedor = new Proveedor(nombre, giro, rutEmpresa);
                listado.add(proveedor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Proveedor> cargarListadoProveedoresInformacionCompleta() {
        ArrayList listado = new ArrayList();
        String sql = "Select * From Proveedor ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String telefono = rs.getString(4);
                String contacto = rs.getString(5);
                String web = rs.getString(6);
                String correo = rs.getString(7);
                String nombreBanco = rs.getString(8);
                String nroCuentaCorriente = rs.getString(9);

                Proveedor proveedor = new Proveedor(nombre, giro, rutEmpresa, web, contacto, telefono, correo,nombreBanco,nroCuentaCorriente);
                listado.add(proveedor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Proveedor> cargarListadoProveedoresInformacionCompleta(String giroBuscar) {
        ArrayList listado = new ArrayList();
        String sql = "Select * From Proveedor where giro = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, giroBuscar);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String telefono = rs.getString(4);
                String contacto = rs.getString(5);
                String web = rs.getString(6);
                String correo = rs.getString(7);
                String nombreBanco = rs.getString(7);
                String nroCuentaCorriente = rs.getString(7);

                Proveedor proveedor = new Proveedor(nombre, giro, rutEmpresa, web, contacto, telefono, correo,nombreBanco,nroCuentaCorriente);
                listado.add(proveedor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Proveedor> cargarListadoProveedoresInformacionCompletaPorNombre(String nombreEmpresa) {
        ArrayList listado = new ArrayList();
        nombreEmpresa = nombreEmpresa.toUpperCase();
        String sql = "Select * From Proveedor where upper(nombre) like '%' ? '%'; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreEmpresa);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String telefono = rs.getString(4);
                String contacto = rs.getString(5);
                String web = rs.getString(6);
                String correo = rs.getString(7);
                String nombreBanco = rs.getString(8);
                String nroCuentaCorriente = rs.getString(9);

                Proveedor proveedor = new Proveedor(nombre, giro, rutEmpresa, web, contacto, telefono, correo,nombreBanco,nroCuentaCorriente);
                listado.add(proveedor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }
    
    public ArrayList<Proveedor> cargarListadoProveedoresInformacionCompletaPorRut(String rutBuscar) {
        ArrayList listado = new ArrayList();

        rutBuscar = rutBuscar.trim().replace(".", "").toUpperCase();

        String sql = "Select * From Proveedor where rut_empresa like ? '%' ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, rutBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String telefono = rs.getString(4);
                String contacto = rs.getString(5);
                String web = rs.getString(6);
                String correo = rs.getString(7);
                String nombreBanco = rs.getString(8);
                String nroCuentaCorriente = rs.getString(9);

                Proveedor proveedor = new Proveedor(nombre, giro, rutEmpresa, web, contacto, telefono, correo,nombreBanco,nroCuentaCorriente);
                listado.add(proveedor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Proveedor> cargarListadoProveedoresInformacionCompleta(String giroBuscar, String rutBuscar) {
        ArrayList listado = new ArrayList();

        rutBuscar = rutBuscar.trim().replace(".", "").toUpperCase();

        String sql = "Select * From Proveedor where rut_empresa like ? '%' and giro = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, rutBuscar);
            ps.setString(2, giroBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String telefono = rs.getString(4);
                String contacto = rs.getString(5);
                String web = rs.getString(6);
                String correo = rs.getString(7);
                String nombreBanco = rs.getString(8);
                String nroCuentaCorriente = rs.getString(9);

                Proveedor proveedor = new Proveedor(nombre, giro, rutEmpresa, web, contacto, telefono, correo,nombreBanco,nroCuentaCorriente);
                listado.add(proveedor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }
    public ArrayList<String> cargarComboBoxGiroProveedor() {
        ArrayList listado = new ArrayList();
        String sql = "Select giro from proveedor ";
        sql += "group by giro ";
        sql += "order by giro; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String giroEmpresa = rs.getString(1);
                listado.add(giroEmpresa);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

}
