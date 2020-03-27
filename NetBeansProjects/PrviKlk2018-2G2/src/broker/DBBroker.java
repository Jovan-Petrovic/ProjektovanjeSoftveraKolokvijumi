package broker;

import domain.Art;
import domain.Exibition;
import domain.Galery;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fonis
 */
public class DBBroker {

    private Connection conn;

    public void openConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rokgalerija", "root", "");
        conn.setAutoCommit(false);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void commit() throws SQLException {
        conn.commit();
    }

    public void rollback() throws SQLException {
        conn.rollback();
    }

    public List<Galery> getAllGaleries() throws SQLException {
        List<Galery> galeries = new LinkedList<>();
        String query = "SELECT * FROM galerije";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Galery galery = new Galery(rs.getInt("id"), rs.getString("naziv"));
            galeries.add(galery);
        }
        rs.close();
        statement.close();
        return galeries;
    }

    public List<Art> getAllArts() throws SQLException {
        List<Art> arts = new LinkedList<>();
        String query = "SELECT * FROM umetnickadela";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Art art = new Art(rs.getInt("id"), rs.getString("naziv"), rs.getString("autor"), rs.getInt("br_prikaza"));
            arts.add(art);
        }
        rs.close();
        statement.close();
        return arts;
    }

    public boolean isGaleryBusy(String galery) throws SQLException {
        try {
//            NEMOJ PLUSEVE NIKAKOOO U UPITU
            String query = "SELECT i.id FROM izlozbe i JOIN galerije g ON i.id_galerije = g.id WHERE g.naziv = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, galery);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public Exibition sacuvajIzlozbu(Exibition e) throws SQLException {
        String query = "INSERT INTO izlozbe (naziv, opis, br_poset, trajanje, datum, tip, id_galerije, kustos) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, e.getNaziv());
        ps.setString(2, e.getOpis());
        ps.setInt(3, e.getBrojPoseta());
        ps.setInt(4, e.getTrajanje());
        ps.setDate(5, new Date(e.getDatum().getTime()));
        ps.setString(6, e.getTip().toString());
        ps.setInt(7, e.getGalerija().getId());
        ps.setString(8, e.getKustos().getName());
        
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            int id = rs.getInt(1);
            e.setId(id);
        }
        return e;
    }

    public void sacuvajUmDela(Exibition e, List<Art> arts) throws Exception {
        String query = "INSERT INTO postavke (id_izlozbe, id_umdela) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        for (Art a : arts) {
            a.setNumberOfShows(a.getNumberOfShows()+1);
            if(a.getNumberOfShows() > 10){
                throw new Exception("Um delo ima vise od 10 izlaganja");
            }
            updateNumberOfShows(a);
            
            ps.setInt(1, e.getId());
            ps.setInt(2, a.getId());
            ps.executeUpdate();
        }
    }

    private void updateNumberOfShows(Art a) throws SQLException {
        String q1 = "UPDATE umetnickadela SET br_prikaza = ? WHERE id = ?";
        PreparedStatement ps1 = conn.prepareStatement(q1);
        ps1.setInt(1, a.getNumberOfShows());
        ps1.setInt(2, a.getId());
        ps1.executeUpdate();
        conn.commit();
    }
}
