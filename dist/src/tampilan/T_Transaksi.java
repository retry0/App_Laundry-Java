/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tampilan;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
import connection.Koneksi;
import controler.Controler_Transaksi;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author ASUS
 */
public class T_Transaksi extends javax.swing.JFrame {

    java.util.Date tglsekarang = new java.util.Date();
    private SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy-M-dd", Locale.getDefault());
    //diatas adalah pengaturan format penulisan, bisa diubah sesuai keinginan.
    private String tanggal = smpdtfmt.format(tglsekarang);
    Controler_Transaksi ct;
    Connection connection;
 String jml = "", i,m;
 int j = 0, k=0, l=0;
    /**
     * Creates new form T_Transaksi
     */
    public T_Transaksi() {
        initComponents();
        ct =new Controler_Transaksi(this);
        ct.isiTable();
        //ct.isiTabledt();
        tampilkan_dataP();
        tampilkan_combo();
        tgl.setText(tanggal);
        tgl_masuk.setDate(tglsekarang);
        d_bayar.setDate(tglsekarang);
         autoNota();
         b_ubahT.setEnabled(false);
         
         //untuk mengubah ukuran form cari
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jDialog1.setPreferredSize(new Dimension(200, 600));
        jDialog1.setMinimumSize(new Dimension(400, 350));
        jDialog1.setMaximumSize(new Dimension(400, 350));
        
        jDialog2.setPreferredSize(new Dimension(200, 600));
        jDialog2.setMinimumSize(new Dimension(740, 530));
        jDialog2.setMaximumSize(new Dimension(740, 530));
        
        setLocationRelativeTo(this);
        
                jDialog1.setLocationRelativeTo(this);
                jDialog2.setLocationRelativeTo(this);
                
        txt_berat.setEnabled(false);
        c_kategori.setEnabled(false);
        txt_jumlah.setEnabled(false);
        b_hapusT.setEnabled(false);
        b_tambah.setEnabled(false);
        area.setEnabled(false);
        txt_jmlitem.setEnabled(false);
        tarif.setEnabled(false);
        
    }
    
    public JTextArea getArea(){
        return area;
    }
    
     public JTextField getTxtjmlitem(){
        return txt_jmlitem;
    }
      public JTextField getTxttarif(){
        return tarif;
    }
    
    public JTextField getTxtNota(){
        return txt_nota;
    }
    public JTextField getTxtNpT(){
        return txt_npT;
    }
    public JDateChooser getDateMasuk(){
        return tgl_masuk;
    }
    
    public JDateChooser getDateBayar(){
        return d_bayar;
    }

        public JDateChooser getDateSelesai(){
        return tgl_selesai;
    }
    
    public JComboBox getCStatus (){
        return c_status;
    }
    
        public JComboBox getCStatusb (){
        return c_statusb;
    }
    
    public JComboBox getCKategori (){
        return c_kategori;
    }   
    
        
    public JTextField getTxtberat(){
        return txt_berat;
    }
    
    public JTextField getTxtjumlah(){
        return txt_jumlah;
    }
    
    public JTextField getTxttotal(){
        return txt_total;
    }
    
    public JTextField getTxtbayar(){
        return txt_bayar;
    }
    
    public JTextField getTxtkembali(){
        return txt_kembali;
    }
    
    public JButton getButtonSimpan(){
        return b_simpan;
    }
    public JButton getButtonUbah(){
        return b_ubahT;
    }
    
 
    public JButton getButtonHapus(){
        return b_hapusT;
    }
    public JButton getButtonReset(){
        return b_reset;
    }
    public JButton getButtonTambah(){
        return b_tambah;
    }
    public JTable getTabelT(){
        return tabel_T;
    }
    
    public JTable getTabelP(){
        return t_p;
    }  
    
 //   public JTable getTabelDT(){
   //     return t_dt;
    //}  
    
    public JRadioButton getRKg(){
        return r_kiloan;
    }
    
     public JRadioButton getRI(){
        return r_item;
    }
     
