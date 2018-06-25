/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class PersonaDao {

    Conexion conexion;

    public PersonaDao() {
        conexion = new Conexion();
    }

    public boolean insertarTrabajador(String rut, String nombre, String apellido, String cargo, int nroTrabajador, String numeroEmergencia1, String numeroEmergencia2) {
        boolean agregado = false;
        String sql = "Insert into Persona(rut,nombre,apellido,cargo,nro_trabajador,nro_emergencia,nro_emergencia_1)";
        sql += "values(?,?,?,?,?,?,?);";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, rut);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, cargo);
            cs.setInt(5, nroTrabajador);
            cs.setString(6, numeroEmergencia1);
            cs.setString(7, numeroEmergencia2);

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

     public boolean modificarTrabajador(String rut, String nombre, String apellido, String cargo, int nroTrabajador, String numeroEmergencia1, String numeroEmergencia2) {
        boolean agregado = false;
        String sql = "Update Persona set nombre = ?, apellido = ?, cargo = ?, nro_trabajador = ?, nro_emergencia= ?, nro_emergencia_1= ?  ";
        sql += " where rut = ?;";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setString(3, cargo);
            cs.setInt(4, nroTrabajador);
            cs.setString(5, numeroEmergencia1);
            cs.setString(6, numeroEmergencia2);
            cs.setString(7, rut);

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

      public boolean eliminar(String rut) {
        boolean agregado = false;
        String sql = "Delete from Persona  where rut= ? ";        
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, rut);
            
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
    /*Listar todas los Trabajadores*/
    public ArrayList<Persona> lisdoTrabajadores() {
        ArrayList listaTrabajadores = new ArrayList();
        String sql = "Select rut,nombre,apellido,cargo,nro_trabajador,nro_emergencia,nro_emergencia_1  ";
        sql+= "  From Persona Order by nro_trabajador ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rut = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String cargo = rs.getString(4);
                int numeroTrabajador = rs.getInt(5);
                String numeroEmergencia1 = rs.getString(6);
                String numeroEmergencia2 = rs.getString(7);

                Persona persona = new Persona(rut, nombre, apellido, cargo, numeroTrabajador,numeroEmergencia1,numeroEmergencia2);
                //Empresa empresita = new Empresa(rutEmpresa, digitoV, giro, razonSocial, comuna, direccion);
                listaTrabajadores.add(persona);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaTrabajadores;
    }

    /*Listar todas los Trabajadores*/
    public ArrayList<Persona> lisdoTrabajadoresFiltrado(String nombreBuscar) {
         ArrayList listaTrabajadores = new ArrayList();
        String sql = "Select rut,nombre,apellido,cargo,nro_trabajador,nro_emergencia,nro_emergencia_1  ";
        sql+= " From Persona ";
        sql+= " where upper(concat(nombre,'  ',apellido)) like '%' ? '%'  ";
        sql+= " Order by nro_trabajador ;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreBuscar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rut = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String cargo = rs.getString(4);
                int numeroTrabajador = rs.getInt(5);
                String numeroEmergencia1 = rs.getString(6);
                String numeroEmergencia2 = rs.getString(7);

                Persona persona = new Persona(rut, nombre, apellido, cargo, numeroTrabajador,numeroEmergencia1,numeroEmergencia2);
                //Empresa empresita = new Empresa(rutEmpresa, digitoV, giro, razonSocial, comuna, direccion);
                listaTrabajadores.add(persona);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaTrabajadores;
    }     
    
    
}
