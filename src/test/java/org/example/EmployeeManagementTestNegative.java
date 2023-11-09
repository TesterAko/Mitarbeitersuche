package org.example;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeManagementTestNegative {

    @Test
    void searchingEmployee() throws Exception {

        String searchNoExistingName = "Maxi Mustermann";
        JSONObject expected = null;

        JSONObject actual = EmployeeManagement.searchingEmployee(searchNoExistingName);

        Assertions.assertEquals(expected, actual);

    }
}
