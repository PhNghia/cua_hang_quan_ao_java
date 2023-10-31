/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonMuaMoiDAO;
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
    
    public String[][] getDsSanPham () {
        ArrayList<SanPham> dsSanPham = hdmmDAO.getDsSanPham();
        Map dsSoLuongSPMua = hdmmDAO.getDsSoLuongSPMua();
        int length = dsSanPham.size();
        String[][] data = new String[length][5];
        for (int i = 0; i < length; i++) {
            SanPham sp = dsSanPham.get(i);
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = sp.getSoLuong() + "";
            data[i][3] = sp.getTrangThaiText();
            data[i][4] = dsSoLuongSPMua.get(sp.getMaSP()) + "";
            
        }
        return data;
    }
    
}
