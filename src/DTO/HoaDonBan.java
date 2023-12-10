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
    private NhanVien nhanVien;
    private LocalDateTime ngayTao;
    private int tongTien;
    private int tongTienThang;
    
    public HoaDonBan() {}

    public HoaDonBan(String maHD, NhanVien nhanVien, LocalDateTime ngayTao) {
        this.maHD = maHD;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
    }

    public HoaDonBan(String maHD, KhachHang khachHang, NhanVien nhanVien, LocalDateTime ngayTao, int tongTien) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public HoaDonBan(String maHD, LocalDateTime ngayTao, int tongTien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public HoaDonBan(LocalDateTime ngayTao, int tongTienThang) {
        this.ngayTao = ngayTao;
        this.tongTienThang = tongTienThang;
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

    public void setTongTienThang(int tongTienThang) {
        this.tongTienThang = tongTienThang;
    }

    public int getTongTienThang() {
        return this.tongTienThang;
    }
}
