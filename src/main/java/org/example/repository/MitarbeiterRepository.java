package org.example.repository;

import org.json.JSONObject;

public interface MitarbeiterRepository {

    JSONObject findByName(String name);
    
}
