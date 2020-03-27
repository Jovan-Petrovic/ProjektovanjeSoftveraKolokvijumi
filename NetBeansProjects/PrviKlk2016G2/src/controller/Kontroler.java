/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DBBroker;
import domain.Lokacija;
import domain.Radnik;
import domain.Raspored;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Kontroler {
    private static Kontroler instanca;
    private final DBBroker db;
    

    public Kontroler() {
        db = new DBBroker();
    }
    
    

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }

    public List<Lokacija> vratiSveLokacije() throws Exception {
        List<Lokacija> lokacije = new ArrayList();
        db.otvoriKonekciju();
        lokacije = db.vratiSveLokacije();
        db.zatvoriKonekciju();
        return lokacije;
    }

    public List<Radnik> vratiSveRadnike() throws Exception {
        List<Radnik> radnici = new ArrayList();
        db.otvoriKonekciju();
        radnici = db.vratiSveRadnike();
        db.zatvoriKonekciju();
        return radnici;
    }

    public boolean sacuvaj(List<Raspored> rasporedi) {
        boolean sacuvano = false;
        db.otvoriKonekciju();
        int idMaksRaspored = db.vratiMax();
        try {
            for (Raspored raspored : rasporedi) {            
                db.sacuvajJedanRaspored(raspored,idMaksRaspored);
                idMaksRaspored++;
            }
             db.commit();
             sacuvano = true;
        } catch (SQLException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                db.rollback();
                sacuvano = false;
        }
       
        db.zatvoriKonekciju();
        return sacuvano;
    }

    

    
    
    
}
