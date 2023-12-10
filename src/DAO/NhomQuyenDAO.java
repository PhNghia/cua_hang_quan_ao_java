package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import DTO.ChiTietNhomQuyen;
import DTO.ChucNang;
import DTO.ConnectionDB;
import DTO.NhomQuyen;

public class NhomQuyenDAO {
    private ArrayList<NhomQuyen> dsnq;
    private Map<Integer, ArrayList<ChiTietNhomQuyen>> basedscn;

    public NhomQuyenDAO() {
        getDsnqFromDB();
        getBaseDscnFromDB();
    }

    public void getDsnqFromDB() {
        dsnq = new ArrayList<NhomQuyen>();
        ConnectionDB condb = new ConnectionDB();
        String sql = "select * from nhom_quyen";
        ResultSet rs = condb.executeQuery(sql);
        try {
            while (rs.next()) {
                dsnq.add(new NhomQuyen(rs.getString("ma_nhom_quyen"), rs.getString("ten_nhom_quyen")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public NhomQuyen getNhomQuyenByMaFromDB(String manq) {
        ConnectionDB condb = new ConnectionDB();
        String sql = "select * from nhom_quyen where ma_nhom_quyen = '" + manq + "'";
        ResultSet rs = condb.executeQuery(sql);
        try {
            while (rs.next()) {
                return new NhomQuyen(rs.getString("ma_nhom_quyen"), rs.getString("ten_nhom_quyen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhomQuyen getNhomQuyenByTenFromDB(String tennq) {
        ConnectionDB condb = new ConnectionDB();
        String sql = "select * from nhom_quyen where ten_nhom_quyen = '" + tennq + "'";
        ResultSet rs = condb.executeQuery(sql);
        try {
            while (rs.next()) {
                return new NhomQuyen(rs.getString("ma_nhom_quyen"), rs.getString("ten_nhom_quyen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int countNhanVienUsedNq(String manq) {
        ConnectionDB condb = new ConnectionDB();
        String sql = "select count(ma_nhan_vien) " +
                "from nhom_quyen join nhan_vien on nhom_quyen.ma_nhom_quyen = nhan_vien.ma_nhom_quyen " +
                String.format("where nhom_quyen.ma_nhom_quyen = '%s' and nhan_vien.hien_thi = 1", manq);
        ResultSet rs = condb.executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public void themNhomQuyen(NhomQuyen nq) {
        ConnectionDB condb = new ConnectionDB();
        String sql = String.format("insert into nhom_quyen (ma_nhom_quyen, ten_nhom_quyen) values ('%s', '%s')",
                nq.getMaNhomQuyen(), nq.getTenNhomQuyen());
        condb.executeUpdate(sql);
        dsnq.add(nq);
    }

    public void suaNhomQuyen(String manq, NhomQuyen newNq) {
        ConnectionDB condb = new ConnectionDB();
        String sql = String.format(
                "update nhom_quyen set ma_nhom_quyen = '%s', ten_nhom_quyen = '%s' where ma_nhom_quyen = '%s'",
                newNq.getMaNhomQuyen(),
                newNq.getTenNhomQuyen(),
                manq);
        condb.executeUpdate(sql);
        int i = 0;
        for (NhomQuyen item : dsnq) {
            if (item.getMaNhomQuyen().equals(manq)) {
                dsnq.set(i, newNq);
                break;
            }
            i++;
        }
    }

    public void xoaNhomQuyen(String manq) {
        ConnectionDB condb = new ConnectionDB();
        String sql = String.format("delete from chi_tiet_nhom_quyen where ma_nhom_quyen = '%s'",
                manq);
        condb.executeUpdate(sql);
        sql = String.format(
                "delete from nhom_quyen where ma_nhom_quyen = '%s'",
                manq);
        condb.executeUpdate(sql);
        for (NhomQuyen item : dsnq) {
            if (item.getMaNhomQuyen().equals(manq)) {
                dsnq.remove(item);
                break;
            }
        }
    }

    public ArrayList<NhomQuyen> getDsnq() {
        return dsnq;
    }

    public void getBaseDscnFromDB() {
        basedscn = new LinkedHashMap<>();
        ConnectionDB condb = new ConnectionDB();
        String sql = "select nhom_quyen.ma_nhom_quyen, ten_nhom_quyen, " +
                "chuc_nang.ma_chuc_nang, chuc_nang.ten_chuc_nang, chi_tiet_chuc_nang.hanh_dong " +
                "from nhom_quyen join chi_tiet_nhom_quyen on nhom_quyen.ma_nhom_quyen = chi_tiet_nhom_quyen.ma_nhom_quyen "
                +
                "join chuc_nang on chi_tiet_nhom_quyen.ma_chuc_nang = chuc_nang.ma_chuc_nang " +
                "join chi_tiet_chuc_nang on chi_tiet_nhom_quyen.hanh_dong = chi_tiet_chuc_nang.hanh_dong " +
                "where nhom_quyen.ma_nhom_quyen = 'QL' order by chuc_nang.ten_chuc_nang, chi_tiet_chuc_nang.sap_xep_stt";
        ResultSet rs = condb.executeQuery(sql);
        try {
            while (rs.next()) {
                int macn = rs.getInt("ma_chuc_nang");
                ChiTietNhomQuyen ctnq = new ChiTietNhomQuyen(
                        new NhomQuyen(
                                rs.getString("ma_nhom_quyen"),
                                rs.getString("ten_nhom_quyen")),
                        new ChucNang(
                                macn,
                                rs.getString("ten_chuc_nang")),
                        rs.getString("hanh_dong"));
                if (basedscn.get(macn) != null) {
                    basedscn.get(macn).add(ctnq);
                } else {
                    basedscn.put(macn, new ArrayList<ChiTietNhomQuyen>());
                    basedscn.get(macn).add(ctnq);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, ArrayList<String>> getDscnOfSelectedNq(String manq) {
        Map<Integer, ArrayList<String>> dscn = new LinkedHashMap<Integer, ArrayList<String>>();
        ConnectionDB condb = new ConnectionDB();
        String sql = String.format("select * from chi_tiet_nhom_quyen join chuc_nang on " +
                "chi_tiet_nhom_quyen.ma_chuc_nang = chuc_nang.ma_chuc_nang where ma_nhom_quyen = '%s'", manq);
        ResultSet rs = condb.executeQuery(sql);
        try {
            while (rs.next()) {
                if (dscn.get(rs.getInt("ma_chuc_nang")) == null) {
                    dscn.put(rs.getInt("ma_chuc_nang"), new ArrayList<>());
                }
                dscn.get(rs.getInt("ma_chuc_nang")).add(rs.getString("hanh_dong"));
            }
            return dscn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<Integer, ArrayList<ChiTietNhomQuyen>> getBaseDscn() {
        return basedscn;
    }

    public void changedChiTietNhomQuyen(String manq, ArrayList<ChiTietNhomQuyen> data) {
        ConnectionDB condb = new ConnectionDB();
        String sql = String.format("delete from chi_tiet_nhom_quyen where ma_nhom_quyen = '%s'", manq);
        condb.executeUpdate(sql);
        if (data.size() > 0) {
            sql = "insert into chi_tiet_nhom_quyen (ma_nhom_quyen, ma_chuc_nang, hanh_dong) values ";
            for (ChiTietNhomQuyen ct : data) {
                sql += String.format(
                        "('%s', %s, '%s'),",
                        ct.getNq().getMaNhomQuyen(),
                        ct.getCn().getMacn(),
                        ct.getHanhDong());
            }
            sql = sql.substring(0, sql.length() - 1);
            condb.executeUpdate(sql);
        }

    }
}
