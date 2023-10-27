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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ConnectionDB {
	private final String db = "cua_hang_quan_ao_db";
	private final String user = "root";
	private final String password = "";
	private String url = String.format("jdbc:mysql://localhost:3306/%s", db);
	private ResultSet rst;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, "MySQL JDBC Driver not found", ex);
		} catch (SQLException e) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, "Connection to MySQL failed", e);
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

	public ResultSet sqlQuery(String querry, Object[] objects) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = con.prepareStatement(querry);
			ResultSet rst;
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pst.setObject(i + 1, objects[i]);
				}
			}
			rst = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Can't get data from " + db + "\n" + e.getLocalizedMessage());
			rst = null;
		}
		return rst;
	}

	public Boolean sqlUpdate(String sql, Object[] objects) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = con.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pst.setObject(i + 1, objects[i]);
				}
			}
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Can't update data into " + db + "\n" + e.getLocalizedMessage());
			return false;
		}
	}
}
