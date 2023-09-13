package org.example;
/*
package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Willkommen zum Mitarbeiterverwaltungssystem");
        System.out.println("Wenn Sie nach einem Mitarbeiter suchen möchten, geben Sie JA ein");
        System.out.println("Wenn Sie den Vorgang abbrechen möchten, geben Sie EXIT ein");

        Scanner scannerEmployeeSearch = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            String option = scannerEmployeeSearch.nextLine().toUpperCase();

            switch (option) {
                case "JA":
                    System.out.println("Wie heißt der Mitarbeiter, der gesucht werden soll?");
                    String employeeName = scannerEmployeeSearch.nextLine();
                    searchEmployee(employeeName);
                    break;
                case "EXIT":
                    System.out.println("Das Programm wird beendet.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte geben Sie 'JA' oder 'EXIT' ein.");

            }
        }
        scannerEmployeeSearch.close();
    }

    public static void searchEmployee(String input) throws FileNotFoundException {
        // Öffnen der JSON-Datei und Lesen des Inhalts

        FileReader fileReader = new FileReader("src/main/resources/employees.json");
        Scanner scanner = new Scanner(fileReader);
        StringBuilder jsonContent = new StringBuilder();
        while (scanner.hasNextLine()) {
            jsonContent.append(scanner.nextLine());
        }

        JSONArray json = new JSONArray(jsonContent.toString());
        JSONObject result = null;

        for (int i = 0; i < json.length(); i++) {
            JSONObject empObject = json.getJSONObject(i);
            if (empObject.has("Name")) {
                if (empObject.getString("Name").equals(input)) {
                    result = empObject;
                    break;
                }
            }
        }

        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No such employee");
        }
    }
}
*/
