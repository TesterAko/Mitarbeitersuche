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

    public static JSONObject deleteEmployee(String input)  {
        JsonReader jsonReader = new DefaultJsonReaderEmployeeData();
        JSONArray jsonArray = jsonReader.readJsonFile("src/main/resources/employees.json");

        EmployeeDeleter employeeDeleter = new EmployeeDeleter();
        return employeeDeleter.deleteEmployee(jsonArray, input);
    }

    public static JSONObject addEmployee(String userInput) {
        JsonReader jsonReader = new DefaultJsonReaderEmployeeData();
        JSONArray jsonArray = jsonReader.readJsonFile("src/main/resources/employees.json");

        EmployeeAdder employeeAdder = new EmployeeAdder();
        return employeeAdder.addEmployee(jsonArray, userInput);
    }
}