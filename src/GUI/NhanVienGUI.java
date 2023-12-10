package GUI;

import DTO.NhanVien;
import DTO.NhomQuyen;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class NhanVienGUI extends javax.swing.JPanel {

    public NhanVienGUI(ArrayList<String> dsHanhDongCuaChucNang) {
        initComponents();
        loadData();//load all data to Jtable
        setEnabledThongTinNVForm(false);//disable textfield ,combobox trong thong tin nhan vien

        jbtnThem.setVisible(false);
		jbtnSua.setVisible(false);
        jbtnXoa.setVisible(false);
		for (String hd : dsHanhDongCuaChucNang) {
			if (hd.toLowerCase().contains("thêm")) {
				jbtnThem.setVisible(true);
			} else if (hd.toLowerCase().contains("sửa")) {
				jbtnSua.setVisible(true);
			} else if (hd.toLowerCase().contains("xóa")) {
                jbtnXoa.setVisible(true);
            }
		}
    }
    //chuyen cac combobox ,jtextfield tim kiem ve gia tri ban dau
    public void clearSearchFilter(){
        jcbNameSearchType.setSelectedIndex(0);
        jtfNameSearch.setText("");
        jcbGioiTinhSearchType.setSelectedIndex(0);
        jcbChucVuSearchType.setSelectedIndex(0);
        jcbStatusSearchType.setSelectedIndex(0);
    }
    //chuyen sang trang thai mac dinh
    public void changeToNormalState() {
        clearThongTinNVForm();
        setEnabledThongTinNVForm(false);
        JTableNV.setEnabled(true);
        jbtnXacNhan.setVisible(false);
        jbtnLamMoi.setVisible(false);
        jbtnHuy.setVisible(false);
        jbtnThem.setEnabled(true);
        JTableNV.clearSelection();
        jbtnSua.setEnabled(false);
        jbtnXoa.setEnabled(false);
        jpnFormNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
    }

    //lam moi cac textfield ,jcombobox trong phan thong tin nhan vien
    public void clearThongTinNVForm() {
        jtfHoTen.setText("");
        jcbGioiTinh.setSelectedIndex(0);
        jdatechooser.setCalendar(null);
        jtfSdt.setText("");
        jtfEmail.setText("");
        jtfDiaChi.setText("");
        jcbChucVu.setSelectedIndex(0);
        jcbTrangThai.setSelectedIndex(0);
    }

    //enable text field ,jcombobox trong phan thong tin nhan vien
    public void setEnabledThongTinNVForm(boolean condition) {
        jtfHoTen.setEnabled(condition);
        jcbGioiTinh.setEnabled(condition);
        jdatechooser.setEnabled(condition);
        jtfSdt.setEnabled(condition);
        jtfDiaChi.setEnabled(condition);
        jcbChucVu.setEnabled(condition);
        jtfEmail.setEnabled(condition);
        jcbTrangThai.setEnabled(condition);
    }

    //load 1 nhan vien tu 1 dong cua jtable va hien len textfield ,combobox trong phan thong tin nhan_vien
    public void loadToForm(int row) {
        DefaultTableModel tablemodel = (DefaultTableModel) JTableNV.getModel();
        int id = Integer.parseInt(tablemodel.getValueAt(row, 0).toString());
        DTO.NhanVien dto = BUS.NhanVienBUS.getInstance().getNhanVienByID(id);
        if (dto != null) {
            jtfHoTen.setText(dto.getTenNhanVien());
            jcbGioiTinh.setSelectedIndex(dto.getGioiTinh() + 1);
            jdatechooser.setDate(Date.from(dto.getNgaySinh().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            jtfSdt.setText(dto.getSdt());
            jtfEmail.setText(dto.getEmail());
            jtfDiaChi.setText(dto.getDiaChi());
            jcbChucVu.setSelectedItem(dto.getChucVu().getTenNhomQuyen());
            jcbTrangThai.setSelectedItem(dto.getTrangThaiText());
        }
        jbtnSua.setEnabled(true);
        jbtnXoa.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jbtnThem = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jcbNameSearchType = new javax.swing.JComboBox<>();
        jtfNameSearch = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jlbGioiTinhSearch = new javax.swing.JLabel();
        jcbGioiTinhSearchType = new javax.swing.JComboBox<>();
        jlbChucVuSearch = new javax.swing.JLabel();
        jcbChucVuSearchType = new javax.swing.JComboBox<>();
        jlbStatusSearch = new javax.swing.JLabel();
        jcbStatusSearchType = new javax.swing.JComboBox<>();
        jpnFormNV = new javax.swing.JPanel();
        jlbHoTen = new javax.swing.JLabel();
        jtfHoTen = new javax.swing.JTextField();
        jlbGioiTinh = new javax.swing.JLabel();
        jcbGioiTinh = new javax.swing.JComboBox<>();
        jlbNgaySinh = new javax.swing.JLabel();
        jlbSdt = new javax.swing.JLabel();
        jtfSdt = new javax.swing.JTextField();
        jlbEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jlbDiaChi = new javax.swing.JLabel();
        jtfDiaChi = new javax.swing.JTextField();
        jlbChucVu = new javax.swing.JLabel();
        jcbChucVu = new javax.swing.JComboBox<>();
        jlbTrangThai = new javax.swing.JLabel();
        jcbTrangThai = new javax.swing.JComboBox<>();
        jbtnXacNhan = new javax.swing.JButton();
        jbtnHuy = new javax.swing.JButton();
        jbtnLamMoi = new javax.swing.JButton();
        jdatechooser = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jScrollPaneNV = new javax.swing.JScrollPane();
        JTableNV = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jbtnThem.setText("Thêm");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jbtnSua.setText("Sửa");
        jbtnSua.setEnabled(false);
        jbtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuaActionPerformed(evt);
            }
        });

        jbtnXoa.setText("Xóa");
        jbtnXoa.setEnabled(false);
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        jcbNameSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã", "Họ tên", "Email", "Số điện thoại", "Địa chỉ" }));

        jbtnSearch.setText("Tìm kiếm");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        jlbGioiTinhSearch.setText("Giới tính");

        jcbGioiTinhSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nữ", "Nam" }));

        jlbChucVuSearch.setText("Chức vụ");

        jcbChucVuSearchType.addItem("Tất cả");
        for(String item:BUS.NhanVienBUS.getInstance().getAllNameChucVu())
        jcbChucVuSearchType.addItem(item);

        jlbStatusSearch.setText("Trạng thái");

        jcbStatusSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã nghỉ việc", "Đang làm việc" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnXoa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbNameSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSearch)
                        .addGap(70, 70, 70)
                        .addComponent(jlbGioiTinhSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbGioiTinhSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jlbChucVuSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbChucVuSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addComponent(jlbStatusSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbStatusSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThem)
                    .addComponent(jbtnSua)
                    .addComponent(jbtnXoa))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbStatusSearch)
                        .addComponent(jcbStatusSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnSearch)
                        .addComponent(jlbGioiTinhSearch)
                        .addComponent(jcbGioiTinhSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbChucVuSearch)
                        .addComponent(jcbChucVuSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbNameSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jpnFormNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
        jpnFormNV.setPreferredSize(new java.awt.Dimension(1247, 200));

        jlbHoTen.setText("Họ tên");

        jlbGioiTinh.setText("Giới tính");

        jcbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Nữ", "Nam" }));

        jlbNgaySinh.setText("Ngày sinh");

        jlbSdt.setText("Số điện thoại");

        jlbEmail.setText("Email");

        jlbDiaChi.setText("Địa chỉ");

        jlbChucVu.setText("Chức vụ");

        jcbChucVu.addItem("");
        for(String item:BUS.NhanVienBUS.getInstance().getAllNameChucVu()) {
            jcbChucVu.addItem(item);
        }

        jlbTrangThai.setText("Trạng thái");

        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Đã nghỉ việc", "Đang làm việc" }));

        jbtnXacNhan.setText("Xác nhận");
        jbtnXacNhan.setVisible(false);
        jbtnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXacNhanActionPerformed(evt);
            }
        });

        jbtnHuy.setText("Hủy");
        jbtnHuy.setVisible(false);
        jbtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHuyActionPerformed(evt);
            }
        });

        jbtnLamMoi.setText("Làm mới");
        jbtnLamMoi.setVisible(false);
        jbtnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLamMoiActionPerformed(evt);
            }
        });

        jdatechooser.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jpnFormNVLayout = new javax.swing.GroupLayout(jpnFormNV);
        jpnFormNV.setLayout(jpnFormNVLayout);
        jpnFormNVLayout.setHorizontalGroup(
            jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFormNVLayout.createSequentialGroup()
                        .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbGioiTinh)
                            .addComponent(jlbHoTen))
                        .addGap(18, 18, 18)
                        .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnFormNVLayout.createSequentialGroup()
                        .addComponent(jlbNgaySinh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbSdt)
                    .addComponent(jlbEmail)
                    .addComponent(jlbDiaChi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnFormNVLayout.createSequentialGroup()
                        .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFormNVLayout.createSequentialGroup()
                                .addComponent(jlbChucVu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jlbTrangThai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnFormNVLayout.createSequentialGroup()
                                .addComponent(jbtnXacNhan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnLamMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnHuy)))))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jpnFormNVLayout.setVerticalGroup(
            jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbHoTen)
                    .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbSdt)
                    .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbChucVu)
                    .addComponent(jcbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTrangThai)
                    .addComponent(jcbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGioiTinh)
                    .addComponent(jcbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbNgaySinh)
                        .addComponent(jlbDiaChi)
                        .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnXacNhan)
                        .addComponent(jbtnHuy)
                        .addComponent(jbtnLamMoi))
                    .addComponent(jdatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        add(jpnFormNV, java.awt.BorderLayout.PAGE_END);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));
        jPanel7.setPreferredSize(new java.awt.Dimension(462, 395));
        jPanel7.setLayout(new java.awt.BorderLayout());

        javax.swing.table.DefaultTableModel TableModelNV = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTableNV.setModel(TableModelNV);
        Object[] columns = new Object[]{"Mã NV","Họ tên","Giới tính","Ngày sinh","Số điện thoại","Email","Địa chỉ","Chức vụ","Trạng thái"};
        TableModelNV.setColumnIdentifiers(columns);
        JTableNV.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumnModel columnmodel = JTableNV.getColumnModel();
        columnmodel.getColumn(0).setMaxWidth(80);
        columnmodel.getColumn(0).setMinWidth(80);
        columnmodel.getColumn(2).setMinWidth(60);
        columnmodel.getColumn(2).setMaxWidth(60);
        columnmodel.getColumn(3).setMinWidth(90);
        columnmodel.getColumn(3).setMaxWidth(90);
        columnmodel.getColumn(4).setMinWidth(100);
        columnmodel.getColumn(4).setMaxWidth(100);
        columnmodel.getColumn(7).setMinWidth(80);
        columnmodel.getColumn(7).setMaxWidth(80);
        columnmodel.getColumn(8).setMinWidth(100);
        columnmodel.getColumn(8).setMaxWidth(100);
        JTableNV.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                int row =JTableNV.getSelectedRow();
                if(row != -1)loadToForm(row);

            }
        });
        jScrollPaneNV.setViewportView(JTableNV);

        jPanel7.add(jScrollPaneNV, java.awt.BorderLayout.CENTER);

        add(jPanel7, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLamMoiActionPerformed
        clearThongTinNVForm();
    }//GEN-LAST:event_jbtnLamMoiActionPerformed

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        clearThongTinNVForm();
        setEnabledThongTinNVForm(true);
        JTableNV.clearSelection();
        JTableNV.setEnabled(false);
        jbtnXacNhan.setVisible(true);
        jbtnLamMoi.setVisible(true);
        jbtnHuy.setVisible(true);
        jbtnSua.setEnabled(false);
        jbtnXoa.setEnabled(false);
        jbtnThem.setEnabled(false);
        jpnFormNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm thông tin nhân viên"));
    }//GEN-LAST:event_jbtnThemActionPerformed
    //kiem tra da dien day du thong tin chua ,neu chua return 0 ,neu co return 1
    public boolean checkFormFilled() {
        return (!jtfHoTen.getText().isBlank()
                && jcbGioiTinh.getSelectedIndex() != 0
                && jdatechooser.getDate() != null
                && !jtfSdt.getText().isBlank()
                && !jtfEmail.getText().isBlank()
                && !jtfDiaChi.getText().isBlank()
                && jcbChucVu.getSelectedIndex() != 0
                && jcbTrangThai.getSelectedIndex() != 0)
                ? true : false;
    }

    //kiem tra sdt co hop le ko ,neu co tra ve 1 ,ko tra ve 0
    public boolean checkValidSDT(String sdt) {
        String regex = "^0\\d{9,10}$";//bat dau = 0 va tong cong co 10 so
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sdt);
        return matcher.matches();
    }

    //kiem tra email co hop le ko ,neu co tra ve 1 ,ko tra ve 0 format:"something@something"
    public boolean checkValidEmail(String email) {
        return Pattern.compile("^(.+)@(\\S+)$")
                .matcher(email)
                .matches();
    }

    //kiem tra co trung sdt voi nhan vien khac ,neu co tra ve 1 ,ko tra ve 0
    public boolean checkDuplicateSDT(String sdt, String manv) {
        return BUS.NhanVienBUS.getInstance().checkDuplicateSdt(sdt, manv);
    }

    //kiem tra co trung email voi nhan vien khac ,neu co tra ve 1 ,ko tra ve 0
    public boolean checkDuplicateEmail(String email, String manv) {
        return BUS.NhanVienBUS.getInstance().checkDuplicateEmail(email, manv);
    }
    private void jbtnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXacNhanActionPerformed
        // kiem tra da day du thong tin chua
        if (!checkFormFilled()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
            return;
        }
        if (JTableNV.getSelectionModel().isSelectionEmpty()) {//neu la trang thai Them tai khoan
            if (!checkValidSDT(jtfSdt.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                return;
            }
            if (!checkValidEmail(jtfEmail.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ");
                return;
            }
            if (checkDuplicateSDT(jtfSdt.getText().trim(), "")) {
                JOptionPane.showMessageDialog(null, "Đã có nhân viên sử dụng số điện thoại này");
                return;
            }
            if (checkDuplicateEmail(jtfEmail.getText().trim(), "")) {
                JOptionPane.showMessageDialog(null, "Đã có nhân viên sử dụng email này");
                return;
            }
            String hoten = jtfHoTen.getText().trim();
            int gioitinh = jcbGioiTinh.getSelectedIndex() - 1;
            LocalDate ngaysinh = jdatechooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String sdt = jtfSdt.getText().trim();
            String email = jtfEmail.getText().trim();
            String diachi = jtfDiaChi.getText().trim();
            NhomQuyen chucvu = new NhomQuyen("", jcbChucVu.getSelectedItem().toString());
            int trangthai = jcbTrangThai.getSelectedIndex() - 1;
            DTO.NhanVien dto = new DTO.NhanVien(0, hoten, gioitinh, ngaysinh, sdt, email, diachi, chucvu, trangthai);
            //them tai khoan
            if (!BUS.NhanVienBUS.getInstance().addNhanVien(dto)) {
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại");
            } else {//neu thanh cong them tai khoan,chuyen sang mac dinh
                loadData();
                changeToNormalState();
                clearSearchFilter();
            }
        } else {//neu la trang thai Sua Tai khoan
            if (!checkValidSDT(jtfSdt.getText())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                return;
            }
            if (!checkValidEmail(jtfEmail.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ");
                return;
            }
            if (checkDuplicateSDT(jtfSdt.getText().trim(), JTableNV.getValueAt(JTableNV.getSelectedRow(), 0).toString())) {
                JOptionPane.showMessageDialog(null, "Đã có nhân viên sử dụng số điện thoại này");
                return;
            }
            if (checkDuplicateEmail(jtfEmail.getText().trim(), JTableNV.getValueAt(JTableNV.getSelectedRow(), 0).toString())) {
                JOptionPane.showMessageDialog(null, "Đã có nhân viên sử dụng email này");
                return;
            }
            int manhanvien = Integer.parseInt(JTableNV.getValueAt(JTableNV.getSelectedRow(), 0).toString());
            String hoten = jtfHoTen.getText().trim();
            int gioitinh = jcbGioiTinh.getSelectedIndex() - 1;
            LocalDate ngaysinh = jdatechooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String sdt = jtfSdt.getText().trim();
            String email = jtfEmail.getText().trim();
            String diachi = jtfDiaChi.getText().trim();
            NhomQuyen chucvu = new NhomQuyen("", jcbChucVu.getSelectedItem().toString());
            int trangthai = jcbTrangThai.getSelectedIndex() - 1;
            //neu thay doi ma quyen ,thong bao "ban co chac muon thay doi ma quyen,yes thi tiep tuc ,no thi thoat"
            if (BUS.NhanVienBUS.getInstance().checkMaQuyenThayDoi("" + manhanvien, jcbChucVu.getSelectedItem().toString())) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Sửa chức vụ sẽ ảnh hưởng đến quyền của tài khoản tương ứng. Tiếp tục?", "Sửa nhóm quyền", JOptionPane.YES_NO_OPTION);
                if (dialogResult == 1) {
                    return;
                }
            }
            DTO.NhanVien dto = new DTO.NhanVien(manhanvien, hoten, gioitinh, ngaysinh, sdt, email, diachi, chucvu, trangthai);
            //bat dau edit nhan vien
            if (!BUS.NhanVienBUS.getInstance().editNhanVien(dto)) {//neu sua that bai
                JOptionPane.showMessageDialog(null, "Sửa nhân viên thất bại");
            } else {//neu thanh cong sua tai khoan,chuyen sang mac dinh
                loadData();
                changeToNormalState();
                clearSearchFilter();
            }
        }
    }//GEN-LAST:event_jbtnXacNhanActionPerformed

    private void jbtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHuyActionPerformed
        changeToNormalState();
    }//GEN-LAST:event_jbtnHuyActionPerformed

    private void jbtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuaActionPerformed
        setEnabledThongTinNVForm(true);
        jbtnXacNhan.setVisible(true);
        jbtnHuy.setVisible(true);
        jbtnThem.setEnabled(false);
        jbtnXoa.setEnabled(false);
        jbtnSua.setEnabled(false);
        JTableNV.setEnabled(false);
        jpnFormNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Sửa thông tin nhân viên"));
    }//GEN-LAST:event_jbtnSuaActionPerformed

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        String manv = JTableNV.getValueAt(JTableNV.getSelectedRow(), 0).toString();
        NhanVien nv = BUS.NhanVienBUS.getInstance().getNhanVienByID(Integer.parseInt(manv));
        if (nv != null && nv.getChucVu().getMaNhomQuyen().equals("QL")) {
            JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên có chức vụ quản lí", "Xóa nhân viên", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhân viên", "Xóa nhân viên", JOptionPane.YES_NO_OPTION);
        if (dialogResult == 0) {
            if (!BUS.NhanVienBUS.getInstance().deleteNhanVien(manv)) {
                JOptionPane.showMessageDialog(null, "Xóa nhân viên thất bại");
            } else {
                loadData();
                changeToNormalState();
                clearSearchFilter();
            }
        }
    }//GEN-LAST:event_jbtnXoaActionPerformed

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        ((DefaultTableModel) (JTableNV.getModel())).setRowCount(0);
        for (DTO.NhanVien dto : BUS.NhanVienBUS.getInstance().search(jcbNameSearchType.getSelectedIndex(), jtfNameSearch.getText().trim(), jcbGioiTinhSearchType.getSelectedIndex(), jcbChucVuSearchType.getSelectedItem().toString(), jcbStatusSearchType.getSelectedIndex())) {
            ((DefaultTableModel) (JTableNV.getModel())).addRow(new Object[]{
                dto.getMaNhanVien(),
                dto.getTenNhanVien(),
                dto.getGioiTinhText(),
                dto.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                dto.getSdt(),
                dto.getEmail(),
                dto.getDiaChi(),
                dto.getChucVu().getTenNhomQuyen(),
                dto.getTrangThaiText()});
        }
        changeToNormalState();
    }//GEN-LAST:event_jbtnSearchActionPerformed
    //load all data from nhan_vien to JTable
    public void loadData() {
        DefaultTableModel tablemodel = ((DefaultTableModel) JTableNV.getModel());
        tablemodel.setRowCount(0);
        for (DTO.NhanVien dto : BUS.NhanVienBUS.getInstance().getAll()) {
            tablemodel.addRow(new Object[]{
                dto.getMaNhanVien(),
                dto.getTenNhanVien(),
                dto.getGioiTinhText(),
                dto.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                dto.getSdt(),
                dto.getEmail(),
                dto.getDiaChi(),
                dto.getChucVu().getTenNhomQuyen(),
                dto.getTrangThaiText()
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableNV;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPaneNV;
    private javax.swing.JButton jbtnHuy;
    private javax.swing.JButton jbtnLamMoi;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXacNhan;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JComboBox<String> jcbChucVu;
    private javax.swing.JComboBox<String> jcbChucVuSearchType;
    private javax.swing.JComboBox<String> jcbGioiTinh;
    private javax.swing.JComboBox<String> jcbGioiTinhSearchType;
    private javax.swing.JComboBox<String> jcbNameSearchType;
    private javax.swing.JComboBox<String> jcbStatusSearchType;
    private javax.swing.JComboBox<String> jcbTrangThai;
    private com.toedter.calendar.JDateChooser jdatechooser;
    private javax.swing.JLabel jlbChucVu;
    private javax.swing.JLabel jlbChucVuSearch;
    private javax.swing.JLabel jlbDiaChi;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbGioiTinh;
    private javax.swing.JLabel jlbGioiTinhSearch;
    private javax.swing.JLabel jlbHoTen;
    private javax.swing.JLabel jlbNgaySinh;
    private javax.swing.JLabel jlbSdt;
    private javax.swing.JLabel jlbStatusSearch;
    private javax.swing.JLabel jlbTrangThai;
    private javax.swing.JPanel jpnFormNV;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfNameSearch;
    private javax.swing.JTextField jtfSdt;
    // End of variables declaration//GEN-END:variables
}
