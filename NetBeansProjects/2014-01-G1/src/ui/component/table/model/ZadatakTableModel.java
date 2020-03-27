/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.TZadatak;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.Controller;

/**
 *
 * @author Bron Zilar
 */
public class ZadatakTableModel extends AbstractTableModel {

    private final List<TZadatak> zadaci;
    private String[] columnNames = new String[]{"Sifra zadatka", "Naziv", "Opis", "Datum", "Ime radnika", "Prezime radnika"};

    public ZadatakTableModel(List<TZadatak> zadaci) {
        this.zadaci = zadaci;
    }
    
    
    
    @Override
    public int getRowCount() {
        if(zadaci==null)
            return 0;
        return zadaci.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        TZadatak zadatak = zadaci.get(row);
        switch(column) {
            case 0:
                return zadatak.getSifraZadatka();
            case 1:
                return zadatak.getNaziv();
            case 2:
                return zadatak.getOpis();
            case 3:
                return zadatak.getDatum();
            case 4:
                return zadatak.getZaposleni().getIme();
            case 5:
                return zadatak.getZaposleni().getPrezime();
            default:
                return "n/a";
        }
    }
    
    public void addZadatak(TZadatak zadatak) {
        Controller.getInstance().getAllZadaci().add(zadatak);
        fireTableDataChanged();
    }
}
