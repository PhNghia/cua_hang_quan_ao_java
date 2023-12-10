/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuyenMaiSanPhamApDungDAO;
import DTO.DotKhuyenMai;
import DTO.SanPham;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author BomPC
 */
public class KhuyenMaiSanPhamApDungBUS {
    private final KhuyenMaiSanPhamApDungDAO dao;

    public KhuyenMaiSanPhamApDungBUS(KhuyenMaiSanPhamApDungDAO dao) {
        this.dao = dao;
    }

    public void changedDSSPADKM() {
        dao.changedDSSPADKMIntoDB();
    }

    public DotKhuyenMai getDotKM () {
        return dao.getDotKM();
    }

    public Object[][] getDSSP() {
        ArrayList<SanPham> dssp = dao.getDSSP();
        Map<String, SanPham> dsspadkm = dao.getDSSPADKM();
        int length = dssp.size();
        Object[][] data = new Object[length][4];
        for (int i = 0; i < length; i++) {
            SanPham sp = dssp.get(i);
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = sp.getGiaBan();
            data[i][3] = dsspadkm.get(sp.getMaSP()) != null;
        }
        return data;
    }

    public Object[][] getDSSPADKM() {
        Map<String, SanPham> dssp = dao.getDSSPADKM();
        Collection<SanPham> values = dssp.values();
        int length = values.size();
        Object[][] data = new Object[length][4];
        int i = 0;
        for (SanPham sp : values) {
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = sp.getGiaBan();
            data[i][3] = true;
            i++;
        }
        return data;
    }

    public SanPham checkedSanPham(int row) {
        return dao.checkedSanPham(row);
    }

    public void uncheckedSanPham(String masp) {
        dao.uncheckedSanPham(masp);
    }

    public int getIndexSanPhamInDSSPByMasp (String masp) {
        return dao.getIndexSanPhamInDSSPByMasp(masp);
    }

    public int getIndexSanPhamInDSSPADKMByMasp (String masp) {
        return dao.getIndexSanPhamInDSSPADKMByMasp(masp);
    }

    public void restoreDSSPADKM () {
        dao.restorDSSPADKM();
    }

    public void filteredDsSP (String value) {
        dao.filteredDsSP(value);
    }
}
