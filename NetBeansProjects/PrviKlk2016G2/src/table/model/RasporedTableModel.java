/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table.model;

import domain.Raspored;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class RasporedTableModel extends AbstractTableModel {
    List<Raspored> rasporedi;
    String[] columns = new String[]{"Lokacija","Ime i prezime","Broj sati","Datum"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public RasporedTableModel() {
        rasporedi = new ArrayList<>();
    }

    public RasporedTableModel(List<Raspored> rasporedi) {
        this.rasporedi = rasporedi;
    }
      
    @Override
    public int getRowCount() {
        return rasporedi.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Raspored raspored = rasporedi.get(row);
        switch(column) {
            case 0:
                return raspored.getLokacija().getNaziv();
            case 1:
                return raspored.getRadnik().getIme()+" "+raspored.getRadnik().getPrezime();
            case 2:
                return raspored.getBrojSati();
            case 3:
                return sdf.format(raspored.getDatum());            
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public void dodaj(Raspored raspored) {
        rasporedi.add(raspored);
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        rasporedi.remove(red);
        fireTableDataChanged();
    }

    public List<Raspored> getRasporedi() {
        return rasporedi;
    }
    
    
    
}
