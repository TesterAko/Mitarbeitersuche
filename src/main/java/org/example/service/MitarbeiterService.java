package org.example.service;

import org.example.repository.MitarbeiterRepository;
import org.json.JSONObject;

public class MitarbeiterService {

    private final MitarbeiterRepository mitarbeiterRepository;

    public MitarbeiterService(MitarbeiterRepository mitarbeiterRepository) {
        this.mitarbeiterRepository = mitarbeiterRepository;
    }

    public JSONObject findByName(String name){

        return mitarbeiterRepository.findByName(name);
    }

     public String create(String name, int alter, int gehalt){

        return null;
    }

    public boolean deleteByName(String name){
        
        return false;
    }
}
