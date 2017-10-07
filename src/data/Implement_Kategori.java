/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.List;
import model.Kategori;
import model.pelanggan;
/**
 *
 * @author ASUS
 */
public interface Implement_Kategori {
    
    public void insert(Kategori k);
    public void update(Kategori k);
    public void delete(String kategori);
    public List<Kategori> getALL();
    
}
