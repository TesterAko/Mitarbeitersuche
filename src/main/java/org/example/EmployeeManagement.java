package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmployeeManagement {
    public static JSONObject searchingEmployee(String input)  {
        JsonReader jsonReader = new DefaultJsonReaderEmployeeData();
        JSONArray jsonArray = jsonReader.readJsonFile("src/main/resources/employees.json");

        EmployeeSearcher employeeSearcher = new EmployeeSearcher();
        return employeeSearcher.searchEmployee(jsonArray, input);
    }
}