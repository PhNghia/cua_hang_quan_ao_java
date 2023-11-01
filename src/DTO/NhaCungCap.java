/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */
public class NhaCungCap {
    private int maNcc;
    private String tenNcc;
    private String sdt;
    private String diaChi;
    private int trangThai;
    private final String[] dsTrangThai = new String[] { "Ngừng hợp tác", "Đang hợp tác" };
    private final String[] dsTrangThaiForFilter = new String[] { "Tất cả", "Ngừng hợp tác", "Đang hợp tác" };

    public NhaCungCap(String tenNcc) {
        this.tenNcc = tenNcc;
    }

    public NhaCungCap(int maNcc, String tenNcc) {
        this.maNcc = maNcc;
        this.tenNcc = tenNcc;
    }

    public NhaCungCap(int maNcc, String tenNcc, String sdt, String diaChi, int trangThai) {
        this.maNcc = maNcc;
        this.tenNcc = tenNcc;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public int getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(int maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
    
    public String getTrangThaiText () {
        return dsTrangThai[trangThai];
    }
}
