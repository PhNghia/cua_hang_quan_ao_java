/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonMuaMoiDAO;
import DTO.ChiTietHDM;
import DTO.HoaDonMua;
import DTO.NhaCungCap;
import DTO.SanPham;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author BomPC
 */
public class HoaDonMuaMoiBUS {
    
    private HoaDonMuaMoiDAO hdmmDAO;

    public HoaDonMuaMoiBUS(HoaDonMuaMoiDAO hdmmDAO) {
        this.hdmmDAO = hdmmDAO;
    }
    
    public HoaDonMua getHDM () {
        return hdmmDAO.getHDM();
    }
    
    public SanPham getSelectedSP (int row) {
        return hdmmDAO.getSanPham(row);
    }
    
    public NhaCungCap getSelectedNcc (int index) {
        return hdmmDAO.getNcc(index);
    }
    
    public ChiTietHDM getSelectedCthdm (int row) {
        return hdmmDAO.getCTHDM(row);
    }
    
    public String[][] getDsSanPham () {
        ArrayList<SanPham> dsSanPham = hdmmDAO.getDsSanPham();
        int length = dsSanPham.size();
        String[][] data = new String[length][4];
        for (int i = 0; i < length; i++) {
            SanPham sp = dsSanPham.get(i);
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = sp.getSoLuong() + "";
            data[i][3] = sp.getTrangThaiText();
            
        }
        return data;
    }
    
    public String[][] getDsCTHDM () {
        ArrayList<ChiTietHDM> dsCTHDM = hdmmDAO.getDsCTHDM();
        int length = dsCTHDM.size();
        String[][] data = new String[length][6];
        for (int i = 0; i < length; i++) {
            SanPham sp = dsCTHDM.get(i).getSanPham();
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = dsCTHDM.get(i).getNcc().getTenNcc();
            data[i][3] = dsCTHDM.get(i).getGiaNhap() + "";
            data[i][4] = sp.getSoLuong() + "";
            data[i][5] = dsCTHDM.get(i).getTongTien() + "";
            
        }
        return data;
    }
    
    public String[] getDsNcc () {
        ArrayList<NhaCungCap> dsNcc = hdmmDAO.getDsNcc();
        String[] data = new String[dsNcc.size()];
        for (int i = 0; i < dsNcc.size(); i++) {
            data[i] = dsNcc.get(i).getTenNcc();
        }
        return data;
    }
    
    public void filteredDsSPByMa (String value) {
        hdmmDAO.filteredDsSPByMa(value);
    }
    
    public void filteredDsSPByTen (String value) {
        hdmmDAO.filteredDsSPByTen(value);
    }
    
    public void themCTHDM (ChiTietHDM cthdm) {
        
        hdmmDAO.themCTHDM(cthdm);
    }
    
    public void suaCTHDM (int selectedCTHDMIndex, ChiTietHDM cthdmUpdated) {
        hdmmDAO.suaCTHDM(selectedCTHDMIndex, cthdmUpdated);
    }
    
    public void xoaCTHDM (int selectedCTHDMIndex) {
        hdmmDAO.xoaCTHDM(selectedCTHDMIndex);
    }
    
    public void restoreDSPP () {
        hdmmDAO.restoreDSSP();
    }
}
