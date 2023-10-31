package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import DTO.ConnectionDB;
import DTO.NhanVien;
import DTO.NhomQuyen;
import DTO.TaiKhoan;

public class TaiKhoanDao {
	private ConnectionDB connection;

	public TaiKhoanDao() {
		this.connection = new ConnectionDB();
	}

	public ArrayList<TaiKhoan> getTaiKhoan() {
<<<<<<< HEAD
		ArrayList<TaiKhoan> taiKhoanList = new ArrayList();
		String query = "SELECT * FROM tai_khoan JOIN nhan_vien ON nhan_vien.ma_nhan_vien = tai_khoan.ma_nhan_vien;";
=======
		ArrayList<TaiKhoan> taiKhoanList = new ArrayList<>();
		String query = "SELECT * FROM tai_khoan JOIN nhan_vien on nhan_vien.ma_nhan_vien = tai_khoan.ma_nhan_vien WHERE hien_thi = 1;";
>>>>>>> b76724dd8fbb1613f65cc37c4ecc700cf156a4b1

		try {
			ResultSet result = this.connection.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					String accountName = result.getString("ten_tai_khoan");
					LocalDateTime accountCreatedDate = result.getTimestamp("ngay_tao").toLocalDateTime();
					int accountStatus = result.getInt("trang_thai");

					int employeeId = result.getInt("ma_nhan_vien");
					String employeeName = result.getString("ten_nhan_vien");
					NhanVien employee = new NhanVien(employeeId, employeeName);

					taiKhoanList.add(new TaiKhoan(accountName, employee, accountCreatedDate, accountStatus));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return taiKhoanList;
	}

	public ArrayList<NhanVien> getEmployees() {
		ArrayList<NhanVien> employees = new ArrayList<>();
		String query = "SELECT nhan_vien.* FROM nhan_vien LEFT JOIN tai_khoan ON nhan_vien.ma_nhan_vien = tai_khoan.ma_nhan_vien WHERE tai_khoan.ma_nhan_vien IS NULL;";
		try {
			ResultSet result = this.connection.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					int employeeId = result.getInt("ma_nhan_vien");
					String employeeName = result.getString("ten_nhan_vien");
					NhanVien employee = new NhanVien(employeeId, employeeName);
					employees.add(employee);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public Boolean add(TaiKhoan tk) {
		String sql = "INSERT INTO tai_khoan(ten_tai_khoan,mat_khau,ma_nhan_vien,ngay_tao,trang_thai) VALUES (?,?,?,?,?)";

		try (PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, tk.getTenTaiKhoan());
			preparedStatement.setString(2, tk.getMatKhau());
			preparedStatement.setInt(3, tk.getNguoiSoHuu().getMaNhanVien());
			preparedStatement.setTimestamp(4, Timestamp.valueOf(tk.getNgayTao()));
			preparedStatement.setInt(5, tk.getTrangThai());

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Boolean del(String tenTaiKhoan) {
		Boolean ok = this.connection.sqlUpdate("DELETE FROM `tai_khoan` WHERE ten_tai_khoan = '" + tenTaiKhoan + "';",
				null);
		return ok;
	}

	public Boolean update(String userName, String password, int status) {
		Boolean ok = this.connection.sqlUpdate("UPDATE tai_khoan SET mat_khau='" + password + "',trang_thai='" + status
				+ "' WHERE ten_tai_khoan='" + userName + "'", null);
		return ok;
	}

	public Boolean updatePassword(String userName, String password) {
		Object[] objs = { password, userName };
		Boolean ok = this.connection.sqlUpdate("UPDATE tai_khoan SET mat_khau = ? WHERE ten_tai_khoan = ?", objs);
		return ok;
	}

	public Boolean updateStatus(String userName, int status) {
		Boolean ok = this.connection.sqlUpdate(
				"UPDATE tai_khoan SET trang_thai='" + status + "' WHERE ten_tai_khoan='" + userName + "'", null);
		return ok;
	}
}
