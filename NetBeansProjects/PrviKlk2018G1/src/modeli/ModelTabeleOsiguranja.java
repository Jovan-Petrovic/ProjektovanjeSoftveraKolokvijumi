/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Osiguranje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class ModelTabeleOsiguranja extends AbstractTableModel {

    ArrayList<Osiguranje> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleOsiguranja() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Osiguranje o = lista.get(row);
        switch(column) {
            case 0:
                return o.getVozilo();
            case 1:
                return o.getImePrezime();
            case 2:
                return o.getUkupnaPremija();
            case 3:
                return sdf.format(o.getDatumPocetka());
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Vozilo";
            case 1:
                return "Ime prezime";
            case 2:
                return "Ukupna premija";
            case 3:
                return "Pocetak vrste osiguranja";
            default:
                return "n/a";
        }
    }

    public void setLista(ArrayList<Osiguranje> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    
}
