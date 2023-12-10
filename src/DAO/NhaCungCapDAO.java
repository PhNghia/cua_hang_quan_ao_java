package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DTO.ConnectionDB;
import DTO.NhaCungCap;

public class NhaCungCapDAO {
	private ArrayList<NhaCungCap> dsncc;

	public ArrayList<NhaCungCap> getDsncc() {
		return dsncc;
	}

	public void setDsncc(ArrayList<NhaCungCap> dsncc) {
		this.dsncc = dsncc;
	}

	public NhaCungCapDAO() {
	}

	public void getDsNccFromDB() {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select * from nha_cung_cap order by trang_thai desc, ten_ncc";
		ResultSet rs = condb.executeQuery(sql);
		try {
			dsncc = new ArrayList<NhaCungCap>();
			while (rs.next()) {
				dsncc.add(new NhaCungCap(
						rs.getInt("ma_ncc"),
						rs.getString("ten_ncc"),
						rs.getString("sdt"),
						rs.getString("dia_chi"),
						rs.getInt("trang_thai")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void filteredDsNcc(String type, String value, String statusText) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select * from nha_cung_cap where ";
		switch (type) {
			case "Tất cả":
				sql += "(ten_ncc like '%" + value + "%' or sdt like '%" + value + "%') ";
				break;
			case "Nhà cung cấp":
				sql += "ten_ncc like '%" + value + "%' ";
				break;
			case "Số điện thoại":
				sql += "sdt like '%" + value + "%' ";
				break;
		}
		switch (statusText) {
			case "Tất cả":
				break;
			case "Đang hợp tác":
				sql += " and trang_thai = 1 ";
				break;
			case "Ngừng hợp tác":
				sql += " and trang_thai = 0 ";
				break;
		}
		sql += "order by trang_thai desc, ten_ncc";
		ResultSet rs = condb.executeQuery(sql);
		try {
			dsncc = new ArrayList<NhaCungCap>();
			while (rs.next()) {
				dsncc.add(new NhaCungCap(
						rs.getInt("ma_ncc"),
						rs.getString("ten_ncc"),
						rs.getString("sdt"),
						rs.getString("dia_chi"),
						rs.getInt("trang_thai")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NhaCungCap getNccByTen(String ten) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select * from nha_cung_cap where ten_ncc = '" + ten + "'";
		ResultSet rs = condb.executeQuery(sql);
		try {
			if (rs.next()) {
				return new NhaCungCap(
						rs.getInt("ma_ncc"),
						rs.getString("ten_ncc"),
						rs.getString("sdt"),
						rs.getString("dia_chi"),
						rs.getInt("trang_thai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public NhaCungCap getNccBySdt(String sdt) {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select * from nha_cung_cap where sdt = '" + sdt + "'";
		ResultSet rs = condb.executeQuery(sql);
		try {
			if (rs.next()) {
				return new NhaCungCap(
						rs.getInt("ma_ncc"),
						rs.getString("ten_ncc"),
						rs.getString("sdt"),
						rs.getString("dia_chi"),
						rs.getInt("trang_thai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void themNcc(NhaCungCap newNcc) {
		ConnectionDB condb = new ConnectionDB();
		String sql = String.format(
				"insert into nha_cung_cap (ten_ncc, sdt, dia_chi, trang_thai) values ('%s', '%s', '%s', %s)",
				newNcc.getTenNcc(), newNcc.getSdt(), newNcc.getDiaChi(), newNcc.getTrangThai());
		condb.executeUpdate(sql);
	}

	public void suaNcc(int row, NhaCungCap updateNcc) {
		ConnectionDB condb = new ConnectionDB();
		String sql = String.format(
				"update nha_cung_cap set ten_ncc = '%s', sdt = '%s', dia_chi = '%s', trang_thai = %s where ma_ncc = %s",
				updateNcc.getTenNcc(), updateNcc.getSdt(), updateNcc.getDiaChi(), updateNcc.getTrangThai(), dsncc.get(row).getMaNcc());
		condb.executeUpdate(sql);
	}
}
