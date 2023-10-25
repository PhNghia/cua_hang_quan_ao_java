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
    private SanPham sanPham; // các thuộc tính cần lấy: mã, tên, giá nhập, số lượng (ở đây là số lượng mua vào trong hóa đơn)
    private float loiNhuan;
    private int tongTien;

    public ChiTietHDM(String maHD, NhaCungCap ncc, SanPham sanPham, float loiNhuan, int tongTien) {
        this.maHD = maHD;
        this.ncc = ncc;
        this.sanPham = sanPham;
        this.loiNhuan = loiNhuan;
        this.tongTien = tongTien;
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

    public float getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(float loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
