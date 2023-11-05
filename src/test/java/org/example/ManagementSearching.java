package org.example;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementSearching {

    @Test
    void searchingEmployee() {
        try {
            EmployeeManagement employeeManagement = new EmployeeManagement();
            JSONObject result = employeeManagement.searchingEmployee("Max Mustermann");

            assertNotNull(result);

        } catch (Exception e) {
            fail("Exception sollte nicht geworfen werden: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
