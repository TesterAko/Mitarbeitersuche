package org.example.repository;

import org.json.JSONArray;
import org.json.JSONObject;

public class MitarbeiterRepositoryJsonFile implements MitarbeiterRepository{

    private final JSONArray json;

    public MitarbeiterRepositoryJsonFile(JSONArray json){
        this.json = json;
    }

    public JSONObject findByName(String name){
        //erstellt einen JSONObject und null ist das erste Mitarbeiter
        JSONObject result = null; 

        //json array weil die Datei ein JSON Array ist
        for (int i = 0; i < json.length(); i++) {//schleife, die alle Mitarbeiter durchläuft
            //int i = 0; solange i kleiner als die Länge des JSON Arrays ist,  wird i um 1 erhöht
            JSONObject empObject = json.getJSONObject(i);//erstellt einen JSONObject aus dem JSON Array
            if (empObject.has("Name")) {//wenn das JSONObject das Attribut "Name" hat
                if (empObject.getString("Name").equals(name)) {//wenn das Attribut "Name" den Input entspricht
                    result = empObject;//speichert das JSONObject in result
                }
            }
        }
        return result;
    }
}
