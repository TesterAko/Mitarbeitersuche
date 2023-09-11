package org.example;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Willkommen zum Mitarbeiterverwaltungssystem");
        System.out.println("Wenn Sie nach einem Mitarbeiter suchen möchten, geben Sie JA ein");
        System.out.println("Wenn Sie den Vorgang abbrechen möchten, geben Sie EXIT ein");

        Scanner scanneremployeesearch = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            String option = scanneremployeesearch.nextLine().toUpperCase();

            switch (option) {
                case "JA":
                    searchEmployee(scanneremployeesearch.nextLine());
                    break;

                case "EXIT":
                    System.out.println("Das Programm wird beendet.");
                    isRunning = false;



                    break;

                default:
                    System.out.println("Ungültige Eingabe. Bitte geben Sie 'JA' oder 'EXIT' ein.");

            }
        }
        scanneremployeesearch.close();
    }

    public static void searchEmployee(String input) throws FileNotFoundException {
        // Öffnen der JSON-Datei und Lesen des Inhalts
        System.out.println("Wie heißt der Mitarbeiter, der gesucht werden soll?");
        FileReader fileReader = new FileReader("src/main/resources/employees.json");
        Scanner scanner = new Scanner(fileReader);
        StringBuilder jsonContent = new StringBuilder();
        while (scanner.hasNextLine()) {
            jsonContent.append(scanner.nextLine());

            JSONObject json = new JSONObject(jsonContent);

            if (jsonContent.toString().contains(input))
            System.out.println("Mitarbeiter gefunden:");
            System.out.println("Name: " + input);
            System.out.println("Details: " + jsonContent.toString());

            }
        }
    }

        /*if (jsonContent.toString().contains(scanner.nextLine())) {
            System.out.println("Mitarbeiter gefunden:");
            System.out.println("Name: " + scanner.nextLine());
            System.out.println("Details: " + jsonContent.toString());*/





     /*   JSONObject json = new JSONObject(jsonContent);

        String searchName = null;
        boolean has = json.has(searchName);
        JSONObject employees = json.getJSONObject(searchName);
        System.out.println("Mitarbeiter gefunden:");
        System.out.println("Name: " + searchName);
        System.out.println("Details: " + employees.toString());
*/



    //implementierung des Mitarbeiterverwaltungssystems mit Menü zum Suchen oder beenden
   /* public static void searchEmployee(Scanner scanneremployeesearch) throws FileNotFoundException {
        // Öffnen der JSON-Datei und Lesen des Inhalts
        FileReader fileReader = new FileReader("src/main/resources/employees.json");
        Scanner scanner = new Scanner(fileReader);
        StringBuilder jsonContent = new StringBuilder();
        while (scanner.hasNextLine()) {
            jsonContent.append(scanner.nextLine());
            scanner.close();

            Scanner scanneremployeesearch = new Scanner(System.in);
            boolean isRunning = true;
            while (isRunning) {
                String option = scanneremployeesearch.nextLine().toUpperCase();

                switch (option) {
                    case "JA":
                        searchEmployee(scanneremployeesearch);
                        break;

                    case "EXIT":
                        System.out.println("Das Programm wird beendet.");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Ungültige Eingabe. Bitte geben Sie 'JA' oder 'EXIT' ein.");


                        System.out.println("Wie heißt der Mitarbeiter, der gesucht werden soll?");
                        String input = scanneremployeesearch.nextLine();

                        if (!input.isEmpty()) {
                            JSONObject json = new JSONObject(jsonContent);

                            if (json.has(input)) {
                                JSONObject employee = json.getJSONObject(input);
                                System.out.println("Mitarbeiter gefunden:");
                                System.out.println("Name: " + input);
                                System.out.println("Details: " + employee.toString());
                            } else {
                                System.out.println("Mitarbeiter nicht gefunden.");
                            }
                        } else {
                            System.out.println("Ungültige Eingabe. Der Mitarbeitername darf nicht leer sein.");
                        }
                    }
                    scanneremployeesearch.close();

                    }
                }


            scanneremployeesearch.close();
        }
    }
}*/