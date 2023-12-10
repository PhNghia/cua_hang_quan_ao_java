package DTO;

public class ChucNang {

    private int macn;
    private String tencn;
    private String icon;

    public ChucNang() {
    }

    public ChucNang(int macn, String tencn) {
        this.macn = macn;
        this.tencn = tencn;
    }

    public ChucNang(int macn, String tencn, String icon) {
        this.macn = macn;
        this.tencn = tencn;
        this.icon = icon;
    }

    public int getMacn() {
        return macn;
    }

    public void setMacn(int macn) {
        this.macn = macn;
    }

    public String getTencn() {
        return tencn;
    }

    public void setTencn(String tencn) {
        this.tencn = tencn;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
