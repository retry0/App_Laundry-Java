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
public class TabelModelTransaksi extends AbstractTableModel {

    List<Transaksi> lt;
    public TabelModelTransaksi(List<Transaksi> lt){
        this.lt=lt;
    }
    
    @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
        case 0 : return "No Nota";
        case 1 : return "No Plgn";
        case 2 : return "Tgl Masuk";
        case 3 : return "Tgl Selesai";
        case 4 : return "Status";
        case 5 : return "Status Byr";
        case 6 : return "Tgl Bayar";
        default : return null; 
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
         switch(column){
        case 0 : return lt.get(row).getNota();
        case 1 : return lt.get(row).getNP();
        case 2 : return lt.get(row).getTglmsk();
        case 3 : return lt.get(row).getTglsls();
        case 4 : return lt.get(row).getStatus();
        case 5 : return lt.get(row).getStatusb();
        case 6 : return lt.get(row).getTglbyr();
        default : return null;     
        }
    }
    
}
