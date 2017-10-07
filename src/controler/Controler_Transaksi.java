/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;
import data.Data_Transaksi;
import data.Implement_Transaksi;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import model.TabelModelDataTransaksi;
import model.Transaksi;
import model.TabelModelTransaksi;
import tampilan.T_Transaksi;
//import tampilan.T_PelangganU;
/**
 *
 * @author ASUS
 */
public class Controler_Transaksi {
    
    T_Transaksi frame;
    Implement_Transaksi implT;
    List<Transaksi> lt;
    List<Transaksi> ltdt;

    public Controler_Transaksi(T_Transaksi frame){
        this.frame=frame;
        implT=new Data_Transaksi();
        lt=implT.getALL();
    }
    //mengosongkan field
    public void reset(){
	frame.getTxtNota().setText("");
	frame.getTxtNpT().setText("");
	frame.getCStatus().setSelectedIndex(0);
        frame.getTxtberat().setText("0");
        frame.getCKategori().setSelectedIndex(0);
	frame.getTxtjumlah().setText("0");
	frame.getTxttotal().setText("");
        frame.getTxtbayar().setText("");
	frame.getTxtkembali().setText("");
        frame.getArea().setText("");
        frame.getDateMasuk().setDate(null);
        frame.getDateBayar().setDate(null);
        frame.getDateSelesai().setDate(null);
        frame.getTxtberat().setEnabled(false);
        frame.getCKategori().setEnabled(false);
        frame.getTxtjumlah().setEnabled(false);
        frame.getRKg().setSelected(false);
        frame.getRI().setSelected(false);
        frame.getAll().setSelected(false);
        frame.getArea().setEnabled(false);
        frame.getTxtjmlitem().setEnabled(false);
        frame.getTxttarif().setEnabled(false);
        frame.getButtonTambah().setEnabled(false);
        frame.getButtonSimpan().setEnabled(true);
        frame.getButtonUbah().setEnabled(false);

    }
    
    //menampilkan data ke dalam tabel
    public void isiTable(){
	lt=implT.getALL();
	TabelModelTransaksi tmt=new TabelModelTransaksi(lt);
	frame.getTabelT().setModel(tmt);
}
    
   // public void isiTabledt(){
	//ltdt=implT.getALLDT();
	//TabelModelDataTransaksi tmdt=new TabelModelDataTransaksi(ltdt);
	//frame.getTabelDT().setModel(tmdt);
//}
    
    //fungsi untuk menampilkan data yang dipilih dari tabel
    public void isiField(int row){
	frame.getTxtNota().setText(lt.get(row).getNota().toString());
	frame.getTxtNpT().setText(lt.get(row).getNP());
	frame.getDateMasuk().setDate(lt.get(row).getTglmsk());
        frame.getDateSelesai().setDate(lt.get(row).getTglsls());
        frame.getCStatus().setSelectedItem(lt.get(row).getStatus());
	frame.getCStatusb().setSelectedItem(lt.get(row).getStatusb());
	frame.getDateBayar().setDate(lt.get(row).getTglbyr());

    }
    
    //fungsi untuk insert data
    public void insert(){

        
        if(frame.getTxtNota().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nomor Nota masih kosong");
        }
        else if(frame.getTxtNpT().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nomor Pelanggan masih kosong");
        }

        else{
String tampilan = "yyyy-M-dd";

SimpleDateFormat format = new SimpleDateFormat(tampilan);
       
        
        Transaksi t=new Transaksi();
        
	t.setNota(frame.getTxtNota().getText());
	t.setNP(frame.getTxtNpT().getText());
        t.setTglmsk(Date.valueOf(format.format(frame.getDateMasuk().getDate())));
        t.setTglsls(Date.valueOf(format.format(frame.getDateSelesai().getDate())));
	t.setStatus((String)frame.getCStatus().getSelectedItem());
	t.setStatusb((String)frame.getCStatusb().getSelectedItem());
        t.setTglbyr(Date.valueOf(format.format(frame.getDateBayar().getDate())));
        implT.insert(t);
        if(frame.getTxtNota().getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(frame, "Data gagal disimpan");
    }else{
          JOptionPane.showMessageDialog(frame, "Data berhasil disimpan");
        }
    
    }
    }
    //fungsi untuk update data berdasarkan inputan dari user
    public void update(){
        
    String tampilan = "yyyy-M-dd";

SimpleDateFormat format = new SimpleDateFormat(tampilan);
        
        Transaksi t=new Transaksi();
        t.setNota(frame.getTxtNota().getText());
	t.setNP(frame.getTxtNpT().getText());
        t.setTglmsk(Date.valueOf(format.format(frame.getDateMasuk().getDate())));
        t.setTglsls(Date.valueOf(format.format(frame.getDateSelesai().getDate())));
	t.setStatus((String)frame.getCStatus().getSelectedItem());
	t.setStatusb((String)frame.getCStatusb().getSelectedItem());
        t.setTglbyr(Date.valueOf(format.format(frame.getDateBayar().getDate())));
        implT.update(t);
        JOptionPane.showMessageDialog(frame, "Data berhasil diubah");
    
    }
    public void delete(){
        if(JOptionPane.showConfirmDialog(frame, "Apakah anda yakin ingin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
	if(!frame.getTxtNota().getText().trim().isEmpty()){
		String no_nota=frame.getTxtNota().getText();
		implT.delete(no_nota);
                JOptionPane.showMessageDialog(frame, "Data berhasil dihapus");
                
	}else{
            JOptionPane.showMessageDialog(frame,"Pilih data yang akan dihapus");
	}
    }
    }
    
     public void insertdt(){

        
        if(frame.getTxtNota().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nomor Nota masih kosong");
        }
        else if(frame.getTxtNpT().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nomor Pelanggan masih kosong");
        }

        else{
          
        Transaksi t=new Transaksi();
        
	t.setNota(frame.getTxtNota().getText());
	t.setBerat(frame.getTxtberat().getText());
        t.setKategori((frame.getArea().getText()));
        t.setJumlah(frame.getTxtjumlah().getText());
	t.setTotal((frame.getTxttotal().getText()));
        implT.insertDT(t);
        if(frame.getTxtNota().getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(frame, "Data Transaksi gagal disimpan");
    }else{
          JOptionPane.showMessageDialog(frame, "Data Transaksi berhasil disimpan");
        }
    
    }
    }
    
}
