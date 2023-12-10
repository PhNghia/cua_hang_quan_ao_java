package SWING;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class ChucNangItemTitle extends ChucNangItem {
    public ChucNangItemTitle (JCheckBox checkbox, JLabel label) {
        super(checkbox, label);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        super.initComponents();
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        this.label.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.label.setForeground(Color.WHITE);
        this.setBackground(new Color(26,115,232));
    }
}
