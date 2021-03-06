/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Bron Zilar
 */
public class Raspored {
    private int rasporedID;
    private int brojSati;
    private Date datum;
    private Lokacija lokacija;
    private Radnik radnik;

    public Raspored(int rasporedID, int brojSati, Date datum, Lokacija lokacija, Radnik radnik) {
        this.rasporedID = rasporedID;
        this.brojSati = brojSati;
        this.datum = datum;
        this.lokacija = lokacija;
        this.radnik = radnik;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public int getRasporedID() {
        return rasporedID;
    }

    public void setRasporedID(int rasporedID) {
        this.rasporedID = rasporedID;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Raspored other = (Raspored) obj;
        if (this.rasporedID != other.rasporedID) {
            return false;
        }
        return true;
    }

    
    
}
