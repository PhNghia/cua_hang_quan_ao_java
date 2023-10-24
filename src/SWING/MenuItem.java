/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SWING;


/**
 *
 * @author BomPC
 */
public class MenuItem extends javax.swing.JLabel {
    public MenuItem () {
        initComponents();
    }
    
    private void initComponents() {
        setBackground(new java.awt.Color(51,51,51));
        setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(200, 50));
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                setBackground(new java.awt.Color(51,51,51));
                setForeground(new java.awt.Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setBackground(new java.awt.Color(255,255,255));
                setForeground(new java.awt.Color(51, 51, 51));
            }
        });
    }
}
