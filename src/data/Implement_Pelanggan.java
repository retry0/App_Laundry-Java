/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.List;
import model.pelanggan;
/**
 *
 * @author ASUS
 */
public interface Implement_Pelanggan {
    
    public void insert(pelanggan p);
    public void update(pelanggan p);
    public void delete(String no_pelanggan);
    public List<pelanggan> getALL();
   // public List<Buku>getCariBuku(String Buku);
}
