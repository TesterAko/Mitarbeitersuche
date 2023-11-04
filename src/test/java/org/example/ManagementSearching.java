package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementSearching  {

    @Test
    void searchingEmployee() {
        try {
            EmployeeManagement.searchingEmployee("Max Mustermann");
        } catch (Exception e) {
            fail("Exception sollte nicht geworfen werden: " + e.getMessage());
            e.printStackTrace();
        }
    }
}