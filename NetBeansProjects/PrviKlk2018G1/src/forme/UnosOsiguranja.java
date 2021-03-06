/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Korisnik;
import domen.Osiguranje;
import domen.Vozilo;
import domen.VrstaOsiguranja;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logika.Kontroler;
import modeli.ModelTabeleOsiguranja;
import modeli.ModelTabeleVrsta;

/**
 *
 * @author Bron Zilar
 */
public class UnosOsiguranja extends javax.swing.JDialog {

    /**
     * Creates new form UnosOsiguranja
     */
    public UnosOsiguranja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        srediTabeluOsiguranja();
        popuniVozila();
        popuniPodatkeVozilo();
        popuniPodatkeTabeleOsiguranja();
        popuniVrsteOsiguranja();
        srediTabeluVrsta();
        popuniVrsteOsiguranja();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        cmbVozilo = new javax.swing.JComboBox<>();
        cmbVrsta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtVlasnikVozila = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGodinaProizvodnje = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCenaVrsteOsiguranja = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVrste = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaOsiguranja = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum osiguranja:");

        jLabel2.setText("Vozilo:");

        jLabel3.setText("Vrsta osiguranja:");

        cmbVozilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVozilo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVoziloItemStateChanged(evt);
            }
        });

        cmbVrsta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVrsta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVrstaItemStateChanged(evt);
            }
        });

        jLabel4.setText("Vlasnik vozila:");

        txtVlasnikVozila.setEditable(false);

        jLabel5.setText("Godina proizvodnje:");

        txtGodinaProizvodnje.setEditable(false);

        jLabel6.setText("Cena vrste osiguranja:");

        txtCenaVrsteOsiguranja.setEditable(false);

        tabelaVrste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaVrste);

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        tabelaOsiguranja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaOsiguranja);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(271, 271, 271)
                            .addComponent(btnDodaj)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisi))
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDatum)
                            .addComponent(cmbVozilo, 0, 255, Short.MAX_VALUE)
                            .addComponent(cmbVrsta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVlasnikVozila)
                            .addComponent(txtGodinaProizvodnje)
                            .addComponent(txtCenaVrsteOsiguranja, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbVozilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cmbVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtVlasnikVozila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGodinaProizvodnje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCenaVrsteOsiguranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(btnSacuvaj)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVoziloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVoziloItemStateChanged
        popuniPodatkeVozilo();
        popuniPodatkeTabeleOsiguranja();
    }//GEN-LAST:event_cmbVoziloItemStateChanged

    private void cmbVrstaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVrstaItemStateChanged
        popuniPodatkeVrsta();
    }//GEN-LAST:event_cmbVrstaItemStateChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        VrstaOsiguranja vrsta = (VrstaOsiguranja) cmbVrsta.getSelectedItem();
        ModelTabeleVrsta mtv = (ModelTabeleVrsta) tabelaVrste.getModel();
        mtv.dodaj(vrsta);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tabelaVrste.getSelectedRow();
        if(red != -1) {
            ModelTabeleVrsta mtv = (ModelTabeleVrsta) tabelaVrste.getModel();
            mtv.obrisi(red);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        String dat = txtDatum.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        try {
            Date datumPocetka = sdf.parse(dat);
            Vozilo vozilo = (Vozilo) cmbVozilo.getSelectedItem();
            
            ArrayList<Osiguranje> listaOsiguranja = Kontroler.getInstanca().vratiOsiguranja(vozilo);
            
            for(Osiguranje osiguranje : listaOsiguranja) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(osiguranje.getDatumPocetka());
                int godinaPocetka = calendar.get(Calendar.YEAR);
                
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(datumPocetka);
                int brojGodina = calendar1.get(Calendar.YEAR);
                
                if(brojGodina == godinaPocetka) {
                    JOptionPane.showMessageDialog(this, "Godina pocetka osiguranja vec ima pokriveno osiguranje");
                    return;
                }
            }
            
            int godina = Calendar.getInstance().get(Calendar.YEAR);
                    
            int razlika = godina - vozilo.getGodinaProizvodnje();
            
            ModelTabeleVrsta mtv = (ModelTabeleVrsta) tabelaVrste.getModel();
            ArrayList<VrstaOsiguranja> vrste = mtv.getVrste();
            
            double premija = 0;
            
            for(VrstaOsiguranja vrstaOsiguranja : vrste) {
                premija += razlika * vrstaOsiguranja.getCena();
            }
            
            Korisnik ulogovani = ((GlavnaForma)getParent()).getUlogovani();
            
            Osiguranje o = new Osiguranje(-1, vozilo, datumPocetka, new Date(), ulogovani.getImePrezime(), premija);
            
            boolean uspesno = Kontroler.getInstanca().sacuvajOsiguranje(o);
            
            
            if(uspesno) {
                JOptionPane.showMessageDialog(this, "Uspesno sacuvano, premija je " + premija + " din.");
            } else {
                JOptionPane.showMessageDialog(this, "Neuspesno sacuvano");
            }
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum je u pogresnom formatu");
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cmbVozilo;
    private javax.swing.JComboBox<Object> cmbVrsta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaOsiguranja;
    private javax.swing.JTable tabelaVrste;
    private javax.swing.JTextField txtCenaVrsteOsiguranja;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtGodinaProizvodnje;
    private javax.swing.JTextField txtVlasnikVozila;
    // End of variables declaration//GEN-END:variables

    private void popuniVozila() {
        cmbVozilo.removeAllItems();
        
        ArrayList<Vozilo> listaVozila = Kontroler.getInstanca().vratiVozila();
        
        for(Vozilo vozilo : listaVozila) {
            cmbVozilo.addItem(vozilo);
        }
    }

    private void popuniPodatkeVozilo() {
        Vozilo vozilo = (Vozilo) cmbVozilo.getSelectedItem();
        if(vozilo != null) {
            txtGodinaProizvodnje.setText(vozilo.getGodinaProizvodnje() + "");
            txtVlasnikVozila.setText(vozilo.getIme() + " " + vozilo.getPrezime());
        }
    }

    private void popuniVrsteOsiguranja() {
        cmbVrsta.removeAllItems();
        
        ArrayList<VrstaOsiguranja> lista = Kontroler.getInstanca().getListaVrsteOsiguranja();
        
        for(VrstaOsiguranja vrstaOsiguranja : lista) {
            cmbVrsta.addItem(vrstaOsiguranja);
        }
    }

    private void popuniPodatkeVrsta() {
        VrstaOsiguranja vrsta = (VrstaOsiguranja) cmbVrsta.getSelectedItem();
        if(vrsta != null) {
            txtCenaVrsteOsiguranja.setText(vrsta.getCena() + "");
        }
    }

    private void srediTabeluVrsta() {
        ModelTabeleVrsta mtv = new ModelTabeleVrsta();
        tabelaVrste.setModel(mtv);
    }

    private void srediTabeluOsiguranja() {
        ModelTabeleOsiguranja mto = new ModelTabeleOsiguranja();
        tabelaOsiguranja.setModel(mto);
    }

    private void popuniPodatkeTabeleOsiguranja() {
        Vozilo vozilo = (Vozilo) cmbVozilo.getSelectedItem();
        if(vozilo != null) {
            ArrayList<Osiguranje> listaOsiguranja = Kontroler.getInstanca().vratiOsiguranja(vozilo);
            ModelTabeleOsiguranja mto = (ModelTabeleOsiguranja) tabelaOsiguranja.getModel();
            mto.setLista(listaOsiguranja);
        }
    }
}
