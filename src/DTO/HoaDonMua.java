/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author BomPC
 */
public class HoaDonMua {
    private String maHD;
    private NhanVien nhanVien;
    private LocalDateTime ngayTao;
    private long tongTien;
    public static final String[] itemFiltersComboBox = new String[] { "Tất cả", "Mã hóa đơn", "Người tạo" };

    public HoaDonMua() {
    }

    public HoaDonMua(String maHD, NhanVien nhanVien, LocalDateTime ngayTao) {
        this.maHD = maHD;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
    }

    public HoaDonMua(String maHD, NhanVien nhanVien, LocalDateTime ngayTao, long tongTien) {
        this.maHD = maHD;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
}
