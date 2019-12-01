package abgabesystem.controller;

import java.awt.event.*;
import javax.swing.*;

import abgabesystem.view.GenericFrame;
import abgabesystem.view.Prozentanzeige;

/**
 * Steuert die Prozent-Anzeige
 * @author Lisa Vittori
 * @version 2019-12-01
 */
public class ProzentController implements ActionListener {
  private Prozentanzeige anzeige;
  private GenericFrame gf;
  private int anzahl;
  
  /**
   * Erzeugt ein neues Anzeige-Objekt
   */
  public ProzentController(int anzahl) {
    anzeige = new Prozentanzeige(anzahl, this);
    this.erzeugeFenster();
  }
  
  /**
   * Erzeugt ein neues Fenster in dem die Anzeige-Oberfläche eingeblendet wird
   */
  public void erzeugeFenster() {
    if(!anzeige.istSichtbar()) {
      gf = new GenericFrame("Abgaben in Prozent", anzeige);
      gf.setLocation(10, 10);
      gf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      anzeige.setSichtbar(true);
    }
  }
  
  /**
   * Gibt das vom Controller verwaltete View-Objekt zurück
   * @return das vom Controller verwaltete View-Objekt
   */
  public Prozentanzeige getAnzeige() {
    return this.anzeige;
  }
  
  /**
   * Setzt die Anzahl der Schueler für die Anzeige.
   * @param anzahl
   */
  public void setAnzahl(int anzahl) {
    anzeige.setMaxAnzahl(anzahl);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
    case "Schliessen":
      anzeige.setSichtbar(false);
      gf.dispose();
    } 
  }

}
