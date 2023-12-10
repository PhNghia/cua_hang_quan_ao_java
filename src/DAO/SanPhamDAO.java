package DAO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import DTO.ConnectionDB;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.TaiKhoan;

public class SanPhamDAO {
	private ConnectionDB connection;

	public SanPhamDAO() {
		this.connection = new ConnectionDB();
	}

	public ArrayList<SanPham> getSanPham() {
		ArrayList<SanPham> sanPhamList = new ArrayList<>();
		String query = "SELECT * FROM san_pham WHERE hien_thi=1";
		try {
			ResultSet result = this.connection.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					String maSP = result.getString("ma_san_pham");
					String tenSP = result.getString("ten_san_pham");
					String chatLieu = result.getString("chat_lieu");
					String kichCo = result.getString("kich_co");
					String mauSac = result.getString("mau_sac");
					int giaBan = result.getInt("gia_ban");
					int soLuong = result.getInt("so_luong");
					String hinhAnh = result.getString("hinh_anh");
					int trangThai = result.getInt("trang_thai");

					sanPhamList.add(
							new SanPham(maSP, tenSP, chatLieu, kichCo, mauSac, giaBan, soLuong, hinhAnh, trangThai));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanPhamList;
	}

	public SanPham getChiTiet(String ma) {
		SanPham sp = new SanPham();
		String query = "SELECT * FROM san_pham WHERE ma_san_pham = '" + ma + "'";
		try {
			ResultSet result = this.connection.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					String maSP = result.getString("ma_san_pham");
					String tenSP = result.getString("ten_san_pham");
					String chatLieu = result.getString("chat_lieu");
					String kichCo = result.getString("kich_co");
					String mauSac = result.getString("mau_sac");
					int giaBan = result.getInt("gia_ban");
					int soLuong = result.getInt("so_luong");
					String hinhAnh = result.getString("hinh_anh");
					int trangThai = result.getInt("trang_thai");

					sp = new SanPham(maSP, tenSP, chatLieu, kichCo, mauSac, giaBan, soLuong, hinhAnh, trangThai);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp;
	}

	public List<List<String>> getMaList() {
		List<List<String>> checkList = new ArrayList<>();
		List<String> ma = new ArrayList<>();
		List<String> hienthi = new ArrayList<>();
		String query = "SELECT * FROM san_pham";
		try {
			ResultSet result = this.connection.executeQuery(query);
			if (result != null)
				while (result.next()) {
					String maSP = result.getString("ma_san_pham");
					String hienThi = String.valueOf(result.getInt("hien_thi"));
					ma.add(maSP);
					hienthi.add(hienThi);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkList.add(0, ma);
		checkList.add(1, hienthi);
		return checkList;
	}

	public void deleteImageInFolder(String source) {
		try {
			Files.delete(new File(source).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String handleImage(SanPham sp) {
		String newPath = "upload/productImages";
		File directory = new File(newPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File sourceFile = null;
		File destinationFile = null;
		String extension;
		if (sp.getHinhAnh().lastIndexOf('.') == -1) {
			extension = "png";
		} else {
			extension = sp.getHinhAnh().substring(sp.getHinhAnh().lastIndexOf('.') + 1);
			if (!extension.contains("png") && !extension.contains("jpeg") && !extension.contains("jpg")) {
				extension = "png";
			}
		}
		sourceFile = new File(sp.getHinhAnh());
		destinationFile = new File(newPath +
				String.format(
						"/ảnh_%s_%s.",
						sp.getTenSP().replaceAll(" ", "_"),
						new Date().getTime())
				+ extension);
		try {
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
			return destinationFile.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			try (InputStream in = new URL(sp.getHinhAnh()).openStream()) {
				Files.copy(in, Paths.get(destinationFile.toURI()));
			}
			// System.out.println("Hello");
			// URL url = new URL(sp.getHinhAnh());
			// BufferedImage img = ImageIO.read(url);
			// File file = new File(destinationFile.toString());
			// ImageIO.write(img, extension, file);
			// System.out.println("end");
			return destinationFile.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public boolean insertNew(SanPham sp) {
		String hinhanh = "";
		if (!sp.getHinhAnh().isEmpty()) {
			hinhanh = handleImage(sp);
		}
		String query = "INSERT INTO san_pham " +
				"(ma_san_pham,ten_san_pham,chat_lieu,kich_co,mau_sac,gia_ban,so_luong,hinh_anh,trang_thai,hien_thi) values "
				+
				"(?, ?, ?, ?, ?, ?, 0, ?, 1, 1)";

		// ConnectionDB condb = new ConnectionDB();
		// condb.executeUpdate(query);
		// return true;

		try (PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, sp.getMaSP());
			preparedStatement.setString(2, sp.getTenSP());
			preparedStatement.setString(3, sp.getChatLieu());
			preparedStatement.setString(4, sp.getKichCo());
			preparedStatement.setString(5, sp.getMauSac());
			preparedStatement.setInt(6, sp.getGiaBan());
			preparedStatement.setString(7, hinhanh);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateSanPham(SanPham sp) {
		String oldHinhanh = "";
		String sql = String.format("select hinh_anh from san_pham where ma_san_pham = '%s'", sp.getMaSP());
		ResultSet rs = this.connection.executeQuery(sql);
		try {
			if (rs.next()) {
				oldHinhanh = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String hinhanh = "";
		if (!sp.getHinhAnh().isEmpty()) {
			hinhanh = handleImage(sp);
		}
		String query = "UPDATE san_pham SET ten_san_pham = ?, "
				+ "chat_lieu = ?,  mau_sac = ?, gia_ban = ?, kich_co = ?, "
				+ (hinhanh.isEmpty() ? "" : "hinh_anh = ?, ") + "trang_thai = ? WHERE ma_san_pham = ?";
		try (PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, sp.getTenSP());
			preparedStatement.setString(2, sp.getChatLieu());
			preparedStatement.setString(3, sp.getMauSac());
			preparedStatement.setInt(4, sp.getGiaBan());
			preparedStatement.setString(5, sp.getKichCo());
			int i = 6;
			if (!hinhanh.isEmpty()) {
				preparedStatement.setString(i, hinhanh);
			} else {
				i--;
			}
			preparedStatement.setInt(i + 1, sp.getTrangThai());
			preparedStatement.setString(i + 2, sp.getMaSP());
			int rowsAffected = preparedStatement.executeUpdate();
			if (!hinhanh.isEmpty() && !oldHinhanh.isEmpty()) {
				deleteImageInFolder(oldHinhanh);
			}
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			return false;
		}

	}

	public void deleteSanPham(String maSP, int typeDelete) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "";
		if (typeDelete == 0) {
			sql = String.format("delete from san_pham where ma_san_pham = '%s'", maSP);
		} else if (typeDelete == 1) {
			sql = String.format("update san_pham set hien_thi = 0 where ma_san_pham = '%s'", maSP);
		}
		condb.executeUpdate(sql);
	}

	public boolean checkSPJoinedHD(String maSP) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select * " +
				"from san_pham  " +
				String.format("where san_pham.ma_san_pham = '%s' and (exists ( ", maSP) +
				"    select * " +
				"    from chi_tiet_hoa_don_ban  " +
				"    where chi_tiet_hoa_don_ban.ma_san_pham = san_pham.ma_san_pham " +
				") or exists ( " +
				"    select * " +
				"    from chi_tiet_hoa_don_mua " +
				"    where chi_tiet_hoa_don_mua.ma_san_pham = san_pham.ma_san_pham " +
				"))";
		ResultSet rs = condb.executeQuery(sql);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<SanPham> searchSanPham(String type, ArrayList<Object> search) {
		String query = "";
		ArrayList<SanPham> spList = new ArrayList<>();
		// check search type
		if (type.equals("Tất cả"))
			query = "SELECT * FROM san_pham WHERE (ma_san_pham LIKE N'%" + search.get(0) +
					"%' OR ten_san_pham LIKE N'%" + search.get(0) + "%') ";
		else if (type.equals("Mã"))
			query = "SELECT * FROM san_pham WHERE ma_san_pham LIKE '%" + search.get(0) + "%' ";
		else
			query = "SELECT * FROM san_pham WHERE ten_san_pham LIKE '%" + search.get(0) + "%' ";
		// check status

		if (Integer.valueOf((int) search.get(1)) != 0) {
			System.out.println("sttElse");
			query += "AND trang_thai = " + (Integer.valueOf((int) search.get(1)) - 1) + " ";
		}

		query += "AND hien_thi = 1";

		try {
			ResultSet result = this.connection.executeQuery(query);
			if (result != null)
				while (result.next()) {
					String maSP = result.getString("ma_san_pham");
					String tenSP = result.getString("ten_san_pham");
					String chatLieu = result.getString("chat_lieu");
					String kichCo = result.getString("kich_co");
					String mauSac = result.getString("mau_sac");
					int giaBan = result.getInt("gia_ban");
					int soLuong = result.getInt("so_luong");
					String hinhAnh = result.getString("hinh_anh");
					int trangThai = result.getInt("trang_thai");
					SanPham sp = new SanPham(maSP, tenSP, chatLieu, kichCo, mauSac, giaBan, soLuong, hinhAnh,
							trangThai);
					spList.add(sp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spList;
	}

	public boolean checkAPDKMSP(String masp) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select * " +
				"from dot_khuyen_mai join chi_tiet_khuyen_mai on " +
				"dot_khuyen_mai.id_dot_khuyen_mai = chi_tiet_khuyen_mai.id_dot_khuyen_mai " +
				String.format("where ma_san_pham = '%s' and ", masp) +
				"dot_khuyen_mai.trang_thai != 0";
		ResultSet rs = condb.executeQuery(sql);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void stopSPADKM(String masp) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "delete from chi_tiet_khuyen_mai\r\n" +
				String.format("where ma_san_pham = '%s' and id_dot_khuyen_mai in (\r\n", masp) +
				"\tselect dot_khuyen_mai.id_dot_khuyen_mai \r\n" +
				"\tfrom dot_khuyen_mai\r\n" +
				"\twhere dot_khuyen_mai.trang_thai != 0\r\n" +
				")";
		condb.executeUpdate(sql);
	}
}