package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import DTO.ChiTietHDB;
import DTO.ChiTietHDM;
import DTO.ConnectionDB;
import DTO.HoaDonBan;
import DTO.HoaDonMua;
import DTO.KhachHang;
import DTO.SanPham;
import GUI.MenuGUI;

public class HoaDonBanMoiDAO {
	private HoaDonBan hdb;
	private ArrayList<SanPham> dsSanPham;
	private ArrayList<SanPham> filteredDsSanPham;
	private ArrayList<ChiTietHDB> dsCTHDB;
	private ArrayList<String> dsHDB;
	private ArrayList<KhachHang> dsKH;

	public HoaDonBanMoiDAO() {
		dsSanPham = new ArrayList<>();
		dsCTHDB = new ArrayList<>();

		createHDBM();
		getDsSanPhamFromDB();
	}

	public void addHDB(HoaDonBan a) {
		String sql = "INSERT INTO `hoa_don_ban` (`ma_hoa_don`, `ma_khach_hang`, `ma_nhan_vien`, `ngay_tao`, `tong_tien`) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = new ConnectionDB().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			// Set parameters for the prepared statement
			ps.setString(1, a.getMaHD());
			ps.setInt(2, a.getKhachHang().getMaKH());
			ps.setInt(3, a.getNhanVien().getMaNhanVien());
			ps.setTimestamp(4, Timestamp.valueOf(a.getNgayTao()));
			ps.setInt(5, a.getTongTien());

			// Execute the update
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("HoaDonBan added successfully.");
			} else {
				System.out.println("Failed to add HoaDonBan.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createHDBM() {
		hdb = new HoaDonBan();
        hdb.setTongTien(0);
        String today = LocalDate.now().toString().replaceAll("-", "");
        String sql = "select ma_hoa_don from hoa_don_ban where ma_hoa_don like '%" + today + "%' order by ngay_tao desc limit 1";
        ConnectionDB con = new ConnectionDB();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs.next()) {
                String mahd = rs.getString(1);
                int number = Integer.parseInt(mahd.substring(mahd.lastIndexOf("N") + 1));
                hdb.setMaHD("HDB" + today + "N" + (number + 1));
            } else {
                hdb.setMaHD("HDB" + today + "N1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void getDsSanPhamFromDB() {
		String sql = "select * from san_pham where trang_thai = 2 and hien_thi = 1";
		ConnectionDB con = new ConnectionDB();
		ResultSet rs = con.executeQuery(sql);
		try {
			dsSanPham = new ArrayList<>();
			while (rs.next()) {
				SanPham sp = new SanPham(rs.getString("ma_san_pham"), rs.getString("ten_san_pham"),
						rs.getString("chat_lieu"), rs.getString("kich_co"), rs.getString("mau_sac"),
						rs.getInt("gia_ban"), rs.getInt("so_luong"), rs.getInt("trang_thai"));
				dsSanPham.add(sp);
			}
			filteredDsSanPham = (ArrayList<SanPham>) dsSanPham.clone();
		} catch (SQLException e) {
		}
	}

	public ArrayList<KhachHang> FindKH(String name) {
		ArrayList<KhachHang> list = new ArrayList<>();
		String sql = "SELECT * FROM khach_hang WHERE sdt =" + name + "";
		ConnectionDB con = new ConnectionDB();
		ResultSet rs = con.executeQuery(sql);
		try {
			while (rs.next()) {
				KhachHang s = new KhachHang(rs.getInt("ma_khach_hang"), rs.getString("ten_khach_hang"),
						rs.getString("sdt"), rs.getInt("tien_tich_luy"), rs.getInt("diem_tich_luy"),
						rs.getInt("bang_tien"));
				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println("HDBM DAO FindKH(): error");
		}
		return list;
	}

	public void handleThemHDB(int t) {
        try {
            ConnectionDB con = new ConnectionDB();
            String sql = String.format(
                    "insert into hoa_don_ban (ma_hoa_don,ma_khach_hang, ma_nhan_vien, ngay_tao, tong_tien) " +
                            "values ('%s', '%s','%s', '%s', %s)",
                    hdb.getMaHD(),
                    String.valueOf(t),
//                    MenuGUI.nv.getMaNhanVien(),
                    "1",
                    LocalDateTime.now().toString(),
                    hdb.getTongTien());
            con.executeUpdate(sql);
            sql = "";
            sql = "insert into chi_tiet_hoa_don_ban (ma_hoa_don, ma_san_pham, ten_san_pham ,gia_ban , giam_gia, so_luong, tong_tien) values ";
            for (ChiTietHDB ct : dsCTHDB) {
                sql += String.format("('%s', '%s', '%s', %s, %s, %s, %s), ",
                        hdb.getMaHD(),
                        ct.getSanPham().getMaSP(),
                        ct.getSanPham().getTenSP(),
                        ct.getSanPham().getGiaBan(),
                        "0",
                        ct.getSanPham().getSoLuong(),
                        ct.getTongTien());
            }
            sql = sql.substring(0, sql.length() - 2);
            con.executeUpdate(sql);
			sql = "update san_pham set so_luong = so_luong - case ";
            String rangeCondition = "";
            for (ChiTietHDB ct : dsCTHDB) {
                sql += String.format(
                        "when ma_san_pham = '%s' then %s ",
                        ct.getSanPham().getMaSP(), ct.getSanPham().getSoLuong());
                rangeCondition += String.format("'%s',", ct.getSanPham().getMaSP());
            }
            rangeCondition = rangeCondition.substring(0, rangeCondition.length() - 1);
            sql += String.format("end where ma_san_pham in (%s)", rangeCondition);
            con.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//	public void Insert(HoaDonBan hdb) {
//		String maHDB = 
//		
//		String query = String.format(
//				"insert into hoa_don_ban (ma_hoa_don,ma_khach_hang, ma_nhan_vien, ngay_tao, tong_tien) values ('%s', '%s','%s', '%s', %s)",
//				"");
//
//		try {
//			ConnectionDB con = new ConnectionDB();
//			con.executeUpdate(query);
////            PreparedStatement ps = con.prepareStatement(query);
//
////            ps.setString(1, item.getId());
////            ps.setString(2, item.getItem());
////            ps.setObject(3, Timestamp.valueOf(item.getDateTime()));
////            ps.setFloat(4, item.getCount());
////            ps.setBoolean(5, item.isIsItem());
////            ps.setInt(6, item.getPrice());
////            if (ps.executeUpdate() == 0) {
////            }
//
////            ps.close();
//			con.close();
//		} catch (SQLException e) {
//		}
//
//	}

	public void themCTHDB(ChiTietHDB cthdb) {
		dsCTHDB.add(cthdb);
		updateTongTienHDB("add", cthdb);
	}

	public void xoaCTHDB(int selectedCTHDMIndex) {
		ChiTietHDB selectedCTHDB = dsCTHDB.get(selectedCTHDMIndex);
		dsCTHDB.remove(selectedCTHDMIndex);
		updateTongTienHDB("delete", selectedCTHDB);
	}

	public void suaCTHDB(int selectedCTHDMIndex, ChiTietHDB cthdmUpdated) {
		ChiTietHDB selectedCTHDM = dsCTHDB.get(selectedCTHDMIndex);
		dsCTHDB.set(selectedCTHDMIndex, cthdmUpdated);
		updateTongTienHDB(selectedCTHDM, cthdmUpdated);
	}

	public void themCTHDB(int selectedCTHDMIndex, ChiTietHDB cthdb) {
		ChiTietHDB selectedCTHDB = dsCTHDB.get(selectedCTHDMIndex);
		updateTongTienHDB("delete", selectedCTHDB);
		selectedCTHDB.getSanPham()
				.setSoLuong(selectedCTHDB.getSanPham().getSoLuong() + cthdb.getSanPham().getSoLuong());
		selectedCTHDB.setTongTien(selectedCTHDB.getSanPham().getSoLuong() * cthdb.getSanPham().getGiaBan());
		updateTongTienHDB("add", selectedCTHDB);
	}

	public void resetHDB() {
		dsCTHDB = new ArrayList<>();

	}

	public void updateTongTienHDB(String action, ChiTietHDB cthdb) {
		switch (action) {
		case "add":
			hdb.setTongTien(hdb.getTongTien() + cthdb.getTongTien());
			break;
		case "delete":
			hdb.setTongTien(hdb.getTongTien() - cthdb.getTongTien());
			break;
		}
	}

	public void updateTongTienHDB(ChiTietHDB cthdm, ChiTietHDB cthdmUpdated) {
		hdb.setTongTien(hdb.getTongTien() - cthdm.getTongTien() + cthdmUpdated.getTongTien());
	}

	public SanPham getSanPham(int row) {
		return filteredDsSanPham.get(row);
	}

	public SanPham getSanPham(String masp) {
		for (SanPham ph : filteredDsSanPham) {
			if (ph.getMaSP().equals(masp)) {
				return ph;
			}
		}
		return null;
	}

	public ChiTietHDB getCTHDB(int row) {
		return dsCTHDB.get(row);
	}

	public HoaDonBan getHDB() {
		return hdb;
	}

	public void setHdb(HoaDonBan hdb) {
		this.hdb = hdb;
	}

	public ArrayList<SanPham> getDsSanPham() {
		return dsSanPham;
	}

	public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}

	public ArrayList<SanPham> getFilteredDsSanPham() {
		return filteredDsSanPham;
	}

	public void setFilteredDsSanPham(ArrayList<SanPham> filteredDsSanPham) {
		this.filteredDsSanPham = filteredDsSanPham;
	}

	public ArrayList<ChiTietHDB> getDsChiTietHDB() {
		return dsCTHDB;
	}

	public void setDsChiTietHDB(ArrayList<ChiTietHDB> dsChiTietHDB) {
		this.dsCTHDB = dsChiTietHDB;
	}

	public void filteredDsSPByMa(String value) {
		filteredDsSanPham = new ArrayList<>();
		for (SanPham sp : dsSanPham) {
			if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())) {
				filteredDsSanPham.add(sp);
			}
		}
	}

	public void filteredDsSPByTen(String value) {
		filteredDsSanPham = new ArrayList<>();
		for (SanPham sp : dsSanPham) {
			if (sp.getTenSP().toLowerCase().contains(value.toLowerCase())) {
				filteredDsSanPham.add(sp);
			}
		}
	}

	public void restoreDSSP() {
		filteredDsSanPham = (ArrayList<SanPham>) dsSanPham.clone();
	}

	public int[] getQuyUocDiem () {
		ConnectionDB condb = new ConnectionDB();
		String sql = "select * from quy_uoc_tich_diem";
		ResultSet rs = condb.executeQuery(sql);
		try {
			if (rs.next()) {
				return new int[] {rs.getInt("menh_gia"), rs.getInt("bang_diem"), rs.getInt("bang_tien")};
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new int[] { 10000, 1, 100 };
	}

}
