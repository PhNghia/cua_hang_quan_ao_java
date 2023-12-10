/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author Windows
 */
public class ThongKeSanPhamBanChayGUI extends javax.swing.JPanel {

    private List<Color> colorlist = Arrays.asList(
            new Color(255, 182, 193), // LightPink
            new Color(255, 160, 122), // LightSalmon
            new Color(255, 165, 0), // Orange
            new Color(255, 255, 0), // Yellow
            new Color(152, 251, 152), // PaleGreen
            new Color(0, 255, 127), // SpringGreen
            new Color(127, 255, 212), // Aquamarine
            new Color(224, 255, 255), // LightCyan
            new Color(240, 248, 255), // AliceBlue
            new Color(230, 230, 250), // Lavender
            new Color(255, 240, 245), // LavenderBlush
            new Color(255, 192, 203), // Pink
            new Color(255, 105, 180), // HotPink
            new Color(255, 20, 147), // DeepPink
            new Color(255, 140, 0), // DarkOrange
            new Color(255, 215, 0), // Gold
            new Color(240, 230, 140), // Khaki
            new Color(238, 232, 170), // PaleGoldenrod
            new Color(189, 183, 107), // DarkKhaki
            new Color(85, 107, 47), // DarkOliveGreen
            new Color(107, 142, 35), // OliveDrab
            new Color(124, 252, 0), // LawnGreen
            new Color(0, 250, 154), // MediumSpringGreen
            new Color(0, 255, 255), // Cyan
            new Color(0, 206, 209), // DarkTurquoise
            new Color(64, 224, 208), // Turquoise
            new Color(135, 206, 235), // SkyBlue
            new Color(135, 206, 250), // LightSkyBlue
            new Color(70, 130, 180), // SteelBlue
            new Color(100, 149, 237), // CornflowerBlue
            new Color(0, 191, 255), // DeepSkyBlue
            new Color(30, 144, 255) // DodgerBlue
    );

