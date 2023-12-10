package BUS;
 
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.SanPhamDAO;
import DTO.SanPham;
import DTO.TaiKhoan;


public class SanPhamBUS{
	private SanPhamDAO SanPhamDAO;
	public SanPhamBUS() {
		this.SanPhamDAO = new SanPhamDAO();
	}
	public ArrayList<SanPham> getSanPham() {
		return this.SanPhamDAO.getSanPham();
	}
	public SanPham getChiTiet(String maSP) {
		return this.SanPhamDAO.getChiTiet(maSP);
	}
	
	public String checkDuplicate(String check) {
		List<List<String>> maList = this.SanPhamDAO.getMaList();
		String flag="ok";
		for(String ma : maList.get(0))
			if(ma.equalsIgnoreCase(check)) {
				int index=maList.get(0).indexOf(ma);
				if( (maList.get(1).get(index)).equals("1"))
					flag="dup";
				else {		//DUPLICATED WITH NE 
						flag="dupNE";
				}
			}
		return flag;
	}
	
	public boolean addSanPham(SanPham sp, String flag) {
		boolean result = false;
		if(flag.equals("ok")) {
			this.SanPhamDAO.insertNew(sp);
			JOptionPane.showMessageDialog(null, "Tạo sản phẩm mới thành công!");
			result = true;
		}
		else if(flag.equals("dupNE")) {
			JOptionPane.showMessageDialog(null, "Mã bị trùng với sản phẩm đã xoá!","WARNING",JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	
	public void updateSanPham(SanPham sp) {
		this.SanPhamDAO.updateSanPham(sp);
		JOptionPane.showMessageDialog(null,"Sửa chi tiết thành công!");
	}
	
	public void deleteSanPham(String maSP, int typeDelete) {
		this.SanPhamDAO.deleteSanPham(maSP, typeDelete);
	}
	
	public ArrayList<SanPham> searchSanPham(String type, ArrayList<Object> search) {
		return this.SanPhamDAO.searchSanPham(type,search);
	}

	public boolean checkSPJoinedHD(String maSP) {
		return this.SanPhamDAO.checkSPJoinedHD(maSP);
	}

	public boolean checkAPDKMSP (String masp) {
		return this.SanPhamDAO.checkAPDKMSP(masp);
	}

	public void stopSPADKM (String masp) {
		this.SanPhamDAO.stopSPADKM(masp);
	}
}