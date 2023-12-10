/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MenuDAO;
import DTO.ChucNang;

import java.util.ArrayList;

/**
 *
 * @author BomPC
 */
public class MenuBUS {
    
    private MenuDAO menuDAO;

    public MenuBUS(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
    
    public ArrayList<ChucNang> getDsChucNang (String maNhomQuyen) {
        return menuDAO.getDsChucNangFromDB(maNhomQuyen);
    }

    public ArrayList<String> getDsHanhDong (String maNhomQuyen, String chucNang) {
        return menuDAO.getDsHanhDongFromDB(maNhomQuyen, chucNang);
    }
}
