/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author BomPC
 */
public class NhanVienGUI extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienView
     */
    public NhanVienGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jtfNgaySinh = new javax.swing.JTextField();
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
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbDSNV = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jbtnThem.setText("Thêm");

        jbtnSua.setText("Sửa");

        jbtnXoa.setText("Xóa");

        jcbNameSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã", "Họ tên", "Email", "Số điện thoại", "Địa chỉ" }));

        jbtnSearch.setText("Tìm kiếm");

        jlbGioiTinhSearch.setText("Giới tính");

        jcbGioiTinhSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));

        jlbChucVuSearch.setText("Chức vụ");

        jcbChucVuSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Admin", "Nhân viên bán hàng" }));

        jlbStatusSearch.setText("Trạng thái");

        jcbStatusSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang làm việc", "Đã nghỉ việc" }));

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
                .addContainerGap(175, Short.MAX_VALUE))
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
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jpnFormNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
        jpnFormNV.setPreferredSize(new java.awt.Dimension(1247, 200));

        jlbHoTen.setText("Họ tên");

        jlbGioiTinh.setText("Giới tính");

        jcbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jcbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGioiTinhActionPerformed(evt);
            }
        });

        jlbNgaySinh.setText("Ngày sinh");

        jlbSdt.setText("Số điện thoại");

        jlbEmail.setText("Email");

        jlbDiaChi.setText("Địa chỉ");

        jlbChucVu.setText("Chức vụ");

        jcbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lí", "Admin", "Nhân viên bán hàng" }));

        jlbTrangThai.setText("Trạng thái");

        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Đã nghỉ việc" }));

        jbtnXacNhan.setText("Xác nhận");

        jbtnHuy.setText("Hủy");

        jbtnLamMoi.setText("Làm mới");
        jbtnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLamMoiActionPerformed(evt);
            }
        });

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
                        .addComponent(jtfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
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
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jpnFormNVLayout.setVerticalGroup(
            jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormNVLayout.createSequentialGroup()
                .addGap(20, 20, 20)
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
                .addGroup(jpnFormNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNgaySinh)
                    .addComponent(jtfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDiaChi)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnXacNhan)
                    .addComponent(jbtnHuy)
                    .addComponent(jbtnLamMoi))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        add(jpnFormNV, java.awt.BorderLayout.PAGE_END);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));
        jPanel7.setPreferredSize(new java.awt.Dimension(462, 395));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jtbDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email", "Địa chỉ", "Chức vụ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbDSNV);
        if (jtbDSNV.getColumnModel().getColumnCount() > 0) {
            jtbDSNV.getColumnModel().getColumn(0).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(1).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(2).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(3).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(4).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(5).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(6).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(7).setResizable(false);
            jtbDSNV.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel7, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGioiTinhActionPerformed

    private void jbtnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTable jtbDSNV;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfNameSearch;
    private javax.swing.JTextField jtfNgaySinh;
    private javax.swing.JTextField jtfSdt;
    // End of variables declaration//GEN-END:variables
}
