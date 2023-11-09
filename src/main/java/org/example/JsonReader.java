package org.example;

import org.json.JSONArray;

public interface JsonReader {
    
    JSONArray readJsonFile(String filePath);
}
