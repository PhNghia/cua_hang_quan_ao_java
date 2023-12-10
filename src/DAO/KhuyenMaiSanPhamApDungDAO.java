/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ConnectionDB;
import DTO.DotKhuyenMai;
import DTO.SanPham;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BomPC
 */
public class KhuyenMaiSanPhamApDungDAO {
    private ArrayList<SanPham> dssp, filteredDssp;
    private Map<String, SanPham> dsspadkm;
    private DotKhuyenMai dotKM;

    public KhuyenMaiSanPhamApDungDAO(DotKhuyenMai dotKM) {
        this.dotKM = dotKM;
        getSanPhamFromDB();
        getDSSPADKMFromDB();
    }

    public void getSanPhamFromDB() {
        dssp = new ArrayList<SanPham>();
        String sql = String.format("select *\r\n" + //
                "from san_pham\r\n" + //
                "where hien_thi = 1 and trang_thai = 2 and not exists (\r\n" + //
                "\tselect *\r\n" + //
                "    from chi_tiet_khuyen_mai, dot_khuyen_mai\r\n" + //
                "    where chi_tiet_khuyen_mai.id_dot_khuyen_mai = dot_khuyen_mai.id_dot_khuyen_mai and \r\n" + //
                "    chi_tiet_khuyen_mai.ma_san_pham = san_pham.ma_san_pham and\r\n" + //
                "    dot_khuyen_mai.id_dot_khuyen_mai != %s and\r\n" + //
                "    dot_khuyen_mai.trang_thai != 0 and \r\n" + //
                "    ('%s' <= dot_khuyen_mai.ngay_ket_thuc and\r\n" + //
                "     '%s' >= dot_khuyen_mai.ngay_bat_dau)\r\n" + //
                ")\r\n" + //
                "order by ma_san_pham", dotKM.getIdDotKm(), dotKM.getNgayBatDau().toString(), dotKM.getNgayKetThuc().toString());
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                dssp.add(new SanPham(
                        rs.getString("ma_san_pham"),
                        rs.getString("ten_san_pham"),
                        rs.getInt("gia_ban"),
                        rs.getInt("so_luong")));
            }
            filteredDssp = (ArrayList<SanPham>) dssp.clone();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDSSPADKMFromDB() {
        dsspadkm = new LinkedHashMap<String, SanPham>();
        ConnectionDB condb = new ConnectionDB();
        String sql = "select khuyen_mai.ma_khuyen_mai, khuyen_mai.ten_khuyen_mai, " +
                "dot_khuyen_mai.ngay_bat_dau, dot_khuyen_mai.ngay_ket_thuc, dot_khuyen_mai.gia_tri, " +
                "san_pham.ma_san_pham, san_pham.ten_san_pham, san_pham.gia_ban " +
                "from khuyen_mai join dot_khuyen_mai on khuyen_mai.ma_khuyen_mai = dot_khuyen_mai.ma_khuyen_mai " +
                "join chi_tiet_khuyen_mai on dot_khuyen_mai.id_dot_khuyen_mai = chi_tiet_khuyen_mai.id_dot_khuyen_mai "
                +
                "join san_pham on chi_tiet_khuyen_mai.ma_san_pham = san_pham.ma_san_pham " +
                "where dot_khuyen_mai.id_dot_khuyen_mai = " + dotKM.getIdDotKm() + " " +
                "order by san_pham.ma_san_pham";
        ResultSet rs = condb.executeQuery(sql);
        try {
            while (rs.next()) {
                dsspadkm.put(
                        rs.getString("ma_san_pham"),
                        new SanPham(
                                rs.getString("ma_san_pham"),
                                rs.getString("ten_san_pham"),
                                rs.getInt("gia_ban") - (int) Math
                                        .floor((float) (rs.getInt("gia_ban") * rs.getFloat("gia_tri")) / (float) 100),
                                0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changedDSSPADKMIntoDB() {
        ConnectionDB condb = new ConnectionDB();
        String sql = "delete from chi_tiet_khuyen_mai where id_dot_khuyen_mai = " + dotKM.getIdDotKm();
        condb.executeUpdate(sql);
        sql = "insert into chi_tiet_khuyen_mai (id_dot_khuyen_mai, ma_san_pham) values ";
        for (SanPham sp : dsspadkm.values()) {
            sql += String.format("(%s, '%s'),", dotKM.getIdDotKm(), sp.getMaSP());
        }
        sql = sql.substring(0, sql.length() - 1);
        condb.executeUpdate(sql);
    }

    public SanPham checkedSanPham(int row) {
        SanPham checkedSP = filteredDssp.get(row);
        // Nếu sp đã được checked thì ko thêm vào nữa
        if (dsspadkm.get(checkedSP.getMaSP()) != null) {
            return null;
        }
        dsspadkm.put(checkedSP.getMaSP(), checkedSP);
        return checkedSP;
    }

    public void uncheckedSanPham(String masp) {
        if (dsspadkm.get(masp) != null) {
            dsspadkm.remove(masp);
        }
    }

    public int getIndexSanPhamInDSSPByMasp(String masp) {
        for (int i = 0; i < filteredDssp.size(); i++) {
            if (filteredDssp.get(i).getMaSP().equals(masp)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexSanPhamInDSSPADKMByMasp(String masp) {
        int i = 0;
        for (String key : dsspadkm.keySet()) {
            if (key.equals(masp)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void restorDSSPADKM() {
        getDSSPADKMFromDB();
    }

    public void filteredDsSP(String value) {
        filteredDssp = new ArrayList<>();
        for (SanPham sp : dssp) {
            if (sp.getMaSP().toLowerCase().contains(value.trim().toLowerCase()) ||
                    sp.getTenSP().toLowerCase().contains(value.trim().toLowerCase())) {
                filteredDssp.add(sp);
            }
        }
    }

    public DotKhuyenMai getDotKM() {
        return dotKM;
    }

    public ArrayList<SanPham> getDSSP() {
        return filteredDssp;
    }

    public Map<String, SanPham> getDSSPADKM() {
        return dsspadkm;
    }
}
