/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import broker.DBBroker;
import com.sun.corba.se.pept.broker.Broker;
import domain.Galery;
import com.sun.javafx.geom.CubicApproximator;
import domain.Art;
import domain.Custos;
import domain.Exibition;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.memory.StorageMemoryCustos;

/**
 *
 * @author fonis
 */
public class Controller {

    private static Controller instance;
    private final storage.memory.StorageMemoryCustos storageMemoryCustos;
    private DBBroker broker;
    private Map<String, Object> map;

    private Controller() {
        this.storageMemoryCustos = new StorageMemoryCustos();
        broker = new DBBroker();
        map = new HashMap<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<Custos> getAllCustos() {
        return storageMemoryCustos.getAll();
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public List<Galery> getAllGaleries() {
        List<Galery> galeries = null;
        try {
            broker.openConnection();
            galeries = broker.getAllGaleries();
            broker.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return galeries;
    }
    
    public List<Art> getAllArts() {
        List<Art> arts = null;
        try {
            broker.openConnection();
            arts = broker.getAllArts();
            broker.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arts;
    }
    
    public boolean checkGalery(String galery) throws SQLException{
        broker.openConnection();
        boolean busy = broker.isGaleryBusy(galery);
        broker.closeConnection();
        return busy;
    }

    public void saveExibition(Exibition exibition, List<Art> chosenArts) throws SQLException {
         broker.openConnection();
         try{
             Exibition e = broker.sacuvajIzlozbu(exibition);
             System.out.println(e.getId());
             broker.commit();
             broker.sacuvajUmDela(e, chosenArts);
             broker.commit();             
         }catch(Exception ex){
             ex.printStackTrace();
             broker.rollback();
         }
    }
}
