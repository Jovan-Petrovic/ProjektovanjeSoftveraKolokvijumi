/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.VrstaOsiguranja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class ModelTabeleVrsta extends AbstractTableModel {
    
    ArrayList<VrstaOsiguranja> vrste;

    public ModelTabeleVrsta() {
        vrste = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return vrste.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        VrstaOsiguranja vo = vrste.get(row);
        
        switch(column) {
            case 0: 
                return vo.getNaziv();
            case 1:
                return vo.getCena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: 
                return "Naziv";
            case 1:
                return "Cena";
            default:
                return "n/a";
        }
    }

    public ArrayList<VrstaOsiguranja> getVrste() {
        return vrste;
    }
    
    public void dodaj(VrstaOsiguranja vo) {
        if(!vrste.contains(vo)) {
            vrste.add(vo);
            fireTableDataChanged();
        }
    }

    public void obrisi(int red) {
        vrste.remove(red);
        fireTableDataChanged();
    }

}
