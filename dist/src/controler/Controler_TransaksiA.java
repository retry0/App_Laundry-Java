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
import model.TabelModelTransaksi;
import model.Transaksi;
import tampilan.T_TransaksiA;

/**
 *
 * @author ASUS
 */
public class Controler_TransaksiA {
    
        T_TransaksiA frame;
    Implement_Transaksi implT;
    List<Transaksi> lt;

    public Controler_TransaksiA(T_TransaksiA frame){
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
	frame.getTxtjumlah().setText("0");
	frame.getTxttotal().setText("");
        frame.getArea().setText("");
        frame.getDateMasuk().setDate(null);
        frame.getDateSelesai().setDate(null);
        frame.getTxtberat().setEditable(false);
        frame.getTxtjumlah().setEditable(false);
        frame.getArea().setEditable(false);
        frame.getButtonHapusBulan().setEnabled(false);
        frame.getButtonHapus().setEnabled(true);
        isiTable();



    }
    
    //menampilkan data ke dalam tabel
    public void isiTable(){
	lt=implT.getALL();
	TabelModelTransaksi tmt=new TabelModelTransaksi(lt);
	frame.getTabelT().setModel(tmt);
}
    
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
    
    public void delete(){
        if(JOptionPane.showConfirmDialog(frame, "Apakah anda yakin ingin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
	if(!frame.getTxtNota().getText().trim().isEmpty()){
		String no_nota=frame.getTxtNota().getText();
		implT.delete(no_nota);
                JOptionPane.showMessageDialog(frame, "Data berhasil dihapus");
                
	}else{
            JOptionPane.showMessageDialog(frame,"Pilih data yang akan dihapus");
	}
    }
    }
}
