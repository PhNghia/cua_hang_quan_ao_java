package DAO;

import DTO.KhachHang;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhachHangDAO {
    private Connection conn;

    public KhachHangDAO() {
        try {
                String url = "jdbc:mysql://localhost:3306/cua_hang_quan_ao_db";
                var user = "root";
                var password = "";
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connect Succesful !");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<KhachHang> getListKH(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM khach_hang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang s = new KhachHang();
                s.setMaKH(rs.getInt("ma_khach_hang"));
                s.setTenKH(rs.getString("ten_khach_hang"));
                s.setSdt(rs.getString("sdt"));
                s.setTienTichLuy(rs.getInt("tien_tich_luy"));
                s.setDiemTichLuy(rs.getInt("diem_tich_luy"));
                s.setBangTien(rs.getInt("bang_tien"));
                list.add(s);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public void AddKH(KhachHang a){
        
        String sql = "INSERT INTO `khach_hang`(`ten_khach_hang`, `sdt`, `tien_tich_luy`, `diem_tich_luy`, `bang_tien`) VALUES (?,?,?,?,?)";
        try {
            
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, a.getTenKH());
            p.setString(2, a.getSdt());
            p.setInt(3, 0);
            p.setInt(4, 0);
            p.setInt(5, 0);
            p.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void UpdateKH(KhachHang a){
        String sql = "UPDATE `khach_hang` SET `ten_khach_hang`=?,`sdt`=? WHERE ma_khach_hang =?";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, a.getTenKH());
            p.setString(2, a.getSdt());
            p.setInt(3, a.getMaKH());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<KhachHang> FindKH(String name, String loc) {
        ArrayList<KhachHang> list = new ArrayList<>();
        if (loc == "all") {
            String sql = "SELECT * FROM khach_hang WHERE ma_khach_hang like ? or ten_khach_hang like ? or sdt like ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                ps.setString(2, "%" + name + "%");
                ps.setString(3, "%" + name + "%");
                
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    KhachHang s = new KhachHang();
                    s.setMaKH(rs.getInt("ma_khach_hang"));
                    s.setTenKH(rs.getString("ten_khach_hang"));
                    s.setSdt(rs.getString("sdt"));
                    s.setTienTichLuy(rs.getInt("tien_tich_luy"));
                    s.setDiemTichLuy(rs.getInt("diem_tich_luy"));
                    s.setBangTien(rs.getInt("bang_tien"));
                    list.add(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "SELECT * FROM khach_hang WHERE "+loc+" like ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    KhachHang s = new KhachHang();
                    s.setMaKH(rs.getInt("ma_khach_hang"));
                    s.setTenKH(rs.getString("ten_khach_hang"));
                    s.setSdt(rs.getString("sdt"));
                    s.setTienTichLuy(rs.getInt("tien_tich_luy"));
                    s.setDiemTichLuy(rs.getInt("diem_tich_luy"));
                    s.setBangTien(rs.getInt("bang_tien"));
                    list.add(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
    
    /*public static void main(String[] args) {
        new KhachHangDAO().AddKH();
    }*/
}
