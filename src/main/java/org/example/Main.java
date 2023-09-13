package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void intro () {
        System.out.println("Willkommen zum Mitarbeiterverwaltungssystem");
        //intro Menü
    }

    public static void logIn() throws IOException {//implementierung log in methode
        FileReader fileReader = new FileReader("src/main/resources/admin.json");//liest die Daten aus der aus der admin.json Datei
        Scanner scanner = new Scanner(fileReader);//erstellt einen Scanner mit dem FileReader
        StringBuffer jsonContent = new StringBuffer();//StringBuffer erstellen aus jsonContent
        while (scanner.hasNext()) {//solange scanner einen nächsten String hat
            jsonContent.append(scanner.nextLine());//wird der String in jsonContent hinzugefögt
        }

        Scanner userInput = new Scanner(System.in);//Scanner für Eingabe

        System.out.println("Log In");//Log In

        System.out.println("Benutzername: ");
        String benutzername = userInput.next();//Eingabe benutzername

        System.out.println("Passwort: ");
        int passwort = Integer.parseInt(userInput.next());//Eingabe passwort

        JSONObject json = new JSONObject(jsonContent.toString()); // JSon Object aus dem Content erstellt
        if (json.has("Benutzername") && json.has("Passwort")) {//wenn die Daten in der json Datei vorhanden sind
            if (json.getString("Benutzername").equals(benutzername) && json.getInt("Passwort") == passwort) {//wenn die Eingabe richtig ist
                System.out.println("Sie sind eingeloggt!");
            } else {
                System.out.println("Falsche Eingabe, probieren Sie es erneut!");
                logIn();
            }
        }
    }

    //throws IOException-Klausel in einer Methodendeklaration in Java bedeutet, dass die Methode möglicherweise eine IOException auslösen kann
    // ist eine Java-Ausnahme (Exception) und steht für "Input/Output Exception". Sie tritt auf, wenn ein Fehler beim Lesen oder Schreiben von Dateien oder beim Arbeiten mit Ein- oder Ausgabeoperationen auftritt
    //throws IOException: Wenn eine Methode mit throws IOException deklariert ist, signalisiert sie, dass sie eine IOException auslösen kann,
    // aber sie behandelt den Fehler nicht selbst. Stattdessen wird der Fehler an die Methode weitergegeben, die diese Methode aufruft.
    // das bedeutet, dass der Aufrufer dieser Methode dafür verantwortlich ist, den Fehler zu behandeln

    public static void main(String[] args) throws IOException {
        intro();//Intro ausführen
        logIn();//log in ausführen
        System.out.println("Wenn Sie nach einem Mitarbeiter suchen möchten, geben Sie JA ein");
        System.out.println("Wenn Sie nach einem Mitarbeiter suchen möchten, geben Sie DELETE ein");
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
                case "DELETE":
                    System.out.println("Wie heißt der Mitarbeiter, der gelöscht werden soll?");
                    String deleteEmployee = scannerEmployeeSearch.nextLine();
                    deleteEmployee(deleteEmployee);
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
        StringBuffer jsonContent = new StringBuffer();//erstellt einen StringBuilder- da es nur ein Thread ist
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
        }
        if (result != null) {//wenn result nicht null ist, gib es aus
            System.out.println("Wollen Sie nochmal suchen? JA, DELETE oder EXIT");//frage ob  man noch weiter suchen will
            Scanner scannerEmployeeSearch = new Scanner(System.in);//Anfangen des Scanner-Objekts
        } else {
            System.out.println("Mitarbeiter nicht gefunden");//info mitarbeiter nicht gefunden
            System.out.println("Wollen Sie nochmal suchen? JA, DELETE oder EXIT");//info nochmal suchen?
            Scanner scannerEmployeeSearch = new Scanner(System.in);//Anfangen des Scanner-Objekts
        }
    }
    public static void deleteEmployee(String input) throws IOException {//implementierung Löschen Mitarbeiter
        FileReader fileReader = new FileReader("src/main/resources/employees.json");//lies die Json Datei ein
        Scanner scanner = new Scanner(fileReader);////scannt die Json Datei ein
        StringBuffer jsonContent = new StringBuffer();// erstellt einen StringBuffer
        while (scanner.hasNextLine()) {//solange es nächste Zeile gibt
            jsonContent.append(scanner.nextLine());//speichert die Zeile in der StringBuffer
        }
        scanner.close();
        JSONArray json = new JSONArray(jsonContent.toString());//JSON Array wird erstellt aus dem StringBuffer
        JSONObject result = null;//erstellt einen JSONObject und null ist das erste Mitarbeiter

        int indexToRemove = -1;//Mitarbeiter der gelöscht werden soll wird gesucht
        for (int i = 0; i < json.length(); i++) {
            //int i = 0; solange i kleiner als die Länge des JSON Arrays ist,  wird i um 1 erhöht
            JSONObject empObject = json.getJSONObject(i);
            //erstellt einen JSONObject aus dem JSON Array
            if (empObject.has("Name")) {//wenn das JSONObject das Attribut "Name" hat
                if (empObject.getString("Name").equals(input)) {//wenn das Attribut "Name" den Input entspricht
                    indexToRemove = i;//löscht der Mitarbeiter aus dem Array
                    break;
                }
            }
        }
            if (indexToRemove != -1) {
                //wenn indexToRemove nicht -1 ist, entfernt das Mitarbeiter aus dem Array
                json.remove(indexToRemove);
                //remove entfernt das Mitarbeiter aus dem Array
                saveToJsonFile(json);
                //saveToJsonFile wird aufgerufen Methode wird unten ausgeführt
                System.out.println("Mitarbeiter wurde gelöscht");
                System.out.println("Wollen Sie nochmal suchen? JA, DELETE oder EXIT");
                Scanner scannerEmployeeSearch = new Scanner(System.in);//Hauptmenü wird neu gestartet
            }
        }
    private static void saveToJsonFile(JSONArray json) throws IOException {
        //implementierung von saveToJson
        //aktualisiert die Daten von Json File
        FileWriter fileWriter = new FileWriter("src/main/resources/employees.json");
        //Funktion zur überschreibung der JSON Datei
        fileWriter.write(json.toString());//löscht den String aus dem JSON Array in die JSON Datei
        fileWriter.close();//Abschluss der Überschreibung
    }
}