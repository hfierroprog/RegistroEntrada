package PRINCIPAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private String conurl = "jdbc:sqlserver://localhost:54422;"+"databaseName=REG_PERSONAL;";
    private Connection con = null;
    
    public Conexion(){
        
    }
    
    public Connection Conectar(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try{
                con = DriverManager.getConnection(conurl,"sa","root");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error! 01, no se logró conectar a la base de datos!, EX:"+ex);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error! 02, clase no encontrada. EX:"+ex);
        }
        
        return con;
    }
    
    public void Desconectar(){
        try {
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error! 03, no se logró desconectar de la base de datos"+ ex);
        }
    }
    
    public void insertarReg(String fecha,String hora,int usuario){
        try {
            Statement statement = con.createStatement();
            
            statement.executeUpdate("INSERT INTO ENTRADA()");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}