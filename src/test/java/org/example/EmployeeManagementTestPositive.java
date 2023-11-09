package org.example;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class EmployeeManagementTestPositive {

    @Test
    void searchingEmployee() throws Exception {

        String searchExistingName = "Max Mustermann";
        JSONObject expected = new JSONObject("{\"Name\": \"Max Mustermann\", \"Alter\": 28, \"Gehalt\": 60000.0}");

        JSONObject actual = EmployeeManagement.searchingEmployee(searchExistingName);

        assertTrue(expected.similar(actual));

    }
}
