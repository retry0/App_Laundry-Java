/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import java.util.List;
import model.Transaksi;
import model.pelanggan;

/**
 *
 * @author ASUS
 */
public interface Implement_Transaksi {
    public void insert(Transaksi t);
    public void insertDT(Transaksi t);
    public void update(Transaksi t);
    public void delete(String no_nota);
    public List<Transaksi> getALL();
    public List<Transaksi> getALLDT();
}
