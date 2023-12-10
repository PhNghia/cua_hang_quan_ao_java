/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BomPC
 */
public class ChiTietNhomQuyen {

    private NhomQuyen nq;
    private ChucNang cn;
    private String hanhDong;

    public ChiTietNhomQuyen() {
    }

    public ChiTietNhomQuyen(NhomQuyen nq, ChucNang cn, String hanhDong) {
        this.nq = nq;
        this.cn = cn;
        this.hanhDong = hanhDong;
    }

    public NhomQuyen getNq() {
        return nq;
    }

    public void setNq(NhomQuyen nq) {
        this.nq = nq;
    }

    public ChucNang getCn() {
        return cn;
    }

    public void setCn(ChucNang cn) {
        this.cn = cn;
    }

    public String getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(String hanhDong) {
        this.hanhDong = hanhDong;
    }

}
