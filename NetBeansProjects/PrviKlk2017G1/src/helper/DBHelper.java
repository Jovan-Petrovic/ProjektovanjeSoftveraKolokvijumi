/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Bron Zilar
 */
public class DBHelper {
    Properties properti;

    public DBHelper() throws FileNotFoundException, IOException {
        properti = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        properti.load(fis);
    }
    
    public String vratiVrednost(String kljuc) {
        return properti.getProperty(kljuc);
    }
}
