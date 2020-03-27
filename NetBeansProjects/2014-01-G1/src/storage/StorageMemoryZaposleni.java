/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.TZaposleni;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Bron Zilar
 */
public class StorageMemoryZaposleni {
    private final List<TZaposleni> zaposleni;

    public StorageMemoryZaposleni() {
        zaposleni = new ArrayList() {
            {
                add(new TZaposleni("SIF-1", "Marko", "Markovic"));
                add(new TZaposleni("SIF-2", "Marko", "Sreckovic"));
                add(new TZaposleni("SIF-3", "Jovan", "Jovanovic"));
            }
        };
    }
    
    public List<TZaposleni> getAll() {
        return zaposleni;
    }
}
