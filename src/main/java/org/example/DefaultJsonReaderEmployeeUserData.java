package org.example;

import org.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DefaultJsonReaderEmployeeUserData implements JsonReader {

    @Override
    public JSONArray readJsonFile(String filePath) throws FileNotFoundException {
        JSONArray jsonArray = new JSONArray();
        try (FileReader fileReader = new FileReader("src/main/resources/users.json");
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
}