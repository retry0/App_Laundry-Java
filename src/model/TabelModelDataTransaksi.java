/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class TabelModelDataTransaksi extends AbstractTableModel {
    
    List<Transaksi> lt;
    public TabelModelDataTransaksi(List<Transaksi> lt){
        this.lt=lt;
    }

   @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
        case 0 : return "No Nota";
        case 1 : return "Berat";
        case 2 : return "Kategori";
        case 3 : return "Jumlah";
        case 4 : return "Total Byr";
        default : return null; 
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
         switch(column){
        case 0 : return lt.get(row).getNota();
        case 1 : return lt.get(row).getBerat();
        case 2 : return lt.get(row).getKategori();
        case 3 : return lt.get(row).getJumlah();
        case 4 : return lt.get(row).getTotal();
        default : return null;     
        }
    }
    
}
