/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Project;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HARSHAL
 */
public class ConectionProvider {

    /**
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection getCon() throws ClassNotFoundException, SQLException
    {
       
        String s = System.getProperty("user.home");
        
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/property?zeroDateTimeBehavior=CONVERT_TO_NULL","root","harshal");
        Statement stm = conn.createStatement();
        stm.executeUpdate("create database IF NOT EXISTS tenant");
        return conn;
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,e);
        
        throw e;
    }
    
    }
    
}