     public JRadioButton getAll(){
        return all;
    }
    
    
    private void tampilkan_combo() {
                    
        try {
            connection = Koneksi.connection();
            String sql = "select * from kategori";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                c_kategori.addItem(rslt.getString("kategori"));
                
            }
            rslt.last();  
            int jumlahdata = rslt.getRow();  
            rslt.first();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data kategori");
        }
    
        }
    
    private void tampilkan_total() {
                   
        try {
            connection = Koneksi.connection();
            String sql = "select * from kategori where kategori ='"+c_kategori.getSelectedItem()+"'";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String h,i,k;
                int j;
                h = rslt.getString("tarif");
                i = txt_jmlitem.getText();
                j = Integer.parseInt(h) * Integer.parseInt(i);
                k = Integer.toString(j);
                tarif.setText(k);
                //txt_bayar.requestFocus();
                
                }
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat tarif");
        }
    
        }
    
    private void tampilkan_total2(){
        String h,l;
float i;
        h=txt_berat.getText();
        i= Float.parseFloat(h)*7000;
        l= Float.toString(i);
totalkg.setText(l);
//txt_bayar.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_p = new javax.swing.JTable();
        jDialog2 = new javax.swing.JDialog();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        r_kiloan = new javax.swing.JRadioButton();
        r_item = new javax.swing.JRadioButton();
        all = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        txt_berat = new javax.swing.JTextField();
        c_kategori = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_jmlitem = new javax.swing.JTextField();
        tarif = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        b_tambah = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalkg = new javax.swing.JTextField();
        totalitem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txt_kembali = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txt_bayar = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_nota = new javax.swing.JTextField();
        txt_npT = new javax.swing.JTextField();
        c_status = new javax.swing.JComboBox();
        tgl_masuk = new com.toedter.calendar.JDateChooser();
        tgl_selesai = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        c_statusb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        d_bayar = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        b_reset = new javax.swing.JButton();
        b_simpan = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabel_T = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        b_ubahT = new javax.swing.JButton();
        b_hapusT = new javax.swing.JButton();
        b_batalT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        jDialog1.setUndecorated(true);

        t_p.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        t_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_pMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_p);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jDialog2.setUndecorated(true);

        jInternalFrame2.setVisible(true);

        r_kiloan.setText("Kiloan");
        r_kiloan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_kiloanActionPerformed(evt);
            }
        });

        r_item.setText("Per Item");
        r_item.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                r_itemStateChanged(evt);
            }
        });
        r_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_itemActionPerformed(evt);
            }
        });

        all.setText("Kiloan & Per Item");
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(r_kiloan)
                .addGap(18, 18, 18)
                .addComponent(r_item)
                .addGap(18, 18, 18)
                .addComponent(all)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_kiloan)
                    .addComponent(r_item)
                    .addComponent(all)))
        );

        jLabel39.setText("Berat (kg)*");

        txt_berat.setText("0");
        txt_berat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_beratActionPerformed(evt);
            }
        });
        txt_berat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_beratKeyPressed(evt);
            }
        });

        c_kategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        c_kategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_kategoriMouseClicked(evt);
            }
        });

        jLabel40.setText("Kategori*");

        jLabel1.setText("Jumlah Item*");

        txt_jmlitem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jmlitemKeyPressed(evt);
            }
        });

        tarif.setEditable(false);

        jLabel2.setText("Tarif (Rp)*");

        area.setEditable(false);
        area.setColumns(20);
        area.setRows(5);
        jScrollPane2.setViewportView(area);

        b_tambah.setText("Tambah");
        b_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_tambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_jmlitem)
                    .addComponent(c_kategori, 0, 139, Short.MAX_VALUE)
                    .addComponent(txt_berat)
                    .addComponent(tarif))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_tambah)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txt_berat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_jmlitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_tambah)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        jLabel41.setText("Jumlah(total item)");

        txt_jumlah.setEditable(false);
        txt_jumlah.setText("0");
        txt_jumlah.setToolTipText("");
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyPressed(evt);
            }
        });

        jLabel42.setText("Total Bayar (Rp)");

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total.setText("0");
        txt_total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_totalFocusGained(evt);
            }
        });

        jLabel7.setText("Total Bayar(kg)");

        jLabel9.setText("Total Bayar(item)");

        totalkg.setEditable(false);
        totalkg.setText("0");

        totalitem.setEditable(false);
        totalitem.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(31, 31, 31)
                        .addComponent(txt_total))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(totalkg)
                            .addComponent(totalitem))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalkg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(totalitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel5.setText("DATA TRANSAKSI");

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setText("Kembali (Rp)");

        txt_kembali.setEditable(false);
        txt_kembali.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kembali.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_kembaliFocusGained(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setText("Bayar (Rp)");

        txt_bayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_bayarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bayar)
                    .addComponent(txt_kembali))
                .addGap(16, 16, 16))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Hitung");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(190, 190, 190))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(215, 215, 215))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(51, 51, 51)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2)
        );

        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jInternalFrame1.setTitle("Transaksi");
        jInternalFrame1.setVisible(true);

        jLabel34.setText("No Nota");

        jLabel35.setText("Nomor Pelanggan");

        jLabel36.setText("tgl Masuk");

        jLabel37.setText("tgl Selesai");

        jLabel38.setText("Status");

        txt_nota.setEditable(false);

        txt_npT.setEditable(false);

        c_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Belum Diambil", "Sudah Diambil" }));

        tgl_masuk.setDateFormatString("yyyy-M-dd");
        tgl_masuk.setEnabled(false);

        tgl_selesai.setDateFormatString("yyyy-M-dd");

        jLabel4.setText("Status Bayar");

        c_statusb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Belum Lunas", "Lunas" }));

        jLabel6.setText("tgl Bayar");

        d_bayar.setDateFormatString("yyyy-M-dd");

        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("*");

        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");

        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("*");

        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("*");

        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("*");

        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("*");

        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(d_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tgl_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_npT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl_selesai, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_status, 0, 139, Short.MAX_VALUE)
                            .addComponent(c_statusb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(244, 244, 244))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_npT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(jLabel12))
                    .addComponent(tgl_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(c_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addComponent(tgl_selesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel16))
                    .addComponent(c_statusb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel17))
                    .addComponent(d_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        b_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset.png"))); // NOI18N
        b_reset.setText("Reset");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });

        b_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/simpan.png"))); // NOI18N
        b_simpan.setText("Simpan");
        b_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_reset)
                .addGap(18, 18, 18)
                .addComponent(b_simpan)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_reset)
                    .addComponent(b_simpan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabel_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No Nota", "Nomor Plgn", "tgl Masuk", "tgl Selesai", "Status", "Status Byr", "Title 7"
            }
        ));
        tabel_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_TMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabel_T);

        b_ubahT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ubah.png"))); // NOI18N
        b_ubahT.setText("Ubah");
        b_ubahT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ubahTActionPerformed(evt);
            }
        });

        b_hapusT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hapus.png"))); // NOI18N
        b_hapusT.setText("Hapus");

        b_batalT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Windows-Close-Program-icon(www.likewin7.co.cc).png"))); // NOI18N
        b_batalT.setText("Keluar");
        b_batalT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_batalTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(b_ubahT)
                .addGap(33, 33, 33)
                .addComponent(b_hapusT)
                .addGap(31, 31, 31)
                .addComponent(b_batalT)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_batalT)
                    .addComponent(b_hapusT)
                    .addComponent(b_ubahT))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cetak.png"))); // NOI18N
        jButton1.setText("Cetak Nota");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel3.setText("Transaksi");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        jButton2.setText("Detail Transaksi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tgl.setText("jLabel7");

        jLabel8.setText("Tanggal :");

        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("*");

        jLabel19.setText(") Wajib diisi");

        jButton5.setText("Cari");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel20.setText("nama");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 42, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(43, 43, 43))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGap(127, 127, 127)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(64, 64, 64))))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tgl)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5)
                                    .addComponent(jLabel20))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tgl)
                        .addComponent(jLabel8))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel19)))
                .addContainerGap())
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

    private void r_kiloanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_kiloanActionPerformed

                txt_berat.setEnabled(true);
        c_kategori.setEnabled(false);
        txt_jumlah.setEnabled(false);
        r_item.setSelected(false);
        all.setSelected(false);
        b_tambah.setEnabled(false);
        area.setEnabled(false);
        txt_jmlitem.setEnabled(false);
        tarif.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_r_kiloanActionPerformed

    private void r_itemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_r_itemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_r_itemStateChanged

    private void r_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_itemActionPerformed

         txt_berat.setEnabled(false);
        c_kategori.setEnabled(true);
        txt_jumlah.setEnabled(true);
        r_kiloan.setSelected(false);
        all.setSelected(false);
        b_tambah.setEnabled(true);
        area.setEnabled(true);
        txt_jmlitem.setEnabled(true);
        tarif.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_r_itemActionPerformed

    private void txt_beratKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_beratKeyPressed
