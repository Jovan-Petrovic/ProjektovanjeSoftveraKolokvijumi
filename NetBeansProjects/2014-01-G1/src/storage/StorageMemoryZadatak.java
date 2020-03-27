/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.TZadatak;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class StorageMemoryZadatak {
    private final List<TZadatak> zadaci;

    public StorageMemoryZadatak() {
        zadaci = new ArrayList<>();
    }
    
    public List<TZadatak> getAll() {
        return zadaci;
    }
    
    public void save(TZadatak zadatak) {
        zadaci.add(zadatak);
    }
}
