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
    private float giamGia;
    private String hinhAnh;
    private int trangThai;
    private int hienThi;
    public final static String[] dsTrangThai = new String[] { "Ngừng bán", "Chuẩn bị bán", "Đang bán" };
    public final static String[] dsTrangThaiForFilter = new String[] { "Tất cả", "Ngừng bán", "Chuẩn bị bán", "Đang bán" };

    // sản phẩm ko có giá nhập trung bình, tạo giá nhập trung bình để thuận tiện cho thống kê nhập
    // tương tự với tổng tiền sản phẩm nhập
    private float giaNhapTB;
    private long tongTienSPNhap;

    public void setGiaNhapTB(float giaNhapTB) {
        this.giaNhapTB = giaNhapTB;
    }

    public float getGiaNhapTB() {
        return giaNhapTB;
    }

    public void setTongTienSPNhap (long tongTienSPNhap) {
        this.tongTienSPNhap = tongTienSPNhap;
    }

    public long getTongTienSPNhap () {
        return tongTienSPNhap;
    }

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham(String maSP, String tenSP, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
    }

    public SanPham(String maSP, String tenSP, int giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public SanPham(String maSP, String tenSP, int giaBan, int soLuong, float giamGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
    }

    
    public SanPham(String maSP, String tenSP, String chatLieu, String kichCo, String mauSac, int giaBan, int soLuong, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.chatLieu = chatLieu;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
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

    public SanPham(String maSP, String tenSP, String chatLieu, String kichCo, String mauSac, int giaBan, int soLuong, int trangThai, int hienThi) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.chatLieu = chatLieu;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.hienThi = hienThi;
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

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
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

    public int getHienThi() {
        return hienThi;
    }

    public void setHienThi(int hienThi) {
        this.hienThi = hienThi;
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
