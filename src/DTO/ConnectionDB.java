/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
    private final String db = "cua_hang_quan_ao_db";
    private final String user = "root";
    private final String password = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = String.format("jdbc:mysql://localhost:3306/%s", db);

            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet executeQuery(String sql) {
        Connection con = getConnection();
        Statement sttm;
        try {
            sttm = con.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
        }
        return null;
    }

    public int executeUpdate(String sql) {
        Connection con = getConnection();
        try {
            Statement sttm = con.createStatement();
            int rowEffect = sttm.executeUpdate(sql);
            return rowEffect;
        } catch (SQLException e) {
            return -1;
        }

    }
}
