package BUS;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JCheckBox;

import DAO.NhomQuyenDAO;
import DTO.ChiTietNhomQuyen;
import DTO.ChucNang;
import DTO.NhomQuyen;

public class NhomQuyenBUS {
    private NhomQuyenDAO dao;

    public NhomQuyenBUS(NhomQuyenDAO dao) {
        this.dao = dao;
    }

    public String[][] getDsnq() {
        ArrayList<NhomQuyen> dsnq = dao.getDsnq();
        String[][] data = new String[dsnq.size()][2];
        for (int i = 0; i < dsnq.size(); i++) {
            data[i][0] = dsnq.get(i).getMaNhomQuyen();
            data[i][1] = dsnq.get(i).getTenNhomQuyen();
        }
        return data;
    }

    public NhomQuyen getNhomQuyenByMa(String manq) {
        return dao.getNhomQuyenByMaFromDB(manq);
    }

    public NhomQuyen getNhomQuyenByTen(String tennq) {
        return dao.getNhomQuyenByTenFromDB(tennq);
    }

    public int countNhanVienUsedNq(String manq) {
        return dao.countNhanVienUsedNq(manq);
    }

    public void themNhomQuyen(NhomQuyen nq) {
        dao.themNhomQuyen(nq);
    }

    public void suaNhomQuyen(String manq, NhomQuyen newNq) {
        dao.suaNhomQuyen(manq, newNq);
    }

    public void xoaNhomQuyen(String manq) {
        dao.xoaNhomQuyen(manq);
    }

    public Map<Integer, ArrayList<ChiTietNhomQuyen>> getBaseDscn() {
        return dao.getBaseDscn();
    }

    public Map<Integer, ArrayList<String>> getDscnOfSelectedNq(String manq) {
        return dao.getDscnOfSelectedNq(manq);
    }

    public void changedChiTietNhomQuyen(String manq, Map<JCheckBox, Integer> dsCheckBoxTitle,
            Map<Integer, Map<JCheckBox, String>> dsCheckBoxItem) {
        ArrayList<ChiTietNhomQuyen> data = new ArrayList<>();
        Map<Integer, ArrayList<ChiTietNhomQuyen>> baseDscn = dao.getBaseDscn();
        for (Map.Entry<JCheckBox, Integer> chucnang : dsCheckBoxTitle.entrySet()) {
            for (Map.Entry<JCheckBox, String> hanhdong : dsCheckBoxItem.get(chucnang.getValue()).entrySet()) {
                if (hanhdong.getKey().isSelected()) {
                    data.add(new ChiTietNhomQuyen(
                            new NhomQuyen(manq),
                            new ChucNang(chucnang.getValue(),
                                    baseDscn.get(chucnang.getValue()).get(0).getCn().getTencn()),
                            hanhdong.getValue()));
                }
            }
        }
        dao.changedChiTietNhomQuyen(manq, data);
    }
}
