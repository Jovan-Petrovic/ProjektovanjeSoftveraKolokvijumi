/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Advokat;
import domen.Klijent;
import domen.Predmet;
import domen.VrstaPostupka;
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
    ArrayList<Advokat> listaAdvokataUKomori;
    DBBroker db;
    
    private Kontroler() {
        listaAdvokataUKomori = new ArrayList<>();
        Advokat jovan = new Advokat("Jovan", "Petrovic", "jovan", "jovan", "Vanparnicni postupak");
        Advokat stevan = new Advokat("Stevan", "Radovanovic", "stevan", "stevan", "Parnicni postupak");
        Advokat matija = new Advokat("Jovan", "Petrovic", "jovan", "jovan", "Izvrsni postupak");
        listaAdvokataUKomori.add(jovan);
        listaAdvokataUKomori.add(stevan);
        listaAdvokataUKomori.add(matija);
        
        db = new DBBroker();
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }

    public Advokat proveriAdvokata(String username, String password) {
        for (Advokat advokat : listaAdvokataUKomori) {
            if(advokat.getUsername().equals(username) && advokat.getPassword().equals(password)) {
                return advokat;
            }
        }
        return null;
    }

    public ArrayList<Klijent> dajMiListuKlijenata() {
        ArrayList<Klijent> lista = new ArrayList<>();
        try {
            db.ucitajDrajver();
            db.otvoriKonekciju();
            lista = db.vratiKlijente();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                db.zatvoriKonekciju();
            } catch (SQLException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<VrstaPostupka> vratiListuPostupaka() {
        ArrayList<VrstaPostupka> lista = new ArrayList<>();
        try {           
            db.ucitajDrajver();
            db.otvoriKonekciju();
            lista = db.vratiPostupke();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                db.zatvoriKonekciju();
            } catch (SQLException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public boolean sacuvajSve(ArrayList<Predmet> lista) {
        boolean sacuvano = false;
        
        try {
            db.ucitajDrajver();
            db.otvoriKonekciju();
            for (Predmet predmet : lista) {
                db.sacuvajPredmet(predmet);               
            }
            db.commit();
            sacuvano = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            try {
                db.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            try {
                db.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                db.zatvoriKonekciju();
            } catch (SQLException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sacuvano;
    }
    
    
}
