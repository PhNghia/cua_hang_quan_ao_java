package BUS;

import java.time.LocalDateTime;
import java.util.ArrayList;

import DAO.ThongKeDoanhThuDAO;
import DTO.HoaDonBan;

public class ThongKeDoanhThuBUS {

    private ThongKeDoanhThuDAO revenueStatisDao;

    public ThongKeDoanhThuBUS() {
        this.revenueStatisDao = new ThongKeDoanhThuDAO();
    }

    public ArrayList<HoaDonBan> getSellInvoices(LocalDateTime fromDate, LocalDateTime toDate) {
        return this.revenueStatisDao.getSellInvoices(fromDate, toDate);
    }

    public ArrayList<HoaDonBan> getTotalMonths(LocalDateTime fromDate, LocalDateTime toDate) {
        return this.revenueStatisDao.getTotalMonths(fromDate, toDate);
    }
}
