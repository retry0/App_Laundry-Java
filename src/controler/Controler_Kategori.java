/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import data.Data_Kategori;
import data.Implement_Kategori;
import java.util.List;
import javax.swing.JOptionPane;
import model.Kategori;
import model.TabelModelKategori;
import tampilan.T_Kategori;

/**
 *
 * @author ASUS
 */
public class Controler_Kategori {
    
    T_Kategori frame;
    Implement_Kategori implKategori;
    List<Kategori> lk;

    public Controler_Kategori(T_Kategori frame){
        this.frame=frame;
        implKategori=new Data_Kategori();
        lk=implKategori.getALL();
    }
    
    //mengosongkan field
    public void reset(){
	frame.getTxtKategori().setText("");
	frame.getTxttarif().setText("");
        frame.getButtonSimpan().setEnabled(true);

    }
    
    //menampilkan data ke dalam tabel
    public void isiTable(){
	lk=implKategori.getALL();
	TabelModelKategori tmk=new TabelModelKategori(lk);
	frame.getTabelData().setModel(tmk);
}
    
    //fungsi untuk menampilkan data yang dipilih dari tabel
    public void isiField(int row){
	frame.getTxtKategori().setText(lk.get(row).getKategori().toString());
	frame.getTxttarif().setText(lk.get(row).getTarif());

    }
    
    //fungsi untuk insert data
    public void insert(){
	
        if(frame.getTxtKategori().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Kategori masih kosong");
        }
        else if(frame.getTxttarif().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Tarif masih kosong");
        }
        else{
        
        Kategori k=new Kategori();
        
	k.setKategori(frame.getTxtKategori().getText());
	k.setTarif(frame.getTxttarif().getText());
	implKategori.insert(k);
        if(frame.getTxtKategori().getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(frame, "Data gagal disimpan");
    }else{
          JOptionPane.showMessageDialog(frame, "Data berhasil disimpan");
        }
    }
    }
    //fungsi untuk update data berdasarkan inputan dari user
    public void update(){
        
        if(frame.getTxtKategori().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Kategori masih kosong");
        }
        else if(frame.getTxttarif().getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Tarif masih kosong");
        }
        else{
                Kategori k=new Kategori();
        k.setKategori(frame.getTxtKategori().getText());
	k.setTarif(frame.getTxttarif().getText());
	implKategori.update(k);
        JOptionPane.showMessageDialog(frame, "Data berhasil diubah");
    }
    }
    public void delete(){
        if(JOptionPane.showConfirmDialog(frame, "Apakah anda yakin ingin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
	if(!frame.getTxtKategori().getText().trim().isEmpty()){
		String kategori=frame.getTxtKategori().getText();
		implKategori.delete(kategori);
                JOptionPane.showMessageDialog(frame, "Data berhasil dihapus");
                
	}else{
            JOptionPane.showMessageDialog(frame,"Pilih data yang akan dihapus");
	}
    }
    }
    
}
