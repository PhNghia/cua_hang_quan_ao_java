/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author BomPC
 */
public class NhanVienDAO {
    private static NhanVienDAO instance;

    public NhanVienDAO() {

    }

    public static NhanVienDAO getInstance() {
        if (instance == null) {
            instance = new NhanVienDAO();
        }
        return instance;
    }
    //lay het du lieu 
    public List<DTO.NhanVien> getAll() {
        List<DTO.NhanVien> list = new ArrayList();
        ConnectionDB connection = new ConnectionDB();
        String sql = "Select * from nhan_vien nv,nhom_quyen nq where nv.hien_thi=1 and nv.ma_nhom_quyen = nq.ma_nhom_quyen  order by nv.ma_nhan_vien";
        ResultSet rs = connection.executeQuery(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    list.add(
                            new DTO.NhanVien(
                                    rs.getInt("ma_nhan_vien"),
                                    rs.getString("ten_nhan_vien"),
                                    rs.getInt("gioi_tinh"),
                                    LocalDate.parse(rs.getString("ngay_sinh")),
                                    rs.getString("sdt"),
                                    rs.getString("email"),
                                    rs.getString("dia_chi"),
                                    new DTO.NhomQuyen(rs.getString("ma_nhom_quyen"), rs.getString("ten_nhom_quyen")),
                                    Integer.parseInt(rs.getString("trang_thai"))
                            )
                    );
                }
            }
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        return list;
    }
    //kiem tra trung lap sdt,neu sua tai khoan thi moi dung manv ,con neu dang trong trang thai them thi manv = "",sql:kiem tra xem co nhan vien nao co sdt do ngoai chinh minh ra ko
    public boolean checkDuplicateSdt(String sdt,String manv){
        String sql = String.format("select * from nhan_vien  where sdt='%s' and ma_nhan_vien <> '%s'",new Object[]{sdt,manv});
        ConnectionDB connection = new ConnectionDB();
        ResultSet rs = connection.executeQuery(sql);
        try{
            if(rs.next()){
            return true;
        }
        }catch(SQLException ex){
        }
        return false;
    }
    //kiem tra trung lap email,neu sua tai khoan thi moi dung manv ,con neu dang trong trang thai them thi manv = "",sql:kiem tra xem co nhan vien nao co email do ngoai chinh minh ra ko
    public boolean checkDuplicateEmail(String email,String manv){
        String sql = String.format("select * from nhan_vien  where email='%s' and ma_nhan_vien <> '%s'",new Object[]{email,manv});
        ConnectionDB connection = new ConnectionDB();
        ResultSet rs = connection.executeQuery(sql);
        try{
            if(rs.next()){
            return true;
        }
        }catch(SQLException ex){
        }
        return false;
    }
    //search 
    public List<DTO.NhanVien> search(int indexsearchtype, String text, int indexgender, String chucvu, int indextrangthai) {
        String ma[] = {"ma_nhan_vien", "ma_nhan_vien", "ma_nhan_vien", "ma_nhan_vien", "ma_nhan_vien", "ma_nhan_vien"};
        String hoten[] = {"ten_nhan_vien", "ten_nhan_vien", "ten_nhan_vien", "ten_nhan_vien", "ten_nhan_vien", "ten_nhan_vien"};
        String email[] = {"email", "email", "email", "email", "email", "email"};
        String Sdt[] = {"sdt", "sdt", "sdt", "sdt", "sdt", "sdt"};
        String diachi[] = {"dia_chi", "dia_chi", "dia_chi", "dia_chi", "dia_chi", "dia_chi"};
        String operator = "or";
        if (!text.isBlank()) {
            ma[0] = ma[1] = "'" + text + "'";
            hoten[0] = hoten[2] = "'%" + text + "%'";
            email[0] = email[3] = "'%" + text + "%'";
            Sdt[0] = Sdt[4] = "'" + text + "%'";
            diachi[0] = diachi[5] = "'%" + text + "%'";
            if (indexsearchtype != 0) {
                operator = "and";
            }
        }
        String gender[] = {"gioi_tinh", "0", "1"};
        if (chucvu.equals("Tất cả")) {
            chucvu = "ten_nhom_quyen";
        } else {
            chucvu = "'" + chucvu + "'";
        }
        String trangthai[] = {"trang_thai", "0", "1"};
        String sql = String.format("Select * from nhan_vien nv,nhom_quyen nq where (nv.ma_nhan_vien=%s %9$s nv.ten_nhan_vien like %s %9$s nv.email like %s %9$s nv.sdt like %s %9$s nv.dia_chi like %s) and nv.gioi_tinh =%s and nq.ma_nhom_quyen = nv.ma_nhom_quyen and nq.ten_nhom_quyen = %s and nv.trang_thai = %s and nv.hien_thi = 1 order by ma_nhan_vien ", new Object[]{ma[indexsearchtype], hoten[indexsearchtype], email[indexsearchtype], Sdt[indexsearchtype], diachi[indexsearchtype], gender[indexgender], chucvu, trangthai[indextrangthai], operator});
        System.out.println(sql);
        ConnectionDB connection = new ConnectionDB();
        List<DTO.NhanVien> list = new ArrayList();
        ResultSet rs = connection.executeQuery(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    list.add(
                            new DTO.NhanVien(
                                    rs.getInt("ma_nhan_vien"),
                                    rs.getString("ten_nhan_vien"),
                                    rs.getInt("gioi_tinh"),
                                    LocalDate.parse(rs.getString("ngay_sinh")),
                                    rs.getString("sdt"),
                                    rs.getString("email"),
                                    rs.getString("dia_chi"),
                                    new DTO.NhomQuyen(rs.getString("ma_nhom_quyen"), rs.getString("ten_nhom_quyen")),
                                    Integer.parseInt(rs.getString("trang_thai"))
                            )
                    );
                }
            }
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        return list;
    }
    //them nhan vien vao data
    public boolean addNhanVien(DTO.NhanVien dto) {
        String sql = "insert into nhan_vien(ten_nhan_vien,gioi_tinh,ngay_sinh,sdt,email,dia_chi,ma_nhom_quyen,trang_thai,hien_thi) values('%s','%s','%s','%s','%s','%s',(select ma_nhom_quyen from nhom_quyen where ten_nhom_quyen='%s'),'%s',1)";
        sql = String.format(sql, new Object[]{
            dto.getTenNhanVien(),
            dto.getGioiTinh(),
            dto.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            dto.getSdt(),
            dto.getEmail(),
            dto.getDiaChi(),
            dto.getChucVu().getTenNhomQuyen(),
            dto.getTrangThai()
        });
        ConnectionDB connection = new ConnectionDB();
        int n = connection.executeUpdate(sql);
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        return (n > 0) ? true : false;
    }
    //sua nhan vien
    public boolean editNhanVien(DTO.NhanVien dto) {
        String sql = "update nhan_vien set ten_nhan_vien='%s',gioi_tinh='%s',ngay_sinh='%s',sdt='%s',email='%s',dia_chi='%s',ma_nhom_quyen=(Select ma_nhom_quyen from nhom_quyen where ten_nhom_quyen='%s'),trang_thai='%s' where ma_nhan_vien='%s'";
        sql = String.format(sql, new Object[]{
            dto.getTenNhanVien(),
            dto.getGioiTinh(),
            dto.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            dto.getSdt(),
            dto.getEmail(),
            dto.getDiaChi(),
            dto.getChucVu().getTenNhomQuyen(),
            dto.getTrangThai(),
            dto.getMaNhanVien()
        });
        ConnectionDB connection = new ConnectionDB();
        int n = connection.executeUpdate(sql);
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        return (n > 0) ? true : false;
    }
    //xoa nhan vien (set hien thi = 0 )
    public boolean deleteNhanVien(String ma_nhan_vien) {
        String sql = String.format("update nhan_vien set hien_thi = 0 where ma_nhan_vien = '%s'", new Object[]{ma_nhan_vien});
        ConnectionDB connection = new ConnectionDB();
        int n = connection.executeUpdate(sql);
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        return (n > 0) ? true : false;
    }
    //lay nhan vien khi co ma id
    public DTO.NhanVien getNhanVienByID(int id) {
        DTO.NhanVien dto = null;
        String sql = String.format("select * from nhan_vien nv,nhom_quyen nq where nv.ma_nhom_quyen = nq.ma_nhom_quyen  and nv.ma_nhan_vien ='%d'", new Object[]{id});
        ConnectionDB connection = new ConnectionDB();
        ResultSet rs = connection.executeQuery(sql);
        try {
            if (rs != null) {
                if (rs.next()) {
                    dto = new DTO.NhanVien(
                            rs.getInt("ma_nhan_vien"),
                            rs.getString("ten_nhan_vien"),
                            rs.getInt("gioi_tinh"),
                            LocalDate.parse(rs.getString("ngay_sinh")),
                            rs.getString("sdt"),
                            rs.getString("email"),
                            rs.getString("dia_chi"),
                            new DTO.NhomQuyen(rs.getString("ma_nhom_quyen"), rs.getString("ten_nhom_quyen")),
                            Integer.parseInt(rs.getString("trang_thai"))
                    );
                }
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        try {
            connection.getConnection().close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        return dto;
    }
    //lay tat ca ten nhom quyen (de nhet vao combobox chuc vu khi moi load chuong trinh)
    public List<String> getAllNameChucVu() {
        List<String> list = new ArrayList();
        ConnectionDB connection = new ConnectionDB();
        String sql = "Select ten_nhom_quyen from nhom_quyen order by ten_nhom_quyen";
        ResultSet rs = connection.executeQuery(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    list.add(
                            new String(rs.getString("ten_nhom_quyen"))
                    );
                }
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        try {

            connection.getConnection().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return list;
    }
    //kiem tra ma quyen moi co khac voi ma quyen cu 
    public boolean checkMaQuyenThayDoi(String manv,String tennhomquyenmoi){
        String sql = String.format("Select * from nhan_vien nv,nhom_quyen nq where nv.ma_nhom_quyen = nq.ma_nhom_quyen and nv.ma_nhan_vien = '%s' and nq.ten_nhom_quyen = '%s' ",new Object[]{manv,tennhomquyenmoi});
        ConnectionDB connection = new ConnectionDB();
        ResultSet rs = connection.executeQuery(sql);
        try{
            if(rs.next()){
                return false;
            }
        }catch(SQLException ex){
        }
        return true;
    }
}
