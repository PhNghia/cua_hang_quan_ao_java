/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private String chatLieu;
    private String kichCo;
    private String mauSac;
    private int giaNhap;
    private int giaBan;
    private int soLuong;
    private String hinhAnh;
    private int trangThai;
    private final String[] dsTrangThai = new String[] { "Ngừng bán", "Chuẩn bị bán", "Đang bán" };
    private final String[] dsTrangThaiForFilter = new String[] { "Tất cả", "Ngừng bán", "Chuẩn bị bán", "Đang bán" };

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public SanPham(String maSP, String tenSP, int giaNhap, int giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }
    
    
    
    public SanPham(String maSP, String tenSP, String chatLieu, String kichCo, String mauSac, int giaNhap, int giaBan, int soLuong, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.chatLieu = chatLieu;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
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
