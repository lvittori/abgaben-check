package abgabesystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Anzeige, wie viele Abgaben prozentuell gesehen schon erfolgt sind 
 * @author Lisa Vittori
 * @version 2019-30-11
 */
public class Prozentanzeige extends JPanel {
  private JProgressBar pbAnzeige;
  private JLabel lAnzeige;
  private JButton bSchliessen;
  private boolean sichtbar;

  /**
   * Erzeugt ein neues Prozentanzeige-Layout mit der Angabe, wie viel
   * Schüler maximal abgeben sollten und dem Controller für die Ereignissteuerung
   * @param maxAnzahl maximale Anzahl der Schüler
   * @param controller Controller für die Ereignissteuerung
   */
  public Prozentanzeige(int maxAnzahl, ActionListener controller) {
    this.setLayout(new BorderLayout());
    lAnzeige = new JLabel("Abgegeben: 0 / " + maxAnzahl + "   ");
    pbAnzeige = new JProgressBar(0,maxAnzahl);
    this.add(lAnzeige, BorderLayout.PAGE_START);
    this.add(pbAnzeige);
    JPanel unten = new JPanel();
    bSchliessen = new JButton("Schliessen");
    bSchliessen.addActionListener(controller);
    unten.add(bSchliessen);
    this.add(unten, BorderLayout.PAGE_END);
  }
  
  /**
   * Aktualisiert die Anzeige
   * @param wert der neue Wert für die Anzeige
   */
  public void aktualisieren(int wert) {
    pbAnzeige.setValue(pbAnzeige.getValue()+ wert);
    lAnzeige.setText("Abgegeben: " + pbAnzeige.getValue() + " / " + pbAnzeige.getMaximum());
  }
  
  /**
   * Setzt einen neuen Maximalwert
   * @param max der neue Maximalwert
   */
  public void setMaxAnzahl(int max) {
    pbAnzeige.setMaximum(max);
    lAnzeige.setText("Abgegeben: " + pbAnzeige.getValue() + " / " + pbAnzeige.getMaximum());
  }
  
  /**
   * Gibt zurück, ob das Panel gerade angezeigt wird
   * @return true, wenn das Panel gerade in einem Frame angezeigt wird
   */
  public boolean istSichtbar() {
    return sichtbar;
  }

  /**
   * Setzt, ob das Panel gerade angezeigt wird
   * @param sichtbar true, wenn das Panel gerade in einem Frame angezeigt wird
   */
  public void setSichtbar(boolean sichtbar) {
    this.sichtbar = sichtbar;
  }
}
