/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MenuDAO;
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
    
    public ArrayList<String> getDsChucNang (String maNhomQuyen) {
        return menuDAO.getDsChucNangFromDB(maNhomQuyen);
    }
}
