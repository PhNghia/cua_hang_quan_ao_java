package BUS;

import java.util.HashMap;

import DAO.DangNhapDAO;
import DTO.NhanVien;

public class DangNhapBUS {
	DangNhapDAO loginDao = null;

	public DangNhapBUS() {
		this.loginDao = new DangNhapDAO();
	}

	public HashMap<String, Object[]> getAccounts() {
		return this.loginDao.getAccounts();
	}

	public NhanVien getEmployee(String accountName) {
		return this.loginDao.getEmployee(accountName);
	}
}
