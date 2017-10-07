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
public class TabelModelKategori extends AbstractTableModel {
    
    List<Kategori> lk;
    public TabelModelKategori(List<Kategori> lk){
        this.lk=lk;
    }

    @Override
    public int getRowCount() {
        return lk.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
        case 0 : return "Kategori";
        case 1 : return "Tarif";
        default : return null; 
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
        case 0 : return lk.get(row).getKategori();
        case 1 : return lk.get(row).getTarif();
        default : return null;     
        }
    }
    
}
