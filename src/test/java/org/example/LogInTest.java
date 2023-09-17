package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInTest extends Main {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testLogInwithValidData() throws IOException {
        String inputBenutzername = "EkrGed1\n"; // Hier den gültigen Benutzernamen eingeben
        String inputPasswort = "1992\n"; // Hier das gültige Passwort eingeben

        InputStream originalIn = System.in;

        try {
            // Mocking der Benutzereingabe
            System.setIn(new ByteArrayInputStream((inputBenutzername + inputPasswort).getBytes()));

            // Aufrufen der logIn-Methode aus der Main-Klasse
            Main.logIn();

            // Überprüfen, ob die erfolgreiche Anmeldung in der Ausgabe angezeigt wird

            assertEquals(true, outputStream.toString().contains("Sie sind eingeloggt!"));
        } finally {
            System.setIn(originalIn);
        }
    }
}

