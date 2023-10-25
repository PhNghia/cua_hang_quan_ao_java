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
public class HoaDonBan {
    private String maHD;
    private KhachHang khachHang;
    private CaLamViec ca;
    private NhanVien nhanVien;
    private LocalDateTime ngayTao;
    private int tongTien;

    public HoaDonBan(String maHD, CaLamViec ca, NhanVien nhanVien, LocalDateTime ngayTao) {
        this.maHD = maHD;
        this.ca = ca;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
    }

    public HoaDonBan(String maHD, KhachHang khachHang, CaLamViec ca, NhanVien nhanVien, LocalDateTime ngayTao, int tongTien) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.ca = ca;
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

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public CaLamViec getCa() {
        return ca;
    }

    public void setCa(CaLamViec ca) {
        this.ca = ca;
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

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
}
