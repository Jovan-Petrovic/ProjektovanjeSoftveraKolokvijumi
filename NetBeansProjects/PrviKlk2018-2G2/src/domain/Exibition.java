/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author fonis
 */
public class Exibition {
    private int id;
    private String naziv;
    private String opis;
    private int brojPoseta;
    private int trajanje;
    private Date datum;
    private ExibitionType tip;
    private Galery galerija;
    private Custos kustos;

    public Exibition() {
    }

    public Exibition(String naziv, String opis, int brojPoseta, int trajanje, Date datum, ExibitionType tip, Galery galerija, Custos kustos) {
        this.naziv = naziv;
        this.opis = opis;
        this.brojPoseta = brojPoseta;
        this.trajanje = trajanje;
        this.datum = datum;
        this.tip = tip;
        this.galerija = galerija;
        this.kustos = kustos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getBrojPoseta() {
        return brojPoseta;
    }

    public void setBrojPoseta(int brojPoseta) {
        this.brojPoseta = brojPoseta;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public ExibitionType getTip() {
        return tip;
    }

    public void setTip(ExibitionType tip) {
        this.tip = tip;
    }

    public Galery getGalerija() {
        return galerija;
    }

    public void setGalerija(Galery galerija) {
        this.galerija = galerija;
    }

    public Custos getKustos() {
        return kustos;
    }

    public void setKustos(Custos kustos) {
        this.kustos = kustos;
    }
    
    
}
