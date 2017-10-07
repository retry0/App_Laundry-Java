/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;
import data.Data_Pelanggan;
import data.Implement_Pelanggan;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import model.pelanggan;
import model.TabelModelPelanggan;
import tampilan.T_PelangganU;
//import tampilan.Tampilan_Cari_Buku;

/**
 *
 * @author ASUS
 */
public class Controler_Pelanggan {
    
     T_PelangganU frame;
    Implement_Pelanggan implPelanggan;
    List<pelanggan> lp;

    public Controler_Pelanggan(T_PelangganU frame){
        this.frame=frame;
        implPelanggan=new Data_Pelanggan();
        lp=implPelanggan.getALL();
    }
    //mengosongkan field
    public void reset(){
	frame.getTxtNP().setText("");
	frame.getTxtNama().setText("");
	frame.getTxtNhp().setText("");
        frame.getTxtAlmt().setText("");
        frame.getButtonSimpan().setEnabled(true);
        frame.getButtonUbah().setEnabled(false);

    }
    
    //menampilkan data ke dalam tabel
    public void isiTable(){
	lp=implPelanggan.getALL();
	TabelModelPelanggan tmp=new TabelModelPelanggan(lp);
	frame.getTabelData().setModel(tmp);
}
    
    //fungsi untuk menampilkan data yang dipilih dari tabel
    public void isiField(int row){
	frame.getTxtNP().setText(lp.get(row).getNP().toString());
	frame.getTxtNama().setText(lp.get(row).getNama());
	frame.getTxtNhp().setText(lp.get(row).getNhp());
        frame.getTxtAlmt().setText(lp.get(row).getAlamat());

    }
    
    //fungsi untuk insert data
    public void insert(){
	
        if(frame.getTxtNP().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nomor Pelanggan masih kosong");
        }
        else if(frame.getTxtNama().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nama masih kosong");
        }
        else if(frame.getTxtAlmt().getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Alamat masih kosong");
        }

        else{
            
        
        pelanggan p=new pelanggan();
        
	p.setNP(frame.getTxtNP().getText());
	p.setNama(frame.getTxtNama().getText());
	p.setNohp(frame.getTxtNhp().getText());
	p.setAlamat(frame.getTxtAlmt().getText());
        p.setTanggal(Date.valueOf((frame.getTanggal().getText())));
        implPelanggan.insert(p);
        if(frame.getTxtNP().getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(frame, "Data gagal disimpan");
    }else{
          JOptionPane.showMessageDialog(frame, "Data berhasil disimpan");
        }
    }
    }
    //fungsi untuk update data berdasarkan inputan dari user
    public void update(){
        
        if(frame.getTxtNP().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nomor Pelanggan masih kosong");
        }
        else if(frame.getTxtNama().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Nama masih kosong");
        }
        else if(frame.getTxtAlmt().getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Alamat masih kosong");
        }
        else{

                pelanggan p=new pelanggan();
        p.setNP(frame.getTxtNP().getText());
	p.setNama(frame.getTxtNama().getText());
	p.setNohp(frame.getTxtNhp().getText());
	p.setAlamat(frame.getTxtAlmt().getText());
        p.setTanggal(Date.valueOf((frame.getTanggal().getText())));
        implPelanggan.update(p);
        JOptionPane.showMessageDialog(frame, "Data berhasil diubah");
    }
    }
    public void delete(){
        if(JOptionPane.showConfirmDialog(frame, "Apakah anda yakin ingin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
	if(!frame.getTxtNP().getText().trim().isEmpty()){
		String no_pelanggan=frame.getTxtNP().getText();
		implPelanggan.delete(no_pelanggan);
                JOptionPane.showMessageDialog(frame, "Data berhasil dihapus");
                
	}else{
            JOptionPane.showMessageDialog(frame,"Pilih data yang akan dihapus");
	}
    }
    }
    
}
