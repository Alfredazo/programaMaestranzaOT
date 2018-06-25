/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Cliente;
import clase.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class ClienteDao {

    Conexion conexion;

    public ClienteDao() {
        conexion = new Conexion();
    }

    public boolean insertarCliente(String nombre, String rut, String giro, String direccion, String nombreContacto, String numeroContacto, String telefono) {
        boolean agregado = false;
        int idIncrementable = this.cargarNumeradorIncrementable();
        String sql = "Insert into empresa(nombre,rut,giro_empresa,direccion,nombre_contacto,nro_contacto,nro_empresa) ";
        sql += "values(?,?,?,?,?,?,?); ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, nombre);
            cs.setString(2, rut);
            cs.setString(3, giro);
            cs.setString(4, direccion);
            cs.setString(5, nombreContacto);
            cs.setString(6, numeroContacto);
            cs.setString(7, telefono);

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

    public boolean modificarCliente(String nombre, String rut, String giro, String direccion, String nombreContacto, String numeroContacto, String telefono) {
        boolean modificado = false;
        rut = rut.trim().replace(".", "").toUpperCase();
        String sql = "Update empresa set ";
        sql += "nombre = ? ,";
        sql += "giro_empresa = ?, ";
        sql += "direccion = ?, ";
        sql += "nombre_contacto = ?,";
        sql += "nro_contacto = ?,";
        sql += "nro_empresa = ?  ";
        sql += "Where rut = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, nombre);
            cs.setString(2, giro);
            cs.setString(3, direccion);
            cs.setString(4, nombreContacto);
            cs.setString(5, numeroContacto);
            cs.setString(6, telefono);
            cs.setString(7, rut);

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

    public boolean eliminarCliente(String rutBuscar) {
        rutBuscar = rutBuscar.trim().replace(".", "").toUpperCase();
        boolean eliminado = false;
        int idIncrementable = this.cargarNumeradorIncrementable();
        String sql = "Delete from empresa ";
        sql += "where upper(rut) = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //cs.setInt(1, idIncrementable);
            cs.setString(1, rutBuscar);

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

    public int cargarNumeradorIncrementable() {
        int valor = 0;
        String sql = "select id_empresa from empresa order by id_empresa desc limit 1;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                valor = rs.getInt(1);
                valor = valor + 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valor;
    }

    public ArrayList<Cliente> rescatarConsultaProveedores(String giroCliente) {
        ArrayList listado = new ArrayList();
        String sql = "Select rut, nombre ,giro_empresa From Empresa where giro_empresa= ?; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, giroCliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);

                Cliente clientex = new Cliente(nombre, rutEmpresa, giro);
                listado.add(clientex);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public ArrayList<Cliente> rescatarConsultaProveedores() {
        ArrayList listado = new ArrayList();
        String sql = "Select rut, nombre,giro_empresa From Empresa; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);

                Cliente clientex = new Cliente(nombre, rutEmpresa, giro);
                listado.add(clientex);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public boolean consultarSiExisteRut(String rutBuscar) {
        rutBuscar = rutBuscar.trim().replace(".", "").toUpperCase();
        boolean valida = false;
        String sql = "Select * from empresa where upper(rut) = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, rutBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valida = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valida;
    }

    public ArrayList<String> cargarComboBoxGiroCliente() {
        ArrayList listado = new ArrayList();
        String sql = "Select giro_empresa from empresa ";
        sql += "group by giro_empresa ";
        sql += "order by giro_empresa; ";
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

    public Cliente rescatarConsultaCliente(String rutBuscado) {
        rutBuscado = rutBuscado.trim().replace(".", "").toUpperCase();
        Cliente clientex = null;
        String sql = "Select nombre,rut,giro_empresa,direccion,nombre_contacto,nro_contacto,nro_empresa from empresa where rut = ? ; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, rutBuscado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString(1);
                String rut = rs.getString(2);
                String giro = rs.getString(3);
                String direccion = rs.getString(4);
                String nombre_contacto = rs.getString(5);
                String nro_contacto = rs.getString(6);
                String nro_empresa = rs.getString(7);

                clientex = new Cliente(nombre, rut, giro, direccion, nombre_contacto, nro_contacto, nro_empresa);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clientex;
    }

    public ArrayList<Cliente> rescatarTodosLosClientes() {
        ArrayList listado = new ArrayList();
        String sql = "Select rut , nombre ,giro_empresa,direccion,nro_empresa,nombre_contacto,nro_contacto  ";
        sql += "from empresa;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String direccion = rs.getString(4);
                String nroTelefono = rs.getString(5);
                String contacto = rs.getString(6);
                String nroContacto = rs.getString(7);

                Cliente clientex = new Cliente(nombre, rutEmpresa, giro, direccion, contacto, nroContacto, nroTelefono);
                listado.add(clientex);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public ArrayList<Cliente> rescatarTodosLosClientes(String giroBuscar, String rutBuscar) {
        ArrayList listado = new ArrayList();

        rutBuscar = rutBuscar.trim().replace(".", "").toUpperCase();

        String sql = "Select rut, nombre, giro_empresa, direccion, nro_empresa, nombre_contacto, nro_contacto  ";
        sql += "From empresa where rut like ? '%' and giro_empresa = ?;";
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
                String direccion = rs.getString(4);
                String nroTelefono = rs.getString(5);
                String contacto = rs.getString(6);
                String nroContacto = rs.getString(7);

                Cliente clientex = new Cliente(nombre, rutEmpresa, giro, direccion, contacto, nroContacto, nroTelefono);
                listado.add(clientex);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Cliente> rescatarTodosLosClientesPorGiro(String giroBuscar) {
        ArrayList listado = new ArrayList();

        String sql = "Select rut, nombre, giro_empresa, direccion, nro_empresa, nombre_contacto, nro_contacto  ";
        sql += "From empresa where giro_empresa = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, giroBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String direccion = rs.getString(4);
                String nroTelefono = rs.getString(5);
                String contacto = rs.getString(6);
                String nroContacto = rs.getString(7);

                Cliente clientex = new Cliente(nombre, rutEmpresa, giro, direccion, contacto, nroContacto, nroTelefono);
                listado.add(clientex);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Cliente> rescatarTodosLosClientesPorRUT(String rutBuscar) {
        ArrayList listado = new ArrayList();

        rutBuscar = rutBuscar.trim().replace(".", "").toUpperCase();

        String sql = "Select rut, nombre, giro_empresa, direccion, nro_empresa, nombre_contacto, nro_contacto  ";
        sql += "From empresa where rut like ? '%' ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, rutBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String direccion = rs.getString(4);
                String nroTelefono = rs.getString(5);
                String contacto = rs.getString(6);
                String nroContacto = rs.getString(7);

                Cliente clientex = new Cliente(nombre, rutEmpresa, giro, direccion, contacto, nroContacto, nroTelefono);
                listado.add(clientex);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<Cliente> rescatarTodosLosClientesPorNombre(String nombreEmpresa) {
        ArrayList listado = new ArrayList();
        nombreEmpresa = nombreEmpresa.toUpperCase();
        String sql = "Select rut, nombre, giro_empresa, direccion, nro_empresa, nombre_contacto, nro_contacto   ";
        sql += "From empresa where upper(nombre) like '%' ? '%'; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreEmpresa);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rutEmpresa = rs.getString(1);
                String nombre = rs.getString(2);
                String giro = rs.getString(3);
                String direccion = rs.getString(4);
                String nroTelefono = rs.getString(5);
                String contacto = rs.getString(6);
                String nroContacto = rs.getString(7);

                Cliente clientex = new Cliente(nombre, rutEmpresa, giro, direccion, contacto, nroContacto, nroTelefono);
                listado.add(clientex);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

    public ArrayList<String> cargarComboBoxGiro() {
        ArrayList listado = new ArrayList();
        String sql = "Select giro_empresa  ";
        sql += "from empresa  ";
        sql += "group by giro_empresa  ";
        sql += "order by giro_empresa;  ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String giro = rs.getString(1);
                listado.add(giro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }

}
