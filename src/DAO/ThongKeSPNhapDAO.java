
package DAO;

import DTO.ConnectionDB;
import DTO.SanPham;

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
public class ThongKeSPNhapDAO {

    private static ThongKeSPNhapDAO instance;

    public static ThongKeSPNhapDAO getInstance() {
        if (instance == null) {
            instance = new ThongKeSPNhapDAO();
        }
        return instance;
    }

    public List<DTO.SanPham> getDataThongKe(LocalDate fromdate, LocalDate todate) {
        String datestart = fromdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dateend = todate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ConnectionDB connection = new ConnectionDB();
        List<DTO.SanPham> list = new ArrayList();
        // String sql = String.format("Select cthd.ma_san_pham as
        // ma_san_pham,cthd.ten_san_pham as ten_san_pham,sum(cthd.so_luong) as
        // so_luong,sum(cthd.tong_tien) as tong_tien from hoa_don_mua
        // hd,chi_tiet_hoa_don_mua cthd where hd.ma_hoa_don = cthd.ma_hoa_don and
        // hd.ngay_tao between '%s 00:00:00' and '%s 23:59:59' group by
        // cthd.ma_san_pham,cthd.ten_san_pham order by cthd.so_luong desc",new
        // Object[]{datestart,dateend});
        String sql = String.format("SELECT\n" +
                "    cthd.ma_san_pham AS ma_san_pham,\n" +
                "    sp.ten_san_pham,\n" +
                "    avg(cthd.gia_nhap) as gia_nhap_tb,\n" +
                "    sum(cthd.so_luong) as so_luong,\n" +
                "    sum(cthd.gia_nhap * cthd.so_luong) as tong_tien\n" +
                "FROM\n" +
                "    hoa_don_mua hd\n" +
                "    INNER JOIN chi_tiet_hoa_don_mua cthd ON hd.ma_hoa_don = cthd.ma_hoa_don\n" +
                "    INNER JOIN san_pham sp ON cthd.ma_san_pham = sp.ma_san_pham\n" +
                "WHERE\n" +
                "    hd.ngay_tao BETWEEN '%s 00:00:00' AND '%s 23:59:59'\n" +
                "GROUP BY\n" +
                "    cthd.ma_san_pham\n" +
                "ORDER BY\n" +
                "    cthd.so_luong DESC;", new Object[] { datestart, dateend });
        ResultSet rs = connection.executeQuery(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    // System.out.println(rs.getString("gia_nhap") +" "+ rs.getString("so_luong"));
                    SanPham sp = new SanPham(
                                    rs.getString("ma_san_pham"),
                                    rs.getString("sp.ten_san_pham"),

                                    rs.getInt("so_luong"), // chống chế cho constructor
                                    rs.getInt("so_luong")
                            // String maSP, String tenSP, int giaBan, int soLuong
                            );
                    // sp đã bị xóa giá nhập, đây chỉ là cách cứu chữa tạm thời không nên xóa
                    sp.setGiaNhapTB(rs.getFloat("gia_nhap_tb"));
                    sp.setTongTienSPNhap(rs.getLong("tong_tien"));
                    list.add(sp);
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
