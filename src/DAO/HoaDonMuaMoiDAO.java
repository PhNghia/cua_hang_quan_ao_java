/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHDM;
import DTO.ConnectionDB;
import DTO.SanPham;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author BomPC
 */
public class HoaDonMuaMoiDAO {
    
    private ArrayList<SanPham> dsSanPham;
    private Map dsSoLuongSPMua;
    private ArrayList<ChiTietHDM> dsCTHDM;
    
    public HoaDonMuaMoiDAO () {
        dsSanPham = new ArrayList<>();
        dsSoLuongSPMua = new LinkedHashMap<String, Integer>();
        getDsSanPhamFromDB();
    }
    
    public void getDsSanPhamFromDB () {
        String sql = "select * from san_pham where hien_thi = 1";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString("ma_san_pham"),
                        rs.getString("ten_san_pham"),
                        rs.getString("chat_lieu"),
                        rs.getString("kich_co"),
                        rs.getString("mau_sac"),
                        rs.getInt("gia_nhap"),
                        rs.getInt("gia_ban"),
                        rs.getInt("so_luong"),
                        rs.getInt("trang_thai")
                );
                dsSanPham.add(sp);
                dsSoLuongSPMua.put(sp.getMaSP(), 0);
                
            }
        } catch (SQLException e) {}
    }
    
    private void resetList () {
        dsSoLuongSPMua = new LinkedHashMap<String, Integer>();
        dsCTHDM = new ArrayList<>();
    }

    public ArrayList<SanPham> getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public Map getDsSoLuongSPMua() {
        return dsSoLuongSPMua;
    }

    public void setDsSoLuongSPMua(Map dsSoLuongSPMua) {
        this.dsSoLuongSPMua = dsSoLuongSPMua;
    }

    public ArrayList<ChiTietHDM> getDsCTHDM() {
        return dsCTHDM;
    }

    public void setDsCTHDM(ArrayList<ChiTietHDM> dsCTHDM) {
        this.dsCTHDM = dsCTHDM;
    }
    
}
