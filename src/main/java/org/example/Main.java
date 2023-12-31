package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.example.DefaultJsonReaderEmployeeData.saveToJsonFile;
import static org.example.EmployeeManagement.deleteEmployee;


public class Main { //Hauptmenü



    //throws IOException-Klausel in einer Methodendeklaration in Java bedeutet, dass die Methode möglicherweise eine IOException auslösen kann
    // ist eine Java-Ausnahme (Exception) und steht für "Input/Output Exception". Sie tritt auf, wenn ein Fehler beim Lesen oder Schreiben von Dateien oder beim Arbeiten mit Ein- oder Ausgabeoperationen auftritt
    //throws IOException: Wenn eine Methode mit throws IOException deklariert ist, signalisiert sie, dass sie eine IOException auslösen kann,
    // aber sie behandelt den Fehler nicht selbst. Stattdessen wird der Fehler an die Methode weitergegeben, die diese Methode aufruft.
    // das bedeutet, dass der Aufrufer dieser Methode dafür verantwortlich ist, den Fehler zu behandeln

    public static void main(String[] args) throws Exception {
       // intro();//Intro ausführen
        //logIn();//log in ausführen
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
                    EmployeeManagement.searchingEmployee(employeeName);
                }
                case "DELETE" -> {
                    System.out.println("Wie heißt der Mitarbeiter, der gelöscht werden soll?");
                    String deleteEmployee = scanner.nextLine();
                    deleteEmployee(deleteEmployee);
                }
                case "ADD" -> {
                    System.out.println("Bitte geben Sie die Daten ein");
                   EmployeeManagement.addEmployee;
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

    //Intro_______________________________________________________________________________________________________________________
    public static void intro() {
        System.out.println("Willkommen zum Mitarbeiterverwaltungssystem");
        //Intro Menü
        System.out.println("Log In");

    }

    //Log In Funktion______________________________________________________________________________________________________________
    public static boolean logIn() throws IOException {//implementierung log in methode
        FileReader fileReader = new FileReader("src/main/resources/admin.json");//liest die Daten aus der aus der admin.json Datei
        Scanner scanner = new Scanner(fileReader);//erstellt einen Scanner mit dem FileReader
        StringBuffer jsonContent = new StringBuffer();//StringBuffer erstellen aus jsonContent

        while (scanner.hasNext()) {//solange scanner einen nächsten String hat
            jsonContent.append(scanner.nextLine());//wird der String in jsonContent hinzugefögt
        }
        scanner.close();

        JSONObject json = new JSONObject(jsonContent.toString()); // JSon Object aus dem Content erstellt
        int maxAttempts = 3;//Maximale Anzahl an Passworteingaben festlegen !!!!
        int attempts = 0;//Anzahl der Versuche
        while (attempts < maxAttempts) {//solange die Anzahl der Versuche kleiner als maxAttempts ist
            Scanner userInput = new Scanner(System.in);//Scanner för Eingabe
            System.out.println("Benutzername: ");
            String benutzername = userInput.nextLine();//Eingabe benutzername
            System.out.println("Passwort: ");
            int passwort = Integer.parseInt(userInput.nextLine());//Eingabe passwort

            if (json.has("Benutzername") && json.has("Passwort")) {//wenn die Daten in der json Datei vorhanden sind
                if (json.getString("Benutzername").equals(benutzername) && json.getInt("Passwort") == passwort) {//wenn die Eingabe richtig ist
                    System.out.println("Sie sind eingeloggt!");
                    break; //wenn die Eingabe richtig ist wird eingeloggt quasi Methode erfolgreich beendet
                } else {
                    System.out.println("Falsches Passwort!");
                    attempts++;//Anzahl der Versuche erhöht
                }
                if (attempts < maxAttempts) {//wenn die Anzahl der Versuche kleiner als maxAttempts ist
                    System.out.println("Bitte versuchen Sie es erneut.");
                } else {
                    System.out.println("Sie haben die maximale Anzahl an Versuchen erreicht.\nIhr Konto wurde gesperrt!\nNeues Passwort erstellen 'NEW' oder Programm beenden 'EXIT'?");
                    String option = userInput.nextLine().toUpperCase();//Eingabe option
                    switch (option) {
                        case "NEW" ->//wenn NEW gedrückt wird
                                createNewPassword();//neues Passwort wird erstellt
                        case "EXIT" -> {//wenn EXIT gedrückt wird
                            System.out.println("Programm wird beendet.");
                            System.exit(0);
                        }
                    }
                }
            }
        }
        return false;
    }

    //Mitarbeiter suchen Funktion________________________________________________________________________________________________
    public static String searchEmployee(String input) throws FileNotFoundException {//searchEmployee wird aufgerufen
        //String input ist das Eingabefeld für den Namen des gesuchten Mitarbeiters
        //throws FileNotFoundException heißt es einen Fehler wenn die Datei nicht gefunden wird

        // Öffnen der JSON-Datei und Lesen des Inhalts
        FileReader fileReader = new FileReader("src/main/resources/employees.json");//lies die Datei ein
        Scanner scanner = new Scanner(fileReader);//scannt die Datei ein
        StringBuffer jsonContent = new StringBuffer();//erstellt einen StringBuffer- da es mehr Threads sind
        while (scanner.hasNextLine()) {//solange es nächste Zeile gibt
            jsonContent.append(scanner.nextLine());//speichert die Zeile in der Stringbuffer
        }//Stringbuffer ist für die Auführung von mehreren Threads
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
            System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");//frage ob  man noch weiter suchen will
            Scanner scannerEmployeeSearch = new Scanner(System.in);//Anfangen des Scanner-Objekts
        } else {
            System.out.println("Mitarbeiter nicht gefunden");//info mitarbeiter nicht gefunden
            System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");//info nochmal suchen?
            Scanner scannerEmployeeSearch = new Scanner(System.in);//Anfangen des Scanner-Objekts
        }
        return input;
    }

