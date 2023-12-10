package BUS;

import java.util.ArrayList;

import DAO.HoaDonBanMoiDAO;
import DAO.HoaDonMuaMoiDAO;
import DAO.KhachHangDAO;
import DTO.ChiTietHDB;
import DTO.ChiTietHDM;
import DTO.HoaDonBan;
import DTO.HoaDonMua;
import DTO.KhachHang;
import DTO.SanPham;

public class HoaDonBanMoiBUS {

	private HoaDonBanMoiDAO hdbmDAO;

	public HoaDonBanMoiBUS(HoaDonBanMoiDAO hdbmDAO) {
		this.hdbmDAO = hdbmDAO;
	}

	public HoaDonBanMoiBUS() {
	}

	public HoaDonBan getHDB() {
		return hdbmDAO.getHDB();
	}

	public int[] getQuyUocDiem () {
		return hdbmDAO.getQuyUocDiem();
	}

	public void getDsSanPhamFromDB () {
		hdbmDAO.getDsSanPhamFromDB();
	}

	public SanPham getSelectedSP(int row) {
		return hdbmDAO.getSanPham(row);
	}

	public SanPham getSelectedSP(String masp) {
		return hdbmDAO.getSanPham(masp);
	}

	public HoaDonBanMoiDAO getHdbmDAO() {
		return hdbmDAO;
	}

	public ChiTietHDB getSelectedCthdb(int row) {
		return hdbmDAO.getCTHDB(row);
	}

	public void setHdbmDAO(HoaDonBanMoiDAO hdbmDAO) {
		this.hdbmDAO = hdbmDAO;
	}

	public String[][] getDsSanPham() {
		ArrayList<SanPham> dsSanPham = hdbmDAO.getDsSanPham();
		int length = dsSanPham.size();
		String[][] data = new String[length][5];
		for (int i = 0; i < length; i++) {
			SanPham sp = dsSanPham.get(i);
			data[i][0] = sp.getMaSP();
			data[i][1] = sp.getTenSP();
			data[i][2] = sp.getSoLuong() + "";
			data[i][3] = sp.getTrangThaiText();
			data[i][4] = sp.getGiaBan() + "";
		}
		return data;
	}

	public String[][] getDsCTHDB() {
		ArrayList<ChiTietHDB> dsCTHDB = hdbmDAO.getDsChiTietHDB();
		int length = dsCTHDB.size();
		String[][] data = new String[length][4];
		for (int i = 0; i < length; i++) {
			SanPham sp = dsCTHDB.get(i).getSanPham();
			data[i][0] = sp.getMaSP();
			data[i][1] = sp.getTenSP();
			data[i][2] = sp.getSoLuong() + "";
			data[i][3] = dsCTHDB.get(i).getTongTien() + "";

		}
		return data;
	}

	public int existsCthdb(ChiTietHDB cthdb) {
		int exists = -1;
		int index = 0;
		ArrayList<ChiTietHDB> dsCTHDB = hdbmDAO.getDsChiTietHDB();
		for (ChiTietHDB ct : dsCTHDB) {
			if (ct.getSanPham().getMaSP().equals(cthdb.getSanPham().getMaSP())) {
				exists = index;
				break;
			}
			index++;
		}
		return exists;
	}

	public boolean isSameSanPham(ChiTietHDB cthdb) {
		boolean same = false;
		ArrayList<ChiTietHDB> dsCTHDB = hdbmDAO.getDsChiTietHDB();
		for (ChiTietHDB ct : dsCTHDB) {
			if (ct.getSanPham().getMaSP().equals(cthdb.getSanPham().getMaSP())) {
				same = true;
			}
		}
		return same;
	}

	public void addHDB(HoaDonBan hdb) {
		new HoaDonBanMoiDAO().addHDB(hdb);
		;
	}

	public void filteredDsSPByMa(String value) {
		hdbmDAO.filteredDsSPByMa(value);
	}

	public void filteredDsSPByTen(String value) {
		hdbmDAO.filteredDsSPByTen(value);
	}

	public void themCTHDB(ChiTietHDB cthdb) {

		hdbmDAO.themCTHDB(cthdb);
	}

	public void themCTHDB(int selectedCTHBIndex, ChiTietHDB cthdb) {
		hdbmDAO.themCTHDB(selectedCTHBIndex, cthdb);
	}

	public void suaCTHDB(int selectedCTHDMIndex, ChiTietHDB cthdmUpdated) {
		hdbmDAO.suaCTHDB(selectedCTHDMIndex, cthdmUpdated);
	}

	public void xoaCTHDB(int selectedCTHDMIndex) {
		hdbmDAO.xoaCTHDB(selectedCTHDMIndex);
	}

	public void resetHDB() {
		hdbmDAO.resetHDB();
	}

	public ArrayList<KhachHang> FindKH(String name) {
		ArrayList<KhachHang> list = new HoaDonBanMoiDAO().FindKH(name);
		return list;
	}

	public void restoreDSPP() {
		hdbmDAO.restoreDSSP();
	}
	
	public void handleThemHDB(int t) {
        hdbmDAO.handleThemHDB(t);
    }
}
