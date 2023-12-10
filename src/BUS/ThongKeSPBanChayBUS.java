/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Windows
 */
public class ThongKeSPBanChayBUS {
    private static ThongKeSPBanChayBUS instance;
    public static ThongKeSPBanChayBUS getInstance(){
        if(instance == null)
            instance = new ThongKeSPBanChayBUS();
        return instance ;
    }
    public List<DTO.SanPham> getDataThongKe(LocalDate fromdate, LocalDate todate) {
        return DAO.ThongKeSPBanChayDAO.getInstance().getDataThongKe(fromdate, todate);
    }
}
