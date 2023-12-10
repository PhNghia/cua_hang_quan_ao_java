
package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.Soundbank;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import BUS.HoaDonBanBUS;
import BUS.HoaDonBanMoiBUS;
import BUS.HoaDonMuaMoiBUS;
import BUS.KhachHangBUS;
import DAO.HoaDonBanMoiDAO;
import DAO.HoaDonMuaMoiDAO;
import DAO.KhachHangDAO;
import DAO.QuyUocDiemDAO;
import DTO.ChiTietHDB;
import DTO.ChiTietHDM;
import DTO.FormatValue;
import DTO.HoaDonBan;
import DTO.HoaDonMua;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.QuyUocDiem;
import DTO.SanPham;

@SuppressWarnings({ "serial", "unused" })
public class HoaDonBanMoiGUI extends javax.swing.JPanel {
	private final HoaDonBanMoiBUS hdbmBUS;
	private JDialog parentDialog;
	private List<KhachHang> khachhang;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jbtnHuy;
	private javax.swing.JButton jbtnLamMoi;
	private javax.swing.JButton jbtnSearch;
	private javax.swing.JButton jbtnSua;
	private javax.swing.JButton jbtnThem;
	private javax.swing.JButton jbtnThoat;
	private javax.swing.JButton jbtnXacNhan;
	private javax.swing.JButton jbtnXoa;
	private javax.swing.JLabel jlbKetQuaTim;
	private javax.swing.JLabel jlbMaHDTitle;
	private javax.swing.JLabel jlbMaSP;
	private javax.swing.JLabel jlbSdt;
	private javax.swing.JLabel jlbSoLuong;
	private javax.swing.JLabel jlbTenSP;
	private javax.swing.JLabel jlbTieuDiem;
	private javax.swing.JLabel jlbTitle;
	private javax.swing.JLabel jlbTongTienNumber;
	private javax.swing.JLabel jlbTongTienTitle;
	private javax.swing.JPanel jpnFormCTHD;
	private javax.swing.JSpinner jspnSoLuong;
	private javax.swing.JTable jtbCTHD;
	private javax.swing.JTable jtbDSSP;
	private javax.swing.JTextField jtfMaSP;
	private javax.swing.JTextField jtfSdt;
	private javax.swing.JTextField jtfTenSP;
	private javax.swing.JTextField jtfTieuDiem;
	// End of variables declaration//GEN-END:variables

	private HoaDonBanGUI hdbGUI;
	private JDialog dialog;

