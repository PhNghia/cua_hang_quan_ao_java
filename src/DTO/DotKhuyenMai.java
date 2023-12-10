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
public class DotKhuyenMai {
    private int idDotKm;
    private KhuyenMai chuongTrinhKM;
    private LocalDateTime ngayBatDau;
    private LocalDateTime ngayKetThuc;
    private float giaTri;
    private int trangThai;
    public static final String[] dsTrangThaiText = new String[] {
        "Đã kết thúc", "Chưa diễn ra", "Đang diễn ra"
    };

    public DotKhuyenMai() {
    }

    public DotKhuyenMai(int idDotKm) {
        this.idDotKm = idDotKm;
    }
    
    public DotKhuyenMai(int idDotKm, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, float giaTri, int trangThai) {
        this.idDotKm = idDotKm;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaTri = giaTri;
        this.trangThai = trangThai;
    }

    public DotKhuyenMai(int idDotKm, KhuyenMai chuongTrinhKM, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, float giaTri, int trangThai) {
        this.idDotKm = idDotKm;
        this.chuongTrinhKM = chuongTrinhKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaTri = giaTri;
        this.trangThai = trangThai;
    }

    public int getIdDotKm() {
        return idDotKm;
    }

    public void setIdDotKm(int idDotKm) {
        this.idDotKm = idDotKm;
    }

    public KhuyenMai getChuongTrinhKM() {
        return chuongTrinhKM;
    }

    public void setChuongTrinhKM(KhuyenMai chuongTrinhKM) {
        this.chuongTrinhKM = chuongTrinhKM;
    }

    public LocalDateTime getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDateTime ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDateTime getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(float giaTri) {
        this.giaTri = giaTri;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getTrangThaiText () {
        return dsTrangThaiText[trangThai];
    }
}
