/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author BomPC
 */
public class NhanVien {
    private int maNhanVien;
    private String tenNhanVien;
    private int gioiTinh;
    private LocalDate ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private NhomQuyen chucVu;
    private int trangThai;
	private int hienThi;

    private final String[] dsGioiTinh = new String[] { "Nữ", "Nam" };
    private final String[] dsTrangThai = new String[] { "Đã nghỉ việc", "Đang làm việc" };
    private final String[] dsTrangThaiForFilter = new String[] { "Tất cả", "Đã nghỉ việc", "Đang làm việc" };

	public int getHienThi() {
		return hienThi;
	}

	public void setHienThi(int hien_thi) {
		this.hienThi = hien_thi;
	}

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public NhomQuyen getChucVu() {
        return chucVu;
    }

    public void setChucVu(NhomQuyen chucVu) {
        this.chucVu = chucVu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String[] getDsGioiTinh() {
        return dsGioiTinh;
    }

    public String[] getDsTrangThai() {
        return dsTrangThai;
    }

    public String[] getDsTrangThaiForFilter() {
        return dsTrangThaiForFilter;
    }

    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String tenNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }

    public NhanVien(int maNhanVien, String tenNhanVien, int gioiTinh, LocalDate ngaySinh, String sdt, String email, String diaChi, NhomQuyen chucVu, int trangThai) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }
    
    public String getGioiTinhText () {
        return dsGioiTinh[gioiTinh];
    }
    
    public String getTrangThaiText () {
        return dsTrangThai[trangThai];
    }
}