if(evt.getKeyCode() == evt.VK_ENTER){
txt_total.requestFocus();
tampilkan_total2();}
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_beratKeyPressed

    private void txt_totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_totalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalFocusGained

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed

        ct.reset();
        autoNota();
        dispose();
        new T_Transaksi().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_b_resetActionPerformed

    private void b_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_simpanActionPerformed
      
             ct.insert();
             ct.insertdt();
             ct.isiTable();
        //     ct.isiTabledt();
             ct.reset();
             jDialog2.dispose();
             autoNota();

        // TODO add your handling code here:
    }//GEN-LAST:event_b_simpanActionPerformed

    private void b_batalTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_batalTActionPerformed

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_batalTActionPerformed

    private void t_pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_pMouseClicked
txt_npT.setText(t_p.getValueAt(t_p.getSelectedRow(), 0).toString());
jDialog1.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_pMouseClicked

    private void txt_bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyPressed
if(evt.getKeyCode() == evt.VK_ENTER)
txt_kembali.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarKeyPressed

    private void txt_kembaliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_kembaliFocusGained
String h,l,m;
int j;
float i;
        h=txt_bayar.getText();
        m=txt_total.getText();
        i= Integer.parseInt(h)-Float.parseFloat(m);
        l= Float.toString(i);
txt_kembali.setText(l);
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembaliFocusGained

    private void txt_jumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahKeyPressed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_beratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_beratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_beratActionPerformed

    private void tabel_TMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_TMouseClicked

