/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */
public class ChiTietHDB {
    private String maHD;
    private SanPham sanPham; // các thuộc tính cần lấy: mã, tên, giá bán, số lượng (ở đây là số lượng bán ra trong hóa đơn)
    private float giamGia;
    private int tongTien;

    public ChiTietHDB(String maHD, SanPham sanPham, float giamGia, int tongTien) {
        this.maHD = maHD;
        this.sanPham = sanPham;
        this.giamGia = giamGia;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
}
