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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import tampilan.T_Transaksi;
/**
 *
 * @author ASUS
 */
public class Transaksi {
    
    private String no_nota;
    private String no_pelanggan;
    private Date tgl_masuk;
    private Date tgl_selesai;
    private Date tgl_bayar;
    private String c_status;
    private String kategori;
    private String berat;
    private String jumlah;
    private String total;
    private String bayar;
    private String kembali;
    private String statusb;
    
    
     public String getNota(){
        return no_nota;
    }
    public void setNota(String nt){
        this.no_nota=nt;
    }
    public String getNP(){
        return no_pelanggan;
    }
    public void setNP(String np){
        this.no_pelanggan=np;
    }
    public Date getTglmsk(){
        return tgl_masuk;
    }
    public void setTglmsk(Date msk){
        this.tgl_masuk=msk;
    }
    public Date getTglbyr(){
        return tgl_bayar;
    }
    public void setTglbyr(Date byr){
        this.tgl_bayar=byr;
    }
    public Date getTglsls(){
        return tgl_selesai;
    }
    public void setTglsls(Date sls){
        this.tgl_selesai=sls;
    }
    public String getStatus(){
        return c_status;
    }
    public void setStatus(String status){
        this.c_status = status;
    }
    public String getStatusb(){
        return statusb;
    }
    public void setStatusb(String statusb){
        this.statusb = statusb;
    }
    public String getKategori(){
        return kategori;
    }
    public void setKategori(String ktg){
        this.kategori = ktg;
    }
    public String getBerat(){
        return berat;
    }
    public void setBerat(String brt){
        this.berat=brt;
    }
     public String getJumlah(){
        return jumlah;
    }
    public void setJumlah(String jml){
        this.jumlah=jml;
    }
     public String getTotal(){
        return total;
    }
    public void setTotal(String ttl){
        this.total=ttl;
    }
     public String getBayar(){
        return bayar;
    }
    public void setBayar(String byr){
        this.bayar=byr;
    }
     public String getKembali(){
        return kembali;
    }
    public void setKembali(String kmbli){
        this.kembali=kmbli;
    }

    
}
