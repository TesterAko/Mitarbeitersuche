package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeSearcherTestPositive {

    @Test
    public void searchExistingEmployee() throws Exception {
        //positive Test
        EmployeeSearcher employeeSearcher = new EmployeeSearcher();
        String existingEmployeeInput = "Max Mustermann";
        JSONArray jsonArray = new JSONArray("[{\"Name\": \"Max Mustermann\", \"Alter\": 28, \"Gehalt\": 60000.0}]");

        JSONObject expected = new JSONObject("{\"Name\": \"Max Mustermann\", \"Alter\": 28, \"Gehalt\": 60000.0}");

        JSONObject actual = employeeSearcher.searchEmployee(jsonArray, existingEmployeeInput);

        assertEquals(expected.toString(), actual.toString());

    }
}