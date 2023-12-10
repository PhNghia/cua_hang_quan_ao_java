/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import DTO.SanPham;
import BUS.HoaDonMuaBUS;
import BUS.SanPhamBUS;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows
 */
public class ThongKeSoLuongNhapHangGUI extends javax.swing.JPanel {
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
     * Creates new form ThongKeSoLuongNhapHang
     */
    public ThongKeSoLuongNhapHangGUI() {
        initComponents();
        LocalDate current = LocalDate.now();
        LocalDate onemonthbefore = LocalDate.now().minusMonths(1);
        jDateChooser1.setDate(Date.from(onemonthbefore.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        jDateChooser2.setDate(Date.from(current.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        List<SanPham> list = BUS.ThongKeSPNhapBUS.getInstance().getDataThongKe(onemonthbefore, current);
        createChart(list);
        loadDataTable(list);
        jLabel1.setText("Từ ngày:"+onemonthbefore.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"-"+current.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    
    }
    public void createChart(List<SanPham> list) {
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
                "Số lượng đã nhập",
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
        jpanelleftup.removeAll();

        jpanelleftup.add(piepanel);
        jpanelleftup.revalidate();
        jpanelleftup.repaint();

        //
        JFreeChart charthist = ChartFactory.createBarChart(
                "",
                "Sản phẩm",
                "Số lượng đã nhập",
                datasethist,
                PlotOrientation.HORIZONTAL, false, false, false);
        CategoryPlot categoryplot = charthist.getCategoryPlot();
        categoryplot.setBackgroundPaint(new Color(255, 250, 205));
        BarRenderer renderer = (BarRenderer) categoryplot.getRenderer();
        renderer.setSeriesPaint(0, new Color(135, 206, 250));

        ChartPanel histpanel = new ChartPanel(charthist);
        jpanelleftdown.removeAll();
        jpanelleftdown.add(histpanel);
        jpanelleftdown.revalidate();
        jpanelleftdown.repaint();

    }
    
    /*public void createChart1(List<SanPham> list){
        datasetpie = new DefaultPieDataset();
        datasethist = new DefaultCategoryDataset();
        
        datasetpie.setValue("SP01", 10);
        datasetpie.setValue("SP02", 10);
        datasetpie.setValue("SP03", 10);
         datasethist.setValue(10, "Sản phẩm", "SP01");
         datasethist.setValue(10,"Sản phẩm","SP02");
         
         chartpie = ChartFactory.createPieChart(
                "Số lượng nhập",
                datasetpie,
                false,
                false,
                false);
        PiePlot pieplot = (PiePlot) chartpie.getPlot();
        PieSectionLabelGenerator labelGenerator;
        
        labelGenerator = new StandardPieSectionLabelGenerator(
                    "{0}({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        pieplot.setSectionPaint("SP01", colorlist.get(0));
        pieplot.setSectionPaint("SP02",colorlist.get(1));
        pieplot.setSectionPaint("SP03",colorlist.get(2));
        pieplot.setLabelGenerator(labelGenerator);
        pieplot.setBackgroundPaint(new Color(255, 250, 205));
        // Create Panel  
        ChartPanel piepanel = new ChartPanel(chartpie);
        jpanelleftup.removeAll();

        jpanelleftup.add(piepanel);
        jpanelleftup.revalidate();
        jpanelleftup.repaint();
        charthist = ChartFactory.createBarChart(
                "",
                "Sản phẩm",
                "Số lượng đã nhập",
                datasethist,
                PlotOrientation.HORIZONTAL, false, false, false);
        CategoryPlot categoryplot = charthist.getCategoryPlot();
        categoryplot.setBackgroundPaint(new Color(255, 250, 205));
        BarRenderer renderer = (BarRenderer) categoryplot.getRenderer();
        renderer.setSeriesPaint(0, new Color(135, 206, 250));

        ChartPanel histpanel = new ChartPanel(charthist);
        jpanelleftdown.removeAll();
        jpanelleftdown.add(histpanel);
        jpanelleftdown.revalidate();
        jpanelleftdown.repaint();
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelleft = new javax.swing.JPanel();
        jpanelleftup = new javax.swing.JPanel();
        jpanelleftdown = new javax.swing.JPanel();
        jpanelright = new javax.swing.JPanel();
        jpanelrightup = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jpanelrightdown = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        jpanelleft.setBackground(new java.awt.Color(255, 255, 255));
        jpanelleft.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jpanelleftupLayout = new javax.swing.GroupLayout(jpanelleftup);
        jpanelleftup.setLayout(jpanelleftupLayout);
        jpanelleftupLayout.setHorizontalGroup(
            jpanelleftupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        jpanelleftupLayout.setVerticalGroup(
            jpanelleftupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpanelleftdownLayout = new javax.swing.GroupLayout(jpanelleftdown);
        jpanelleftdown.setLayout(jpanelleftdownLayout);
        jpanelleftdownLayout.setHorizontalGroup(
            jpanelleftdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanelleftdownLayout.setVerticalGroup(
            jpanelleftdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpanelleftLayout = new javax.swing.GroupLayout(jpanelleft);
        jpanelleft.setLayout(jpanelleftLayout);
        jpanelleftLayout.setHorizontalGroup(
            jpanelleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelleftup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpanelleftdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanelleftLayout.setVerticalGroup(
            jpanelleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelleftLayout.createSequentialGroup()
                .addComponent(jpanelleftup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanelleftdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanelleftup.setLayout(new BorderLayout());
        jpanelleftdown.setLayout(new BorderLayout());

        add(jpanelleft);

        jpanelright.setBackground(new java.awt.Color(255, 255, 255));
        jpanelright.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jpanelrightup.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Từ ngày");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá nhập trung bình", "Tổng số lượng nhập", "Tổng tiền nhập"
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
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jpanelrightupLayout = new javax.swing.GroupLayout(jpanelrightup);
        jpanelrightup.setLayout(jpanelrightupLayout);
        jpanelrightupLayout.setHorizontalGroup(
            jpanelrightupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelrightupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelrightupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(jpanelrightupLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpanelrightupLayout.setVerticalGroup(
            jpanelrightupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelrightupLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );

        jpanelrightdown.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Từ:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Đến:");

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));

        jDateChooser2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelrightdownLayout = new javax.swing.GroupLayout(jpanelrightdown);
        jpanelrightdown.setLayout(jpanelrightdownLayout);
        jpanelrightdownLayout.setHorizontalGroup(
            jpanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelrightdownLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelrightdownLayout.setVerticalGroup(
            jpanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelrightdownLayout.createSequentialGroup()
                .addGroup(jpanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelrightdownLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jpanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpanelrightdownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpanelrightdownLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanelrightLayout = new javax.swing.GroupLayout(jpanelright);
        jpanelright.setLayout(jpanelrightLayout);
        jpanelrightLayout.setHorizontalGroup(
            jpanelrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelrightup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpanelrightdown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanelrightLayout.setVerticalGroup(
            jpanelrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelrightLayout.createSequentialGroup()
                .addComponent(jpanelrightup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanelrightdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jpanelright);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (jDateChooser1.getDate().after(jDateChooser2.getDate())) {
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu không thể lớn hơn ngày kết thúc");
            return;
        }
        List<DTO.SanPham> list = BUS.ThongKeSPNhapBUS.getInstance().getDataThongKe(jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), jDateChooser2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        createChart(list);
        loadDataTable(list);
        jLabel1.setText("Từ ngày:"+new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser1.getDate())+"-"+new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser2.getDate()));
    }//GEN-LAST:event_jButton1ActionPerformed

    public void loadDataTable(List<SanPham> list) {
        DefaultTableModel tablemodel = ((DefaultTableModel) jTable.getModel());
        tablemodel.setRowCount(0);
        for (DTO.SanPham item : list) {
            tablemodel.addRow(new Object[]{item.getMaSP(), item.getTenSP(), item.getGiaNhapTB(), item.getSoLuong(), item.getTongTienSPNhap()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JPanel jpanelleft;
    private javax.swing.JPanel jpanelleftdown;
    private javax.swing.JPanel jpanelleftup;
    private javax.swing.JPanel jpanelright;
    private javax.swing.JPanel jpanelrightdown;
    private javax.swing.JPanel jpanelrightup;
    // End of variables declaration//GEN-END:variables
    private DefaultPieDataset datasetpie;
    private DefaultCategoryDataset datasethist;
    private JFreeChart chartpie;
    private JFreeChart charthist;
}
