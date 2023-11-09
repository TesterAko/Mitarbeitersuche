package org.example.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class MitarbeiterRepositoryJsonFileTest {

    @Test
    void findByNameExistingMitarbeiter(){
        JSONObject expected = new JSONObject();
        expected.put("Name", "Test");
        JSONArray given = new JSONArray();
        given.put(expected);

        MitarbeiterRepository repository = new MitarbeiterRepositoryJsonFile(given);
        
        JSONObject actual = repository.findByName("Test");
        
        Assert.assertEquals(expected, actual);
    }

    @Test
    void findByNameNotExistingMitarbeiter(){
        JSONObject expected = new JSONObject();
        expected.put("Name", "Dummy");
        JSONArray given = new JSONArray();
        given.put(expected);

        MitarbeiterRepository repository = new MitarbeiterRepositoryJsonFile(given);
        
        JSONObject actual = repository.findByName("Test");
        
        Assert.assertEquals(expected, actual);
    }

}
