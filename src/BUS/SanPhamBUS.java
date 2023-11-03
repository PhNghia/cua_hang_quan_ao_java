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
	
	public void addSanPham(SanPham sp, String flag) {
		if(flag.equals("ok")) {
			this.SanPhamDAO.insertNew(sp);
			JOptionPane.showMessageDialog(null, "Tạo sản phẩm mới thành công!");
		}
		else if(flag.equals("dupNE")) {
			JOptionPane.showMessageDialog(null, "Mã bị trùng với sản phẩm đã xoá trước đó!","WARNING",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateSanPham(SanPham sp) {
		this.SanPhamDAO.updateSanPham(sp);
		JOptionPane.showMessageDialog(null,"Sửa chi tiết thành công!");
	}
	
	public boolean deleteSanPham(String maSP) {
		return this.SanPhamDAO.deleteSanPham(maSP);
	}
	
	public ArrayList<SanPham> searchSanPham(String type, ArrayList<Object> search) {
		return this.SanPhamDAO.searchSanPham(type,search);
	}
}