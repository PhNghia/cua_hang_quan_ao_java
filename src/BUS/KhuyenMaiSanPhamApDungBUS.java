/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuyenMaiSanPhamApDungDAO;
import DTO.SanPham;
import java.util.ArrayList;
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
    
    public Object[][] getDSSP () {
        ArrayList<SanPham> dssp = dao.getDSSP();
        Map dsspChecked = dao.getDsspChecked();
        int length = dssp.size();
        Object[][] data = new Object[length][4];
        for (int i = 0; i < length; i++) {
            SanPham sp = dssp.get(i);
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = sp.getGiaBan();
            data[i][3] = dsspChecked.get(sp.getMaSP()) != null;
        }
        return data;
    }
    
    public Object[][] getDSSPADKM () {
        ArrayList<SanPham> dssp = dao.getDSSPADKM();
        Map dsspChecked = dao.getDsspChecked();
        int length = dssp.size();
        Object[][] data = new Object[length][4];
        for (int i = 0; i < length; i++) {
            SanPham sp = dssp.get(i);
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = sp.getGiaBan();
            data[i][3] = dsspChecked.get(sp.getMaSP()) != null;
        }
        return data;
    } 
    
    public void checkedSanPham (int row) {
        dao.checkedSanPham(row);
    }
    
    public void uncheckedSanPham (String masp) {
        dao.uncheckedSanPham(masp);
    }
}
