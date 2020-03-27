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
public class TZadatak {
    private String sifraZadatka;
    private String datum;
    private String naziv;
    private String opis;
    private TZaposleni zaposleni;

    public TZadatak(String sifraZadatka, String datum, String naziv, String opis, TZaposleni zaposleni) {
        this.sifraZadatka = sifraZadatka;
        this.datum = datum;
        this.naziv = naziv;
        this.opis = opis;
        this.zaposleni = zaposleni;
    }

    public TZaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(TZaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public String getSifraZadatka() {
        return sifraZadatka;
    }

    public void setSifraZadatka(String sifraZadatka) {
        this.sifraZadatka = sifraZadatka;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "TZadatak{" + "sifraZadatka=" + sifraZadatka + ", datum=" + datum + ", naziv=" + naziv + ", opis=" + opis + ", zaposleni=" + zaposleni + '}';
    }
    
}
