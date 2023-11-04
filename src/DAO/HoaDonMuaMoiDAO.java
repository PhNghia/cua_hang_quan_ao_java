/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHDM;
import DTO.ConnectionDB;
import DTO.HoaDonMua;
import DTO.NhaCungCap;
import DTO.SanPham;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author BomPC
 */
public class HoaDonMuaMoiDAO {
    
    private HoaDonMua hdm;
    private ArrayList<SanPham> dsSanPham;
    private ArrayList<SanPham> filteredDsSanPham;
    private ArrayList<NhaCungCap> dsNcc;
    private Map dsTongSoLuongSPMua;
    private ArrayList<ChiTietHDM> dsCTHDM;
    
    public HoaDonMuaMoiDAO () {
        dsSanPham = new ArrayList<>();
        dsNcc = new ArrayList<>();
        dsTongSoLuongSPMua = new LinkedHashMap<String, Integer>();
        dsCTHDM = new ArrayList<>();
        
        createHDMM();
        getDsSanPhamFromDB();
        getDsNccFromDB();
    }
    
    public void createHDMM () {
        hdm = new HoaDonMua();
        hdm.setTongTien(0);
        String today = LocalDate.now().toString().replaceAll("-", "");
        String sql = 
                "select ma_hoa_don from hoa_don_mua where ma_hoa_don like '%" + 
                today + 
                "%' order by ma_hoa_don desc limit 1";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs.next()) {
                String mahd = rs.getString("ma_hoa_don");
                int number = Integer.parseInt(mahd.substring(mahd.indexOf("N") + 1, mahd.length()));
                hdm.setMaHD("HDM" + today + "N" + (number + 1));
            } else {
                hdm.setMaHD("HDM" + today + "N1");
            }
        } catch (SQLException e) {}
    }
    
    public SanPham getSanPham (int row) {
        return filteredDsSanPham.get(row);
    }
    
    public NhaCungCap getNcc (int index) {
        return dsNcc.get(index);
    }
    
    public ChiTietHDM getCTHDM (int row) {
        return dsCTHDM.get(row);
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
                        rs.getInt("gia_ban"),
                        rs.getInt("so_luong"),
                        rs.getInt("trang_thai")
                );
                dsSanPham.add(sp);
            }
            filteredDsSanPham = (ArrayList<SanPham>)  dsSanPham.clone();
        } catch (SQLException e) {}
    }
    
    public void getDsNccFromDB () {
        String sql = "select * from nha_cung_cap where hien_thi = 1";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                dsNcc.add(new NhaCungCap(
                        rs.getInt("ma_ncc"),
                        rs.getString("ten_ncc")
                ));
            }
        } catch (SQLException e) {}
    }
    
    public void themCTHDM (ChiTietHDM cthdm) {
        dsCTHDM.add(cthdm);
        updateTongTienHDM("add", cthdm);
    }
    
    public void suaCTHDM (int selectedCTHDMIndex, ChiTietHDM cthdmUpdated) {
        ChiTietHDM selectedCTHDM = dsCTHDM.get(selectedCTHDMIndex);
        dsCTHDM.set(selectedCTHDMIndex, cthdmUpdated);
        updateTongTienHDM(selectedCTHDM, cthdmUpdated);
    }
    
    public void xoaCTHDM (int selectedCTHDMIndex) {
        ChiTietHDM selectedCTHDM = dsCTHDM.get(selectedCTHDMIndex);
        dsCTHDM.remove(selectedCTHDMIndex);
        updateTongTienHDM("delete", selectedCTHDM);
    }
    
    public void updateTongTienHDM (String action, ChiTietHDM cthdm) {
        switch (action) {
            case "add":
                hdm.setTongTien(hdm.getTongTien() + cthdm.getTongTien());
                break;
            case "delete":
                hdm.setTongTien(hdm.getTongTien() - cthdm.getTongTien());
                break;
        }
    }
    
    public void updateTongTienHDM (ChiTietHDM cthdm, ChiTietHDM cthdmUpdated) {
        hdm.setTongTien(hdm.getTongTien() - cthdm.getTongTien() + cthdmUpdated.getTongTien());
    }
    
    public void filteredDsSPByMa (String value) {
        filteredDsSanPham = new ArrayList<>();
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                filteredDsSanPham.add(sp);
            }
        }
    }
    
    public void filteredDsSPByTen (String value) {
        filteredDsSanPham = new ArrayList<>();
        for (SanPham sp : dsSanPham) {
            if (sp.getTenSP().toLowerCase().contains(value.toLowerCase())) {
                filteredDsSanPham.add(sp);
            }
        }
    }
    private void resetList () {
        dsTongSoLuongSPMua = new LinkedHashMap<String, Integer>();
        dsCTHDM = new ArrayList<>();
    }
    
    public void restoreDSSP () {
        filteredDsSanPham = (ArrayList<SanPham>) dsSanPham.clone();
    }

    public HoaDonMua getHDM() {
        return hdm;
    }

    public void setHDM(HoaDonMua hdm) {
        this.hdm = hdm;
    }

    public ArrayList<SanPham> getDsSanPham() {
        return filteredDsSanPham;
    }

    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.filteredDsSanPham = dsSanPham;
    }

    public ArrayList<NhaCungCap> getDsNcc() {
        return dsNcc;
    }

    public void setDsNcc(ArrayList<NhaCungCap> dsNcc) {
        this.dsNcc = dsNcc;
    }

    public Map getDsTongSoLuongSPMua() {
        return dsTongSoLuongSPMua;
    }

    public void setDsTongSoLuongSPMua(Map dsTongSoLuongSPMua) {
        this.dsTongSoLuongSPMua = dsTongSoLuongSPMua;
    }

    public ArrayList<ChiTietHDM> getDsCTHDM() {
        return dsCTHDM;
    }

    public void setDsCTHDM(ArrayList<ChiTietHDM> dsCTHDM) {
        this.dsCTHDM = dsCTHDM;
    }
    
}
