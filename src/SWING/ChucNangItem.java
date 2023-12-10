/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SWING;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author BomPC
 */
public class ChucNangItem extends javax.swing.JPanel {

    protected JCheckBox checkbox;
    protected JLabel label;
    
    public ChucNangItem (JCheckBox checkbox, JLabel label) {
        this.checkbox = checkbox;
        this.label = label;
        initComponents();
    }
    
    public void initComponents() {
        this.setBorder(new EmptyBorder(0, 10, 0, 20));
        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
        checkbox.setText("");
        this.add(label, BorderLayout.CENTER);
        this.add(checkbox, BorderLayout.EAST);
    }
}
