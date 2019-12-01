package abgabesystem.controller;

import java.awt.event.*;
import java.io.File;
import java.util.Timer;

import abgabesystem.model.Abgaben;
import abgabesystem.view.*;
import abgabesystem.checker.DirectoryChecker;

/**
 * Controller zur Steuerung des Abgabe-Managers
 * @author Lisa Vittori
 * @version 2019-12-01
 */
public class AbgabeController implements ActionListener {
  private AbgabeManager manager;
  private Abgaben abgaben;
  private Timer ueberwachung;
  private ProzentController pController;
  private File f;
  
  /**
   * Erzeugt alle Fenster und startet die Überwachung
   * @param f
   */
  public AbgabeController(File f) {
    this.f = f;
    manager = new AbgabeManager(this);
    new GenericFrame("Überwachungsmanager", manager);
    // Erzeugt einen neuen Controller für die Prozentanzeige.
    // Dieser kümmert sich dann um das Erzeugen der eigentlichen Ansicht
    pController = new ProzentController(24);
    // Datenobjekt, das die Abgaben speichert und auch die Anzeige als
    // Parameter übernimmt, damit diese aktualisiert werden kann.
    // TODO: Enge Kopplung - muss durch Observer geändert werden.
    abgaben = new Abgaben(pController.getAnzeige());
    // NICHT ÄNDERN: Starte Überwachung mit Hilfe eines Timers 
    // Parameter: Überwachter Ordner, Daten-Objekt, Prüfintervall in Sekunden
    ueberwachung = DirectoryChecker.start(f, abgaben, 3);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
    case "End":
      ueberwachung.cancel();
      manager.aktiviereStarten(true);
      break;
    case "Prozent":
      pController.setAnzahl(manager.getSchuelerzahl());
      pController.erzeugeFenster();
      break;
    case "Start":
      // NICHT ÄNDERN: Startet nach Beendigung die Überwachung neu
      ueberwachung = DirectoryChecker.start(f, abgaben, 3);
      manager.aktiviereStarten(false);
    } 
  }
}
