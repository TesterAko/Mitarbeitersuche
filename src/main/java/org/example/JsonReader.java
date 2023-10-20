package org.example;

import org.json.JSONArray;

import java.io.FileNotFoundException;

public interface JsonReader {
    JSONArray readJsonFile(String filePath) throws FileNotFoundException;
}
