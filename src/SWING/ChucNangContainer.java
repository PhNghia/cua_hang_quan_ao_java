/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SWING;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

/**
 *
 * @author BomPC
 */
public class ChucNangContainer extends javax.swing.JPanel {
    public ChucNangContainer () {
        initComponents();
    }
    
    public void initComponents () {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new LineBorder(Color.black));
    }
}
