/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author josec
 */
public class Conexion {
    Connection con;
    public Connection getConexion(){
        try {
            String db = "jdbc:mysql://localhost:3306/posventa_mvc";
            con = DriverManager.getConnection(db, "root", "");
            return con;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;

    }  
}
