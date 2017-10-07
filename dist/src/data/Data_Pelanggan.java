/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

//import connection.Koneksi;
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
import model.pelanggan;
import tampilan.T_PelangganU;
//import tampilan.Tampilan_Cari_Buku;
/**
 *
 * @author ASUS
 */
public class Data_Pelanggan implements Implement_Pelanggan {

    Connection connection;
  final String insert="INSERT INTO pelanggan(no_pelanggan,nama,no_hp,alamat,tanggal) VALUES (?,?,?,?,?);";
  final String update="UPDATE pelanggan SET no_pelanggan=?, nama=?, no_hp=?, alamat=?, tanggal=? where no_pelanggan=?;";
  final String delete="DELETE FROM pelanggan where no_pelanggan=?;";
  //final String cariBuku="SELECT * FROM buku where kategori like ? order by judul;";
  final String select="SELECT * FROM pelanggan;";
  public Data_Pelanggan(){
    connection=Koneksi.connection();}
    
    @Override
    public void insert(pelanggan p) {
        PreparedStatement statement=null;
        try{
            
                statement=connection.prepareStatement(insert);
                statement.setString(1, p.getNP());
                statement.setString(2, p.getNama());
                statement.setString(3, p.getNhp());
                statement.setString(4, p.getAlamat());
                statement.setDate(5, new java.sql.Date( p.getTanggal().getTime()));
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
    public void update(pelanggan p) {
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement(update);
            statement.setString(1, p.getNP());
            statement.setString(2, p.getNama());
            statement.setString(3, p.getNhp());
            statement.setString(4, p.getAlamat());
            statement.setDate(5, new java.sql.Date( p.getTanggal().getTime()));
            statement.setString(6, p.getNP());
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
    public void delete(String no_pelanggan) {
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement(delete);
            statement.setString(1,no_pelanggan);
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
    public List<pelanggan> getALL() {
        List<pelanggan> lp=null;
    try{
        lp=new ArrayList<pelanggan>();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
            pelanggan p=new pelanggan();
            p.setNP(rs.getString("no_pelanggan"));
            p.setNama(rs.getString("nama"));
            p.setNohp(rs.getString("no_hp"));
            p.setAlamat(rs.getString("alamat"));
            p.setTanggal(rs.getDate("tanggal"));
            lp.add(p);
        }
    }catch (SQLException ex){
        Logger.getLogger(Data_Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
}
