package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeSearcherTestNegative {

    @Test
    public void searchNotExistingEmployee() throws Exception {
        //positive Test

        EmployeeSearcher employeeSearcher = new EmployeeSearcher();
        String notExistingEmployeeInput = "Maxi Mustermann";
        JSONArray actual = null;

        JSONObject expected = null;


        assertEquals(expected, employeeSearcher.searchEmployee(actual, notExistingEmployeeInput));

    }
}