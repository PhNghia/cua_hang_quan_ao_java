package BUS;

import DAO.NhaCungCapNewShortDAO;
import DTO.NhaCungCap;

public class NhaCungCapNewShortBUS {
    private NhaCungCapNewShortDAO dao;

    public NhaCungCapNewShortBUS(NhaCungCapNewShortDAO dao) {
        this.dao = dao;
    }

    public NhaCungCap getNccByTen (String tenNcc) {
        return dao.getNccByTenFromDB(tenNcc);
    }
}
