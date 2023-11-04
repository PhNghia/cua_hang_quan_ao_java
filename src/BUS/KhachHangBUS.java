
package BUS;

import DTO.KhachHang;
import DAO.KhachHangDAO;
import java.util.ArrayList;

public class KhachHangBUS {
    KhachHangDAO khachhangDAO;

    public KhachHangBUS() {
        khachhangDAO = new KhachHangDAO();
    }
    
    public ArrayList<KhachHang> getListKH(){
        ArrayList<KhachHang> list = new KhachHangDAO().getListKH();
        return list;
    }
    
    public void AddKH(KhachHang a){
        new KhachHangDAO().AddKH(a);
    }
    
    public void UpdateKH(KhachHang a){
        new KhachHangDAO().UpdateKH(a);
    }
    
    public ArrayList<KhachHang> FindKH(String name,String loc){
        ArrayList<KhachHang> list = new KhachHangDAO().FindKH(name, loc);
        return list;
    }
}
