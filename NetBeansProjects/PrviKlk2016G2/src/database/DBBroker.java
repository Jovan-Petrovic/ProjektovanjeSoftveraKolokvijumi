/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Lokacija;
import domain.Radnik;
import domain.Raspored;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.net.www.protocol.http.AuthCacheValue;

/**
 *
 * @author Bron Zilar
 */
public class DBBroker {
    private Connection konekcija;
    
    public void otvoriKonekciju() {
        try {
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoftg2","root","");
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

    public List<Lokacija> vratiSveLokacije() throws SQLException, Exception {
        List<Lokacija> lokacije = new ArrayList<>();
        try {
        String upit = "select * from lokacija order by Naziv asc";
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while(rs.next()) {
            int lokacijaId = rs.getInt("LokacijaID");
            String naziv = rs.getString("Naziv");
            Date pocetakGradnje = rs.getDate("PocetakGradnje");
            Date zavrsetakGradnje = rs.getDate("ZavrsetakGradnje");
            Lokacija lokacija = new Lokacija(lokacijaId, naziv, pocetakGradnje, zavrsetakGradnje);
            lokacije.add(lokacija);
        }
        rs.close();
        statement.close();
        return lokacije; 
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("greska u konekciji");
        }
    }

    public List<Radnik> vratiSveRadnike() throws Exception {
        List<Radnik> radnici = new ArrayList<>();
        try {
        String upit = "select * from radnik order by Prezime asc";
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while(rs.next()) {
            int radnikID = rs.getInt("RadnikID");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String specijalizacija = rs.getString("Specijalizacija");
            Radnik radnik = new Radnik(radnikID, ime, prezime, specijalizacija);
            radnici.add(radnik);
        }
        rs.close();
        statement.close();
        return radnici; 
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("greska u konekciji");
        }
    }

    public int vratiMax() {
        int maks = 0;
        try {
            String upit = "select max(RasporedID) as maks from raspored";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            if(rs.next()) {
                maks = rs.getInt("maks");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maks+1;
        
    }

    public void sacuvajJedanRaspored(Raspored raspored, int idMaksRaspored) throws SQLException {
        String upit = "insert into raspored values(?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, idMaksRaspored);
        ps.setInt(2, raspored.getBrojSati());
        ps.setDate(3, new java.sql.Date(raspored.getDatum().getTime()));
        ps.setInt(4, raspored.getLokacija().getLokacijaID());
        ps.setInt(5, raspored.getRadnik().getRadnikId());
        ps.executeUpdate();
    }

   
    
}
