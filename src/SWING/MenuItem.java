/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SWING;

import java.awt.Color;

/**
 *
 * @author BomPC
 */
public class MenuItem extends javax.swing.JLabel {
    private boolean isSelected = false;
    private Color bgColor = new Color(76,76,76);

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public MenuItem () {
        initComponents();
    }

    private void initComponents() {
        setBackground(bgColor);
        setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(200, 50));

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (isSelected == false) {
                    setStopedState();
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setActiveState();
            }
        });
    }

    public void setStopedState() {
        setBackground(bgColor);
        setForeground(new java.awt.Color(255, 255, 255));
    }

    public void setActiveState() {
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(bgColor);
    }
}
