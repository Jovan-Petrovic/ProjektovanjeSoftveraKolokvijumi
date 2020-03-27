/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Bron Zilar
 */
public class Vozilo {
    private int sifraVozila;
    private String regBroj;
    private int godinaProizvodnje;
    private String ime;
    private String prezime;

    public Vozilo(int sifraVozila, String regBroj, int godinaProizvodnje, String ime, String prezime) {
        this.sifraVozila = sifraVozila;
        this.regBroj = regBroj;
        this.godinaProizvodnje = godinaProizvodnje;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Vozilo() {
    }

    public int getSifraVozila() {
        return sifraVozila;
    }

    public void setSifraVozila(int sifraVozila) {
        this.sifraVozila = sifraVozila;
    }

    public String getRegBroj() {
        return regBroj;
    }

    public void setRegBroj(String regBroj) {
        this.regBroj = regBroj;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
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
        return getRegBroj();
    }
    
}
