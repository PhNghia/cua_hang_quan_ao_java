
package DTO;

public class QuyUocDiem {
    private int menh_gia;
    private int bang_diem;
    private int bang_tien;

    public QuyUocDiem() {
    }

    public QuyUocDiem(int menh_gia, int bang_diem, int bang_tien) {
        this.menh_gia = menh_gia;
        this.bang_diem = bang_diem;
        this.bang_tien = bang_tien;
    }

    public int getMenh_gia() {
        return menh_gia;
    }

    public void setMenh_gia(int menh_gia) {
        this.menh_gia = menh_gia;
    }

    public int getBang_diem() {
        return bang_diem;
    }

    public void setBang_diem(int bang_diem) {
        this.bang_diem = bang_diem;
    }

    public int getBang_tien() {
        return bang_tien;
    }

    public void setBang_tien(int bang_tien) {
        this.bang_tien = bang_tien;
    }
    
    
}
