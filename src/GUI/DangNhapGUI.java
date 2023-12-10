/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BUS.DangNhapBUS;
import DTO.NhanVien;
import cua_hang_quan_ao.Cua_hang_quan_ao;

/**
 *
 * @author BomPC
 */
public class DangNhapGUI extends javax.swing.JPanel {
	DangNhapBUS loginBus = null;
	Cua_hang_quan_ao app;
	KeyListener enterListener;

	/**
	 * Creates new form DangNhap
	 */
	public DangNhapGUI(Cua_hang_quan_ao app) {
		this.app = app;
		initComponents();
		enterListener = new KeyAdapter() {
			@Override
			public void keyPressed (KeyEvent event) {
				if (event.getKeyCode() == 10) {
					// enter
					loginAction();
					return;
				}
			}
		};
		jtfTenDangNhap.addKeyListener(enterListener);
		jtfMatKhau.addKeyListener(enterListener);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		loginBus = new DangNhapBUS();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jtfTenDangNhap = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jtfMatKhau = new javax.swing.JPasswordField();
		jbtnDangNhap = new javax.swing.JButton();

		setPreferredSize(new java.awt.Dimension(330, 317));
		setLayout(new java.awt.BorderLayout());

		jPanel1.setLayout(new java.awt.BorderLayout());

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Đăng nhập");
		jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

		add(jPanel1, java.awt.BorderLayout.PAGE_START);

		jPanel2.setPreferredSize(new java.awt.Dimension(330, 297));
		jPanel2.setLayout(new java.awt.BorderLayout());

		jPanel4.setPreferredSize(new java.awt.Dimension(330, 140));
		jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));

		jLabel2.setText("Tên đăng nhập");
		jLabel2.setPreferredSize(new java.awt.Dimension(80, 16));
		jPanel4.add(jLabel2);

		jtfTenDangNhap.setMinimumSize(new java.awt.Dimension(200, 22));
		jtfTenDangNhap.setPreferredSize(new java.awt.Dimension(200, 26));
		jPanel4.add(jtfTenDangNhap);

		jLabel3.setText("Mật khẩu");
		jLabel3.setPreferredSize(new java.awt.Dimension(80, 16));
		jPanel4.add(jLabel3);

		jtfMatKhau.setPreferredSize(new java.awt.Dimension(200, 26));
		jtfMatKhau.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtfMatKhauActionPerformed(evt);
			}
		});
		jPanel4.add(jtfMatKhau);

		jbtnDangNhap.setText("Đăng nhập");
		jbtnDangNhap.setPreferredSize(new java.awt.Dimension(88, 26));
		jPanel4.add(jbtnDangNhap);

		jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

		add(jPanel2, java.awt.BorderLayout.CENTER);

		// Handle events
		jbtnDangNhap.addActionListener(e -> loginAction());
	}// </editor-fold>//GEN-END:initComponents

	private void loginAction() {
		String username = jtfTenDangNhap.getText();
		String password = jtfMatKhau.getText();
		boolean isSuccess = login(username, password);
		if (isSuccess) {
			app.setVisible(false);
			app.getContentPane().remove(0);
			app.customComponents();
			app.setVisible(true);
		}
	}

	private Boolean login(String username, String password) {
		HashMap<String, Object[]> accounts = this.loginBus.getAccounts();
		String isUserName = null;
		String isPassword = null;
		int trangthai = 0;
		boolean flag = false;

		// Check the existing username and password
		for (Map.Entry<String, Object[]> account : accounts.entrySet()) {
			String savedUsername = account.getKey();
			String savedPassword = account.getValue()[0].toString();

			if (savedUsername.equals(username) && savedPassword.equals(password)) {
				isUserName = savedUsername;
				isPassword = savedPassword;
				trangthai = Integer.parseInt(account.getValue()[1].toString());
			}
		}

		if (isUserName == null) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản không tồn tại");
			return flag;
		}

		if (isPassword == null) {
			JOptionPane.showMessageDialog(null, "Sai mật khẩu");
			return flag;
		}

		if (trangthai == 0) {
			JOptionPane.showMessageDialog(null, "Tài khoản đã ngừng hoạt động! Vui lòng liên hệ admin để biết thêm chi tiết!");
			return flag;
		}

		flag = true;

		// Lưu nhân viên đây nhé =))
		NhanVien employee = this.loginBus.getEmployee(isUserName);
		cua_hang_quan_ao.Cua_hang_quan_ao.nv = employee;
		return flag;
	}

	private void jtfMatKhauActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfMatKhauActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtfMatKhauActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JButton jbtnDangNhap;
	private javax.swing.JPasswordField jtfMatKhau;
	private javax.swing.JTextField jtfTenDangNhap;
	private javax.swing.JPanel employeeInfoPanel;
	// End of variables declaration//GEN-END:variables

}
