/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Korisnik;
import domen.Osiguranje;
import domen.Vozilo;
import domen.VrstaOsiguranja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Kontroler {
    private static Kontroler instanca;
    ArrayList<Korisnik> listaKorisnika;
    ArrayList<VrstaOsiguranja> listaVrsteOsiguranja;
    DBBroker db;
    
    public Kontroler() {
        db = new DBBroker();
        
        listaKorisnika = new ArrayList<>();
        listaKorisnika.add(new Korisnik("Jovan Petrovic", "jovan", "jovan"));
        listaKorisnika.add(new Korisnik("Stevan Radovanovic", "stevan", "stevan"));
        listaKorisnika.add(new Korisnik("Nikola Colic", "nikola", "nikola"));
        listaKorisnika.add(new Korisnik("Matija Radicevic", "matija", "matija"));
        
        listaVrsteOsiguranja = new ArrayList<>();
        listaVrsteOsiguranja.add(new VrstaOsiguranja(1, "Obazvezno osiguranje", 100));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(2, "Mini kasko", 150));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(3, "Kasko", 200));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(4, "Pomoc na putu RS", 250));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(5, "Pomoc na putu ne RS", 300));
        
    }
    
    public static Kontroler getInstanca() {
        if(instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ArrayList<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }
    
    public Korisnik login(Korisnik korisnikSaForme) {
        for(Korisnik korisnik : listaKorisnika) {
            if(korisnik.equals(korisnikSaForme)) {
                return korisnik;
            }
        }
        return null;
    }

    public ArrayList<Vozilo> vratiVozila() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Vozilo> lista = db.vratiVozila();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public ArrayList<VrstaOsiguranja> getListaVrsteOsiguranja() {
        return listaVrsteOsiguranja;
    }

    public boolean sacuvajOsiguranje(Osiguranje o) {
        boolean uspesno = false; 
        db.ucitajDrajver();
        db.otvoriKonekciju();
        try {
            db.sacuvaj(o);
            db.commit();
            uspesno = true;
            System.out.println("Jej");
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            db.rollback();
        }
        db.zatvoriKonekciju();
        return uspesno;
    }

    public ArrayList<Osiguranje> vratiOsiguranja(Vozilo vozilo) {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Osiguranje> lista = db.vratiOsiguranja(vozilo);
        db.zatvoriKonekciju();
        
        return lista;
    }

}
