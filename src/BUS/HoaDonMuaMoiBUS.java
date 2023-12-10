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

    public HoaDonMua getHDM() {
        return hdmmDAO.getHDM();
    }

    public SanPham getSelectedSP(int row) {
        return hdmmDAO.getSanPham(row);
    }

    public NhaCungCap getSelectedNcc(int index) {
        return hdmmDAO.getNcc(index);
    }

    public ChiTietHDM getSelectedCthdm(int row) {
        return hdmmDAO.getCTHDM(row);
    }

    public SanPham getSanPhamByMa(String masp) {
        return hdmmDAO.getSanPhamByMa(masp);
    }

    public void getDsSanPhamFromDB() {
        hdmmDAO.getDsSanPhamFromDB();
    }

    public String[][] getDsSanPham(boolean wasConfirmHDM) {
        ArrayList<SanPham> dsSanPham = hdmmDAO.getDsSanPham();
        int length = dsSanPham.size();
        int numberColumn = wasConfirmHDM ? 4 : 3;
        String[][] data = new String[length][numberColumn];
        if (wasConfirmHDM) {
            Map<String, Integer> dsTongSoLuongSPMua = hdmmDAO.getDsTongSoLuongSPMua();
            for (int i = 0; i < length; i++) {
                SanPham sp = dsSanPham.get(i);
                data[i][0] = sp.getMaSP();
                data[i][1] = sp.getTenSP();
                data[i][2] = sp.getSoLuong() + "";
                Object tongSL = dsTongSoLuongSPMua.get(sp.getMaSP()); 
                if (tongSL != null ) {
                    data[i][3] = tongSL + "";
                } else {
                    data[i][3] = "";
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                SanPham sp = dsSanPham.get(i);
                data[i][0] = sp.getMaSP();
                data[i][1] = sp.getTenSP();
                data[i][2] = sp.getSoLuong() + "";
            }
        }
        return data;
    }

    public String[][] getDsCTHDM() {
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

    public void getDsNccFromDB() {
        hdmmDAO.getDsNccFromDB();
    }

    public String[] getDsNcc() {
        ArrayList<NhaCungCap> dsNcc = hdmmDAO.getDsNcc();
        String[] data = new String[dsNcc.size()];
        for (int i = 0; i < dsNcc.size(); i++) {
            data[i] = dsNcc.get(i).getTenNcc();
        }
        return data;
    }

    public void filteredDsSPByMa(String value) {
        hdmmDAO.filteredDsSPByMa(value);
    }

    public void filteredDsSPByTen(String value) {
        hdmmDAO.filteredDsSPByTen(value);
    }

    public int existsCthdm(ChiTietHDM cthdm) {
        int exists = -1;
        int index = 0;
        ArrayList<ChiTietHDM> dsCTHDM = hdmmDAO.getDsCTHDM();
        for (ChiTietHDM ct : dsCTHDM) {
            if (ct.getSanPham().getMaSP().equals(cthdm.getSanPham().getMaSP()) &&
                    ct.getNcc().getTenNcc().equals(cthdm.getNcc().getTenNcc())) {
                exists = index;
                break;
            }
            index++;
        }
        return exists;
    }

    public boolean isSameGiaNhapCuaCthdm(ChiTietHDM cthdm) {
        boolean same = false;
        ArrayList<ChiTietHDM> dsCTHDM = hdmmDAO.getDsCTHDM();
        for (ChiTietHDM ct : dsCTHDM) {
            if (ct.getSanPham().getMaSP().equals(cthdm.getSanPham().getMaSP()) &&
                    ct.getNcc().getTenNcc().equals(cthdm.getNcc().getTenNcc())) {
                if (ct.getGiaNhap() == cthdm.getGiaNhap()) {
                    same = true;
                }
            }
        }
        return same;
    }

    public void themCTHDM(ChiTietHDM cthdm) {
        hdmmDAO.themCTHDM(cthdm);
    }

    public void themCTHDM(int selectedCTHMIndex, ChiTietHDM cthdm) {
        hdmmDAO.themCTHDM(selectedCTHMIndex, cthdm);
    }

    public void suaCTHDM(int selectedCTHDMIndex, ChiTietHDM cthdmUpdated) {
        hdmmDAO.suaCTHDM(selectedCTHDMIndex, cthdmUpdated);
    }

    public void themSuaCTHDM(int selectedCTHMIndex, ChiTietHDM cthdm) {
        ChiTietHDM selectedCTHDM = hdmmDAO.getDsCTHDM().get(selectedCTHMIndex);
        hdmmDAO.updateTongTienHDM("delete", selectedCTHDM);
        selectedCTHDM.setGiaNhap(cthdm.getGiaNhap());
        hdmmDAO.updateTongTienHDM("add", selectedCTHDM);
        themCTHDM(selectedCTHMIndex, cthdm);
    }

    public void xoaCTHDM(int selectedCTHDMIndex) {
        hdmmDAO.xoaCTHDM(selectedCTHDMIndex);
    }

    public void restoreDSPP() {
        hdmmDAO.restoreDSSP();
    }

    public void resetHDM() {
        hdmmDAO.resetHDM();
    }

    public int addNewShortNcc(String tenNcc) {
        return hdmmDAO.addNewShortNcc(tenNcc);
    }

    public void handleThemHDM() {
        hdmmDAO.handleThemHDM();
    }
}
