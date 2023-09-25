package org.example;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

class addEmployerTest extends Main {

    private JSONArray employees;

    @BeforeEach
    public void setUp() {
        employees = new JSONArray();
    }
// Unit Test für add employerr fertig schreiben!!!
    @Test
    public void testAddEmployer() throws IOException {
        //Mock Benutzereingabe
        String input = "John Meyer\n30\n50000\n"; // Benutzereingabe mit Zeilenumbrüchen
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //aufrufen addEmployer Methode
        Main.addEmployer();


        // Überprüfen Sie, ob das employees JSONArray einen Mitarbeiter enthält
        assertEquals(1, employees.length());


        // Überprüfen Sie, ob der hinzugefügte Mitarbeiter die erwarteten Werte hat
        assertEquals("John", employees.getJSONObject(0).getString("Name"));
        assertEquals(30, employees.getJSONObject(0).getInt("Alter"));
        assertEquals(50000.0, employees.getJSONObject(0).getDouble("Gehalt"), 0.001);
    }
}