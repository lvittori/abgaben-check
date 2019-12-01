package abgabesystem.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Das Layout für den Abgabe-Manager
 * @author Lisa Vittori
 * @version 2019-12-01
 */
public class AbgabeManager extends JPanel {
  private JButton bProzent, bBeenden, bStarten;
  private JTextField tfSchueler;
  
  /**
   * Bildet das Layout für das Abgabe-Manager-Fenster
   * @param controller der Controller zur Ereignissteuerung
   */
  public AbgabeManager(ActionListener controller) {
    this.setLayout(new BorderLayout());
    this.add(new JLabel("Anzeige aktivieren:"), BorderLayout.PAGE_START);
    // Bereich für die Anzeigen
    JPanel pAnzeigen = new JPanel();
    bProzent = new JButton("Prozentanzeige");
    bProzent.setActionCommand("Prozent");
    bProzent.addActionListener(controller);
    pAnzeigen.add(bProzent);
    this.add(pAnzeigen); 
    
    // Bereich für die Überwachung
    JPanel pUeberwachung = new JPanel();
    pUeberwachung.add(new JLabel("Schülerzahl:"));
    tfSchueler = new JTextField("24",3);
    pUeberwachung.add(tfSchueler);
    bStarten = new JButton("Überwachung starten");
    bStarten.setActionCommand("Start");
    bStarten.addActionListener(controller);
    bStarten.setEnabled(false);
    pUeberwachung.add(bStarten);
    bBeenden = new JButton("Überwachung beenden");
    bBeenden.setActionCommand("End");
    bBeenden.addActionListener(controller);
    bBeenden.setEnabled(true);
    pUeberwachung.add(bBeenden);
    this.add(pUeberwachung, BorderLayout.PAGE_END);
  }
  
  /**
   * Steuert, ob der Starten-Button auf true oder auf false gesetzt wird.
   * Der Beenden-Button wird gegengleich gesetzt.
   * @param b Falls true übergeben wird, wird der Starten-Button auf true und
   *  der Beenden-Button auf false gesetzt. Falls false übergeben wird, wird 
   *  der Starten-Button auf false und der Beenden-Button auf true gesetzt.
   */
  public void aktiviereStarten(boolean b) {
    bBeenden.setEnabled(b^true);
    bStarten.setEnabled(b^false);
  }
  
  /**
   * Gibt die im Textfeld angegebene maximale Schüleranzahl zurück.
   * @return die im angegebene maximale Schüleranzahl (0 im Fehlerfall)
   */
  public int getSchuelerzahl() {
    try {
      return Integer.parseInt(tfSchueler.getText());
    } catch (NumberFormatException nfe) {
      JOptionPane.showMessageDialog(this, "Nur Zahlen im Eingabefeld erlaubt");
      return 0;
    }
  }
}
