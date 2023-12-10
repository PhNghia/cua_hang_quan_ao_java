/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */
public class KhuyenMai {
    private String makm;
    private String tenkm;
    private int trangThai;
    public static final String[] dsTrangThaiText = new String[] { "Không hoạt động", "Đang hoạt động" };
    public static final String[] dsTrangThaiTextForFilter = new String[] { "Tất cả", "Không hoạt động", "Đang hoạt động" };

    public KhuyenMai(String makm) {
        this.makm = makm;
    }

    public KhuyenMai(String makm, String tenkm) {
        this.makm = makm;
        this.tenkm = tenkm;
    }

    public KhuyenMai(String makm, String tenkm, int trangThai) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.trangThai = trangThai;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTrangThaiText() {
        return dsTrangThaiText[trangThai];
    }
}
