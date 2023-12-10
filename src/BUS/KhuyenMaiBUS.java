package BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import DAO.KhuyenMaiDAO;
import DTO.DotKhuyenMai;
import DTO.KhuyenMai;

public class KhuyenMaiBUS {
	private KhuyenMaiDAO KhuyenMaiDAO;

	public KhuyenMaiBUS() {
		this.KhuyenMaiDAO = new KhuyenMaiDAO();
	}

	// LIST CT
	public ArrayList<KhuyenMai> getListKhuyenMai() {
		return this.KhuyenMaiDAO.getListKhuyenMai();
	}

	// LIST DOT OF CT(maCT)
	public ArrayList<DotKhuyenMai> getListDot(String maCT) {
		return KhuyenMaiDAO.getListDot(maCT);
	}

	// LIST SANPHAM OF DOT(maDot)
	public List<List<String>> getListSP(int maDot) {
		return KhuyenMaiDAO.getListSP(maDot);
	}

	// CHECK TRANG THAI CT
	public Boolean checkStatusCT(String maCT) {
		Boolean flag = false;
		ArrayList<DotKhuyenMai> dotList = getListDot(maCT);
		for (DotKhuyenMai st : dotList)
			if (st.getTrangThai() == 2)
				flag = true;
		return flag;
	}

	// CHECK DUPLICATE MA CT
	public Boolean checkDuplicate(String check, JTable jtbDSCTKM) {
		ArrayList<String> maList = this.KhuyenMaiDAO.getMaList();
		Boolean flag = true;
		if (jtbDSCTKM.getSelectedRow() == -1) {
			for (String ma : maList)
				if (ma.equalsIgnoreCase(check))
					flag = false;
		} else {
			for (String ma : maList)
				if (ma.equalsIgnoreCase(check) && 
				!ma.equalsIgnoreCase(jtbDSCTKM.getValueAt(jtbDSCTKM.getSelectedRow(), 0).toString()))
					flag = false;
		}

		return flag;
	}

	// ADD NEW CT
	public void insertNewCT(KhuyenMai km) {
		KhuyenMaiDAO.insertNewCT(km);
		JOptionPane.showMessageDialog(null, "Tạo chương trình mới thành công!");
	}

	// ADD NEW DOT
	public void insertNewDot(DotKhuyenMai dot) {
		KhuyenMaiDAO.insertNewDot(dot);
		JOptionPane.showMessageDialog(null, "Tạo đợt mới thành công!");
	}

	// COUNT DOT
	public int countDot() {
		return KhuyenMaiDAO.countDot();
	}

	// UPDATE CT
	public void updateCT(String selected, KhuyenMai km) {
		try {
			KhuyenMaiDAO.updateCT(selected, km);
			JOptionPane.showMessageDialog(null, "Cập nhật chương trình thành công!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// UPDATE DOT
	public void updateDot(DotKhuyenMai dot) {
		try {
			KhuyenMaiDAO.updateDot(dot);
			JOptionPane.showMessageDialog(null, "Cập nhật đợt thành công!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cập nhật lỗi, vui lòng thử lại!", "WARNING",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// DELETE CT
	public boolean deleteCT(KhuyenMai km) {
		int status = km.getTrangThai();
		int reply;
		if (status == 1)
			reply = JOptionPane.showConfirmDialog(null, "Chương trình vẫn đang hoạt động, vẫn muốn xoá?", "WARNING",
					JOptionPane.YES_NO_OPTION);
		else
			reply = JOptionPane.showConfirmDialog(null, "Xoá chương trình khuyến mãi?", "WARNING",
					JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			try {
				KhuyenMaiDAO.deleteCT(km);
				JOptionPane.showMessageDialog(null, "Xoá chương trình thành công!");
				return true;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Cập nhật lỗi, vui lòng thử lại!", "WARNING",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		return false;
	}

	// DELETE DOT
	public boolean deleteDot(int id) {
		Boolean flag = KhuyenMaiDAO.existSP(id);
		int reply;
		if (flag) 
			reply = JOptionPane.showConfirmDialog(null, "Đợt có sản phẩm, vẫn muốn xoá?", "WARNING",
					JOptionPane.YES_NO_OPTION);
		else
			reply = JOptionPane.showConfirmDialog(null, "Xoá đợt khuyến mãi?", "WARNING", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			try {
				KhuyenMaiDAO.deleteDot(id);
				JOptionPane.showMessageDialog(null, "Xoá đợt thành công!");
				return true;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Cập nhật lỗi, vui lòng thử lại!", "WARNING",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		return false;
	}

	// SEARCH FORM
	public List<List<Object>> searchFilterDot(ArrayList<String> filterForm) {
		return KhuyenMaiDAO.searchFilterDot(filterForm);
	}

	public List<List<Object>> searchFilterSP(ArrayList<String> filterForm) {
		return KhuyenMaiDAO.searchFilterSP(filterForm);
	}

	public DotKhuyenMai getDKMById(int idDKM) {
		return KhuyenMaiDAO.getDKMByIdFromDB(idDKM);
	}
}
