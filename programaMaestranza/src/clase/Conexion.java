package clase;

import java.sql.*;

public class Conexion{

    public Conexion() {
    }
    
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String clave = "misyr2011";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdmaestranzaot","maestranza_misyr",clave);
        }catch(Exception e){
            System.out.println("Mensaje de conexion:"+e.getMessage());
        }
        return con;
    }
    
}