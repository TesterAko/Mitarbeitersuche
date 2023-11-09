package org.example.controller;

import org.example.service.MitarbeiterService;
import org.json.JSONObject;

public class HttpInputController {

       private final MitarbeiterService mitarbeiterService;

    public HttpInputController(MitarbeiterService mitarbeiterService){
        this.mitarbeiterService = mitarbeiterService;
    }

    public JSONObject getMitarbeiter(String name){
        return mitarbeiterService.findByName(name);
    }
    
}
