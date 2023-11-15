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
    private int giaBan;
    private int soLuong;
    private String hinhAnh;
    private int trangThai;
    public final static String[] dsTrangThai = new String[] { "Ngừng bán", "Chuẩn bị bán", "Đang bán" };
    public final static String[] dsTrangThaiForFilter = new String[] { "Tất cả", "Ngừng bán", "Chuẩn bị bán", "Đang bán" };

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }
    

    public SanPham(String maSP, String tenSP, String chatLieu, String kichCo, String mauSac, int giaBan, int soLuong, String hinhAnh, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.chatLieu = chatLieu;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
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
