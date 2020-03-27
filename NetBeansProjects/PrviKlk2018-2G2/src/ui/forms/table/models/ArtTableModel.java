/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forms.table.models;

import domain.Art;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fonis
 */
public class ArtTableModel extends AbstractTableModel {

    List<Art> arts;
    String[] columns = new String[]{"No", "ID", "NAME", "AUTHOR", "NUMBERSHOW"};

    public ArtTableModel(List<Art> arts) {
        this.arts = arts;
    }

    @Override
    public int getRowCount() {
        return arts.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Art art = arts.get(rowIndex);
        switch (columnIndex) {
            case 0:
//              ova linija sredjuje brojeve redova  
                return rowIndex+1;
            case 1:
                return art.getId();
            case 2:
                return art.getName();
            case 3:
                return art.getAuthor();
            case 4:
                return art.getNumberOfShows();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        if(column>=0 && column<columns.length){
            return columns[column];
        }
        return "N/A";
    }

//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return false;
//    }
    
    public void addArt(Art art){
        if(arts.contains(art)){
            return;
        }
        this.arts.add(art);
        fireTableDataChanged();
    }

    public Art getArt(int row){
        return arts.get(row);
    }

    public void removeArt(int rowSelected) {
        arts.remove(rowSelected);
        fireTableDataChanged();
    }

    public List<Art> getArts() {
        return arts;
    }
}
