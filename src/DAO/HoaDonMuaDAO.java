/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHDM;
import DTO.ConnectionDB;
import DTO.HoaDonMua;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.SanPham;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.sql.SQLException;

/**
 *
 * @author BomPC
 */
public class HoaDonMuaDAO {
    private ArrayList<HoaDonMua> dsHDM;
    private ArrayList<ChiTietHDM> dsCTHDM;

    public HoaDonMuaDAO() {
        dsHDM = new ArrayList<>();
        getDsHDMFromDB();
    }
    
    public void getDsHDMFromDB () {
        String sql = "select * from hoa_don_mua join nhan_vien " + 
                "on hoa_don_mua.ma_nhan_vien = nhan_vien.ma_nhan_vien limit 100";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                dsHDM.add(new HoaDonMua(
                        rs.getString("ma_hoa_don"),
                        new NhanVien(
                                rs.getInt("ma_nhan_vien"),
                                rs.getString("ten_nhan_vien")
                        ),
                        LocalDateTime.parse(rs.getString("ngay_tao").replace(" ","T")),
                        rs.getInt("tong_tien")
                ));
            }
        } catch (SQLException e) {}
    }
    
    public ArrayList<ChiTietHDM> getDsCTHDMFromDB (int row) {
        dsCTHDM = new ArrayList<>();
        HoaDonMua hdmSelected = this.dsHDM.get(row);
        String sql = "select hoa_don_mua.ma_hoa_don, nha_cung_cap.ma_ncc, ten_ncc, san_pham.ma_san_pham, san_pham.ten_san_pham, " + 
                "chi_tiet_hoa_don_mua.gia_nhap, chi_tiet_hoa_don_mua.so_luong, loi_nhuan, chi_tiet_hoa_don_mua.tong_tien " +
                "from hoa_don_mua join chi_tiet_hoa_don_mua " +
                "on hoa_don_mua.ma_hoa_don = chi_tiet_hoa_don_mua.ma_hoa_don " +
                "join nha_cung_cap on chi_tiet_hoa_don_mua.ma_ncc = nha_cung_cap.ma_ncc " +
                "join san_pham on chi_tiet_hoa_don_mua.ma_san_pham = san_pham.ma_san_pham " +
                "where hoa_don_mua.ma_hoa_don = '" + hdmSelected.getMaHD() + "'";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                dsCTHDM.add(new ChiTietHDM(
                        rs.getString("ma_hoa_don"),
                        new NhaCungCap(
                                rs.getString("ma_ncc"),
                                rs.getString("ten_ncc")
                        ),
                        new SanPham(
                                rs.getString("ma_san_pham"),
                                rs.getString("ten_san_pham"),
                                rs.getInt("gia_nhap"),
                                0,
                                rs.getInt("so_luong")
                        ),
                        rs.getFloat("loi_nhuan"),
                        rs.getInt("tong_tien")
                ));
            }
        } catch (SQLException e) {}
        return dsCTHDM;
    }

    public ArrayList<HoaDonMua> getDsHDM() {
        return dsHDM;
    }

    public void setDsHDM(ArrayList<HoaDonMua> dsHDM) {
        this.dsHDM = dsHDM;
    }

    public ArrayList<ChiTietHDM> getDsCTHDM() {
        return dsCTHDM;
    }

    public void setDsCTHDM(ArrayList<ChiTietHDM> dsCTHDM) {
        this.dsCTHDM = dsCTHDM;
    }
    
}
