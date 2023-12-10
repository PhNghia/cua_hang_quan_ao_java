package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import DTO.ConnectionDB;
import DTO.KhuyenMai;
import DTO.SanPham;
import DTO.DotKhuyenMai;
import DTO.FormatValue;

public class KhuyenMaiDAO {
	
	private SanPhamDAO SanPhamDAO = new SanPhamDAO();

	public KhuyenMaiDAO() {
//		this.connection = new ConnectionDB();
	}

	public ArrayList<KhuyenMai> getListKhuyenMai() {
		ConnectionDB connection = new ConnectionDB();
		ArrayList<KhuyenMai> khuyenmaiList = new ArrayList<>();
		String query = "SELECT * FROM khuyen_mai";
		try {
			ResultSet result = connection.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					String maKM = result.getString("ma_khuyen_mai");
					String tenKM = result.getString("ten_khuyen_mai");
					int trangThai = result.getInt("trang_thai");
					khuyenmaiList.add(new KhuyenMai(maKM, tenKM, trangThai));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.close();
		return khuyenmaiList;
	}

	public ArrayList<DotKhuyenMai> getListDot(String mact) {
		ConnectionDB connection = new ConnectionDB();
		// GET LIST DOT
		ArrayList<DotKhuyenMai> dotList = new ArrayList<>();
		String sql = "SELECT * FROM dot_khuyen_mai WHERE ma_khuyen_mai='" + mact + "'";
		try {
			ResultSet result = connection.executeQuery(sql);
			if (result != null) {
				while (result.next()) {
					int idKM = result.getInt("id_dot_khuyen_mai");
					LocalDateTime batDau = LocalDateTime.parse(result.getString("ngay_bat_dau").replace(" ", "T"));
					LocalDateTime ketThuc = LocalDateTime.parse(result.getString("ngay_ket_thuc").replace(" ", "T"));
					float giaTri = result.getFloat("gia_tri");
					int trangThai = result.getInt("trang_thai");
					dotList.add(new DotKhuyenMai(idKM, new KhuyenMai(mact), batDau, ketThuc, giaTri, trangThai));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (DotKhuyenMai dot : dotList) {
			switch (dot.getTrangThai()) {
				case 2:
					if (FormatValue.convertLocalDateTimeToDate(dot.getNgayKetThuc()).before(new Date())) {
						sql = "update dot_khuyen_mai set trang_thai = 0 where id_dot_khuyen_mai =" + dot.getIdDotKm();
						connection.executeUpdate(sql);
						dot.setTrangThai(0);
					}
					break;
				case 1:
					if (!FormatValue.convertLocalDateTimeToDate(dot.getNgayBatDau()).after(new Date())) {
						sql = "update dot_khuyen_mai set trang_thai = 2 where id_dot_khuyen_mai =" + dot.getIdDotKm();
						connection.executeUpdate(sql);
						dot.setTrangThai(2);
					}
					break;
			}
		}
		return dotList;
	}

	// GET LIST SANPHAM
	public List<List<String>> getListSP(int maDot) {
		ConnectionDB connection = new ConnectionDB();
		List<List<String>> checkList = new ArrayList<>();
		List<String> maSP = new ArrayList<>();
		List<String> tenSP = new ArrayList<>();
		String query = "SELECT * FROM chi_tiet_khuyen_mai WHERE id_dot_khuyen_mai=" + maDot;
		try {
			ResultSet result = connection.executeQuery(query);
			if (result != null)
				while (result.next()) {
					String ma = result.getString("ma_san_pham");
					SanPham sp = SanPhamDAO.getChiTiet(ma);
					String ten = sp.getTenSP();
					maSP.add(ma);
					tenSP.add(ten);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		checkList.add(0, maSP);
		checkList.add(1, tenSP);
		connection.close();
		return checkList;
	}

	public ArrayList<String> getMaList() {
		ConnectionDB connection = new ConnectionDB();
		ArrayList<String> checkList = new ArrayList<>();
		String query = "SELECT * FROM khuyen_mai";
		try {
			ResultSet result = connection.executeQuery(query);
			if (result != null)
				while (result.next()) {
					String maKM = result.getString("ma_khuyen_mai");
					checkList.add(maKM);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.close();
		return checkList;
	}

	public int countDot() {
		ConnectionDB connection = new ConnectionDB();
		int n = 0;
		String query = "SELECT * FROM dot_khuyen_mai order by id_dot_khuyen_mai desc limit 1";
		try {
			ResultSet result = connection.executeQuery(query);
			if (result.next()) {
				n = result.getInt("id_dot_khuyen_mai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.close();
		return n;
	}

	public boolean insertNewCT(KhuyenMai km) {
		ConnectionDB connection = new ConnectionDB();
		String query = "INSERT INTO khuyen_mai (ma_khuyen_mai,ten_khuyen_mai,trang_thai) VALUES (?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, km.getMakm());
			preparedStatement.setString(2, km.getTenkm());
			preparedStatement.setInt(3, 0);
			int rowsAffected = preparedStatement.executeUpdate();
			connection.close();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			connection.close();
			return false;
		}
	}

	public boolean insertNewDot(DotKhuyenMai dot) {
		ConnectionDB connection = new ConnectionDB();
		if (FormatValue.convertLocalDateTimeToDate(dot.getNgayBatDau()).before(new Date())) {
			dot.setTrangThai(2);
		}
		String query = "INSERT INTO dot_khuyen_mai (id_dot_khuyen_mai, ma_khuyen_mai,ngay_bat_dau,ngay_ket_thuc,gia_tri,trang_thai) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, (countDot() + 1) + "");
			preparedStatement.setString(2, dot.getChuongTrinhKM().getMakm());
			preparedStatement.setString(3, dot.getNgayBatDau().toString());
			preparedStatement.setString(4, dot.getNgayKetThuc().toString());
			preparedStatement.setFloat(5, dot.getGiaTri());
			preparedStatement.setInt(6, dot.getTrangThai());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateCT(String selected, KhuyenMai km) throws SQLException {
		ConnectionDB connection = new ConnectionDB();
		String query1 = "SET GLOBAL foreign_key_checks = 0";
		String query2 = "UPDATE dot_khuyen_mai SET ma_khuyen_mai=? WHERE ma_khuyen_mai=?";
		String query3 = "UPDATE khuyen_mai SET ma_khuyen_mai=?, ten_khuyen_mai=? WHERE ma_khuyen_mai=?";
		String query4 = "SET GLOBAL foreign_key_checks = 1";
		PreparedStatement ps1 = connection.getConnection().prepareStatement(query1);
		ps1.executeUpdate();
		PreparedStatement ps2 = connection.getConnection().prepareStatement(query2);
		ps2.setString(1, km.getMakm());
		ps2.setString(2, selected);
		ps2.executeUpdate();
		PreparedStatement ps3 = connection.getConnection().prepareStatement(query3);
		ps3.setString(1, km.getMakm());
		ps3.setString(2, km.getTenkm());
		ps3.setString(3, selected);
		ps3.executeUpdate();
		PreparedStatement ps4 = connection.getConnection().prepareStatement(query4);
		ps4.executeUpdate();
		connection.close();
		return false;
	}

	public boolean updateDot(DotKhuyenMai dot) throws SQLException {
		ConnectionDB connection = new ConnectionDB();
		String query = "UPDATE dot_khuyen_mai SET ngay_bat_dau=?, ngay_ket_thuc=?, gia_tri=?, trang_thai=? WHERE id_dot_khuyen_mai=?";
		try (PreparedStatement ps = connection.getConnection().prepareStatement(query)) {
			ps.setString(1, dot.getNgayBatDau().toString().replace("T", " "));
			ps.setString(2, dot.getNgayKetThuc().toString().replace("T", " "));
			ps.setFloat(3, dot.getGiaTri());
			ps.setInt(4, dot.getTrangThai());
			ps.setInt(5, dot.getIdDotKm());
			int rowsAffected = ps.executeUpdate();
			connection.close();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			connection.close();
			return false;
		}
	}

	public boolean deleteCT(KhuyenMai km) throws SQLException {
		ConnectionDB connection = new ConnectionDB();
		String query1 = "DELETE FROM chi_tiet_khuyen_mai\r\n" + //
				"WHERE id_dot_khuyen_mai IN (\r\n" + //
				"\tSELECT id_dot_khuyen_mai\r\n" + //
				"    FROM dot_khuyen_mai\r\n" + //
				String.format("    WHERE dot_khuyen_mai.ma_khuyen_mai = '%s'\r\n", km.getMakm()) + //
				")";
		String.format("WHERE dot_khuyen_mai.ma_khuyen_mai = '%s'", km.getMakm());
		String query2 = String.format("DELETE FROM dot_khuyen_mai WHERE ma_khuyen_mai='%s'", km.getMakm());
		String query3 = String.format("DELETE FROM khuyen_mai WHERE ma_khuyen_mai='%s'", km.getMakm());
		connection.executeUpdate(query1);
		connection.executeUpdate(query2);
		connection.executeUpdate(query3);
		
//		PreparedStatement ps1 = connection.getConnection().prepareStatement(query1);
//		ps1.executeUpdate();
//		PreparedStatement ps2 = connection.getConnection().prepareStatement(query2);
//		ps2.setString(1, km.getMakm());
//		ps2.executeUpdate();
//		PreparedStatement ps3 = connection.getConnection().prepareStatement(query3);
//		ps3.setString(1, km.getMakm());
//		ps3.executeUpdate();
//		PreparedStatement ps4 = connection.getConnection().prepareStatement(query4);
//		ps4.executeUpdate();
		return false;
	}

	public Boolean existSP(int id) {
		ConnectionDB connection = new ConnectionDB();
		Boolean flag = false;
		int count = 0;
		String query = "SELECT COUNT(ma_san_pham) FROM chi_tiet_khuyen_mai WHERE id_dot_khuyen_mai=" + id;
		try {
			ResultSet result = connection.executeQuery(query);
			if (result != null)
				while (result.next()) {
					count = result.getInt(1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count>0)
			flag = true;
		return flag;
		
//		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query)) {
//			count = preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			// Handle the exception as needed, e.g., logging and error messages
//			System.out.println(e.getMessage());
//		}
//		if (count > 0)
//			flag = true;
//		return flag;
	}

	public boolean deleteDot(int id) throws SQLException {
		ConnectionDB connection = new ConnectionDB();
		String query1 = "SET GLOBAL foreign_key_checks = 0";
		String query2 = "DELETE FROM chi_tiet_khuyen_mai WHERE id_dot_khuyen_mai="+id;
		String query3 = "DELETE FROM dot_khuyen_mai WHERE id_dot_khuyen_mai="+id;
		String query4 = "SET GLOBAL foreign_key_checks = 1";
		
		connection.executeUpdate(query1);
		connection.executeUpdate(query2);
		connection.executeUpdate(query3);
		connection.executeUpdate(query4);

		return true;
	}

	public List<List<Object>> searchFilterDot(ArrayList<String> filterForm) {
		ConnectionDB connection = new ConnectionDB();
		List<List<Object>> listDot = new ArrayList<>();
		List<Object> listMaCT = new ArrayList<>();
		List<Object> listIdDot = new ArrayList<>();
		List<Object> listBatDau = new ArrayList<>();
		List<Object> listKetThuc = new ArrayList<>();
		List<Object> listGiaTri = new ArrayList<>();
		List<Object> listStatus = new ArrayList<>();

		String chuongTrinh = filterForm.get(0);
		String sanPham = filterForm.get(1);
		String status = filterForm.get(4);

		String query = "SELECT dot_khuyen_mai.ma_khuyen_mai, dot_khuyen_mai.id_dot_khuyen_mai, dot_khuyen_mai.ngay_bat_dau, dot_khuyen_mai.gia_tri, dot_khuyen_mai.ngay_ket_thuc, dot_khuyen_mai.trang_thai"
				+ " FROM dot_khuyen_mai"
				+ " WHERE dot_khuyen_mai.ma_khuyen_mai IN("
				+ " SELECT khuyen_mai.ma_khuyen_mai"
				+ " FROM khuyen_mai"
				+ " WHERE";
		switch (status) {
			case "Tất cả":
				query += " (khuyen_mai.trang_thai=0 OR khuyen_mai.trang_thai=1)";
				break;
			case "Không hoạt động":
				query += " khuyen_mai.trang_thai=0";
				break;
			case "Đang hoạt động":
				query += " khuyen_mai.trang_thai=1";
				break;
		}
		if (!chuongTrinh.isEmpty())
			query += " AND (khuyen_mai.ma_khuyen_mai LIKE '%" + chuongTrinh + "%'"
					+ " OR khuyen_mai.ten_khuyen_mai LIKE '%" + chuongTrinh + "%')";
		query += ")";
		query += " AND (dot_khuyen_mai.ngay_bat_dau>='" + filterForm.get(2) + "' AND"
				+ " dot_khuyen_mai.ngay_ket_thuc<='" + filterForm.get(3) + "')";
		try {
			ResultSet result = connection.executeQuery(query);
			if (result != null)
				while (result.next()) {
					String maCT = result.getString("ma_khuyen_mai");
					String idDot = result.getString("id_dot_khuyen_mai");
					LocalDateTime batDau = LocalDateTime.parse(result.getString("ngay_bat_dau").replace(" ", "T"));
					LocalDateTime ketThuc = LocalDateTime.parse(result.getString("ngay_ket_thuc").replace(" ", "T"));
					float giaTri = result.getFloat("gia_tri");
					int trangThai = result.getInt("trang_thai");
					listMaCT.add(maCT);
					listIdDot.add(idDot);
					listBatDau.add(batDau);
					listKetThuc.add(ketThuc);
					listGiaTri.add(giaTri);
					listStatus.add(trangThai);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listDot.add(0, listMaCT);
		listDot.add(1, listIdDot);
		listDot.add(2, listBatDau);
		listDot.add(3, listKetThuc);
		listDot.add(4, listGiaTri);
		listDot.add(5, listStatus);

		return listDot;
	}

	public List<List<Object>> searchFilterSP(ArrayList<String> filterForm) {
		ConnectionDB connection = new ConnectionDB();
		List<List<Object>> listSP = new ArrayList<>();
		List<Object> listIdDot = new ArrayList<>();
		List<Object> listMaSP = new ArrayList<>();
		List<Object> listTenSP = new ArrayList<>();

		String chuongTrinh = filterForm.get(0);
		String sanPham = filterForm.get(1);
		String status = filterForm.get(4);
		String query = "SELECT chi_tiet_khuyen_mai.id_dot_khuyen_mai, chi_tiet_khuyen_mai.ma_san_pham, san_pham.ten_san_pham"
				+ " FROM chi_tiet_khuyen_mai JOIN san_pham"
				+ " WHERE chi_tiet_khuyen_mai.ma_san_pham=san_pham.ma_san_pham"
				+ " AND chi_tiet_khuyen_mai.id_dot_khuyen_mai IN"
				+ " (SELECT dot_khuyen_mai.id_dot_khuyen_mai FROM dot_khuyen_mai"
				+ " WHERE dot_khuyen_mai.ma_khuyen_mai IN("
				+ " SELECT khuyen_mai.ma_khuyen_mai FROM khuyen_mai"
				+ " WHERE";
		switch (status) {
			case "Tất cả":
				query += " (khuyen_mai.trang_thai=0 OR khuyen_mai.trang_thai=1)";
				break;
			case "Không hoạt động":
				query += " khuyen_mai.trang_thai=0";
				break;
			case "Đang hoạt động":
				query += " khuyen_mai.trang_thai=1";
				break;
		}
		if (!chuongTrinh.isEmpty())
			query += " AND (khuyen_mai.ma_khuyen_mai LIKE '%" + chuongTrinh + "%'"
					+ " OR khuyen_mai.ten_khuyen_mai LIKE '%" + chuongTrinh + "%')"; // first parent
		query += " AND (dot_khuyen_mai.ngay_bat_dau>='" + filterForm.get(2) + "' AND"
				+ " dot_khuyen_mai.ngay_ket_thuc<='" + filterForm.get(3) + "')";
		query += "))"; // second parent

		if (!sanPham.isEmpty())
			query += " AND (san_pham.ma_san_pham LIKE '%" + sanPham + "%'"
					+ " OR san_pham.ten_san_pham LIKE '%" + sanPham + "%')";

		try {
			ResultSet result = connection.executeQuery(query);
			if (result != null)
				while (result.next()) {
					int idDot = result.getInt("id_dot_khuyen_mai");
					String maSP = result.getString("ma_san_pham");
					String tenSP = result.getString("ten_san_pham");
					listIdDot.add(idDot);
					listMaSP.add(maSP);
					listTenSP.add(tenSP);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listSP.add(0, listIdDot);
		listSP.add(1, listMaSP);
		listSP.add(2, listTenSP);
		return listSP;
	}

	//GET DOT BY ID 
	public DotKhuyenMai getDKMByIdFromDB(int idDKM) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select khuyen_mai.ma_khuyen_mai, ten_khuyen_mai, " +
				"ngay_bat_dau, ngay_ket_thuc, gia_tri, dot_khuyen_mai.trang_thai " +
				"from dot_khuyen_mai join khuyen_mai on dot_khuyen_mai.ma_khuyen_mai = khuyen_mai.ma_khuyen_mai " +
				String.format("where id_dot_khuyen_mai = '%s'", idDKM);
		ResultSet rs = condb.executeQuery(sql);
		try {
			while (rs.next()) {
				return new DotKhuyenMai(
						idDKM,
						new KhuyenMai(rs.getString("ma_khuyen_mai"), rs.getString("ten_khuyen_mai")),
						LocalDateTime.parse(rs.getString("ngay_bat_dau").replace(" ", "T")),
						LocalDateTime.parse(rs.getString("ngay_ket_thuc").replace(" ", "T")),
						rs.getFloat("gia_tri"),
						rs.getInt("trang_thai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
