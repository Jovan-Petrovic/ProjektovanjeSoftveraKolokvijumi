/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Osiguranje;
import domen.Vozilo;
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
    private Connection konekcija;
    
    public void ucitajDrajver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void otvoriKonekciju() {
        try {
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/prviklk2018g1", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Vozilo> vratiVozila() {
        ArrayList<Vozilo> lista =  new ArrayList<>();
        try {
            String upit = "select * from vozilo order by prezime asc";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while(rs.next()) {
                lista.add(new Vozilo(rs.getInt("sifraVozila"),rs.getString("regBroj"),rs.getInt("godinaProizvodnje"),rs.getString("ime"),rs.getString("prezime")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void sacuvaj(Osiguranje o) throws SQLException {
        String upit = "insert into osiguranje(sifraVozila,datumPocetka,datumUnosa,imePrezime,ukupnaPremija) values (?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, o.getVozilo().getSifraVozila());
        ps.setDate(2, new Date(o.getDatumPocetka().getTime()));
        ps.setDate(3, new Date(o.getDatumUnosa().getTime()));
        ps.setString(4, o.getImePrezime());
        ps.setDouble(5, o.getUkupnaPremija());
        
        ps.executeUpdate();
    }

    public ArrayList<Osiguranje> vratiOsiguranja(Vozilo vozilo) {
        ArrayList<Osiguranje> lista =  new ArrayList<>();
        try {
            String upit = "select * from osiguranje o join vozilo v on o.sifraVozila = v.sifraVozila where v.sifraVozila = " + vozilo.getSifraVozila() + " order by o.datumPocetka desc";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while(rs.next()) {
                Vozilo v = new Vozilo(rs.getInt("sifraVozila"),rs.getString("regBroj"),rs.getInt("godinaProizvodnje"),rs.getString("ime"),rs.getString("prezime"));
                lista.add(new Osiguranje(rs.getInt("osiguranjeID"), v, new java.util.Date(rs.getDate("datumPocetka").getTime()), new java.util.Date(rs.getDate("datumUnosa").getTime()), rs.getString("imePrezime"), rs.getDouble("ukupnaPremija")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
