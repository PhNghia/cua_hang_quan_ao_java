/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BUS.HoaDonBanBUS;
import BUS.HoaDonMuaBUS;
import DAO.HoaDonBanDAO;
import DTO.FormatValue;
import DTO.HoaDonBan;
import DTO.HoaDonMua;

@SuppressWarnings({ "serial", "unused" })
public class HoaDonBanGUI extends javax.swing.JPanel {

	private final HoaDonBanBUS hdbBUS;

	public HoaDonBanBUS getBUS() {
		return hdbBUS;
	}

	public HoaDonBanGUI(ArrayList<String> dsHanhDongCuaChucNang) {
		hdbBUS = new HoaDonBanBUS(new HoaDonBanDAO());
		initComponents();
		customComponents();
		jbtnThem.setVisible(false);
		jbtnThuHoi.setVisible(false);
		for (String hd : dsHanhDongCuaChucNang) {
			if (hd.toLowerCase().contains("thêm")) {
				jbtnThem.setVisible(true);
			} else if (hd.toLowerCase().contains("thu")) {
				jbtnThuHoi.setVisible(true);
			}
		}
	}

	private JButton jbtnThem;

	private void initComponents() {

		jbtnThem = new JButton("Hóa đơn mới");

		jbtnThuHoi = new javax.swing.JButton();
		jcbNameSearch = new javax.swing.JComboBox<>();
		jtfNameSearch = new javax.swing.JTextField();
		jbtnSearch = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtbCTHD = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jlbTongTienHD = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtbDSHoaDon = new javax.swing.JTable();
		jbtnlammoi = new javax.swing.JButton();
//		jlbCa = new javax.swing.JLabel();
		jcbCaSearch = new javax.swing.JComboBox<>();

		jbtnThuHoi.setText("Thu hồi");

		jcbNameSearch.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Tất cả", "Mã hóa đơn", "Khách hàng", "Nhân viên" }));

		jbtnSearch.setText("Tìm kiếm");

		jPanel1.setLayout(new java.awt.BorderLayout());

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
		jPanel2.setPreferredSize(new java.awt.Dimension(600, 500));
		jPanel2.setLayout(new java.awt.BorderLayout());

		jtbCTHD.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Sản phẩm", "Giá bán", "Giảm giá", "Số lượng", "Tổng tiền" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(jtbCTHD);
		if (jtbCTHD.getColumnModel().getColumnCount() > 0) {
			jtbCTHD.getColumnModel().getColumn(0).setResizable(false);
			jtbCTHD.getColumnModel().getColumn(1).setResizable(false);
			jtbCTHD.getColumnModel().getColumn(2).setResizable(false);
			jtbCTHD.getColumnModel().getColumn(3).setResizable(false);
			jtbCTHD.getColumnModel().getColumn(4).setResizable(false);
			jtbCTHD.getColumnModel().getColumn(5).setResizable(false);
		}

		jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

		jLabel1.setText("Tổng tiền hóa đơn:");

		jlbTongTienHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jlbTongTienHD.setForeground(new java.awt.Color(255, 0, 0));
		jlbTongTienHD.setText("0 VNĐ");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jlbTongTienHD)
						.addContainerGap(351, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jlbTongTienHD))
						.addContainerGap(58, Short.MAX_VALUE)));

		jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

		jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_END);

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		jPanel4.setLayout(new java.awt.BorderLayout());

		jtbDSHoaDon.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
//				new String[] { "Mã hóa đơn", "Khách hàng", "Nhân viên", "Ngày tạo", "Tổng tiền", "Tiêu điểm" }) {
//			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
			new String[] { "Mã hóa đơn", "Khách hàng", "Nhân viên", "Ngày tạo", "Tổng tiền"}) {
				boolean[] canEdit = new boolean[] { false, false, false, false, false};


			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jtbDSHoaDon.setToolTipText("");
		jtbDSHoaDon.setInheritsPopupMenu(true);
		jtbDSHoaDon.setShowGrid(false);
		jScrollPane1.setViewportView(jtbDSHoaDon);
		if (jtbDSHoaDon.getColumnModel().getColumnCount() > 0) {
			jtbDSHoaDon.getColumnModel().getColumn(0).setResizable(false);
			jtbDSHoaDon.getColumnModel().getColumn(1).setResizable(false);
			jtbDSHoaDon.getColumnModel().getColumn(2).setResizable(false);
			jtbDSHoaDon.getColumnModel().getColumn(3).setResizable(false);
			jtbDSHoaDon.getColumnModel().getColumn(4).setResizable(false);
		}

		jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

		jbtnlammoi.setText("Làm mới");

//		jlbCa.setText("Ca làm việc");

//		jcbCaSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Ca 1", "Ca 2" }));
//		jcbCaSearch.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				jcbCaSearchActionPerformed(evt);
//			}
//		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jbtnThem)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnThuHoi)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnlammoi))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jcbNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
														180, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnSearch).addGap(70, 70, 70)
