package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeAdder {//hier weitermachen 9.12.2023
    public JSONObject addEmployee(JSONArray jsonArray, String Input) {
       try {
           Scanner Input = new Scanner(System.in);
           System.out.println("Geben Sie den Namen des neuen Mitarbeiters ein:");
           String name = Input.nextLine();
           System.out.println("Geben Sie das Alter des neuen Mitarbeiters ein:");
           String age = String.valueOf(Integer.parseInt(Input.nextLine()));
           System.out.println("Geben Sie das Gehalt des neuen Mitarbeiters ein:");
           String salary = String.valueOf(Double.parseDouble(Input.nextLine()));

           // Erstellen des JSON-Objekts für den neuen Mitarbeiter
           JSONObject newEmployee = new JSONObject();
           newEmployee.put("ID", jsonArray.length() + 1);
           newEmployee.put("Name", name);
           newEmployee.put("Alter", age);
           newEmployee.put("Gehalt", salary);
           jsonArray.put(newEmployee);

           DefaultJsonReaderEmployeeData.saveToJsonFile(jsonArray);

           return newEmployee; // Gibt das neue JSON-Objekt zurück, um es in der Main-Klasse zu verwenden.

       } catch (IOException e) {
           System.out.println("Fehler beim Speichern der Daten: " + e.getMessage());
           e.printStackTrace(); // Gibt die Stacktrace der Ausnahme aus.
           return null;
       }
    }

}
