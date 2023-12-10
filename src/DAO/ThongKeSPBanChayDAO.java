/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class ThongKeSPBanChayDAO {

    private static ThongKeSPBanChayDAO instance;

    public static ThongKeSPBanChayDAO getInstance() {
        if (instance == null) {
            instance = new ThongKeSPBanChayDAO();
        }
        return instance;
    }

    public List<DTO.SanPham> getDataThongKe(LocalDate fromdate, LocalDate todate) {
        String datestart = fromdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dateend = todate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ConnectionDB connection = new ConnectionDB();
        List<DTO.SanPham> list = new ArrayList();
        String sql = String.format("Select cthd.ma_san_pham as ma_san_pham,cthd.ten_san_pham as ten_san_pham,sum(cthd.so_luong) as so_luong,sum(cthd.tong_tien) as tong_tien from hoa_don_ban hd,chi_tiet_hoa_don_ban cthd where hd.ma_hoa_don = cthd.ma_hoa_don and hd.ngay_tao between '%s 00:00:00' and '%s 23:59:59' group by cthd.ma_san_pham,cthd.ten_san_pham order by cthd.so_luong desc",new Object[]{datestart,dateend});
        
        ResultSet rs = connection.executeQuery(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    list.add(
                            new DTO.SanPham(
                                    rs.getString("ma_san_pham"),
                                    rs.getString("ten_san_pham"),
                                   
                                    rs.getInt("tong_tien"),
                                    rs.getInt("so_luong")
                                    //String maSP, String tenSP, int giaBan, int soLuong
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

}
