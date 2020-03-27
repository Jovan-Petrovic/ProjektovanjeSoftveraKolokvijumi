/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.TZadatak;
import domain.TZaposleni;
import java.util.List;
import storage.StorageMemoryZadatak;
import storage.StorageMemoryZaposleni;

/**
 *
 * @author Bron Zilar
 */
public class Controller {
     private static  Controller instance;
     private final StorageMemoryZadatak storageMemoryZadatak;
     private final StorageMemoryZaposleni storageMemoryZaposleni;

    public Controller() {
        storageMemoryZadatak = new StorageMemoryZadatak();
        storageMemoryZaposleni = new StorageMemoryZaposleni();
    }
     
    public static Controller getInstance() {
        if(instance==null)
            instance = new Controller();
        return instance;
    }

    public List<TZadatak> getAllZadaci() {
        return storageMemoryZadatak.getAll();
    }
     
    public  List<TZaposleni> getAllZaposleni() {
        return storageMemoryZaposleni.getAll();
    }
    
    public void saveZadatak(TZadatak zadatak) {
        storageMemoryZadatak.save(zadatak);
    }
}
