/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Persona;
import clase.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class UsuarioDao {

    Conexion conexion;

    public UsuarioDao() {
        conexion = new Conexion();
    }

    public boolean insertarTipoTrabajo(int nroTrabajador, String clave) {
        boolean agregado = false;
        String sql = "Insert into usuario(numero_trabajador,clave) ";
        sql += "values(?,?) ;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, nroTrabajador);
            cs.setString(2, clave);

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

    public boolean modificarUsuario(int nroTrabajador, String clave, int idUsuario) {
        boolean agregado = false;
        String sql = "Update usuario set ";
        sql += "numero_trabajador = ?, ";
        sql += "clave = ?  ";
        sql += "where id_usuario = ? ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, nroTrabajador);
            cs.setString(2, clave);
            cs.setInt(3, idUsuario);

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

    public ArrayList<Persona> cargarNombreNroTrabajador() {
        ArrayList lista = new ArrayList();
        String sql = "Select rut,upper(CONCAT(nombre,' ',apellido)), nro_trabajador ";
        sql += "from persona  ";
        sql += "order by CONCAT(nombre,' ',apellido);";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rut = rs.getString(1);
                String nombre = rs.getString(2);
                int nroTrabajador = rs.getInt(3);

                Persona personita = new Persona(rut, nombre, nroTrabajador);
                lista.add(personita);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Persona> cargarNombreNroTrabajador(String nombreBuscar) {
        ArrayList lista = new ArrayList();
        String sql = "Select rut,upper(CONCAT(nombre,' ',apellido)), nro_trabajador  ";
        sql += "from persona  ";
        sql += "where upper(CONCAT(nombre,' ',apellido)) like '%' ? '%'  ";
        sql += "order by CONCAT(nombre,' ',apellido);";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rut = rs.getString(1);
                String nombre = rs.getString(2);
                int nroTrabajador = rs.getInt(3);
                Persona personita = new Persona(rut, nombre, nroTrabajador);
                lista.add(personita);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Usuario> cargarListaUsuarios() {
        ArrayList lista = new ArrayList();
        String sql = "Select id_usuario,numero_trabajador,clave from usuario";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            //ps.setString(1, nombreBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                int nroTrabajador = rs.getInt(2);
                String clave = rs.getString(3);
                Usuario usuario = new Usuario(idUsuario, nroTrabajador, clave);
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public boolean validarSiExisteUsuarioTrabajador(int nroTrabajador) {
        boolean existe = false;
        String sql = "Select id_usuario from usuario where numero_trabajador = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nroTrabajador);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return existe;
    }

    public boolean validarSiExisteIDUsuario(int numeroUsuario) {
        boolean existe = false;
        String sql = "Select id_usuario from usuario where id_usuario = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return existe;
    }
    
    public int obtenerUltimoIDUsuario() {
        int id = 0;
        String sql = "Select id_usuario from usuario order by id_usuario desc limit 1; ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            // ps.setString(1, nombreBuscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public String obtenerNombreUsuario(int numeroUsuario) {
        String nombreUsuario = "";
        String sql = "Select  upper(CONCAT(nombre,' ',apellido)) ";
        sql += "from persona  ";
        sql += "where nro_trabajador = ?; ";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, numeroUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombreUsuario = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nombreUsuario;
    }

}
