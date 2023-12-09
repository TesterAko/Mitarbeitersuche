package org.example;

import org.json.JSONArray;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DefaultJsonReaderEmployeeData implements JsonReader {

    @Override
    public JSONArray readJsonFile(String filePath) {
        JSONArray jsonArray = new JSONArray();
        try (FileReader fileReader = new FileReader("src/main/resources/employees.json");
            Scanner scanner = new Scanner(fileReader)) {
            StringBuffer jsonContent = new StringBuffer();

            while (scanner.hasNextLine()) {
                jsonContent.append(scanner.nextLine());
            }
                jsonArray = new JSONArray(jsonContent.toString());

            } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonArray;
    }

    static void saveToJsonFile(JSONArray json) throws IOException {
        //Die throws IOException-Klausel zeigt an, dass möglicherweise Ausnahmen im Zusammenhang mit Ein- und Ausgabe auftreten können.
        //implementierung von saveToJson
        //aktualisiert die Daten von Json File
        FileWriter fileWriter = new FileWriter("src/main/resources/employees.json");
        //Funktion zur überschreibung der JSON Datei
        fileWriter.write(json.toString());//löscht den String aus dem JSON Array in die JSON Datei
        fileWriter.close();//Abschluss der Überschreibung
    }
}