/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Conexion;
import clase.OrdenTrabajoConsulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredo
 */
public class OrdenTrabajoConsultaDao {
    Conexion conexion;

    public OrdenTrabajoConsultaDao() {
        conexion = new Conexion();
    }
    
     public ArrayList<OrdenTrabajoConsulta> obtenerListaAyudaNroOT() {
        ArrayList listadoOTConsulta = new ArrayList();
        String sql = "Select numero_OT, descripcion_OT From ordentrabajo;";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int nroOT = rs.getInt(1);
                String descripcion = rs.getString(2);
                OrdenTrabajoConsulta ot = new OrdenTrabajoConsulta(nroOT, descripcion);
                listadoOTConsulta.add(ot);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listadoOTConsulta;
    }
    
    
}
