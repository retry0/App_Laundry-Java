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
public class TabelModelPelanggan extends AbstractTableModel {
    
     List<pelanggan> lp;
    public TabelModelPelanggan(List<pelanggan> lp){
        this.lp=lp;
    }

    @Override
    public int getRowCount() {
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
        case 0 : return "No Plgn";
        case 1 : return "Nama";
        case 2 : return "No HP";
        case 3 : return "Alamat";
        case 4 : return "Tanggal";
        default : return null; 
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
        case 0 : return lp.get(row).getNP();
        case 1 : return lp.get(row).getNama();
        case 2 : return lp.get(row).getNhp();
        case 3 : return lp.get(row).getAlamat();
        case 4 : return lp.get(row).getTanggal();
        default : return null;     
        }
    }
    
}