//												.addComponent(jlbCa)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//												.addComponent(jcbCaSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
//														javax.swing.GroupLayout.DEFAULT_SIZE,
//														javax.swing.GroupLayout.PREFERRED_SIZE)
										)).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jbtnThem).addComponent(jbtnThuHoi).addComponent(jbtnlammoi))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jcbNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtnSearch)
//								.addComponent(jlbCa)
//								.addComponent(jcbCaSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
//										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						).addGap(30, 30, 30)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}// </editor-fold>                        

	private void jcbCaSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcbCaSearchActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jcbCaSearchActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jbtnlammoi;
	private javax.swing.JButton jbtnSearch;

	private javax.swing.JButton jbtnThuHoi;
	private javax.swing.JComboBox<String> jcbCaSearch;
	private javax.swing.JComboBox<String> jcbNameSearch;
//	private javax.swing.JLabel jlbCa;
	private javax.swing.JLabel jlbTongTienHD;
	private javax.swing.JTable jtbCTHD;
	private javax.swing.JTable jtbDSHoaDon;
	private javax.swing.table.DefaultTableModel model;
	private javax.swing.JTextField jtfNameSearch;
	// End of variables declaration//GEN-END:variables

	private HoaDonBanGUI hdbGUI;

	private void customComponents() {
		hdbGUI = this;
		jbtnlammoi.setVisible(false);

		ListSelectionModel selectOfDSHD = this.jtbDSHoaDon.getSelectionModel();
		selectOfDSHD.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = jtbDSHoaDon.getSelectedRow();
				if (row < 0) {
					renderTableCTHDB();
//                    renderInforCTHB();
					return;
				}
				;
				renderTableCTHDB(row);
			}
		});

		jbtnlammoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				renewTable();
				renderTableHDB();
			}
		});

		jbtnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleFilterHDB();
			}
		});

		jbtnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame topFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, (Component) e.getSource());
				JDialog dialog = new JDialog(topFrame, JDialog.ModalityType.APPLICATION_MODAL);
				dialog.setTitle("Tạo hóa đơn bán mới");
				dialog.setLayout(new BorderLayout(0, 0));
				dialog.setSize(1400, 800);
				dialog.add(new HoaDonBanMoiGUI(hdbGUI, dialog));
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}

		});
		renderTableHDB();

		jbtnThuHoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = jtbDSHoaDon.getSelectedRow();
					removeHDB(row);
                                        hdbBUS.getDsHDBFromDB();
					renderTableHDB();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Chọn Hóa đơn muốn thu hồi");
				}

			}
		});
	}

	public void removeHDB(int row) {
		int selectMaHD = jtbDSHoaDon.getSelectedRow();
		String maHD = (String) jtbDSHoaDon.getValueAt(row, 0);

		try {
			hdbBUS.xoaHD(maHD);
			JOptionPane.showMessageDialog(null, "Thu hồi thành công");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}

	}

	public void renewTable() {
		// Chuyển dữ liệu từ JTable sang DefaultTableModel
		DefaultTableModel defaultTableModel = (DefaultTableModel) jtbDSHoaDon.getModel();
		defaultTableModel.setRowCount(0);
	}

	public void renderTableHDB() {

		String[][] data = this.hdbBUS.getDsHDB();
        this.jtbDSHoaDon.setModel(new DefaultTableModel(
                        data,
                        new String[] { "Mã hóa đơn", "Khách hàng", "Nhân viên", "Ngày tạo", "Tổng tiền"}) {
                			boolean[] canEdit = new boolean[] { false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                }
        });
        this.revalidate();
	}

	public void renderTableCTHDB() {
//        jpnCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn mua"));
		jlbTongTienHD.setText("");
		jtbCTHD.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Mã sản phẩm",
				"Sản phẩm", "Nhà cung cấp", "Giá nhập (VNĐ)", "Số lượng nhập (chiếc)", "Tổng tiền (VNĐ)" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		this.revalidate();
	}

	public void renderTableCTHDB(int row) {
		HoaDonBan hdmSelected = hdbBUS.getHDBSelected(row);
//        jpnCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn mua " + hdmSelected.getMaHD()));
		jlbTongTienHD.setText(FormatValue.formatCurrency((long) hdmSelected.getTongTien()));

		String[][] data = hdbBUS.getDsCTHDB(row);
		jtbCTHD.setModel(new javax.swing.table.DefaultTableModel(data,
				new String[] { "Mã sản phẩm", "Sản phẩm", "Giá bán", "Giảm giá", "Số lượng", "Tổng tiền" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		this.revalidate();
	};

	public void handleFilterHDB() {
		String itemFilterCbSelected = (String) jcbNameSearch.getSelectedItem();
		String valueOfJtfNameSearch = jtfNameSearch.getText();
		System.out.print(jtfNameSearch.getText());
		hdbBUS.filterDsHDB(itemFilterCbSelected, valueOfJtfNameSearch);
		renderTableHDB();
	}

}
