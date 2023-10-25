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
public class TaiKhoan {
    private String tenTaiKhoan;
    private NhanVien nguoiSoHuu;
    private LocalDateTime ngayTao;
    private int trangThai;
    private final String[] dsTrangThai = new String[] { "Ngừng hoạt động", "Hoạt động" };    
    private final String[] dsTrangThaiForFilter = new String[] { "Tất ", "Ngừng hoạt động", "Hoạt động" };


    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public NhanVien getNguoiSoHuu() {
        return nguoiSoHuu;
    }

    public void setNguoiSoHuu(NhanVien nguoiSoHuu) {
        this.nguoiSoHuu = nguoiSoHuu;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String[] getDsTrangThai() {
        return dsTrangThai;
    }

    public String[] getDsTrangThaiForFilter() {
        return dsTrangThaiForFilter;
    }

    public TaiKhoan(String tenTaiKhoan, NhanVien nguoiSoHuu, LocalDateTime ngayTao, int trangThai) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.nguoiSoHuu = nguoiSoHuu;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }
    
}
