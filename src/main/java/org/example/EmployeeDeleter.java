package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static org.example.DefaultJsonReaderEmployeeData.saveToJsonFile;

public class EmployeeDeleter {

    public JSONObject deleteEmployee(JSONArray jsonArray, String input) {
        JsonReader jsonReader = new DefaultJsonReaderEmployeeData();
        JSONArray json = jsonReader.readJsonFile("src/main/resources/employees.json");
        JSONObject result = null;

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
            try {
                saveToJsonFile(json);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //saveToJsonFile wird aufgerufen Methode wird unten ausgeführt
            System.out.println("Mitarbeiter wurde gelöscht");
            System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");
            //Hauptmenü wird neu gestartet
        }
        if (indexToRemove == -1) {
            //wenn indexToRemove -1 ist, wurde mitarbeiter schon entfernt kann nicht gefunden werden
            System.out.println("Mitarbeiter nicht gefunden");
            System.out.println("Wollen Sie nochmal suchen? YES, ADD, DELETE oder EXIT");
        }
        return result;
    }
}

