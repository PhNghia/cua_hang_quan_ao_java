/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import javax.swing.JCheckBox;

/**
 *
 * @author BomPC
 */
public class SanPhamGUI extends javax.swing.JPanel {

    /**
     * Creates new form SanPhamView
     */
    public SanPhamGUI() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDSSP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlbMaSPCT = new javax.swing.JLabel();
        jlbChatLieuCT = new javax.swing.JLabel();
        jlbMauSacCT = new javax.swing.JLabel();
        jlbKichCoCT = new javax.swing.JLabel();
        jlbGiaNhapCT = new javax.swing.JLabel();
        jlbGiaBanCT = new javax.swing.JLabel();
        jlbSoLuongCT = new javax.swing.JLabel();
        jlbTrangThaiCT = new javax.swing.JLabel();
        jlbImageCT = new javax.swing.JLabel();
        jlbSanPhamCT = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jbtnThem = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jcbNameSearchType = new javax.swing.JComboBox<>();
        jtfNameSearch = new javax.swing.JTextField();
        jlbChatLieuSearch = new javax.swing.JLabel();
        jtfChatLieuSearch = new javax.swing.JTextField();
        jlbKichCoSearch = new javax.swing.JLabel();
        jcbKickCoSearch = new javax.swing.JComboBox<>();
        jlbStatusSearch = new javax.swing.JLabel();
        jcbStatusSearch = new javax.swing.JComboBox<>();
        jbtnSearch = new javax.swing.JButton();
        jlbMauSacSearch = new javax.swing.JLabel();
        jtfMauSacSearch = new javax.swing.JTextField();
        jpnFormSP = new javax.swing.JPanel();
        jlbMa = new javax.swing.JLabel();
        jtfMa = new javax.swing.JTextField();
        jlbChatLieu = new javax.swing.JLabel();
        jtfChatLieu = new javax.swing.JTextField();
        jlbGiaNhap = new javax.swing.JLabel();
        jtfGiaNhap = new javax.swing.JTextField();
        jlbSoLuong = new javax.swing.JLabel();
        jtfSoLuong = new javax.swing.JTextField();
        jlbSanPham = new javax.swing.JLabel();
        jtfSanPham = new javax.swing.JTextField();
        jlbMauSac = new javax.swing.JLabel();
        jtfMauSac = new javax.swing.JTextField();
        jlbGiaBan = new javax.swing.JLabel();
        jtfGiaBan = new javax.swing.JTextField();
        jlbStatus = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();
        jlbHinhAnh = new javax.swing.JLabel();
        jtfHinhAnh = new javax.swing.JTextField();
        jlbKichCo = new javax.swing.JLabel();
        jcbKichCo = new javax.swing.JComboBox<>();
        jbtnXacNhan = new javax.swing.JButton();
        jbtnHuy = new javax.swing.JButton();
        jbtnLamMoi = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jtbDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Sản phẩm", "Giá nhập", "Giá bán", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbDSSP);
        if (jtbDSSP.getColumnModel().getColumnCount() > 0) {
            jtbDSSP.getColumnModel().getColumn(0).setResizable(false);
            jtbDSSP.getColumnModel().getColumn(1).setResizable(false);
            jtbDSSP.getColumnModel().getColumn(2).setResizable(false);
            jtbDSSP.getColumnModel().getColumn(3).setResizable(false);
            jtbDSSP.getColumnModel().getColumn(4).setResizable(false);
            jtbDSSP.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setPreferredSize(new java.awt.Dimension(380, 427));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHI TIẾT SẢN PHẨM");
        jLabel2.setPreferredSize(new java.awt.Dimension(108, 24));
        jPanel3.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlbMaSPCT.setText("Mã sản phẩm:");

        jlbChatLieuCT.setText("Chất liệu:");

        jlbMauSacCT.setText("Màu sắc:");

        jlbKichCoCT.setText("Kích cỡ:");

        jlbGiaNhapCT.setText("Giá nhập:");

        jlbGiaBanCT.setText("Giá bán:");

        jlbSoLuongCT.setText("Số lượng:");

        jlbTrangThaiCT.setText("Trạng thái:");

        jlbImageCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/362262966_1023992471955085_8868555814812732925_n.jpg"))); // NOI18N
        jlbImageCT.setOpaque(true);
        jlbImageCT.setPreferredSize(new java.awt.Dimension(200, 220));

        jlbSanPhamCT.setText("Sản phẩm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMauSacCT)
                            .addComponent(jlbGiaNhapCT)
                            .addComponent(jlbSoLuongCT))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbGiaBanCT)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbTrangThaiCT)
                                    .addComponent(jlbKichCoCT))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 99, Short.MAX_VALUE)
                        .addComponent(jlbImageCT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMaSPCT)
                            .addComponent(jlbChatLieuCT)
                            .addComponent(jlbSanPhamCT))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlbImageCT, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbMaSPCT)
                .addGap(18, 18, 18)
                .addComponent(jlbSanPhamCT)
                .addGap(57, 57, 57)
                .addComponent(jlbChatLieuCT)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMauSacCT)
                    .addComponent(jlbKichCoCT))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGiaNhapCT)
                    .addComponent(jlbGiaBanCT))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSoLuongCT)
                    .addComponent(jlbTrangThaiCT))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_END);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jbtnThem.setText("Thêm");

        jbtnSua.setText("Sửa");

        jbtnXoa.setText("Xóa");

        jcbNameSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã", "Sản phẩm" }));

        jlbChatLieuSearch.setText("Chất liệu");

        jlbKichCoSearch.setText("Kích cỡ");

        jcbKickCoSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlbStatusSearch.setText("Trạng thái");

        jcbStatusSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnSearch.setText("Tìm kiếm");

        jlbMauSacSearch.setText("Màu sắc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jbtnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnXoa))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jcbNameSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSearch))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMauSacSearch)
                            .addComponent(jlbChatLieuSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jtfChatLieuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jlbKichCoSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbKickCoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jlbStatusSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbStatusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfMauSacSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThem)
                    .addComponent(jbtnSua)
                    .addComponent(jbtnXoa))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbNameSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbChatLieuSearch)
                    .addComponent(jtfChatLieuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbKichCoSearch)
                    .addComponent(jcbKickCoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbStatusSearch)
                    .addComponent(jcbStatusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMauSacSearch)
                    .addComponent(jtfMauSacSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSearch))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jpnFormSP.setBackground(new java.awt.Color(255, 255, 255));
        jpnFormSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        jpnFormSP.setPreferredSize(new java.awt.Dimension(1004, 200));

        jlbMa.setText("Mã");

        jlbChatLieu.setText("Chất liệu");

        jtfChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfChatLieuActionPerformed(evt);
            }
        });

        jlbGiaNhap.setText("Giá nhập");

        jlbSoLuong.setText("Số lượng");

        jlbSanPham.setText("Sản phẩm");

        jlbMauSac.setText("Màu sắc");

        jlbGiaBan.setText("Giá bán");

        jlbStatus.setText("Trạng thái");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlbHinhAnh.setText("Hình ảnh");

        jlbKichCo.setText("Kích cỡ");

        jcbKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnXacNhan.setText("Xác nhận");

        jbtnHuy.setText("Hủy");

        jbtnLamMoi.setText("Làm mới");

        javax.swing.GroupLayout jpnFormSPLayout = new javax.swing.GroupLayout(jpnFormSP);
        jpnFormSP.setLayout(jpnFormSPLayout);
        jpnFormSPLayout.setHorizontalGroup(
            jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormSPLayout.createSequentialGroup()
                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFormSPLayout.createSequentialGroup()
                        .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbSanPham)
                            .addGroup(jpnFormSPLayout.createSequentialGroup()
                                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbHinhAnh)
                                    .addComponent(jlbMa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpnFormSPLayout.createSequentialGroup()
                                        .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfMa, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(74, 74, 74)
                                        .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlbChatLieu)
                                            .addComponent(jlbMauSac))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jtfMauSac)))
                                    .addComponent(jtfHinhAnh))
                                .addGap(74, 74, 74)
                                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbKichCo)
                                    .addComponent(jlbGiaBan)
                                    .addComponent(jlbGiaNhap))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFormSPLayout.createSequentialGroup()
                                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jtfGiaBan))
                                .addGap(74, 74, 74)
                                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jcbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnFormSPLayout.createSequentialGroup()
                        .addComponent(jbtnXacNhan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnHuy)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jpnFormSPLayout.setVerticalGroup(
            jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMa)
                    .addComponent(jtfMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbChatLieu)
                    .addComponent(jtfChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbGiaNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSanPham)
                    .addComponent(jtfSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbMauSac)
                    .addComponent(jtfMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbGiaBan)
                    .addComponent(jtfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbSoLuong)
                    .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbHinhAnh)
                    .addComponent(jtfHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbKichCo)
                    .addComponent(jcbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbStatus)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFormSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnXacNhan)
                    .addComponent(jbtnHuy)
                    .addComponent(jbtnLamMoi))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        add(jpnFormSP, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfChatLieuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnHuy;
    private javax.swing.JButton jbtnLamMoi;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXacNhan;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JComboBox<String> jcbKichCo;
    private javax.swing.JComboBox<String> jcbKickCoSearch;
    private javax.swing.JComboBox<String> jcbNameSearchType;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JComboBox<String> jcbStatusSearch;
    private javax.swing.JLabel jlbChatLieu;
    private javax.swing.JLabel jlbChatLieuCT;
    private javax.swing.JLabel jlbChatLieuSearch;
    private javax.swing.JLabel jlbGiaBan;
    private javax.swing.JLabel jlbGiaBanCT;
    private javax.swing.JLabel jlbGiaNhap;
    private javax.swing.JLabel jlbGiaNhapCT;
    private javax.swing.JLabel jlbHinhAnh;
    private javax.swing.JLabel jlbImageCT;
    private javax.swing.JLabel jlbKichCo;
    private javax.swing.JLabel jlbKichCoCT;
    private javax.swing.JLabel jlbKichCoSearch;
    private javax.swing.JLabel jlbMa;
    private javax.swing.JLabel jlbMaSPCT;
    private javax.swing.JLabel jlbMauSac;
    private javax.swing.JLabel jlbMauSacCT;
    private javax.swing.JLabel jlbMauSacSearch;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JLabel jlbSanPhamCT;
    private javax.swing.JLabel jlbSoLuong;
    private javax.swing.JLabel jlbSoLuongCT;
    private javax.swing.JLabel jlbStatus;
    private javax.swing.JLabel jlbStatusSearch;
    private javax.swing.JLabel jlbTrangThaiCT;
    private javax.swing.JPanel jpnFormSP;
    private javax.swing.JTable jtbDSSP;
    private javax.swing.JTextField jtfChatLieu;
    private javax.swing.JTextField jtfChatLieuSearch;
    private javax.swing.JTextField jtfGiaBan;
    private javax.swing.JTextField jtfGiaNhap;
    private javax.swing.JTextField jtfHinhAnh;
    private javax.swing.JTextField jtfMa;
    private javax.swing.JTextField jtfMauSac;
    private javax.swing.JTextField jtfMauSacSearch;
    private javax.swing.JTextField jtfNameSearch;
    private javax.swing.JTextField jtfSanPham;
    private javax.swing.JTextField jtfSoLuong;
    // End of variables declaration//GEN-END:variables
}