	public HoaDonBanMoiGUI(HoaDonBanGUI hdmGUI, JDialog parentDialog) {
		this.hdbGUI = hdmGUI;
		this.parentDialog = parentDialog;
		hdbmBUS = new HoaDonBanMoiBUS(new HoaDonBanMoiDAO());
		initComponents();
		customComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jlbMaHDTitle = new javax.swing.JLabel();
		jlbTitle = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jbtnThoat = new javax.swing.JButton();
		jbtnXacNhan = new javax.swing.JButton();
		jbtnLamMoi = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jpnFormCTHD = new javax.swing.JPanel();
		jPanel6 = new javax.swing.JPanel();
		jPanel7 = new javax.swing.JPanel();
		jlbTongTienTitle = new javax.swing.JLabel();
		jlbTongTienNumber = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jlbSdt = new javax.swing.JLabel();
		jtfSdt = new javax.swing.JTextField();
		jbtnSearch = new javax.swing.JButton();
		jlbKetQuaTim = new javax.swing.JLabel();
		jlbTieuDiem = new javax.swing.JLabel();
		jtfTieuDiem = new javax.swing.JTextField();
		jPanel8 = new javax.swing.JPanel();
		jlbMaSP = new javax.swing.JLabel();
		jtfMaSP = new javax.swing.JTextField();
		jlbTenSP = new javax.swing.JLabel();
		jtfTenSP = new javax.swing.JTextField();
		jlbSoLuong = new javax.swing.JLabel();
		jspnSoLuong = new javax.swing.JSpinner();
		jbtnThem = new javax.swing.JButton();
		jbtnSua = new javax.swing.JButton();
		jbtnXoa = new javax.swing.JButton();
		jbtnHuy = new javax.swing.JButton();
		jPanel10 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtbCTHD = new javax.swing.JTable();
		jPanel11 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtbDSSP = new javax.swing.JTable();

		setLayout(new java.awt.BorderLayout());

		jPanel1.setPreferredSize(new java.awt.Dimension(839, 60));
		jPanel1.setLayout(new java.awt.BorderLayout());

		jlbMaHDTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbMaHDTitle.setText("Hóa đơn: HD01");
		jPanel1.add(jlbMaHDTitle, java.awt.BorderLayout.CENTER);

		jlbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbTitle.setText("Tạo hóa đơn mới");
		jPanel1.add(jlbTitle, java.awt.BorderLayout.PAGE_START);

		add(jPanel1, java.awt.BorderLayout.PAGE_START);

		jPanel2.setPreferredSize(new java.awt.Dimension(151, 60));
		java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
		jPanel2Layout.columnWidths = new int[] { 0, 20, 0, 20, 0, 20, 0, 20, 0 };
		jPanel2Layout.rowHeights = new int[] { 0, 0, 0 };
		jPanel2.setLayout(jPanel2Layout);

		jbtnThoat.setText("Thoát");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 0;
		jPanel2.add(jbtnThoat, gridBagConstraints);

		jbtnXacNhan.setText("Xác nhận");

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		jPanel2.add(jbtnXacNhan, gridBagConstraints);

		jbtnLamMoi.setText("Làm mới");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		jPanel2.add(jbtnLamMoi, gridBagConstraints);

		add(jPanel2, java.awt.BorderLayout.PAGE_END);

		jPanel3.setLayout(new java.awt.BorderLayout());

		jpnFormCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Hiệu chỉnh chi tiết hóa đơn"));
		jpnFormCTHD.setPreferredSize(new java.awt.Dimension(1282, 220));
		jpnFormCTHD.setLayout(new java.awt.BorderLayout());

		jPanel6.setPreferredSize(new java.awt.Dimension(490, 140));
		jPanel6.setLayout(new java.awt.BorderLayout());

		jPanel7.setMinimumSize(new java.awt.Dimension(100, 30));
		jPanel7.setPreferredSize(new java.awt.Dimension(490, 30));

		jlbTongTienTitle.setText("Tổng tiền hóa đơn:");

		jlbTongTienNumber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jlbTongTienNumber.setForeground(new java.awt.Color(255, 0, 0));
		jlbTongTienNumber.setText("0 VNĐ");

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(jlbTongTienTitle)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jlbTongTienNumber).addContainerGap(266, Short.MAX_VALUE)));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addGap(0, 0, 0)
						.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbTongTienTitle).addComponent(jlbTongTienNumber))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel6.add(jPanel7, java.awt.BorderLayout.PAGE_START);

		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tích điểm cho khách hàng"));

		jlbSdt.setText("Số điện thoại");

		jbtnSearch.setText("Tìm kiếm");

		jlbKetQuaTim.setText("");

		jlbTieuDiem.setText("Tiêu điểm");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jlbKetQuaTim, javax.swing.GroupLayout.PREFERRED_SIZE, 450,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel5Layout.createSequentialGroup().addComponent(jlbSdt)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jbtnSearch))
								.addGroup(jPanel5Layout.createSequentialGroup().addComponent(jlbTieuDiem)
										.addGap(26, 26, 26).addComponent(jtfTieuDiem,
												javax.swing.GroupLayout.PREFERRED_SIZE, 176,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(24, Short.MAX_VALUE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbSdt)
								.addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtnSearch))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jlbKetQuaTim)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbTieuDiem).addComponent(jtfTieuDiem,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel6.add(jPanel5, java.awt.BorderLayout.CENTER);

		jpnFormCTHD.add(jPanel6, java.awt.BorderLayout.LINE_END);

		jPanel8.setPreferredSize(new java.awt.Dimension(713, 140));

		jlbMaSP.setText("Mã sản phẩm");

		jlbTenSP.setText("Sản phẩm");

		jlbSoLuong.setText("Số lượng");

		jspnSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

		jbtnThem.setText("Thêm vào hóa đơn");

		jbtnSua.setText("Sửa chi tiết");

		jbtnXoa.setText("Xóa khỏi hóa đơn");

		jbtnHuy.setText("Hủy");

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jlbMaSP).addComponent(jlbTenSP).addComponent(jlbSoLuong))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel8Layout.createSequentialGroup()
										.addComponent(jspnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(147, 147, 147).addComponent(jbtnThem)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jbtnSua)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jbtnXoa)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jbtnHuy))
								.addGroup(jPanel8Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jtfMaSP).addComponent(jtfTenSP,
												javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
						.addContainerGap(56, Short.MAX_VALUE)));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbMaSP).addComponent(jtfMaSP, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbTenSP).addComponent(jtfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbSoLuong)
								.addComponent(jspnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtnThem).addComponent(jbtnSua).addComponent(jbtnXoa)
								.addComponent(jbtnHuy))
						.addContainerGap(88, Short.MAX_VALUE)));

		jpnFormCTHD.add(jPanel8, java.awt.BorderLayout.CENTER);

		jPanel3.add(jpnFormCTHD, java.awt.BorderLayout.PAGE_END);

		jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
		jPanel10.setPreferredSize(new java.awt.Dimension(500, 471));
		jPanel10.setLayout(new java.awt.BorderLayout());

		jtbCTHD.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Sản phẩm", "Số lượng", "Tổng tiền" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

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
		}

		jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

		jPanel3.add(jPanel10, java.awt.BorderLayout.LINE_END);

		jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
		jPanel11.setLayout(new java.awt.BorderLayout());

		jtbDSSP.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Mã sản phẩm", "Sản phẩm", "Giá bán", "Giảm giá", "Hiện có" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}

		});
		jScrollPane1.setViewportView(jtbDSSP);
		if (jtbDSSP.getColumnModel().getColumnCount() > 0) {
			jtbDSSP.getColumnModel().getColumn(0).setResizable(false);
			jtbDSSP.getColumnModel().getColumn(1).setResizable(false);
			jtbDSSP.getColumnModel().getColumn(2).setResizable(false);
			jtbDSSP.getColumnModel().getColumn(3).setResizable(false);
			jtbDSSP.getColumnModel().getColumn(4).setResizable(false);
		}

		jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		jPanel3.add(jPanel11, java.awt.BorderLayout.CENTER);

		add(jPanel3, java.awt.BorderLayout.CENTER);
	}// </editor-fold>//GEN-END:initComponents

	public void customComponents() {
		renderHDB();
		renderGUIAction();
		renderDsSanPham();

		ListSelectionModel selectOfDSHD = this.jtbDSSP.getSelectionModel();
		selectOfDSHD.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = -1;
				row = jtbDSSP.getSelectedRow();
				if (row < 0) {
					renderInforSP();
					row = -1;
				} else {
					renderInforSP(row);
				}
			}
		});

		ListSelectionModel selectOfCTHD = this.jtbCTHD.getSelectionModel();
		selectOfCTHD.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = jtbCTHD.getSelectedRow();
				if (row < 0) {
				} else {
					renderInforCTHDB(row);
					renderGUIAction();
				}

			}
		});

		jtfMaSP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (jtbCTHD.getSelectedRow() < 0) {
					JTextField source = (JTextField) e.getSource();
					String value = source.getText();
					hdbmBUS.filteredDsSPByMa(value);
					renderDsSanPham();
					if (hdbmBUS.getDsSanPham().length == 1) {
						jtbDSSP.setRowSelectionInterval(0, 0);
					}
				}
			}
		});

		jtfTenSP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (jtbCTHD.getSelectedRow() < 0) {
					JTextField source = (JTextField) e.getSource();
					String value = source.getText();
					hdbmBUS.filteredDsSPByTen(value);
					renderDsSanPham();
					if (hdbmBUS.getDsSanPham().length == 1) {
						jtbDSSP.setRowSelectionInterval(0, 0);
					}
				}
			}
		});

		jbtnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleThemSPVaoCTHDB();
			}
		});

		jbtnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedCTHDMIndex = jtbCTHD.getSelectedRow();
				handleSuaCTHDM(selectedCTHDMIndex);
				unselectedTableDsCTHDB();
			}
		});

		jbtnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedCTHDMIndex = jtbCTHD.getSelectedRow();
				int result = handleXoaCTHDB(selectedCTHDMIndex);
				if (result == JOptionPane.YES_OPTION) {
					unselectedTableDsCTHDB();
				}
			}
		});

		jbtnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unselectedTableDsCTHDB();
			}
		});

		jbtnLamMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int gotOption = JOptionPane.showConfirmDialog(parentDialog,
						"Làm mới hóa đơn sẽ xóa toàn bộ sản phẩm đã được chọn! Xác nhận làm mới?", "Thông báo xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (gotOption == JOptionPane.YES_OPTION) {
					hdbmBUS.resetHDB();
					renderDsCTHDB();
				}
			}
		});

		jbtnThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parentDialog.dispose();
			}
		});

		jbtnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnSearchActionPerformed(e);

			}
		});

		jbtnXacNhan.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (hdbmBUS.getDsCTHDB().length <= 0) {
					JOptionPane.showMessageDialog(parentDialog, "Hóa đơn trống không thể thêm", "Thêm hóa đơn thất bại",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int gotOption = JOptionPane.showConfirmDialog(parentDialog, "Xác nhận thêm hóa đơn?",
						"Thông báo xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (gotOption == JOptionPane.YES_OPTION) {
					String sdt = jtfSdt.getText();
					if (!sdt.isEmpty()) {
						if (checkExistSDT(sdt) == 1) {
							if (jtfTieuDiem.getText().isEmpty()) {
								tichdiem(sdt);
								JOptionPane.showMessageDialog(parentDialog, "Thêm hóa đơn thành công",
										"Thông báo kết quả", JOptionPane.INFORMATION_MESSAGE);

								System.out.println("tich diem");
							} else if (isAllLetters(jtfTieuDiem.getText())) {
								JOptionPane.showMessageDialog(parentDialog, "tiêu điểm phải là số nguyên",
										"Thông báo kết quả", JOptionPane.INFORMATION_MESSAGE);
								return;
							} else if (Integer.valueOf(jtfTieuDiem.getText()) < 0) {
								JOptionPane.showMessageDialog(parentDialog, "tiêu điểm không là số âm",
										"Thông báo kết quả", JOptionPane.INFORMATION_MESSAGE);
								return;
							} else {
								System.out.println("tieu diem");
								if (tieudiem(sdt) == false) {
									return;
								}
								tichdiem(sdt);
							}
						}
						khachhang = new HoaDonBanMoiBUS().FindKH(sdt + "");
						for (KhachHang a : khachhang) {
							hdbmBUS.handleThemHDB(a.getMaKH());
						}
					} else {
						hdbmBUS.handleThemHDB(5);
						JOptionPane.showMessageDialog(parentDialog, "Thêm hóa đơn thành công", "Thông báo kết quả",
								JOptionPane.INFORMATION_MESSAGE);
					}

					renderFinalGUI();
					hdbmBUS.getDsSanPhamFromDB();
					renderDsSanPham();
					hdbGUI.getBUS().getDsHDBFromDB();
					hdbGUI.renderTableHDB();
				}
			}
		});
	}

	private static boolean isAllLetters(String s) {
		// Kiểm tra xem tất cả các ký tự trong chuỗi có phải là chữ không
		for (char c : s.toCharArray()) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	private boolean tieudiem(String sdt) {
		HoaDonBan hdb = hdbmBUS.getHDB();
		int[] cacQuyUocDiem = hdbmBUS.getQuyUocDiem();
		khachhang = new HoaDonBanMoiBUS().FindKH(sdt + "");
		for (KhachHang a : khachhang) {
			if (Integer.valueOf(jtfTieuDiem.getText()) > Integer.valueOf(a.getBangTien())) {
				JOptionPane.showMessageDialog(parentDialog, "Không đủ điểm đổi!!\n",
						"Thêm hóa đơn thất bại", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			a.setBangTien(Integer.valueOf(a.getBangTien()) - Integer.valueOf(jtfTieuDiem.getText()));

			System.out.println(Integer.valueOf(jtfTieuDiem.getText()));
			System.out.println(a.getBangTien());
			a.setDiemTichLuy(a.getDiemTichLuy() - Integer.valueOf(jtfTieuDiem.getText()) / cacQuyUocDiem[2]);

			// a.setTienTichLuy(a.getTienTichLuy() - Integer.valueOf(jtfTieuDiem.getText())
			// * 100);
			a.setSdt(sdt);
			hdb.setTongTien(Integer.valueOf(hdb.getTongTien()) - Integer.valueOf(jtfTieuDiem.getText()));
			jlbTongTienNumber.setText(FormatValue.formatCurrency((long) hdb.getTongTien()));
			jlbKetQuaTim.setText(
					a.getTenKH() + "[ Điểm " + a.getDiemTichLuy() + " ][ Tiền  " + a.getBangTien() + " ]");
			try {
				new KhachHangDAO().UpdateDiem(a);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private void tichdiem(String sdt) {// GEN-FIRST:event_btLuuActionPerformed
		HoaDonBan hdb = hdbmBUS.getHDB();
		int[] cacQuyUocDiem = hdbmBUS.getQuyUocDiem();
		khachhang = new HoaDonBanMoiBUS().FindKH(sdt + "");
		for (KhachHang a : khachhang) {
			a.setTienTichLuy(Integer.valueOf(hdb.getTongTien()) + Integer.valueOf(a.getTienTichLuy()));
			// a.setBangTien(Integer.valueOf(hdb.getTongTien()) +
			// Integer.valueOf(a.getBangTien()));
			a.setDiemTichLuy(
					Integer.valueOf(hdb.getTongTien()) / cacQuyUocDiem[0] + Integer.valueOf(a.getDiemTichLuy()));

			// a.setTienTichLuy(Integer.valueOf(hdb.getTongTien()) / 100 +
			// Integer.valueOf(a.getTienTichLuy()));
			a.setBangTien(Integer.valueOf(hdb.getTongTien()) / cacQuyUocDiem[0] * cacQuyUocDiem[2]
					+ Integer.valueOf(a.getBangTien()));
			a.setSdt(sdt);

			jlbKetQuaTim.setText(
					a.getTenKH() + "[ Điểm " + a.getDiemTichLuy() + " ][ Tiền  " + a.getBangTien() + " ]");
			new KhachHangDAO().UpdateDiem(a);
		}

	}// G

	public void renderFinalGUI() {
		jbtnThem.setEnabled(false);
		jbtnSua.setEnabled(false);
		jbtnXoa.setEnabled(false);
		jbtnXacNhan.setEnabled(false);
		jbtnLamMoi.setEnabled(false);
	}

	private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
		if (!checkValidSDT(jtfSdt.getText())) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			return;
		}
		String sdt = jtfSdt.getText();

		khachhang = new HoaDonBanMoiBUS().FindKH(sdt);
		jlbKetQuaTim.setText("Không tìm thấy khách hàng");
		for (KhachHang kh : khachhang) {
			jlbKetQuaTim.setText(
					kh.getTenKH() + "[ Điểm " + kh.getDiemTichLuy() + " ][ Tiền  " + kh.getBangTien() + " ]");
		}

	}

	public int checkExistSDT(String sdt) {
		khachhang = new HoaDonBanMoiBUS().FindKH(sdt);
		if (khachhang != null) {
			return 1;
		}
		return -1;
	}

	public Boolean checkTieuDiem() {
		System.out.println(jtfTieuDiem.getText().isEmpty());
		if (jtfTieuDiem.getText().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	public ChiTietHDB getInputDataFromForm() {

		boolean isValidInput = true;
		// Lấy chỉ mục hàng được chọn
		int selectedRow = jtbDSSP.getSelectedRow();

		// Lấy giá trị từ ô (hàng, cột) trong JTable
		Object obj = jtbDSSP.getValueAt(selectedRow, 4);
		int tongTien = Integer.parseInt((String) obj);

		SanPham sp = new SanPham(jtfMaSP.getText().trim(), jtfTenSP.getText().trim(), tongTien, 0);

		int soLuong = (int) jspnSoLuong.getValue();

		isValidInput = validateSP(sp);
		if (isValidInput == false) {
			return null;
		}
		sp.setSoLuong(soLuong);
		ChiTietHDB cthdbmoi = new ChiTietHDB(hdbmBUS.getHDB().getMaHD(), sp, soLuong, soLuong * tongTien);
		return cthdbmoi;
	}

	public ChiTietHDB getInputDataFromFormCTHD() {

		boolean isValidInput = true;
		// Lấy chỉ mục hàng được chọn
		int selectedRow = jtbCTHD.getSelectedRow();

		// Lấy giá trị từ ô (hàng, cột) trong JTable
		Object obj = jtbCTHD.getValueAt(selectedRow, 3);
		int tongTien = Integer.parseInt((String) obj);

		SanPham sp = new SanPham(jtfMaSP.getText().trim(), jtfTenSP.getText().trim(), tongTien, 0);

		int soLuong = (int) jspnSoLuong.getValue();

		isValidInput = validateSP(sp);
		if (isValidInput == false) {
			return null;
		}
		sp.setSoLuong(soLuong);
		ChiTietHDB cthdbmoi = new ChiTietHDB(hdbmBUS.getHDB().getMaHD(), sp, soLuong, soLuong * tongTien);
		return cthdbmoi;
	}

	public void handleThemSPVaoCTHDB() {
		ChiTietHDB cthdbmoi = getInputDataFromForm();
		if (cthdbmoi == null) {
			return;
		}
		if (cthdbmoi.getSanPham().getSoLuong() == 0) {
			JOptionPane.showMessageDialog(null, "Sản phẩm đã hết hàng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		};
		if (jtbDSSP.getSelectedRow() != -1) {
			int existsCthdb = hdbmBUS.existsCthdb(cthdbmoi);
			if (existsCthdb != -1) {
				boolean isSame = hdbmBUS.isSameSanPham(cthdbmoi);
				if (isSame) {
					hdbmBUS.themCTHDB(existsCthdb, cthdbmoi);
				}
			} else {
				hdbmBUS.themCTHDB(cthdbmoi);
			}
			renderHDB();
			renderDsCTHDB();
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm! Không thể thêm vào hóa đơn",
					"Thêm vào hóa đơn thất bại", JOptionPane.WARNING_MESSAGE);
		}
	}

	private int CheckCTHDM(ChiTietHDB ct) {
		int rowIndex = findProductIndex(ct.getSanPham());

		if (rowIndex != -1) {
			// Sản phẩm đã tồn tại, cập nhật số lượng
			int currentQuantity = (int) jtbCTHD.getValueAt(rowIndex, 2);
			jtbCTHD.setValueAt(currentQuantity + (int) jspnSoLuong.getValue(), rowIndex, 2);
			return rowIndex;
		} else {
			return -1;
		}
	}

	private int findProductIndex(SanPham sp) {
		for (int i = 0; i < jtbCTHD.getRowCount(); i++) {
			String currentMaSP = (String) jtbCTHD.getValueAt(i, 0);
			if (sp.getMaSP().equals(currentMaSP)) {
				return i; // Trả về chỉ số nếu sản phẩm đã tồn tại
			}
		}
		return -1; // Trả về -1 nếu sản phẩm chưa tồn tại
	}

	public void renderHDB() {
		HoaDonBan hdb = hdbmBUS.getHDB();
		jlbMaHDTitle.setText("Mã hóa đơn: " + hdb.getMaHD());
		jlbTongTienNumber.setText(FormatValue.formatCurrency((long) hdb.getTongTien()));
	}

	public void unselectedTableDsCTHDB() {
		jtbCTHD.clearSelection();
		clearFormCTHDB();
		renderGUIAction();
	}

	public void clearFormCTHDB() {
		jtfMaSP.setText("");
		jtfTenSP.setText("");
		jspnSoLuong.setValue(1);
	}

	public void renderDsCTHDB() {
		String[][] data = hdbmBUS.getDsCTHDB();
		jtbCTHD.setModel(new javax.swing.table.DefaultTableModel(data,
				new String[] { "Mã sản phẩm", "Sản phẩm", "Số lượng", "Tổng tiền" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		revalidate();
	}

	public void renderInforSP() {
		if (jtfMaSP.isFocusOwner() == false) {
			jtfMaSP.setText("");
		}
		if (jtfTenSP.isFocusOwner() == false) {
			jtfTenSP.setText("");
		}
	}

	public void renderInforSP(int row) {
		SanPham selectedSP = hdbmBUS.getSelectedSP(row);
		jtfMaSP.setText(selectedSP.getMaSP());
		jtfTenSP.setText(selectedSP.getTenSP());
		jspnSoLuong.setModel(new javax.swing.SpinnerNumberModel(selectedSP.getSoLuong() == 0 ? 0 : 1, selectedSP.getSoLuong() == 0 ? 0 : 1, selectedSP.getSoLuong(), 1));
	}

	public void renderInforCTHDB(int row) {
		ChiTietHDB selectedCthdb = hdbmBUS.getSelectedCthdb(row);
		jtfMaSP.setText(selectedCthdb.getSanPham().getMaSP());
		jtfTenSP.setText(selectedCthdb.getSanPham().getTenSP());
		jspnSoLuong.setValue(selectedCthdb.getSanPham().getSoLuong());
		SanPham selectedSP = hdbmBUS.getSelectedSP(selectedCthdb.getSanPham().getMaSP());
		jspnSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, selectedSP.getSoLuong(), 1));
	}

	public void renderDsSanPham() {
		String[][] data = hdbmBUS.getDsSanPham();
		jtbDSSP.setModel(new javax.swing.table.DefaultTableModel(data,
				new String[] { "Mã sản phẩm", "Sản phẩm", "Số lượng", "Trạng thái", "Giá Bán" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		revalidate();
	}

	public void renderGUIAction() {
		if (jtbCTHD.getSelectedRow() < 0) {
			jtbDSSP.setEnabled(true);
			// filter when input jtfMaSP, jtfSanPham is open => handle KeyListener its
			jpnFormCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm chi tiết hóa đơn mua"));
			jbtnThem.setVisible(true);
			jbtnSua.setVisible(false);
			jbtnXoa.setVisible(false);
			jbtnHuy.setVisible(false);
		} else {
			jtbDSSP.clearSelection();
			jtbDSSP.setEnabled(false);
			// filter when input jtfMaSP, jtfSanPham is close => handle KeyListener its
			jpnFormCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Hiệu chỉnh tiết hóa đơn mua"));
			jbtnThem.setVisible(false);
			jbtnSua.setVisible(true);
			jbtnXoa.setVisible(true);
			jbtnHuy.setVisible(true);
		}
	}

	public void handleSuaCTHDM(int selectedCTHDMIndex) {
		ChiTietHDB cthdbmoi = getInputDataFromFormCTHD();

		if (cthdbmoi == null) {
			return;
		}

		hdbmBUS.suaCTHDB(selectedCTHDMIndex, cthdbmoi);

		renderHDB();
		renderDsCTHDB();
	}

	public int handleXoaCTHDB(int selectedCTHDMIndex) {
		int gotOption = JOptionPane.showConfirmDialog(this,
				String.format("Xóa sản phẩm \"%s\" khỏi hóa đơn?", jtfTenSP.getText()), "Thông báo xác nhận",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (gotOption == JOptionPane.YES_OPTION) {
			hdbmBUS.xoaCTHDB(selectedCTHDMIndex);
			renderHDB();
			renderDsCTHDB();
		}
		return gotOption;
	}

	public boolean validateRequired(String value, String message, String title, int typeMessage) {
		if ("".equals(value.trim())) {
			JOptionPane.showMessageDialog(this, message, title, typeMessage);
			return false;
		}
		return true;
	}

	public boolean validateSP(SanPham sp) {
		boolean isValid;
		isValid = validateRequired(sp.getMaSP(), "Mã sản phẩm là bắt buộc", "Thêm sản phẩm thất bại",
				JOptionPane.WARNING_MESSAGE);
		if (isValid) {
			isValid = validateRequired(sp.getTenSP(), "Sản phẩm mới cần cung cấp tên sản phẩm",
					"Thêm sản phẩm thất bại", JOptionPane.WARNING_MESSAGE);
		}
		return isValid;
	}

	public boolean checkValidSDT(String sdt) {
		String regex = "^0\\d{9,10}$";// bat dau = 0 va tong cong co 10 so
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sdt);
		return matcher.matches();
	}

}
