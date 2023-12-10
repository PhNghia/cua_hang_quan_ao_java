package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.text.DateFormatter;

import DTO.ConnectionDB;
import DTO.HoaDonBan;
import java.time.ZoneId;

public class ThongKeDoanhThuDAO {

    private ConnectionDB connection;

    public ThongKeDoanhThuDAO() {
        this.connection = new ConnectionDB();
    }

    public ArrayList<HoaDonBan> getSellInvoices(LocalDateTime fromDate, LocalDateTime toDate) {
        ArrayList<HoaDonBan> sellInvoices = new ArrayList<>();

        String newFromDate = fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String newToDate = toDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql = String.format(
                "SELECT ma_hoa_don, ngay_tao, tong_tien FROM hoa_don_ban WHERE ngay_tao BETWEEN '%s 00:00:00' AND '%s 23:59:59' GROUP BY ngay_tao;",
                new Object[]{newFromDate, newToDate});

        try {
            ResultSet results = this.connection.executeQuery(sql);

            if (results != null) {
                while (results.next()) {
                    String sellInvoiceId = results.getString("ma_hoa_don");
                    LocalDateTime sellInvoiceDate = results.getTimestamp("ngay_tao").toLocalDateTime();
                    int sellInvoiceTotal = results.getInt("tong_tien");

                    HoaDonBan sellInvoice = new HoaDonBan(sellInvoiceId, sellInvoiceDate, sellInvoiceTotal);

                    sellInvoices.add(sellInvoice);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellInvoices;
    }

    public ArrayList<HoaDonBan> getTotalMonths(LocalDateTime fromDate, LocalDateTime toDate) {
        ArrayList<HoaDonBan> totalMonths = new ArrayList<>();

        String newFromDate = fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String newToDate = toDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql = String.format(
                "SELECT DATE(ngay_tao) AS creationDate, SUM(tong_tien) AS total FROM hoa_don_ban WHERE ngay_tao BETWEEN '%s 00:00:00' AND '%s 23:59:59' GROUP BY DATE(ngay_tao);",
                new Object[]{newFromDate, newToDate});

        try {
            ResultSet results = this.connection.executeQuery(sql);
            if (results != null) {
                while (results.next()) {
                    LocalDateTime sellInvoiceDate = results.getTimestamp("creationDate").toLocalDateTime();
                    int sellInvoicetotalMonth = results.getInt("total");

                    HoaDonBan sellInvoice = new HoaDonBan(sellInvoiceDate, sellInvoicetotalMonth);

                    totalMonths.add(sellInvoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalMonths;
    }
}
