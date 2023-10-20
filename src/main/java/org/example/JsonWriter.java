package org.example;

import org.json.JSONArray;

import java.io.FileNotFoundException;

public interface JsonWriter {
    void writeJsonFile(JSONArray jsonArray, String fileName) throws FileNotFoundException;
}
