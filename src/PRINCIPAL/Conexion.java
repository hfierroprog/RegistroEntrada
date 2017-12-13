package PRINCIPAL;

import VISTAS.MENU;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private String conurl = "jdbc:sqlserver://localhost:54422;"+"databaseName=REG_PERSONAL;";
    private Connection con = null;
    private ResultSet rs;
    
    MENU m = new MENU();
    
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
            PreparedStatement stmt = con.prepareStatement("INSERT INTO ENTRADA(ID_USUARIO,FECHA,HORA) VALUES(?,?,?)");
            stmt.setInt(1, usuario);
            stmt.setString(2, fecha);
            stmt.setString(3, hora);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet obtenerREG(){
        try {
            Statement st = con.createStatement();
            
            rs = st.executeQuery("SELECT N_USUARIO,FECHA,HORA FROM USUARIO INNER JOIN ENTRADA ON ID = ID_USUARIO");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public boolean verificar(int usuario){
        Boolean resultado = null;
        try {
            Calendar calendario = new GregorianCalendar();
            
            String fechaDB = "";
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT MAX(FECHA) FROM ENTRADA WHERE ID_USUARIO = "+usuario);
            
            while(rs.next()){
                fechaDB = rs.getString(1);
            }
            
            if (fechaDB == m.convertirFecha(calendario.getTime())){
                resultado = false;
            }else{
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
