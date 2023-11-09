package org.example.controller;

import java.util.Scanner;

import org.example.service.MitarbeiterService;
import org.json.JSONObject;

public class MitarbeiterController {

    private final MitarbeiterService mitarbeiterService;

    public MitarbeiterController(MitarbeiterService mitarbeiterService){
        this.mitarbeiterService = mitarbeiterService;
    }

    public void readOptions() {
        intro();
        System.out.println("Hauptmenü");
        System.out.println("Wenn Sie nach einem Mitarbeiter suchen möchten, geben Sie YES ein");
        System.out.println("Wenn Sie einen Mitarbeiter löschen möchten, geben Sie DELETE ein");
        System.out.println("Wenn Sie einen Mitarbeiter hinzufügen möchten, geben Sie ADD ein");
        System.out.println("Wenn Sie den Vorgang abbrechen möchten, geben Sie EXIT ein");

        Scanner scanner = new Scanner(System.in);//Anfangen des Scanner-Objekts
        boolean isRunning = true;//startet das Programmm solange true ist
        while (isRunning) {
            String option = scanner.nextLine().toUpperCase();//option ist die Eingabe des Benutzer
            //scannerEmployeeSearch.nextLine() gibt die Eingabe des Benutzers wieder
            //.toUpperCase() gibt die Eingabe in Großbuchstaben wieder
            switch (option) {//option wird gestartet
                case "YES" -> {//wenn ja wird das employeeName gestartet
                    System.out.println("Wie heißt der Mitarbeiter, der gesucht werden soll?");
                    String employeeName = scanner.nextLine();
                    JSONObject result = mitarbeiterService.findByName(employeeName);

                    if (result != null) {
                        System.out.println("Mitarbeiter gefunden:");//also wenn result nicht null ist, gib es aus
                        System.out.println("Name: " + result.getString("Name"));//ausgabe name result soll es vom String vom Parameter Name nehmen
                        System.out.println("Alter: " + result.getInt("Alter"));//ausgabe alter result soll es vom Integer vom Parameter Alter nehmen
                        System.out.println("Gehalt: " + result.getDouble("Gehalt") + " €");//ausgabe gehalt result soll es vom Double vom Parameter Gehalt nehmen
                        //Euro Zeichen nicht innerhalb der Key Klammern hinzufügen!!   ^^
                    }
                    if (result != null) {//wenn result nicht null ist, gib es aus
                        System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");//frage ob  man noch weiter suchen will
                    
                    } else {
                        System.out.println("Mitarbeiter nicht gefunden");//info mitarbeiter nicht gefunden
                        System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");//info nochmal suchen?
                    }
                }
                case "DELETE" -> {
                    System.out.println("Wie heißt der Mitarbeiter, der gelöscht werden soll?");
                    String name = scanner.nextLine();
                    mitarbeiterService.deleteByName(name);
                }
                case "ADD" -> {
                    System.out.println("Bitte geben Sie die Daten ein");

                    String name = "Test"; // scanner.nextLine();
                    int alter = 123; // scanner.nextInt();
                    int gehalt = 300; // scanner.nextInt();

                    mitarbeiterService.create(name, alter, gehalt);
                }
                case "EXIT" -> {
                    System.out.println("Das Programm wird beendet.");
                    isRunning = false;
                }
                default ->
                        System.out.println("Ungültige Eingabe. Bitte geben Sie 'YES', 'ADD', 'DELETE' oder 'EXIT' ein.");
            }
        }
        scanner.close();//Scanner wird geschlossen
    }

    private static void intro() {
        System.out.println("Willkommen zum Mitarbeiterverwaltungssystem");
        //Intro Menü
        System.out.println("Log In");
    }
}
