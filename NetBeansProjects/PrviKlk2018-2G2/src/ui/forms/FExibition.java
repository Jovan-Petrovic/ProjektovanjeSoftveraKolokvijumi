/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forms;

import controller.Controller;
import domain.Art;
import domain.Custos;
import domain.Exibition;
import domain.ExibitionType;
import domain.Galery;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;
import ui.forms.table.models.ArtTableModel;

/**
 *
 * @author fonis
 */
public class FExibition extends javax.swing.JDialog {

    /**
     * Creates new form FExibition
     */
    public FExibition(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtExibitionName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtExibitionDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jtxtExibitionVisitiors = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtExibitionDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbType = new javax.swing.JComboBox<ExibitionType>();
        jLabel6 = new javax.swing.JLabel();
        jcbGalery = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jcbDays = new javax.swing.JComboBox<Integer>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblChosenArts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblAllArts = new javax.swing.JTable();
        jbtnAddArt = new javax.swing.JButton();
        jbtnRemoveArt = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv izlozbe:");

        jLabel2.setText("Opis izlozbe:");

        jtxtExibitionDescription.setColumns(20);
        jtxtExibitionDescription.setRows(5);
        jScrollPane1.setViewportView(jtxtExibitionDescription);

        jLabel3.setText("Broj posetilaca (u hiljadama):");

        jLabel4.setText("Datum:");

        jtxtExibitionDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtExibitionDateActionPerformed(evt);
            }
        });

        jLabel5.setText("Tip izlozbe:");

        jLabel6.setText("Galerija:");

        jLabel7.setText("Broj dana:");

        jcbDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDaysActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("izabrana um dela"));

        jtblChosenArts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jtblChosenArts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("sva um dela"));

        jtblAllArts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jtblAllArts);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtnAddArt.setText("Add");
        jbtnAddArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddArtActionPerformed(evt);
            }
        });

        jbtnRemoveArt.setText("Remove");
        jbtnRemoveArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveArtActionPerformed(evt);
            }
        });

        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(5, 5, 5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jLabel7)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtExibitionName)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(jtxtExibitionVisitiors)
                            .addComponent(jtxtExibitionDate)
                            .addComponent(jcbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbGalery, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbDays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnAddArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnRemoveArt)
                                .addGap(0, 7, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtExibitionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtExibitionVisitiors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtExibitionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jcbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jcbGalery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnRemoveArt)
                        .addGap(99, 99, 99)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnAddArt)
                        .addGap(76, 76, 76)))
                .addComponent(jbtnSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtExibitionDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtExibitionDateActionPerformed
        String dateTyped = jtxtExibitionDate.getText();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            String currentDate = dateFormat.format(dateTyped);
            String[] d = currentDate.split(".");
            if (Integer.parseInt(d[2]) < new GregorianCalendar().get(GregorianCalendar.YEAR)) {
                return;
            } else if (Integer.parseInt(d[2]) == new GregorianCalendar().get(GregorianCalendar.YEAR)) {
                if (Integer.parseInt(d[1]) < new GregorianCalendar().get(GregorianCalendar.MONTH) + 1) {
                    return;
                } else if (Integer.parseInt(d[1]) == new GregorianCalendar().get(GregorianCalendar.MONTH) + 1) {
                    if (Integer.parseInt(d[0]) <= new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH)) {
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Datum mora biti u proslosti ili trenutni");
                        jtxtExibitionDate.setText(dateFormat.format(new Date()));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Datum mora biti u proslosti ili trenutni");
                    jtxtExibitionDate.setText(dateFormat.format(new Date()));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Datum mora biti u proslosti ili trenutni");
                jtxtExibitionDate.setText(dateFormat.format(new Date()));
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Datum mora biti u formatu dd.mm.gggg");
            String currentDate = dateFormat.format(new Date());
            jtxtExibitionDate.setText(currentDate);
        }
    }//GEN-LAST:event_jtxtExibitionDateActionPerformed

    private void jcbDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDaysActionPerformed

    private void jbtnAddArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddArtActionPerformed
        ArtTableModel tmChosen = (ArtTableModel) jtblChosenArts.getModel();
        ArtTableModel tmAll = (ArtTableModel) jtblAllArts.getModel();
        int rowSelected = jtblAllArts.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red");
            return;
        }
        Art art = tmAll.getArt(rowSelected);
        tmChosen.addArt(art);
    }//GEN-LAST:event_jbtnAddArtActionPerformed

    private void jbtnRemoveArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveArtActionPerformed
        int rowSelected = jtblChosenArts.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red");
            return;
        }
        ArtTableModel artTableModel = (ArtTableModel) jtblChosenArts.getModel();
        artTableModel.removeArt(rowSelected);
    }//GEN-LAST:event_jbtnRemoveArtActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        Galery galery = (Galery) jcbGalery.getSelectedItem();
        try {
            boolean galeryBusy = Controller.getInstance().checkGalery(galery.getName());
            if (galeryBusy) {
                JOptionPane.showMessageDialog(this, "Galery is taken");
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        String name = jtxtExibitionName.getText().trim();
        String desc = jtxtExibitionDescription.getText();
        int visitors = (int)Double.parseDouble(jtxtExibitionVisitiors.getText().trim()) * 1000;
        int days = jcbDays.getSelectedIndex();
        Date date;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(jtxtExibitionDate.getText().trim());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum nije u ispravnom formatu");
            return;
        }
        ExibitionType type = (ExibitionType) jcbType.getSelectedItem();
        List<Art> chosenArts = ((ArtTableModel) jtblChosenArts.getModel()).getArts();

        Exibition exibition = new Exibition(name, desc, visitors, days, date, type, galery, (Custos) Controller.getInstance().getMap().get("current.user"));
        try {
            Controller.getInstance().saveExibition(exibition, chosenArts);
        } catch (SQLException ex) {
            Logger.getLogger(FExibition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jbtnAddArt;
    private javax.swing.JButton jbtnRemoveArt;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox<Integer> jcbDays;
    private javax.swing.JComboBox jcbGalery;
    private javax.swing.JComboBox<ExibitionType> jcbType;
    private javax.swing.JTable jtblAllArts;
    private javax.swing.JTable jtblChosenArts;
    private javax.swing.JTextField jtxtExibitionDate;
    private javax.swing.JTextArea jtxtExibitionDescription;
    private javax.swing.JTextField jtxtExibitionName;
    private javax.swing.JTextField jtxtExibitionVisitiors;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        for (int i = 1; i < 91; i++) {
            jcbDays.addItem(new Integer(i));
        }

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = dateFormat.format(new Date());
        jtxtExibitionDate.setText(currentDate);
        jtxtExibitionDate.setEditable(false);

//        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        DateFormatter df = new DateFormatter(dateFormat);
//        date = new JFormattedTextField(df);
//        date.setValue(new Date());
        List<String> types = new ArrayList() {
            {
                add(ExibitionType.fotografija);
                add(ExibitionType.slike);
                add(ExibitionType.potreti);
                add(ExibitionType.autoportreti);
            }
        };
        Collections.sort(types);
        jcbType.setModel(new DefaultComboBoxModel(types.toArray()));

        List<Galery> galerys = Controller.getInstance().getAllGaleries();
        Collections.sort(galerys);
        jcbGalery.setModel(new DefaultComboBoxModel(galerys.toArray()));

        fillChosenArts();
        fillAllArts();
    }

    private void fillAllArts() {
        List<Art> allArts = Controller.getInstance().getAllArts();
        jtblAllArts.setModel(new ArtTableModel(allArts));
    }

    private void fillChosenArts() {
        jtblChosenArts.setModel(new ArtTableModel(new LinkedList<>()));
    }
}
