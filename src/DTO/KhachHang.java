/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */
public class KhachHang {
    private int maKH;
    private String tenKH;
    private String sdt;
    private int tienTichLuy = 0;
    private int diemTichLuy = 0;
    private int bangTien = 0; 
    // tiền tích lũy là số tiền khách hàng trả trong hóa đơn
    // => quy đổi thành điểm
    // => quy đổi trở lại thành tiền theo 1 hệ số được xác định trước

    public KhachHang() {
    }

    public KhachHang (int makh, String tenKH) {
        this.maKH = makh;
        this.tenKH = tenKH;
    }

    public KhachHang(String tenKH, String sdt) {
        this.tenKH = tenKH;
        this.sdt = sdt;
    }

    public KhachHang(int maKH, String tenKH, String sdt, int tienTichLuy, int diemTichLuy, int bangTien) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.tienTichLuy = tienTichLuy;
        this.diemTichLuy = diemTichLuy;
        this.bangTien = bangTien;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTienTichLuy() {
        return tienTichLuy;
    }

    public void setTienTichLuy(int tienTichLuy) {
        this.tienTichLuy = tienTichLuy;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public int getBangTien() {
        return bangTien;
    }

    public void setBangTien(int bangTien) {
        this.bangTien = bangTien;
    }
    
}
