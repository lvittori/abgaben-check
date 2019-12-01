package abgabesystem;

import java.io.File;

import abgabesystem.controller.AbgabeController;
/**
 * Startpunkt der Applikation. Legt das Ordner-Objekt fest und startet
 * die Überwachung
 * @author Lisa Vittori
 * @version 2019-11-30
 */
public class Start {
  //TODO: Pfad zur Datei angeben, die überwacht werden soll-
  public static String ordner = "./Ueberwacht";

  public static void main(String[] args) {
    File f = new File(ordner); // überwachter Ordner
    if(f.exists() && f.isDirectory()) {
      // Ausgabe zum Überprüfen des Ablaufes
      System.out.println("Starte Überwachung von " + f.getAbsolutePath());
      // Anzeige
      new AbgabeController(f);
    }
  }
}
