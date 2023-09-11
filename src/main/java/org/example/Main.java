package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Willkommen zum Mitarbeiterverwaltungssystem");
        System.out.println("Wenn Sie nach einem Mitarbeiter suchen möchten, geben Sie JA ein");
        System.out.println("Wenn Sie den Vorgang abbrechen möchten, geben Sie EXIT ein");

        Scanner scannerEmployeeSearch = new Scanner(System.in);//Anfangen des Scanner-Objekts
        boolean isRunning = true;//startet das Programmm solange true ist
        while (isRunning) {
            String option = scannerEmployeeSearch.nextLine().toUpperCase();//option ist die Eingabe des Benutzer
            //scannerEmployeeSearch.nextLine() gibt die Eingabe des Benutzers wieder
            //.toUpperCase() gibt die Eingabe in Großbuchstaben wieder
            switch (option) {//option wird gestartet
                case "JA"://wenn ja wird das employeeName gestartet
                    System.out.println("Wie heißt der Mitarbeiter, der gesucht werden soll?");
                    String employeeName = scannerEmployeeSearch.nextLine();
                    searchEmployee(employeeName);//employeeName wird öffnet und gesucht
                    break;
                case "EXIT":
                    System.out.println("Das Programm wird beendet.");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Ungültige Eingabe. Bitte geben Sie 'JA' oder 'EXIT' ein.");
            }
        }
        scannerEmployeeSearch.close();//Scanner wird geschlossen
    }

    public static void searchEmployee(String input) throws FileNotFoundException {//searchEmployee wird aufgerufen
        //String input ist das Eingabefeld für den Namen des gesuchten Mitarbeiters
        //throws FileNotFoundException heißt es einen Fehler wenn die Datei nicht gefunden wird

        // Öffnen der JSON-Datei und Lesen des Inhalts
        FileReader fileReader = new FileReader("src/main/resources/employees.json");//lies die Datei ein
        Scanner scanner = new Scanner(fileReader);//scannt die Datei ein
        StringBuilder jsonContent = new StringBuilder();//erstellt einen StringBuilder- da es nur ein Thread ist
        while (scanner.hasNextLine()) {//solange es nächste Zeile gibt
            jsonContent.append(scanner.nextLine());//speichert die Zeile in der StringBuilder
        }//Stringbuilder ist für die Auführung von einem Thread
        JSONArray json = new JSONArray(jsonContent.toString());//erstellt einen JSONArray aus dem StringBuilder
        JSONObject result = null;//erstellt einen JSONObject und null ist das erste Mitarbeiter
            //json array weil die Datei ein JSON Array ist
        for (int i = 0; i < json.length(); i++) {//schleife, die alle Mitarbeiter durchläuft
            //int i = 0; solange i kleiner als die Länge des JSON Arrays ist,  wird i um 1 erhöht
            JSONObject empObject = json.getJSONObject(i);//erstellt einen JSONObject aus dem JSON Array
            if (empObject.has("Name")) {//wenn das JSONObject das Attribut "Name" hat
                if (empObject.getString("Name").equals(input)) {//wenn das Attribut "Name" den Input entspricht
                    result = empObject;//speichert das JSONObject in result
                }
            }
        }
        if (result != null) {
            System.out.println("Mitarbeiter gefunden:");//also wenn result nicht null ist, gib es aus
            System.out.println("Name: " + result.getString("Name"));//ausgabe name result soll es vom String vom Parameter Name nehmen
            System.out.println("Alter: " + result.getInt("Alter"));//ausgabe alter result soll es vom Integer vom Parameter Alter nehmen
            System.out.println("Gehalt: " + result.getDouble("Gehalt") + " €");//ausgabe gehalt result soll es vom Double vom Parameter Gehalt nehmen
            //Euro Zeichen nicht innerhalb der Key Klammern hinzufügen!!   ^^
        } if (result != null) {//wenn result nicht null ist, gib es aus
            System.out.println("Wollen Sie weiter suchen? JA oder EXIT");//frage ob  man noch weiter suchen will
            Scanner scannerEmployeeSearch = new Scanner(System.in);//Anfangen des Scanner-Objekts
        } else {
            System.out.println("Mitarbeiter nicht gefunden");//info mitarbeiter nicht gefunden
            System.out.println("Wollen Sie nochmal suchen? JA oder EXIT");//info nochmal suchen?
            Scanner scannerEmployeeSearch = new Scanner(System.in);//Anfangen des Scanner-Objekts
        }
    }
}

