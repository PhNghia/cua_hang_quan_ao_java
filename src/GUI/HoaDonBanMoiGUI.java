/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author BomPC
 */
public class HoaDonBanMoiGUI extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonBanMoiView
     */
    public HoaDonBanMoiGUI() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jlbMaHDTitle = new javax.swing.JLabel();
        jlbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbtnThoat = new javax.swing.JButton();
        jbtnXacNhan = new javax.swing.JButton();
        jbtnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlbTongTienTitle = new javax.swing.JLabel();
        jlbTongTienNumber = new javax.swing.JLabel();
        jlbTongTienCurency = new javax.swing.JLabel();
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
        jTable2 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
        jPanel2Layout.columnWidths = new int[] {0, 20, 0, 20, 0, 20, 0, 20, 0};
        jPanel2Layout.rowHeights = new int[] {0, 0, 0};
        jPanel2.setLayout(jPanel2Layout);

        jbtnThoat.setText("Thoát");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jbtnThoat, gridBagConstraints);

        jbtnXacNhan.setText("Xác nhận");
        jbtnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXacNhanActionPerformed(evt);
            }
        });
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

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Hiệu chỉnh chi tiết hóa đơn"));
        jPanel9.setPreferredSize(new java.awt.Dimension(1282, 200));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(490, 140));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel7.setPreferredSize(new java.awt.Dimension(490, 46));

        jlbTongTienTitle.setText("Tổng tiền hóa đơn:");

        jlbTongTienNumber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbTongTienNumber.setForeground(new java.awt.Color(255, 0, 0));
        jlbTongTienNumber.setText("100.000");

        jlbTongTienCurency.setText("VND");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTongTienTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTongTienNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTongTienCurency)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTongTienTitle)
                    .addComponent(jlbTongTienNumber)
                    .addComponent(jlbTongTienCurency))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tích điểm cho khách hàng"));

        jlbSdt.setText("Số điện thoại");

        jtfSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSdtActionPerformed(evt);
            }
        });

        jbtnSearch.setText("Tìm kiếm");

        jlbKetQuaTim.setText("Nguyễn Văn A - Điểm 0 = Tiền 0 / Không tìm thấy khách hàng");

        jlbTieuDiem.setText("Tiêu điểm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbKetQuaTim, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlbSdt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSearch))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlbTieuDiem)
                        .addGap(26, 26, 26)
                        .addComponent(jtfTieuDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSdt)
                    .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbKetQuaTim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTieuDiem)
                    .addComponent(jtfTieuDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel6, java.awt.BorderLayout.LINE_END);

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
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMaSP)
                    .addComponent(jlbTenSP)
                    .addComponent(jlbSoLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jspnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(jbtnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnHuy))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfMaSP)
                        .addComponent(jtfTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaSP)
                    .addComponent(jtfMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTenSP)
                    .addComponent(jtfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSoLuong)
                    .addComponent(jspnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnThem)
                    .addComponent(jbtnSua)
                    .addComponent(jbtnXoa)
                    .addComponent(jbtnHuy))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
        jPanel10.setPreferredSize(new java.awt.Dimension(500, 471));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Sản phẩm", "Số lượng", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel10, java.awt.BorderLayout.LINE_END);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Sản phẩm", "Giá bán", "Giảm giá", "Hiện có"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel11, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnXacNhanActionPerformed

    private void jtfSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSdtActionPerformed


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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
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
    private javax.swing.JLabel jlbTongTienCurency;
    private javax.swing.JLabel jlbTongTienNumber;
    private javax.swing.JLabel jlbTongTienTitle;
    private javax.swing.JSpinner jspnSoLuong;
    private javax.swing.JTextField jtfMaSP;
    private javax.swing.JTextField jtfSdt;
    private javax.swing.JTextField jtfTenSP;
    private javax.swing.JTextField jtfTieuDiem;
    // End of variables declaration//GEN-END:variables
}
