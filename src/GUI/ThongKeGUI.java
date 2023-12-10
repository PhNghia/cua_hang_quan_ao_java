/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author BomPC
 */
public class ThongKeGUI extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeGUI
     */
    public ThongKeGUI() {
        initComponents();
        customComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpnDoanhThu = new javax.swing.JPanel();
        jpnSPXuat = new javax.swing.JPanel();
        jpnSPNhap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jpnDoanhThu.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Doanh thu", jpnDoanhThu);

        jpnSPXuat.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Sản phẩm xuất", jpnSPXuat);

        jpnSPNhap.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Sản phẩm nhập", jpnSPNhap);

        add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);
        jTabbedPane1.getAccessibleContext().setAccessibleName("");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpnDoanhThu;
    private javax.swing.JPanel jpnSPNhap;
    private javax.swing.JPanel jpnSPXuat;
    // End of variables declaration//GEN-END:variables

    public void customComponents() {
        changeUniScroll();
        renderTab(0);
        jTabbedPane1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                renderTab(jTabbedPane1.getSelectedIndex());
                revalidate();
            }
        });
    }

    public void changeUniScroll () {
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
    }

    public void renderTab(int index) {
        jPanel1.removeAll();
        switch (index) {
            case 0:
                jPanel1.add(new ThongKeDoanhThuGUI(), BorderLayout.CENTER);
                break;
            case 1:
                jPanel1.add(new ThongKeSanPhamBanChayGUI(), BorderLayout.CENTER);
                break;
            case 2:
                jPanel1.add(new ThongKeSoLuongNhapHangGUI(), BorderLayout.CENTER);
                break;
        }
    }
}
