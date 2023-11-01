package GUI;

import DTO.KhachHang;
import BUS.KhachHangBUS;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhachHangGUI extends javax.swing.JPanel {

    private List<KhachHang> khachhang;
    private List<KhachHang> them = new ArrayList<>();
    private List<KhachHang> sua = new ArrayList<>();

    private DefaultTableModel Model;
    int selectedIndex;
    String sdt;

    public KhachHangGUI() {
        initComponents();

        Model = (DefaultTableModel) jtbDSKH.getModel();
        showTable();
        enableForm(false);
        normalState();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDSKH = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbtnThem = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jcbNameSearchType = new javax.swing.JComboBox<>();
        jtfNameSearch = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbHoTen = new javax.swing.JLabel();
        jtfHoTen = new javax.swing.JTextField();
        jlbSdt = new javax.swing.JLabel();
        jtfSdt = new javax.swing.JTextField();
        jbtnXacNhan = new javax.swing.JButton();
        jbtnHuy = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jtbDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Số điện thoại", "Tổng số tiền tích lũy", "Thành điểm", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbDSKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDSKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDSKH);
        if (jtbDSKH.getColumnModel().getColumnCount() > 0) {
            jtbDSKH.getColumnModel().getColumn(0).setResizable(false);
            jtbDSKH.getColumnModel().getColumn(1).setResizable(false);
            jtbDSKH.getColumnModel().getColumn(2).setResizable(false);
            jtbDSKH.getColumnModel().getColumn(3).setResizable(false);
            jtbDSKH.getColumnModel().getColumn(4).setResizable(false);
            jtbDSKH.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jbtnThem.setText("Thêm");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jbtnSua.setText("Sửa");
        jbtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuaActionPerformed(evt);
            }
        });

        jcbNameSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã", "Họ tên", "Số điện thoại" }));

        jbtnSearch.setText("Tìm kiếm");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSua))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbNameSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSearch)))
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThem)
                    .addComponent(jbtnSua))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbNameSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSearch))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jlbHoTen.setText("Họ tên khách hàng");

        jlbSdt.setText("Số điện thoại");

        jbtnXacNhan.setText("Xác nhận");
        jbtnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXacNhanActionPerformed(evt);
            }
        });

        jbtnHuy.setText("Hủy");
        jbtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbHoTen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbSdt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98)
                .addComponent(jbtnXacNhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnHuy)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbHoTen)
                    .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSdt)
                    .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnXacNhan)
                    .addComponent(jbtnHuy))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuaActionPerformed
        enableForm(true);
        jbtnXacNhan.setVisible(true);
        jbtnHuy.setVisible(true);
        jbtnXacNhan.setEnabled(true);
        jbtnHuy.setEnabled(true);
        jbtnThem.setEnabled(false);
        jbtnSua.setEnabled(false);
        jtbDSKH.setEnabled(false);
    }//GEN-LAST:event_jbtnSuaActionPerformed

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        resetForm();
        enableForm(true);
        jtbDSKH.clearSelection();
        jbtnXacNhan.setVisible(true);
        jbtnHuy.setVisible(true);
        jbtnXacNhan.setEnabled(true);
        jbtnHuy.setEnabled(true);
        jbtnSua.setEnabled(false);
        jbtnThem.setEnabled(false);
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void jtbDSKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDSKHMouseClicked
        selectedIndex = jtbDSKH.getSelectedRow();
        KhachHang a = khachhang.get(selectedIndex);
        jtfHoTen.setText(a.getTenKH());
        jtfSdt.setText(a.getSdt());
        jbtnSua.setEnabled(true);
        sdt = a.getSdt();
    }//GEN-LAST:event_jtbDSKHMouseClicked

    private void jbtnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXacNhanActionPerformed
        if (!checkFormFilled()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
            return;
        }
        if (jtbDSKH.getSelectionModel().isSelectionEmpty()) {//neu la trang thai Them tai khoan
            if (!checkValidSDT(jtfSdt.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                return;
            }

            if (!checkDuplicateSDT(jtfSdt.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại này đã tồn tại");
                return;
            }

            String hoten = jtfHoTen.getText().trim();
            String sdt = jtfSdt.getText().trim();
            KhachHang dto = new KhachHang(hoten, sdt);
            //them tai khoan
            try {
                new KhachHangBUS().AddKH(dto);
                showTable();
                normalState();
                clearSearchFilter();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại");
                e.printStackTrace();
            }
        } else {//neu la trang thai Sua Tai khoan
            if (!checkValidSDT(jtfSdt.getText())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                return;
            }
            if (!jtfSdt.getText().equals(sdt)) {
                if (!checkDuplicateSDT(jtfSdt.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Số điện thoại này đã tồn tại");
                    return;
                }
            }
            selectedIndex = jtbDSKH.getSelectedRow();
            KhachHang dto = khachhang.get(selectedIndex);
            dto.setTenKH(jtfHoTen.getText().trim());
            dto.setSdt(jtfSdt.getText().trim());
            //them tai khoan
            try {
                new KhachHangBUS().UpdateKH(dto);
                showTable();
                normalState();
                clearSearchFilter();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sửa khách hàng thất bại");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jbtnXacNhanActionPerformed

    private void jbtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHuyActionPerformed
        normalState();
        showTable();
    }//GEN-LAST:event_jbtnHuyActionPerformed

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        String loc = "";
        if (jcbNameSearchType.getSelectedItem().toString() == "Mã") {
            loc = "ma_khach_hang";
        }
        if (jcbNameSearchType.getSelectedItem().toString() == "Họ tên") {
            loc = "ten_khach_hang";
        }
        if (jcbNameSearchType.getSelectedItem().toString() == "Số điện thoại") {
            loc = "sdt";
        }
        if (jcbNameSearchType.getSelectedItem().toString() == "Tất cả") {
            loc = "all";
        }
        String name = jtfNameSearch.getText();
        if (name.length() > 0) {
            khachhang = new KhachHangBUS().FindKH(name, loc);
            Model.setRowCount(0);
            for (KhachHang kh : khachhang) {
                Model.addRow(new Object[]{
                    kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getTienTichLuy(), kh.getDiemTichLuy(), kh.getBangTien(),});
            }
        }
        jbtnHuy.setEnabled(true);
    }//GEN-LAST:event_jbtnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnHuy;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXacNhan;
    private javax.swing.JComboBox<String> jcbNameSearchType;
    private javax.swing.JLabel jlbHoTen;
    private javax.swing.JLabel jlbSdt;
    private javax.swing.JTable jtbDSKH;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfNameSearch;
    private javax.swing.JTextField jtfSdt;
    // End of variables declaration//GEN-END:variables

    private void showTable() {
        khachhang = new KhachHangBUS().getListKH();
        Model.setRowCount(0);
        for (KhachHang kh : khachhang) {
            Model.addRow(new Object[]{
                kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getTienTichLuy(), kh.getDiemTichLuy(), kh.getBangTien(),});
        }
    }

    private void resetForm() {
        jtfHoTen.setText("");
        jtfSdt.setText("");
        jtfNameSearch.setText("");
    }

    private void enableForm(boolean e) {
        jtfHoTen.setEnabled(e);
        jtfSdt.setEnabled(e);
    }

    private void normalState() {
        resetForm();
        enableForm(false);
        jtbDSKH.setEnabled(true);
        jbtnThem.setEnabled(true);
        jbtnSua.setEnabled(false);
        jbtnXacNhan.setEnabled(false);
        jbtnHuy.setEnabled(false);

    }

    private void clearSearchFilter() {
        jtfNameSearch.setText("");
        jcbNameSearchType.setSelectedIndex(0);
    }

    /*boolean isValidPhoneNumber(String phoneNumber) {
        // Kiểm tra chuỗi chỉ chứa 10 ký tự là chữ số
        String regex = "\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }*/
    public boolean checkFormFilled() {
        return (!jtfHoTen.getText().isBlank()
                && !jtfSdt.getText().isBlank())
                ? true : false;
    }

    public boolean checkValidSDT(String sdt) {
        String regex = "^0\\d{9}$";//bat dau = 0 va tong cong co 10 so
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sdt);
        return matcher.matches();
    }

    public boolean checkDuplicateSDT(String sdt) {
        boolean duplicate = true;
        List<KhachHang> list = new KhachHangBUS().getListKH();
        for (KhachHang i : list) {
            if (sdt.equals(i.getSdt())) {
                duplicate = false;
                break;
            } else {
                duplicate = true;
            }
        }

        return duplicate;
    }
}
