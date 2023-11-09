package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

public class EmployeeSearcher {

    public JSONObject searchEmployee(JSONArray jsonArray, String input) {
        JsonReader jsonReader = new DefaultJsonReaderEmployeeData();
        JSONArray json = jsonReader.readJsonFile("src/main/resources/employees.json");
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
        return result;
    }
}
