/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Klijent;
import domen.Predmet;
import domen.VrstaPostupka;
import helper.DBHelper;
import helper.Konstante;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class DBBroker {
    Connection konekcija;
    DBHelper dbHelper;

    public DBBroker() {
        try {
            dbHelper = new DBHelper();
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ucitajDrajver() throws ClassNotFoundException {
        Class.forName(dbHelper.vratiVrednost(Konstante.DRIVER));
    }
    
    public void otvoriKonekciju() throws SQLException {
        String url = dbHelper.vratiVrednost(Konstante.URL);
        String user = dbHelper.vratiVrednost(Konstante.USER);
        String pass = dbHelper.vratiVrednost(Konstante.PASS);
        
        konekcija = DriverManager.getConnection(url, user, pass);
        konekcija.setAutoCommit(false);
    }
    
    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }
    
    public void commit() throws SQLException {
        konekcija.commit();
    }
    
    public void rollback() throws SQLException {
        konekcija.rollback();
    }

    public ArrayList<Klijent> vratiKlijente() throws SQLException {
        ArrayList<Klijent> lista = new ArrayList<>();
        String upit = "select * from klijent order by Prezime asc";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while(rs.next()) {
            int klijentID = rs.getInt("KlijentID");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String telefon = rs.getString("Telefon");
            String elPosta = rs.getString("ElPosta");
            String adressa = rs.getString("Adresa");
            
            Klijent k = new Klijent(klijentID, ime, prezime, elPosta, telefon, adressa);
            lista.add(k);
        }
        rs.close();
        s.close();
        return lista;
    }

    public ArrayList<VrstaPostupka> vratiPostupke() throws SQLException {
        ArrayList<VrstaPostupka> lista = new ArrayList<>();
        String upit = "select * from vrstapostupka order by Naziv asc";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while(rs.next()) {
            int vpID = rs.getInt("VrstaPostupkaID");
            String naziv = rs.getString("Naziv");
            VrstaPostupka vp = new VrstaPostupka(vpID, naziv);
            lista.add(vp);
        }
        rs.close();
        s.close();
        return lista;
    }

    public void sacuvajPredmet(Predmet predmet) throws SQLException {
        String upit = "insert into predmet(PredmetID,Naziv,Problem,Datum,Advokat,KlijentID,VrstaPostupkaID) values(?,?,?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, vratiMaxID());
        ps.setString(2, predmet.getNaziv());
        ps.setString(3, predmet.getProblem());
        ps.setDate(4, new Date(predmet.getDatum().getTime()));
        ps.setString(5, predmet.getAdvokat().getUsername());
        ps.setInt(6, predmet.getK().getKlijentID());
        ps.setInt(7, predmet.getVp().getVrstaPostupkaID());
        
        ps.executeUpdate();
        
        ps.close();
    }

    private int vratiMaxID() throws SQLException {
        int max = 0;
        String upit = "select max(predmetID) as max from predmet";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while(rs.next()) {
            max = rs.getInt("max");
        }
        return ++max;
    }
}