    /**
     * Creates new form ThongKeSanPhamBanChay
     */
    public ThongKeSanPhamBanChayGUI() {
        initComponents();
        LocalDate current = LocalDate.now();
        LocalDate onemonthbefore = LocalDate.now().minusMonths(1);
        jDateFrom.setDate(Date.from(onemonthbefore.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        jDateTo.setDate(Date.from(current.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        List<DTO.SanPham> list = BUS.ThongKeSPBanChayBUS.getInstance().getDataThongKe(onemonthbefore, current);
        createChart(list);
        loadDataTable(list);
        jLabel3.setText("Từ ngày:"+onemonthbefore.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"-"+current.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public void loadDataTable(List<DTO.SanPham> list) {
        DefaultTableModel tablemodel = ((DefaultTableModel) jTable.getModel());
        tablemodel.setRowCount(0);
        for (DTO.SanPham item : list) {
            tablemodel.addRow(new Object[]{item.getMaSP(), item.getTenSP(), item.getGiaBan(), item.getSoLuong(), item.getGiaBan() * item.getSoLuong()});
        }
    }

    public void createChart(List<DTO.SanPham> list) {
        datasetpie = new DefaultPieDataset();
        datasethist = new DefaultCategoryDataset();
        if (list.size() == 0) {
            datasetpie.setValue("Không có sản phẩm", 1);
            datasethist.setValue(0, "Sản phẩm", "");
        } else {
            for (DTO.SanPham item : list) {
                datasetpie.setValue(item.getTenSP(), item.getSoLuong());
                datasethist.setValue(item.getSoLuong(), "Sản phẩm", item.getTenSP());
            }
        }
        chartpie = ChartFactory.createPieChart(
                "Số lượng đã bán",
                datasetpie,
                false,
                false,
                false);
        PiePlot pieplot = (PiePlot) chartpie.getPlot();
        PieSectionLabelGenerator labelGenerator;
        if (list.size() != 0) {
            labelGenerator = new StandardPieSectionLabelGenerator(
                    "{0}({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            for (int i = 0; i < list.size(); i++) {
                pieplot.setSectionPaint(list.get(i).getTenSP(), colorlist.get(i));
                
            }
        } else {
            labelGenerator = new StandardPieSectionLabelGenerator(
                    "{0}", new DecimalFormat("0"), new DecimalFormat("0%"));
            pieplot.setSectionPaint("Không có sản phẩm", Color.BLACK);
        }

        pieplot.setLabelGenerator(labelGenerator);
        pieplot.setBackgroundPaint(new Color(255, 250, 205));
        // Create Panel  
        ChartPanel piepanel = new ChartPanel(chartpie);
        jPanelleftup.removeAll();

        jPanelleftup.add(piepanel);
        jPanelleftup.revalidate();
        jPanelleftup.repaint();

        //
        JFreeChart charthist = ChartFactory.createBarChart(
                "",
                "Sản phẩm",
                "Số lượng đã bán",
                datasethist,
                PlotOrientation.HORIZONTAL, false, false, false);
        CategoryPlot categoryplot = charthist.getCategoryPlot();
        categoryplot.setBackgroundPaint(new Color(255, 250, 205));
        BarRenderer renderer = (BarRenderer) categoryplot.getRenderer();
        renderer.setSeriesPaint(0, new Color(135, 206, 250));

        ChartPanel histpanel = new ChartPanel(charthist);
        jPanelleftdown.removeAll();
        jPanelleftdown.add(histpanel);
        jPanelleftdown.revalidate();
        jPanelleftdown.repaint();

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
        jPanelleftup = new javax.swing.JPanel();
        jPanelleftdown = new javax.swing.JPanel();
        jPanelright = new javax.swing.JPanel();
        jPanelrightup = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanelrightdown = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateFrom = new com.toedter.calendar.JDateChooser();
        jDateTo = new com.toedter.calendar.JDateChooser();
        jBtnThongKe = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanelleftup.setBackground(new java.awt.Color(204, 255, 204));
        jPanelleftup.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanelleftup);

        jPanelleftdown.setBackground(new java.awt.Color(153, 255, 153));
        jPanelleftdown.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanelleftdown);
        jPanel2.setLayout(new GridLayout(2,1));

        add(jPanel2);

        jPanelright.setBackground(new java.awt.Color(255, 102, 102));
        jPanelright.setLayout(new java.awt.GridLayout(1, 0));

        jPanelrightup.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Giá", "Số lượng", "Tổng giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Từ ngày");

        javax.swing.GroupLayout jPanelrightupLayout = new javax.swing.GroupLayout(jPanelrightup);
        jPanelrightup.setLayout(jPanelrightupLayout);
        jPanelrightupLayout.setHorizontalGroup(
            jPanelrightupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelrightupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelrightupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelrightupLayout.setVerticalGroup(
            jPanelrightupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelrightupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelright.add(jPanelrightup);
        jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        jPanel2.setBackground(Color.WHITE);
        jPanelright.setBorder(BorderFactory.createTitledBorder(""));
        jPanelright.setBackground(Color.WHITE);

        jPanelrightdown.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Từ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Đến");

        jDateFrom.setBackground(new java.awt.Color(255, 255, 255));

        jDateTo.setBackground(new java.awt.Color(255, 255, 255));

        jBtnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnThongKe.setText("Thống kê");
        jBtnThongKe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jBtnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelrightdownLayout = new javax.swing.GroupLayout(jPanelrightdown);
        jPanelrightdown.setLayout(jPanelrightdownLayout);
        jPanelrightdownLayout.setHorizontalGroup(
            jPanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelrightdownLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanelrightdownLayout.setVerticalGroup(
            jPanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelrightdownLayout.createSequentialGroup()
                .addGroup(jPanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelrightdownLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jBtnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelrightdownLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jPanelright.add(jPanelrightdown);

        add(jPanelright);
        jPanelright.setLayout(new GridLayout(2,1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThongKeActionPerformed
        // TODO add your handling code here:
        if (jDateFrom.getDate().after(jDateTo.getDate())) {
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu không thể lớn hơn ngày kết thúc");
            return;
        }
        List<DTO.SanPham> list = BUS.ThongKeSPBanChayBUS.getInstance().getDataThongKe(jDateFrom.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), jDateTo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        createChart(list);
        loadDataTable(list);
        jLabel3.setText("Từ ngày:"+new SimpleDateFormat("dd/MM/yyyy").format(jDateFrom.getDate())+"-"+new SimpleDateFormat("dd/MM/yyyy").format(jDateTo.getDate()));

    }//GEN-LAST:event_jBtnThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnThongKe;
    private com.toedter.calendar.JDateChooser jDateFrom;
    private com.toedter.calendar.JDateChooser jDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelleftdown;
    private javax.swing.JPanel jPanelleftup;
    private javax.swing.JPanel jPanelright;
    private javax.swing.JPanel jPanelrightdown;
    private javax.swing.JPanel jPanelrightup;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
    private DefaultPieDataset datasetpie;
    private DefaultCategoryDataset datasethist;
    private JFreeChart chartpie;
    private JFreeChart charthist;
}
