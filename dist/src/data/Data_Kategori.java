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
import model.Kategori;
import tampilan.T_Kategori;
/**
 *
 * @author ASUS
 */
public class Data_Kategori implements Implement_Kategori {
    
    Connection connection;
  final String insert="INSERT INTO kategori(kategori,tarif) VALUES (?,?);";
  final String update="UPDATE kategori SET kategori=?, tarif=? where kategori=?;";
  final String delete="DELETE FROM kategori where kategori=?;";
  //final String cariBuku="SELECT * FROM buku where kategori like ? order by judul;";
  final String select="SELECT * FROM kategori;";
  public Data_Kategori(){
    connection=Koneksi.connection();}

    @Override
    public void insert(Kategori k) {
        PreparedStatement statement=null;
        try{
            
                statement=connection.prepareStatement(insert);
                statement.setString(1, k.getKategori());
                statement.setString(2, k.getTarif());
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
    public void update(Kategori k) {
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement(update);
            statement.setString(1, k.getKategori());
            statement.setString(2, k.getTarif());
            statement.setString(3, k.getKategori());
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
    public void delete(String kategori) {
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement(delete);
            statement.setString(1,kategori);
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
    public List<Kategori> getALL() {
        List<Kategori> lk=null;
    try{
        lk=new ArrayList<Kategori>();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
            Kategori k=new Kategori();
            k.setKategori(rs.getString("kategori"));
            k.setTarif(rs.getString("tarif"));
            lk.add(k);
        }
    }catch (SQLException ex){
        Logger.getLogger(Data_Kategori.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lk;
    }
    }
    

