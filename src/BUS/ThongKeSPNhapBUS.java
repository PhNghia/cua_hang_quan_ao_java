package BUS;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Windows
 */
public class ThongKeSPNhapBUS {
    private static ThongKeSPNhapBUS instance;
    public static ThongKeSPNhapBUS getInstance(){
        if(instance == null)
            instance = new ThongKeSPNhapBUS();
        return instance ;
    }
    public List<DTO.SanPham> getDataThongKe(LocalDate fromdate, LocalDate todate) {
        return DAO.ThongKeSPNhapDAO.getInstance().getDataThongKe(fromdate, todate);
    }
}
