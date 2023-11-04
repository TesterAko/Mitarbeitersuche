package org.example;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

class EmployeeSearcherTest extends Main {

    @Test
    public void testSearchEmployee() throws Exception {

        EmployeeSearcher employeeSearcher = new EmployeeSearcher();
        String existingEmployeeInput = "Max Mustermann";
        JSONArray jsonArray = null;
        employeeSearcher.searchEmployee(jsonArray, existingEmployeeInput);

        System.out.println("===========================================");

        String nonExistingEmployeeInput = "John Doe";
        employeeSearcher.searchEmployee(jsonArray, nonExistingEmployeeInput);
    }
}