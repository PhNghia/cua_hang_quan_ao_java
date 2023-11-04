/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.List;

/**
 *
 * @author BomPC
 */
public class NhanVienBUS {
    private static NhanVienBUS instance;

    public NhanVienBUS() {

    }

    public static NhanVienBUS getInstance() {
        if (instance == null) {
            instance = new NhanVienBUS();
        }
        return instance;
    }

    public List<DTO.NhanVien> getAll() {
        return DAO.NhanVienDAO.getInstance().getAll();
    }

    public List<String> getAllNameChucVu() {
        return DAO.NhanVienDAO.getInstance().getAllNameChucVu();
    }

    public boolean addNhanVien(DTO.NhanVien dto) {
        return DAO.NhanVienDAO.getInstance().addNhanVien(dto);
    }

    public boolean editNhanVien(DTO.NhanVien dto) {
        return DAO.NhanVienDAO.getInstance().editNhanVien(dto);
    }

    public boolean deleteNhanVien(String ma_nhan_vien) {
        return DAO.NhanVienDAO.getInstance().deleteNhanVien(ma_nhan_vien);
    }

    public DTO.NhanVien getNhanVienByID(int id) {
        return DAO.NhanVienDAO.getInstance().getNhanVienByID(id);
    }

    public List<DTO.NhanVien> search(int indexsearchtype, String text, int indexgender, String chucvu, int indextrangthai) {
        return DAO.NhanVienDAO.getInstance().search(indexsearchtype, text, indexgender, chucvu, indextrangthai);
    }

    public boolean checkDuplicateSdt(String sdt, String manv) {
        return DAO.NhanVienDAO.getInstance().checkDuplicateSdt(sdt, manv);
    }

    public boolean checkDuplicateEmail(String email, String manv) {
        return DAO.NhanVienDAO.getInstance().checkDuplicateEmail(email, manv);
    }
    public boolean checkMaQuyenThayDoi(String manv,String tennhomquyenmoi){
        return DAO.NhanVienDAO.getInstance().checkMaQuyenThayDoi(manv, tennhomquyenmoi);
    }
}
