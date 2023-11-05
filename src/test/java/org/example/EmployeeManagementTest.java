package org.example;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class EmployeeManagementTest {

    @Test
    void searchingEmployee() throws Exception {
            try {
                String searchTerm = "Max Mustermann"; // Ändere dies entsprechend deiner Testanforderungen
                JSONObject expected = new JSONObject("{\"Name\": \"Max Mustermann\", \"Alter\": 28, \"Gehalt\": 60000.0}");

                // Hier kannst du Assertions hinzufügen, um sicherzustellen, dass die Suche wie erwartet funktioniert
            } catch (Exception e) {
                fail("Exception thrown during test: " + e.getMessage());
            }
        }
    }
