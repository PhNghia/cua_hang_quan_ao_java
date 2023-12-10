/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */
public class ChiTietHDM {
    private String maHD;
    private NhaCungCap ncc; //các thuộc tính cần lấy: mã, tên
    private SanPham sanPham; // các thuộc tính cần lấy: mã, tên, số lượng (ở đây là số lượng mua vào trong hóa đơn)
    private int giaNhap;
    private int tongTien;
    private boolean isNew;

    public ChiTietHDM(String maHD, NhaCungCap ncc, SanPham sanPham, int giaNhap, int tongTien) {
        this.maHD = maHD;
        this.ncc = ncc;
        this.sanPham = sanPham;
        this.giaNhap = giaNhap;
        this.tongTien = tongTien;
    }

    public ChiTietHDM(String maHD, NhaCungCap ncc, SanPham sanPham, int giaNhap, int tongTien, boolean isNew) {
        this.maHD = maHD;
        this.ncc = ncc;
        this.sanPham = sanPham;
        this.giaNhap = giaNhap;
        this.tongTien = tongTien;
        this.isNew = isNew;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
    
    
}
