/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import tampilan.T_PelangganU;
/**
 *
 * @author ASUS
 */
public class pelanggan {
    
     private String no_pelanggan;
    private String nama;
    private String no_hp;
    private String alamat;
    private Date tanggal;
    
     public String getNP(){
        return no_pelanggan;
    }
    public void setNP(String np){
        this.no_pelanggan=np;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nm){
        this.nama=nm;
    }
    public String getNhp(){
        return no_hp;
    }
    public void setNohp(String hp){
        this.no_hp=hp;
    }
    public String getAlamat(){
        return alamat;
    }
    public void setAlamat(String almt){
        this.alamat = almt;
    }
    public Date getTanggal(){
        return tanggal;
    }
    public void setTanggal(Date tgl){
        this.tanggal = tgl;
    }
    
}
