/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ConnectionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author BomPC
 */
public class MenuDAO {
    public ArrayList<String> getDsChucNangFromDB (String maNhomQuyen) {
        ArrayList<String> dsChucNang;
        dsChucNang = new ArrayList<>();
        String sql = String.format(
            "select * from chuc_nang join chi_tiet_nhom_quyen on chuc_nang.ma_chuc_nang = chi_tiet_nhom_quyen.ma_chuc_nang where ma_nhom_quyen = '%s'",
            maNhomQuyen);
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs == null) return null;
            while (rs.next()) {
                dsChucNang.add(rs.getString("ten_chuc_nang"));
            }
            return dsChucNang;
        } catch (SQLException e) {
            return null;
        }
    }
}
