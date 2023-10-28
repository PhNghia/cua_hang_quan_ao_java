package BUS;

import java.util.ArrayList;

import DAO.TaiKhoanDao;
import DTO.NhanVien;
import DTO.TaiKhoan;

public class TaiKhoanBus {
	private TaiKhoanDao taiKhoanDao;

	public TaiKhoanBus() {
		this.taiKhoanDao = new TaiKhoanDao();
	}

	public Boolean add(TaiKhoan tk) {
		return this.taiKhoanDao.add(tk);
	}

	public ArrayList<TaiKhoan> getTaiKhoan() {
		return this.taiKhoanDao.getTaiKhoan();
	}

	public ArrayList<NhanVien> getNhanVien() {
		return this.taiKhoanDao.getEmployees();
	}

	public Boolean deleteTaiKhoan(String tenTaiKhoan) {
		return this.taiKhoanDao.del(tenTaiKhoan);
	}

	public Boolean updateTaiKhoan(String username, String password, int status) {
		return this.taiKhoanDao.update(username, password, status);
	}

	public Boolean updatePassword(String username, String password) {
		return this.taiKhoanDao.updatePassword(username, password);
	}

	public Boolean updateStatus(String username, int status) {
		return this.taiKhoanDao.updateStatus(username, status);
	}

}
