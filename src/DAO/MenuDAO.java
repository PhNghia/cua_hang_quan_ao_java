/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChucNang;
import DTO.ConnectionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author BomPC
 */
public class MenuDAO {
    public ArrayList<ChucNang> getDsChucNangFromDB(String maNhomQuyen) {
        ArrayList<ChucNang> dsChucNang;
        dsChucNang = new ArrayList<>();
        String sql = String.format(
                "select chuc_nang.ma_chuc_nang, ten_chuc_nang, icon from chuc_nang join chi_tiet_nhom_quyen on " +
                        "chuc_nang.ma_chuc_nang = chi_tiet_nhom_quyen.ma_chuc_nang " +
                        "where ma_nhom_quyen = '%s' group by chuc_nang.ma_chuc_nang, ten_chuc_nang, icon order by ten_chuc_nang",
                maNhomQuyen);
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs == null)
                return null;
            while (rs.next()) {
                dsChucNang.add(new ChucNang(
                        rs.getInt("ma_chuc_nang"),
                        rs.getString("ten_chuc_nang"),
                        rs.getString("icon")));
            }
            return dsChucNang;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<String> getDsHanhDongFromDB(String maNhomQuyen, String chucNang) {
        ArrayList<String> dsHanhDong = new ArrayList<>();
        String sql = String.format(
                "select hanh_dong " + 
                "from chi_tiet_nhom_quyen join chuc_nang on chi_tiet_nhom_quyen.ma_chuc_nang = chuc_nang.ma_chuc_nang " +
                "where ma_nhom_quyen = '%s' and ten_chuc_nang = '%s'",
                maNhomQuyen, chucNang);
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs == null)
                return null;
            while (rs.next()) {
                dsHanhDong.add(rs.getString(1));
            }
            return dsHanhDong;
        } catch (SQLException e) {
            return null;
        }
    }
}
