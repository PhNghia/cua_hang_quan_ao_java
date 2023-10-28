/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonMuaDAO;
import DTO.ChiTietHDM;
import DTO.FormatDateTime;
import DTO.HoaDonMua;
import DTO.SanPham;
import java.util.ArrayList;

/**
 *
 * @author BomPC
 */
public class HoaDonMuaBUS {
    
    private final HoaDonMuaDAO hdmDAO;
    
    public HoaDonMuaBUS (HoaDonMuaDAO hdmDAO) {
        this.hdmDAO = hdmDAO;
    }
    
    public String[][] getDsHDM () {
        ArrayList<HoaDonMua> dsHDM = hdmDAO.getDsHDM();
        int length = dsHDM.size();
        String[][] data = new String[length][4]; // number of column in table
        for (int i = 0; i < length; i++) {
            data[i][0] = dsHDM.get(i).getMaHD();
            data[i][1] = dsHDM.get(i).getNhanVien().getTenNhanVien();
            data[i][2] = FormatDateTime.formatDateTime(dsHDM.get(i).getNgayTao());
            data[i][3] = dsHDM.get(i).getTongTien() + "";
        }
        return data;
    }
    
    public String[][] getDsCTHDM (int row) {
        ArrayList<ChiTietHDM> dsCTHDM = hdmDAO.getDsCTHDMFromDB(row);
        int length = dsCTHDM.size();
        String[][] data = new String[length][7]; // number of column in table
        for (int i = 0; i < length; i++) {
            SanPham sp = dsCTHDM.get(i).getSanPham();
            data[i][0] = sp.getMaSP();
            data[i][1] = sp.getTenSP();
            data[i][2] = dsCTHDM.get(i).getNcc().getTenNcc();
            data[i][3] = sp.getGiaNhap() + "";
            data[i][4] = dsCTHDM.get(i).getLoiNhuan() + "";
            data[i][5] = sp.getSoLuong() + "";
            data[i][6] = dsCTHDM.get(i).getTongTien() + "";
        }
        return data;
    }
    
    public HoaDonMua getHDMSelected (int row) {
        return hdmDAO.getDsHDM().get(row);
    }
    
    public ChiTietHDM getCTHDMSelected (int row) {
        return hdmDAO.getDsCTHDM().get(row);
    }
    
    public void filterDsHDM (int indexFilterSelected, String nameSearch, String ncc, String sanPham) {
        
    }
}
