package BUS;

import java.util.ArrayList;

import DAO.HoaDonBanDAO;
import DTO.ChiTietHDB;
import DTO.ChiTietHDM;
import DTO.FormatValue;
import DTO.HoaDonBan;
import DTO.HoaDonMua;
import DTO.SanPham;

public class HoaDonBanBUS {

	private final HoaDonBanDAO hdbDAO;

	public HoaDonBanBUS(HoaDonBanDAO hdbDAO) {
		this.hdbDAO = hdbDAO;
	}
	public HoaDonBanBUS() {
		this.hdbDAO = new HoaDonBanDAO();
		
	}

	public void getDsHDBFromDB () {
		hdbDAO.getDsHDBMFromDb();
	}

	public String[][] getDsHDB() {
		ArrayList<HoaDonBan> dsHDB = hdbDAO.getDsHDB();
		int length = dsHDB.size();
		String[][] data = new String[length][5];
		for (int i = 0; i < length; i++) {
			data[i][0] = dsHDB.get(i).getMaHD();
			data[i][1] = dsHDB.get(i).getKhachHang().getTenKH();
			data[i][2] = dsHDB.get(i).getNhanVien().getTenNhanVien();
			data[i][3] = FormatValue.formatDateTime(dsHDB.get(i).getNgayTao());
			data[i][4] = dsHDB.get(i).getTongTien() + "";
		}
		return data;
	}
	
	 public String[][] getDsCTHDB (int row) {
	        ArrayList<ChiTietHDB> dsCTHDB = hdbDAO.getDsCTHDBFromDB(row);
	        int length = dsCTHDB.size();
	        String[][] data = new String[length][6]; // number of column in table
	        for (int i = 0; i < length; i++) {
	            SanPham sp = dsCTHDB.get(i).getSanPham();
	            data[i][0] = sp.getMaSP();
	            data[i][1] = sp.getTenSP();
	            data[i][2] = sp.getGiaBan() + "";
	            data[i][3] = dsCTHDB.get(i).getGiamGia() + "";
	            data[i][4] = sp.getSoLuong() + "";
	            data[i][5] = dsCTHDB.get(i).getTongTien() +"";
	        }
	        return data;
	    }

	public HoaDonBan getHDBSelected(int row) {
		return hdbDAO.getDsHDB().get(row);
	}
	
	 public void filterDsHDB (String itemFilterSelected, String nameSearch) {
	        hdbDAO.getFilterDsHDBFromDB(itemFilterSelected, nameSearch);
	    }
	public void addCTHDB(ChiTietHDB chiTietHDB) {
		new HoaDonBanDAO().addChiTietHDB(chiTietHDB);
		
	}
	public void xoaHD(String maHD) {
		hdbDAO.xoa(maHD);
	}

}
