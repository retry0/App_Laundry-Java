/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import connection.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Transaksi;
import tampilan.T_Transaksi;

/**
 *
 * @author ASUS
 */
public class Data_Transaksi implements Implement_Transaksi {

    Connection connection;
  final String insert="INSERT INTO transaksi(no_nota,no_pelanggan,tgl_masuk,tgl_selesai,status,status_bayar,tgl_bayar) VALUES (?,?,?,?,?,?,?);";
  final String insertdt="INSERT INTO data_transaksi(no_nota,berat,kategori,jumlah,total_bayar) VALUES (?,?,?,?,?);";
  final String update="UPDATE transaksi SET no_nota=?, no_pelanggan=?, tgl_masuk=?, tgl_selesai=?, status=?, status_bayar=?, tgl_bayar=? where no_nota=?;";
  final String delete="DELETE FROM transaksi where no_nota=?;";
  //final String delete="DELETE FROM transaksi where no_nota=?;";
  final String select="SELECT * FROM transaksi;";
  final String selectdt="SELECT * FROM data_transaksi;";
  public Data_Transaksi(){
    connection=Koneksi.connection();}
    
    @Override
    public void insert(Transaksi t) {
         PreparedStatement statement=null;
        try{
            
                statement=connection.prepareStatement(insert);
                statement.setString(1, t.getNota());
                statement.setString(2, t.getNP());
                statement.setDate(3,new java.sql.Date( t.getTglmsk().getTime()));
                statement.setDate(4,new java.sql.Date( t.getTglsls().getTime()));
                statement.setString(5, t.getStatus());
                statement.setString(6, t.getStatusb());
                statement.setDate(7,new java.sql.Date( t.getTglbyr().getTime()));
                statement.executeUpdate();
           
        }catch (SQLException ex){
                    ex.printStackTrace();
        }finally{
                try{
                    statement.close();
                }catch (SQLException ex){
                    ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Transaksi t) {
       PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement(update);
            statement.setString(1, t.getNota());
            statement.setString(2, t.getNP());
            statement.setDate(3,new java.sql.Date( t.getTglmsk().getTime()));
            statement.setDate(4,new java.sql.Date( t.getTglsls().getTime()));
            statement.setString(5, t.getStatus());
            statement.setString(6, t.getStatusb());
            statement.setDate(7,new java.sql.Date(t.getTglbyr().getTime()));
            statement.setString(8, t.getNota());
            statement.executeUpdate();
        }catch (SQLException ex){
        ex.printStackTrace();

        }finally{
            try{
            statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String no_nota) {
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement(delete);
            statement.setString(1,no_nota);
            statement.executeUpdate();
        }catch(SQLException ex){
        ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Transaksi> getALL() {
                List<Transaksi> lt=null;
    try{
        lt=new ArrayList<Transaksi>();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
            Transaksi t=new Transaksi();
            t.setNota(rs.getString("no_nota"));
            t.setNP(rs.getString("no_pelanggan"));
            t.setTglmsk(rs.getDate("tgl_masuk"));
            t.setTglsls(rs.getDate("tgl_selesai"));
            t.setStatus(rs.getString("status"));
            t.setStatusb(rs.getString("status_bayar"));
            t.setTglbyr(rs.getDate("tgl_bayar"));
            lt.add(t);
        }
    }catch (SQLException ex){
        Logger.getLogger(Data_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;
    }

    @Override
    public void insertDT(Transaksi t) {
        PreparedStatement statement=null;
        try{
            
                statement=connection.prepareStatement(insertdt);
                statement.setString(1, t.getNota());
                statement.setString(2, t.getBerat());
                statement.setString(3,t.getKategori());
                statement.setString(4,t.getJumlah());
                statement.setString(5, t.getTotal());
                statement.executeUpdate();
           
        }catch (SQLException ex){
                    ex.printStackTrace();
        }finally{
                try{
                    statement.close();
                }catch (SQLException ex){
                    ex.printStackTrace();
            }
        }  
    }

    @Override
    public List<Transaksi> getALLDT() {
    List<Transaksi> lt=null;
    try{
        lt=new ArrayList<Transaksi>();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(selectdt);
        while(rs.next()){
            Transaksi t=new Transaksi();
            t.setNota(rs.getString("no_nota"));
            t.setBerat(rs.getString("berat"));
            t.setKategori(rs.getString("kategori"));
            t.setJumlah(rs.getString("jumlah"));
            t.setTotal(rs.getString("total_bayar"));
            lt.add(t);
        }
    }catch (SQLException ex){
        Logger.getLogger(Data_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;    
    }
    
}
