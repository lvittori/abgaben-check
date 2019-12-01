package abgabesystem.model;

import java.util.*;

import abgabesystem.view.Prozentanzeige;

/**
 * Abstrahiert und verwaltet einen Abgabestatus in einem Ordner.
 * @author Lisa Vittori
 * @version 2019-11-30
 */
public class Abgaben {
  private SortedSet<String> dateien;
  private Prozentanzeige anzeige;
  
  /**
   * Erzeugt ein neues Abgabe-Objekt, das die zugehörige Anzeige
   * als Parameter bekommt.
   * @param anzeige die Anzeige, die aktualisiert wird.
   */
  public Abgaben(Prozentanzeige anzeige) {
    dateien = new TreeSet<String>();
    this.anzeige = anzeige;
  }
  
  /**
   * Fügt nur neue Dateien zur bestehenden Liste hinzu.
   * @param dateien ein Set der Dateien eines Ordners 
   */
  public void compareAndAdd(Set<String> dateien) {
    // Überprüft, ob neue Dateien im Set sind
    dateien.removeAll(this.dateien);
    if(dateien.size() > 0) {
      System.out.println("Füge Dateien hinzu");
      this.dateien.addAll(dateien);
      this.anzeige.aktualisieren(dateien.size());
      this.testPrint();
    }
  }
  
  /**
   * Testausgabe zum Nachvollziehen der Änderungen
   */
  public void testPrint() {
    System.out.println("Anzahl an Dateien: " + dateien.size());
    for(String s : dateien) {
      System.out.println(s);
    }
  }
}
