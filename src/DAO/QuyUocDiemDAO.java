package DAO;

import DTO.QuyUocDiem;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuyUocDiemDAO {
    private Connection conn;

    public QuyUocDiemDAO() {
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
    
    public QuyUocDiem Get(){
        String sql = "SELECT * FROM quy_uoc_tich_diem";
        QuyUocDiem s = new QuyUocDiem();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                s.setMenh_gia(rs.getInt("menh_gia"));
                s.setBang_diem(rs.getInt("bang_diem"));
                s.setBang_tien(rs.getInt("bang_tien"));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
    
    /*public void Add(KhachHang a){
        
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
    }*/
    
    public void Update(QuyUocDiem a){
        String sql = "UPDATE `quy_uoc_tich_diem` SET `menh_gia`=?,`bang_diem`=?,`bang_tien`=? WHERE 1";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, a.getMenh_gia());
            p.setInt(2, a.getBang_diem());
            p.setInt(3, a.getBang_tien());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
