package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	
	public ArrayList<SanPham> getSanPham(){
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
					
					sanPhamList.add(new SanPham(maSP,tenSP,chatLieu,kichCo,mauSac,giaBan,soLuong,hinhAnh,trangThai));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanPhamList;
	}
	
	public SanPham getChiTiet(String ma){
		SanPham sp = new SanPham();
		String query = "SELECT * FROM san_pham WHERE hien_thi = 1 AND ma_san_pham = '"+ma+"'";
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
					
					sp = new SanPham(maSP,tenSP,chatLieu,kichCo,mauSac,giaBan,soLuong,hinhAnh,trangThai);
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
		checkList.add(0,ma); checkList.add(1,hienthi);
		return checkList;
	}
	
	public boolean insertNew(SanPham sp) {
		String query = "INSERT INTO san_pham (ma_san_pham,ten_san_pham,chat_lieu,kich_co,mau_sac,gia_ban,so_luong,hinh_anh,trang_thai,hien_thi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, sp.getMaSP());
			preparedStatement.setString(2, sp.getTenSP());
			preparedStatement.setString(3, sp.getChatLieu());
			preparedStatement.setString(4, sp.getKichCo());
			preparedStatement.setString(5, sp.getMauSac());
			preparedStatement.setInt(6, sp.getGiaBan());
			preparedStatement.setInt(7, 0);
			preparedStatement.setString(8, sp.getHinhAnh());
			preparedStatement.setInt(9, 1);
			preparedStatement.setInt(10, 1);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateSanPham(SanPham sp) {
		String query = "UPDATE san_pham SET ten_san_pham = ?, "
				+ "chat_lieu = ?,  mau_sac = ?, gia_ban = ?, kich_co = ?, "
				+ "hinh_anh = ?, trang_thai = ? WHERE ma_san_pham = ?";
		try (PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, sp.getTenSP());
			preparedStatement.setString(2, sp.getChatLieu());
			preparedStatement.setString(3, sp.getMauSac());
			preparedStatement.setInt(4, sp.getGiaBan());
			preparedStatement.setString(5, sp.getKichCo());
			preparedStatement.setString(6, sp.getHinhAnh());
			preparedStatement.setInt(7, sp.getTrangThai());
			preparedStatement.setString(8, sp.getMaSP());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Handle the exception as needed, e.g., logging and error messages
			System.out.println(e.getMessage());
			return false;
		}
				
	}
	
	public boolean deleteSanPham(String maSP) {
		return this.connection.sqlUpdate("UPDATE san_pham SET hien_thi=0 WHERE ma_san_pham = '" + maSP + "';",null);
	}
	public ArrayList<SanPham> searchSanPham(String type, ArrayList<Object> search) {
		String query="";
		ArrayList<SanPham> spList = new ArrayList<>();
		//check search type
		if(type.equals("Tất cả")) 
			query = "SELECT * FROM san_pham WHERE (ma_san_pham LIKE N'%"+search.get(0)+
					"%' OR ten_san_pham LIKE N'%"+search.get(0)+"%') ";
		else if(type.equals("Mã"))
			query = "SELECT * FROM san_pham WHERE ma_san_pham LIKE '%"+search.get(0)+"%' ";			
		else
			query = "SELECT * FROM san_pham WHERE ten_san_pham LIKE '%"+search.get(0)+"%' ";
		//check status 
		if(Integer.valueOf((int)search.get(1))!=0) {  
			System.out.println("sttElse");
			query += "AND trang_thai = " + (Integer.valueOf((int)search.get(1))-1) ;
		}
		
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
					SanPham sp = new SanPham(maSP,tenSP,chatLieu,kichCo,mauSac,giaBan,soLuong,hinhAnh,trangThai);
					spList.add(sp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spList;
	}
}