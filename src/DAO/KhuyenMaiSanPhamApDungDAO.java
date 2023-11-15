/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ConnectionDB;
import DTO.SanPham;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BomPC
 */
public class KhuyenMaiSanPhamApDungDAO {
    private ArrayList<SanPham> dssp, filteredDssp;
    private ArrayList<SanPham> dsspadkm;
    private Map dsspChecked;

    public KhuyenMaiSanPhamApDungDAO() {
        dsspadkm = new ArrayList<>();
        getSanPhamFromDB();
        dsspChecked = new LinkedHashMap<String, Boolean>();
    }
    
    public void getSanPhamFromDB () {
        dssp = new ArrayList<>();
        String sql = "select ma_san_pham, ten_san_pham, gia_ban, so_luong from san_pham where hien_thi = 1 and trang_thai = 2";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                dssp.add(new SanPham(
                        rs.getString("ma_san_pham"),
                        rs.getString("ten_san_pham"),
                        rs.getInt("gia_ban"),
                        rs.getInt("so_luong")
                ));
            }
            filteredDssp = (ArrayList<SanPham>) dssp.clone();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void checkedSanPham (int row) {
        SanPham checkedSP = filteredDssp.get(row);
        dsspadkm.add(checkedSP);
        dsspChecked.put(checkedSP.getMaSP(), true);
    }
    
    public void uncheckedSanPham (String masp) {
        for (SanPham item : dsspadkm) {
            if (item.getMaSP().equals(masp)) {
                dsspadkm.remove(item);
                break;
            }
        }
        dsspChecked.remove(masp);
    }
    
    public ArrayList<SanPham> getDSSP () {
        return filteredDssp;
    }
    
    public ArrayList<SanPham> getDSSPADKM () {
        return dsspadkm;
    }
    
    public Map getDsspChecked () {
        return dsspChecked;
    }
}
