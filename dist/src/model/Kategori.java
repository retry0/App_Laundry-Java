/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import tampilan.T_Kategori;

/**
 *
 * @author ASUS
 */
public class Kategori {
    
    private String kategori;
    private String tarif;
    
    public String getKategori(){
        return kategori;
    }
    public void setKategori(String ktg){
        this.kategori=ktg;
    }
    public String getTarif(){
        return tarif;
    }
    public void setTarif(String trf){
        this.tarif=trf;
    }
    
}
