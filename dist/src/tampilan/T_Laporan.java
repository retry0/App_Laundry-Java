/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tampilan;

import connection.Koneksi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class T_Laporan extends javax.swing.JFrame {

              Connection connection;
    /**
     * Creates new form T_Laporan
     */
    public T_Laporan() {
        initComponents();
        tampilkan_tahun();
        date1.setEnabled(false);
        c_tahun.setEnabled(false);
        b_cari.setEnabled(false);
        date2.setEnabled(false);
        b_cariH.setEnabled(false);
        
setLocationRelativeTo(this);
    }
    
    private void Total(){
        int rows = tabel_LK.getRowCount();
        int sum=0;
        for(int x=0;x<rows;x++){

            String nilai = tabel_LK.getValueAt(x, 3).toString();
        int nilai1 = Integer.parseInt(nilai);
            sum = sum + nilai1;
        }
            String sum1 = Integer.toString(sum);
            txt_hitung.setText("Rp."+sum1);
    }
    
    private void tampilkan_tahun() {
                   
        try {
            connection = Koneksi.connection();
            String sql = "select* from tahun";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                c_tahun.addItem(rslt.getString("tahun"));
                
            }
            rslt.last();  
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat tahun");
        }
    
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_LK = new javax.swing.JTable();
        b_cetak = new javax.swing.JButton();
        b_cari = new javax.swing.JButton();
        b_batal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b_cariH = new javax.swing.JButton();
        date2 = new com.toedter.calendar.JDateChooser();
        date1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txt_hitung = new javax.swing.JTextField();
        c_tahun = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        c_pilihan = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jInternalFrame1.setBackground(new java.awt.Color(0, 102, 204));
        jInternalFrame1.setForeground(new java.awt.Color(0, 51, 204));
        jInternalFrame1.setTitle("Laporan Keuangan");
        jInternalFrame1.setVisible(true);

        jLabel2.setText("Bulan");

        tabel_LK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal", "Berat", "Kategori", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tabel_LK);

        b_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cetak.png"))); // NOI18N
        b_cetak.setText("Cetak");
        b_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cetakActionPerformed(evt);
            }
        });

        b_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cari.png"))); // NOI18N
        b_cari.setText("Cari");
        b_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_cariMouseClicked(evt);
            }
        });
        b_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cariActionPerformed(evt);
            }
        });

        b_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Windows-Close-Program-icon(www.likewin7.co.cc).png"))); // NOI18N
        b_batal.setText("Keluar");
        b_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_batalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        jLabel1.setText("Laporan");

        jLabel3.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        jLabel3.setText("Keuangan");

        jLabel4.setText("Hari");

        b_cariH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cari.png"))); // NOI18N
        b_cariH.setText("Cari");
        b_cariH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_cariHMouseClicked(evt);
            }
        });
        b_cariH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cariHActionPerformed(evt);
            }
        });

        date1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel5.setText("Total Pendapatan");

        txt_hitung.setEditable(false);

        c_tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel6.setText("Tahun");

        c_pilihan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Harian", "Bulanan" }));
        c_pilihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_pilihanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(c_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(date2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(b_cari)
                                    .addComponent(b_cariH)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(c_pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(b_cetak)
                        .addGap(30, 30, 30)
                        .addComponent(b_batal)
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(txt_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(c_pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(c_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(b_cari))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_cariH)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cetak)
                    .addComponent(b_batal))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_batalActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_batalActionPerformed

    private void b_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cariActionPerformed
tampilkan_dataT();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_cariActionPerformed

    private void b_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cetakActionPerformed

       if  (c_pilihan.getSelectedItem().equals("Bulanan")){
   try{
       String NamaFile = "src/report/bulanan.jasper"; 
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Laundry","root","");
       @SuppressWarnings("rawtypes")
       HashMap hash = new HashMap(2);
       //mengambil parameter dari ireport
       hash.put("bulan", date1.getSelectedItem());
       hash.put("tahun", c_tahun.getSelectedItem());
       hash.put("total", txt_hitung.getText());
       
       File file = new File(NamaFile);
       JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash,koneksi);
       JasperViewer.viewReport(jasperPrint,false);
   }catch(Exception ex){
       System.out.println(ex);
   }
   }
        else if (c_pilihan.getSelectedItem().equals("Harian")){
            String tampilan = "yyyy-M-dd";
            SimpleDateFormat format = new SimpleDateFormat(tampilan);
             try{
       String NamaFile = "src/report/laporanHari.jasper"; 
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Laundry","root","");
       @SuppressWarnings("rawtypes")
       HashMap hash = new HashMap(2);
       //mengambil parameter dari ireport
       hash.put("tanggal", java.sql.Date.valueOf(format.format(date2.getDate())));
       hash.put("total", txt_hitung.getText());
       
       File file = new File(NamaFile);
       JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash,koneksi);
       JasperViewer.viewReport(jasperPrint,false);
   }catch(Exception ex){
       System.out.println(ex);
   }
        }
        else{
            JOptionPane.showMessageDialog(null, "Pilih Laporan Harian atau Bulanan");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_b_cetakActionPerformed

    private void b_cariHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cariHActionPerformed

        tampilkan_dataT2();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_cariHActionPerformed

    private void b_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_cariMouseClicked

                Total();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_cariMouseClicked

    private void b_cariHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_cariHMouseClicked

        Total();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_cariHMouseClicked

    private void c_pilihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_pilihanActionPerformed

        if (c_pilihan.getSelectedItem().equals("Harian")){
            date1.setEnabled(false);
        c_tahun.setEnabled(false);
        b_cari.setEnabled(false);
        date2.setEnabled(true);
        b_cariH.setEnabled(true);
        }
        else if(c_pilihan.getSelectedItem().equals("Bulanan")){
            date1.setEnabled(true);
        c_tahun.setEnabled(true);
        b_cari.setEnabled(true);
        date2.setEnabled(false);
        b_cariH.setEnabled(false);
        }
        else{
            date1.setEnabled(false);
        c_tahun.setEnabled(false);
        b_cari.setEnabled(false);
        date2.setEnabled(false);
        b_cariH.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_c_pilihanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(T_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(T_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(T_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(T_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new T_Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_batal;
    private javax.swing.JButton b_cari;
    private javax.swing.JButton b_cariH;
    private javax.swing.JButton b_cetak;
    private javax.swing.JComboBox c_pilihan;
    private javax.swing.JComboBox c_tahun;
    private javax.swing.JComboBox date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_LK;
    private javax.swing.JTextField txt_hitung;
    // End of variables declaration//GEN-END:variables

    private void tampilkan_dataT() {
        
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("Tanggal");
        tabelmapel.addColumn("Berat");
        tabelmapel.addColumn("Kategori");
        tabelmapel.addColumn("Harga");
        
        try {
            connection = Koneksi.connection();
            String sql = "select a.tgl_bayar, b.berat, b.kategori, b.total_bayar from transaksi a, data_transaksi b where a.no_nota=b.no_nota AND a.status_bayar='Lunas' AND MONTH(tgl_bayar) = '"+date1.getSelectedItem()+"' And YEAR(tgl_bayar) = '"+c_tahun.getSelectedItem()+"'";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                Object[] o =new Object[4];
                o[0] = rslt.getDate("tgl_bayar");
                o[1] = rslt.getString("berat");
                o[2] = rslt.getString("kategori");
                o[3] = rslt.getString("total_bayar");
                tabelmapel.addRow(o);
            }
            tabel_LK.setModel(tabelmapel);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data");
        }
    
        }
    
     private void tampilkan_dataT2() {
        
                 String tampilan = "yyyy-M-dd";

SimpleDateFormat format = new SimpleDateFormat(tampilan);

        
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("Tanggal");
        tabelmapel.addColumn("Berat");
        tabelmapel.addColumn("Kategori");
        tabelmapel.addColumn("Harga");
        
        try {
            connection = Koneksi.connection();
            String sql = "select a.tgl_bayar, b.berat, b.kategori, b.total_bayar from transaksi a, data_transaksi b where a.no_nota=b.no_nota AND a.status_bayar='Lunas' AND a.tgl_bayar = '"+java.sql.Date.valueOf(format.format(date2.getDate()))+"'";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                Object[] o =new Object[4];
                o[0] = rslt.getDate("tgl_bayar");
                o[1] = rslt.getString("berat");
                o[2] = rslt.getString("kategori");
                o[3] = rslt.getString("total_bayar");
                tabelmapel.addRow(o);
            }
            tabel_LK.setModel(tabelmapel);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data");
        }
    
        }
}
