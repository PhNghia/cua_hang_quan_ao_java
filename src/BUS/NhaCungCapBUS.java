package BUS;

import java.util.ArrayList;
import java.util.List;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;

public class NhaCungCapBUS {

    private NhaCungCapDAO dao;

    public NhaCungCapBUS(NhaCungCapDAO dao) {
        this.dao = dao;
    }

    public String[][] getDsNcc() {
        dao.getDsNccFromDB();
        ArrayList<NhaCungCap> dsncc = dao.getDsncc();
        String[][] data = new String[dsncc.size()][4];
        for (int i = 0; i < dsncc.size(); i++) {
            data[i][0] = dsncc.get(i).getTenNcc();
            data[i][1] = dsncc.get(i).getSdt();
            data[i][2] = dsncc.get(i).getDiaChi();
            data[i][3] = dsncc.get(i).getTrangThaiText();
        }
        return data;
    }

    public String[][] getFilterdDsNcc(String type, String value, String statusText) {
        dao.filteredDsNcc(type, value, statusText);
        ArrayList<NhaCungCap> dsncc = dao.getDsncc();
        String[][] data = new String[dsncc.size()][4];
        for (int i = 0; i < dsncc.size(); i++) {
            data[i][0] = dsncc.get(i).getTenNcc();
            data[i][1] = dsncc.get(i).getSdt();
            data[i][2] = dsncc.get(i).getDiaChi();
            data[i][3] = dsncc.get(i).getTrangThaiText();
        }
        return data;
    }

    public int getIndexNcc (String tenNcc) {
        int index = 0;
        for (NhaCungCap ncc : dao.getDsncc()) {
            if (ncc.getTenNcc().equals(tenNcc)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public NhaCungCap getSelectedNcc(int row) {
        return dao.getDsncc().get(row);
    }

    public NhaCungCap getNccByTen(String ten) {
        return dao.getNccByTen(ten);
    }

    public NhaCungCap getNccBySdt(String sdt) {
        return dao.getNccBySdt(sdt);
    }

    public void themNcc (NhaCungCap newNcc) {
        dao.themNcc(newNcc);
    }

    public void suaNcc (int row, NhaCungCap updateNcc) {
        dao.suaNcc(row, updateNcc);
    }
}
