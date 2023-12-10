/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cua_hang_quan_ao;

import GUI.DangNhapGUI;
import GUI.MenuGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DTO.NhanVien;

/**
 *
 * @author BomPC
 */
public class Cua_hang_quan_ao extends javax.swing.JFrame {

    /**
     * Creates new form Cua_hang_quan_ao
     */
    public static NhanVien nv;

    public Cua_hang_quan_ao() {
        initComponents();
        loginExecute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cua_hang_quan_ao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cua_hang_quan_ao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cua_hang_quan_ao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cua_hang_quan_ao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cua_hang_quan_ao();
            }
        });
    }

    public void loginExecute() {
        this.setTitle("Đăng nhập");
        this.setSize(new Dimension(330, 200));
        this.setLayout(new BorderLayout(0, 0));
        this.add(new DangNhapGUI(this));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void customComponents() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel rootPage = new JPanel();
        rootPage.setLayout(new BorderLayout(0, 0));
        rootPage.setBackground(new Color(255, 255, 255));
        this.add(rootPage, BorderLayout.CENTER);

        MenuGUI menuGUI = new MenuGUI(this);
        this.add(menuGUI, BorderLayout.WEST);

        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
