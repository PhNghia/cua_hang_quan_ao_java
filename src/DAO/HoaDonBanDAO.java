package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import DTO.ChiTietHDB;
import DTO.ChiTietHDM;
import DTO.ConnectionDB;
import DTO.HoaDonBan;
import DTO.HoaDonMua;
import DTO.KhachHang;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.SanPham;

public class HoaDonBanDAO {
	private ArrayList<HoaDonBan> dsHDB;
	private ArrayList<ChiTietHDB> dsCTHDB;

	public HoaDonBanDAO() {
		getDsHDBMFromDb();
	}

	public void getDsHDBMFromDb() {
		dsHDB = new ArrayList<>();
		// TODO Auto-generated method stub
		String sql = "select * from hoa_don_ban, nhan_vien, khach_hang "
				+ "where hoa_don_ban.ma_nhan_vien = nhan_vien.ma_nhan_vien "
				+ "and hoa_don_ban.ma_khach_hang = khach_hang.ma_khach_hang order by ngay_tao desc;";
		ConnectionDB con = new ConnectionDB();
		ResultSet rs = con.executeQuery(sql);
		try {
			while (rs.next()) {
				dsHDB.add(new HoaDonBan(rs.getString("ma_hoa_don"),
						new KhachHang(rs.getInt("ma_khach_hang"), rs.getString("ten_khach_hang")),
						new NhanVien(rs.getInt("ma_nhan_vien"), rs.getString("ten_nhan_vien")),
						LocalDateTime.parse(rs.getString("ngay_tao").replace(" ", "T")), rs.getInt("tong_tien")));
			}
		} catch (SQLException e) {

		}
	}

	public ArrayList<ChiTietHDB> getDsCTHDBFromDB(int row) {
		dsCTHDB = new ArrayList<>();
		HoaDonBan hdbSeclected = this.dsHDB.get(row);
		String sql = "select *\r\n" + "from chi_tiet_hoa_don_ban , san_pham \r\n"
				+ "WHERE chi_tiet_hoa_don_ban.ma_san_pham = san_pham.ma_san_pham  "
				+ "and chi_tiet_hoa_don_ban.ma_hoa_don = '" + hdbSeclected.getMaHD() + "'";
		ConnectionDB con = new ConnectionDB();
		ResultSet rs = con.executeQuery(sql);
		try {
			while (rs.next()) {
				dsCTHDB.add(new ChiTietHDB(
						rs.getString("ma_hoa_don"),
						new SanPham(
								rs.getString("ma_san_pham"),
								rs.getString("ten_san_pham"),
								rs.getInt("gia_ban"),
								rs.getInt("so_luong")),
						rs.getInt("giam_gia"), rs.getInt("tong_tien")));
			}
		} catch (SQLException e) {
		}
		return dsCTHDB;
	}

	public void getFilterDsHDBFromDB(String itemFilterSelected, String nameSearch) {
		String sql = "select * from nhan_vien join hoa_don_ban on nhan_vien.ma_nhan_vien= hoa_don_ban.ma_nhan_vien "
				+ "join khach_hang on hoa_don_ban.ma_khach_hang = khach_hang.ma_khach_hang" + " where ";
		switch (itemFilterSelected) {
			case "Tất cả":
				sql += "hoa_don_ban.ma_hoa_don like '%" + nameSearch + "%' or khach_hang.ten_khach_hang like '%"
						+ nameSearch + "%' or nhan_vien.ten_nhan_vien like '% " + nameSearch + " %'";
				break;
			case "Mã hóa đơn":
				sql += "hoa_don_ban.ma_hoa_don like '%" + nameSearch + "%'";
				break;
			case "Khách hàng":
				sql += "khach_hang.ten_khach_hang like '%" + nameSearch + "%'";
				break;
			case "Nhân viên":
				sql += "nhan_vien.ten_nhan_vien like '%" + nameSearch + " %'";
				break;
		}

		ConnectionDB con = new ConnectionDB();
		ResultSet rs = con.executeQuery(sql);
		try {
			dsHDB = new ArrayList<>();
			while (rs.next()) {
				dsHDB.add(new HoaDonBan(rs.getString("ma_hoa_don"),
						new KhachHang(rs.getInt("ma_khach_hang"), rs.getString("ten_khach_hang")),
						new NhanVien(rs.getInt("ma_nhan_vien"), rs.getString("ten_nhan_vien")),
						LocalDateTime.parse(rs.getString("ngay_tao").replace(" ", "T")), rs.getInt("tong_tien")));
				
			}
		} catch (SQLException e) {
		}

	}

	public void addChiTietHDB(ChiTietHDB a) {
		String sql = "INSERT INTO `chi_tiet_hoa_don_ban` (`ma_hoa_don`, `ma_san_pham`, `ten_san_pham`, `gia_ban`, `giam_gia`, `so_luong`, `tong_tien`) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try (Connection connection = new ConnectionDB().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(a.getSanPham().getMaSP());
			// Set parameters for the prepared statement
			ps.setString(1, a.getMaHD());
			ps.setString(2, a.getSanPham().getMaSP());
			ps.setString(3, a.getSanPham().getTenSP());
			ps.setInt(4, a.getSanPham().getGiaBan());
			ps.setFloat(5, a.getGiamGia());
			ps.setInt(6, a.getSanPham().getSoLuong());
			ps.setInt(7, a.getTongTien());
			// Execute the update
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("CTHDB added successfully.");
			} else {
				System.out.println("Failed to add CTHDB.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoa(String maHD) {
		String sql1 = "DELETE FROM chi_tiet_hoa_don_ban WHERE ma_hoa_don = '" + maHD + "' ;\n";
		String sql2 = "DELETE FROM hoa_don_ban WHERE ma_hoa_don = '" + maHD + "' ";
		try {
			Connection connection = new ConnectionDB().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

			// Execute the update
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("xoa dư lieu CTHD thanh cong");
			} else {
				System.out.println("khong co dư lieu CTHD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = new ConnectionDB().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

			// Execute the update
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("xoa du lieu HDB thanh cong");
			} else {
				System.out.println("khong co du lieu HDB");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HoaDonBan> getDsHDB() {
		return dsHDB;
	}

	public ArrayList<ChiTietHDB> getDsCTHDB() {
		return dsCTHDB;
	}

	public void setDsCTHDB(ArrayList<ChiTietHDB> dsCTHDB) {
		this.dsCTHDB = dsCTHDB;
	}

	public void setDsHDB(ArrayList<HoaDonBan> dsHDB) {
		this.dsHDB = dsHDB;
	}

}