ct.isiField(tabel_T.getSelectedRow());
b_simpan.setEnabled(false);
b_ubahT.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_TMouseClicked

    private void b_ubahTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ubahTActionPerformed
ct.update();
ct.isiTable();
ct.reset();
autoNota();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_ubahTActionPerformed

    private void b_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_tambahActionPerformed
   
jml += c_kategori.getSelectedItem()+" "+txt_jmlitem.getText()+" Rp."+tarif.getText()+"\n";
j = j+Integer.parseInt(tarif.getText());
i = Integer.toString(j);
k = k+Integer.parseInt(txt_jmlitem.getText());
m = Integer.toString(k);

area.setText(jml);
totalitem.setText(i);
txt_jumlah.setText(m);

txt_jmlitem.setText("");
tarif.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_b_tambahActionPerformed

    private void txt_jmlitemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jmlitemKeyPressed
if(evt.getKeyCode() == evt.VK_ENTER){
tarif.requestFocus();
tampilkan_total();}        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jmlitemKeyPressed

    private void c_kategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_kategoriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_c_kategoriMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

new T_CetakNota().setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        jDialog2.setVisible(true);
        
        tampilkan_data_transaksi();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jDialog2.hide();
        //b_simpan.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed

        txt_berat.setEnabled(true);
        c_kategori.setEnabled(true);
        txt_jumlah.setEnabled(true);
        r_kiloan.setSelected(false);
        r_item.setSelected(false);
        b_tambah.setEnabled(true);
        area.setEnabled(true);
        txt_jmlitem.setEnabled(true);
        tarif.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_allActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int  b;
        float a, c;
        String d;
        a=Float.parseFloat(totalkg.getText());
        b=Integer.parseInt(totalitem.getText());
        c=a+b;
        d=Float.toString(c);
        txt_total.setText(d);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("no pelanggan");
        tabelmapel.addColumn("nama");
        tabelmapel.addColumn("no hp");
        tabelmapel.addColumn("alamat");
        tabelmapel.addColumn("Tanggal");
       
        try {
            connection = Koneksi.connection();
            String sql = "select * from pelanggan where nama LIKE '"+txt_nama.getText()+"'";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            
            
            
            while (rslt.next()) {
               // Object[] o =new Object[5];
               // o[0] = rslt.getString("no_pelanggan");
               // o[1] = rslt.getString("nama");
               // o[2] = rslt.getString("no_hp");
               // o[3] = rslt.getString("alamat");
               // o[4] = rslt.getString("tanggal");
               // tabelmapel.addRow(o);
                
                txt_npT.setText(rslt.getString("no_pelanggan"));
            }
            
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data pelanggan");
        }
    
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(T_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(T_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(T_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(T_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new T_Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton all;
    private javax.swing.JTextArea area;
    private javax.swing.JButton b_batalT;
    private javax.swing.JButton b_hapusT;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_simpan;
    private javax.swing.JButton b_tambah;
    private javax.swing.JButton b_ubahT;
    private javax.swing.JComboBox c_kategori;
    private javax.swing.JComboBox c_status;
    private javax.swing.JComboBox c_statusb;
    private com.toedter.calendar.JDateChooser d_bayar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JRadioButton r_item;
    private javax.swing.JRadioButton r_kiloan;
    private javax.swing.JTable t_p;
    private javax.swing.JTable tabel_T;
    private javax.swing.JTextField tarif;
    private javax.swing.JLabel tgl;
    private com.toedter.calendar.JDateChooser tgl_masuk;
    private com.toedter.calendar.JDateChooser tgl_selesai;
    private javax.swing.JTextField totalitem;
    private javax.swing.JTextField totalkg;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_berat;
    private javax.swing.JTextField txt_jmlitem;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nota;
    private javax.swing.JTextField txt_npT;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

private void autoNota(){
        try{
            connection = Koneksi.connection();
            String sql = "select max(right(no_nota,3)) as id from transaksi";
            Statement stmt = (Statement) connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                if (rs.first()==false){
                    txt_nota.setText("T-001");
                }else {
                    rs.last();
                    int autoid = rs.getInt(1)+1;
                        String nomor = String.valueOf(autoid);
                        int noLong = nomor.length();
                        
                        for (int a=0;a<3-noLong;a++){
                            nomor = "0" + nomor;
                        }
                        txt_nota.setText("T-"+nomor);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(T_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 private void tampilkan_dataP() {
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("no plgn");
        tabelmapel.addColumn("nama");
        tabelmapel.addColumn("no hp");
        tabelmapel.addColumn("alamat");
        
        try {
            connection = Koneksi.connection();
            String sql = "select * from pelanggan";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                Object[] o =new Object[4];
                o[0] = rslt.getString("no_pelanggan");
                o[1] = rslt.getString("nama");
                o[2] = rslt.getString("no_hp");
                o[3] = rslt.getString("alamat");
                tabelmapel.addRow(o);
            }
            t_p.setModel(tabelmapel);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data pelanggan");
        }
    
        }

 private void tampilkan_data_transaksi() {
                   
        try {
            connection = Koneksi.connection();
            String sql = "select * from data_transaksi where no_nota ='"+txt_nota.getText()+"'";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String h,i,j,k,l;
                
                h = rslt.getString("no_nota");
                j = rslt.getString("berat");
                i = rslt.getString("kategori");
                k = rslt.getString("jumlah");
                l = rslt.getString("total_bayar");
                
                txt_berat.setText(j);
                txt_jumlah.setText(k);
                txt_total.setText(l);
                area.setText(i);
                

                
                }
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data transaksi");
        }
    
        }
 
}
