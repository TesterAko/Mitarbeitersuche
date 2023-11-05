package org.example;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagementTest extends Main {

    @Test
    void searchingEmployee() throws Exception {
        try {
            EmployeeManagement.searchingEmployee("Max Mustermann");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject expected = new JSONObject("{\"Name\": \"Max Mustermann\", \"Alter\": 28, \"Gehalt\": 60000.0}");

       // assertEquals(expected, EmployeeManagement.searchingEmployee("Max Mustermann")
    }
}