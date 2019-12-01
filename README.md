# Abgaben-Check als Basis für Observer

Dieses Projekt überprüft die Abgaben in einem Ordner. **Der Pfad zum Ordner muss in der Klasse Start.java angegeben werden.** Der Name jeder hinzugefügten Datei wird in einer eigenen Klasse (abgabesystem.model.Abgaben) gespeichert, die dann damit die Daten für die entsprechenden Anzeigen liefert. Da Abgaben nicht wieder gelöscht werden sollen, ist dieser Vorgang im System auch nicht abgebildet.

**Projektstruktur**
- abgabesystem.Start: Start-Punkt der Applikation, enthält die main-Methode. **Der Pfad zum überprüften Abgabe-Ordner muss hier angegeben werden**.
- abgabesystem.checker.DirectoryChecker: **Nicht ändern!** Klasse, die den zu überprüfenden Ordner regelmäßig auf neue Dateien abfragt. Das Ergebnis wird in der Klasse abgabesystem.model.Abgaben gespeichert.
- abgabesystem.model.Abgaben: Dieses Klasse abstrahiert die Daten im Ordner und speichert intern die Namen aller abgegebenen Dateien.
- abgabesystem.controller.AbgabeController: Ereignissteuerung und Controller-Klasse für das Fenster des Abgabe-Managers
- abgabesystem.controller.ProzentController: Ereignissteuerung und Controller-Klasse für das Fenster der prozentuellen Anzeige
- abgabesystem.view.GenericFrame: Frame-Klasse um die Layout-Panels anzeigen zu können.
- abgabesystem.view.AbgabeManager: Layout für den zentralen Abgabe-Manager
- abgabesystem.view.Prozentanzeige: Layout für eine Überwachungsanzeige des Ordners. Diese zeigt die Zahl der Abgaben prozentuell in einem ProgressBar an.

