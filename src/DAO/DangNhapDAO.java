package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import DTO.ConnectionDB;
import DTO.NhanVien;
import DTO.NhomQuyen;

public class DangNhapDAO {
	private ConnectionDB connection;

	public DangNhapDAO() {
		this.connection = new ConnectionDB();
	}

	public HashMap<String, Object[]> getAccounts() {
		HashMap<String, Object[]> accounts = new HashMap<>();

		String query = "SELECT * FROM tai_khoan";

		try {
			ResultSet results = this.connection.executeQuery(query);
			if (results != null) {
				while (results.next()) {
					String username = results.getString("ten_tai_khoan");
					String password = results.getString("mat_khau");
					int trangthai = results.getInt("trang_thai");
					accounts.put(username, new Object[] { password, trangthai });
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;
	}

	public NhanVien getEmployee(String accountName) {
		String query = "SELECT * FROM tai_khoan JOIN nhan_vien ON tai_khoan.ten_tai_khoan = '" + accountName + "' "
				+ "JOIN nhom_quyen ON nhan_vien.ma_nhom_quyen = nhom_quyen.ma_nhom_quyen "
				+ "WHERE tai_khoan.ma_nhan_vien = nhan_vien.ma_nhan_vien";

		NhanVien employee = null;
		NhomQuyen permission = null;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			ResultSet results = this.connection.executeQuery(query);
			if (results != null) {
				while (results.next()) {
					int id = results.getInt("ma_nhan_vien");
					String name = results.getString("ten_nhan_vien");
					int gender = results.getInt("gioi_tinh");
					String dob = results.getString("ngay_sinh");
					LocalDate dobParse = LocalDate.parse(dob, formatter);
					String phoneNumber = results.getString("sdt");
					String email = results.getString("email");
					String address = results.getString("dia_chi");
					int status = results.getInt("trang_thai");
					int show = results.getInt("hien_thi");

					String idPermission = results.getString("ma_nhom_quyen");
					String namePermission = results.getString("ten_nhom_quyen");
					permission = new NhomQuyen(idPermission, namePermission);

					employee = new NhanVien(id, name, gender, dobParse, phoneNumber, email, address, permission,
							status);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}
}
