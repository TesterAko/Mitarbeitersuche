package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmployeeManagement {
    public static JSONObject searchingEmployee(String input) throws Exception {
        JsonReader jsonReader = new DefaultJsonReaderEmployeeData();
        JSONArray jsonArray = jsonReader.readJsonFile("src/main/resources/employees.json");

        EmployeeSearcher employeeSearcher = new EmployeeSearcher();
        employeeSearcher.searchEmployee(jsonArray, input);
        return employeeSearcher.searchEmployee(jsonArray, input);
    }
}