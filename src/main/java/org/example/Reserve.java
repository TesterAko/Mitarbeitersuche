package org.example;
/*
package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {


    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanneremployeesearch = new Scanner(System.in);
        FileReader fileReader = new FileReader("src/main/resources/employees.json");
        Scanner scanner = new Scanner(fileReader);
        StringBuilder jsonContent = new StringBuilder();
        while (scanner.hasNextLine()) {
            jsonContent.append(scanner.nextLine());
        }
        scanner.close();

        //implementierung des Mitarbeiterverwaltungssystems mit Menü zum Suchen oder beenden
        System.out.println("Willkommen zum Mitarbeiterverwaltungssystem");
        System.out.println("Wenn Sie nach einem Mitarbeiter suchen möchten, geben sie JA ein");
        System.out.println("Wenn Sie den Vorgang abbrechen möchten, geben sie EXIT ein");
        Pattern operationPattern = Pattern.compile("\\s*(\\d+)\\s*\\s*(\\d+)\\s*");
        String name = scanneremployeesearch.nextLine();
        String operation = scanneremployeesearch.nextLine();

        boolean isRunning = true;//Programm läuft
        while (isRunning) {//solange Programm läuft, solange EXIT nicht eingegeben wird
            String input = scanneremployeesearch.nextLine();
            if (input.equals("EXIT")) {
                isRunning = false;
                System.out.println("Vorgang abgebrochen");
            } else if (input.equals("JA")) {
                searchEmployee(scanneremployeesearch);
            } else {
                System.out.println("Bitte geben Sie eine gültige Eingabe ein");
            }
        }








    }

    public static void searchEmployee(Scanner scanneremployeesearch) {
        System.out.println("Wie heißt der Mitarbeiter, der gesucht werden soll?");
    }

}


}*/
