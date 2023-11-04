package org.example;

import org.json.JSONArray;

public class EmployeeManagement {
    public static void searchingEmployee(String input) throws Exception {

        JsonReader jsonReader = new DefaultJsonReaderEmployeeData();
        JSONArray jsonArray = jsonReader.readJsonFile("src/main/resources/employees.json");

        EmployeeSearcher employeeSearcher = new EmployeeSearcher();
        employeeSearcher.searchEmployee(jsonArray, input);


    }
//findet Max Mustermann nicht obwohl Tests erfolgreich

}