    //Mitarbeiter suchen nach Filter Funktion__________________________________________________________________________________________

    //suche mit filter fertig implementieren!!!

        //Mitarbeiter hinzufügen Funktion__________________________________________________________________________________________________
        public static void addEmployer () throws IOException {
            try {
                //hinzufügen Mitarbeiter erstellen Funktion
                FileReader fileReader = new FileReader("src/main/resources/employees.json");//lies die Json Datei ein
                Scanner scanner = new Scanner(fileReader);//scannt die Json Datei ein
                StringBuffer jsonContent = new StringBuffer();//erstellt einen StringBuffer zum JsonContent
                while (scanner.hasNextLine()) {//solange es nächste Zeile gibt
                    jsonContent.append(scanner.nextLine());//speichert die Zeile in der StringBuffer
                }

                scanner.close();//schließt den Scanner
                JSONArray jsonArray = new JSONArray(jsonContent.toString());//erstellt einen JSONArray aus dem StringBuffer
                Scanner userInput = new Scanner(System.in);
                System.out.println("Geben Sie den Namen des neuen Mitarbeiters ein:");
                String name = userInput.nextLine();
                System.out.println("Geben Sie das Alter des neuen Mitarbeiters ein:");
                String age = String.valueOf(Integer.parseInt(userInput.nextLine()));
                System.out.println("Geben Sie das Gehalt des neuen Mitarbeiters ein:");
                String salary = String.valueOf(Double.parseDouble(userInput.nextLine()));
                //Bei Parse wird die eingegebene Zeichenfolge in eine Ganzzahl (Integer, Double) umgewandelt.
                //Hier wird die eingegebene Zeichenfolge in eine Ganzzahl (Integer) umgewandelt.
                //String.valueOf(...):String.valueOf(...) ist eine Methode, die einen Wert (in diesem Fall eine Ganzzahl) in eine Zeichenfolge umwandelt.


                System.out.println("Mitarbeiter wurde hinzugefügt");//info Mitarbeiter wurde hinzugefügt;;
                System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");
                String scannerEmployeeSearch;//Anfangen des Scanner-Objekts

                //Schwachstelle nach Eingabe des Gehaltes lässt 3 Eingaben zu die schließlich ungültig sind
                //^^gelöst durch Entfernung der Scannermethode vom Add Block im dem Menü
                // Erstellen des JSON-Objekts für den neuen Mitarbeiter
                JSONObject newEmployer = new JSONObject();//neue JSon  Objekt wird erstellt
                newEmployer.put("ID", jsonArray.length() + 1); // Hier kannst du eine eindeutige ID generieren
                newEmployer.put("Name", name);//Name wird zugewiesen
                newEmployer.put("Alter", age);//Alter wird zugewiesen
                newEmployer.put("Gehalt", salary);//Gehalt wird zugewiesen
                jsonArray.put(newEmployer); // Hier wird der neue Mitarbeiter hinzugefügt
                saveToJsonFile(jsonArray);//Überschreibt die Änderungen ins JSon datei

            } catch (Exception e) {
                //Dies ist ein Teil einer Try-Catch-Struktur in Java, die verwendet wird, um Ausnahmen (Fehler) zu behandeln, die während der Ausführung des Codes auftreten können
                //Exception ist die Oberklasse für alle Java-Ausnahmearten, daher kann sie verschiedene Arten von Fehlern abfangen
                //Innerhalb des catch-Blocks wird diese Anweisung verwendet, um eine Fehlermeldung auf der Konsole auszugeben
                //getMessage() ist eine Methode, die auf einer Ausnahme aufgerufen werden kann, um die Fehlermeldung oder den Grund für die Ausnahme abzurufen.
                //Dies hilft dabei, Probleme zu identifizieren und zu debuggen, wenn sie auftreten.
                System.out.println("Fehler: " + e.getMessage());
            }
        }
/*
        //delete Funktion _________________________________________________________________________________________________________
        public static void deleteEmployee (String input) throws IOException {//implementierung Löschen Mitarbeiter
            FileReader fileReader = new FileReader("src/main/resources/employees.json");//lies die Json Datei ein
            Scanner scanner = new Scanner(fileReader);////scannt die Json Datei ein
            StringBuffer jsonContent = new StringBuffer();// erstellt einen StringBuffer
            while (scanner.hasNextLine()) {//solange es nächste Zeile gibt
                jsonContent.append(scanner.nextLine());//speichert die Zeile in der StringBuffer
            }
            scanner.close();
            JSONArray json = new JSONArray(jsonContent.toString());//JSON Array wird erstellt aus dem StringBuffer
            JSONObject result = null;//erstellt einen JSONObject und null ist das erste Mitarbeiter

            int indexToRemove = -1;//Mitarbeiter der gelöscht werden soll wird gesucht//indexToRemove wird -1
            for (int i = 0; i < json.length(); i++) {
                //int i = 0; solange i kleiner als die Länge des JSON Arrays ist,  wird i um 1 erhöht
                JSONObject empObject = json.getJSONObject(i);//json objekt ist i
                //erstellt einen JSONObject aus dem JSON Array
                if (empObject.has("Name")) {//wenn das JSONObject das Attribut "Name" hat
                    if (empObject.getString("Name").equals(input)) {//wenn das Attribut "Name" den Input entspricht
                        indexToRemove = i;//löscht der Mitarbeiter aus dem Array
                        break;
                    }
                }
            }
            //hier auch Schwachstelle nach löschung von Mitarbeitern, wenn nicht mehr vorhanden, dann lässt 2 Eingaben zu die schließlich ungÜltig sind
            //gelöst^^ durch Implementierung der == -1 in der Schleife unten, also wenn Mitarbeiter schon entfernt wurde kann nicht zurückgeben werden
            if (indexToRemove != -1) {
                //wenn indexToRemove nicht -1 ist, ist mitarbeiter noch da, kann gefunden werden
                json.remove(indexToRemove);
                //remove entfernt das Mitarbeiter aus dem Array
                saveToJsonFile(json);
                //saveToJsonFile wird aufgerufen Methode wird unten ausgeführt
                System.out.println("Mitarbeiter wurde gelöscht");
                System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");
                Scanner scannerEmployeeSearch = new Scanner(System.in);
                //Hauptmenü wird neu gestartet
            }
            if (indexToRemove == -1) {
                //wenn indexToRemove -1 ist, wurde mitarbeiter schon entfernt kann nicht gefunden werden
                System.out.println("Mitarbeiter nicht gefunden");
                System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");
                Scanner scannerEmployeeSearch = new Scanner(System.in);//Hauptmenü wird neu gestartet
            }
        }
*/
        /*//Json überschreiben Mitarbeiter______________________________________________________________________________________________________
        private static void saveToJsonFile (JSONArray json) throws IOException {
            //Die throws IOException-Klausel zeigt an, dass möglicherweise Ausnahmen im Zusammenhang mit Ein- und Ausgabe auftreten können.
            //implementierung von saveToJson
            //aktualisiert die Daten von Json File
            FileWriter fileWriter = new FileWriter("src/main/resources/employees.json");
            //Funktion zur überschreibung der JSON Datei
            fileWriter.write(json.toString());//löscht den String aus dem JSON Array in die JSON Datei
            fileWriter.close();//Abschluss der Überschreibung
        }
*/
        //Passwort erstellen Funktion _________________________________________________________________________________________________________
        public static void createNewPassword () throws IOException {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Bitte geben Sie ein neues Passwort ein:");
            int newPassword = userInput.nextInt();//neues Passwort wird eingegeben


            //Ein neues JSON Objekt wird erstellt
            JSONObject newAdminData = new JSONObject();// neue JSon  Objekt wird erstellt
            newAdminData.put("Benutzername", "EkrGed1");//Hier wird der Benutzername gesetzt
            newAdminData.put("Passwort", newPassword);//Hier wird das neue Passwort gesetzt
            //Hier werden die neuen Daten in die JSON Objekt gespeichert
            System.out.println("Ihre aktuelle Daten lauten: \n" + newAdminData);
            saveAdminToJsonFile(newAdminData);
            System.out.println("Ihre Daten wurden gespeichert");

            System.out.println("Bitte loggen Sie sich nun ein:");
            //logIn();
        }

        //Json Überschreiben Funktion admin.json_________________________________________________________________________________________________________
        private static void saveAdminToJsonFile (JSONObject jsonData) throws IOException {
            try (FileWriter fileWriter = new FileWriter("src/main/resources/admin.json")) {
                // JSON-Objekt in die Datei schreiben
                fileWriter.write(jsonData.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
