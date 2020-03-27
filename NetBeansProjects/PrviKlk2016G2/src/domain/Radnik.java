/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Bron Zilar
 */
public class Radnik {
    private int radnikId;
    private String ime;
    private String prezime;
    private String specijalizacija;

    public Radnik(int radnikId, String ime, String prezime, String specijalizacija) {
        this.radnikId = radnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalizacija = specijalizacija;
    }

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getRadnikId() {
        return radnikId;
    }

    public void setRadnikId(int radnikId) {
        this.radnikId = radnikId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
}
