package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class addEmployerTest extends Main {
    public JSONArray employees;

    @BeforeEach
    public void setUp() {
        employees = new JSONArray();
    }

    @Test
    public void testAddEmployer() throws IOException {
       // Benutzereingabe
        String input = "John Meyer\n30\n50000\n"; // Benutzereingabe mit Zeilenumbrüchen
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //aufrufen addEmployer Methode
        Main.addEmployer();

        // Überprüfen  ob das employees JSONArray einen Mitarbeiter enthält
        assertEquals(1, employees.length());

        // Überprüfen ob der hinzugefügte Mitarbeiter die erwarteten Werte hat
        JSONObject employee = employees.getJSONObject(1);
        Assert.assertEquals("John Meyer", employee.getString("Name"));
        Assert.assertEquals(30, employee.getInt("Alter"));
        Assert.assertEquals(50000.0, employee.getDouble("Gehalt"), 0.001);
        System.out.println(employees);
    }

}
