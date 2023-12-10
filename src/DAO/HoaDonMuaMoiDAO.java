/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHDM;
import DTO.ConnectionDB;
import DTO.FormatValue;
import DTO.HoaDonMua;
import DTO.NhaCungCap;
import DTO.SanPham;
import GUI.MenuGUI;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private ArrayList<ChiTietHDM> dsCTHDM;
    private ArrayList<String> dsTenNccNewShort;

    public HoaDonMuaMoiDAO() {
        dsCTHDM = new ArrayList<>();
        dsTenNccNewShort = new ArrayList<>();

        createHDMM();
        getDsSanPhamFromDB();
        getDsNccFromDB();
    }

    public void createHDMM() {
        hdm = new HoaDonMua();
        hdm.setTongTien(0);
        String today = LocalDate.now().toString().replaceAll("-", "");
        String sql = "select ma_hoa_don from hoa_don_mua where ma_hoa_don like '%" + today + "%' order by ngay_tao desc limit 1";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs.next()) {
                String mahd = rs.getString(1);
                int number = Integer.parseInt(mahd.substring(mahd.lastIndexOf("N") + 1));
                hdm.setMaHD("HDM" + today + "N" + (number + 1));
            } else {
                hdm.setMaHD("HDM" + today + "N1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SanPham getSanPham(int row) {
        return filteredDsSanPham.get(row);
    }

    public NhaCungCap getNcc(int index) {
        return dsNcc.get(index);
    }

    public ChiTietHDM getCTHDM(int row) {
        return dsCTHDM.get(row);
    }

    public SanPham getSanPhamByMa(String masp) {
        String sql = String.format("select * from san_pham where ma_san_pham = '%s'", masp);
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs.next()) {
                return new SanPham(
                        rs.getString("ma_san_pham"),
                        rs.getString("ten_san_pham"),
                        rs.getString("chat_lieu"),
                        rs.getString("kich_co"),
                        rs.getString("mau_sac"),
                        rs.getInt("gia_ban"),
                        rs.getInt("so_luong"),
                        rs.getInt("trang_thai"),
                        rs.getInt("hien_thi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getDsSanPhamFromDB() {
        dsSanPham = new ArrayList<>();
        String sql = "select * from san_pham where trang_thai = 2 and hien_thi = 1";
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
                        rs.getInt("trang_thai"));
                dsSanPham.add(sp);
            }
            filteredDsSanPham = (ArrayList<SanPham>) dsSanPham.clone();
        } catch (SQLException e) {
        }
    }

    public void getDsNccFromDB() {
        dsNcc = new ArrayList<>();
        String sql = "select * from nha_cung_cap where trang_thai = 1 order by ten_ncc";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                dsNcc.add(new NhaCungCap(
                        rs.getInt("ma_ncc"),
                        rs.getString("ten_ncc")));
            }
        } catch (SQLException e) {
        }
    }

    public void themCTHDM(ChiTietHDM cthdm) {
        dsCTHDM.add(cthdm);
        updateTongTienHDM("add", cthdm);
    }

    public void themCTHDM(int selectedCTHDMIndex, ChiTietHDM cthdm) {
        ChiTietHDM selectedCTHDM = dsCTHDM.get(selectedCTHDMIndex);
        updateTongTienHDM("delete", selectedCTHDM);
        selectedCTHDM.getSanPham()
                .setSoLuong(selectedCTHDM.getSanPham().getSoLuong() + cthdm.getSanPham().getSoLuong());
        selectedCTHDM.setTongTien(selectedCTHDM.getGiaNhap() * selectedCTHDM.getSanPham().getSoLuong());
        updateTongTienHDM("add", selectedCTHDM);
    }

    public void suaCTHDM(int selectedCTHDMIndex, ChiTietHDM cthdmUpdated) {
        ChiTietHDM selectedCTHDM = dsCTHDM.get(selectedCTHDMIndex);
        dsCTHDM.set(selectedCTHDMIndex, cthdmUpdated);
        updateTongTienHDM(selectedCTHDM, cthdmUpdated);
    }

    public void xoaCTHDM(int selectedCTHDMIndex) {
        ChiTietHDM selectedCTHDM = dsCTHDM.get(selectedCTHDMIndex);
        dsCTHDM.remove(selectedCTHDMIndex);
        updateTongTienHDM("delete", selectedCTHDM);
    }

    public void updateTongTienHDM(String action, ChiTietHDM cthdm) {
        switch (action) {
            case "add":
                hdm.setTongTien(hdm.getTongTien() + cthdm.getTongTien());
                break;
            case "delete":
                hdm.setTongTien(hdm.getTongTien() - cthdm.getTongTien());
                break;
        }
    }

    public void updateTongTienHDM(ChiTietHDM cthdm, ChiTietHDM cthdmUpdated) {
        hdm.setTongTien(hdm.getTongTien() - cthdm.getTongTien() + cthdmUpdated.getTongTien());
    }

    public void filteredDsSPByMa(String value) {
        filteredDsSanPham = new ArrayList<>();
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                filteredDsSanPham.add(sp);
            }
        }
    }

    public void filteredDsSPByTen(String value) {
        filteredDsSanPham = new ArrayList<>();
        for (SanPham sp : dsSanPham) {
            if (sp.getTenSP().toLowerCase().contains(value.toLowerCase())) {
                filteredDsSanPham.add(sp);
            }
        }
    }

    public void resetHDM() {
        dsCTHDM = new ArrayList<>();
        this.deleteNewShortNcc();
    }

    public void restoreDSSP() {
        filteredDsSanPham = (ArrayList<SanPham>) dsSanPham.clone();
    }

    public int addNewShortNcc(String tenNcc) {
        dsTenNccNewShort.add(tenNcc);
        String sql = String.format("insert into nha_cung_cap (ten_ncc, trang_thai) values ('%s', 1)",
                tenNcc);
        ConnectionDB con = new ConnectionDB();
        int rowEffected = con.executeUpdate(sql);
        return rowEffected;
    }

    public void deleteNewShortNcc() {
        if (dsTenNccNewShort.size() > 0) {
            String sql = "delete from nha_cung_cap where ";
            for (String tenNcc : dsTenNccNewShort) {
                sql += String.format("ten_ncc = '%s' or ", tenNcc);
            }
            sql = sql.substring(0, sql.length() - 3);
            ConnectionDB con = new ConnectionDB();
            con.executeUpdate(sql);
        }
    }

    public void handleThemHDM() {
        try {
            ConnectionDB con = new ConnectionDB();
            String sql = String.format(
                    "insert into hoa_don_mua (ma_hoa_don, ma_nhan_vien, ngay_tao, tong_tien) " +
                            "values ('%s', '%s', '%s', %s)",
                    hdm.getMaHD(),
                    cua_hang_quan_ao.Cua_hang_quan_ao.nv.getMaNhanVien(),
                    LocalDateTime.now().toString(),
                    hdm.getTongTien());
            con.executeUpdate(sql);
            sql = "";
            sql = "insert into chi_tiet_hoa_don_mua (ma_hoa_don, ma_san_pham, ma_ncc, gia_nhap, so_luong, tong_tien) values ";
            for (ChiTietHDM ct : dsCTHDM) {
                sql += String.format("('%s', '%s', '%s', %s, %s, %s), ",
                        hdm.getMaHD(),
                        ct.getSanPham().getMaSP(),
                        ct.getNcc().getMaNcc(),
                        ct.getGiaNhap(),
                        ct.getSanPham().getSoLuong(),
                        ct.getTongTien());
            }
            sql = sql.substring(0, sql.length() - 2);
            con.executeUpdate(sql);
            dsTenNccNewShort = new ArrayList<>();
            sql = "update san_pham set so_luong = so_luong + case ";
            String rangeCondition = "";
            for (ChiTietHDM ct : dsCTHDM) {
                sql += String.format(
                        "when ma_san_pham = '%s' then %s ",
                        ct.getSanPham().getMaSP(), ct.getSanPham().getSoLuong());
                rangeCondition += String.format("'%s',", ct.getSanPham().getMaSP());
            }
            rangeCondition = rangeCondition.substring(0, rangeCondition.length() - 1);
            sql += String.format("end where ma_san_pham in (%s)", rangeCondition);
            con.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getDsTongSoLuongSPMua () {
        Map<String, Integer> ds = new LinkedHashMap<String, Integer>();
        ConnectionDB con = new ConnectionDB();
        String sql = String.format(
            "select ma_san_pham, sum(so_luong) as tong_so_luong from chi_tiet_hoa_don_mua " + 
            "where ma_hoa_don = '%s' group by ma_san_pham", hdm.getMaHD());
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                ds.put(rs.getString("ma_san_pham"), rs.getInt("tong_so_luong"));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public ArrayList<ChiTietHDM> getDsCTHDM() {
        return dsCTHDM;
    }

    public void setDsCTHDM(ArrayList<ChiTietHDM> dsCTHDM) {
        this.dsCTHDM = dsCTHDM;
    }

}
